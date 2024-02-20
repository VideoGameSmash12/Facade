package facade.sensor;

import facade.util.SpriteID;

public class GraceAnimationCueSensor extends AnimationCueSensor implements SpriteID
{
    private static final Object[] senseArgs;
    
    public void senseOneShot(final Object[] array) {
        super.senseOneShot(GraceAnimationCueSensor.senseArgs);
    }
    
    public void initializeContinuous(final Object[] array) {
        super.initializeContinuous(GraceAnimationCueSensor.senseArgs);
    }
    
    public void senseContinuous(final Object[] array) {
        super.senseContinuous(GraceAnimationCueSensor.senseArgs);
    }
    
    static {
        senseArgs = new Object[] { new Integer(0) };
    }
}
