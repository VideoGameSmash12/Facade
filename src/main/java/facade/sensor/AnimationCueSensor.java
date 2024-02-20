package facade.sensor;

import wm.WME;
import facade.characters.wmedef.AnimationCueWME;
import abl.runtime.BehavingEntity;
import facade.util.AnimCueSensePacket;
import facade.nativeinterface.NativeAnimationInterface;
import abl.runtime.RuntimeError;
import facade.util.AnimLayer;
import facade.util.SpriteID;

public abstract class AnimationCueSensor extends FacadeSensor implements SpriteID, AnimLayer
{
    private static final /* synthetic */ boolean $noassert;
    
    public void senseOneShot(final Object[] array) {
        throw new RuntimeError("Attempt to sense animation cue in a precondition");
    }
    
    public void initializeContinuous(final Object[] array) {
        final int intValue = (int)array[0];
        if (!AnimationCueSensor.$noassert && (intValue < 0 || intValue > 2)) {
            throw new AssertionError();
        }
        NativeAnimationInterface.resetMyCopyOfAllAnimCues(intValue);
    }
    
    public void senseContinuous(final Object[] array) {
        final int intValue = (int)array[0];
        if (!AnimationCueSensor.$noassert && (intValue < 0 || intValue > 2)) {
            throw new AssertionError();
        }
        final AnimCueSensePacket animCueSensePacket = new AnimCueSensePacket();
        NativeAnimationInterface.getMyCopyOfAllAnimCues(intValue, animCueSensePacket);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (animCueSensePacket.getCueInfo(i, j) != -1) {
                    BehavingEntity.getBehavingEntity().addWME(new AnimationCueWME(i, j, animCueSensePacket.getCueInfo(i, j)));
                }
            }
        }
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.sensor.AnimationCueSensor;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
