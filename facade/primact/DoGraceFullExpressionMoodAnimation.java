package facade.primact;

import facade.util.SpriteID;

public class DoGraceFullExpressionMoodAnimation extends DoFullExpressionMoodAnimation implements SpriteID
{
    public void execute(final Object[] array) {
        super.execute(new Object[] { new Integer(0), array[0], array[1], array[2], null });
    }
}
