package facade.characters.wmedef;

import wm.WME;

public class ComputedWalkTargetWME extends WME
{
    private float x;
    private float z;
    
    public synchronized float getX() {
        return this.x;
    }
    
    public synchronized float getZ() {
        return this.z;
    }
    
    public synchronized void setX(final float x) {
        this.x = x;
    }
    
    public synchronized void setZ(final float z) {
        this.z = z;
    }
    
    public ComputedWalkTargetWME(final float x, final float z) {
        this.x = x;
        this.z = z;
    }
    
    public ComputedWalkTargetWME() {
    }
}
