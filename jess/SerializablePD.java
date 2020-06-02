package jess;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.io.Serializable;

class SerializablePD implements Serializable
{
    private String m_class;
    private String m_property;
    private transient Method m_get;
    private transient Method m_set;
    
    private final void reload(final Rete rete) throws JessException {
        try {
            final PropertyDescriptor[] propertyDescriptors = ReflectFunctions.getPropertyDescriptors(rete.findClass(this.m_class));
            for (int i = 0; i < propertyDescriptors.length; ++i) {
                if (propertyDescriptors[i].getName().equals(this.m_property)) {
                    this.m_get = propertyDescriptors[i].getReadMethod();
                    this.m_set = propertyDescriptors[i].getWriteMethod();
                    return;
                }
            }
        }
        catch (Exception ex) {
            throw new JessException("SerializablePD.reload", "Can't recreate property", ex);
        }
    }
    
    String getName() {
        return this.m_property;
    }
    
    Method getReadMethod(final Rete rete) throws JessException {
        if (this.m_get == null) {
            this.reload(rete);
        }
        return this.m_get;
    }
    
    Method getWriteMethod(final Rete rete) throws JessException {
        if (this.m_set == null) {
            this.reload(rete);
        }
        return this.m_set;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof SerializablePD)) {
            return false;
        }
        final SerializablePD serializablePD = (SerializablePD)o;
        boolean b = false;
        if (this.m_class.equals(serializablePD.m_class) && this.m_property.equals(serializablePD.m_property)) {
            b = true;
        }
        return b;
    }
    
    SerializablePD(final Class clazz, final PropertyDescriptor propertyDescriptor) {
        this.m_class = clazz.getName();
        this.m_property = propertyDescriptor.getName();
        this.m_get = propertyDescriptor.getReadMethod();
        this.m_set = propertyDescriptor.getWriteMethod();
    }
}
