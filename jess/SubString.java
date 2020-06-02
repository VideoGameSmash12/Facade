package jess;

import java.io.Serializable;

class SubString implements Userfunction, Serializable
{
    public String getName() {
        return "sub-string";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final int n = (int)valueVector.get(1).numericValue(context) - 1;
        final int n2 = (int)valueVector.get(2).numericValue(context);
        final String stringValue = valueVector.get(3).stringValue(context);
        if (n < 0 || n > stringValue.length() - 1 || n2 > stringValue.length() || n2 <= 0) {
            throw new JessException("sub-string", "Indices must be between 1 and " + stringValue.length(), "");
        }
        return new Value(stringValue.substring(n, n2), 2);
    }
}
