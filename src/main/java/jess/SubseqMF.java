package jess;

import java.io.Serializable;

class SubseqMF implements Userfunction, Serializable
{
    public String getName() {
        return "subseq$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector listValue = valueVector.get(1).listValue(context);
        int n = (int)valueVector.get(2).numericValue(context);
        int size = (int)valueVector.get(3).numericValue(context);
        if (n < 1) {
            n = 1;
        }
        if (size > listValue.size()) {
            size = listValue.size();
        }
        final ValueVector valueVector2 = new ValueVector();
        if (n <= listValue.size() && size <= listValue.size() && n <= size) {
            if (n == size) {
                valueVector2.add(listValue.get(n - 1).resolveValue(context));
            }
            else {
                for (int i = n; i <= size; ++i) {
                    valueVector2.add(listValue.get(i - 1).resolveValue(context));
                }
            }
        }
        return new Value(valueVector2, 512);
    }
}
