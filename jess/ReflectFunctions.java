package jess;

import java.beans.IntrospectionException;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Hashtable;
import java.io.Serializable;

class ReflectFunctions implements IntrinsicPackage, Serializable
{
    private static Hashtable s_descriptors;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Object;
    static /* synthetic */ Class class$java$lang$Short;
    static /* synthetic */ Class class$java$lang$Character;
    static /* synthetic */ Class class$java$lang$Byte;
    static /* synthetic */ Class class$java$lang$Double;
    static /* synthetic */ Class class$java$lang$Float;
    static /* synthetic */ Class class$java$lang$Void;
    static /* synthetic */ Class class$java$lang$Boolean;
    
    private final void addFunction(final Userfunction userfunction, final HashMap hashMap) {
        hashMap.put(userfunction.getName(), userfunction);
    }
    
    public void add(final HashMap hashMap) {
        this.addFunction(new Engine(), hashMap);
        this.addFunction(new FetchContext(), hashMap);
        this.addFunction(new JessImport(), hashMap);
        this.addFunction(new JessNew(), hashMap);
        this.addFunction(new Call(), hashMap);
        this.addFunction(new JessField("set-member"), hashMap);
        this.addFunction(new JessField("get-member"), hashMap);
        this.addFunction(new Set(), hashMap);
        this.addFunction(new Get(), hashMap);
        this.addFunction(new Defclass(), hashMap);
        this.addFunction(new UnDefinstance(), hashMap);
        this.addFunction(new Definstance(), hashMap);
        this.addFunction(new InstanceOf(), hashMap);
    }
    
    static Object valueToObject(final Class clazz, final Value value, final Context context) throws IllegalArgumentException, JessException {
        return valueToObject(clazz, value, context, true);
    }
    
