package jess;

import java.io.Serializable;

class Log implements Userfunction, Serializable
{
    public String getName() {
        return "log";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(Math.log(valueVector.get(1).numericValue(context)), 32);
    }
}
