package facade.primact;

public class DoTripArmRGesture extends DoGestureAnimation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), new Integer(1), array[0] });
    }
}
