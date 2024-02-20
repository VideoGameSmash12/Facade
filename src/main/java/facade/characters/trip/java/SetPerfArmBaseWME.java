package facade.characters.trip.java;

import wm.WME;

public class SetPerfArmBaseWME extends WME
{
    private int armLBase;
    private int armRBase;
    private int armsBothBase;
    
    public synchronized int getArmLBase() {
        return this.armLBase;
    }
    
    public synchronized int getArmRBase() {
        return this.armRBase;
    }
    
    public synchronized int getArmsBothBase() {
        return this.armsBothBase;
    }
    
    public synchronized void setArmLBase(final int armLBase) {
        this.armLBase = armLBase;
    }
    
    public synchronized void setArmRBase(final int armRBase) {
        this.armRBase = armRBase;
    }
    
    public synchronized void setArmsBothBase(final int armsBothBase) {
        this.armsBothBase = armsBothBase;
    }
    
    public SetPerfArmBaseWME(final int armLBase, final int armRBase, final int armsBothBase) {
        this.armLBase = armLBase;
        this.armRBase = armRBase;
        this.armsBothBase = armsBothBase;
    }
    
    public SetPerfArmBaseWME() {
    }
}
