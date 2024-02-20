package abl.runtime;

import java.util.HashSet;
import java.util.Vector;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.lang.reflect.Method;
import java.util.Set;
import java.beans.PropertyChangeSupport;

public abstract class Behavior implements ABTNode
{
    public static final short SEQUENTIAL = 0;
    public static final short PARALLEL = 1;
    public static final short COLLECTION = 2;
    public static final short ADAPTIVE = 3;
    final AblNamedPropertySupport propertyTable;
    protected GoalStep parent;
    private short priority;
    protected boolean isAtomic;
    protected PropertyChangeSupport changes;
    protected boolean behaviorRemoved;
    protected final String signature;
    protected final Object[] behaviorVariableFrame;
    protected final __StepDesc[] stepDescs;
    protected short specificity;
    protected Set teamMembers;
    protected final int behaviorID;
    private final Method contextCondition;
    private final Method contextConditionSensorFactory;
    private final Method successCondition;
    private final Method successConditionSensorFactory;
    private BehaviorWME behaviorWME;
    private static final /* synthetic */ boolean $noassert;
    
    boolean getBehaviorRemoved() {
        return this.behaviorRemoved;
    }
    
    void setBehaviorRemoved() {
        this.behaviorRemoved = true;
    }
    
    Object[] getBehaviorVariableFrame() {
        return this.behaviorVariableFrame;
    }
    
    int getID() {
        return this.behaviorID;
    }
    
    short getPriority() {
        return this.priority;
    }
    
    final GoalStep getParent() {
        return this.parent;
    }
    
    public String toString() {
        try {
            final String signature = this.getSignature();
            String s = null;
            switch (this.getBehaviorType()) {
                case 0: {
                    s = "sequential";
                    break;
                }
                case 1: {
                    s = "parallel";
                    break;
                }
                case 2: {
                    s = "collection";
                    break;
                }
                default: {
                    s = "UNEXPECTED BEHAVIOR TYPE";
                    break;
                }
            }
            return s + ' ' + signature + " priority: " + this.priority;
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Reflection error in SequentialBehavior.toString()");
        }
    }
    
    abstract short getBehaviorType();
    
    boolean getHasContextCondition() {
        return this.contextCondition != null;
    }
    
    boolean getHasSuccessCondition() {
        return this.successCondition != null;
    }
    
    short getSpecificity() {
        return this.specificity;
    }
    
    void setSpecificity(final short specificity) {
        this.specificity = specificity;
    }
    
    String getSignature() {
        return this.signature;
    }
    
    boolean isJointBehavior() {
        return this.teamMembers != null;
    }
    
    final Set getTeamMembers() {
        if (!Behavior.$noassert && !this.isJointBehavior()) {
            throw new AssertionError();
        }
        return this.teamMembers;
    }
    
    abstract void addChildren();
    
    abstract void removeChildren();
    
    protected abstract boolean hasTeamEffectOnlySteps();
    
    protected void removeChild(final Step step, final boolean b) {
        final short stepType = step.getStepType();
        switch (stepType) {
            case 0: {
                if (((PrimitiveStep)step).isExecuting()) {
                    ((PrimitiveStep)step).abort();
                }
                ((PrimitiveStep)step).processStepRemoval();
                BehavingEntity.getBehavingEntity().removeStep(step);
                this.changes.firePropertyChange("child", step, null);
                break;
            }
            case 1: {
                if (((GoalStep)step).isExpanded()) {
                    ((GoalStep)step).removeGoal();
                }
                ((GoalStep)step).processStepRemoval();
                BehavingEntity.getBehavingEntity().removeStep(step);
                this.changes.firePropertyChange("child", step, null);
                break;
            }
            case 2: {
                ((MentalStep)step).delete();
                BehavingEntity.getBehavingEntity().removeStep(step);
                this.changes.firePropertyChange("child", step, null);
                break;
            }
            case 3:
            case 4:
            case 5:
            case 6: {
                BehavingEntity.getBehavingEntity().removeStep(step);
                this.changes.firePropertyChange("child", step, null);
                break;
            }
            default: {
                throw new AblRuntimeError("Unexpected step type " + stepType);
            }
        }
    }
    
    private final void failBehaviorBody() {
        BehavingEntity.getBehavingEntity().removeBehavior(this);
        this.removeChildren();
        if (this.parent != null) {
            this.parent.addFailedBehavior(this);
            this.parent.removeChild(false);
            BehavingEntity.getBehavingEntity().resetStep(this.parent);
        }
    }
    
