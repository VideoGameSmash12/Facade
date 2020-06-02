package jess;

import java.io.Serializable;

class Unwatch implements Userfunction, Serializable, WatchConstants
{
    public String getName() {
        return "unwatch";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        final Rete engine = context.getEngine();
        if (stringValue.equals("rules")) {
            engine.unwatch(1);
        }
        else if (stringValue.equals("facts")) {
            engine.unwatch(0);
        }
        else if (stringValue.equals("activations")) {
            engine.unwatch(2);
        }
        else if (stringValue.equals("compilations")) {
            engine.unwatch(3);
        }
        else if (stringValue.equals("focus")) {
            engine.unwatch(4);
        }
        else {
            if (!stringValue.equals("all")) {
                throw new JessException("unwatch", "unwatch: can't unwatch", stringValue);
            }
            engine.unwatchAll();
        }
        return Funcall.TRUE;
    }
}
