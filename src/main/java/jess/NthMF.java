package jess;

import java.io.Serializable;

class NthMF implements Userfunction, Serializable
{
    public String getName() {
        return "nth$";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final int n = (int)valueVector.get(1).numericValue(context);
        if (n < 1) {
            return Funcall.NIL;
        }
        final ValueVector listValue = valueVector.get(2).listValue(context);
        if (n > listValue.size()) {
            return Funcall.NIL;
        }
        return listValue.get(n - 1).resolveValue(context);
    }
}