    void failBehavior() {
        final List freezeSubtreeAndNegotiateRemoval = this.freezeSubtreeAndNegotiateRemoval();
        if (!freezeSubtreeAndNegotiateRemoval.isEmpty()) {
            BehavingEntity.getBehavingEntity().registerNegotiationThread(new JointGoalNegotiationThread((JointGoalStep)null, this + " negotiateFailThread") {
                public final void run() {
                    JointGoalStep.blockOnSubtreeNegotiation(freezeSubtreeAndNegotiateRemoval);
                    Behavior.this.failBehaviorBody();
                }
            });
        }
        else {
            this.failBehaviorBody();
        }
    }
    
    void removeBehavior() {
        BehavingEntity.getBehavingEntity().removeBehavior(this);
        this.removeChildren();
    }
    
    private final void succeedBehaviorBody() {
        BehavingEntity.getBehavingEntity().removeBehavior(this);
        this.removeChildren();
        if (this.parent != null) {
            this.parent.removeChild(false);
            this.parent.succeedStep();
        }
    }
    
    void succeedBehavior() {
        final List freezeSubtreeAndNegotiateRemoval = this.freezeSubtreeAndNegotiateRemoval();
        if (!freezeSubtreeAndNegotiateRemoval.isEmpty()) {
            BehavingEntity.getBehavingEntity().registerNegotiationThread(new JointGoalNegotiationThread((JointGoalStep)null, this + " negotiateSucceedThread") {
                public final void run() {
                    JointGoalStep.blockOnSubtreeNegotiation(freezeSubtreeAndNegotiateRemoval);
                    Behavior.this.succeedBehaviorBody();
                }
            });
        }
        else if (this.isJointBehavior() && this.hasTeamEffectOnlySteps()) {
            this.parent.succeedStep();
        }
        else {
            this.succeedBehaviorBody();
        }
    }
    
    boolean contextCondition() {
        if (this.contextCondition == null) {
            return true;
        }
        final Object[] array = { new Integer(this.behaviorID), this.behaviorVariableFrame, BehavingEntity.getBehavingEntity() };
        try {
            return (boolean)this.contextCondition.invoke(null, array);
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking context condition", ex);
        }
    }
    
    final SensorActivation[] getContextConditionSensorActivations() {
        if (this.contextConditionSensorFactory == null) {
            return null;
        }
        final Object[] array = { new Integer(this.behaviorID) };
        try {
            return (SensorActivation[])this.contextConditionSensorFactory.invoke(null, array);
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking context condition sensor factory", ex);
        }
    }
    
    boolean successCondition() {
        if (this.successCondition == null) {
            return false;
        }
        final Object[] array = { new Integer(this.behaviorID), this.behaviorVariableFrame, BehavingEntity.getBehavingEntity() };
        try {
            return (boolean)this.successCondition.invoke(null, array);
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking success condition", ex);
        }
    }
    
    final SensorActivation[] getSuccessConditionSensorActivations() {
        if (this.successConditionSensorFactory == null) {
            return null;
        }
        final Object[] array = { new Integer(this.behaviorID) };
        try {
            return (SensorActivation[])this.successConditionSensorFactory.invoke(null, array);
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking success condition sensor factory", ex);
        }
    }
    
    abstract boolean currentLineOfExpansion(final GoalStep p0);
    
    abstract void suspend(final ExecutableStep p0);
    
    abstract void suspendSkipJointGoals(final ExecutableStep p0);
    
    abstract void jointUnsuspend();
    
    abstract void unsuspend(final ExecutableStep p0);
    
    abstract void metaSuspend();
    
    abstract void metaSuspendSkipJointGoals();
    
    abstract void metaUnsuspend();
    
    public void addChildChangeListener(final PropertyChangeListener propertyChangeListener) {
        this.changes.addPropertyChangeListener("child", propertyChangeListener);
    }
    
    public void removeChildChangeListener(final PropertyChangeListener propertyChangeListener) {
        this.changes.removePropertyChangeListener("child", propertyChangeListener);
    }
    
    void setReflectionWME(final BehaviorWME behaviorWME) {
        this.behaviorWME = behaviorWME;
    }
    
    protected BehaviorWME getReflectionWME() {
        return this.behaviorWME;
    }
    
