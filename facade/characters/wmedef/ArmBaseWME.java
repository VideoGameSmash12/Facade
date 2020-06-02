package facade.characters.wmedef;

import facade.util.PrintUtilities;
import wm.WME;

public class ArmBaseWME extends WME
{
    private int characterID;
    private int gestureLayer;
    private int base;
    
    public synchronized int getCharacterID() {
        return this.characterID;
    }
    
    public synchronized int getGestureLayer() {
        return this.gestureLayer;
    }
    
    public synchronized int getBase() {
        return this.base;
    }
    
    public synchronized void setCharacterID(final int characterID) {
        this.characterID = characterID;
    }
    
    public synchronized void setGestureLayer(final int gestureLayer) {
        this.gestureLayer = gestureLayer;
    }
    
    public synchronized void setBase(final int base) {
        this.base = base;
    }
    
    public synchronized String formatCharacterID() {
        return PrintUtilities.spriteID_EnumToString(this.getCharacterID());
    }
    
    public synchronized String formatGestureLayer() {
        return PrintUtilities.animLayer_EnumToString(this.getGestureLayer());
    }
    
    public ArmBaseWME(final int characterID, final int gestureLayer, final int base) {
        this.characterID = characterID;
        this.gestureLayer = gestureLayer;
        this.base = base;
    }
    
    public ArmBaseWME() {
    }
}
