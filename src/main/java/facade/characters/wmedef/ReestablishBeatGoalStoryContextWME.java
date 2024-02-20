package facade.characters.wmedef;

import wm.TimeStampedWME;

public class ReestablishBeatGoalStoryContextWME extends TimeStampedWME
{
    private boolean bVal;
    
    public synchronized boolean getBVal() {
        return this.bVal;
    }
    
    public synchronized void setBVal(final boolean bVal) {
        this.bVal = bVal;
    }
    
    public ReestablishBeatGoalStoryContextWME() {
        this.bVal = false;
    }
    
    public ReestablishBeatGoalStoryContextWME(final boolean bVal) {
        this.bVal = bVal;
    }
}
