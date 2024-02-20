package facade.characters.wmedef;

import wm.WME;

public class StagingInfoWME extends WME
{
    private int resourcePriority;
    private int targetObjectID;
    private float targetX;
    private float targetZ;
    private float targetRot;
    private int walkType;
    private boolean bObjMovedFromOrig;
    
    public synchronized int getResourcePriority() {
        return this.resourcePriority;
    }
    
    public synchronized int getTargetObjectID() {
        return this.targetObjectID;
    }
    
    public synchronized float getTargetX() {
        return this.targetX;
    }
    
    public synchronized float getTargetZ() {
        return this.targetZ;
    }
    
    public synchronized float getTargetRot() {
        return this.targetRot;
    }
    
    public synchronized int getWalkType() {
        return this.walkType;
    }
    
    public synchronized boolean getBObjMovedFromOrig() {
        return this.bObjMovedFromOrig;
    }
    
    public synchronized void setResourcePriority(final int resourcePriority) {
        this.resourcePriority = resourcePriority;
    }
    
    public synchronized void setTargetObjectID(final int targetObjectID) {
        this.targetObjectID = targetObjectID;
    }
    
    public synchronized void setTargetX(final float targetX) {
        this.targetX = targetX;
    }
    
    public synchronized void setTargetZ(final float targetZ) {
        this.targetZ = targetZ;
    }
    
    public synchronized void setTargetRot(final float targetRot) {
        this.targetRot = targetRot;
    }
    
    public synchronized void setWalkType(final int walkType) {
        this.walkType = walkType;
    }
    
    public synchronized void setBObjMovedFromOrig(final boolean bObjMovedFromOrig) {
        this.bObjMovedFromOrig = bObjMovedFromOrig;
    }
    
    public StagingInfoWME(final int resourcePriority, final int targetObjectID, final float targetX, final float targetZ, final float targetRot, final int walkType) {
        this.resourcePriority = resourcePriority;
        this.targetObjectID = targetObjectID;
        this.targetX = targetX;
        this.targetZ = targetZ;
        this.targetRot = targetRot;
        this.walkType = walkType;
        this.bObjMovedFromOrig = false;
    }
    
    public StagingInfoWME() {
    }
}
