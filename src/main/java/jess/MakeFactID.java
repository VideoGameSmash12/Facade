package jess;

import java.io.Serializable;

class MakeFactID implements Userfunction, Serializable
{
    public String getName() {
        return "fact-id";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final int n = (int)valueVector.get(1).numericValue(context);
        final Fact factByID = context.getEngine().findFactByID(n);
        if (factByID == null) {
            throw new JessException("factid", "No such fact-id:", n);
        }
        return new FactIDValue(factByID);
    }
}
