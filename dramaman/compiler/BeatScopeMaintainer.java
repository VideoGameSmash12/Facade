package dramaman.compiler;

import java.util.Iterator;
import macro.SimpleMacroException;
import jd.CodeStringDescriptor;
import jd.NestableCodeDescriptor;
import jd.MethodDescriptor;
import java.util.List;
import jd.FieldDescriptor;
import java.util.LinkedList;
import java.util.Hashtable;
import macro.SimpleMacro;

public class BeatScopeMaintainer extends BeatParseNode
{
    private static final SimpleMacro defineVariableMacro;
    private static final SimpleMacro scopeInitializerMacro;
    public static final int noScope = -1;
    public static final int beatScope = 0;
    public static final int methodScope = 1;
    protected Hashtable variableDecl;
    protected LinkedList fieldDescriptors;
    protected BeatScopeMaintainer scopeParent;
    protected String scopeName;
    private int scopeType;
    
    public void setScopeName(final String scopeName) {
        this.scopeName = scopeName;
    }
    
    public String getScopeName() {
        return this.scopeName;
    }
    
    public void setScopeParent(final BeatScopeMaintainer scopeParent) {
        this.scopeParent = scopeParent;
    }
    
    public BeatScopeMaintainer getScopeParent() {
        return this.scopeParent;
    }
    
    public void setScopeType(final int scopeType) {
        if (scopeType == 0 || scopeType == 1) {
            this.scopeType = scopeType;
            return;
        }
        throw new CompileError("Attempt to set illegal scope type " + scopeType);
    }
    
    public BeatScopeMaintainer getEnclosingScope() {
        return this;
    }
    
    public BeatScopeMaintainer getNextEnclosingScope() {
        final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetParent();
        if (beatParseNode != null) {
            return beatParseNode.getEnclosingScope();
        }
        return null;
    }
    
    public void addVariableDeclaration(final FieldDescriptor fieldDescriptor) {
        this.fieldDescriptors.add(fieldDescriptor);
        final String fieldType = fieldDescriptor.fieldType;
        final String[] fieldNames = fieldDescriptor.getFieldNames();
        for (int i = 0; i < fieldNames.length; ++i) {
            if (this.variableDecl.get(fieldNames[i]) != null) {
                throw new CompileError("Variable " + fieldNames[i] + " multiply defined in scope " + this.scopeName);
            }
            this.variableDecl.put(fieldNames[i].intern(), fieldType.intern());
        }
    }
    
    public String lookupVariableType(final String s) {
        final String s2 = this.variableDecl.get(s);
        if (s2 != null) {
            return s2;
        }
        if (this.scopeParent != null) {
            return this.scopeParent.lookupVariableType(s);
        }
        return null;
    }
    
    public String lookupVariableTypeInParentScope(final String s) {
        if (this.scopeParent != null) {
            return this.scopeParent.lookupVariableType(s);
        }
        return null;
    }
    
    public int lookupVariableScope(final String s) {
        if (this.variableDecl.get(s) != null) {
            return this.scopeType;
        }
        if (this.scopeParent != null) {
            return this.scopeParent.lookupVariableScope(s);
        }
        return -1;
    }
    
    public int lookupVariableScopeInParentScope(final String s) {
        if (this.scopeParent != null) {
            return this.scopeParent.lookupVariableScope(s);
        }
        return -1;
    }
    
    public boolean declaredInLocalScope(final String s) {
        return this.variableDecl.get(s) != null;
    }
    
    public List getDeclaredVariables() {
        return this.fieldDescriptors;
    }
    
    public void addChildVariableDeclarations() {
        for (int i = 0; i < this.jjtGetNumChildren(); ++i) {
            final BeatParseNode beatParseNode = (BeatParseNode)this.jjtGetChild(i);
            if (BeatParserTreeConstants.jjtNodeName[beatParseNode.id] == "BeatVariableDecl") {
                this.addVariableDeclaration(((ASTBeatVariableDecl)beatParseNode).getFieldDescriptor());
            }
        }
    }
    
