package abl.runtime;

import java.util.LinkedList;
import wm.WME;
import wm.WorkingMemory;
import java.util.Collection;
import java.util.Vector;
import java.util.List;
import java.lang.reflect.Method;

public abstract class Step implements ABTNode
{
    public static final short PRIMITIVE = 0;
    public static final short GOAL = 1;
    public static final short MENTAL = 2;
    public static final short WAIT = 3;
    public static final short FAIL = 4;
    public static final short SUCCEED = 5;
    public static final short EXECUTE_POLICY = 6;
    protected Behavior parent;
    private boolean persistent;
    private boolean persistentWhenSucceeds;
    private boolean persistentWhenFails;
    private boolean ignoreFailure;
    private boolean effectOnly;
    private boolean teamEffectOnly;
    private short priority;
    private short priorityModifier;
    private boolean isAtomic;
    private boolean post;
    private String postMemory;
    protected final Method execute;
    private final Method successTest;
    private final Method successTestSensorFactory;
    private final short stepType;
    protected final int stepID;
    protected List stepsSuspendingMe;
    protected List stepsIHaveSuspended;
    private int metaSuspenderCount;
    private int jointSuspenderCount;
    final AblNamedPropertySupport propertyTable;
    private StepWME stepWME;
    private static final /* synthetic */ boolean $noassert;
    
    public String toString() {
        String s = null;
        switch (this.getStepType()) {
            case 1: {
                if (((GoalStep)this).getGoalExecutionType() != 0 && !((GoalStep)this).getRerooted()) {
                    s = "spawngoal " + ((GoalStep)this).getSignature();
                }
                else {
                    s = "subgoal " + ((GoalStep)this).getSignature();
                }
                if (((GoalStep)this).isJointGoal()) {
                    s = "joint " + s;
                }
                break;
            }
            case 0: {
                s = "act " + ((PrimitiveStep)this).name;
                break;
            }
            case 3: {
                s = "wait";
                break;
            }
            case 2: {
                s = "mental";
                break;
            }
            case 4: {
                s = "fail_step";
                break;
            }
            case 5: {
                s = "succeed_step";
                break;
            }
            case 6: {
                s = "execute_policy";
                break;
            }
            default: {
                return "UNEXPECTED STEP TYPE";
            }
        }
        return s;
    }
    
    final short getStepType() {
        return this.stepType;
    }
    
    final boolean getPersistent() {
        return this.persistent;
    }
    
    final boolean getPersistentWhenSucceeds() {
        return this.persistentWhenSucceeds;
    }
    
    final boolean getPersistentWhenFails() {
        return this.persistentWhenFails;
    }
    
    final boolean getIgnoreFailure() {
        return this.ignoreFailure;
    }
    
    final boolean getHasSuccessTest() {
        return this.successTest != null;
    }
    
    final boolean getEffectOnly() {
        return this.effectOnly;
    }
    
    final boolean getTeamEffectOnly() {
        return this.teamEffectOnly;
    }
    
    final boolean getEffectOnlyOrTeamEffectOnly() {
        boolean b = false;
        if (this.effectOnly || this.teamEffectOnly) {
            b = true;
        }
        return b;
    }
    
    final short getPriority() {
        if (this.priority == -32768) {
            return this.priority = (short)(this.parent.getPriority() + this.priorityModifier);
        }
        return this.priority;
    }
    
    final short getPriorityModifier() {
        return this.priorityModifier;
    }
    
    final boolean getIsAtomic() {
        return this.isAtomic;
    }
    
    final List getStepsSuspendingMe() {
        return new Vector(this.stepsSuspendingMe);
    }
    
    final List getStepsIHaveSuspended() {
        return new Vector(this.stepsIHaveSuspended);
    }
    
    final Behavior getParent() {
        return this.parent;
    }
    
    final int getMetaSuspenderCount() {
        return this.metaSuspenderCount;
    }
    
    final void setPersistent(final boolean persistent) {
        this.persistent = persistent;
    }
    
    final void setPersistentWhenSucceeds(final boolean persistentWhenSucceeds) {
        this.persistentWhenSucceeds = persistentWhenSucceeds;
    }
    
    final void setPersistentWhenFails(final boolean persistentWhenFails) {
        this.persistentWhenFails = persistentWhenFails;
    }
    
    final void setIgnoreFailure(final boolean ignoreFailure) {
        this.ignoreFailure = ignoreFailure;
    }
    
    final void setEffectOnly(final boolean effectOnly) {
        this.effectOnly = effectOnly;
    }
    
