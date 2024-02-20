package jess;

import java.io.Serializable;

class JessRandom implements Userfunction, Serializable
{
    public String getName() {
        return "random";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value((int)(Math.random() * 65536.0), 4);
    }
}
