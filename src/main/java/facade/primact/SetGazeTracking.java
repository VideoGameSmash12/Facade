package facade.primact;

import facade.nativeinterface.NativeAnimationInterface;
import facade.util.SpriteID;
import abl.runtime.PrimitiveAction;

public class SetGazeTracking extends PrimitiveAction implements SpriteID
{
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        if (!SetGazeTracking.$noassert && array.length != 5 && array.length != 7) {
            throw new AssertionError();
        }
        final int intValue = (int)array[0];
        float floatValue = 0.0f;
        float floatValue2 = 0.0f;
        float floatValue3 = 0.0f;
        int intValue2;
        int n;
        int n2;
        int n3;
        if (array.length == 5) {
            intValue2 = (int)array[1];
            n = (int)array[2];
            n2 = (int)array[3];
            n3 = (int)array[4];
        }
        else {
            intValue2 = -1;
            floatValue = (float)array[1];
            floatValue2 = (float)array[2];
            floatValue3 = (float)array[3];
            n = (int)array[4];
            n2 = (int)array[5];
            n3 = (int)array[6];
        }
        NativeAnimationInterface.setGazeTracking(intValue, intValue2, floatValue, floatValue2, floatValue3, n, n2, n3);
        this.completionStatus = 1;
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.SetGazeTracking;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
