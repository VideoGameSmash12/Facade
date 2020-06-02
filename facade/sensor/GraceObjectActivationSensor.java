package facade.sensor;

import facade.util.SpriteID;

public class GraceObjectActivationSensor extends ObjectActivationSensor implements SpriteID
{
    private static final Object[] senseArgs;
    
    public void senseOneShot(final Object[] array) {
        super.senseOneShot(GraceObjectActivationSensor.senseArgs);
    }
    
    public void initializeContinuous(final Object[] array) {
        super.initializeContinuous(GraceObjectActivationSensor.senseArgs);
    }
    
    public void senseContinuous(final Object[] array) {
        super.senseContinuous(GraceObjectActivationSensor.senseArgs);
    }
    
    static {
        senseArgs = new Object[] { new Integer(0) };
    }
}
