package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.GestureBodyPart;
import facade.util.SpriteID;

public class DoPickupObjGestureAnimation extends FacadeAsynchronousAction implements SpriteID, GestureBodyPart
{
    protected int character;
    protected int gestureBodyPart;
    
    public void execute(final Object[] array) {
        final int intValue = (int)array[0];
        final int intValue2 = (int)array[1];
        NativeAnimationInterface.doPickupObjGestureAnimation(intValue, intValue2, (int)array[2], (int)array[3], (int)array[4], this);
        this.character = intValue;
        this.gestureBodyPart = intValue2;
    }
    
    public void abort() {
        if (this.character != -1 && this.gestureBodyPart != -1) {
            this.unregisterAction();
            NativeAnimationInterface.doPickupObjGestureAnimation(this.character, this.gestureBodyPart, -1, -1, -1, this);
            this.character = -1;
            this.gestureBodyPart = -1;
        }
    }
    
    private final /* synthetic */ void this() {
        this.character = -1;
        this.gestureBodyPart = -1;
    }
    
    public DoPickupObjGestureAnimation() {
        this.this();
    }
}
