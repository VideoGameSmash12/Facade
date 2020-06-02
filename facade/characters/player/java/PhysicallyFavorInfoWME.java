package facade.characters.player.java;

import wm.WME;

public class PhysicallyFavorInfoWME extends WME
{
    private int spriteID;
    private boolean lookAtSensorActive;
    private boolean objectActivateSensorActive;
    private float lookDistance;
    
    public synchronized int getSpriteID() {
        return this.spriteID;
    }
    
    public synchronized boolean getLookAtSensorActive() {
        return this.lookAtSensorActive;
    }
    
    public synchronized boolean getObjectActivateSensorActive() {
        return this.objectActivateSensorActive;
    }
    
    public synchronized float getLookDistance() {
        return this.lookDistance;
    }
    
    public synchronized void setSpriteID(final int spriteID) {
        this.spriteID = spriteID;
    }
    
    public synchronized void setLookAtSensorActive(final boolean lookAtSensorActive) {
        this.lookAtSensorActive = lookAtSensorActive;
    }
    
    public synchronized void setObjectActivateSensorActive(final boolean objectActivateSensorActive) {
        this.objectActivateSensorActive = objectActivateSensorActive;
    }
    
    public synchronized void setLookDistance(final float lookDistance) {
        this.lookDistance = lookDistance;
    }
    
    public PhysicallyFavorInfoWME(final int spriteID, final boolean lookAtSensorActive, final boolean objectActivateSensorActive, final float lookDistance) {
        this.spriteID = spriteID;
        this.lookAtSensorActive = lookAtSensorActive;
        this.objectActivateSensorActive = objectActivateSensorActive;
        this.lookDistance = lookDistance;
    }
    
    public PhysicallyFavorInfoWME() {
    }
}
