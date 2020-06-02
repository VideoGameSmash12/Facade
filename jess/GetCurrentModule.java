package jess;

import java.io.Serializable;

class GetCurrentModule implements Userfunction, Serializable
{
    public String getName() {
        return "get-current-module";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(context.getEngine().getCurrentModule(), 1);
    }
}
