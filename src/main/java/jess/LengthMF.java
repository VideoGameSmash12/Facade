package jess;

import java.io.Serializable;

class LengthMF implements Userfunction, Serializable
{
    public String getName() {
        return "length$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(valueVector.get(1).listValue(context).size(), 4);
    }
}
