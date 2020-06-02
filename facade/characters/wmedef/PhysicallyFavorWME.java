package facade.characters.wmedef;

import facade.util.PrintUtilities;
import wm.TimeStampedWME;

public class PhysicallyFavorWME extends TimeStampedWME
{
    private int objectID;
    private int favoringCharID;
    private boolean handled;
    
    public synchronized int getObjectID() {
        return this.objectID;
    }
    
    public synchronized int getFavoringCharID() {
        return this.favoringCharID;
    }
    
    public synchronized boolean getHandled() {
        return this.handled;
    }
    
    public synchronized void setObjectID(final int objectID) {
        this.objectID = objectID;
    }
    
    public synchronized void setFavoringCharID(final int favoringCharID) {
        this.favoringCharID = favoringCharID;
    }
    
    public synchronized void setHandled(final boolean handled) {
        this.handled = handled;
    }
    
    public synchronized String formatObjectID() {
        return PrintUtilities.spriteID_EnumToString(this.getObjectID());
    }
    
    public synchronized String formatFavoringCharID() {
        return PrintUtilities.spriteID_EnumToString(this.getFavoringCharID());
    }
    
    public PhysicallyFavorWME(final int objectID, final int favoringCharID) {
        this.objectID = objectID;
        this.favoringCharID = favoringCharID;
        this.handled = false;
    }
    
    public PhysicallyFavorWME(final int objectID, final int favoringCharID, final int n) {
        super(n);
        this.objectID = objectID;
        this.favoringCharID = favoringCharID;
        this.handled = false;
    }
    
    public PhysicallyFavorWME() {
    }
}
