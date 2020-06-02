package jess;

import java.lang.reflect.Field;
import java.io.Serializable;

class JessField implements Userfunction, Serializable
{
    private String m_name;
    
    public String getName() {
        return this.m_name;
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(2).stringValue(context);
        boolean b = false;
        if (valueVector.get(0).stringValue(context).equals("set-member")) {
            b = true;
        }
        Class<?> clazz = null;
        Object externalAddressValue = null;
        final Value resolveValue = valueVector.get(1).resolveValue(context);
        Label_0113: {
            if (resolveValue.type() != 2) {
                if (resolveValue.type() != 1) {
                    break Label_0113;
                }
            }
            try {
                clazz = (Class<?>)context.getEngine().findClass(resolveValue.stringValue(context));
            }
            catch (ClassNotFoundException ex) {
                throw new JessException(valueVector.get(0).stringValue(context), "No such class", resolveValue.stringValue(context));
            }
        }
        if (clazz == null) {
            externalAddressValue = resolveValue.externalAddressValue(context);
            clazz = externalAddressValue.getClass();
        }
        try {
            final Field field = clazz.getField(stringValue);
            final Class<?> type = field.getType();
            if (b) {
                final Value resolveValue2 = valueVector.get(3).resolveValue(context);
                field.set(externalAddressValue, ReflectFunctions.valueToObject(type, resolveValue2, context));
                return resolveValue2;
            }
            return ReflectFunctions.objectToValue(type, field.get(externalAddressValue));
        }
        catch (NoSuchFieldException ex2) {
            throw new JessException(valueVector.get(0).stringValue(context), "No such field " + stringValue + " in class ", clazz.getName());
        }
        catch (IllegalAccessException ex3) {
            throw new JessException(valueVector.get(0).stringValue(context), "Field is not accessible", stringValue);
        }
        catch (IllegalArgumentException ex4) {
            throw new JessException(valueVector.get(0).stringValue(context), "Invalid argument", valueVector.get(1).toString());
        }
    }
    
    JessField(final String name) {
        this.m_name = name;
    }
}
