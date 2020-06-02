package jess;

import java.io.Serializable;

class Defclass implements Userfunction, Serializable
{
    public String getName() {
        return "defclass";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        final String stringValue2 = valueVector.get(2).stringValue(context);
        final String s = (valueVector.size() > 4) ? valueVector.get(4).stringValue(context) : null;
        if (s != null && !valueVector.get(3).equals("extends")) {
            throw new JessException("defclass", "expected 'extends <classname>'", valueVector.get(3).toString());
        }
        return context.getEngine().defclass(stringValue, stringValue2, s);
    }
}
