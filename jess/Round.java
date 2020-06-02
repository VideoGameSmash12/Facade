package jess;

import java.io.Serializable;

class Round implements Userfunction, Serializable
{
    public String getName() {
        return "round";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value((double)Math.round(valueVector.get(1).numericValue(context)), 4);
    }
}
