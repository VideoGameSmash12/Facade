package jess;

import java.io.Serializable;

class Expt implements Userfunction, Serializable
{
    public String getName() {
        return "**";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(Math.pow(valueVector.get(1).numericValue(context), valueVector.get(2).numericValue(context)), 32);
    }
}
