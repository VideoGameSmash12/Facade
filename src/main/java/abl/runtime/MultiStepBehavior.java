package abl.runtime;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Vector;
import java.util.Iterator;
import java.util.List;
import java.util.HashSet;

public abstract class MultiStepBehavior extends Behavior
{
    protected HashSet children;
    private int numberNeededForSuccess;
    private int numberOfCompletedSteps;
    private GoalStep lastPursuedGoal;
    private static final /* synthetic */ boolean $noassert;
    
    int getNumberNeededForSuccess() {
        return this.numberNeededForSuccess;
    }
    
    final int getNumberOfCompletedSteps() {
        return this.numberOfCompletedSteps;
    }
    
    final GoalStep getLastPursuedGoal() {
        return this.lastPursuedGoal;
    }
    
    final int getNumberOfSteps() {
        return this.stepDescs.length;
    }
    
    final Step[] getChildren() {
        return (Step[])this.children.toArray(new Step[this.children.size()]);
    }
    
    final void pursueGoal(final GoalStep lastPursuedGoal) {
        this.lastPursuedGoal = lastPursuedGoal;
    }
    
    final void clearLastPursuedGoal() {
        this.lastPursuedGoal = null;
    }
    
    protected void removeChildren() {
        final Step[] array = (Step[])this.children.toArray(new Step[this.children.size()]);
        for (int i = 0; i < array.length; ++i) {
            this.removeChild(array[i], false);
        }
    }
    
    void addChild(final Step step) {
        if (this.parent != null && this.parent.isSuspended()) {
            final List stepsSuspendingMe = this.parent.getStepsSuspendingMe();
            final int metaSuspenderCount = this.parent.getMetaSuspenderCount();
            if (!MultiStepBehavior.$noassert && stepsSuspendingMe.size() == 0 && metaSuspenderCount <= 0) {
                throw new AssertionError();
            }
            if (stepsSuspendingMe.size() != 0) {
                final Iterator<ExecutableStep> iterator = stepsSuspendingMe.iterator();
                while (iterator.hasNext()) {
                    step.suspend(iterator.next());
                }
            }
            if (metaSuspenderCount > 0) {
                for (int i = 0; i < metaSuspenderCount; ++i) {
                    step.metaSuspend();
                }
            }
        }
        this.children.add(step);
        if (!step.getEffectOnlyOrTeamEffectOnly()) {
            ++this.numberNeededForSuccess;
        }
        BehavingEntity.getBehavingEntity().addStep(step);
        this.changes.firePropertyChange("child", null, step);
    }
    
    void addChildren() {
        final Step[] allSteps = this.getAllSteps();
        for (int i = 0; i < allSteps.length; ++i) {
            this.children.add(allSteps[i]);
            BehavingEntity.getBehavingEntity().addStep(allSteps[i]);
            this.changes.firePropertyChange("child", null, allSteps[i]);
        }
    }
    
    protected void removeChild(final Step step, final boolean b) {
        if (!MultiStepBehavior.$noassert && !this.children.contains(step)) {
            throw new AssertionError((Object)("child == " + step + " current children == " + this.children));
        }
        super.removeChild(step, b);
        this.children.remove(step);
        this.lastPursuedGoal = null;
        if (this.numberNeededForSuccess != -1 && !step.getEffectOnlyOrTeamEffectOnly()) {
            ++this.numberOfCompletedSteps;
        }
    }
    
    protected Step[] getAllSteps() {
        final Step[] array = new Step[this.stepDescs.length];
        for (int i = 0; i < array.length; ++i) {
            try {
                array[i] = (Step)this.stepDescs[i].factory.invoke(null, new Integer(this.stepDescs[i].stepID), this, this.getBehaviorVariableFrame());
            }
            catch (Exception ex) {
                throw new AblRuntimeError("Error invoking step factory", ex);
            }
        }
        return array;
    }
    
    boolean isSuccessful() {
        if (!MultiStepBehavior.$noassert && this.numberNeededForSuccess == -1) {
            throw new AssertionError();
        }
        boolean b = false;
        if (this.numberOfCompletedSteps >= this.numberNeededForSuccess) {
            b = true;
        }
        return b;
    }
    
    boolean currentLineOfExpansion(final GoalStep goalStep) {
        if (this.parent != null) {
            return (goalStep == null || this.lastPursuedGoal == null || goalStep == this.lastPursuedGoal) && this.parent.currentLineOfExpansion(goalStep);
        }
        return goalStep == null || this.lastPursuedGoal == null || goalStep == this.lastPursuedGoal;
    }
    
    final void suspend(final ExecutableStep executableStep) {
        final Iterator<Step> iterator = this.children.iterator();
        while (iterator.hasNext()) {
            iterator.next().suspend(executableStep);
        }
    }
    
    final void metaSuspend() {
        final Iterator<Step> iterator = this.children.iterator();
        while (iterator.hasNext()) {
            iterator.next().metaSuspend();
        }
    }
    
    final void unsuspend(final ExecutableStep executableStep) {
        final Iterator<Step> iterator = this.children.iterator();
        while (iterator.hasNext()) {
            iterator.next().unsuspend(executableStep);
        }
    }
    
    final void metaUnsuspend() {
        final Iterator<Step> iterator = this.children.iterator();
        while (iterator.hasNext()) {
            iterator.next().metaUnsuspend();
        }
    }
    
