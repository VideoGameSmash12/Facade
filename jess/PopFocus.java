package jess;

import java.io.Serializable;

class PopFocus implements Userfunction, Serializable
{
    public String getName() {
        return "pop-focus";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(context.getEngine().popFocus(null), 1);
    }
}
