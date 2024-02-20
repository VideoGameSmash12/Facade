package abl.runtime;

import java.lang.reflect.Method;

public class PrimitiveStep extends ExecutableStep
{
    private PrimitiveAction act;
    private boolean executing;
    
    final boolean isExecuting() {
        if (this.executing) {
            if (this.getCompletionStatus() == 0) {
                return true;
            }
            this.executing = false;
        }
        return false;
    }
    
    final int getCompletionStatus() {
        return this.act.getCompletionStatus();
    }
    
    final void resetStep() {
        if (this.isExecuting()) {
            this.act.abort();
        }
        BehavingEntity.getBehavingEntity().resetStep(this);
        try {
            this.act = (PrimitiveAction)this.act.getClass().newInstance();
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Reflection error in PrimitiveStep.resetStep()", ex);
        }
        this.executing = false;
    }
    
    private final Object[] bindArgs() {
        if (this.execute != null) {
            final Object[] array = { new Integer(this.stepID), this.parent.getBehaviorVariableFrame(), BehavingEntity.getBehavingEntity() };
            try {
                return (Object[])this.execute.invoke(null, array);
            }
            catch (Exception ex) {
                throw new AblRuntimeError("Error invoking execute", ex);
            }
        }
        return new Object[0];
    }
    
    void execute() {
        this.checkForConflictsOnExecution();
        if (!this.isSuspended()) {
            this.executeBookkeeping();
            this.act.execute(this.bindArgs());
        }
    }
    
    protected final void executeBookkeeping() {
        this.executing = true;
        super.executeBookkeeping();
    }
    
    final void abort() {
        if (this.isExecuting()) {
            this.act.abort();
        }
        BehavingEntity.getBehavingEntity().abortStep(this);
        this.executing = false;
    }
    
    void suspend(final ExecutableStep executableStep) {
        super.suspend(executableStep);
        BehavingEntity.getBehavingEntity().suspendStep(this);
        if (this.isExecuting()) {
            this.act.abort();
            try {
                this.act = (PrimitiveAction)this.act.getClass().newInstance();
            }
            catch (Exception ex) {
                throw new AblRuntimeError("Reflection error in PrimitiveStep.suspend()", ex);
            }
            this.executing = false;
        }
    }
    
    public void metaSuspend() {
        super.metaSuspend();
        BehavingEntity.getBehavingEntity().suspendStep(this);
        if (this.isExecuting()) {
            this.act.abort();
            try {
                this.act = (PrimitiveAction)this.act.getClass().newInstance();
            }
            catch (Exception ex) {
                throw new AblRuntimeError("Reflection error in PrimitiveStep.suspend()", ex);
            }
            this.executing = false;
        }
    }
    
    void jointSuspend() {
        super.jointSuspend();
        BehavingEntity.getBehavingEntity().suspendStep(this);
        if (this.isExecuting()) {
            this.act.abort();
            try {
                this.act = (PrimitiveAction)this.act.getClass().newInstance();
            }
            catch (Exception ex) {
                throw new AblRuntimeError("Reflection error in PrimitiveStep.suspend()", ex);
            }
            this.executing = false;
        }
    }
    
    void unsuspend(final ExecutableStep executableStep) {
        super.unsuspend(executableStep);
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().unsuspendStep(this);
        }
    }
    
    public void metaUnsuspend() {
        super.metaUnsuspend();
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().unsuspendStep(this);
        }
    }
    
    void jointUnsuspend() {
        super.jointUnsuspend();
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().unsuspendStep(this);
        }
    }
    
    private final /* synthetic */ void this() {
        this.executing = false;
    }
    
    public PrimitiveStep(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final PrimitiveAction act, final String[] array, final String name) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, (short)0, array);
        this.this();
        this.act = act;
        this.name = name;
    }
}
