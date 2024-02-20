package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import abl.runtime.PrimitiveAction;

public class AbortAnimationScripts extends PrimitiveAction
{
    public void execute(final Object[] array) {
        NativeAnimationInterface.abortAnimationScripts((int)array[0], (int)array[1]);
        this.completionStatus = 1;
    }
}
