package facade.primact;

public class SetTripObjectToHold extends SetObjectToHold
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), array[0], array[1] });
    }
}
