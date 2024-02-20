package facade.sensor;

import abl.runtime.RuntimeError;
import wm.WME;
import facade.characters.wmedef.PlayerTextWME;
import abl.runtime.BehavingEntity;
import facade.nativeinterface.NativeAnimationInterface;

public class PlayerTextSensor extends FacadeSensor
{
    public void senseOneShot(final Object[] array) {
        final String textSensor = NativeAnimationInterface.textSensor();
        BehavingEntity.getBehavingEntity().deleteAllWMEClass("PlayerTextWME");
        BehavingEntity.getBehavingEntity().addWME(new PlayerTextWME(textSensor));
    }
    
    public void initializeContinuous(final Object[] array) {
        throw new RuntimeError("continuous sensing not defined for PlayerTextSensor");
    }
    
    public void senseContinuous(final Object[] array) {
        throw new RuntimeError("continuous sensing not defined for PlayerTextSensor");
    }
}
