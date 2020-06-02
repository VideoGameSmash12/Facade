package facade.primact;

public class DoGraceArmsBothGesture extends DoGestureAnimation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), new Integer(2), array[0] });
    }
}
