package facade.characters.wmedef;

import wm.WME;

public class PlayerUncoopWME extends WME
{
    boolean bCurrentlyUncooperative;
    boolean bNotSpeaking;
    boolean bNotMoving;
    boolean bActingWeird;
    boolean bFidgety;
    boolean bLeavingForKitchen;
    boolean bLeavingApartment;
    boolean bLeftApartment;
    boolean bMonitorAntisocial;
    boolean bMonitorLeavingApartment;
    boolean bMonitorLeavingForKitchen;
    float prevPlayerX;
    float prevPlayerZ;
    float prevPlayerRot;
    long millisLastSpoke;
    long millisLastStill;
    long millisLastBeganMoving;
    long millisStartedLeavingApartment;
    long millisStartedLeavingForKitchen;
    long millisLastGeneratedUncoopDA;
    long millisLastGeneratedLeavingDA;
    int weirdObjPlacementDecayCtr;
    int couchSitsDecayCtr;
    float leavingForKitchenZ;
    
    public synchronized boolean getBCurrentlyUncooperative() {
        return this.bCurrentlyUncooperative;
    }
    
    public synchronized boolean getBNotSpeaking() {
        return this.bNotSpeaking;
    }
    
    public synchronized boolean getBNotMoving() {
        return this.bNotMoving;
    }
    
    public synchronized boolean getBActingWeird() {
        return this.bActingWeird;
    }
    
    public synchronized boolean getBFidgety() {
        return this.bFidgety;
    }
    
    public synchronized boolean getBLeavingForKitchen() {
        return this.bLeavingForKitchen;
    }
    
    public synchronized boolean getBLeavingApartment() {
        return this.bLeavingApartment;
    }
    
    public synchronized boolean getBLeftApartment() {
        return this.bLeftApartment;
    }
    
    public synchronized boolean getBMonitorAntisocial() {
        return this.bMonitorAntisocial;
    }
    
    public synchronized boolean getBMonitorLeavingApartment() {
        return this.bMonitorLeavingApartment;
    }
    
    public synchronized boolean getBMonitorLeavingForKitchen() {
        return this.bMonitorLeavingForKitchen;
    }
    
    public synchronized float getPrevPlayerX() {
        return this.prevPlayerX;
    }
    
    public synchronized float getPrevPlayerZ() {
        return this.prevPlayerZ;
    }
    
    public synchronized float getPrevPlayerRot() {
        return this.prevPlayerRot;
    }
    
    public synchronized long getMillisLastSpoke() {
        return this.millisLastSpoke;
    }
    
    public synchronized long getMillisLastStill() {
        return this.millisLastStill;
    }
    
    public synchronized long getMillisLastBeganMoving() {
        return this.millisLastBeganMoving;
    }
    
    public synchronized long getMillisStartedLeavingApartment() {
        return this.millisStartedLeavingApartment;
    }
    
    public synchronized long getMillisStartedLeavingForKitchen() {
        return this.millisStartedLeavingForKitchen;
    }
    
    public synchronized long getMillisLastGeneratedUncoopDA() {
        return this.millisLastGeneratedUncoopDA;
    }
    
    public synchronized long getMillisLastGeneratedLeavingDA() {
        return this.millisLastGeneratedLeavingDA;
    }
    
    public synchronized int getWeirdObjPlacementDecayCtr() {
        return this.weirdObjPlacementDecayCtr;
    }
    
    public synchronized int getCouchSitsDecayCtr() {
        return this.couchSitsDecayCtr;
    }
    
    public synchronized float getLeavingForKitchenZ() {
        return this.leavingForKitchenZ;
    }
    
    public synchronized void setBCurrentlyUncooperative(final boolean bCurrentlyUncooperative) {
        this.bCurrentlyUncooperative = bCurrentlyUncooperative;
    }
    
    public synchronized void setBNotSpeaking(final boolean bNotSpeaking) {
        this.bNotSpeaking = bNotSpeaking;
    }
    
    public synchronized void setBNotMoving(final boolean bNotMoving) {
        this.bNotMoving = bNotMoving;
    }
    
    public synchronized void setBActingWeird(final boolean bActingWeird) {
        this.bActingWeird = bActingWeird;
    }
    
    public synchronized void setBFidgety(final boolean bFidgety) {
        this.bFidgety = bFidgety;
    }
    
