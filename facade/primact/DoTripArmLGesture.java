package facade.primact;

public class DoTripArmLGesture extends DoGestureAnimation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), new Integer(0), array[0] });
    }
}
