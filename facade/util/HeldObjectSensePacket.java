package facade.util;

import java.util.Iterator;
import java.util.HashMap;

public class HeldObjectSensePacket implements SpriteID
{
    private final HashMap info;
    
    public int getNumberOfObjects() {
        return this.info.size();
    }
    
    public void setObjectInfo(final int n, final int n2, final int n3, final int n4) {
        this.info.put(new Integer(n), new HeldObjectInfo(n, n2, n3, n4));
    }
    
    public void setObjectInfo(final HeldObjectInfo heldObjectInfo) {
        this.info.put(new Integer(heldObjectInfo.objectID), heldObjectInfo);
    }
    
    public HeldObjectInfo getObjectInfo(final int n) {
        final HeldObjectInfo heldObjectInfo = this.info.get(new Integer(n));
        if (heldObjectInfo != null) {
            return new HeldObjectInfo(heldObjectInfo.objectID, heldObjectInfo.characterID, heldObjectInfo.attachPointID, heldObjectInfo.objectCategory);
        }
        return null;
    }
    
    public Iterator iterator() {
        return this.info.values().iterator();
    }
    
    public boolean objectInfoEquality(final HeldObjectInfo heldObjectInfo) {
        final HeldObjectInfo heldObjectInfo2 = this.info.get(new Integer(heldObjectInfo.objectID));
        return heldObjectInfo2 != null && heldObjectInfo2.characterID == heldObjectInfo.characterID && heldObjectInfo2.attachPointID == heldObjectInfo.attachPointID && heldObjectInfo2.objectCategory == heldObjectInfo.objectCategory;
    }
    
    private final /* synthetic */ void this() {
        this.info = new HashMap();
    }
    
    public HeldObjectSensePacket() {
        this.this();
    }
    
    public class HeldObjectInfo
    {
        public int objectID;
        public int characterID;
        public int attachPointID;
        public int objectCategory;
        
        public boolean equals(final Object o) {
            if (!o.getClass().getName().equals("facade.util.HeldObjectSensePacket")) {
                return false;
            }
            final HeldObjectInfo heldObjectInfo = (HeldObjectInfo)o;
            return this.objectID == heldObjectInfo.objectID && this.characterID == heldObjectInfo.characterID && this.attachPointID == heldObjectInfo.attachPointID && this.objectCategory == heldObjectInfo.objectCategory;
        }
        
        public String toString() {
            return "(HeldObjectInfo  objectID == " + PrintUtilities.spriteID_EnumToString(this.objectID) + "  characterID == " + PrintUtilities.spriteID_EnumToString(this.objectID) + "  attachPointID " + this.attachPointID + " objectCategory " + this.objectCategory + ')';
        }
        
        private final /* synthetic */ void this() {
            this.objectID = -1;
            this.characterID = -1;
            this.attachPointID = -1;
            this.objectCategory = -1;
        }
        
        public HeldObjectInfo(final int objectID, final int characterID, final int attachPointID, final int objectCategory) {
            this.this();
            this.objectID = objectID;
            this.characterID = characterID;
            this.attachPointID = attachPointID;
            this.objectCategory = objectCategory;
        }
        
        public HeldObjectInfo() {
            this.this();
        }
    }
}
