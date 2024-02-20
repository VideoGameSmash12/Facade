package facade.sensor;

import abl.runtime.Sensor;

public abstract class FacadeSensor extends Sensor
{
    protected static final int ONE_SHOT = 0;
    protected static final int INITIALIZE = 1;
    protected static final int CONTINUOUS = 2;
    
    public FacadeSensor() {
        this.bCanBeParallel = true;
    }
}