    final void jointUnsuspend() {
        final Iterator<Step> iterator = this.children.iterator();
        while (iterator.hasNext()) {
            iterator.next().jointUnsuspend();
        }
    }
    
    final void suspendSkipJointGoals(final ExecutableStep executableStep) {
        for (final Step step : this.children) {
            if (step.getStepType() != 1 || !((GoalStep)step).isJointGoal()) {
                if (step.getStepType() == 1) {
                    ((GoalStep)step).suspendSkipJointGoals(executableStep);
                }
                else {
                    step.suspend(executableStep);
                }
            }
        }
    }
    
    final void metaSuspendSkipJointGoals() {
        for (final Step step : this.children) {
            if (step.getStepType() != 1 || !((GoalStep)step).isJointGoal()) {
                if (step.getStepType() == 1) {
                    ((GoalStep)step).metaSuspendSkipJointGoals();
                }
                else {
                    step.metaSuspend();
                }
            }
        }
    }
    
    final List freezeSubtreeAndNegotiateRemoval() {
        if (this.hasTeamEffectOnlySteps()) {
            return this.freezeNonTeamEffectOnlySubtreeAndNegotiateRemoval();
        }
        BehavingEntity.getBehavingEntity().removeBehavior(this);
        final Iterator<Step> iterator = this.children.iterator();
        final Vector vector = new Vector();
        while (iterator.hasNext()) {
            vector.addAll(this.freezeChild(iterator.next()));
        }
        return vector;
    }
    
    protected final List freezeNonTeamEffectOnlySubtreeAndNegotiateRemoval() {
        BehavingEntity.getBehavingEntity().removeBehavior(this);
        final Iterator<Step> iterator = this.children.iterator();
        final Vector vector = new Vector();
        while (iterator.hasNext()) {
            final Step step = iterator.next();
            if (!step.getTeamEffectOnly()) {
                vector.addAll(this.freezeChild(step));
            }
        }
        return vector;
    }
    
    protected final boolean hasTeamEffectOnlySteps() {
        final Iterator<Step> iterator = this.children.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getTeamEffectOnly()) {
                return true;
            }
        }
        return false;
    }
    
    final List negotiateSuspensionOfSubtree() {
        final Iterator<Step> iterator = this.children.iterator();
        final Vector vector = new Vector();
        while (iterator.hasNext()) {
            vector.addAll(this.negotiateSuspensionOfChild(iterator.next()));
        }
        return vector;
    }
    
    final List negotiateSuspensionOfSubtree(final ExecutableStep executableStep) {
        final Iterator<Step> iterator = this.children.iterator();
        final Vector vector = new Vector();
        while (iterator.hasNext()) {
            vector.addAll(this.negotiateSuspensionOfChild(iterator.next(), executableStep));
        }
        return vector;
    }

    public MultiStepBehavior(final GoalStep goalStep, final Method method, final Method method2, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final int numberNeededForSuccess) {
        super(goalStep, method, method2, null, null, b, s, n, n2, array, array2);
        this.children = new HashSet();
        this.numberNeededForSuccess = -1;
        this.numberOfCompletedSteps = 0;
        this.lastPursuedGoal = null;
        if (numberNeededForSuccess == -1) {
            if (this.getBehaviorType() != 3) {
                this.numberNeededForSuccess = 0;
                final Step[] allSteps = this.getAllSteps();
                for (int i = 0; i < allSteps.length; ++i) {
                    if (!allSteps[i].getEffectOnlyOrTeamEffectOnly()) {
                        ++this.numberNeededForSuccess;
                    }
                }
            }
        }
        else {
            this.numberNeededForSuccess = numberNeededForSuccess;
        }
    }
    
    public MultiStepBehavior(final GoalStep goalStep, final Method method, final Method method2, final Method method3, final Method method4, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final int numberNeededForSuccess) {
        super(goalStep, method, method2, method3, method4, b, s, n, n2, array, array2);
        this.children = new HashSet();
        this.numberNeededForSuccess = -1;
        this.numberOfCompletedSteps = 0;
        this.lastPursuedGoal = null;
        if (numberNeededForSuccess == -1) {
            if (this.getBehaviorType() != 3) {
                this.numberNeededForSuccess = 0;
                final Step[] allSteps = this.getAllSteps();
                for (int i = 0; i < allSteps.length; ++i) {
                    if (!allSteps[i].getEffectOnlyOrTeamEffectOnly()) {
                        ++this.numberNeededForSuccess;
                    }
                }
            }
        }
        else {
            this.numberNeededForSuccess = numberNeededForSuccess;
        }
    }
    
    public MultiStepBehavior(final GoalStep goalStep, final Method method, final Method method2, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final int numberNeededForSuccess, final BehavingEntity[] array3) {
        super(goalStep, method, method2, null, null, b, s, n, n2, array, array2, array3);
        this.children = new HashSet();
        this.numberNeededForSuccess = -1;
        this.numberOfCompletedSteps = 0;
        this.lastPursuedGoal = null;
        if (numberNeededForSuccess == -1) {
            final Step[] allSteps = this.getAllSteps();
            this.numberNeededForSuccess = 0;
            for (int i = 0; i < allSteps.length; ++i) {
                if (!allSteps[i].getEffectOnlyOrTeamEffectOnly()) {
                    ++this.numberNeededForSuccess;
                }
            }
        }
        else {
            this.numberNeededForSuccess = numberNeededForSuccess;
        }
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.MultiStepBehavior;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
