package facade.characters.wmedef;

import wm.WME;

public class PlayerCrowdWME extends WME
{
    private long timestamp;
    
    public synchronized long getTimestamp() {
        return this.timestamp;
    }
    
    public synchronized void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
    
    public PlayerCrowdWME(final long timestamp) {
        this.timestamp = timestamp;
    }
    
    public PlayerCrowdWME() {
    }
}
