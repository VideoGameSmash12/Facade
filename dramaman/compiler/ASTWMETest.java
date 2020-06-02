package dramaman.compiler;

import java.util.ListIterator;
import macro.SimpleMacroException;
import jd.NestableCodeDescriptor;
import jd.CodeBlockDescriptor;
import jd.JavaCodeDescriptor;
import jd.CodeStringDescriptor;
import java.util.LinkedList;
import jd.FieldDescriptor;
import java.util.HashSet;
import macro.SimpleMacro;

public class ASTWMETest extends BeatParseNode implements Compileable
{
    private static final SimpleMacro wmeTestGetWMEListNoMemory;
    private static final SimpleMacro wmeTestGetWMEListMemory;
    private static final SimpleMacro wmeTestWhile;
    private static final SimpleMacro wmeTestWhileNextAssign;
    private static final SimpleMacro wmeTestWhileNextNoAssign;
    public boolean negated;
    public String wmeClassName;
    private ASTJavaName wmeAssignmentVariable;
    String memoryName;
    
    BeatScopeMaintainer getEnclosingScope() {
        return (ASTTestExpression)this.jjtGetParent();
    }
    
    void setMemoryName(final String memoryName) {
        this.memoryName = memoryName;
    }
    
    void setWMEAssignmentVariable(final ASTJavaName wmeAssignmentVariable) {
        this.wmeAssignmentVariable = wmeAssignmentVariable;
    }
    
