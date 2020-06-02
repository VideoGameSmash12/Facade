package jess;

import java.io.Serializable;

public class Value implements Serializable
{
    static final int STRING_TYPES = 57355;
    static final int NUM_TYPES = 36;
    private int m_type;
    private int m_intval;
    private double m_floatval;
    private Object m_objectval;
    
    public Object externalAddressValue(final Context context) throws JessException {
        switch (this.m_type) {
            case 1:
            case 2:
            case 16:
            case 2048: {
                return this.m_objectval;
            }
            default: {
                throw this.typeError("externalAddressValue", "Not an external address");
            }
        }
    }
    
    public Funcall funcallValue(final Context context) throws JessException {
        if (this.m_type == 64) {
            return (Funcall)this.m_objectval;
        }
        throw this.typeError("funcallValue", "Not a function call");
    }
    
    public Fact factValue(final Context context) throws JessException {
        if (this.m_type == 16 || (this.m_type == 2048 && this.m_objectval instanceof Fact)) {
            return (Fact)this.m_objectval;
        }
        throw this.typeError("factValue", "Not a fact");
    }
    
    public ValueVector listValue(final Context context) throws JessException {
        if (this.m_type == 512) {
            return (ValueVector)this.m_objectval;
        }
        throw this.typeError("listValue", "Not a list");
    }
    
    public double numericValue(final Context context) throws JessException {
        final Value resolveValue = this.resolveValue(context);
        switch (resolveValue.m_type) {
            case 32: {
                return resolveValue.m_floatval;
            }
            case 4:
            case 16: {
                return resolveValue.m_intval;
            }
            case 1:
            case 2: {
                try {
                    return Double.valueOf((String)this.m_objectval);
                }
                catch (NumberFormatException ex) {}
                break;
            }
        }
        throw this.typeError("numericValue", "Not a number");
    }
    
    public int intValue(final Context context) throws JessException {
        switch (this.m_type) {
            case 32: {
                return (int)this.m_floatval;
            }
            case 4: {
                return this.m_intval;
            }
            case 1:
            case 2: {
                try {
                    return Integer.parseInt((String)this.m_objectval);
                }
                catch (NumberFormatException ex) {}
                break;
            }
        }
        throw this.typeError("intValue", "Not an integer");
    }
    
    public long longValue(final Context context) throws JessException {
        return (long)this.numericValue(context);
    }
    
    public double floatValue(final Context context) throws JessException {
        return this.numericValue(context);
    }
    
    public String atomValue(final Context context) throws JessException {
        return this.stringValue(context);
    }
    
    public String variableValue(final Context context) throws JessException {
        if (this.m_type != 8 && this.m_type != 8192) {
            throw this.typeError("variableValue", "Not a variable");
        }
        return this.stringValue(context);
    }
    
    public String stringValue(final Context context) throws JessException {
        switch (this.m_type) {
            case 1:
            case 2:
            case 8:
            case 8192:
            case 16384:
            case 32768: {
                return (String)this.m_objectval;
            }
            case 4: {
                return String.valueOf(this.m_intval);
            }
            case 32: {
                return String.valueOf(this.m_floatval);
            }
            case 2048: {
                return this.m_objectval.toString();
            }
            default: {
                throw this.typeError("stringValue", "Not a string");
            }
        }
    }
    
    private final JessException typeError(final String s, final String s2) {
        return this.typeError(s, s2, this.m_type);
    }
    
    private final JessException typeError(final String s, final String s2, final int n) {
        return new JessException("Value." + s, s2 + ": \"" + this.toString() + '\"', "(type = " + RU.getTypeName(n) + ')');
    }
    
