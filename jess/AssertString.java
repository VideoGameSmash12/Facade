package jess;

import java.io.Serializable;

class AssertString implements Userfunction, Serializable
{
    public String getName() {
        return "assert-string";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Fact assertString = context.getEngine().assertString(valueVector.get(1).stringValue(context), context);
        if (assertString != null) {
            return new FactIDValue(assertString);
        }
        return Funcall.FALSE;
    }
}
