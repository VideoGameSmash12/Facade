package facade.primact;

public class DoTripArmsBothPickupObjGesture extends DoPickupObjGestureAnimation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), new Integer(2), array[0], array[1], array[2] });
    }
}
