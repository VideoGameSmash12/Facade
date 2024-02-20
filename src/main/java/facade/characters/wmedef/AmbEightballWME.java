package facade.characters.wmedef;

import wm.TimeStampedWME;

public class AmbEightballWME extends TimeStampedWME
{
    private boolean bActiveThisSession;
    private boolean bActiveThisBeat;
    private boolean bActiveThisBeatgoal;
    private int readingCtr;
    private int beatCtrItLastHappened;
    private int phraseSpoken;
    private int prevMoodValue;
    private boolean bHoldingEightballTempVal;
    
    public synchronized boolean getBActiveThisSession() {
        return this.bActiveThisSession;
    }
    
    public synchronized boolean getBActiveThisBeat() {
        return this.bActiveThisBeat;
    }
    
    public synchronized boolean getBActiveThisBeatgoal() {
        return this.bActiveThisBeatgoal;
    }
    
    public synchronized int getReadingCtr() {
        return this.readingCtr;
    }
    
    public synchronized int getBeatCtrItLastHappened() {
        return this.beatCtrItLastHappened;
    }
    
    public synchronized int getPhraseSpoken() {
        return this.phraseSpoken;
    }
    
    public synchronized int getPrevMoodValue() {
        return this.prevMoodValue;
    }
    
    public synchronized boolean getBHoldingEightballTempVal() {
        return this.bHoldingEightballTempVal;
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
    
    public synchronized void setReadingCtr(final int readingCtr) {
        this.readingCtr = readingCtr;
    }
    
    public synchronized void setBeatCtrItLastHappened(final int beatCtrItLastHappened) {
        this.beatCtrItLastHappened = beatCtrItLastHappened;
    }
    
    public synchronized void setPhraseSpoken(final int phraseSpoken) {
        this.phraseSpoken = phraseSpoken;
    }
    
    public synchronized void setPrevMoodValue(final int prevMoodValue) {
        this.prevMoodValue = prevMoodValue;
    }
    
    public synchronized void setBHoldingEightballTempVal(final boolean bHoldingEightballTempVal) {
        this.bHoldingEightballTempVal = bHoldingEightballTempVal;
    }
    
    public AmbEightballWME() {
        this.bActiveThisSession = false;
        this.bActiveThisBeat = false;
        this.bActiveThisBeatgoal = false;
        this.readingCtr = 0;
        this.beatCtrItLastHappened = 0;
        this.phraseSpoken = -1;
        this.prevMoodValue = -1;
        this.bHoldingEightballTempVal = false;
    }
}
