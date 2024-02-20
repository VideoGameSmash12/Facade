package abl.runtime;

import java.lang.reflect.Method;

class ExecutePolicyStep extends Step
{
    private static final int EXECUTE_POLICY_STEP_ID = -100;
    
    void execute() {
        this.parent.removeChild(this, true);
        ((AdaptiveBehavior)this.parent).executePolicy();
    }
    
    void resetStep() {
        BehavingEntity.getBehavingEntity().resetStep(this);
    }
    
    ExecutePolicyStep(final Behavior behavior) {
        super(-100, behavior, false, false, false, false, false, false, (short)0, (short)0, false, null, null, null, null, null, (short)6);
    }
}
