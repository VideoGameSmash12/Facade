package facade.primact;

public class DoGraceArmsBothPutdownObjGesture extends DoPutdownObjGestureAnimation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), new Integer(2), array[0], array[1], array[2], array[3], array[4], array[5], array[6] });
    }
}
