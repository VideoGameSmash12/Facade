package jess;

import java.io.Serializable;

class GetFocus implements Userfunction, Serializable
{
    public String getName() {
        return "get-focus";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(context.getEngine().getFocus(), 1);
    }
}
