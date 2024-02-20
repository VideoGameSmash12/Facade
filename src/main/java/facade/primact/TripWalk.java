package facade.primact;

public class TripWalk extends Walk
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), array[0], array[1], array[2], array[3], array[4], array[5] });
    }
}
