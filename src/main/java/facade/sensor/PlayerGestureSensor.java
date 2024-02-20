package facade.sensor;

import wm.WME;
import facade.characters.wmedef.PlayerGestureWME;
import abl.runtime.BehavingEntity;
import facade.nativeinterface.NativeAnimationInterface;
import facade.util.IntegerRef;
import abl.runtime.RuntimeError;
import facade.util.AnimLayer;
import facade.util.SpriteID;

public class PlayerGestureSensor extends FacadeSensor implements SpriteID, AnimLayer
{
    public void senseOneShot(final Object[] array) {
        throw new RuntimeError("Attempt to sense player gesture in a precondition");
    }
    
    public void initializeContinuous(final Object[] array) {
        final IntegerRef integerRef = new IntegerRef(-1);
        final IntegerRef integerRef2 = new IntegerRef(-1);
        final IntegerRef integerRef3 = new IntegerRef(-1);
        NativeAnimationInterface.getPlayerGesture(integerRef, integerRef2, integerRef3);
        BehavingEntity.getBehavingEntity().deleteAllWMEClass("PlayerGestureWME");
        if (integerRef.i != -1) {
            BehavingEntity.getBehavingEntity().addWME(new PlayerGestureWME(integerRef.i, integerRef2.i, integerRef3.i));
        }
    }
    
    public void senseContinuous(final Object[] array) {
        final IntegerRef integerRef = new IntegerRef(-1);
        final IntegerRef integerRef2 = new IntegerRef(-1);
        final IntegerRef integerRef3 = new IntegerRef(-1);
        NativeAnimationInterface.getPlayerGesture(integerRef, integerRef2, integerRef3);
        if (integerRef.i != -1) {
            BehavingEntity.getBehavingEntity().addWME(new PlayerGestureWME(integerRef.i, integerRef2.i, integerRef3.i));
        }
        try {
            Thread.currentThread();
            Thread.sleep(33L);
        }
        catch (InterruptedException ex) {
            throw new RuntimeError("Unexpected interruption");
        }
    }
}
