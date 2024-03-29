package facade.primact;

public class SetGraceGazeTracking extends SetGazeTracking
{
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        if (!SetGraceGazeTracking.$noassert && array.length != 4 && array.length != 6) {
            throw new AssertionError();
        }
        final Object[] array2 = new Object[array.length + 1];
        array2[0] = new Integer(0);
        for (int i = 0; i < array.length; ++i) {
            array2[i + 1] = array[i];
        }
        super.execute(array2);
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.SetGraceGazeTracking;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
