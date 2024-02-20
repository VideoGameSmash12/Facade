package facade.primact;

public class PushTripTorsoLeanAnimation extends PushAnimationScript
{
    public void execute(final Object[] array) {
        final Object[] array2 = { new Integer(1), array[0], new Integer(2), null };
        if (array.length == 2) {
            array2[3] = array[1];
        }
        else {
            array2[3] = new Boolean(true);
        }
        super.execute(array2);
    }
}
