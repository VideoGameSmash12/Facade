package facade.sensor;

import facade.util.SpriteID;

public class TripObjectActivationSensor extends ObjectActivationSensor implements SpriteID
{
    private static final Object[] senseArgs;
    
    public void senseOneShot(final Object[] array) {
        super.senseOneShot(TripObjectActivationSensor.senseArgs);
    }
    
    public void initializeContinuous(final Object[] array) {
        super.initializeContinuous(TripObjectActivationSensor.senseArgs);
    }
    
    public void senseContinuous(final Object[] array) {
        super.senseContinuous(TripObjectActivationSensor.senseArgs);
    }
    
    static {
        senseArgs = new Object[] { new Integer(1) };
    }
}
