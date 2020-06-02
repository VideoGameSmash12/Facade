package facade.primact;

import java.util.Hashtable;
import abl.runtime.PrimitiveAction;

public abstract class FacadeAsynchronousAction extends PrimitiveAction
{
    private static Hashtable actionRegistry;
    private Long thisActID;
    private static final /* synthetic */ boolean $noassert;
    
    public static void callCompletionCallback(final long n, final boolean b) {
        final Long n2 = new Long(n);
        final FacadeAsynchronousAction facadeAsynchronousAction = FacadeAsynchronousAction.actionRegistry.get(n2);
        try {
            facadeAsynchronousAction.completionCallback(b);
        }
        catch (NullPointerException ex) {
            throw new RuntimeException("Non-existent act ID " + n);
        }
        FacadeAsynchronousAction.actionRegistry.remove(n2);
    }
    
    protected void unregisterAction() {
        if (!FacadeAsynchronousAction.$noassert && this.thisActID == null) {
            throw new AssertionError();
        }
        FacadeAsynchronousAction.actionRegistry.remove(this.thisActID);
    }
    
    public void registerActID(final long n) {
        FacadeAsynchronousAction.actionRegistry.put(new Long(n), this);
        this.thisActID = new Long(n);
    }
    
    private final /* synthetic */ void this() {
        this.thisActID = null;
    }
    
    public FacadeAsynchronousAction() {
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.primact.FacadeAsynchronousAction;").getComponentType().desiredAssertionStatus() ^ true);
        FacadeAsynchronousAction.actionRegistry = new Hashtable();
    }
}
