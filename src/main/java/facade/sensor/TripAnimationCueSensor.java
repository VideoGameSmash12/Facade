package facade.sensor;

import facade.util.SpriteID;

public class TripAnimationCueSensor extends AnimationCueSensor implements SpriteID
{
    private static final Object[] senseArgs;
    
    public void senseOneShot(final Object[] array) {
        super.senseOneShot(TripAnimationCueSensor.senseArgs);
    }
    
    public void initializeContinuous(final Object[] array) {
        super.initializeContinuous(TripAnimationCueSensor.senseArgs);
    }
    
    public void senseContinuous(final Object[] array) {
        super.senseContinuous(TripAnimationCueSensor.senseArgs);
    }
    
    static {
        senseArgs = new Object[] { new Integer(1) };
    }
}
