package jess;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;

class JessNew implements Userfunction, Serializable
{
    public String getName() {
        return "new";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        try {
            final Class class1 = context.getEngine().findClass(valueVector.get(1).stringValue(context));
            final ValueVector valueVector2 = new ValueVector();
            for (int i = 2; i < valueVector.size(); ++i) {
                valueVector2.add(valueVector.get(i).resolveValue(context));
            }
            final int n = valueVector.size() - 2;
            final Object[] array = new Object[n];
            final Constructor[] constructors = class1.getConstructors();
            for (int j = 0; j < constructors.length; ++j) {
                try {
                    final Constructor constructor = constructors[j];
                    final Class[] parameterTypes = constructor.getParameterTypes();
                    if (n == parameterTypes.length) {
                        for (int k = 0; k < n; ++k) {
                            array[k] = ReflectFunctions.valueToObject(parameterTypes[k], valueVector2.get(k), context);
                        }
                        return new Value(constructor.newInstance(array));
                    }
                }
                catch (IllegalArgumentException ex6) {}
            }
            throw new NoSuchMethodException(class1.getName());
        }
        catch (InvocationTargetException ex) {
            throw new JessException("new", "Constructor threw an exception", ex.getTargetException());
        }
        catch (NoSuchMethodException ex2) {
            throw new JessException("new", "Constructor not found: " + valueVector.toStringWithParens(), ex2);
        }
        catch (ClassNotFoundException ex3) {
            throw new JessException("new", "Class not found", ex3);
        }
        catch (IllegalAccessException ex4) {
            throw new JessException("new", "Class or constructor is not accessible", ex4);
        }
        catch (InstantiationException ex5) {
            throw new JessException("new", "Class cannot be instantiated", ex5);
        }
    }
}
