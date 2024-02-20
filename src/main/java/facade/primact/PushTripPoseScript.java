package facade.primact;

public class PushTripPoseScript extends PushPoseScript
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), array[0] });
    }
}
