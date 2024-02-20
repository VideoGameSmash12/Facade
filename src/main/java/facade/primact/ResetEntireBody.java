package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.SpriteID;
import abl.runtime.PrimitiveAction;

public class ResetEntireBody extends PrimitiveAction implements SpriteID
{
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        if (!ResetEntireBody.$noassert && array.length != 1) {
            throw new AssertionError();
        }
        NativeAnimationInterface.abortAnimationScripts((int)array[0], -1);
        this.completionStatus = 1;
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.ResetEntireBody;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
