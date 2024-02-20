package facade.primact;

public class DoTripArmLPickupObjGesture extends DoPickupObjGestureAnimation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), new Integer(0), array[0], array[1], new Integer(-1) });
    }
}
