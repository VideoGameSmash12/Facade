package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.SpriteID;
import abl.runtime.PrimitiveAction;

public class SetObjectRotation extends PrimitiveAction implements SpriteID
{
    public void execute(final Object[] array) {
        NativeAnimationInterface.setObjectRotation((int)array[0], (float)array[1], (float)array[2], (float)array[3]);
        this.completionStatus = 1;
    }
}
