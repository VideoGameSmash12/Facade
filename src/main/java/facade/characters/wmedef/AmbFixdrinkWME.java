package facade.characters.wmedef;

import facade.util.DAType;
import wm.WME;

public class AmbFixdrinkWME extends WME implements DAType
{
    private boolean bActiveThisSession;
    private boolean bActiveThisBeat;
    private boolean bActiveThisBeatgoal;
    private int beatCtrItLastHappened;
    private int playerDrink;
    private int tripDrink;
    private int graceDrink;
    
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
    
    public synchronized int getPlayerDrink() {
        return this.playerDrink;
    }
    
    public synchronized int getTripDrink() {
        return this.tripDrink;
    }
    
    public synchronized int getGraceDrink() {
        return this.graceDrink;
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
    
    public synchronized void setPlayerDrink(final int playerDrink) {
        this.playerDrink = playerDrink;
    }
    
    public synchronized void setTripDrink(final int tripDrink) {
        this.tripDrink = tripDrink;
    }
    
    public synchronized void setGraceDrink(final int graceDrink) {
        this.graceDrink = graceDrink;
    }
    
    public AmbFixdrinkWME() {
        this.bActiveThisSession = false;
        this.bActiveThisBeat = false;
        this.bActiveThisBeatgoal = false;
        this.beatCtrItLastHappened = 0;
        this.playerDrink = 4998;
        this.tripDrink = 4998;
        this.graceDrink = 4998;
    }
}
