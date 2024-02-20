package jess;

import java.io.Serializable;

class FirstMF implements Userfunction, Serializable
{
    public String getName() {
        return "first$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector listValue = valueVector.get(1).listValue(context);
        final ValueVector valueVector2 = new ValueVector(1);
        if (listValue.size() > 0) {
            valueVector2.add(listValue.get(0).resolveValue(context));
        }
        return new Value(valueVector2, 512);
    }
}
