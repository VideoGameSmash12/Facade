package facade.sensor;

import facade.util.SpriteID;

public class PlayerObjectActivationSensor extends ObjectActivationSensor implements SpriteID
{
    private static final Object[] senseArgs;
    
    public void senseOneShot(final Object[] array) {
        super.senseOneShot(PlayerObjectActivationSensor.senseArgs);
    }
    
    public void initializeContinuous(final Object[] array) {
        super.initializeContinuous(PlayerObjectActivationSensor.senseArgs);
    }
    
    public void senseContinuous(final Object[] array) {
        super.senseContinuous(PlayerObjectActivationSensor.senseArgs);
    }
    
    static {
        senseArgs = new Object[] { new Integer(2) };
    }
}
