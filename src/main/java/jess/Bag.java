package jess;

import java.util.Enumeration;
import java.util.Hashtable;
import java.io.Serializable;

class Bag implements Userfunction, Serializable
{
    private static Hashtable m_bags;
    
    public String getName() {
        return "bag";
    }
    
    public Value call(final ValueVector valueVector, final Context context) throws JessException {
        final String stringValue = valueVector.get(1).stringValue(context);
        Hashtable<Object, Hashtable<?, ?>> hashtable = Bag.m_bags.get(context.getEngine());
        if (hashtable == null) {
            Bag.m_bags.put(context.getEngine(), hashtable = new Hashtable<Object, Hashtable<?, ?>>());
        }
        if (stringValue.equals("create")) {
            final String stringValue2 = valueVector.get(2).stringValue(context);
            Hashtable<?, ?> hashtable2 = hashtable.get(stringValue2);
            if (hashtable2 == null) {
                hashtable2 = new Hashtable<Object, Object>();
                hashtable.put(stringValue2, hashtable2);
            }
            return new Value(hashtable2);
        }
        if (stringValue.equals("delete")) {
            hashtable.remove(valueVector.get(2).stringValue(context));
            if (hashtable.size() == 0) {
                Bag.m_bags.remove(context.getEngine());
            }
            return Funcall.TRUE;
        }
        if (stringValue.equals("find")) {
            final Hashtable<?, ?> hashtable3 = hashtable.get(valueVector.get(2).stringValue(context));
            if (hashtable3 != null) {
                return new Value(hashtable3);
            }
            return Funcall.NIL;
        }
        else {
            if (stringValue.equals("list")) {
                final ValueVector valueVector2 = new ValueVector();
                final Enumeration<String> keys = hashtable.keys();
                while (keys.hasMoreElements()) {
                    valueVector2.add(new Value(keys.nextElement(), 2));
                }
                return new Value(valueVector2, 512);
            }
            if (stringValue.equals("set")) {
                final Hashtable hashtable4 = (Hashtable)valueVector.get(2).externalAddressValue(context);
                final String stringValue3 = valueVector.get(3).stringValue(context);
                final Value resolveValue = valueVector.get(4).resolveValue(context);
                hashtable4.put(stringValue3, resolveValue);
                return resolveValue;
            }
            if (stringValue.equals("get")) {
                final Value value = ((Hashtable)valueVector.get(2).externalAddressValue(context)).get(valueVector.get(3).stringValue(context));
                if (value != null) {
                    return value;
                }
                return Funcall.NIL;
            }
            else {
                if (stringValue.equals("props")) {
                    final Hashtable hashtable5 = (Hashtable)valueVector.get(2).externalAddressValue(context);
                    final ValueVector valueVector3 = new ValueVector();
                    final Enumeration<String> keys2 = hashtable5.keys();
                    while (keys2.hasMoreElements()) {
                        valueVector3.add(new Value(keys2.nextElement(), 2));
                    }
                    return new Value(valueVector3, 512);
                }
                throw new JessException("bag", "Unknown command", stringValue);
            }
        }
    }
    
    static {
        Bag.m_bags = new Hashtable();
    }
}
