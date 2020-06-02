package facade.primact;

public class DoGraceArmRGesture extends DoGestureAnimation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), new Integer(1), array[0] });
    }
}
