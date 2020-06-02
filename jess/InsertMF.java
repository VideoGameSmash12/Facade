package jess;

import java.io.Serializable;

class InsertMF implements Userfunction, Serializable
{
    public String getName() {
        return "insert$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector listValue = valueVector.get(1).listValue(context);
        int n = (int)valueVector.get(2).numericValue(context);
        if (n < 1 || n > listValue.size() + 1) {
            throw new JessException("insert$", "index must be >= 1 and <= " + (listValue.size() + 1), ": " + n);
        }
        final ValueVector valueVector2 = new ValueVector();
        --n;
        for (int i = 0; i < n; ++i) {
            valueVector2.add(listValue.get(i).resolveValue(context));
        }
        for (int j = 3; j < valueVector.size(); ++j) {
            final Value resolveValue = valueVector.get(j).resolveValue(context);
            if (resolveValue.type() != 512) {
                valueVector2.add(resolveValue);
            }
            else {
                final ValueVector listValue2 = resolveValue.listValue(context);
                for (int k = 0; k < listValue2.size(); ++k) {
                    valueVector2.add(listValue2.get(k).resolveValue(context));
                }
            }
        }
        for (int l = n; l < listValue.size(); ++l) {
            valueVector2.add(listValue.get(l).resolveValue(context));
        }
        return new Value(valueVector2, 512);
    }
}
