package jess;

import java.util.HashMap;
import java.io.Serializable;

class Union implements Userfunction, Serializable
{
    public String getName() {
        return "union$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector listValue = valueVector.get(1).listValue(context);
        final ValueVector valueVector2 = new ValueVector();
        final HashMap<Value, Value> hashMap = new HashMap<Value, Value>();
        for (int i = 0; i < listValue.size(); ++i) {
            final Value resolveValue = listValue.get(i).resolveValue(context);
            if (hashMap.put(resolveValue, resolveValue) == null) {
                valueVector2.add(resolveValue);
            }
        }
        for (int j = 2; j < valueVector.size(); ++j) {
            final ValueVector listValue2 = valueVector.get(j).listValue(context);
            for (int k = 0; k < listValue2.size(); ++k) {
                final Value resolveValue2 = listValue2.get(k).resolveValue(context);
                if (hashMap.put(resolveValue2, resolveValue2) == null) {
                    valueVector2.add(resolveValue2);
                }
            }
        }
        return new Value(valueVector2, 512);
    }
}
