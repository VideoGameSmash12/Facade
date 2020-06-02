package facade.characters.wmedef;

import wm.TimeStampedWME;

public class BeatOneOnOneAffChrT2WME extends TimeStampedWME
{
    private float playerOrigX;
    private float playerOrigZ;
    
    public synchronized float getPlayerOrigX() {
        return this.playerOrigX;
    }
    
    public synchronized float getPlayerOrigZ() {
        return this.playerOrigZ;
    }
    
    public synchronized void setPlayerOrigX(final float playerOrigX) {
        this.playerOrigX = playerOrigX;
    }
    
    public synchronized void setPlayerOrigZ(final float playerOrigZ) {
        this.playerOrigZ = playerOrigZ;
    }
    
    public BeatOneOnOneAffChrT2WME() {
        this.playerOrigX = 0.0f;
        this.playerOrigZ = 0.0f;
    }
}
