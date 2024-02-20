package jess;

import java.io.Serializable;

class Exp implements Userfunction, Serializable
{
    public String getName() {
        return "exp";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(Math.pow(2.718281828459045, valueVector.get(1).numericValue(context)), 32);
    }
}
