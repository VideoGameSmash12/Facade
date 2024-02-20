package facade.primact;

public class GraceReactiveWalk extends ReactiveWalk
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), array[0], array[1] });
    }
}
