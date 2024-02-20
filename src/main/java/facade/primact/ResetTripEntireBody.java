package facade.primact;

public class ResetTripEntireBody extends ResetEntireBody
{
    private static final /* synthetic */ boolean $noassert;
    
    public void execute(final Object[] array) {
        if (!ResetTripEntireBody.$noassert && array.length != 0) {
            throw new AssertionError();
        }
        super.execute(new Object[] { new Integer(1) });
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.ResetTripEntireBody;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
