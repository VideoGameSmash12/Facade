package facade.primact;

public class SetPlayerPosition extends SetObjectPosition
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(2), array[0], array[1], array[2] });
    }
}
