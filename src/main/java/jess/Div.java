package jess;

import java.io.Serializable;

class Div implements Userfunction, Serializable
{
    public String getName() {
        return "div";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value((int)valueVector.get(1).numericValue(context) / (int)valueVector.get(2).numericValue(context), 4);
    }
}
