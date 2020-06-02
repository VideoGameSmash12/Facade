package jess;

import java.io.Serializable;

class GetStrategy implements Userfunction, Serializable
{
    public String getName() {
        return "get-strategy";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        return new Value(context.getEngine().getStrategy().getName(), 1);
    }
}
