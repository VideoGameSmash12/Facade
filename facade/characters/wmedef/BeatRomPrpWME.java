package facade.characters.wmedef;

import wm.TimeStampedWME;

public class BeatRomPrpWME extends TimeStampedWME
{
    private boolean bVal;
    private int sprite;
    private float graceWalkToX;
    private float graceWalkToY;
    private float graceWalkToZ;
    private float graceWalkToRot;
    private float tripWalkToX;
    private float tripWalkToY;
    private float tripWalkToZ;
    private float tripWalkToRot;
    private String sVal;
    private long tempMillis;
    
    public synchronized boolean getBVal() {
        return this.bVal;
    }
    
    public synchronized int getSprite() {
        return this.sprite;
    }
    
    public synchronized float getGraceWalkToX() {
        return this.graceWalkToX;
    }
    
    public synchronized float getGraceWalkToY() {
        return this.graceWalkToY;
    }
    
    public synchronized float getGraceWalkToZ() {
        return this.graceWalkToZ;
    }
    
    public synchronized float getGraceWalkToRot() {
        return this.graceWalkToRot;
    }
    
    public synchronized float getTripWalkToX() {
        return this.tripWalkToX;
    }
    
    public synchronized float getTripWalkToY() {
        return this.tripWalkToY;
    }
    
    public synchronized float getTripWalkToZ() {
        return this.tripWalkToZ;
    }
    
    public synchronized float getTripWalkToRot() {
        return this.tripWalkToRot;
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
    
    public synchronized void setSprite(final int sprite) {
        this.sprite = sprite;
    }
    
    public synchronized void setGraceWalkToX(final float graceWalkToX) {
        this.graceWalkToX = graceWalkToX;
    }
    
    public synchronized void setGraceWalkToY(final float graceWalkToY) {
        this.graceWalkToY = graceWalkToY;
    }
    
    public synchronized void setGraceWalkToZ(final float graceWalkToZ) {
        this.graceWalkToZ = graceWalkToZ;
    }
    
    public synchronized void setGraceWalkToRot(final float graceWalkToRot) {
        this.graceWalkToRot = graceWalkToRot;
    }
    
    public synchronized void setTripWalkToX(final float tripWalkToX) {
        this.tripWalkToX = tripWalkToX;
    }
    
    public synchronized void setTripWalkToY(final float tripWalkToY) {
        this.tripWalkToY = tripWalkToY;
    }
    
    public synchronized void setTripWalkToZ(final float tripWalkToZ) {
        this.tripWalkToZ = tripWalkToZ;
    }
    
    public synchronized void setTripWalkToRot(final float tripWalkToRot) {
        this.tripWalkToRot = tripWalkToRot;
    }
    
    public synchronized void setSVal(final String sVal) {
        this.sVal = sVal;
    }
    
    public synchronized void setTempMillis(final long tempMillis) {
        this.tempMillis = tempMillis;
    }
    
    public BeatRomPrpWME() {
        this.bVal = false;
        this.sprite = 0;
        this.graceWalkToX = 0.0f;
        this.graceWalkToY = 0.0f;
        this.graceWalkToZ = 0.0f;
        this.graceWalkToRot = 0.0f;
        this.tripWalkToX = 0.0f;
        this.tripWalkToY = 0.0f;
        this.tripWalkToZ = 0.0f;
        this.tripWalkToRot = 0.0f;
        this.sVal = "";
        this.tempMillis = 0L;
    }
}
