package facade.primact;

import facade.util.SpriteID;

public class SetGracePerformanceInfo extends SetPerformanceInfo implements SpriteID
{
    public void execute(final Object[] array) {
        final Object[] array2 = new Object[85];
        array2[0] = new Integer(0);
        for (int i = 1; i < 85; ++i) {
            array2[i] = array[i - 1];
        }
        super.execute(array2);
    }
}
