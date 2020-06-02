package jess;

import java.io.Serializable;

class Assert implements Userfunction, Serializable
{
    public String getName() {
        return "assert";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        Fact assertFact = null;
        final Rete engine = context.getEngine();
        for (int i = 1; i < valueVector.size(); ++i) {
            assertFact = engine.assertFact(valueVector.get(i).factValue(context).expand(context), context);
        }
        if (assertFact != null) {
            return new FactIDValue(assertFact);
        }
        return Funcall.FALSE;
    }
}
