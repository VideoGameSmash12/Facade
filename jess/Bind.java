package jess;

import java.io.Serializable;

class Bind implements Userfunction, Serializable
{
    public String getName() {
        return "bind";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value resolveValue = valueVector.get(2).resolveValue(context);
        context.setVariable(valueVector.get(1).variableValue(context), resolveValue);
        return resolveValue;
    }
}
