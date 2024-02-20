package facade.sensor;

import facade.util.SpriteID;

public class PlayerPositionSensor extends FacadeSensor implements SpriteID
{
    private static final Object[] senseArgs;
    
    public void senseOneShot(final Object[] array) {
        final ObjectPositionSensor objectPositionSensor = new ObjectPositionSensor();
        objectPositionSensor.senseOneShot(PlayerPositionSensor.senseArgs);
        objectPositionSensor.addSpecificPositionWME(2);
    }
    
    public void initializeContinuous(final Object[] array) {
        final ObjectPositionSensor objectPositionSensor = new ObjectPositionSensor();
        objectPositionSensor.senseContinuous(PlayerPositionSensor.senseArgs);
        objectPositionSensor.addSpecificPositionWME(2);
    }
    
    public void senseContinuous(final Object[] array) {
        final ObjectPositionSensor objectPositionSensor = new ObjectPositionSensor();
        objectPositionSensor.senseContinuous(PlayerPositionSensor.senseArgs);
        objectPositionSensor.addSpecificPositionWME(2);
    }
    
    static {
        senseArgs = new Object[] { new Integer(2) };
    }
}
