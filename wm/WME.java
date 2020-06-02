package wm;

import java.beans.PropertyChangeListener;
import java.util.Vector;
import java.lang.reflect.Method;
import java.beans.PropertyChangeSupport;

public abstract class WME implements Cloneable
{
    protected static final String BOLD_TAG = "<B>";
    protected static final String UNBOLD_TAG = "</B>";
    protected PropertyChangeSupport __support;
    
    public static String lowercaseFirstCharacter(final String s) {
        final StringBuffer sb = new StringBuffer(s);
        sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        return sb.toString();
    }
    
    public static String uppercaseFirstCharacter(final String s) {
        final StringBuffer sb = new StringBuffer(s);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        return sb.toString();
    }
    
    public Method[] _getSetMethods() {
        try {
            final Method[] methods = this.getClass().getMethods();
            final Vector vector = new Vector<Method>(methods.length);
            for (int i = 0; i < methods.length; ++i) {
                if (methods[i].getName().substring(0, 3).equals("set") && methods[i].getParameterTypes().length == 1) {
                    vector.add(methods[i]);
                }
            }
            return (Method[])vector.toArray((Object[])new Method[vector.size()]);
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
    }
    
    public Method[] _getGetMethods() {
        try {
            final Method[] methods = this.getClass().getMethods();
            final Vector vector = new Vector<Method>(methods.length);
            for (int i = 0; i < methods.length; ++i) {
                final String name = methods[i].getName();
                if (name.substring(0, 3).equals("get") && !name.equals("getClass") && methods[i].getParameterTypes().length == 0) {
                    vector.add(methods[i]);
                }
            }
            return (Method[])vector.toArray((Object[])new Method[vector.size()]);
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
    }
    
    public String[] _getFieldNames() {
        final Method[] getGetMethods = this._getGetMethods();
        final String[] array = new String[getGetMethods.length];
        for (int i = 0; i < getGetMethods.length; ++i) {
            array[i] = lowercaseFirstCharacter(getGetMethods[i].getName().substring(3));
        }
        return array;
    }
    
    public Class[] _getFieldTypes() {
        final Method[] getGetMethods = this._getGetMethods();
        final Class[] array = new Class[getGetMethods.length];
        for (int i = 0; i < getGetMethods.length; ++i) {
            array[i] = getGetMethods[i].getReturnType();
        }
        return array;
    }
    
    public Method _getGetMethod(final String s) throws NoSuchFieldException {
        final String string = "get" + uppercaseFirstCharacter(s);
        try {
            return this.getClass().getMethod(string, (Class<?>[])null);
        }
        catch (NoSuchMethodException ex) {
            throw new NoSuchFieldException(s);
        }
    }
    
    public Method _getSetMethod(final String s, final Class clazz) throws NoSuchFieldException {
        final String string = "set" + uppercaseFirstCharacter(s);
        try {
            return this.getClass().getMethod(string, clazz);
        }
        catch (NoSuchMethodException ex) {
            throw new NoSuchFieldException(s);
        }
    }
    
    public String toString() {
        final String[] getFieldNames = this._getFieldNames();
        final Method[] getGetMethods = this._getGetMethods();
        final StringBuffer sb = new StringBuffer();
        sb.append("(");
        try {
            for (int i = 0; i < getFieldNames.length; ++i) {
                sb.append(getFieldNames[i] + ": ");
                final String string = "format" + uppercaseFirstCharacter(getFieldNames[i]);
                if (!Class.forName("wm.WME").isAssignableFrom(getGetMethods[i].getReturnType())) {
                    try {
                        sb.append(this.getClass().getMethod(string, (Class<?>[])null).invoke(this, (Object[])null));
                    }
                    catch (NoSuchMethodException ex2) {
                        sb.append(getGetMethods[i].invoke(this, (Object[])null));
                    }
                }
                else {
                    try {
                        sb.append(this.getClass().getMethod(string, (Class<?>[])null).invoke(this, (Object[])null));
                    }
                    catch (NoSuchMethodException ex3) {
                        final WME wme = (WME)getGetMethods[i].invoke(this, (Object[])null);
                        if (wme == null) {
                            sb.append(wme);
                        }
                        else {
                            sb.append(wme.objectToString());
                        }
                    }
                }
                if (i + 1 != getFieldNames.length) {
                    sb.append(", ");
                }
            }
            sb.append(")");
            return sb.toString();
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
    }
    
    public String toString_HTML() {
        final String[] getFieldNames = this._getFieldNames();
        final Method[] getGetMethods = this._getGetMethods();
        final StringBuffer sb = new StringBuffer();
        sb.append("<font size = \"-1\" face=\"Helvetica, Arial, sans-serif\">");
        sb.append("(");
        try {
            for (int i = 0; i < getFieldNames.length; ++i) {
                sb.append(getFieldNames[i] + ": ");
                final String string = "format" + uppercaseFirstCharacter(getFieldNames[i]);
                if (!Class.forName("wm.WME").isAssignableFrom(getGetMethods[i].getReturnType())) {
                    try {
                        sb.append("<B>" + this.getClass().getMethod(string, (Class<?>[])null).invoke(this, (Object[])null) + "</B>");
                    }
                    catch (NoSuchMethodException ex2) {
                        sb.append("<B>" + getGetMethods[i].invoke(this, (Object[])null) + "</B>");
                    }
                }
                else {
                    try {
                        sb.append("<B>" + this.getClass().getMethod(string, (Class<?>[])null).invoke(this, (Object[])null) + "</B>");
                    }
                    catch (NoSuchMethodException ex3) {
                        final WME wme = (WME)getGetMethods[i].invoke(this, (Object[])null);
                        if (wme == null) {
                            sb.append("<B>" + wme + "</B>");
                        }
                        else {
                            sb.append("<B>" + wme.objectToString() + "</B>");
                        }
                    }
                }
                if (i + 1 != getFieldNames.length) {
                    sb.append(", ");
                }
            }
            sb.append(")");
            return sb.toString();
        }
        catch (Exception ex) {
            throw new WmeReflectionError(ex);
        }
    }
    
    protected String objectToString() {
        return super.toString();
    }
    
    public WME cloneWME() {
        try {
            return (WME)this.clone();
        }
        catch (CloneNotSupportedException ex) {
            throw new WorkingMemoryError(ex.getMessage());
        }
    }
    
    public void addPropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        this.__support.addPropertyChangeListener(propertyChangeListener);
    }
    
    public void removePropertyChangeListener(final PropertyChangeListener propertyChangeListener) {
        this.__support.removePropertyChangeListener(propertyChangeListener);
    }
    
    public void addPropertyChangeListener(final String s, final PropertyChangeListener propertyChangeListener) {
        this.__support.addPropertyChangeListener(propertyChangeListener);
    }
    
    public void removePropertyChangeListener(final String s, final PropertyChangeListener propertyChangeListener) {
        this.__support.removePropertyChangeListener(s, propertyChangeListener);
    }
    
    public boolean isTransient() {
        return false;
    }
    
    public void assign(final WME wme) {
        final Method[] getGetMethods = wme._getGetMethods();
        wme._getFieldTypes();
        for (int i = 0; i < getGetMethods.length; ++i) {
            try {
                final String lowercaseFirstCharacter = lowercaseFirstCharacter(getGetMethods[i].getName().substring(3));
                final Class<?> returnType = getGetMethods[i].getReturnType();
                try {
                    this._getSetMethod(lowercaseFirstCharacter, returnType).invoke(this, getGetMethods[i].invoke(wme, (Object[])null));
                }
                catch (NoSuchFieldException ex2) {}
            }
            catch (Exception ex) {
                throw new WmeReflectionError(ex);
            }
        }
    }
    
    private final /* synthetic */ void this() {
        this.__support = new PropertyChangeSupport(this);
    }
    
    public WME() {
        this.this();
    }
}
