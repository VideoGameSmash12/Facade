package facade.characters.grace.java;

import wm.WME;

public class DoGestureTempWME extends WME
{
    private int val;
    
    public synchronized int getVal() {
        return this.val;
    }
    
    public synchronized void setVal(final int val) {
        this.val = val;
    }
    
    public DoGestureTempWME(final int val) {
        this.val = val;
    }
    
    public DoGestureTempWME() {
    }
}
