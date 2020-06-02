package jess;

import java.io.Serializable;

class Asc implements Userfunction, Serializable
{
    public String getName() {
        return "asc";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(valueVector.get(1).stringValue(context).charAt(0), 4);
    }
}
