package facade.characters.wmedef;

import wm.TimeStampedWME;

public class EventWME extends TimeStampedWME
{
    private int type;
    private int charID;
    private int objID;
    private int action;
    private boolean bVal;
    private int iVal;
    private int iVal2;
    private float fVal;
    
    public synchronized int getType() {
        return this.type;
    }
    
    public synchronized int getCharID() {
        return this.charID;
    }
    
    public synchronized int getObjID() {
        return this.objID;
    }
    
    public synchronized int getAction() {
        return this.action;
    }
    
    public synchronized boolean getBVal() {
        return this.bVal;
    }
    
    public synchronized int getIVal() {
        return this.iVal;
    }
    
    public synchronized int getIVal2() {
        return this.iVal2;
    }
    
    public synchronized float getFVal() {
        return this.fVal;
    }
    
    public synchronized void setType(final int type) {
        this.type = type;
    }
    
    public synchronized void setcharID(final int charID) {
        this.charID = charID;
    }
    
    public synchronized void setObjID(final int objID) {
        this.objID = objID;
    }
    
    public synchronized void setAction(final int action) {
        this.action = action;
    }
    
    public synchronized void setBVal(final boolean bVal) {
        this.bVal = bVal;
    }
    
    public synchronized void setIVal(final int iVal) {
        this.iVal = iVal;
    }
    
    public synchronized void setIVal2(final int iVal2) {
        this.iVal2 = iVal2;
    }
    
    public synchronized void setFVal(final float fVal) {
        this.fVal = fVal;
    }
    
    public EventWME(final int type, final int charID, final int objID, final int action, final boolean bVal, final int iVal, final int iVal2, final float fVal) {
        this.type = type;
        this.charID = charID;
        this.objID = objID;
        this.action = action;
        this.bVal = bVal;
        this.iVal = iVal;
        this.iVal2 = iVal2;
        this.fVal = fVal;
    }
}
