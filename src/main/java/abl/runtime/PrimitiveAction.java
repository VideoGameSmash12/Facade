package abl.runtime;

public abstract class PrimitiveAction
{
    public static final int NOT_COMPLETE = 0;
    public static final int SUCCESS = 1;
    public static final int FAILURE = 2;
    protected int completionStatus;
    
    public void abort() {
    }
    
    public synchronized int getCompletionStatus() {
        return this.completionStatus;
    }
    
    public synchronized void completionCallback(final boolean b) {
        if (b) {
            this.completionStatus = 1;
        }
        else {
            this.completionStatus = 2;
        }
    }
    
    public abstract void execute(final Object[] p0);
    
    public void decisionCycleCallback() {
    }
    
    private final /* synthetic */ void this() {
        this.completionStatus = 0;
    }
    
    public PrimitiveAction() {
        this.this();
    }
}