    void initializeScope(final int scopeType, final String scopeName, final BeatScopeMaintainer scopeParent) {
        this.setScopeType(scopeType);
        this.setScopeParent(scopeParent);
        this.setScopeName(scopeName);
        this.fieldDescriptors.clear();
        this.variableDecl.clear();
    }
    
    void defineRuntimeScope(final MethodDescriptor methodDescriptor, final String s, final String s2) throws CompileException {
        try {
            final Iterator<FieldDescriptor> iterator = this.getDeclaredVariables().iterator();
            final FieldDescriptor fieldDescriptor = new FieldDescriptor();
            fieldDescriptor.fieldType = "VariableScopeThrowsErrors";
            fieldDescriptor.addFieldName("_scope");
            fieldDescriptor.initializer = BeatScopeMaintainer.scopeInitializerMacro.expand(new String[] { s2, s });
            methodDescriptor.addToBlockBody(fieldDescriptor);
            while (iterator.hasNext()) {
                final FieldDescriptor fieldDescriptor2 = iterator.next();
                final String[] fieldNames = fieldDescriptor2.getFieldNames();
                for (int i = 0; i < fieldNames.length; ++i) {
                    if (i == fieldNames.length - 1) {
                        final String[] array = { fieldNames[i], null, fieldDescriptor2.fieldType };
                        if (fieldDescriptor2.initializer != null) {
                            if (fieldDescriptor2.fieldType.equals("int")) {
                                array[1] = "new VariableScope.IntValue(" + fieldDescriptor2.initializer + ')';
                            }
                            else if (fieldDescriptor2.fieldType.equals("long")) {
                                array[1] = "new VariableScope.LongValue(" + fieldDescriptor2.initializer + ')';
                            }
                            else if (fieldDescriptor2.fieldType.equals("short")) {
                                array[1] = "new VariableScope.ShortValue(" + fieldDescriptor2.initializer + ')';
                            }
                            else if (fieldDescriptor2.fieldType.equals("byte")) {
                                array[1] = "new VariableScope.ByteValue(" + fieldDescriptor2.initializer + ')';
                            }
                            else if (fieldDescriptor2.fieldType.equals("float")) {
                                array[1] = "new VariableScope.FloatValue(" + fieldDescriptor2.initializer + ')';
                            }
                            else if (fieldDescriptor2.fieldType.equals("double")) {
                                array[1] = "new VariableScope.DoubleValue(" + fieldDescriptor2.initializer + ')';
                            }
                            else if (fieldDescriptor2.fieldType.equals("boolean")) {
                                array[1] = "new VariableScope.BooleanValue(" + fieldDescriptor2.initializer + ')';
                            }
                            else {
                                array[1] = fieldDescriptor2.initializer;
                            }
                        }
                        else {
                            array[1] = null;
                        }
                        methodDescriptor.addToBlockBody(new CodeStringDescriptor(BeatScopeMaintainer.defineVariableMacro.expand(array)));
                    }
                    else {
                        methodDescriptor.addToBlockBody(new CodeStringDescriptor(BeatScopeMaintainer.defineVariableMacro.expand(new String[] { fieldNames[i], null, fieldDescriptor2.fieldType })));
                    }
                }
            }
        }
        catch (SimpleMacroException ex) {
            throw new CompileException(ex.getMessage());
        }
    }
    
    public String toString() {
        return BeatParserTreeConstants.jjtNodeName[this.id] + ": scopeName = " + this.scopeName + " scopeParent = " + this.scopeParent;
    }
    
    private final /* synthetic */ void this() {
        this.variableDecl = new Hashtable();
        this.fieldDescriptors = new LinkedList();
        this.scopeParent = null;
        this.scopeType = -1;
    }
    
    public BeatScopeMaintainer(final int n) {
        super(n);
        this.this();
    }
    
    public BeatScopeMaintainer(final BeatParser beatParser, final int n) {
        super(beatParser, n);
        this.this();
    }
    
    static {
        defineVariableMacro = new SimpleMacro("definemacro defineVariable(variableName, initializer, type)_scope.defineVariable(\"variableName\", initializer, \"type\");");
        scopeInitializerMacro = new SimpleMacro("definemacro scope(parentScope, scopeName)new VariableScopeThrowsErrors(parentScope, \"@scopeName_scope\")");
    }
}
