package facade.characters.wmedef;

import facade.util.PrintUtilities;
import wm.WME;

public class OneCharacterVisibleWME extends WME
{
    private int visibleCharID;
    
    public synchronized int getVisibleCharID() {
        return this.visibleCharID;
    }
    
    public synchronized void setVisibleCharID(final int visibleCharID) {
        this.visibleCharID = visibleCharID;
    }
    
    public synchronized String formatVisibleCharID() {
        return PrintUtilities.spriteID_EnumToString(this.getVisibleCharID());
    }
    
    public OneCharacterVisibleWME(final int visibleCharID) {
        this.visibleCharID = visibleCharID;
    }
    
    public OneCharacterVisibleWME() {
    }
}
