package facade.characters.wmedef;

import wm.WME;

public class BeatGoalStatusWME extends WME
{
    private String bgSig;
    private boolean bCommitPointReached;
    private boolean bGistPointReached;
    private boolean bLetBeatGoalFinish;
    
    public synchronized String getBgSig() {
        return this.bgSig;
    }
    
    public synchronized void setBgSig(final String bgSig) {
        this.bgSig = bgSig;
    }
    
    public synchronized boolean getBCommitPointReached() {
        return this.bCommitPointReached;
    }
    
    public synchronized void setBCommitPointReached(final boolean bCommitPointReached) {
        this.bCommitPointReached = bCommitPointReached;
    }
    
    public synchronized boolean getBGistPointReached() {
        return this.bGistPointReached;
    }
    
    public synchronized void setBGistPointReached(final boolean bGistPointReached) {
        this.bGistPointReached = bGistPointReached;
    }
    
    public synchronized boolean getBLetBeatGoalFinish() {
        return this.bLetBeatGoalFinish;
    }
    
    public synchronized void setBLetBeatGoalFinish(final boolean bLetBeatGoalFinish) {
        this.bLetBeatGoalFinish = bLetBeatGoalFinish;
    }
    
    public BeatGoalStatusWME(final String bgSig, final boolean bCommitPointReached, final boolean bGistPointReached, final boolean bLetBeatGoalFinish) {
        this.bgSig = bgSig;
        this.bCommitPointReached = bCommitPointReached;
        this.bGistPointReached = bGistPointReached;
        this.bLetBeatGoalFinish = bLetBeatGoalFinish;
    }
    
    public BeatGoalStatusWME() {
    }
}
