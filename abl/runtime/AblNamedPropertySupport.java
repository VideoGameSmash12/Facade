package abl.runtime;

import java.util.Enumeration;
import java.util.Vector;
import java.util.List;
import java.util.Hashtable;

public class AblNamedPropertySupport
{
    private final Hashtable propertyTable;
    
    public void setProperty(final String s, final Object o) {
        this.propertyTable.put(s, o);
    }
    
    public Object getProperty(final String s) {
        return this.propertyTable.get(s);
    }
    
    void deleteProperty(final String s) {
        this.propertyTable.remove(s);
    }
    
    List getAllDefinedProperties() {
        final Vector<UserProperty> vector = new Vector<UserProperty>();
        final Enumeration<String> keys = this.propertyTable.keys();
        while (keys.hasMoreElements()) {
            final String s = keys.nextElement();
            vector.add(new UserProperty(s, this.propertyTable.get(s)));
        }
        return vector;
    }
    
    private final /* synthetic */ void this() {
        this.propertyTable = new Hashtable();
    }
    
    public AblNamedPropertySupport() {
        this.this();
    }
    
    public class UserProperty
    {
        private final String name;
        private final Object value;
        
        public String getName() {
            return this.name;
        }
        
        public Object getValue() {
            return this.value;
        }
        
        UserProperty(final String name, final Object value) {
            this.name = name;
            this.value = value;
        }
    }
}
