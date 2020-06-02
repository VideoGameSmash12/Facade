package facade.characters.wmedef;

import wm.TimeStampedWME;

public class AmbSipdrinkWME extends TimeStampedWME
{
    private boolean bActiveThisSession;
    private boolean bActiveThisBeat;
    private boolean bActiveThisBeatgoal;
    private int beatCtrItLastHappened;
    private int chance;
    private int finishScript;
    
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
    
    public synchronized int getChance() {
        return this.chance;
    }
    
    public synchronized int getFinishScript() {
        return this.finishScript;
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
    
    public synchronized void setChance(final int chance) {
        this.chance = chance;
    }
    
    public synchronized void setFinishScript(final int finishScript) {
        this.finishScript = finishScript;
    }
    
    public AmbSipdrinkWME() {
        this.bActiveThisSession = false;
        this.bActiveThisBeat = false;
        this.bActiveThisBeatgoal = false;
        this.beatCtrItLastHappened = 0;
        this.chance = 0;
        this.finishScript = 0;
    }
}
