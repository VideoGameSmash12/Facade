package facade.characters.wmedef;

import wm.WME;

public class CurrentTimeWME extends WME
{
    private long currentTime;
    
    public synchronized long getCurrentTime() {
        return this.currentTime;
    }
    
    public synchronized void setCurrentTime(final int n) {
        this.currentTime = n;
    }
    
    public CurrentTimeWME(final long currentTime) {
        this.currentTime = currentTime;
    }
    
    public CurrentTimeWME() {
    }
}
