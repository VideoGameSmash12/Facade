package facade.characters.wmedef;

import wm.WME;

public class PlayerRecentlyTypedTextWME extends WME
{
    private boolean b;
    private long timestamp;
    private long graceIgnoreTillTimestamp;
    private long tripIgnoreTillTimestamp;
    
    public synchronized boolean getB() {
        return this.b;
    }
    
    public synchronized long getTimestamp() {
        return this.timestamp;
    }
    
    public synchronized long getGraceIgnoreTillTimestamp() {
        return this.graceIgnoreTillTimestamp;
    }
    
    public synchronized long getTripIgnoreTillTimestamp() {
        return this.tripIgnoreTillTimestamp;
    }
    
    public synchronized void setB(final boolean b) {
        this.b = b;
    }
    
    public synchronized void setTimestamp(final long timestamp) {
        this.timestamp = timestamp;
    }
    
    public synchronized void setGraceIgnoreTillTimestamp(final long graceIgnoreTillTimestamp) {
        this.graceIgnoreTillTimestamp = graceIgnoreTillTimestamp;
    }
    
    public synchronized void setTripIgnoreTillTimestamp(final long tripIgnoreTillTimestamp) {
        this.tripIgnoreTillTimestamp = tripIgnoreTillTimestamp;
    }
    
    public PlayerRecentlyTypedTextWME(final boolean b, final long tripIgnoreTillTimestamp) {
        this.b = b;
        this.timestamp = tripIgnoreTillTimestamp;
        this.graceIgnoreTillTimestamp = tripIgnoreTillTimestamp;
        this.tripIgnoreTillTimestamp = tripIgnoreTillTimestamp;
    }
    
    public PlayerRecentlyTypedTextWME() {
    }
}
