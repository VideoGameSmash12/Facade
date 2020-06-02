package facade.characters.trip.java;

import wm.WME;

public class MiscFlagWME extends WME
{
    private boolean bGmProvocativeL2Moved;
    private boolean bMiscTempBool;
    
    public synchronized boolean getBGmProvocativeL2Moved() {
        return this.bGmProvocativeL2Moved;
    }
    
    public synchronized boolean getBMiscTempBool() {
        return this.bMiscTempBool;
    }
    
    public synchronized void setBGmProvocativeL2Moved(final boolean bGmProvocativeL2Moved) {
        this.bGmProvocativeL2Moved = bGmProvocativeL2Moved;
    }
    
    public synchronized void setBMiscTempBool(final boolean bMiscTempBool) {
        this.bMiscTempBool = bMiscTempBool;
    }
    
    public MiscFlagWME(final boolean bGmProvocativeL2Moved, final boolean bMiscTempBool) {
        this.bGmProvocativeL2Moved = bGmProvocativeL2Moved;
        this.bMiscTempBool = bMiscTempBool;
    }
    
    public MiscFlagWME() {
    }
}
