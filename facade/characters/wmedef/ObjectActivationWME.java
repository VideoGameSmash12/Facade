package facade.characters.wmedef;

import wm.TransientWME;

public class ObjectActivationWME extends TransientWME
{
    private int objectID;
    private int activationID;
    private int activatorID;
    
    public synchronized int getObjectID() {
        return this.objectID;
    }
    
    public synchronized int getActivationID() {
        return this.activationID;
    }
    
    public synchronized int getActivatorID() {
        return this.activatorID;
    }
    
    public synchronized void setObjectID(final int objectID) {
        this.objectID = objectID;
    }
    
    public synchronized void setActivationID(final int activationID) {
        this.activationID = activationID;
    }
    
    public synchronized void setActivatorID(final int activatorID) {
        this.activatorID = activatorID;
    }
    
    public ObjectActivationWME(final int objectID, final int activationID, final int activatorID) {
        this.objectID = objectID;
        this.activationID = activationID;
        this.activatorID = activatorID;
    }
    
    public ObjectActivationWME() {
    }
}
