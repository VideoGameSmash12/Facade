package facade.primact;

public class DoTripArmLPutdownObjGesture extends DoPutdownObjGestureAnimation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), new Integer(0), array[0], array[1], array[2], array[3], array[4], array[5], array[6] });
    }
}
