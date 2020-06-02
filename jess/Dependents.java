package jess;

import java.util.ArrayList;
import java.io.Serializable;

class Dependents implements Userfunction, Serializable
{
    public String getName() {
        return "dependents";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        Fact fact;
        if (resolveValue.type() == 4) {
            fact = engine.findFactByID(resolveValue.intValue(context));
        }
        else {
            fact = resolveValue.factValue(context);
        }
        final ValueVector valueVector2 = new ValueVector();
        final ArrayList supportedFacts = engine.getSupportedFacts(fact);
        for (int i = 0; i < supportedFacts.size(); ++i) {
            valueVector2.add(new FactIDValue(supportedFacts.get(i)));
        }
        return new Value(valueVector2, 512);
    }
}
