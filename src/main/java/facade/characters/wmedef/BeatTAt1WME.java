package facade.characters.wmedef;

import wm.TimeStampedWME;

public class BeatTAt1WME extends TimeStampedWME
{
    private boolean bVal;
    private int numLures;
    private float fVal;
    private String sVal;
    private long tempMillis;
    
    public synchronized boolean getBVal() {
        return this.bVal;
    }
    
    public synchronized int getNumLures() {
        return this.numLures;
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
    
    public synchronized void setBVal(final boolean bVal) {
        this.bVal = bVal;
    }
    
    public synchronized void setNumLures(final int numLures) {
        this.numLures = numLures;
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
    
    public BeatTAt1WME() {
        this.bVal = false;
        this.numLures = 0;
        this.fVal = 0.0f;
        this.sVal = "";
        this.tempMillis = 0L;
    }
}
