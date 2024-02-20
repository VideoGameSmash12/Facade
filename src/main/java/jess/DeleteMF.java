package jess;

import java.io.Serializable;

class DeleteMF implements Userfunction, Serializable
{
    public String getName() {
        return "delete$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final ValueVector valueVector2 = new ValueVector();
        final ValueVector listValue = valueVector.get(1).listValue(context);
        final int n = (int)valueVector.get(2).numericValue(context);
        final int n2 = (int)valueVector.get(3).numericValue(context);
        if (n2 < n || n < 1 || n2 > listValue.size()) {
            throw new JessException("delete$", "invalid range", "(" + n + ',' + n2 + ')');
        }
        for (int i = 0; i < listValue.size(); ++i) {
            if (i < n - 1 || i > n2 - 1) {
                valueVector2.add(listValue.get(i).resolveValue(context));
            }
        }
        return new Value(valueVector2, 512);
    }
}
