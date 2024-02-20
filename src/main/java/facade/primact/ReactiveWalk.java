package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.SpriteID;

public class ReactiveWalk extends FacadeAsynchronousAction implements SpriteID
{
    private int character;
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        final int intValue = (int)array[0];
        NativeAnimationInterface.reactiveWalkStep(intValue, (int)array[1], (boolean)array[2], this);
        this.character = intValue;
    }
    
    public void abort() {
        if (!ReactiveWalk.$noassert && this.character == -1) {
            throw new AssertionError();
        }
        this.unregisterAction();
        NativeAnimationInterface.abortWalkStep(this.character);
        this.character = -1;
    }
    
    private final /* synthetic */ void this() {
        this.character = -1;
    }
    
    public ReactiveWalk() {
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.ReactiveWalk;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
