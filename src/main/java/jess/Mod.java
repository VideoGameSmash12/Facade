package jess;

import java.io.Serializable;

class Mod implements Userfunction, Serializable
{
    public String getName() {
        return "mod";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value((int)valueVector.get(1).numericValue(context) % (int)valueVector.get(2).numericValue(context), 4);
    }
}
