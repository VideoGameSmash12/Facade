package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.GestureBodyPart;
import facade.util.SpriteID;

public class DoGestureAnimation extends FacadeAsynchronousAction implements SpriteID, GestureBodyPart
{
    protected int character;
    protected int gestureBodyPart;
    
    public void execute(final Object[] array) {
        final int intValue = (int)array[0];
        final int intValue2 = (int)array[1];
        NativeAnimationInterface.doGestureAnimation(intValue, intValue2, (int)array[2], this);
        this.character = intValue;
        this.gestureBodyPart = intValue2;
    }
    
    public void abort() {
        if (this.character != -1 && this.gestureBodyPart != -1) {
            this.unregisterAction();
            NativeAnimationInterface.doGestureAnimation(this.character, this.gestureBodyPart, -1, this);
            this.character = -1;
            this.gestureBodyPart = -1;
        }
    }
    
    private final /* synthetic */ void this() {
        this.character = -1;
        this.gestureBodyPart = -1;
    }
    
    public DoGestureAnimation() {
        this.this();
    }
}
