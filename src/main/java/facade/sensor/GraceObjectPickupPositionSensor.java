package facade.sensor;

import facade.util.SpriteID;

public class GraceObjectPickupPositionSensor extends ObjectPickupPositionSensor implements SpriteID
{
    public void senseOneShot(final Object[] array) {
        this.senseOneShot_Utility(0);
    }
    
    public void initializeContinuous(final Object[] array) {
        this.initializeContinuous_Utility(0);
    }
    
    public void senseContinuous(final Object[] array) {
        this.senseContinuous_Utility(0);
    }
}
