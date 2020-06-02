package jess;

import java.io.Serializable;

class StrIndex implements Userfunction, Serializable
{
    public String getName() {
        return "str-index";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final int index = valueVector.get(2).stringValue(context).indexOf(valueVector.get(1).stringValue(context));
        return (index == -1) ? Funcall.FALSE : new Value(index + 1, 4);
    }
}
