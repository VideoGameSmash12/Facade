package jess;

import java.io.Serializable;

class GtOrEq implements Userfunction, Serializable
{
    public String getName() {
        return ">=";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        for (int i = 1; i < valueVector.size() - 1; ++i) {
            if (valueVector.get(i).numericValue(context) < valueVector.get(i + 1).numericValue(context)) {
                return Funcall.FALSE;
            }
        }
        return Funcall.TRUE;
    }
}
