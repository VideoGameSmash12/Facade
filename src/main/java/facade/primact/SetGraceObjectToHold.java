package facade.primact;

public class SetGraceObjectToHold extends SetObjectToHold
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), array[0], array[1] });
    }
}
