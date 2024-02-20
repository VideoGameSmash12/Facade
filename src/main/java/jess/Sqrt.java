package jess;

import java.io.Serializable;

class Sqrt implements Userfunction, Serializable
{
    public String getName() {
        return "sqrt";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(Math.sqrt(valueVector.get(1).numericValue(context)), 32);
    }
}
