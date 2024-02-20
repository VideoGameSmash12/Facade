package facade.characters.wmedef;

import wm.TimeStampedWME;

public class DAMiscStatusWME extends TimeStampedWME
{
    private boolean bHandlersActive;
    private long lastDAHandlersActiveCheck;
    private long lastDACommitCheck;
    private long lastReferToObjByActivation;
    
    public synchronized boolean getBHandlersActive() {
        return this.bHandlersActive;
    }
    
    public synchronized long getLastDAHandlersActiveCheck() {
        return this.lastDAHandlersActiveCheck;
    }
    
    public synchronized long getLastDACommitCheck() {
        return this.lastDACommitCheck;
    }
    
    public synchronized long getLastReferToObjByActivation() {
        return this.lastReferToObjByActivation;
    }
    
    public synchronized void setBHandlersActive(final boolean bHandlersActive) {
        this.bHandlersActive = bHandlersActive;
    }
    
    public synchronized void setLastDAHandlersActiveCheck(final long lastDAHandlersActiveCheck) {
        this.lastDAHandlersActiveCheck = lastDAHandlersActiveCheck;
    }
    
    public synchronized void setLastDACommitCheck(final long lastDACommitCheck) {
        this.lastDACommitCheck = lastDACommitCheck;
    }
    
    public synchronized void setLastReferToObjByActivation(final long lastReferToObjByActivation) {
        this.lastReferToObjByActivation = lastReferToObjByActivation;
    }
    
    public DAMiscStatusWME() {
        this.bHandlersActive = false;
        this.lastDAHandlersActiveCheck = 0L;
        this.lastDACommitCheck = 0L;
        this.lastReferToObjByActivation = 0L;
    }
}
