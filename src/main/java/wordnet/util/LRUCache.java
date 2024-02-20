package wordnet.util;

import java.util.Hashtable;
import java.util.Vector;

public class LRUCache implements Cache
{
    protected int capacity;
    protected Vector keys;
    protected Hashtable map;
    
    public synchronized void put(final Object o, final Object o2) {
        this.remove(o);
        this.keys.insertElementAt(o, 0);
        this.map.put(o, o2);
        if (this.keys.size() >= this.capacity) {
            this.remove(this.keys.elementAt(this.keys.size() - 1));
        }
    }
    
    public synchronized Object get(final Object o) {
        final Object value = this.map.get(o);
        if (value != null) {
            this.keys.removeElement(o);
            this.keys.insertElementAt(o, 0);
        }
        return value;
    }
    
    public synchronized void remove(final Object o) {
        if (this.map.remove(o) != null) {
            this.keys.removeElement(o);
            --this.capacity;
        }
    }
    
    public synchronized void clear() {
        this.keys.removeAllElements();
        this.map.clear();
    }
    
    public LRUCache(final int capacity) {
        this.capacity = capacity;
        this.keys = new Vector(capacity);
        this.map = new Hashtable(capacity);
    }
}
