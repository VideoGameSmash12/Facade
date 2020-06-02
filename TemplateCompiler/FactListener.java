package TemplateCompiler;

import java.util.List;
import wm.WorkingMemory;
import jess.Rete;
import jess.JessEvent;
import jess.JessException;
import jess.Value;
import jess.ValueVector;
import jess.Fact;
import java.lang.reflect.Constructor;
import abl.runtime.RuntimeError;
import wm.WME;
import java.util.Hashtable;
import jess.Context;
import java.util.Vector;
import jess.JessListener;

public class FactListener implements JessListener
{
    private static Vector WMElist;
    private Context c;
    private Hashtable listofnames;
    private Hashtable constants;
    private long time;
    private TimeOut to;
    
    private final WME chooseWME(final String s, final Vector vector, final long n) {
        Class<?> forName;
        try {
            forName = Class.forName("facade.characters.wmedef." + s);
        }
        catch (ClassNotFoundException ex) {
            throw new RuntimeError(ex.getMessage());
        }
        vector.addElement(new Long(n));
        final Object[] array = vector.toArray();
        final Class[] array2 = new Class[array.length];
        for (int i = 0; i < array.length; ++i) {
            final Class<?> class1 = array[i].getClass();
            if (class1.getName().equals("java.lang.Integer")) {
                array2[i] = Integer.TYPE;
            }
            else if (class1.getName().equals("java.lang.Float")) {
                array2[i] = Float.TYPE;
            }
            else if (class1.getName().equals("java.lang.Long")) {
                array2[i] = Long.TYPE;
            }
            else if (class1.getName().equals("java.lang.Byte")) {
                array2[i] = Byte.TYPE;
            }
            else if (class1.getName().equals("java.lang.Double")) {
                array2[i] = Double.TYPE;
            }
            else if (class1.getName().equals("java.lang.Short")) {
                array2[i] = Short.TYPE;
            }
            else {
                array2[i] = class1;
            }
        }
        Constructor<?> declaredConstructor;
        try {
            declaredConstructor = forName.getDeclaredConstructor((Class<?>[])array2);
        }
        catch (Exception ex2) {
            throw new RuntimeError("Could not find constructor. " + ex2.getMessage());
        }
        WME wme;
        try {
            wme = (WME)declaredConstructor.newInstance(array);
        }
        catch (Throwable t) {
            throw new RuntimeError("could not construct WME " + t.getMessage());
        }
        return wme;
    }
    
    private final WME generateWME(final Fact fact, final long n, final String s, final Context context) throws JessException {
        final Vector<WME> vector = new Vector<WME>();
        final ValueVector listValue = fact.get(0).listValue(context);
        for (int size = listValue.size(), i = 0; i < size; ++i) {
            final Value value = listValue.get(i);
            switch (value.type()) {
                case 16: {
                    final Fact factValue = value.factValue(context);
                    System.out.println("we got a fact");
                    final String s2 = this.listofnames.get(factValue.getDeftemplate().getBaseName());
                    if (s2 == null) {
                        throw new RuntimeException("Could not find a nested fact");
                    }
                    vector.addElement(this.generateWME(factValue, n, s2, context));
                    break;
                }
                case 4: {
                    vector.addElement((WME)new Integer(value.intValue(context)));
                    break;
                }
                case 1: {
                    final Integer n2 = this.constants.get(value.atomValue(context));
                    if (n2 == null) {
                        throw new RuntimeException("Constant " + value.atomValue(context) + " not defined");
                    }
                    vector.addElement((WME)n2);
                    break;
                }
                default: {
                    throw new RuntimeException("Invalid type in DisAct");
                }
            }
        }
        return this.chooseWME(s, vector, n);
    }
    
    public void eventHappened(final JessEvent jessEvent) throws JessException {
        final int type = jessEvent.getType();
        if (type == 16) {
            final Fact fact = (Fact)jessEvent.getObject();
            final String baseName = fact.getDeftemplate().getBaseName();
            this.c = ((Rete)jessEvent.getSource()).getGlobalContext();
            if (NLUdebugger.observe) {
                NLUdebugger.addmessage(baseName, System.currentTimeMillis());
            }
            if (baseName.equals("DefMap")) {
                final ValueVector listValue = fact.get(0).listValue(this.c);
                this.listofnames.put(listValue.get(0).toString(), listValue.get(1).toString());
            }
            else if (baseName.equals("_timeout")) {
                final ValueVector listValue2 = fact.get(0).listValue(this.c);
                this.to.addnew(listValue2.get(0).atomValue(this.c), listValue2.get(1).intValue(this.c), listValue2.get(2).intValue(this.c));
            }
            else if (baseName.equals("DefConst")) {
                final ValueVector listValue3 = fact.get(0).listValue(this.c);
                this.constants.put(listValue3.get(0).atomValue(this.c), new Integer(listValue3.get(1).intValue(this.c)));
            }
            else if (this.listofnames.containsKey(baseName)) {
                final String s = this.listofnames.get(baseName);
                if (this.time == 0L) {
                    this.time = System.currentTimeMillis();
                }
                System.out.println(new StringBuffer().append(this.time).append(' ').append(s).toString());
                FactListener.WMElist.addElement(this.generateWME(fact, this.time, s, this.c));
            }
        }
        else if (type == 16384) {
            System.out.println("Adding " + FactListener.WMElist.size() + " DAWMEs to Trip's memory");
            WorkingMemory.lookupRegisteredMemory("TripMemory").addWMEs(FactListener.WMElist);
            FactListener.WMElist.removeAllElements();
            this.time = 0L;
        }
    }
    
    private final /* synthetic */ void this() {
        this.listofnames = new Hashtable();
        this.constants = new Hashtable();
        this.time = 0L;
    }
    
    public FactListener(final TimeOut to) {
        this.this();
        this.to = to;
    }
    
    static {
        FactListener.WMElist = new Vector();
    }
}