    public synchronized void setBLeavingForKitchen(final boolean bLeavingForKitchen) {
        this.bLeavingForKitchen = bLeavingForKitchen;
    }
    
    public synchronized void setBLeavingApartment(final boolean bLeavingApartment) {
        this.bLeavingApartment = bLeavingApartment;
    }
    
    public synchronized void setBLeftApartment(final boolean bLeftApartment) {
        this.bLeftApartment = bLeftApartment;
    }
    
    public synchronized void setBMonitorAntisocial(final boolean bMonitorAntisocial) {
        this.bMonitorAntisocial = bMonitorAntisocial;
    }
    
    public synchronized void setBMonitorLeavingApartment(final boolean bMonitorLeavingApartment) {
        this.bMonitorLeavingApartment = bMonitorLeavingApartment;
    }
    
    public synchronized void setBMonitorLeavingForKitchen(final boolean bMonitorLeavingForKitchen) {
        this.bMonitorLeavingForKitchen = bMonitorLeavingForKitchen;
    }
    
    public synchronized void setPrevPlayerX(final float prevPlayerX) {
        this.prevPlayerX = prevPlayerX;
    }
    
    public synchronized void setPrevPlayerZ(final float prevPlayerZ) {
        this.prevPlayerZ = prevPlayerZ;
    }
    
    public synchronized void setPrevPlayerRot(final float prevPlayerRot) {
        this.prevPlayerRot = prevPlayerRot;
    }
    
    public synchronized void setMillisLastSpoke(final long millisLastSpoke) {
        this.millisLastSpoke = millisLastSpoke;
    }
    
    public synchronized void setMillisLastStill(final long millisLastStill) {
        this.millisLastStill = millisLastStill;
    }
    
    public synchronized void setMillisLastBeganMoving(final long millisLastBeganMoving) {
        this.millisLastBeganMoving = millisLastBeganMoving;
    }
    
    public synchronized void setMillisStartedLeavingApartment(final long millisStartedLeavingApartment) {
        this.millisStartedLeavingApartment = millisStartedLeavingApartment;
    }
    
    public synchronized void setMillisStartedLeavingForKitchen(final long millisStartedLeavingForKitchen) {
        this.millisStartedLeavingForKitchen = millisStartedLeavingForKitchen;
    }
    
    public synchronized void setMillisLastGeneratedUncoopDA(final long millisLastGeneratedUncoopDA) {
        this.millisLastGeneratedUncoopDA = millisLastGeneratedUncoopDA;
    }
    
    public synchronized void setMillisLastGeneratedLeavingDA(final long millisLastGeneratedLeavingDA) {
        this.millisLastGeneratedLeavingDA = millisLastGeneratedLeavingDA;
    }
    
    public synchronized void setWeirdObjPlacementDecayCtr(final int weirdObjPlacementDecayCtr) {
        this.weirdObjPlacementDecayCtr = weirdObjPlacementDecayCtr;
    }
    
    public synchronized void setCouchSitsDecayCtr(final int couchSitsDecayCtr) {
        this.couchSitsDecayCtr = couchSitsDecayCtr;
    }
    
    public synchronized void setLeavingForKitchenZ(final float leavingForKitchenZ) {
        this.leavingForKitchenZ = leavingForKitchenZ;
    }
    
    public PlayerUncoopWME() {
        this.bCurrentlyUncooperative = false;
        this.bNotSpeaking = false;
        this.bNotMoving = false;
        this.bActingWeird = false;
        this.bFidgety = false;
        this.bLeavingForKitchen = false;
        this.bLeavingApartment = false;
        this.bLeftApartment = false;
        this.bMonitorAntisocial = false;
        this.bMonitorLeavingApartment = false;
        this.bMonitorLeavingForKitchen = false;
        this.prevPlayerX = 0.0f;
        this.prevPlayerZ = 0.0f;
        this.prevPlayerRot = 0.0f;
        this.millisLastSpoke = 0L;
        this.millisLastStill = 0L;
        this.millisLastBeganMoving = 0L;
        this.millisStartedLeavingApartment = 0L;
        this.millisStartedLeavingForKitchen = 0L;
        this.millisLastGeneratedUncoopDA = 0L;
        this.millisLastGeneratedLeavingDA = 0L;
        this.weirdObjPlacementDecayCtr = 0;
        this.couchSitsDecayCtr = 0;
        this.leavingForKitchenZ = 0.0f;
    }
}
