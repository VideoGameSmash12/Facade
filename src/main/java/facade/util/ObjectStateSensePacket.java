package facade.util;

import java.util.Iterator;
import java.util.HashMap;

public class ObjectStateSensePacket implements SpriteID
{
    private final HashMap info;
    
    public int getNumberOfObjects() {
        return this.info.size();
    }
    
    public void setObjectInfo(final int n, final int n2) {
        this.info.put(new Integer(n), new ObjectStateInfo(n, n2));
    }
    
    public void setObjectInfo(final ObjectStateInfo objectStateInfo) {
        this.info.put(new Integer(objectStateInfo.objectID), objectStateInfo);
    }
    
    public ObjectStateInfo getObjectInfo(final int n) {
        final ObjectStateInfo objectStateInfo = this.info.get(new Integer(n));
        if (objectStateInfo != null) {
            return new ObjectStateInfo(objectStateInfo.objectID, objectStateInfo.state);
        }
        return null;
    }
    
    public Iterator iterator() {
        return this.info.values().iterator();
    }
    
    public boolean objectInfoEquality(final ObjectStateInfo objectStateInfo) {
        final ObjectStateInfo objectStateInfo2 = this.info.get(new Integer(objectStateInfo.objectID));
        return objectStateInfo2 != null && objectStateInfo2.equals(objectStateInfo);
    }
    
    private final /* synthetic */ void this() {
        this.info = new HashMap();
    }
    
    public ObjectStateSensePacket() {
        this.this();
    }
    
    public class ObjectStateInfo
    {
        public int objectID;
        public int state;
        
        public boolean equals(final Object o) {
            if (!o.getClass().getName().equals("facade.util.ObjectStateSensePacket")) {
                return false;
            }
            final ObjectStateInfo objectStateInfo = (ObjectStateInfo)o;
            return this.objectID == objectStateInfo.objectID && this.state == objectStateInfo.state;
        }
        
        public String toString() {
            return "(ObjectStateInfo  objectID == " + PrintUtilities.spriteID_EnumToString(this.objectID) + "  state == " + this.state + ')';
        }
        
        private final /* synthetic */ void this() {
            this.objectID = -1;
            this.state = -1;
        }
        
        public ObjectStateInfo(final int objectID, final int state) {
            this.this();
            this.objectID = objectID;
            this.state = state;
        }
        
        public ObjectStateInfo() {
            this.this();
        }
    }
}
