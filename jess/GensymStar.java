package jess;

import java.io.Serializable;

class GensymStar implements Userfunction, Serializable
{
    public String getName() {
        return "gensym*";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(RU.gensym("gen"), 1);
    }
}