    final void setTeamEffectOnly(final boolean teamEffectOnly) {
        this.teamEffectOnly = teamEffectOnly;
    }
    
    final void setPriority(final short priority) {
        this.priority = priority;
    }
    
    final void setPriorityModifier(final short priority) {
        this.priority = priority;
    }
    
    boolean successTest() {
        if (this.successTest == null) {
            return false;
        }
        final Object[] array = { new Integer(this.stepID), this.parent.getBehaviorVariableFrame(), BehavingEntity.getBehavingEntity() };
        try {
            return (boolean)this.successTest.invoke(null, array);
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking success test", ex);
        }
    }
    
    final SensorActivation[] getSuccessTestSensorActivations() {
        if (this.successTestSensorFactory == null) {
            return null;
        }
        final Object[] array = { new Integer(this.stepID) };
        try {
            return (SensorActivation[])this.successTestSensorFactory.invoke(null, array);
        }
        catch (Exception ex) {
            throw new AblRuntimeError("Error invoking success test sensor factory", ex);
        }
    }
    
    abstract void execute();
    
    protected void executeBookkeeping() {
        BehavingEntity.getBehavingEntity().executeStep(this);
    }
    
    private final void postCompletionWME(final int n, final String s) {
        if (s != null && !Step.$noassert && WorkingMemory.lookupRegisteredMemory(s) == null) {
            throw new AssertionError((Object)("memory " + s + " does not exist."));
        }
        CompletedStepWME completedStepWME = null;
        switch (this.getStepType()) {
            case 0: {
                completedStepWME = new CompletedActWME(((PrimitiveStep)this).name, n, this.parent.getSignature(), BehavingEntity.getBehavingEntity().getBehavingEntityShortName());
                break;
            }
            case 1: {
                completedStepWME = new CompletedGoalWME(((GoalStep)this).getSignature(), n, this.parent.getSignature(), BehavingEntity.getBehavingEntity().getBehavingEntityShortName());
                break;
            }
            case 2: {
                completedStepWME = new CompletedMentalActWME(this.parent.getSignature(), BehavingEntity.getBehavingEntity().getBehavingEntityShortName());
                break;
            }
            case 3: {
                completedStepWME = new CompletedWaitWME(this.parent.getSignature(), BehavingEntity.getBehavingEntity().getBehavingEntityShortName());
                break;
            }
            default: {
                throw new AblRuntimeError("Unexpected step type " + this.getStepType());
            }
        }
        WorkingMemory workingMemory;
        if (s == null) {
            workingMemory = BehavingEntity.getBehavingEntity().getWorkingMemory();
        }
        else {
            workingMemory = WorkingMemory.lookupRegisteredMemory(s);
        }
        workingMemory.addWME(completedStepWME);
    }
    
    void succeedStep() {
        if (this.post) {
            this.postCompletionWME(0, null);
        }
        if (this.postMemory != null) {
            this.postCompletionWME(0, this.postMemory);
        }
        if (this.getPersistent() || this.getPersistentWhenSucceeds()) {
            this.resetStep();
        }
        else {
            this.parent.removeChild(this, true);
            if (this.parent.getBehaviorType() == 0) {
                final Step nextStep = ((SequentialBehavior)this.parent).getNextStep();
                if (nextStep == null) {
                    this.parent.succeedBehavior();
                }
                else {
                    ((SequentialBehavior)this.parent).addChild(nextStep);
                }
            }
            else if (this.parent.getBehaviorType() == 3) {
                final AdaptiveBehavior adaptiveBehavior = (AdaptiveBehavior)this.parent;
                adaptiveBehavior.updatePolicy();
                adaptiveBehavior.addChildren();
            }
            else if (((MultiStepBehavior)this.parent).isSuccessful()) {
                this.parent.succeedBehavior();
            }
        }
    }
    
    void failStep() {
        if (this.post) {
            this.postCompletionWME(1, null);
        }
        if (this.postMemory != null) {
            this.postCompletionWME(1, this.postMemory);
        }
        if (this.getIgnoreFailure()) {
            this.succeedStep();
        }
        else if (this.getPersistent() || this.getPersistentWhenFails()) {
            this.resetStep();
        }
        else {
            this.parent.removeChild(this, true);
            if (this.parent.getBehaviorType() == 2) {
                if (((MultiStepBehavior)this.parent).isSuccessful()) {
                    this.parent.succeedBehavior();
                }
            }
            else if (this.parent.getBehaviorType() == 3) {
                final AdaptiveBehavior adaptiveBehavior = (AdaptiveBehavior)this.parent;
                adaptiveBehavior.updatePolicy();
                adaptiveBehavior.addChildren();
            }
            else if (!this.getEffectOnly() && !this.getTeamEffectOnly()) {
                this.parent.failBehavior();
            }
        }
    }
    
