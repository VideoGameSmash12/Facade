package jess;

import java.lang.reflect.Method;
import java.beans.PropertyDescriptor;
import java.beans.IntrospectionException;

class Set extends Call
{
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        try {
            final Funcall funcall = new Funcall("call", context.getEngine());
            for (int i = 1; i < valueVector.size(); ++i) {
                funcall.arg(valueVector.get(i).resolveValue(context));
            }
            final String stringValue = funcall.get(2).stringValue(context);
            final PropertyDescriptor[] propertyDescriptors = ReflectFunctions.getPropertyDescriptors(funcall.get(1).externalAddressValue(context).getClass());
            for (int j = 0; j < propertyDescriptors.length; ++j) {
                final Method writeMethod;
                if (propertyDescriptors[j].getName().equals(stringValue) && (writeMethod = propertyDescriptors[j].getWriteMethod()) != null) {
                    funcall.set(new Value(writeMethod.getName(), 2), 2);
                    return super.call(funcall, context);
                }
            }
            throw new JessException("set", "No such property:", stringValue);
        }
        catch (IntrospectionException ex) {
            throw new JessException("set", "Introspection Error:", ex);
        }
    }
    
    Set() {
        this.m_name = "set";
    }
}