    static Object valueToObject(final Class clazz, Value resolveValue, final Context context, final boolean b) throws IllegalArgumentException, JessException {
        resolveValue = resolveValue.resolveValue(context);
        switch (resolveValue.type()) {
            case 16:
            case 2048: {
                if (clazz.isInstance(resolveValue.externalAddressValue(context))) {
                    return resolveValue.externalAddressValue(context);
                }
                throw new IllegalArgumentException();
            }
            case 1:
            case 2: {
                final String stringValue = resolveValue.stringValue(context);
                if (!clazz.isPrimitive() && stringValue.equals(Funcall.NIL.stringValue(context))) {
                    return null;
                }
                Class class$java$lang$String;
                if ((class$java$lang$String = ReflectFunctions.class$java$lang$String) == null) {
                    class$java$lang$String = (ReflectFunctions.class$java$lang$String = class$("[Ljava.lang.String;", false));
                }
                if (clazz.isAssignableFrom(class$java$lang$String)) {
                    return stringValue;
                }
                if (clazz == Character.TYPE) {
                    if (stringValue.length() == 1) {
                        return new Character(stringValue.charAt(0));
                    }
                    throw new IllegalArgumentException();
                }
                else {
                    if (clazz != Boolean.TYPE) {
                        throw new IllegalArgumentException();
                    }
                    if (stringValue.equals(Funcall.TRUE.stringValue(context))) {
                        return Boolean.TRUE;
                    }
                    if (stringValue.equals(Funcall.FALSE.stringValue(context))) {
                        return Boolean.FALSE;
                    }
                    throw new IllegalArgumentException();
                }
                break;
            }
            case 4: {
                if (clazz != Long.TYPE) {
                    Class class$java$lang$Long;
                    if ((class$java$lang$Long = ReflectFunctions.class$java$lang$Long) == null) {
                        class$java$lang$Long = (ReflectFunctions.class$java$lang$Long = class$("[Ljava.lang.Long;", false));
                    }
                    if (clazz != class$java$lang$Long) {
                        final int intValue = resolveValue.intValue(context);
                        if (clazz != Integer.TYPE) {
                            Class class$java$lang$Integer;
                            if ((class$java$lang$Integer = ReflectFunctions.class$java$lang$Integer) == null) {
                                class$java$lang$Integer = (ReflectFunctions.class$java$lang$Integer = class$("[Ljava.lang.Integer;", false));
                            }
                            if (clazz != class$java$lang$Integer) {
                                Class class$java$lang$Object;
                                if ((class$java$lang$Object = ReflectFunctions.class$java$lang$Object) == null) {
                                    class$java$lang$Object = (ReflectFunctions.class$java$lang$Object = class$("[Ljava.lang.Object;", false));
                                }
                                if (clazz != class$java$lang$Object) {
                                    if (clazz != Short.TYPE) {
                                        Class class$java$lang$Short;
                                        if ((class$java$lang$Short = ReflectFunctions.class$java$lang$Short) == null) {
                                            class$java$lang$Short = (ReflectFunctions.class$java$lang$Short = class$("[Ljava.lang.Short;", false));
                                        }
                                        if (clazz != class$java$lang$Short) {
                                            if (clazz != Character.TYPE) {
                                                Class class$java$lang$Character;
                                                if ((class$java$lang$Character = ReflectFunctions.class$java$lang$Character) == null) {
                                                    class$java$lang$Character = (ReflectFunctions.class$java$lang$Character = class$("[Ljava.lang.Character;", false));
                                                }
                                                if (clazz != class$java$lang$Character) {
                                                    if (clazz != Byte.TYPE) {
                                                        Class class$java$lang$Byte;
                                                        if ((class$java$lang$Byte = ReflectFunctions.class$java$lang$Byte) == null) {
                                                            class$java$lang$Byte = (ReflectFunctions.class$java$lang$Byte = class$("[Ljava.lang.Byte;", false));
                                                        }
                                                        if (clazz != class$java$lang$Byte) {
                                                            if (!b) {
                                                                Class class$java$lang$String2;
                                                                if ((class$java$lang$String2 = ReflectFunctions.class$java$lang$String) == null) {
                                                                    class$java$lang$String2 = (ReflectFunctions.class$java$lang$String = class$("[Ljava.lang.String;", false));
                                                                }
                                                                if (clazz == class$java$lang$String2) {
                                                                    return String.valueOf(intValue);
                                                                }
                                                            }
                                                            throw new IllegalArgumentException();
                                                        }
                                                    }
                                                    return new Byte((byte)intValue);
                                                }
                                            }
                                            return new Character((char)intValue);
                                        }
                                    }
                                    return new Short((short)intValue);
                                }
                            }
                        }
                        return new Integer(intValue);
                    }
                }
                return new Long(resolveValue.longValue(context));
            }
            case 65536: {
                if (clazz != Long.TYPE) {
                    Class class$java$lang$Long2;
                    if ((class$java$lang$Long2 = ReflectFunctions.class$java$lang$Long) == null) {
                        class$java$lang$Long2 = (ReflectFunctions.class$java$lang$Long = class$("[Ljava.lang.Long;", false));
                    }
                    if (clazz != class$java$lang$Long2) {
                        Class class$java$lang$Object2;
                        if ((class$java$lang$Object2 = ReflectFunctions.class$java$lang$Object) == null) {
                            class$java$lang$Object2 = (ReflectFunctions.class$java$lang$Object = class$("[Ljava.lang.Object;", false));
                        }
                        if (clazz != class$java$lang$Object2) {
                            final int intValue2 = resolveValue.intValue(context);
                            if (clazz != Integer.TYPE) {
                                Class class$java$lang$Integer2;
                                if ((class$java$lang$Integer2 = ReflectFunctions.class$java$lang$Integer) == null) {
                                    class$java$lang$Integer2 = (ReflectFunctions.class$java$lang$Integer = class$("[Ljava.lang.Integer;", false));
                                }
                                if (clazz != class$java$lang$Integer2) {
                                    if (clazz != Short.TYPE) {
                                        Class class$java$lang$Short2;
                                        if ((class$java$lang$Short2 = ReflectFunctions.class$java$lang$Short) == null) {
                                            class$java$lang$Short2 = (ReflectFunctions.class$java$lang$Short = class$("[Ljava.lang.Short;", false));
                                        }
                                        if (clazz != class$java$lang$Short2) {
                                            if (clazz != Character.TYPE) {
                                                Class class$java$lang$Character2;
                                                if ((class$java$lang$Character2 = ReflectFunctions.class$java$lang$Character) == null) {
                                                    class$java$lang$Character2 = (ReflectFunctions.class$java$lang$Character = class$("[Ljava.lang.Character;", false));
                                                }
                                                if (clazz != class$java$lang$Character2) {
                                                    if (clazz != Byte.TYPE) {
                                                        Class class$java$lang$Byte2;
                                                        if ((class$java$lang$Byte2 = ReflectFunctions.class$java$lang$Byte) == null) {
                                                            class$java$lang$Byte2 = (ReflectFunctions.class$java$lang$Byte = class$("[Ljava.lang.Byte;", false));
                                                        }
                                                        if (clazz != class$java$lang$Byte2) {
                                                            if (!b) {
                                                                Class class$java$lang$String3;
                                                                if ((class$java$lang$String3 = ReflectFunctions.class$java$lang$String) == null) {
                                                                    class$java$lang$String3 = (ReflectFunctions.class$java$lang$String = class$("[Ljava.lang.String;", false));
                                                                }
                                                                if (clazz == class$java$lang$String3) {
                                                                    return String.valueOf(intValue2);
                                                                }
                                                            }
                                                            throw new IllegalArgumentException();
                                                        }
                                                    }
                                                    return new Byte((byte)intValue2);
                                                }
                                            }
                                            return new Character((char)intValue2);
                                        }
                                    }
                                    return new Short((short)intValue2);
                                }
                            }
                            return new Integer(intValue2);
                        }
                    }
                }
                return new Long(resolveValue.longValue(context));
            }
            case 32: {
                final double floatValue = resolveValue.floatValue(context);
                if (clazz != Double.TYPE) {
                    Class class$java$lang$Double;
                    if ((class$java$lang$Double = ReflectFunctions.class$java$lang$Double) == null) {
                        class$java$lang$Double = (ReflectFunctions.class$java$lang$Double = class$("[Ljava.lang.Double;", false));
                    }
                    if (clazz != class$java$lang$Double) {
                        Class class$java$lang$Object3;
                        if ((class$java$lang$Object3 = ReflectFunctions.class$java$lang$Object) == null) {
                            class$java$lang$Object3 = (ReflectFunctions.class$java$lang$Object = class$("[Ljava.lang.Object;", false));
                        }
                        if (clazz != class$java$lang$Object3) {
                            if (clazz != Float.TYPE) {
                                Class class$java$lang$Float;
                                if ((class$java$lang$Float = ReflectFunctions.class$java$lang$Float) == null) {
                                    class$java$lang$Float = (ReflectFunctions.class$java$lang$Float = class$("[Ljava.lang.Float;", false));
                                }
                                if (clazz != class$java$lang$Float) {
                                    if (!b) {
                                        Class class$java$lang$String4;
                                        if ((class$java$lang$String4 = ReflectFunctions.class$java$lang$String) == null) {
                                            class$java$lang$String4 = (ReflectFunctions.class$java$lang$String = class$("[Ljava.lang.String;", false));
                                        }
                                        if (clazz == class$java$lang$String4) {
                                            return String.valueOf(floatValue);
                                        }
                                    }
                                    throw new IllegalArgumentException();
                                }
                            }
                            return new Float((float)floatValue);
                        }
                    }
                }
                return new Double(floatValue);
            }
            case 512: {
                if (clazz.isArray()) {
                    final Class componentType = clazz.getComponentType();
                    final ValueVector listValue = resolveValue.listValue(context);
                    final Object instance = Array.newInstance(componentType, listValue.size());
                    for (int i = 0; i < listValue.size(); ++i) {
                        Array.set(instance, i, valueToObject(componentType, listValue.get(i), context, false));
                    }
                    return instance;
                }
                throw new IllegalArgumentException();
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
    static Value objectToValue(final Class clazz, final Object o) throws JessException {
        final Class<?> clazz2 = (o == null) ? Void.TYPE : o.getClass();
        if (o == null && !clazz.isArray()) {
            return Funcall.NIL;
        }
        Class class$java$lang$Void;
        if ((class$java$lang$Void = ReflectFunctions.class$java$lang$Void) == null) {
            class$java$lang$Void = (ReflectFunctions.class$java$lang$Void = class$("[Ljava.lang.Void;", false));
        }
        if (clazz == class$java$lang$Void) {
            return Funcall.NIL;
        }
        if (o instanceof Value) {
            return (Value)o;
        }
        Class class$java$lang$String;
        if ((class$java$lang$String = ReflectFunctions.class$java$lang$String) == null) {
            class$java$lang$String = (ReflectFunctions.class$java$lang$String = class$("[Ljava.lang.String;", false));
        }
        if (clazz != class$java$lang$String) {
            final Class<?> clazz3 = clazz2;
            Class class$java$lang$String2;
            if ((class$java$lang$String2 = ReflectFunctions.class$java$lang$String) == null) {
                class$java$lang$String2 = (ReflectFunctions.class$java$lang$String = class$("[Ljava.lang.String;", false));
            }
            if (clazz3 != class$java$lang$String2) {
                if (clazz.isArray()) {
                    int length = 0;
                    if (o != null) {
                        length = Array.getLength(o);
                    }
                    final ValueVector valueVector = new ValueVector(length);
                    for (int i = 0; i < length; ++i) {
                        valueVector.add(objectToValue(clazz.getComponentType(), Array.get(o, i)));
                    }
                    return new Value(valueVector, 512);
                }
                if (clazz != Boolean.TYPE && clazz2 != Boolean.TYPE) {
                    Class class$java$lang$Boolean;
                    if ((class$java$lang$Boolean = ReflectFunctions.class$java$lang$Boolean) == null) {
                        class$java$lang$Boolean = (ReflectFunctions.class$java$lang$Boolean = class$("[Ljava.lang.Boolean;", false));
                    }
                    if (clazz != class$java$lang$Boolean) {
                        final Class<Boolean> clazz4 = (Class<Boolean>)clazz2;
                        Class class$java$lang$Boolean2;
                        if ((class$java$lang$Boolean2 = ReflectFunctions.class$java$lang$Boolean) == null) {
                            class$java$lang$Boolean2 = (ReflectFunctions.class$java$lang$Boolean = class$("[Ljava.lang.Boolean;", false));
                        }
                        if (clazz4 != class$java$lang$Boolean2) {
                            if (clazz != Byte.TYPE && clazz != Short.TYPE && clazz != Integer.TYPE && clazz2 != Byte.TYPE && clazz2 != Short.TYPE && clazz2 != Integer.TYPE) {
                                Class class$java$lang$Byte;
                                if ((class$java$lang$Byte = ReflectFunctions.class$java$lang$Byte) == null) {
                                    class$java$lang$Byte = (ReflectFunctions.class$java$lang$Byte = class$("[Ljava.lang.Byte;", false));
                                }
                                if (clazz != class$java$lang$Byte) {
                                    Class class$java$lang$Short;
                                    if ((class$java$lang$Short = ReflectFunctions.class$java$lang$Short) == null) {
                                        class$java$lang$Short = (ReflectFunctions.class$java$lang$Short = class$("[Ljava.lang.Short;", false));
                                    }
                                    if (clazz != class$java$lang$Short) {
                                        Class class$java$lang$Integer;
                                        if ((class$java$lang$Integer = ReflectFunctions.class$java$lang$Integer) == null) {
                                            class$java$lang$Integer = (ReflectFunctions.class$java$lang$Integer = class$("[Ljava.lang.Integer;", false));
                                        }
                                        if (clazz != class$java$lang$Integer) {
                                            final Class<Integer> clazz5 = (Class<Integer>)clazz2;
                                            Class class$java$lang$Byte2;
                                            if ((class$java$lang$Byte2 = ReflectFunctions.class$java$lang$Byte) == null) {
                                                class$java$lang$Byte2 = (ReflectFunctions.class$java$lang$Byte = class$("[Ljava.lang.Byte;", false));
                                            }
                                            if (clazz5 != class$java$lang$Byte2) {
                                                final Class<Integer> clazz6 = (Class<Integer>)clazz2;
                                                Class class$java$lang$Short2;
                                                if ((class$java$lang$Short2 = ReflectFunctions.class$java$lang$Short) == null) {
                                                    class$java$lang$Short2 = (ReflectFunctions.class$java$lang$Short = class$("[Ljava.lang.Short;", false));
                                                }
                                                if (clazz6 != class$java$lang$Short2) {
                                                    final Class<Integer> clazz7 = (Class<Integer>)clazz2;
                                                    Class class$java$lang$Integer2;
                                                    if ((class$java$lang$Integer2 = ReflectFunctions.class$java$lang$Integer) == null) {
                                                        class$java$lang$Integer2 = (ReflectFunctions.class$java$lang$Integer = class$("[Ljava.lang.Integer;", false));
                                                    }
                                                    if (clazz7 != class$java$lang$Integer2) {
                                                        if (clazz != Long.TYPE && clazz2 != Long.TYPE) {
                                                            Class class$java$lang$Long;
                                                            if ((class$java$lang$Long = ReflectFunctions.class$java$lang$Long) == null) {
                                                                class$java$lang$Long = (ReflectFunctions.class$java$lang$Long = class$("[Ljava.lang.Long;", false));
                                                            }
                                                            if (clazz != class$java$lang$Long) {
                                                                final Class<Long> clazz8 = (Class<Long>)clazz2;
                                                                Class class$java$lang$Long2;
                                                                if ((class$java$lang$Long2 = ReflectFunctions.class$java$lang$Long) == null) {
                                                                    class$java$lang$Long2 = (ReflectFunctions.class$java$lang$Long = class$("[Ljava.lang.Long;", false));
                                                                }
                                                                if (clazz8 != class$java$lang$Long2) {
                                                                    if (clazz != Double.TYPE && clazz != Float.TYPE && clazz2 != Double.TYPE && clazz2 != Float.TYPE) {
                                                                        Class class$java$lang$Double;
                                                                        if ((class$java$lang$Double = ReflectFunctions.class$java$lang$Double) == null) {
                                                                            class$java$lang$Double = (ReflectFunctions.class$java$lang$Double = class$("[Ljava.lang.Double;", false));
                                                                        }
                                                                        if (clazz != class$java$lang$Double) {
                                                                            Class class$java$lang$Float;
                                                                            if ((class$java$lang$Float = ReflectFunctions.class$java$lang$Float) == null) {
                                                                                class$java$lang$Float = (ReflectFunctions.class$java$lang$Float = class$("[Ljava.lang.Float;", false));
                                                                            }
                                                                            if (clazz != class$java$lang$Float) {
                                                                                final Class<Float> clazz9 = (Class<Float>)clazz2;
                                                                                Class class$java$lang$Double2;
                                                                                if ((class$java$lang$Double2 = ReflectFunctions.class$java$lang$Double) == null) {
                                                                                    class$java$lang$Double2 = (ReflectFunctions.class$java$lang$Double = class$("[Ljava.lang.Double;", false));
                                                                                }
                                                                                if (clazz9 != class$java$lang$Double2) {
                                                                                    final Class<Float> clazz10 = (Class<Float>)clazz2;
                                                                                    Class class$java$lang$Float2;
                                                                                    if ((class$java$lang$Float2 = ReflectFunctions.class$java$lang$Float) == null) {
                                                                                        class$java$lang$Float2 = (ReflectFunctions.class$java$lang$Float = class$("[Ljava.lang.Float;", false));
                                                                                    }
                                                                                    if (clazz10 != class$java$lang$Float2) {
                                                                                        if (clazz != Character.TYPE && clazz2 != Character.TYPE) {
                                                                                            Class class$java$lang$Character;
                                                                                            if ((class$java$lang$Character = ReflectFunctions.class$java$lang$Character) == null) {
                                                                                                class$java$lang$Character = (ReflectFunctions.class$java$lang$Character = class$("[Ljava.lang.Character;", false));
                                                                                            }
                                                                                            if (clazz != class$java$lang$Character) {
                                                                                                final Class<Character> clazz11 = (Class<Character>)clazz2;
                                                                                                Class class$java$lang$Character2;
                                                                                                if ((class$java$lang$Character2 = ReflectFunctions.class$java$lang$Character) == null) {
                                                                                                    class$java$lang$Character2 = (ReflectFunctions.class$java$lang$Character = class$("[Ljava.lang.Character;", false));
                                                                                                }
                                                                                                if (clazz11 != class$java$lang$Character2) {
                                                                                                    return new Value(o);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        return new Value(o.toString(), 1);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    return new Value(((Number)o).doubleValue(), 32);
                                                                }
                                                            }
                                                        }
                                                        return new LongValue((long)o);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return new Value(((Number)o).intValue(), 4);
                        }
                    }
                }
                return o ? Funcall.TRUE : Funcall.FALSE;
            }
        }
        return new Value(o.toString(), 2);
    }
    
    static PropertyDescriptor[] getPropertyDescriptors(final Class clazz) throws JessException, IntrospectionException {
        final PropertyDescriptor[] array;
        if ((array = ReflectFunctions.s_descriptors.get(clazz)) != null) {
            return array;
        }
        final BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        if (beanInfo.getBeanDescriptor().getBeanClass() != clazz) {
            throw new JessException("ReflectFunctions.getPropertyDescriptors", "Introspector returned bogus BeanInfo object for class ", beanInfo.getBeanDescriptor().getBeanClass().getName());
        }
        final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        ReflectFunctions.s_descriptors.put(clazz, propertyDescriptors);
        return propertyDescriptors;
    }
    
    static /* synthetic */ Class class$(final String s, final boolean b) {
        try {
            final Class<?> forName = Class.forName(s);
            if (!b) {
                forName.getComponentType();
            }
            return forName;
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        ReflectFunctions.s_descriptors = new Hashtable();
    }
}
