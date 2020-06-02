package jess;

import java.io.Serializable;

class Log10 implements Userfunction, Serializable
{
    private static final double log10;
    
    public String getName() {
        return "log10";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(Math.log(valueVector.get(1).numericValue(context)) / Log10.log10, 32);
    }
    
    static {
        log10 = Math.log(10.0);
    }
}
