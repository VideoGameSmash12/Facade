package facade.characters.wmedef;

import wm.WME;

public class MoodWME extends WME
{
    private int type;
    private int alt;
    private int strength;
    private int priority;
    private float decay;
    private int decayToType;
    private float burstDecay;
    private int charID1;
    private int charID2;
    private long decayAtMillis;
    private long burstDecayAtMillis;
    private boolean bTerminate;
    private float stagingConverseDist;
    private float stagingConverseOutwardAngleOffset;
    
    public synchronized int getType() {
        return this.type;
    }
    
    public synchronized int getAlt() {
        return this.alt;
    }
    
    public synchronized int getStrength() {
        return this.strength;
    }
    
    public synchronized int getPriority() {
        return this.priority;
    }
    
    public synchronized float getDecay() {
        return this.decay;
    }
    
    public synchronized int getDecayToType() {
        return this.decayToType;
    }
    
    public synchronized float getBurstDecay() {
        return this.burstDecay;
    }
    
    public synchronized int getCharID1() {
        return this.charID1;
    }
    
    public synchronized int getCharID2() {
        return this.charID2;
    }
    
    public synchronized long getDecayAtMillis() {
        return this.decayAtMillis;
    }
    
    public synchronized long getBurstDecayAtMillis() {
        return this.burstDecayAtMillis;
    }
    
    public synchronized boolean getBTerminate() {
        return this.bTerminate;
    }
    
    public synchronized float getStagingConverseDist() {
        return this.stagingConverseDist;
    }
    
    public synchronized float getStagingConverseOutwardAngleOffset() {
        return this.stagingConverseOutwardAngleOffset;
    }
    
    public synchronized void setType(final int type) {
        this.type = type;
    }
    
    public synchronized void setAlt(final int alt) {
        this.alt = alt;
    }
    
    public synchronized void setStrength(final int strength) {
        this.strength = strength;
    }
    
    public synchronized void setPriority(final int priority) {
        this.priority = priority;
    }
    
    public synchronized void setDecay(final float decay) {
        this.decay = decay;
        this.decayAtMillis = System.currentTimeMillis() + (long)(1000.0f * decay);
    }
    
    public synchronized void setDecayToType(final int decayToType) {
        this.decayToType = decayToType;
    }
    
    public synchronized void setBurstDecay(final float burstDecay) {
        this.burstDecay = burstDecay;
        this.burstDecayAtMillis = System.currentTimeMillis() + (long)(1000.0f * burstDecay);
    }
    
    public synchronized void setCharID1(final int charID1) {
        this.charID1 = charID1;
    }
    
    public synchronized void setCharID2(final int charID2) {
        this.charID2 = charID2;
    }
    
    public synchronized void setDecayAtMillis(final long decayAtMillis) {
        this.decayAtMillis = decayAtMillis;
    }
    
    public synchronized void setBurstDecayAtMillis(final long burstDecayAtMillis) {
        this.burstDecayAtMillis = burstDecayAtMillis;
    }
    
    public synchronized void setBTerminate(final boolean bTerminate) {
        this.bTerminate = bTerminate;
    }
    
    public synchronized void setStagingConverseDist(final float stagingConverseDist) {
        this.stagingConverseDist = stagingConverseDist;
    }
    
    public synchronized void setStagingConverseOutwardAngleOffset(final float stagingConverseOutwardAngleOffset) {
        this.stagingConverseOutwardAngleOffset = stagingConverseOutwardAngleOffset;
    }
    
    public synchronized void setStagingConverseInfo(final float stagingConverseDist, final float stagingConverseOutwardAngleOffset) {
        this.stagingConverseDist = stagingConverseDist;
        this.stagingConverseOutwardAngleOffset = stagingConverseOutwardAngleOffset;
    }
    
    public MoodWME(final int type, final int alt, final int strength, final int priority, final float decay, final int decayToType, final float burstDecay, final int charID1, final int charID2, final float stagingConverseDist, final float stagingConverseOutwardAngleOffset) {
        this.type = type;
        this.alt = alt;
        this.strength = strength;
        this.priority = priority;
        this.decay = decay;
        this.decayToType = decayToType;
        this.burstDecay = burstDecay;
        this.charID1 = charID1;
        this.charID2 = charID2;
        this.decayAtMillis = System.currentTimeMillis() + (long)(1000.0f * decay);
        this.burstDecayAtMillis = System.currentTimeMillis() + (long)(1000.0f * burstDecay);
        this.bTerminate = false;
        this.stagingConverseDist = stagingConverseDist;
        this.stagingConverseOutwardAngleOffset = stagingConverseOutwardAngleOffset;
    }
    
    public MoodWME() {
    }
}
