package facade.characters.wmedef;

import wm.TimeStampedWME;

public class BeatFlagWME extends TimeStampedWME
{
    private boolean bVal;
    private int iVal;
    private float fVal;
    private String sVal;
    
    public synchronized boolean getBVal() {
        return this.bVal;
    }
    
    public synchronized int getIVal() {
        return this.iVal;
    }
    
    public synchronized float getFVal() {
        return this.fVal;
    }
    
    public synchronized String getSVal() {
        return this.sVal;
    }
    
    public synchronized void setBVal(final boolean bVal) {
        this.bVal = bVal;
    }
    
    public synchronized void setIVal(final int iVal) {
        this.iVal = iVal;
    }
    
    public synchronized void setFVal(final float fVal) {
        this.fVal = fVal;
    }
    
    public synchronized void setSVal(final String sVal) {
        this.sVal = sVal;
    }
    
    public BeatFlagWME() {
        this.bVal = false;
        this.iVal = 0;
        this.fVal = 0.0f;
        this.sVal = "";
    }
    
    public BeatFlagWME(final boolean bVal) {
        this.bVal = bVal;
        this.iVal = 0;
        this.fVal = 0.0f;
        this.sVal = "";
    }
    
    public BeatFlagWME(final int iVal) {
        this.bVal = false;
        this.iVal = iVal;
        this.fVal = 0.0f;
        this.sVal = "";
    }
    
    public BeatFlagWME(final float fVal) {
        this.bVal = false;
        this.iVal = 0;
        this.fVal = fVal;
        this.sVal = "";
    }
    
    public BeatFlagWME(final String sVal) {
        this.bVal = false;
        this.iVal = 0;
        this.fVal = 0.0f;
        this.sVal = sVal;
    }
}
