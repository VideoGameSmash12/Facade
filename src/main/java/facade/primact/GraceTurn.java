package facade.primact;

public class GraceTurn extends Turn
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), array[0] });
    }
}
