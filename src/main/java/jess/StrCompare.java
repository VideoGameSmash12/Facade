package jess;

import java.io.Serializable;

class StrCompare implements Userfunction, Serializable
{
    public String getName() {
        return "str-compare";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(valueVector.get(1).stringValue(context).compareTo(valueVector.get(2).stringValue(context)), 4);
    }
}
