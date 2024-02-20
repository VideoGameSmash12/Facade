package facade.characters.wmedef;

import wm.TimeStampedWME;

public class BeatFAskDrinkT2WME extends TimeStampedWME
{
    private boolean bGotFancySpecificRequest;
    private boolean bGotNonFancySpecificRequest;
    private int roundOfDrinks;
    private int whenToGoToBar;
    private int curDrinkIdea;
    private int tripDrinkIdea;
    private int graceDrinkIdea;
    private float fVal;
    private String sVal;
    private long tempMillis;
    
    public synchronized boolean getBGotFancySpecificRequest() {
        return this.bGotFancySpecificRequest;
    }
    
    public synchronized boolean getBGotNonFancySpecificRequest() {
        return this.bGotNonFancySpecificRequest;
    }
    
    public synchronized int getRoundOfDrinks() {
        return this.roundOfDrinks;
    }
    
    public synchronized int getWhenToGoToBar() {
        return this.whenToGoToBar;
    }
    
    public synchronized int getCurDrinkIdea() {
        return this.curDrinkIdea;
    }
    
    public synchronized int getTripDrinkIdea() {
        return this.tripDrinkIdea;
    }
    
    public synchronized int getGraceDrinkIdea() {
        return this.graceDrinkIdea;
    }
    
    public synchronized float getFVal() {
        return this.fVal;
    }
    
    public synchronized String getSVal() {
        return this.sVal;
    }
    
    public synchronized long getTempMillis() {
        return this.tempMillis;
    }
    
    public synchronized void setBGotFancySpecificRequest(final boolean bGotFancySpecificRequest) {
        this.bGotFancySpecificRequest = bGotFancySpecificRequest;
    }
    
    public synchronized void setBGotNonFancySpecificRequest(final boolean bGotNonFancySpecificRequest) {
        this.bGotNonFancySpecificRequest = bGotNonFancySpecificRequest;
    }
    
    public synchronized void setRoundOfDrinks(final int roundOfDrinks) {
        this.roundOfDrinks = roundOfDrinks;
    }
    
    public synchronized void setWhenToGoToBar(final int whenToGoToBar) {
        this.whenToGoToBar = whenToGoToBar;
    }
    
    public synchronized void setCurDrinkIdea(final int curDrinkIdea) {
        this.curDrinkIdea = curDrinkIdea;
    }
    
    public synchronized void setTripDrinkIdea(final int tripDrinkIdea) {
        this.tripDrinkIdea = tripDrinkIdea;
    }
    
    public synchronized void setGraceDrinkIdea(final int graceDrinkIdea) {
        this.graceDrinkIdea = graceDrinkIdea;
    }
    
    public synchronized void setFVal(final float fVal) {
        this.fVal = fVal;
    }
    
    public synchronized void setSVal(final String sVal) {
        this.sVal = sVal;
    }
    
    public synchronized void setTempMillis(final long tempMillis) {
        this.tempMillis = tempMillis;
    }
    
    public BeatFAskDrinkT2WME() {
        this.bGotFancySpecificRequest = false;
        this.bGotNonFancySpecificRequest = false;
        this.roundOfDrinks = 0;
        this.whenToGoToBar = 0;
        this.curDrinkIdea = 0;
        this.tripDrinkIdea = 0;
        this.graceDrinkIdea = 0;
        this.fVal = 0.0f;
        this.sVal = "";
        this.tempMillis = 0L;
    }
}
