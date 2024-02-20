package facade.primact;

public class PushAnimationScript extends PushMultipleAnimationScripts
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { array[0], array[1], new Integer(-1), new Integer(-1), new Integer(-1), array[2], array[3] });
    }
}
