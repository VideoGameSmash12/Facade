package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.SpriteID;

public class Turn extends FacadeAsynchronousAction implements SpriteID
{
    private int character;
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        final int intValue = (int)array[0];
        NativeAnimationInterface.turnInPlace(intValue, (float)array[1], this);
        this.character = intValue;
    }
    
    public void abort() {
        if (!Turn.$noassert && this.character == -1) {
            throw new AssertionError();
        }
        this.unregisterAction();
        NativeAnimationInterface.abortTurnInPlace(this.character);
        this.character = -1;
    }
    
    private final /* synthetic */ void this() {
        this.character = -1;
    }
    
    public Turn() {
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.Turn;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
