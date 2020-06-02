package jess;

import java.io.Serializable;

class Time implements Userfunction, Serializable
{
    public String getName() {
        return "time";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value((double)(System.currentTimeMillis() / 1000L), 32);
    }
}
