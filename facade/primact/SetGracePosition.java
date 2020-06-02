package facade.primact;

public class SetGracePosition extends SetObjectPosition
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), array[0], array[1], array[2] });
    }
}
