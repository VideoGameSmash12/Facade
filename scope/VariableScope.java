package scope;

import java.util.Hashtable;

public class VariableScope
{
    private Hashtable variables;
    private VariableScope parent;
    private String scopeName;
    
    public void defineVariable(final String s, Object o, final String s2) throws MultipleDefinitionException {
        if (this.variables.containsKey(s)) {
            throw new MultipleDefinitionException(s, this.scopeName);
        }
        if (o == null) {
            if (s2.equals("int")) {
                o = new IntValue();
            }
            else if (s2.equals("long")) {
                o = new LongValue();
            }
            else if (s2.equals("short")) {
                o = new ShortValue();
            }
            else if (s2.equals("byte")) {
                o = new ByteValue();
            }
            else if (s2.equals("float")) {
                o = new FloatValue();
            }
            else if (s2.equals("double")) {
                o = new DoubleValue();
            }
            else if (s2.equals("boolean")) {
                o = new BooleanValue();
            }
        }
        this.variables.put(s, new Variable(o, s2));
    }
    
    public boolean variableDefined(final String s) {
        return this.variables.containsKey(s) || (this.parent != null && this.parent.variableDefined(s));
    }
    
    public String getType(final String s) throws UndefinedVariableException {
        if (this.variables.containsKey(s)) {
            return this.variables.get(s).typeName;
        }
        if (this.parent != null) {
            return this.parent.getType(s);
        }
        throw new UndefinedVariableException(s, this.scopeName);
    }
    
    private final boolean isPrimitiveNumberType(final String s) {
        return s.equals("int") || s.equals("long") || s.equals("short") || s.equals("byte") || s.equals("float") || s.equals("double");
    }
    
    private final boolean checkTypeConsistency(final Variable variable) {
        if (!this.isPrimitiveNumberType(variable.typeName) && variable.value == null) {
            return true;
        }
        final String name = variable.value.getClass().getName();
        if (variable.typeName.equals("int")) {
            if (!name.equals("scope.VariableScope$IntValue")) {
                return false;
            }
        }
        else if (variable.typeName.equals("long")) {
            if (!name.equals("scope.VariableScope$LongValue")) {
                return false;
            }
        }
        else if (variable.typeName.equals("short")) {
            if (!name.equals("scope.VariableScope$ShortValue")) {
                return false;
            }
        }
        else if (variable.typeName.equals("byte")) {
            if (!name.equals("scope.VariableScope$ByteValue")) {
                return false;
            }
        }
        else if (variable.typeName.equals("float")) {
            if (!name.equals("scope.VariableScope$FloatValue")) {
                return false;
            }
        }
        else if (variable.typeName.equals("double")) {
            if (!name.equals("scope.VariableScope$DoubleValue")) {
                return false;
            }
        }
        else if (variable.typeName.equals("boolean")) {
            if (!name.equals("scope.VariableScope$BooleanValue")) {
                return false;
            }
        }
        else if (!name.equals(variable.typeName) && !name.substring(name.lastIndexOf(46) + 1).equals(variable.typeName)) {
            return false;
        }
        return true;
    }
    
    public Object getValue(final String s) throws UndefinedVariableException, TypeException {
        if (this.variables.containsKey(s)) {
            final Variable variable = this.variables.get(s);
            if (!this.checkTypeConsistency(variable)) {
                throw new TypeException(s, this.scopeName, variable.typeName, variable.value.getClass().getName());
            }
            return variable.value;
        }
        else {
            if (this.parent != null) {
                return this.parent.getValue(s);
            }
            throw new UndefinedVariableException(s, this.scopeName);
        }
    }
    
    public Object setValue(final String s, final Object value) throws UndefinedVariableException, TypeException {
        final String type = this.getType(s);
        final String substring = type.substring(type.lastIndexOf(46) + 1);
        final String name = value.getClass().getName();
        final String substring2 = name.substring(name.lastIndexOf(46) + 1);
        if (type.equals(name) || substring.equals(substring2)) {
            return this.variables.get(s).value = value;
        }
        throw new TypeException(s, this.scopeName, substring, substring2);
    }
    
    public Variable getVariable(final String s) throws UndefinedVariableException, TypeException {
        if (this.variables.containsKey(s)) {
            final Variable variable = this.variables.get(s);
            if (!this.checkTypeConsistency(variable)) {
                throw new TypeException(s, this.scopeName, variable.typeName, variable.value.getClass().getName());
            }
            return variable;
        }
        else {
            if (this.parent != null) {
                return this.parent.getVariable(s);
            }
            throw new UndefinedVariableException(s, this.scopeName);
        }
    }
    
    public Variable getParentVariable(final String s) throws UndefinedVariableException, TypeException {
        if (this.parent != null) {
            return this.parent.getVariable(s);
        }
        throw new UndefinedVariableException(s, this.scopeName);
    }
    
    private final /* synthetic */ void this() {
        this.variables = new Hashtable();
    }
    
    public VariableScope(final VariableScope parent, final String scopeName) {
        this.this();
        this.parent = parent;
        this.scopeName = scopeName;
    }
    
    public static class Variable
    {
        public Object value;
        String typeName;
        
        public String toString() {
            return "Variable(" + this.value + ' ' + this.typeName + ')';
        }
        
        Variable(final Object value, final String typeName) {
            this.value = value;
            this.typeName = typeName;
        }
    }
    
    public static class IntValue
    {
        public int i;
        
        public String toString() {
            return Integer.toString(this.i);
        }
        
        public IntValue(final int i) {
            this.i = i;
        }
        
        public IntValue() {
        }
    }
    
    public static class LongValue
    {
        public long l;
        
        public String toString() {
            return Long.toString(this.l);
        }
        
        public LongValue(final long l) {
            this.l = l;
        }
        
        public LongValue() {
        }
    }
    
    public static class ShortValue
    {
        public short s;
        
        public String toString() {
            return Short.toString(this.s);
        }
        
        public ShortValue(final short s) {
            this.s = s;
        }
        
        public ShortValue() {
        }
    }
    
    public static class ByteValue
    {
        public byte b;
        
        public String toString() {
            return Byte.toString(this.b);
        }
        
        public ByteValue(final byte b) {
            this.b = b;
        }
        
        public ByteValue() {
        }
    }
    
    public static class FloatValue
    {
        public float f;
        
        public String toString() {
            return Float.toString(this.f);
        }
        
        public FloatValue(final float f) {
            this.f = f;
        }
        
        public FloatValue() {
        }
    }
    
    public static class DoubleValue
    {
        public double d;
        
        public String toString() {
            return Double.toString(this.d);
        }
        
        public DoubleValue(final double d) {
            this.d = d;
        }
        
        public DoubleValue() {
        }
    }
    
    public static class BooleanValue
    {
        public boolean b;
        
        public String toString() {
            return new Boolean(this.b).toString();
        }
        
        public BooleanValue(final boolean b) {
            this.b = b;
        }
        
        public BooleanValue() {
        }
    }
}
