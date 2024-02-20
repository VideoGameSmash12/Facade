package facade.characters.wmedef;

import facade.util.PrintUtilities;
import wm.WME;

public class HeldObjectWME extends WME
{
    private int objectID;
    private int characterID;
    private int attachPointID;
    private int objectCategory;
    
    public synchronized int getObjectID() {
        return this.objectID;
    }
    
    public synchronized int getCharacterID() {
        return this.characterID;
    }
    
    public synchronized int getAttachPointID() {
        return this.attachPointID;
    }
    
    public synchronized int getObjectCategory() {
        return this.objectCategory;
    }
    
    public synchronized void setObjectID(final int objectID) {
        this.objectID = objectID;
    }
    
    public synchronized void setCharacterID(final int characterID) {
        this.characterID = characterID;
    }
    
    public synchronized void setAttachPointID(final int attachPointID) {
        this.attachPointID = attachPointID;
    }
    
    public synchronized void setObjectCategory(final int objectCategory) {
        this.objectCategory = objectCategory;
    }
    
    public synchronized String formatObjectID() {
        return PrintUtilities.spriteID_EnumToString(this.getObjectID());
    }
    
    public synchronized String formatCharacterID() {
        return PrintUtilities.spriteID_EnumToString(this.getCharacterID());
    }
    
    public HeldObjectWME(final int objectID, final int characterID, final int attachPointID, final int objectCategory) {
        this.objectID = objectID;
        this.characterID = characterID;
        this.attachPointID = attachPointID;
        this.objectCategory = objectCategory;
    }
    
    public HeldObjectWME() {
    }
}
