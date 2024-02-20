package jess;

import java.io.Serializable;

class Retract implements Userfunction, Serializable
{
    public String getName() {
        return "retract";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Value value = valueVector.get(1);
        if (value.type() == 1 && value.stringValue(context).equals("*")) {
            context.getEngine().removeAllFacts();
        }
        else {
            final Rete engine = context.getEngine();
            for (int i = 1; i < valueVector.size(); ++i) {
                final Value resolveValue = valueVector.get(i).resolveValue(context);
                Fact factByID;
                if (resolveValue.type() == 4) {
                    factByID = engine.findFactByID(resolveValue.intValue(context));
                }
                else {
                    factByID = (Fact)resolveValue.externalAddressValue(context);
                }
                if (factByID == null) {
                    return Funcall.FALSE;
                }
                engine.retract(factByID);
            }
        }
        return Funcall.TRUE;
    }
}
