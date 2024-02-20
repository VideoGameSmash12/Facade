package jess;

import jess.factory.Factory;
import java.io.Serializable;

class SetFactory implements Userfunction, Serializable
{
    public String getName() {
        return "set-factory";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Factory factory = (Factory)valueVector.get(1).externalAddressValue(context);
        context.getEngine();
        final Factory factory2 = Rete.getFactory();
        context.getEngine();
        Rete.setFactory(factory);
        return new Value(factory2);
    }
}
