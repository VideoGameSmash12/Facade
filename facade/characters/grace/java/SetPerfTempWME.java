package facade.characters.grace.java;

import wm.WME;

public class SetPerfTempWME extends WME
{
    private boolean bVal;
    
    public synchronized boolean getBVal() {
        return this.bVal;
    }
    
    public synchronized void setBVal(final boolean bVal) {
        this.bVal = bVal;
    }
    
    public SetPerfTempWME(final boolean bVal) {
        this.bVal = bVal;
    }
    
    public SetPerfTempWME() {
    }
}
