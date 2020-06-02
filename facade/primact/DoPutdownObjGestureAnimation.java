package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.GestureBodyPart;
import facade.util.SpriteID;

public class DoPutdownObjGestureAnimation extends FacadeAsynchronousAction implements SpriteID, GestureBodyPart
{
    protected int character;
    protected int gestureBodyPart;
    
    public void execute(final Object[] array) {
        final int intValue = (int)array[0];
        final int intValue2 = (int)array[1];
        NativeAnimationInterface.doPutdownObjGestureAnimation(intValue, intValue2, (int)array[2], (int)array[3], (int)array[4], (float)array[5], (float)array[6], (float)array[7], (int)array[8], this);
        this.character = intValue;
        this.gestureBodyPart = intValue2;
    }
    
    public void abort() {
        if (this.character != -1 && this.gestureBodyPart != -1) {
            this.unregisterAction();
            NativeAnimationInterface.doPutdownObjGestureAnimation(this.character, this.gestureBodyPart, -1, -1, -1, 0.0f, 0.0f, 0.0f, -1, this);
            this.character = -1;
            this.gestureBodyPart = -1;
        }
    }
    
    private final /* synthetic */ void this() {
        this.character = -1;
        this.gestureBodyPart = -1;
    }
    
    public DoPutdownObjGestureAnimation() {
        this.this();
    }
}
