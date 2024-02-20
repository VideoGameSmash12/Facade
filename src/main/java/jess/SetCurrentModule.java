package jess;

import java.io.Serializable;

class SetCurrentModule implements Userfunction, Serializable
{
    public String getName() {
        return "set-current-module";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(context.getEngine().setCurrentModule(valueVector.get(1).stringValue(context)), 1);
    }
}
