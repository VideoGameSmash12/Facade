package jess;

import java.io.Serializable;

class Divide implements Userfunction, Serializable
{
    public String getName() {
        return "/";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        double numericValue = valueVector.get(1).numericValue(context);
        for (int size = valueVector.size(), i = 2; i < size; ++i) {
            numericValue /= valueVector.get(i).numericValue(context);
        }
        return new Value(numericValue, 32);
    }
}
