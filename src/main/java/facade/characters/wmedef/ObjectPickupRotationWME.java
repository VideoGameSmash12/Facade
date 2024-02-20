package facade.characters.wmedef;

import wm.WME;

public class ObjectPickupRotationWME extends WME
{
    private int objectID;
    private int characterID;
    private float x;
    private float y;
    private float z;
    
    public synchronized int getObjectID() {
        return this.objectID;
    }
    
    public synchronized int getCharacterID() {
        return this.characterID;
    }
    
    public synchronized float getX() {
        return this.x;
    }
    
    public synchronized float getY() {
        return this.y;
    }
    
    public synchronized float getZ() {
        return this.z;
    }
    
    public synchronized void setObjectID(final int objectID) {
        this.objectID = objectID;
    }
    
    public synchronized void setCharacterID(final int characterID) {
        this.characterID = characterID;
    }
    
    public synchronized void setX(final float x) {
        this.x = x;
    }
    
    public synchronized void setY(final float y) {
        this.y = y;
    }
    
    public synchronized void setZ(final float z) {
        this.z = z;
    }
    
    public ObjectPickupRotationWME(final int objectID, final int characterID, final float x, final float y, final float z) {
        this.objectID = objectID;
        this.characterID = characterID;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public ObjectPickupRotationWME() {
    }
}
