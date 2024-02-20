package facade.primact;

public class SetPlayerRotation extends SetObjectRotation
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(2), new Float(0.0), array[0], new Float(0.0) });
    }
}
