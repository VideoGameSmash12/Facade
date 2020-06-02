package facade.characters.grace.java;

import wm.WME;

public class GazeWME extends WME
{
    private int objectID;
    private int speed;
    private int type;
    private int alterHeadCock;
    
    public synchronized int getObjectID() {
        return this.objectID;
    }
    
    public synchronized int getSpeed() {
        return this.speed;
    }
    
    public synchronized int getType() {
        return this.type;
    }
    
    public synchronized int getAlterHeadCock() {
        return this.alterHeadCock;
    }
    
    public synchronized void setObjectID(final int objectID) {
        this.objectID = objectID;
    }
    
    public synchronized void setSpeed(final int speed) {
        this.speed = speed;
    }
    
    public synchronized void setType(final int type) {
        this.type = type;
    }
    
    public synchronized void setAlterHeadCock(final int alterHeadCock) {
        this.alterHeadCock = alterHeadCock;
    }
    
    public GazeWME(final int objectID, final int speed, final int type, final int alterHeadCock) {
        this.objectID = objectID;
        this.speed = speed;
        this.type = type;
        this.alterHeadCock = alterHeadCock;
    }
    
    public GazeWME() {
    }
}
