package jess;

import java.util.HashMap;
import java.io.Serializable;

class Complement implements Userfunction, Serializable
{
    public String getName() {
        return "complement$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector listValue = valueVector.get(1).listValue(context);
        final ValueVector listValue2 = valueVector.get(2).listValue(context);
        final ValueVector valueVector2 = new ValueVector();
        final HashMap<Value, Value> hashMap = new HashMap<Value, Value>();
        for (int i = 0; i < listValue.size(); ++i) {
            final Value resolveValue = listValue.get(i).resolveValue(context);
            hashMap.put(resolveValue, resolveValue);
        }
        for (int j = 0; j < listValue2.size(); ++j) {
            final Value resolveValue2 = listValue2.get(j).resolveValue(context);
            if (hashMap.get(resolveValue2) == null) {
                valueVector2.add(resolveValue2);
            }
        }
        return new Value(valueVector2, 512);
    }
}
