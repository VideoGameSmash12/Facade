package jess;

import java.io.Serializable;

class Watch implements Userfunction, Serializable, WatchConstants
{
    public String getName() {
        return "watch";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        final Rete engine = context.getEngine();
        if (stringValue.equals("rules")) {
            engine.watch(1);
        }
        else if (stringValue.equals("facts")) {
            engine.watch(0);
        }
        else if (stringValue.equals("activations")) {
            engine.watch(2);
        }
        else if (stringValue.equals("compilations")) {
            engine.watch(3);
        }
        else if (stringValue.equals("focus")) {
            engine.watch(4);
        }
        else {
            if (!stringValue.equals("all")) {
                throw new JessException("watch", "watch: can't watch/unwatch", stringValue);
            }
            engine.watchAll();
        }
        return Funcall.TRUE;
    }
    
    public String toString() {
        return "[The watch command]";
    }
}
