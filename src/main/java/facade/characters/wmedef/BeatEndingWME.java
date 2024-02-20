package facade.characters.wmedef;

import wm.TimeStampedWME;

public class BeatEndingWME extends TimeStampedWME
{
    private int rxn;
    private int ctr;
    
    public synchronized int getRxn() {
        return this.rxn;
    }
    
    public synchronized int getCtr() {
        return this.ctr;
    }
    
    public synchronized void setRxn(final int rxn) {
        this.rxn = rxn;
    }
    
    public synchronized void setCtr(final int ctr) {
        this.ctr = ctr;
    }
    
    public BeatEndingWME() {
        this.rxn = -1;
        this.ctr = 0;
    }
}
