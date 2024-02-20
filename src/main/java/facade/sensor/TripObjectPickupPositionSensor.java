package facade.sensor;

import facade.util.SpriteID;

public class TripObjectPickupPositionSensor extends ObjectPickupPositionSensor implements SpriteID
{
    public void senseOneShot(final Object[] array) {
        this.senseOneShot_Utility(1);
    }
    
    public void initializeContinuous(final Object[] array) {
        this.initializeContinuous_Utility(1);
    }
    
    public void senseContinuous(final Object[] array) {
        this.senseContinuous_Utility(1);
    }
}
