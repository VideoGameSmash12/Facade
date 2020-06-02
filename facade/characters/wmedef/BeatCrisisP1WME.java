package facade.characters.wmedef;

import wm.TimeStampedWME;

public class BeatCrisisP1WME extends TimeStampedWME
{
    private int currentAccusationID;
    private int currentAccuserChr;
    private int currentAccusationPCType;
    private int currentAccusationPCParam;
    private int currentAccusedChr;
    private float graceX;
    private float graceZ;
    private float graceFaceRot;
    private float graceFaceAwayRot;
    private float tripX;
    private float tripZ;
    private float tripFaceRot;
    private float tripFaceAwayRot;
    private boolean bVal;
    private String sVal;
    
    public synchronized int getCurrentAccusationID() {
        return this.currentAccusationID;
    }
    
    public synchronized int getCurrentAccuserChr() {
        return this.currentAccuserChr;
    }
    
    public synchronized int getCurrentAccusationPCType() {
        return this.currentAccusationPCType;
    }
    
    public synchronized int getCurrentAccusationPCParam() {
        return this.currentAccusationPCParam;
    }
    
    public synchronized int getCurrentAccusedChr() {
        return this.currentAccusedChr;
    }
    
    public synchronized float getGraceX() {
        return this.graceX;
    }
    
    public synchronized float getGraceZ() {
        return this.graceZ;
    }
    
    public synchronized float getGraceFaceRot() {
        return this.graceFaceRot;
    }
    
    public synchronized float getGraceFaceAwayRot() {
        return this.graceFaceAwayRot;
    }
    
    public synchronized float getTripX() {
        return this.tripX;
    }
    
    public synchronized float getTripZ() {
        return this.tripZ;
    }
    
    public synchronized float getTripFaceRot() {
        return this.tripFaceRot;
    }
    
    public synchronized float getTripFaceAwayRot() {
        return this.tripFaceAwayRot;
    }
    
    public synchronized boolean getBVal() {
        return this.bVal;
    }
    
    public synchronized String getSVal() {
        return this.sVal;
    }
    
    public synchronized void setCurrentAccusationID(final int currentAccusationID) {
        this.currentAccusationID = currentAccusationID;
    }
    
    public synchronized void setCurrentAccuserChr(final int currentAccuserChr) {
        this.currentAccuserChr = currentAccuserChr;
    }
    
    public synchronized void setCurrentAccusationPCType(final int currentAccusationPCType) {
        this.currentAccusationPCType = currentAccusationPCType;
    }
    
    public synchronized void setCurrentAccusationPCParam(final int currentAccusationPCParam) {
        this.currentAccusationPCParam = currentAccusationPCParam;
    }
    
    public synchronized void setCurrentAccusedChr(final int currentAccusedChr) {
        this.currentAccusedChr = currentAccusedChr;
    }
    
    public synchronized void setGraceX(final float graceX) {
        this.graceX = graceX;
    }
    
    public synchronized void setGraceZ(final float graceZ) {
        this.graceZ = graceZ;
    }
    
    public synchronized void setGraceFaceRot(final float graceFaceRot) {
        this.graceFaceRot = graceFaceRot;
    }
    
    public synchronized void setGraceFaceAwayRot(final float graceFaceAwayRot) {
        this.graceFaceAwayRot = graceFaceAwayRot;
    }
    
    public synchronized void setTripX(final float tripX) {
        this.tripX = tripX;
    }
    
    public synchronized void setTripZ(final float tripZ) {
        this.tripZ = tripZ;
    }
    
    public synchronized void setTripFaceRot(final float tripFaceRot) {
        this.tripFaceRot = tripFaceRot;
    }
    
    public synchronized void setTripFaceAwayRot(final float tripFaceAwayRot) {
        this.tripFaceAwayRot = tripFaceAwayRot;
    }
    
    public synchronized void setBVal(final boolean bVal) {
        this.bVal = bVal;
    }
    
    public synchronized void setSVal(final String sVal) {
        this.sVal = sVal;
    }
    
    public BeatCrisisP1WME() {
        this.currentAccusationID = -1;
        this.currentAccuserChr = -1;
        this.currentAccusationPCType = -1;
        this.currentAccusationPCParam = -1;
        this.currentAccusedChr = -1;
        this.graceX = 0.0f;
        this.graceZ = 0.0f;
        this.graceFaceRot = 0.0f;
        this.graceFaceAwayRot = 0.0f;
        this.tripX = 0.0f;
        this.tripZ = 0.0f;
        this.tripFaceRot = 0.0f;
        this.tripFaceAwayRot = 0.0f;
        this.bVal = false;
        this.sVal = "";
    }
}
