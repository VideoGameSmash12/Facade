package facade.characters.wmedef;

import wm.WME;

public class GazeTrackingObjectWME extends WME
{
    private int characterID;
    private int objectID;
    
    public synchronized int getCharacterID() {
        return this.characterID;
    }
    
    public synchronized long getObjectID() {
        return this.objectID;
    }
    
    public synchronized void setCharacterID(final int characterID) {
        this.characterID = characterID;
    }
    
    public synchronized void setObjectID(final int objectID) {
        this.objectID = objectID;
    }
    
    public GazeTrackingObjectWME(final int characterID, final int objectID) {
        this.characterID = characterID;
        this.objectID = objectID;
    }
    
    public GazeTrackingObjectWME() {
    }
}