    abstract void resetStep();
    
    boolean currentLineOfExpansion(final GoalStep goalStep) {
        return this.parent.currentLineOfExpansion(goalStep);
    }
    
    void suspend(final ExecutableStep executableStep) {
        this.stepsSuspendingMe.add(executableStep);
        executableStep.suspenderFor(this);
    }
    
    void unsuspend(final ExecutableStep executableStep) {
        this.stepsSuspendingMe.remove(executableStep);
        executableStep.unsuspenderFor(this);
    }
    
    void metaSuspend() {
        if (!Step.$noassert && this.metaSuspenderCount < 0) {
            throw new AssertionError();
        }
        ++this.metaSuspenderCount;
    }
    
    void metaUnsuspend() {
        if (!Step.$noassert && this.metaSuspenderCount < 0) {
            throw new AssertionError();
        }
        if (this.metaSuspenderCount > 0) {
            --this.metaSuspenderCount;
        }
    }
    
    void jointSuspend() {
        if (!Step.$noassert && this.jointSuspenderCount < 0) {
            throw new AssertionError();
        }
        ++this.jointSuspenderCount;
    }
    
    void jointUnsuspend() {
        if (!Step.$noassert && this.jointSuspenderCount <= 0) {
            throw new AssertionError();
        }
        --this.jointSuspenderCount;
    }
    
    boolean isSuspended() {
        return !this.stepsSuspendingMe.isEmpty() || this.metaSuspenderCount > 0 || this.jointSuspenderCount > 0;
    }
    
    void updateStepsSuspendingMe() {
        final ExecutableStep[] array = this.stepsSuspendingMe.toArray(new ExecutableStep[this.stepsSuspendingMe.size()]);
        for (int i = 0; i < array.length; ++i) {
            array[i].unsuspenderFor(this);
        }
    }
    
    void setReflectionWME(final StepWME stepWME) {
        if (!Step.$noassert && stepWME == null) {
            throw new AssertionError();
        }
        this.stepWME = stepWME;
    }
    
    public StepWME getReflectionWME() {
        if (BehavingEntity.getBehavingEntity().reflectionEnabled() && this.stepWME == null) {
            System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ UNEXPECTED NULL REFLECTION WME in " + BehavingEntity.getBehavingEntity());
            BehavingEntity.printABTBranchUpwards(this);
            throw new AblRuntimeError("Unexpected NULL Reflection WME in " + BehavingEntity.getBehavingEntity());
        }
        return this.stepWME;
    }
    
    private final /* synthetic */ void this() {
        this.persistent = false;
        this.persistentWhenSucceeds = false;
        this.persistentWhenFails = false;
        this.ignoreFailure = false;
        this.effectOnly = false;
        this.teamEffectOnly = false;
        this.priority = -32768;
        this.priorityModifier = 0;
        this.isAtomic = false;
        this.post = false;
        this.postMemory = null;
        this.stepsSuspendingMe = new LinkedList();
        this.stepsIHaveSuspended = new LinkedList();
        this.metaSuspenderCount = 0;
        this.jointSuspenderCount = 0;
        this.stepWME = null;
    }
    
    public Step(final int stepID, final Behavior parent, final boolean persistent, final boolean persistentWhenSucceeds, final boolean persistentWhenFails, final boolean ignoreFailure, final boolean effectOnly, final boolean teamEffectOnly, final short priority, final short priorityModifier, final boolean post, final String postMemory, final Method execute, final Method successTest, final Method successTestSensorFactory, final AblNamedPropertySupport propertyTable, final short stepType) {
        this.this();
        this.stepID = stepID;
        this.parent = parent;
        this.isAtomic = this.parent.isAtomic;
        this.persistent = persistent;
        this.persistentWhenSucceeds = persistentWhenSucceeds;
        this.persistentWhenFails = persistentWhenFails;
        this.ignoreFailure = ignoreFailure;
        this.effectOnly = effectOnly;
        this.teamEffectOnly = teamEffectOnly;
        this.priority = priority;
        this.priorityModifier = priorityModifier;
        this.post = post;
        this.postMemory = postMemory;
        this.execute = execute;
        this.successTest = successTest;
        this.successTestSensorFactory = successTestSensorFactory;
        if (propertyTable != null) {
            this.propertyTable = propertyTable;
        }
        else {
            this.propertyTable = new AblNamedPropertySupport();
        }
        this.stepType = stepType;
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.Step;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
