package abl.runtime;

public abstract class CompletedExecutableStepWME extends CompletedStepWME
{
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;
    private String signature;
    private int completionStatus;
    
    public synchronized String getSignature() {
        return this.signature;
    }
    
    public synchronized void setSignature(final String signature) {
        this.signature = signature;
    }
    
    public synchronized int getCompletionStatus() {
        return this.completionStatus;
    }
    
    public synchronized void setCompletionStatus(final int completionStatus) {
        this.completionStatus = completionStatus;
    }
    
    public CompletedExecutableStepWME(final String signature, final int completionStatus, final String s, final String s2, final long n) {
        super(s, s2, n);
        this.signature = signature;
        this.completionStatus = completionStatus;
    }
    
    public CompletedExecutableStepWME(final String signature, final int completionStatus, final String s, final String s2) {
        super(s, s2);
        this.signature = signature;
        this.completionStatus = completionStatus;
    }
}
