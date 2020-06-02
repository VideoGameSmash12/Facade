package facade.primact;

import facade.util.SpriteID;

public class DoTripFullExpressionBaseAnimation extends DoFullExpressionBaseAnimation implements SpriteID
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(1), array[0], array[1], array[2], null });
    }
}
