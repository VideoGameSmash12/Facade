package dramaman.compiler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ASTJavaName extends BeatParseNode
{
    private static final /* synthetic */ boolean $noassert;
    
    public int lookupVariableScope(final BeatScopeMaintainer beatScopeMaintainer) {
        return beatScopeMaintainer.lookupVariableScope(this.dumpTokens(0, 1));
    }
    
    public String lookupVariableType(final BeatScopeMaintainer beatScopeMaintainer) {
        return beatScopeMaintainer.lookupVariableType(this.dumpTokens(0, 1));
    }
    
    public boolean declaredInLocalScope(final BeatScopeMaintainer beatScopeMaintainer) {
        return beatScopeMaintainer.declaredInLocalScope(this.dumpTokens(0, 1));
    }
    
    public String getName() {
        return this.dumpTokens(0, 1);
    }
    
    public String getFullName() {
        return this.dumpTokens();
    }
    
    public String lookupFieldType(final BeatScopeMaintainer beatScopeMaintainer) throws CompileException {
        String s = this.lookupVariableType(beatScopeMaintainer);
        if (this.numberOfTokens() == 1) {
            return s;
        }
        final int numberOfTokens = this.numberOfTokens();
        if (!ASTJavaName.$noassert && numberOfTokens % 2 != 1) {
            throw new AssertionError();
        }
        int i = 2;
        while (i < numberOfTokens) {
            final String dumpTokens = this.dumpTokens(i, numberOfTokens);
            try {
                s = this.getFieldType(s, dumpTokens).getName();
                i += 2;
            }
            catch (ClassNotFoundException ex) {
                throw new CompileException("Class not found in variable reference. " + ex.getMessage());
            }
            catch (NoSuchFieldException ex2) {
                throw new CompileException("No such field found in variable reference. " + ex2.getMessage());
            }
        }
        return s;
    }
    
    public boolean isVariableReference(final BeatScopeMaintainer beatScopeMaintainer) {
        return this.lookupVariableScope(beatScopeMaintainer) != -1;
    }
    
    public Method getMethod() throws CompileException {
        if (this.numberOfTokens() == 1) {
            return null;
        }
        try {
            final int numberOfTokens = this.numberOfTokens();
            if (!ASTJavaName.$noassert && numberOfTokens % 2 != 1) {
                throw new AssertionError();
            }
            Class clazz = this.getClass(this.dumpTokens(0, 1));
            String s = clazz.getName();
            for (int i = 2; i < numberOfTokens - 1; i += 2) {
                clazz = this.getFieldType(s, this.dumpTokens(i, i + 1));
                s = clazz.getName();
            }
            return clazz.getMethod(this.dumpTokens(numberOfTokens - 1, numberOfTokens), (Class[])null);
        }
        catch (ClassNotFoundException ex) {
            throw new CompileException(this.getFirstLineNumber(), "Class not found in method reference. " + ex.getMessage());
        }
        catch (NoSuchFieldException ex2) {
            throw new CompileException(this.getFirstLineNumber(), "Field not found in method reference. " + ex2.getMessage());
        }
        catch (NoSuchMethodException ex3) {
            return null;
        }
    }
    
    public String getVariableReference(final BeatScopeMaintainer beatScopeMaintainer) throws ScopeException {
        final int lookupVariableScope = this.lookupVariableScope(beatScopeMaintainer);
        final String lookupVariableType = this.lookupVariableType(beatScopeMaintainer);
        final String name = this.getName();
        String dumpTokens = "";
        if (this.numberOfTokens() > 1) {
            dumpTokens = this.dumpTokens(1, this.numberOfTokens());
        }
        final StringBuffer sb = new StringBuffer();
        if (lookupVariableScope == 0 || lookupVariableScope == 1) {
            if (lookupVariableType.equals("int")) {
                sb.append("((VariableScope.IntValue)_scope.getValue(\"" + name + "\")).i");
            }
            else if (lookupVariableType.equals("long")) {
                sb.append("((VariableScope.LongValue)_scope.getValue(\"" + name + "\")).l");
            }
            else if (lookupVariableType.equals("short")) {
                sb.append("((VariableScope.ShortValue)_scope.getValue(\"" + name + "\")).s");
            }
            else if (lookupVariableType.equals("byte")) {
                sb.append("((VariableScope.ByteValue)_scope.getValue(\"" + name + "\")).b");
            }
            else if (lookupVariableType.equals("float")) {
                sb.append("((VariableScope.FloatValue)_scope.getValue(\"" + name + "\")).f");
            }
            else if (lookupVariableType.equals("double")) {
                sb.append("((VariableScope.DoubleValue)_scope.getValue(\"" + name + "\")).d");
            }
            else if (lookupVariableType.equals("boolean")) {
                sb.append("((VariableScope.BooleanValue)_scope.getValue(\"" + name + "\")).b");
            }
            else if (!this.getName().equals(this.getFullName())) {
                sb.append("((" + lookupVariableType + ")_scope.getVariable(\"" + name + "\").value)");
            }
            else {
                sb.append("_scope.getVariable(\"" + name + "\").value");
            }
            sb.append(dumpTokens);
            return sb.toString();
        }
        throw new ScopeException(this.getFullName());
    }
    
    public String getVariableReferenceAsObject(final BeatScopeMaintainer beatScopeMaintainer) throws ScopeException {
        final String variableReference = this.getVariableReference(beatScopeMaintainer);
        final String lookupVariableType = this.lookupVariableType(beatScopeMaintainer);
        if (lookupVariableType.equals("int")) {
            return "new Integer(" + variableReference + ')';
        }
        if (lookupVariableType.equals("long")) {
            return "new Long(" + variableReference + ')';
        }
        if (lookupVariableType.equals("short")) {
            return "new Short(" + variableReference + ')';
        }
        if (lookupVariableType.equals("float")) {
            return "new Float(" + variableReference + ')';
        }
        if (lookupVariableType.equals("double")) {
            return "new Double(" + variableReference + ')';
        }
        if (lookupVariableType.equals("char")) {
            return "new Character(" + variableReference + ')';
        }
        if (lookupVariableType.equals("boolean")) {
            return "new Boolean(" + variableReference + ')';
        }
        return variableReference;
    }
    
    public String getVariableReferenceOrConstant(final BeatScopeMaintainer beatScopeMaintainer) throws CompileException {
        try {
            return this.getVariableReference(beatScopeMaintainer);
        }
        catch (ScopeException ex) {
            final String dumpTokens = this.dumpTokens();
            final Field declaredConstant = ASTBeatTopLevel.getBeatTopLevel().getDeclaredConstant(dumpTokens);
            if (declaredConstant == null) {
                throw new CompileException(this.getFirstLineNumber(), "The variable " + dumpTokens + " is not defined in any scope nor is it a constant.");
            }
            final String name = declaredConstant.getType().getName();
            Object value;
            try {
                value = declaredConstant.get(null);
            }
            catch (IllegalAccessException ex2) {
                throw new CompileException(this.getFirstLineNumber(), "Illegal access exception while processing constant " + dumpTokens);
            }
            if (!name.equals("int") && !name.equals("float") && !name.equals("char") && !name.equals("String") && !name.equals("boolean")) {
                throw new CompileException(this.getFirstLineNumber(), "Constant " + dumpTokens + " of type " + name + " has an unrecognized type.");
            }
            if (name.equals("String")) {
                return "\"" + value.toString() + '\"';
            }
            return value.toString();
        }
    }
    
    public String getVariableReferenceOrConstantAsObject(final BeatScopeMaintainer beatScopeMaintainer) throws CompileException {
        try {
            return this.getVariableReferenceAsObject(beatScopeMaintainer);
        }
        catch (ScopeException ex) {
            final String dumpTokens = this.dumpTokens();
            final Field declaredConstant = ASTBeatTopLevel.getBeatTopLevel().getDeclaredConstant(dumpTokens);
            if (declaredConstant == null) {
                throw new CompileException(this.getFirstLineNumber(), "The variable " + dumpTokens + " is not defined in any scope nor is it a constant.");
            }
            final String name = declaredConstant.getType().getName();
            Object value;
            try {
                value = declaredConstant.get(null);
            }
            catch (IllegalAccessException ex2) {
                throw new CompileException(this.getFirstLineNumber(), "Illegal access exception while processing constant " + dumpTokens);
            }
            if (name.equals("int")) {
                return "new Integer(" + value + ')';
            }
            if (name.equals("float")) {
                return "new Float(" + value + ')';
            }
            if (name.equals("char")) {
                return "new Character(" + value + ')';
            }
            if (name.equals("boolean")) {
                return "new Boolean(" + value + ')';
            }
            if (name.equals("String")) {
                return "new String(\"" + value + "\")";
            }
            throw new CompileException(this.getFirstLineNumber(), "Constant " + dumpTokens + " of type " + name + " has an unrecognized type.");
        }
    }
    
    public boolean isConstant(final BeatScopeMaintainer beatScopeMaintainer) throws CompileException {
        return !this.isVariableReference(beatScopeMaintainer) && ASTBeatTopLevel.getBeatTopLevel().getDeclaredConstant(this.dumpTokens()) != null;
    }
    
    public Object getConstantValue() throws CompileException {
        final String dumpTokens = this.dumpTokens();
        final Field declaredConstant = ASTBeatTopLevel.getBeatTopLevel().getDeclaredConstant(dumpTokens);
        if (declaredConstant == null) {
            throw new CompileException(this.getFirstLineNumber(), "The variable " + dumpTokens + " is not defined in any scope nor is it a constant.");
        }
        final String name = declaredConstant.getType().getName();
        Object value;
        try {
            value = declaredConstant.get(null);
        }
        catch (IllegalAccessException ex) {
            throw new CompileException(this.getFirstLineNumber(), "Illegal access exception while processing constant " + dumpTokens);
        }
        if (!name.equals("int") && !name.equals("float") && !name.equals("char") && !name.equals("String") && !name.equals("boolean")) {
            throw new CompileException(this.getFirstLineNumber(), "Constant " + dumpTokens + " of type " + name + " has an unrecognized type.");
        }
        return value;
    }
    
    public String getConstantType() throws CompileException {
        final String dumpTokens = this.dumpTokens();
        final Field declaredConstant = ASTBeatTopLevel.getBeatTopLevel().getDeclaredConstant(dumpTokens);
        if (declaredConstant != null) {
            return declaredConstant.getType().getName();
        }
        throw new CompileException(this.getFirstLineNumber(), "The constant " + dumpTokens + " is not defined");
    }
    
    public String getConstantString() throws CompileException {
        return this.getConstantValue().toString();
    }
    
    public void setJavaNameImage(final String image) {
        this.firstToken.image = image;
        this.firstToken.kind = 87;
        this.firstToken.next = this.lastToken.next;
        this.lastToken = this.firstToken;
    }
    
    public String getType(final BeatScopeMaintainer beatScopeMaintainer) throws CompileException {
        if (this.isVariableReference(beatScopeMaintainer)) {
            return this.lookupFieldType(beatScopeMaintainer);
        }
        if (this.isConstant(beatScopeMaintainer)) {
            return this.getConstantType();
        }
        throw new CompileException(this.getFirstLineNumber(), "The expression " + this.dumpTokens(0, 1) + " is neither a declared variable nor constant");
    }
    
    public ASTJavaName(final int n) {
        super(n);
    }
    
    public ASTJavaName(final BeatParser beatParser, final int n) {
        super(beatParser, n);
    }
    
    static {
        $noassert = (Class.forName("[Ldramaman.compiler.ASTJavaName;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
