package jess;

import java.io.Serializable;

class JessInteger implements Userfunction, Serializable
{
    public String getName() {
        return "integer";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value((int)valueVector.get(1).numericValue(context), 4);
    }
}
