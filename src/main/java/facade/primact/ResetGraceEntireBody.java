package facade.primact;

public class ResetGraceEntireBody extends ResetEntireBody
{
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        if (!ResetGraceEntireBody.$noassert && array.length != 0) {
            throw new AssertionError();
        }
        super.execute(new Object[] { new Integer(0) });
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.ResetGraceEntireBody;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
