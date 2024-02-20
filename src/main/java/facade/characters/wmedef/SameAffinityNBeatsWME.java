package facade.characters.wmedef;

import dramaman.runtime.DramaManagerConstants;
import wm.WME;

public class SameAffinityNBeatsWME extends WME implements DramaManagerConstants
{
    private int beatCount;
    private int targetAffinity;
    
    public synchronized int getBeatCount() {
        return this.beatCount;
    }
    
    public synchronized int getTargetAffinity() {
        return this.targetAffinity;
    }
    
    public synchronized void setBeatCount(final int beatCount) {
        this.beatCount = beatCount;
    }
    
    public synchronized void setTargetAffinity(final int targetAffinity) {
        this.targetAffinity = targetAffinity;
    }
    
    public SameAffinityNBeatsWME(final int beatCount, final int targetAffinity) {
        this.beatCount = beatCount;
        this.targetAffinity = targetAffinity;
    }
    
    public SameAffinityNBeatsWME() {
        this.beatCount = 0;
        this.targetAffinity = 0;
    }
}
