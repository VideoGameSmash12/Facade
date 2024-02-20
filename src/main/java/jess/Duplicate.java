package jess;

import java.io.Serializable;

class Duplicate implements Userfunction, Serializable
{
    public String getName() {
        return "duplicate";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Fact duplicate = context.getEngine()._duplicate(valueVector, context);
        if (duplicate == null) {
            return Funcall.FALSE;
        }
        return new FactIDValue(duplicate);
    }
}
