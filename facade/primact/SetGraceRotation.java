package facade.primact;

public class SetGraceRotation extends SetObjectRotation
{
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        if (!SetGraceRotation.$noassert && array.length != 1) {
            throw new AssertionError();
        }
        super.execute(new Object[] { new Integer(0), new Float(0.0), array[0], new Float(0.0) });
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.SetGraceRotation;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
