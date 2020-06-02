package facade.characters.wmedef;

import facade.util.PrintUtilities;
import abl.runtime.BehaviorWME;
import wm.WME;

public class BodyResourceWME extends WME
{
    private int resourceID;
    private BehaviorWME owner;
    private int resourcePriority;
    private int timeout;
    
    public synchronized String formatResourceID() {
        return PrintUtilities.bodyResource_EnumToString(this.getResourceID());
    }
    
    public synchronized String formatOwner() {
        if (this.owner != null) {
            return this.owner.getSignature();
        }
        return "null";
    }
    
    public synchronized int getResourceID() {
        return this.resourceID;
    }
    
    public synchronized BehaviorWME getOwner() {
        return this.owner;
    }
    
    public synchronized int getResourcePriority() {
        return this.resourcePriority;
    }
    
    public synchronized int getTimeout() {
        return this.timeout;
    }
    
    public synchronized void setResourceID(final int resourceID) {
        this.resourceID = resourceID;
    }
    
    public synchronized void setOwner(final BehaviorWME owner) {
        this.owner = owner;
    }
    
    public synchronized void setResourcePriority(final int resourcePriority) {
        this.resourcePriority = resourcePriority;
    }
    
    public synchronized void setTimeout(final int timeout) {
        this.timeout = timeout;
    }
    
    public BodyResourceWME(final int resourceID, final BehaviorWME owner, final int resourcePriority, final int timeout) {
        this.resourceID = resourceID;
        this.owner = owner;
        this.resourcePriority = resourcePriority;
        this.timeout = timeout;
    }
    
    public BodyResourceWME() {
    }
}
