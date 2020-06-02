package jess;

import java.io.Serializable;

class OddP implements Userfunction, Serializable
{
    public String getName() {
        return "oddp";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        boolean b = false;
        if ((int)valueVector.get(1).numericValue(context) % 2 == 0) {
            b = true;
        }
        return b ? Funcall.FALSE : Funcall.TRUE;
    }
}
