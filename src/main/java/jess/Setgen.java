package jess;

import java.io.Serializable;

class Setgen implements Userfunction, Serializable
{
    public String getName() {
        return "setgen";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final int intValue = valueVector.get(1).intValue(context);
        RU.s_gensymIdx = ((intValue > RU.s_gensymIdx) ? intValue : (RU.s_gensymIdx + 1));
        return Funcall.TRUE;
    }
}
