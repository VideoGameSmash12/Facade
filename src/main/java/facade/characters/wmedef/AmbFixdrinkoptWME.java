package facade.characters.wmedef;

import wm.TimeStampedWME;

public class AmbFixdrinkoptWME extends TimeStampedWME
{
    private boolean bActiveThisSession;
    private boolean bActiveThisBeat;
    private boolean bActiveThisBeatgoal;
    private int beatCtrItLastHappened;
    private int which;
    
    public synchronized boolean getBActiveThisSession() {
        return this.bActiveThisSession;
    }
    
    public synchronized boolean getBActiveThisBeat() {
        return this.bActiveThisBeat;
    }
    
    public synchronized boolean getBActiveThisBeatgoal() {
        return this.bActiveThisBeatgoal;
    }
    
    public synchronized int getBeatCtrItLastHappened() {
        return this.beatCtrItLastHappened;
    }
    
    public synchronized int getWhich() {
        return this.which;
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
    
    public synchronized void setBeatCtrItLastHappened(final int beatCtrItLastHappened) {
        this.beatCtrItLastHappened = beatCtrItLastHappened;
    }
    
    public synchronized void setWhich(final int which) {
        this.which = which;
    }
    
    public AmbFixdrinkoptWME() {
        this.bActiveThisSession = false;
        this.bActiveThisBeat = false;
        this.bActiveThisBeatgoal = false;
        this.beatCtrItLastHappened = 0;
        this.which = -1;
    }
}
