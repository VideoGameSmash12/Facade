package abl.runtime;

import java.lang.reflect.Method;
import java.util.Vector;
import java.util.List;

public class SequentialBehavior extends Behavior
{
    protected static short behaviorType;
    private int stepCounter;
    private Step child;
    private static final /* synthetic */ boolean $noassert;
    
    final short getBehaviorType() {
        return SequentialBehavior.behaviorType;
    }
    
    final Step getChild() {
        return this.child;
    }
    
    final Step getNextStep() {
        if (this.stepCounter == this.stepDescs.length) {
            return null;
        }
        try {
            return (Step)this.stepDescs[this.stepCounter++].factory.invoke(null, new Integer(this.stepDescs[this.stepCounter].stepID), this, this.getBehaviorVariableFrame());
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking step factory", ex);
        }
    }
    
    void addChildren() {
        if (!SequentialBehavior.$noassert && this.stepCounter != 0) {
            throw new AssertionError();
        }
        this.child = this.getNextStep();
        BehavingEntity.getBehavingEntity().addStep(this.child);
        this.changes.firePropertyChange("child", null, this.child);
    }
    
    final void addChild(final Step child) {
        if (!SequentialBehavior.$noassert && this.child != null) {
            throw new AssertionError();
        }
        this.child = child;
        BehavingEntity.getBehavingEntity().addStep(child);
        this.changes.firePropertyChange("child", null, this.child);
    }
    
    protected final void removeChildren() {
        if (this.child != null) {
            this.removeChild(this.child, false);
        }
    }
    
    protected final void removeChild(final Step step, final boolean b) {
        if (!SequentialBehavior.$noassert && step != this.child) {
            throw new AssertionError((Object)("childToRemove == " + step + ": current child == " + this.child + " behavior: " + this.getSignature()));
        }
        if (!SequentialBehavior.$noassert && step == null) {
            throw new AssertionError((Object)"Attempt to remove a null child from a sequential behavior.");
        }
        super.removeChild(step, b);
        this.child = null;
    }
    
    final boolean currentLineOfExpansion(final GoalStep goalStep) {
        return this.parent.currentLineOfExpansion(goalStep);
    }
    
    final void suspend(final ExecutableStep executableStep) {
        this.child.suspend(executableStep);
    }
    
    final void jointUnsuspend() {
        this.child.jointUnsuspend();
    }
    
    final void metaSuspend() {
        this.child.metaSuspend();
    }
    
    final void unsuspend(final ExecutableStep executableStep) {
        this.child.unsuspend(executableStep);
    }
    
    final void metaUnsuspend() {
        this.child.metaUnsuspend();
    }
    
    final void suspendSkipJointGoals(final ExecutableStep executableStep) {
        if (this.child != null && (this.child.getStepType() != 1 || !((GoalStep)this.child).isJointGoal())) {
            if (this.child.getStepType() == 1) {
                ((GoalStep)this.child).suspendSkipJointGoals(executableStep);
            }
            else {
                this.child.suspend(executableStep);
            }
        }
    }
    
    final void metaSuspendSkipJointGoals() {
        if (this.child != null && (this.child.getStepType() != 1 || !((GoalStep)this.child).isJointGoal())) {
            if (this.child.getStepType() == 1) {
                ((GoalStep)this.child).metaSuspendSkipJointGoals();
            }
            else {
                this.child.metaSuspend();
            }
        }
    }
    
    final List freezeSubtreeAndNegotiateRemoval() {
        if (this.hasTeamEffectOnlySteps()) {
            return this.freezeNonTeamEffectOnlySubtreeAndNegotiateRemoval();
        }
        BehavingEntity.getBehavingEntity().removeBehavior(this);
        if (this.child != null) {
            return this.freezeChild(this.child);
        }
        return new Vector(0);
    }
    
    protected final List freezeNonTeamEffectOnlySubtreeAndNegotiateRemoval() {
        BehavingEntity.getBehavingEntity().removeBehavior(this);
        if (this.child != null && !this.child.getTeamEffectOnly()) {
            return this.freezeChild(this.child);
        }
        return new Vector(0);
    }
    
    protected final boolean hasTeamEffectOnlySteps() {
        return this.child != null && this.child.getTeamEffectOnly();
    }
    
    final List negotiateSuspensionOfSubtree(final ExecutableStep executableStep) {
        if (this.child != null) {
            return this.negotiateSuspensionOfChild(this.child, executableStep);
        }
        return new Vector(0);
    }
    
    final List negotiateSuspensionOfSubtree() {
        if (this.child != null) {
            return this.negotiateSuspensionOfChild(this.child);
        }
        return new Vector(0);
    }
    
    private final /* synthetic */ void this() {
        this.stepCounter = 0;
    }
    
    public SequentialBehavior(final GoalStep goalStep, final Method method, final Method method2, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2) {
        super(goalStep, method, method2, null, null, b, s, n, n2, array, array2);
        this.this();
    }
    
    public SequentialBehavior(final GoalStep goalStep, final Method method, final Method method2, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final BehavingEntity[] array3) {
        super(goalStep, method, method2, null, null, b, s, n, n2, array, array2, array3);
        this.this();
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.SequentialBehavior;").getComponentType().desiredAssertionStatus() ^ true);
        SequentialBehavior.behaviorType = 0;
    }
}
