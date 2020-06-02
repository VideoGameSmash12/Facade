package jess;

import java.util.HashMap;
import java.io.Serializable;

class SubsetP implements Userfunction, Serializable
{
    public String getName() {
        return "subsetp";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector listValue = valueVector.get(1).listValue(context);
        final ValueVector listValue2 = valueVector.get(2).listValue(context);
        final HashMap<Value, Value> hashMap = new HashMap<Value, Value>();
        for (int i = 0; i < listValue2.size(); ++i) {
            final Value resolveValue = listValue2.get(i).resolveValue(context);
            hashMap.put(resolveValue, resolveValue);
        }
        for (int j = 0; j < listValue.size(); ++j) {
            if (hashMap.get(listValue.get(j).resolveValue(context)) == null) {
                return Funcall.FALSE;
            }
        }
        return Funcall.TRUE;
    }
}
