package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.FullExpressions;

public class DoFullExpressionMoodAnimation extends FacadeAsynchronousAction implements FullExpressions
{
    private int character;
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        final int intValue = (int)array[0];
        NativeAnimationInterface.doFullExpressionMoodAnimation(intValue, (int)array[1], (int)array[2], (int)array[3], this);
        this.character = intValue;
    }
    
    public void abort() {
        if (!DoFullExpressionMoodAnimation.$noassert && this.character == -1) {
            throw new AssertionError();
        }
        this.unregisterAction();
        NativeAnimationInterface.doFullExpressionMoodAnimation(this.character, -1, 0, 0, this);
        this.character = -1;
    }
    
    private final /* synthetic */ void this() {
        this.character = -1;
    }
    
    public DoFullExpressionMoodAnimation() {
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.DoFullExpressionMoodAnimation;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
