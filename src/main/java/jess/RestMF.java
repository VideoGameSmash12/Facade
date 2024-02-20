package jess;

import java.io.Serializable;

class RestMF implements Userfunction, Serializable
{
    public String getName() {
        return "rest$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector valueVector2 = new ValueVector();
        final ValueVector listValue = valueVector.get(1).listValue(context);
        for (int i = 1; i < listValue.size(); ++i) {
            valueVector2.add(listValue.get(i).resolveValue(context));
        }
        return new Value(valueVector2, 512);
    }
}
