package jess;

import java.io.Serializable;

class Modify implements Userfunction, Serializable
{
    public String getName() {
        return "modify";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new FactIDValue(context.getEngine()._modify(valueVector, context));
    }
}
