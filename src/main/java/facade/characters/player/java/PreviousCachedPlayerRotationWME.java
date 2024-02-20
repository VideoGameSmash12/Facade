package facade.characters.player.java;

import wm.WME;

public class PreviousCachedPlayerRotationWME extends WME
{
    private float x;
    private float y;
    private float z;
    
    public synchronized float getX() {
        return this.x;
    }
    
    public synchronized float getY() {
        return this.y;
    }
    
    public synchronized float getZ() {
        return this.z;
    }
    
    public synchronized void setX(final float x) {
        this.x = x;
    }
    
    public synchronized void setY(final float y) {
        this.y = y;
    }
    
    public synchronized void setZ(final float z) {
        this.z = z;
    }
    
    public PreviousCachedPlayerRotationWME(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public PreviousCachedPlayerRotationWME() {
    }
}
