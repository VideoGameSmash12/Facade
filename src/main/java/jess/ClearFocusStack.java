package jess;

import java.io.Serializable;

class ClearFocusStack implements Userfunction, Serializable
{
    public String getName() {
        return "clear-focus-stack";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        context.getEngine().clearFocusStack();
        return Funcall.NIL;
    }
}
