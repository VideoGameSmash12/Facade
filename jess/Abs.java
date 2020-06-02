package jess;

import java.io.Serializable;

class Abs implements Userfunction, Serializable
{
    public String getName() {
        return "abs";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        return new Value(Math.abs(resolveValue.numericValue(context)), resolveValue.type());
    }
}
