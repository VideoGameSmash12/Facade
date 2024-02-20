package facade.primact;

public class PushGracePoseScript extends PushPoseScript
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), array[0] });
    }
}
