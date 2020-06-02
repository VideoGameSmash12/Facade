package facade.characters.wmedef;

import facade.util.PrintUtilities;
import wm.WME;

public class ObjectStateWME extends WME
{
    private int objectID;
    private int state;
    
    public synchronized int getObjectID() {
        return this.objectID;
    }
    
    public synchronized int getState() {
        return this.state;
    }
    
    public synchronized void setObjectID(final int objectID) {
        this.objectID = objectID;
    }
    
    public synchronized void setState(final int state) {
        this.state = state;
    }
    
    public synchronized String formatObjectID() {
        return PrintUtilities.spriteID_EnumToString(this.getObjectID());
    }
    
    public ObjectStateWME(final int objectID, final int state) {
        this.objectID = objectID;
        this.state = state;
    }
    
    public ObjectStateWME() {
    }
}
