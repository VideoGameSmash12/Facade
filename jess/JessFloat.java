package jess;

import java.io.Serializable;

class JessFloat implements Userfunction, Serializable
{
    public String getName() {
        return "float";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(valueVector.get(1).numericValue(context), 32);
    }
}
