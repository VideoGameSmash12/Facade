package facade.sensor;

import facade.util.SpriteID;

public class TripArmBaseSensor extends ArmBaseSensor implements SpriteID
{
    public void senseOneShot(final Object[] array) {
        this.sense_Utility(1);
    }
    
    public void initializeContinuous(final Object[] array) {
        this.sense_Utility(1);
    }
    
    public void senseContinuous(final Object[] array) {
        this.sense_Utility(1);
    }
}
