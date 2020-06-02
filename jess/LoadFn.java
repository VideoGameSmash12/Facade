package jess;

import java.io.Serializable;

class LoadFn implements Userfunction, Serializable
{
    public String getName() {
        return "load-function";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        try {
            final Rete engine = context.getEngine();
            engine.addUserfunction((Userfunction)engine.findClass(stringValue).newInstance());
        }
        catch (ClassNotFoundException ex) {
            throw new JessException("load-function", "Class not found", stringValue);
        }
        catch (IllegalAccessException ex2) {
            throw new JessException("load-function", "Class is not accessible", stringValue);
        }
        catch (InstantiationException ex3) {
            throw new JessException("load-function", "Class cannot be instantiated", stringValue);
        }
        catch (ClassCastException ex4) {
            throw new JessException("load-function", "Class must inherit from UserFunction", stringValue);
        }
        return Funcall.TRUE;
    }
}
