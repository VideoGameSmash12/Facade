package facade.primact;

import facade.util.SpriteID;

public class DoGraceTwoArmGesture extends DoTwoArmGestureAnimation implements SpriteID
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), array[0], array[1] });
    }
}
