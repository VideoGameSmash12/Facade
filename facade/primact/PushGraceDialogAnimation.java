package facade.primact;

public class PushGraceDialogAnimation extends PushMultipleAnimationScripts
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), array[0], array[1], array[2], array[3], new Integer(7), new Boolean(false) });
    }
}