    abstract List freezeSubtreeAndNegotiateRemoval();
    
    protected abstract List freezeNonTeamEffectOnlySubtreeAndNegotiateRemoval();
    
    abstract List negotiateSuspensionOfSubtree();
    
    abstract List negotiateSuspensionOfSubtree(final ExecutableStep p0);
    
    protected List freezeChild(final Step step) {
        final short stepType = step.getStepType();
        switch (stepType) {
            case 0: {
                if (((PrimitiveStep)step).isExecuting()) {
                    ((PrimitiveStep)step).abort();
                }
                BehavingEntity.getBehavingEntity().removeStep(step);
                step.updateStepsSuspendingMe();
                return new Vector(0);
            }
            case 1: {
                BehavingEntity.getBehavingEntity().removeStep(step);
                step.updateStepsSuspendingMe();
                return ((GoalStep)step).freezeSubtreeAndNegotiateRemoval();
            }
            case 2: {
                ((MentalStep)step).delete();
                BehavingEntity.getBehavingEntity().removeStep(step);
                step.updateStepsSuspendingMe();
                return new Vector(0);
            }
            case 3:
            case 4:
            case 5:
            case 6: {
                BehavingEntity.getBehavingEntity().removeStep(step);
                step.updateStepsSuspendingMe();
                return new Vector(0);
            }
            default: {
                throw new AblRuntimeError("Unexpected step type " + stepType);
            }
        }
    }
    
    protected List negotiateSuspensionOfChild(final Step step, final ExecutableStep executableStep) {
        final short stepType = step.getStepType();
        switch (stepType) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5: {
                if (executableStep != null) {
                    step.suspend(executableStep);
                }
                else {
                    step.metaSuspend();
                }
                return new Vector(0);
            }
            case 1: {
                return ((GoalStep)step).negotiateSuspensionOfSubtree(executableStep);
            }
            default: {
                throw new AblRuntimeError("Unexpected step type " + stepType);
            }
        }
    }
    
    protected List negotiateSuspensionOfChild(final Step step) {
        final short stepType = step.getStepType();
        switch (stepType) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5: {
                step.jointSuspend();
                return new Vector(0);
            }
            case 1: {
                return ((GoalStep)step).negotiateSuspensionOfSubtree();
            }
            default: {
                throw new AblRuntimeError("Unexpected step type " + stepType);
            }
        }
    }
    
    boolean isRootBehavior() {
        return this.parent == null;
    }

    
    public Behavior(final GoalStep parent, final Method contextCondition, final Method contextConditionSensorFactory, final Method successCondition, final Method successConditionSensorFactory, final boolean isAtomic, final String signature, final short specificity, final int behaviorID, final Object[] behaviorVariableFrame, final __StepDesc[] stepDescs) {
        this.propertyTable = new AblNamedPropertySupport();
        this.priority = 0;
        this.isAtomic = false;
        this.changes = new PropertyChangeSupport(this);
        this.behaviorRemoved = false;
        this.teamMembers = null;
        this.behaviorWME = null;
        this.parent = parent;
        if (parent != null && !this.isAtomic) {
            this.isAtomic = this.parent.getIsAtomic();
        }
        else {
            this.isAtomic = isAtomic;
        }
        this.contextCondition = contextCondition;
        this.contextConditionSensorFactory = contextConditionSensorFactory;
        this.successCondition = successCondition;
        this.successConditionSensorFactory = successConditionSensorFactory;
        this.signature = signature;
        this.specificity = specificity;
        this.behaviorID = behaviorID;
        this.behaviorVariableFrame = behaviorVariableFrame;
        this.stepDescs = stepDescs;
        if (this.parent != null) {
            this.priority = this.parent.getPriority();
        }
        else {
            this.priority = 0;
        }
    }
    
    public Behavior(final GoalStep goalStep, final Method method, final Method method2, final Method method3, final Method method4, final boolean b, final String s, final short n, final int n2, final Object[] array, final __StepDesc[] array2, final BehavingEntity[] array3) {
        this(goalStep, method, method2, method3, method4, b, s, n, n2, array, array2);
        if (!Behavior.$noassert && (array3 == null || array3.length <= 0)) {
            throw new AssertionError();
        }
        this.teamMembers = new HashSet();
        for (int i = 0; i < array3.length; ++i) {
            this.teamMembers.add(array3[i]);
        }
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.Behavior;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
