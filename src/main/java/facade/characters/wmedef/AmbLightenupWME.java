package facade.characters.wmedef;

import wm.TimeStampedWME;

public class AmbLightenupWME extends TimeStampedWME
{
    private boolean bActiveThisSession;
    private boolean bActiveThisBeat;
    private boolean bActiveThisBeatgoal;
    private int beatCtrItLastHappened;
    private int tempVal;
    
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
    
    public synchronized int getTempVal() {
        return this.tempVal;
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
    
    public synchronized void setTempVal(final int tempVal) {
        this.tempVal = tempVal;
    }
    
    public AmbLightenupWME() {
        this.bActiveThisSession = false;
        this.bActiveThisBeat = false;
        this.bActiveThisBeatgoal = false;
        this.beatCtrItLastHappened = 0;
        this.tempVal = 0;
    }
}
