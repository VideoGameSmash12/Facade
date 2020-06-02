package jess;

import java.io.Serializable;

class Max implements Userfunction, Serializable
{
    public String getName() {
        return "max";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        int type = resolveValue.type();
        double numericValue = resolveValue.numericValue(context);
        for (int i = 2; i < valueVector.size(); ++i) {
            final Value resolveValue2 = valueVector.get(i).resolveValue(context);
            if (resolveValue2.type() == 32) {
                type = 32;
            }
            final double numericValue2 = resolveValue2.numericValue(context);
            if (numericValue2 > numericValue) {
                numericValue = numericValue2;
            }
        }
        return new Value(numericValue, type);
    }
}
