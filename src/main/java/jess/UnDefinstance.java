package jess;

import java.util.Iterator;
import java.io.Serializable;

class UnDefinstance implements Userfunction, Serializable
{
    public String getName() {
        return "undefinstance";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final Rete engine = context.getEngine();
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        if (resolveValue.type() == 2048) {
            final Fact undefinstance = engine.undefinstance(resolveValue.externalAddressValue(context));
            if (undefinstance == null) {
                return Funcall.NIL;
            }
            return new FactIDValue(undefinstance);
        }
        else {
            if (resolveValue.equals("*")) {
                final Iterator listDefinstances = engine.listDefinstances();
                while (listDefinstances.hasNext()) {
                    engine.undefinstance(listDefinstances.next());
                }
                return Funcall.TRUE;
            }
            throw new JessException("undefinstance", "Invalid argument", resolveValue.toString());
        }
    }
}