    HashSet preprocessVariableRefs() throws CompileException {
        final HashSet<FieldDescriptor> set = new HashSet<FieldDescriptor>();
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "WMEFieldTest") {
                final FieldDescriptor preprocessVariableRef = ((ASTWMEFieldTest)beatParseNode).preprocessVariableRef();
                if (preprocessVariableRef != null) {
                    set.add(preprocessVariableRef);
                }
            }
        }
        if (this.wmeAssignmentVariable != null) {
            if (!this.wmeAssignmentVariable.declaredInLocalScope(this.getEnclosingScope())) {
                final FieldDescriptor fieldDescriptor = new FieldDescriptor();
                fieldDescriptor.addFieldName(this.wmeAssignmentVariable.getName());
                fieldDescriptor.fieldType = this.wmeClassName;
                set.add(fieldDescriptor);
                this.getEnclosingScope().addVariableDeclaration(fieldDescriptor);
            }
            else if (!this.wmeAssignmentVariable.lookupVariableType(this.getEnclosingScope()).equals(this.wmeClassName)) {
                throw new CompileException("Type error in WME assignment: " + this.prettyPrintTokens());
            }
        }
        return set;
    }
    
    HashSet getBoundVariables() {
        final HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "WMEFieldTest") {
                final String boundVariable = ((ASTWMEFieldTest)beatParseNode).getBoundVariable();
                if (boundVariable != null) {
                    set.add(boundVariable);
                }
            }
        }
        if (this.wmeAssignmentVariable != null) {
            set.add(this.wmeAssignmentVariable.getName());
        }
        return set;
    }
    
    int getWMECounter() {
        return ((ASTTestExpression)this.jjtGetParent()).getTestCounter();
    }
    
    protected LinkedList compileFieldTests() throws CompileException {
        final LinkedList<CodeStringDescriptor> list = new LinkedList<CodeStringDescriptor>();
        if (this.jjtGetNumChildren() == 0) {
            list.add(new CodeStringDescriptor("true"));
            return list;
        }
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "WMEFieldTest") {
                list.add((CodeStringDescriptor)((ASTWMEFieldTest)beatParseNode).compileToJava());
            }
        }
        return list;
    }
    
    int getTestType() {
        return ((ASTTestExpression)this.jjtGetParent()).getTestType();
    }
    
    public JavaCodeDescriptor compileToJava() throws CompileException {
        try {
            final int testCounter = ((ASTTestExpression)this.jjtGetParent()).getTestCounter();
            final CodeBlockDescriptor codeBlockDescriptor = new CodeBlockDescriptor();
            final String[] array = { Integer.toString(testCounter), this.wmeClassName };
            if (this.memoryName == null) {
                codeBlockDescriptor.addToBlockBody(new CodeStringDescriptor(ASTWMETest.wmeTestGetWMEListNoMemory.expand(array)));
            }
            else {
                codeBlockDescriptor.addToBlockBody(new CodeStringDescriptor(ASTWMETest.wmeTestGetWMEListMemory.expand(new String[] { Integer.toString(testCounter), this.wmeClassName, this.memoryName })));
            }
            final CodeBlockDescriptor codeBlockDescriptor2 = new CodeBlockDescriptor();
            codeBlockDescriptor2.setBlockHeader(ASTWMETest.wmeTestWhile.expand(new String[] { Integer.toString(testCounter) }));
            codeBlockDescriptor2.setBlockFooter("}");
            if (this.wmeAssignmentVariable != null) {
                codeBlockDescriptor2.addToBlockBody(new CodeStringDescriptor(ASTWMETest.wmeTestWhileNextAssign.expand(new String[] { Integer.toString(testCounter), this.wmeClassName, this.wmeAssignmentVariable.getVariableReference(this.getEnclosingScope()) })));
            }
            else {
                codeBlockDescriptor2.addToBlockBody(new CodeStringDescriptor(ASTWMETest.wmeTestWhileNextNoAssign.expand(array)));
            }
            final CodeBlockDescriptor codeBlockDescriptor3 = new CodeBlockDescriptor("if (", ")");
            final ListIterator listIterator = this.compileFieldTests().listIterator();
            if (listIterator.hasNext()) {
                codeBlockDescriptor3.addToBlockBody(listIterator.next());
            }
            while (listIterator.hasNext()) {
                codeBlockDescriptor3.addToBlockBody(new CodeStringDescriptor("&&"));
                codeBlockDescriptor3.addToBlockBody(listIterator.next());
            }
            final CodeBlockDescriptor codeBlockDescriptor4 = new CodeBlockDescriptor("{", "}");
            if (!this.negated) {
                if (((ASTTestExpression)this.jjtGetParent()).hasNextTest()) {
                    codeBlockDescriptor4.addToBlockBody(((ASTTestExpression)this.jjtGetParent()).compileNextTest());
                }
                else {
                    ((ASTTestExpression)this.jjtGetParent()).compileVariableCopyThrough(codeBlockDescriptor4);
                    codeBlockDescriptor4.addToBlockBody(new CodeStringDescriptor("return true;"));
                }
            }
            else {
                codeBlockDescriptor4.addToBlockBody(new CodeStringDescriptor("return false;"));
            }
            codeBlockDescriptor2.addToBlockBody(codeBlockDescriptor3);
            codeBlockDescriptor2.addToBlockBody(codeBlockDescriptor4);
            codeBlockDescriptor.addToBlockBody(codeBlockDescriptor2);
            if (this.negated) {
                if (((ASTTestExpression)this.jjtGetParent()).hasNextTest()) {
                    codeBlockDescriptor.addToBlockBody(((ASTTestExpression)this.jjtGetParent()).compileNextTest());
                }
                else {
                    ((ASTTestExpression)this.jjtGetParent()).compileVariableCopyThrough(codeBlockDescriptor);
                    codeBlockDescriptor.addToBlockBody(new CodeStringDescriptor("return true;"));
                }
            }
            return codeBlockDescriptor;
        }
        catch (SimpleMacroException ex) {
            throw new CompileError("Error in ASTWMETest.compileToJava()", ex);
        }
    }
    
    private final /* synthetic */ void this() {
        this.wmeAssignmentVariable = null;
        this.memoryName = null;
    }
    
    public ASTWMETest(final int n) {
        super(n);
        this.this();
    }
    
    public ASTWMETest(final BeatParser beatParser, final int n) {
        super(beatParser, n);
        this.this();
    }
    
    static {
        wmeTestGetWMEListNoMemory = new SimpleMacro(MacroDefinitions.wmeTestGetWMEListNoMemoryMacroString);
        wmeTestGetWMEListMemory = new SimpleMacro(MacroDefinitions.wmeTestGetWMEListMemoryMacroString);
        wmeTestWhile = new SimpleMacro("definemacro wmeTestWhile(wmeCount)while(wmeIter@wmeCount.hasNext()) {");
        wmeTestWhileNextAssign = new SimpleMacro(MacroDefinitions.wmeTestWhileNextAssignMacroString);
        wmeTestWhileNextNoAssign = new SimpleMacro("definemacro wmeTestWhileNext(wmeCount, wmeClassName)wmeClassName wme__@wmeCount = (wmeClassName)wmeIter@wmeCount.next();");
    }
}