    private final String escape(final String s) {
        if (s.indexOf(34) == -1 && s.indexOf(92) == -1) {
            return s;
        }
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '\"' || char1 == '\\') {
                sb.append('\\');
            }
            sb.append(char1);
        }
        return sb.toString();
    }
    
    public String toString() {
        switch (this.m_type) {
            case 4: {
                return String.valueOf(this.m_intval);
            }
            case 32: {
                return String.valueOf(this.m_floatval);
            }
            case 2: {
                return "\"" + this.escape((String)this.m_objectval) + '\"';
            }
            case 1:
            case 16384:
            case 32768: {
                return (String)this.m_objectval;
            }
            case 8: {
                return "?" + this.m_objectval;
            }
            case 8192: {
                return "$?" + this.m_objectval;
            }
            case 16: {
                return "<Fact-" + this.m_intval + '>';
            }
            case 64:
            case 512: {
                return this.m_objectval.toString();
            }
            case 2048: {
                return "<External-Address:" + this.m_objectval.getClass().getName() + '>';
            }
            case 0: {
                return Funcall.NIL.toString();
            }
            default: {
                return "<UNKNOWN>";
            }
        }
    }
    
    public String toStringWithParens() {
        switch (this.m_type) {
            case 64:
            case 512: {
                return ((ValueVector)this.m_objectval).toStringWithParens();
            }
            default: {
                return this.toString();
            }
        }
    }
    
    public int type() {
        return this.m_type;
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Value) {
            return this.equals((Value)o);
        }
        return o.equals(this.m_objectval);
    }
    
    public boolean equals(final Value value) {
        if (this == value) {
            return true;
        }
        if (value.m_type != this.m_type) {
            return false;
        }
        switch (this.m_type) {
            case 4:
            case 16: {
                boolean b = false;
                if (this.m_intval == value.m_intval) {
                    b = true;
                }
                return b;
            }
            case 32: {
                boolean b2 = false;
                if (this.m_floatval == value.m_floatval) {
                    b2 = true;
                }
                return b2;
            }
            default: {
                return this.m_objectval.equals(value.m_objectval);
            }
        }
    }
    
    public boolean equalsStar(final Value value) {
        if (this == value) {
            return true;
        }
        try {
            if ((this.m_type & 0x24) != 0x0 && (value.m_type & 0x24) != 0x0) {
                boolean b = false;
                if (this.numericValue(null) == value.numericValue(null)) {
                    b = true;
                }
                return b;
            }
            return this.equals(value);
        }
        catch (JessException ex) {
            return false;
        }
    }
    
    public int hashCode() {
        switch (this.m_type) {
            case 0: {
                return 0;
            }
            case 4:
            case 16: {
                return this.m_intval;
            }
            case 32: {
                return (int)this.m_floatval;
            }
            case 64:
            case 512: {
                try {
                    final ValueVector valueVector = (ValueVector)this.m_objectval;
                    int n = 0;
                    for (int i = 0; i < valueVector.size(); ++i) {
                        n += valueVector.get(i).hashCode();
                    }
                    return n;
                }
                catch (JessException ex) {
                    return 0;
                }
                break;
            }
        }
        int hashCode = 0;
        if (this.m_objectval != null) {
            hashCode = this.m_objectval.hashCode();
        }
        return hashCode;
    }
    
    public Value resolveValue(final Context context) throws JessException {
        return this;
    }
    
    public Value(final int intval, final int type) throws JessException {
        switch (this.m_type = type) {
            case 0:
            case 4: {
                this.m_intval = intval;
            }
            default: {
                throw this.typeError("Value", "Not an integral type", type);
            }
        }
    }
    
    public Value(final Value value) {
        this.m_type = value.m_type;
        this.m_intval = value.m_intval;
        this.m_floatval = value.m_floatval;
        this.m_objectval = value.m_objectval;
    }
    
    public Value(final String objectval, final int type) throws JessException {
        if (!(this instanceof Variable) && (type == 8 || type == 8192)) {
            throw new JessException("Value.Value", "Cannot use jess.Value to represent variable " + objectval + '.', "You must use class jess.Variable");
        }
        if ((type & 0xE00B) == 0x0) {
            throw this.typeError("Value", "Not a string type", type);
        }
        this.m_type = type;
        this.m_objectval = objectval;
    }
    
    public Value(final ValueVector objectval, final int type) throws JessException {
        if (!(this instanceof FuncallValue) && type == 64) {
            throw new JessException("Value.Value", "Cannot use jess.Value to represent the function call " + objectval.toStringWithParens(), "You must use class jess.FuncallValue");
        }
        if (type != 64 && type != 512) {
            throw this.typeError("Value", "Not a vector type", type);
        }
        this.m_type = type;
        this.m_objectval = objectval;
    }
    
    public Value(final double floatval, final int type) throws JessException {
        if (type != 32 && type != 4 && type != 65536) {
            throw this.typeError("Value", "Not a float type", type);
        }
        if (type == 65536 && !(this instanceof LongValue)) {
            throw this.typeError("Value", "You must use class jess.LongValue", type);
        }
        if ((this.m_type = type) == 32 || type == 65536) {
            this.m_floatval = floatval;
        }
        else {
            this.m_intval = (int)floatval;
        }
    }
    
    public Value(final boolean b) {
        this.m_type = 1;
        if (b) {
            this.m_objectval = Funcall.TRUE.m_objectval;
        }
        else {
            this.m_objectval = Funcall.FALSE.m_objectval;
        }
    }
    
    public Value(final Object objectval) {
        if (objectval != null) {
            this.m_type = 2048;
            this.m_objectval = objectval;
        }
        else {
            this.m_type = Funcall.NIL.m_type;
            this.m_objectval = Funcall.NIL.m_objectval;
        }
    }
    
    Value(Fact objectval) throws JessException {
        if (!(this instanceof FactIDValue)) {
            throw new JessException("Value.Value", "Cannot use jess.Value to represent fact-ids.", "You must use class jess.FactIDValue");
        }
        if (objectval == null) {
            objectval = Fact.getNullFact();
        }
        else {
            while (objectval.getIcon() != objectval) {
                objectval = objectval.getIcon();
            }
        }
        this.m_type = 16;
        this.m_objectval = objectval;
        this.m_intval = objectval.getFactId();
    }
    
    Value() throws JessException {
        if (!(this instanceof BindingValue)) {
            throw new JessException("Value.Value", "Cannot use jess.Value to represent bindings.", "You must use class jess.BindingValue");
        }
        this.m_type = 4096;
    }
}
