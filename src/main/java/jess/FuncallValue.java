package jess;

import java.io.Serializable;

public class FuncallValue extends Value implements Serializable
{
    public Value resolveValue(final Context context) throws JessException {
        if (context == null) {
            throw new JessException("FuncallValue.resolveValue", "Null context for", this.funcallValue(context).toStringWithParens());
        }
        return this.funcallValue(context).execute(context);
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
        return this.resolveValue(context).variableValue(context);
    }
    
    public final String stringValue(final Context context) throws JessException {
        return this.resolveValue(context).stringValue(context);
    }
    
    public FuncallValue(final Funcall funcall) throws JessException {
        super(funcall, 64);
    }
}
