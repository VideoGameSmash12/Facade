package facade.characters.trip.java;

import wm.WME;

public class TGChooseMixinTempWME extends WME
{
    private int val;
    
    public synchronized int getVal() {
        return this.val;
    }
    
    public synchronized void setVal(final int val) {
        this.val = val;
    }
    
    public TGChooseMixinTempWME(final int val) {
        this.val = val;
    }
    
    public TGChooseMixinTempWME() {
    }
}
