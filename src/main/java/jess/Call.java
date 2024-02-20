package jess;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.io.Serializable;

class Call implements Userfunction, Serializable
{
    private static Hashtable s_methods;
    String m_name;
    
    public String getName() {
        return this.m_name;
    }
    
    static Method[] getMethods(final Class clazz) {
        if (Call.s_methods.get(clazz) != null) {
            return Call.s_methods.get(clazz);
        }
        final Method[] methods = clazz.getMethods();
        Call.s_methods.put(clazz, methods);
        return methods;
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(2).stringValue(context);
        Class<?> clazz = null;
        try {
            Object externalAddressValue = null;
            final Value resolveValue = valueVector.get(1).resolveValue(context);
            if (resolveValue.type() == 2 || resolveValue.type() == 1) {
                if (resolveValue.equals(Funcall.NIL)) {
                    throw new JessException("call", "Can't call method on nil reference:", stringValue);
                }
                try {
                    clazz = (Class<?>)context.getEngine().findClass(resolveValue.stringValue(context));
                }
                catch (Exception ex4) {}
            }
            if (clazz == null) {
                externalAddressValue = resolveValue.externalAddressValue(context);
                clazz = externalAddressValue.getClass();
            }
            final int n = valueVector.size() - 3;
            final Object[] array = new Object[n];
            final Method[] methods = getMethods(clazz);
            for (int i = 0; i < methods.length; ++i) {
                try {
                    Method method = methods[i];
                    final Class<?>[] parameterTypes = method.getParameterTypes();
                    if (method.getName().equals(stringValue) && n == parameterTypes.length) {
                        if (!Modifier.isPublic(clazz.getModifiers())) {
                            method = null;
                        Label_0276:
                            while (clazz != null) {
                                final Class[] interfaces = clazz.getInterfaces();
                                int j = 0;
                                while (j < interfaces.length) {
                                    try {
                                        method = interfaces[j].getMethod(stringValue, (Class[])parameterTypes);
                                        break Label_0276;
                                    }
                                    catch (NoSuchMethodException ex5) {
                                        ++j;
                                    }
                                }
                                clazz = clazz.getSuperclass();
                                if (clazz != null && Modifier.isPublic(clazz.getModifiers())) {
                                    try {
                                        method = clazz.getMethod(stringValue, (Class[])parameterTypes);
                                        break;
                                    }
                                    catch (NoSuchMethodException ex6) {}
                                }
                            }
                            if (method == null) {
                                throw new JessException("call", "Method not accessible", stringValue);
                            }
                        }
                        for (int k = 0; k < n; ++k) {
                            array[k] = ReflectFunctions.valueToObject(parameterTypes[k], valueVector.get(k + 3), context);
                        }
                        return ReflectFunctions.objectToValue(method.getReturnType(), method.invoke(externalAddressValue, array));
                    }
                }
                catch (IllegalArgumentException ex7) {}
            }
            throw new NoSuchMethodException(stringValue);
        }
        catch (NoSuchMethodException ex8) {
            if (!this.hasMethodOfName(clazz, stringValue)) {
                throw new JessException("call", "No method named '" + stringValue + "' found", "in class " + clazz.getName());
            }
            throw new JessException("call", "No overloading of method '" + stringValue + '\'', "in class " + clazz.getName() + " I can call with these arguments: " + valueVector.toStringWithParens());
        }
        catch (InvocationTargetException ex) {
            throw new JessException("call", "Called method threw an exception", ex.getTargetException());
        }
        catch (IllegalAccessException ex2) {
            throw new JessException("call", "Method is not accessible", ex2);
        }
        catch (IllegalArgumentException ex3) {
            throw new JessException("call", "Invalid argument to " + stringValue, ex3);
        }
    }
    
    private final boolean hasMethodOfName(final Class clazz, final String s) {
        try {
            final Method[] methods = getMethods(clazz);
            for (int i = 0; i < methods.length; ++i) {
                if (methods[i].getName().equals(s)) {
                    return true;
                }
            }
            return false;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    private final /* synthetic */ void this() {
        this.m_name = "call";
    }
    
    Call() {
        this.this();
    }
    
    static {
        Call.s_methods = new Hashtable();
    }
}
