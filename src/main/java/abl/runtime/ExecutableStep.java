package abl.runtime;

import java.lang.reflect.Method;

public abstract class ExecutableStep extends Step
{
    protected String[] stepsIConflictWith;
    protected String name;
    
    protected void checkForConflictsOnExecution() {
        if (this.stepsIConflictWith != null) {
            BehavingEntity.getBehavingEntity().findConflictsWithCurrentlyExecutingSteps(this, 1);
        }
    }
    
    protected void initConflictSteps(final String[] stepsIConflictWith) {
        this.stepsIConflictWith = stepsIConflictWith;
    }
    
    abstract boolean isExecuting();
    
    String[] getConflicts() {
        if (this.stepsIConflictWith != null) {
            return this.stepsIConflictWith.clone();
        }
        return new String[0];
    }
    
    private final void unsuspendStepsIHaveSuspended() {
        final Step[] array = this.stepsIHaveSuspended.toArray(new Step[this.stepsIHaveSuspended.size()]);
        for (int i = 0; i < array.length; ++i) {
            array[i].unsuspend(this);
        }
    }
    
    void processStepRemoval() {
        this.unsuspendStepsIHaveSuspended();
        this.updateStepsSuspendingMe();
    }
    
    String getName() {
        return this.name;
    }
    
    void suspend(final ExecutableStep executableStep) {
        if (this.isExecuting()) {
            this.unsuspendStepsIHaveSuspended();
        }
        super.suspend(executableStep);
    }
    
    void metaSuspend() {
        if (this.isExecuting()) {
            this.unsuspendStepsIHaveSuspended();
        }
        super.metaSuspend();
    }
    
    void jointSuspend() {
        if (this.isExecuting()) {
            this.unsuspendStepsIHaveSuspended();
        }
        super.jointSuspend();
    }
    
    void suspenderFor(final Step step) {
        this.stepsIHaveSuspended.add(step);
    }
    
    void unsuspenderFor(final Step step) {
        this.stepsIHaveSuspended.remove(step);
    }
    
    public ExecutableStep(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final short n4, final String[] stepsIConflictWith) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, n4);
        this.stepsIConflictWith = stepsIConflictWith;
    }
}
