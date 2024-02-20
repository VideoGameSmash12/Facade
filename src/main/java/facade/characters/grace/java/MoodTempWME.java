package facade.characters.grace.java;

import wm.WME;

public class MoodTempWME extends WME
{
    private int val;
    private boolean bVal;
    
    public synchronized int getVal() {
        return this.val;
    }
    
    public synchronized boolean getBVal() {
        return this.bVal;
    }
    
    public synchronized void setVal(final int val) {
        this.val = val;
    }
    
    public synchronized void setBVal(final boolean bVal) {
        this.bVal = bVal;
    }
    
    public MoodTempWME(final int val, final boolean bVal) {
        this.val = val;
        this.bVal = bVal;
    }
    
    public MoodTempWME() {
    }
}
