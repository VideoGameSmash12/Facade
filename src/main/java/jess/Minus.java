package jess;

import java.io.Serializable;

class Minus implements Userfunction, Serializable
{
    public String getName() {
        return "-";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        int n = (resolveValue.type() == 32) ? 32 : 4;
        double numericValue = resolveValue.numericValue(context);
        for (int size = valueVector.size(), i = 2; i < size; ++i) {
            final Value resolveValue2 = valueVector.get(i).resolveValue(context);
            numericValue -= resolveValue2.numericValue(context);
            if (resolveValue2.type() == 32) {
                n = 32;
            }
        }
        return new Value(numericValue, n);
    }
}
