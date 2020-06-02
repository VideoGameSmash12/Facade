package abl.runtime;

public class ExecutableStepWME extends StepWME
{
    public synchronized String[] getConflicts() {
        return ((ExecutableStep)this.s).getConflicts();
    }
    
    public synchronized boolean getIsExecuting() {
        return ((ExecutableStep)this.s).isExecuting();
    }
    
    public synchronized boolean getIsSuspended() {
        return ((ExecutableStep)this.s).isSuspended();
    }
    
    public synchronized void suspend() {
        if (this.s != null) {
            ((ExecutableStep)this.s).metaSuspend();
        }
    }
    
    public synchronized void unsuspend() {
        if (this.s != null) {
            ((ExecutableStep)this.s).metaUnsuspend();
        }
    }
    
    public synchronized void resetStep() {
        if (this.s != null) {
            ((ExecutableStep)this.s).resetStep();
        }
    }
    
    public ExecutableStepWME(final Step step, final BehaviorWME behaviorWME) {
        super(step, behaviorWME);
    }
}
