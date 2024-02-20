package jess;

import java.io.Serializable;

class LoadPkg implements Userfunction, Serializable
{
    public String getName() {
        return "load-package";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        try {
            final Rete engine = context.getEngine();
            engine.addUserpackage((Userpackage)engine.findClass(stringValue).newInstance());
        }
        catch (ClassNotFoundException ex) {
            throw new JessException("load-package", "Class not found", stringValue);
        }
        catch (IllegalAccessException ex2) {
            throw new JessException("load-package", "Class is not accessible", stringValue);
        }
        catch (InstantiationException ex3) {
            throw new JessException("load-package", "Class cannot be instantiated", stringValue);
        }
        catch (ClassCastException ex4) {
            throw new JessException("load-package", "Class must inherit from UserPackage", stringValue);
        }
        return Funcall.TRUE;
    }
}
