package abl.runtime;

public abstract class Sensor
{
    protected boolean bCanBeParallel;
    
    public abstract void senseOneShot(final Object[] p0);
    
    public abstract void initializeContinuous(final Object[] p0);
    
    public abstract void senseContinuous(final Object[] p0);
    
    public boolean canBeParallel() {
        return this.bCanBeParallel;
    }
    
    public Sensor() {
        this.bCanBeParallel = false;
    }
}
