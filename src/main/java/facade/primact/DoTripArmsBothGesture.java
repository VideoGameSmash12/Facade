package facade.primact;

public class DoTripArmsBothGesture extends DoGestureAnimation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), new Integer(2), array[0] });
    }
}
