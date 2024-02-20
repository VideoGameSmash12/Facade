package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.Point3D;
import facade.util.SpriteID;

public class Walk extends FacadeAsynchronousAction implements SpriteID
{
    private int character;
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        final int intValue = (int)array[0];
        NativeAnimationInterface.walkStep(intValue, (int)array[5], (float)array[1], (float)array[2], (float)array[3], (float)array[4], (Point3D)array[6], this);
        this.character = intValue;
    }
    
    public void abort() {
        if (!Walk.$noassert && this.character == -1) {
            throw new AssertionError();
        }
        this.unregisterAction();
        NativeAnimationInterface.abortWalkStep(this.character);
        this.character = -1;
    }
    
    private final /* synthetic */ void this() {
        this.character = -1;
    }
    
    public Walk() {
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.Walk;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
