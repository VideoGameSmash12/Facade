package jess;

import java.io.Serializable;

class Engine implements Userfunction, Serializable
{
    public String getName() {
        return "engine";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(context.getEngine());
    }
}
