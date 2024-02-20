package dramaman.compiler;

import java.util.Vector;
import java.util.Iterator;
import jd.NestableCodeDescriptor;
import jd.CodeStringDescriptor;
import jd.FieldDescriptor;
import java.util.Collection;
import java.util.HashSet;
import jd.CodeBlockDescriptor;
import java.util.ListIterator;
import java.util.List;

public class ASTTestExpression extends BeatScopeMaintainer
{
    public static final int PRECONDITION = 0;
    public static final int WEIGHT_TEST = 1;
    public static final int PRIORITY_TEST = 2;
    private int testType;
    private int testCounter;
    private List testList;
    private ListIterator testIter;
    
    void setTestType(final int testType) {
        if (testType < 0 || testType > 2) {
            throw new CompileError("Illegal test type in call to ASTTestExpression.setTestType(int)");
        }
        this.testType = testType;
    }
    
    int getTestType() {
        if (this.testType == -1) {
            throw new CompileError("Attempt to get the test type of an ASTTestExpression node before the test type was set.");
        }
        return this.testType;
    }
    
    BeatScopeMaintainer getEnclosingBeatScope() {
        return ((BeatParseNode)this.jjtGetParent()).getEnclosingBeatScope();
    }
    
    CodeBlockDescriptor compileNextTest() throws CompileException {
        ++this.testCounter;
        if (!this.testIter.hasNext()) {
            throw new CompileError("Call to ASTTestExpression.compileNextTest() with no more tests.");
        }
        return (CodeBlockDescriptor)this.testIter.next().compileToJava();
    }
    
    public int getTestCounter() {
        return this.testCounter;
    }
    
    public boolean hasNextTest() {
        return this.testIter.hasNext();
    }
    
    HashSet getBoundVariables() {
        final HashSet set = new HashSet();
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "WMETest") {
                set.addAll(((ASTWMETest)beatParseNode).getBoundVariables());
            }
        }
        return set;
    }
    
    protected boolean allNegatedTests() {
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "WMETest") {
                if (!((ASTWMETest)beatParseNode).negated) {
                    return false;
                }
            }
            else if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "ConditionalExpression") {
                return false;
            }
        }
        return true;
    }
    
    private final HashSet preprocessVariableRefs() throws CompileException {
        final HashSet set = new HashSet();
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "WMETest") {
                set.addAll(((ASTWMETest)beatParseNode).preprocessVariableRefs());
            }
        }
        return set;
    }
    
    void initializeTestScope(final String s) throws CompileException {
        super.initializeScope(1, s, this.getNextEnclosingScope());
        this.preprocessVariableRefs();
    }

    void compileVariableCopyThrough(final CodeBlockDescriptor codeBlockDescriptor) {
        for (final FieldDescriptor fieldDescriptor : this.getDeclaredVariables()) {
            final String[] fieldNames = fieldDescriptor.getFieldNames();
            for (int i = 0; i < fieldNames.length; ++i) {
                if (this.lookupVariableScopeInParentScope(fieldNames[i]) != -1 && this.lookupVariableTypeInParentScope(fieldNames[i]).equals(fieldDescriptor.fieldType)) {
                    codeBlockDescriptor.addToBlockBody(new CodeStringDescriptor("_scope.getParentVariable(\"" + fieldNames[i] + "\").value = _scope.getVariable(\"" + fieldNames[i] + "\").value;"));
                }
            }
        }
    }

    private final CodeBlockDescriptor compileTests() throws CompileException {
        this.testCounter = 0;
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "WMETest" || BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "ConditionalExpression") {
                this.testList.add(beatParseNode);
            }
        }
        this.testIter = this.testList.listIterator();
        if (this.testIter.hasNext()) {
            return (CodeBlockDescriptor)this.testIter.next().compileToJava();
        }
        return null;
    }

    public CodeBlockDescriptor compileToJava() throws CompileException {
        final CodeBlockDescriptor compileTests = this.compileTests();
        if (!this.allNegatedTests()) {
            compileTests.addToBlockBody(new CodeStringDescriptor("return false;"));
        }
        return compileTests;
    }

    public ASTTestExpression(final int n) {
        super(n);
        this.testType = -1;
        this.testList = new Vector();
    }

    public ASTTestExpression(final BeatParser beatParser, final int n) {
        super(beatParser, n);
        this.testType = -1;
        this.testList = new Vector();
    }
}
