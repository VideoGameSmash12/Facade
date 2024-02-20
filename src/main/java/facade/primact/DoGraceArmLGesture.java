package facade.primact;

public class DoGraceArmLGesture extends DoGestureAnimation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), new Integer(0), array[0] });
    }
}
