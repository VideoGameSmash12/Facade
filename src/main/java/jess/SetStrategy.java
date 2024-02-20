package jess;

import java.io.Serializable;

class SetStrategy implements Userfunction, Serializable
{
    public String getName() {
        return "set-strategy";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        final Rete engine = context.getEngine();
        Strategy strategy;
        try {
            strategy = (Strategy)Class.forName("jess." + stringValue).newInstance();
        }
        catch (Throwable t) {
            try {
                strategy = engine.findClass(stringValue).newInstance();
            }
            catch (Throwable t2) {
                throw new JessException("set-strategy", "Strategy class not found:", stringValue);
            }
        }
        return new Value(engine.setStrategy(strategy), 1);
    }
}
