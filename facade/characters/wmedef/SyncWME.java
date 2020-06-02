package facade.characters.wmedef;

import wm.WME;

public class SyncWME extends WME
{
    private int val;
    
    public synchronized int getVal() {
        return this.val;
    }
    
    public synchronized void setVal(final int val) {
        this.val = val;
    }
    
    public SyncWME() {
        this.val = 0;
    }
}
