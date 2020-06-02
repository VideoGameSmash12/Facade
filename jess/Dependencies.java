package jess;

import java.util.ArrayList;
import java.io.Serializable;

class Dependencies implements Userfunction, Serializable
{
    public String getName() {
        return "dependencies";
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
        final ArrayList supportingTokens = engine.getSupportingTokens(fact);
        if (supportingTokens != null) {
            for (int i = 0; i < supportingTokens.size(); ++i) {
                valueVector2.add(new Value(supportingTokens.get(i)));
            }
        }
        return new Value(valueVector2, 512);
    }
}
