package facade.primact;

public class TripTurn extends Turn
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), array[0] });
    }
}
