package jess;

import java.io.Serializable;

class Times implements Userfunction, Serializable
{
    public String getName() {
        return "*";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        double n = 1.0;
        int n2 = 4;
        for (int size = valueVector.size(), i = 1; i < size; ++i) {
            final Value resolveValue = valueVector.get(i).resolveValue(context);
            n *= resolveValue.numericValue(context);
            if (resolveValue.type() == 32) {
                n2 = 32;
            }
        }
        return new Value(n, n2);
    }
}
