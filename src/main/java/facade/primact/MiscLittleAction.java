package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.SpriteID;
import abl.runtime.PrimitiveAction;

public class MiscLittleAction extends PrimitiveAction implements SpriteID
{
    public void execute(final Object[] array) {
        NativeAnimationInterface.miscLittleAction((int)array[0], (int)array[1], (int)array[2], (float)array[3]);
        this.completionStatus = 1;
    }
}
