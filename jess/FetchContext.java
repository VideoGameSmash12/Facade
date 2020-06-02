package jess;

import java.io.Serializable;

class FetchContext implements Userfunction, Serializable
{
    public String getName() {
        return "context";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(context);
    }
}
