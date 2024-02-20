package facade.sensor;

import wm.WME;
import facade.characters.wmedef.ObjectActivationWME;
import abl.runtime.BehavingEntity;
import facade.util.ObjectActivationSensePacket;
import facade.nativeinterface.NativeAnimationInterface;
import abl.runtime.RuntimeError;
import facade.util.BeatConstants;
import facade.util.SpriteID;

public abstract class ObjectActivationSensor extends FacadeSensor implements SpriteID, BeatConstants
{
    private static final /* synthetic */ boolean $noassert;
    
    public void senseOneShot(final Object[] array) {
        throw new RuntimeError("Attempt to sense object activation in a precondition");
    }
    
    public void initializeContinuous(final Object[] array) {
        final int intValue = (int)array[0];
        if (!ObjectActivationSensor.$noassert && (intValue < 0 || intValue > 2)) {
            throw new AssertionError();
        }
        NativeAnimationInterface.resetMyCopyOfAllObjectActivations(intValue);
    }
    
    public void senseContinuous(final Object[] array) {
        final int intValue = (int)array[0];
        if (!ObjectActivationSensor.$noassert && (intValue < 0 || intValue > 2)) {
            throw new AssertionError();
        }
        final ObjectActivationSensePacket objectActivationSensePacket = new ObjectActivationSensePacket();
        NativeAnimationInterface.getMyCopyOfAllObjectActivations(intValue, objectActivationSensePacket);
        for (int i = 0; i < 49; ++i) {
            final ObjectActivationSensePacket.ObjectActivationEntry activationInfo = objectActivationSensePacket.getActivationInfo(i);
            if (activationInfo.activation != -1) {
                BehavingEntity.getBehavingEntity().addWME(new ObjectActivationWME(i, activationInfo.activation, activationInfo.activatorID));
            }
        }
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.sensor.ObjectActivationSensor;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
