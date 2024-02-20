package facade.characters.wmedef;

import wm.TimeStampedWME;

public class AmbMetacommWME extends TimeStampedWME
{
    private boolean bActiveThisSession;
    private boolean bActiveThisBeat;
    private boolean bActiveThisBeatgoal;
    private int prevAffinity;
    private boolean bAffinityChangeFromNDone;
    private boolean bAffinityChangeSwitchDone;
    
    public synchronized boolean getBActiveThisSession() {
        return this.bActiveThisSession;
    }
    
    public synchronized boolean getBActiveThisBeat() {
        return this.bActiveThisBeat;
    }
    
    public synchronized boolean getBActiveThisBeatgoal() {
        return this.bActiveThisBeatgoal;
    }
    
    public synchronized int getPrevAffinity() {
        return this.prevAffinity;
    }
    
    public synchronized boolean getBAffinityChangeFromNDone() {
        return this.bAffinityChangeFromNDone;
    }
    
    public synchronized boolean getBAffinityChangeSwitchDone() {
        return this.bAffinityChangeSwitchDone;
    }
    
    public synchronized void setBActiveThisSession(final boolean bActiveThisSession) {
        this.bActiveThisSession = bActiveThisSession;
    }
    
    public synchronized void setBActiveThisBeat(final boolean bActiveThisBeat) {
        this.bActiveThisBeat = bActiveThisBeat;
    }
    
    public synchronized void setBActiveThisBeatgoal(final boolean bActiveThisBeatgoal) {
        this.bActiveThisBeatgoal = bActiveThisBeatgoal;
    }
    
    public synchronized void setPrevAffinity(final int prevAffinity) {
        this.prevAffinity = prevAffinity;
    }
    
    public synchronized void setBAffinityChangeFromNDone(final boolean bAffinityChangeFromNDone) {
        this.bAffinityChangeFromNDone = bAffinityChangeFromNDone;
    }
    
    public synchronized void setBAffinityChangeSwitchDone(final boolean bAffinityChangeSwitchDone) {
        this.bAffinityChangeSwitchDone = bAffinityChangeSwitchDone;
    }
    
    public AmbMetacommWME() {
        this.bActiveThisSession = false;
        this.bActiveThisBeat = false;
        this.bActiveThisBeatgoal = false;
        this.prevAffinity = 0;
        this.bAffinityChangeFromNDone = false;
        this.bAffinityChangeSwitchDone = false;
    }
}
