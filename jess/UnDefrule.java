package jess;

import java.io.Serializable;

class UnDefrule implements Userfunction, Serializable
{
    public String getName() {
        return "undefrule";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return context.getEngine().unDefrule(valueVector.get(1).stringValue(context));
    }
}
