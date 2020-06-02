package facade.characters.wmedef;

import wm.TimeStampedWME;

public class BeatC2TGGlueWME extends TimeStampedWME
{
    private int who;
    private boolean bFuriousOrUpset;
    private boolean bSwitchedToKitchen;
    
    public synchronized int getWho() {
        return this.who;
    }
    
    public synchronized boolean getBFuriousOrUpset() {
        return this.bFuriousOrUpset;
    }
    
    public synchronized boolean getBSwitchedToKitchen() {
        return this.bSwitchedToKitchen;
    }
    
    public synchronized void setWho(final int who) {
        this.who = who;
    }
    
    public synchronized void setBFuriousOrUpset(final boolean bFuriousOrUpset) {
        this.bFuriousOrUpset = bFuriousOrUpset;
    }
    
    public synchronized void setBSwitchedToKitchen(final boolean bSwitchedToKitchen) {
        this.bSwitchedToKitchen = bSwitchedToKitchen;
    }
    
    public BeatC2TGGlueWME(final int who, final boolean bFuriousOrUpset, final boolean bSwitchedToKitchen) {
        this.who = who;
        this.bFuriousOrUpset = bFuriousOrUpset;
        this.bSwitchedToKitchen = bSwitchedToKitchen;
    }
}
