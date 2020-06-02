package facade.sensor;

import wm.WME;
import facade.characters.wmedef.CurrentTimeWME;
import abl.runtime.BehavingEntity;

public class CurrentTimeSensor extends FacadeSensor
{
    private long lastTime;
    
    private static final void addTimeWME(final long n) {
        BehavingEntity.getBehavingEntity().deleteAllWMEClass("CurrentTimeWME");
        BehavingEntity.getBehavingEntity().addWME(new CurrentTimeWME(n));
    }
    
    public void senseOneShot(final Object[] array) {
        addTimeWME(System.currentTimeMillis());
    }
    
    public void initializeContinuous(final Object[] array) {
        addTimeWME(this.lastTime = System.currentTimeMillis());
    }
    
    public void senseContinuous(final Object[] array) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis != this.lastTime) {
            addTimeWME(currentTimeMillis);
        }
    }
}
