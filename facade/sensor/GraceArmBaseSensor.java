package facade.sensor;

import facade.util.SpriteID;

public class GraceArmBaseSensor extends ArmBaseSensor implements SpriteID
{
    public void senseOneShot(final Object[] array) {
        this.sense_Utility(0);
    }
    
    public void initializeContinuous(final Object[] array) {
        this.sense_Utility(0);
    }
    
    public void senseContinuous(final Object[] array) {
        this.sense_Utility(0);
    }
}
