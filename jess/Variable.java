package jess;

import java.io.Serializable;

public class Variable extends Value implements Serializable
{
    public Value resolveValue(final Context context) throws JessException {
        if (context == null) {
            throw new JessException("Variable.resolveValue", "Null context for", this.variableValue(context));
        }
        return context.getVariable(this.variableValue(context));
    }
    
    public final Object externalAddressValue(final Context context) throws JessException {
        return this.resolveValue(context).externalAddressValue(context);
    }
    
    public final Fact factValue(final Context context) throws JessException {
        return this.resolveValue(context).factValue(context);
    }
    
    public final ValueVector listValue(final Context context) throws JessException {
        return this.resolveValue(context).listValue(context);
    }
    
    public final int intValue(final Context context) throws JessException {
        return this.resolveValue(context).intValue(context);
    }
    
    public final double floatValue(final Context context) throws JessException {
        return this.resolveValue(context).floatValue(context);
    }
    
    public final double numericValue(final Context context) throws JessException {
        return this.resolveValue(context).numericValue(context);
    }
    
    public final String atomValue(final Context context) throws JessException {
        return this.resolveValue(context).atomValue(context);
    }
    
    public final String variableValue(final Context context) throws JessException {
        return super.stringValue(context);
    }
    
    public final String stringValue(final Context context) throws JessException {
        return this.resolveValue(context).stringValue(context);
    }
    
    public Variable(final String s, final int n) throws JessException {
        super(s, n);
        if (s.indexOf("?") != -1 || s.indexOf("$") != -1) {
            throw new JessException("Variable.Variable", "Variable name cannot contain '?' or '$'", s);
        }
    }
}
