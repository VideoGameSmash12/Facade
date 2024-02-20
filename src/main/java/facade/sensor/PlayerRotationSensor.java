package facade.sensor;

import facade.util.SpriteID;

public class PlayerRotationSensor extends FacadeSensor implements SpriteID
{
    private static final Object[] senseArgs;
    
    public void senseOneShot(final Object[] array) {
        final ObjectRotationSensor objectRotationSensor = new ObjectRotationSensor();
        objectRotationSensor.senseOneShot(PlayerRotationSensor.senseArgs);
        objectRotationSensor.addSpecificRotationWME(2);
    }
    
    public void initializeContinuous(final Object[] array) {
        final ObjectRotationSensor objectRotationSensor = new ObjectRotationSensor();
        objectRotationSensor.initializeContinuous(PlayerRotationSensor.senseArgs);
        objectRotationSensor.addSpecificRotationWME(2);
    }
    
    public void senseContinuous(final Object[] array) {
        final ObjectRotationSensor objectRotationSensor = new ObjectRotationSensor();
        objectRotationSensor.senseContinuous(PlayerRotationSensor.senseArgs);
        objectRotationSensor.addSpecificRotationWME(2);
    }
    
    static {
        senseArgs = new Object[] { new Integer(2) };
    }
}
