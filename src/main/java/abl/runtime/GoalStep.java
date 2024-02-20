package abl.runtime;

import java.util.Iterator;
import java.lang.reflect.Method;
import java.util.Vector;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.beans.PropertyChangeSupport;
import java.util.HashSet;

public class GoalStep extends ExecutableStep
{
    public static final short SUBGOAL = 0;
    public static final short SPAWNGOAL_DEFAULT = 1;
    public static final short SPAWNGOAL_AT_NODE = 2;
    protected Behavior child;
    private String signature;
    private short goalExecutionType;
    protected HashSet failedBehaviors;
    private PropertyChangeSupport changes;
    private boolean succeeding;
    private NegotiateSubtreeRemovalThread currentNegotiationThread;
    private Object[] args;
    private MultiStepBehaviorWME rerootParent;
    private boolean rerooted;
    private static final /* synthetic */ boolean $noassert;
    
    String getSignature() {
        return this.signature;
    }
    
    short getGoalExecutionType() {
        return this.goalExecutionType;
    }
    
    boolean getRerooted() {
        return this.rerooted;
    }
    
    boolean isJointGoal() {
        return false;
    }
    
    protected void addFailedBehavior(final Behavior behavior) {
        this.failedBehaviors.add(new Integer(behavior.getID()));
    }
    
    private static final String formatAction(final int n) {
        switch (n) {
            case 1: {
                return "SUCCEED";
            }
            case 2: {
                return "FAIL";
            }
            case 3: {
                return "RESET";
            }
            default: {
                return "INVALID_ACTION";
            }
        }
    }
    
    private final void succeedStepSuper() {
        super.succeedStep();
    }
    
    private final void failStepSuper() {
        super.failStep();
    }
    
    void succeedStep() {
        this.succeeding = true;
        if (!this.isJointGoal()) {
            final List freezeSubtreeAndNegotiateRemoval = this.freezeSubtreeAndNegotiateRemoval();
            if (!freezeSubtreeAndNegotiateRemoval.isEmpty()) {
                if (this.currentNegotiationThread == null || this.currentNegotiationThread.getActionOnCommit() != 1) {
                    final NegotiateSubtreeRemovalThread currentNegotiationThread = new NegotiateSubtreeRemovalThread(freezeSubtreeAndNegotiateRemoval, 1);
                    if (this.currentNegotiationThread != null) {
                        BehavingEntity.getBehavingEntity().unregisterNegotiationThread(this.currentNegotiationThread);
                    }
                    BehavingEntity.getBehavingEntity().registerNegotiationThread(currentNegotiationThread);
                    this.currentNegotiationThread = currentNegotiationThread;
                }
            }
            else {
                super.succeedStep();
            }
        }
        else {
            if (this.child != null) {
                this.child.removeChildren();
            }
            super.succeedStep();
        }
    }
    
    void failStep() {
        if (!this.isJointGoal()) {
            final List freezeSubtreeAndNegotiateRemoval = this.freezeSubtreeAndNegotiateRemoval();
            if (!freezeSubtreeAndNegotiateRemoval.isEmpty()) {
                if (this.currentNegotiationThread == null || this.currentNegotiationThread.getActionOnCommit() != 2) {
                    final NegotiateSubtreeRemovalThread currentNegotiationThread = new NegotiateSubtreeRemovalThread(freezeSubtreeAndNegotiateRemoval, 2);
                    if (this.currentNegotiationThread != null) {
                        BehavingEntity.getBehavingEntity().unregisterNegotiationThread(this.currentNegotiationThread);
                    }
                    BehavingEntity.getBehavingEntity().registerNegotiationThread(currentNegotiationThread);
                    this.currentNegotiationThread = currentNegotiationThread;
                }
            }
            else {
                super.failStep();
            }
        }
        else {
            super.failStep();
        }
    }
    
    void resetStep() {
        if (!this.isJointGoal()) {
            final List freezeSubtreeAndNegotiateRemoval = this.freezeSubtreeAndNegotiateRemoval();
            if (!freezeSubtreeAndNegotiateRemoval.isEmpty()) {
                if (this.currentNegotiationThread == null || this.currentNegotiationThread.getActionOnCommit() != 3) {
                    final NegotiateSubtreeRemovalThread currentNegotiationThread = new NegotiateSubtreeRemovalThread(freezeSubtreeAndNegotiateRemoval, 3);
                    if (this.currentNegotiationThread != null) {
                        BehavingEntity.getBehavingEntity().unregisterNegotiationThread(this.currentNegotiationThread);
                    }
                    BehavingEntity.getBehavingEntity().registerNegotiationThread(currentNegotiationThread);
                    this.currentNegotiationThread = currentNegotiationThread;
                }
            }
            else {
                this.resetStepBody();
            }
        }
        else {
            this.resetStepBody();
        }
    }
    
    private final void resetStepBody() {
        this.removeChild(true);
        this.failedBehaviors.clear();
        BehavingEntity.getBehavingEntity().resetStep(this);
    }
    
    void addChild(final Behavior child) {
        if (child == null) {
            throw new AblRuntimeError("Null ABTNode passed to addChild().");
        }
        if (this.child != null) {
            throw new AblRuntimeError("addChild() called on a GoalStep with non-null child.");
        }
        this.child = child;
        BehavingEntity.getBehavingEntity().addBehavior(this.child);
        this.changes.firePropertyChange("child", null, child);
        this.child.addChildren();
    }
    
    void removeGoal() {
        this.removeChild(true);
    }
    
    void removeChild(final boolean b) {
        if (this.child != null) {
            if (b) {
                this.child.removeBehavior();
            }
            this.changes.firePropertyChange("child", this.child, null);
            this.child = null;
        }
    }
    
    boolean isExecuting() {
        return this.isExpanded() && !this.isSuspended();
    }
    
    boolean isExpanded() {
        return this.child != null;
    }
    
    protected final void executeBookkeeping() {
        final short behaviorType = this.parent.getBehaviorType();
        if (behaviorType == 1 || behaviorType == 2) {
            ((MultiStepBehavior)this.parent).pursueGoal(this);
        }
        super.executeBookkeeping();
    }
    
    private final void rerootGoal(final MultiStepBehaviorWME multiStepBehaviorWME) {
        this.succeedStep();
        if (multiStepBehaviorWME == null) {
            this.parent = BehavingEntity.getBehavingEntity().getRootCollectionBehavior();
        }
        else {
            final Behavior behavior = multiStepBehaviorWME.getBehavior();
            if (behavior == null) {
                System.err.println("WARNING: unexected NULL behavior when attempting to reroot goal " + this + " at behavior " + multiStepBehaviorWME + ". Failing the step");
                this.failStep();
                return;
            }
            this.parent = behavior;
        }
        ((MultiStepBehavior)this.parent).addChild(this);
    }
    
    void chooseBehavior(final Object[] array) {
        final Behavior chooseIndividualBehavior = BehavingEntity.getBehavingEntity().chooseIndividualBehavior(array, this.failedBehaviors, this);
        if (chooseIndividualBehavior != null) {
            if (!GoalStep.$noassert && chooseIndividualBehavior.isJointBehavior()) {
                throw new AssertionError();
            }
            this.addChild(chooseIndividualBehavior);
            this.executeBookkeeping();
        }
        else {
            this.failStep();
        }
    }
    
    boolean currentLineOfExpansion(final GoalStep goalStep) {
        return this.parent.currentLineOfExpansion(this);
    }
    
    void suspend(final ExecutableStep executableStep) {
        this.suspend(executableStep, true);
    }
    
    void suspend(final ExecutableStep executableStep, final boolean b) {
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().suspendStep(this);
        }
        super.suspend(executableStep);
        if (b && this.child != null) {
            this.child.suspend(executableStep);
        }
    }
    
    void suspendSkipJointGoals(final ExecutableStep executableStep) {
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().suspendStep(this);
        }
        super.suspend(executableStep);
        if (this.child != null) {
            this.child.suspendSkipJointGoals(executableStep);
        }
    }
    
    void metaSuspend() {
        this.metaSuspend(true);
    }
    
    void metaSuspend(final boolean b) {
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().suspendStep(this);
        }
        super.metaSuspend();
        if (b && this.child != null) {
            this.child.metaSuspend();
        }
    }
    
    void metaSuspendSkipJointGoals() {
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().suspendStep(this);
        }
        super.metaSuspend();
        if (this.child != null) {
            this.child.metaSuspendSkipJointGoals();
        }
    }
    
    void jointSuspend() {
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().suspendStep(this);
        }
        super.jointSuspend();
    }
    
    void unsuspend(final ExecutableStep executableStep) {
        super.unsuspend(executableStep);
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().unsuspendStep(this);
        }
    }
    
    void metaUnsuspend() {
        super.metaUnsuspend();
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().unsuspendStep(this);
        }
        if (this.child != null) {
            this.child.metaUnsuspend();
        }
    }
    
    void jointUnsuspend() {
        super.jointUnsuspend();
        if (!this.isSuspended()) {
            BehavingEntity.getBehavingEntity().unsuspendStep(this);
        }
        if (this.child != null) {
            this.child.jointUnsuspend();
        }
    }
    
    void addChildChangeListener(final PropertyChangeListener propertyChangeListener) {
        this.changes.addPropertyChangeListener("child", propertyChangeListener);
    }
    
    void removeChildChangeListener(final PropertyChangeListener propertyChangeListener) {
        this.changes.removePropertyChangeListener("child", propertyChangeListener);
    }
    
    List freezeSubtreeAndNegotiateRemoval() {
        BehavingEntity.getBehavingEntity().removeSuccessTest(this);
        if (this.child != null) {
            return this.child.freezeSubtreeAndNegotiateRemoval();
        }
        return new Vector(0);
    }
    
    List negotiateSuspensionOfSubtree() {
        this.jointSuspend();
        if (this.child != null) {
            return this.child.negotiateSuspensionOfSubtree();
        }
        return new Vector(0);
    }
    
    List negotiateSuspensionOfSubtree(final ExecutableStep executableStep) {
        if (executableStep != null) {
            this.suspend(executableStep, false);
        }
        else {
            this.metaSuspend(false);
        }
        if (this.child != null) {
            return this.child.negotiateSuspensionOfSubtree(executableStep);
        }
        return new Vector(0);
    }
    
    void processStepRemoval() {
        if (this.succeeding) {
            if (this.goalExecutionType == 0 || this.rerooted) {
                super.processStepRemoval();
            }
            else {
                this.rerooted = true;
                this.succeeding = false;
            }
        }
        else {
            super.processStepRemoval();
        }
    }
    
    private final void bindArgs() {
        if (this.execute != null) {
            final Object[] array = { new Integer(this.stepID), this.parent.getBehaviorVariableFrame(), BehavingEntity.getBehavingEntity() };
            try {
                final Object[] args = (Object[])this.execute.invoke(null, array);
                if (this.goalExecutionType != 2) {
                    this.args = args;
                }
                else {
                    final int n = args.length - 1;
                    this.args = new Object[n];
                    for (int i = 0; i < n; ++i) {
                        this.args[i] = args[i + 1];
                    }
                    this.rerootParent = (MultiStepBehaviorWME)args[0];
                }
            }
            catch (Exception ex) {
                throw new AblRuntimeError("Error invoking execute", ex);
            }
        }
        else {
            this.args = null;
        }
    }
    
    void execute() {
        this.checkForConflictsOnExecution();
        if (!this.isSuspended()) {
            if (this.goalExecutionType != 0) {
                if (!this.rerooted) {
                    this.bindArgs();
                    this.rerootGoal(this.rerootParent);
                }
                else {
                    this.chooseBehavior(this.args);
                }
            }
            else {
                this.bindArgs();
                this.chooseBehavior(this.args);
            }
        }
    }
    
    private final /* synthetic */ void this() {
        this.child = null;
        this.goalExecutionType = 0;
        this.failedBehaviors = new HashSet();
        this.changes = new PropertyChangeSupport(this);
        this.succeeding = false;
        this.currentNegotiationThread = null;
        this.rerootParent = null;
        this.rerooted = false;
    }
    
    public GoalStep(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final String signature, final String[] array) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, (short)1, array);
        this.this();
        this.signature = signature;
        this.name = this.signature.substring(0, this.signature.indexOf("("));
    }
    
    public GoalStep(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final String signature, final String[] array, final short goalExecutionType) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, (short)1, array);
        this.this();
        this.signature = signature;
        this.name = this.signature.substring(0, this.signature.indexOf("("));
        this.goalExecutionType = goalExecutionType;
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.GoalStep;").getComponentType().desiredAssertionStatus() ^ true);
    }
    
    private class NegotiateSubtreeRemovalThread extends JointGoalNegotiationThread
    {
        static final int INVALID_ACTION = 0;
        static final int SUCCEED = 1;
        static final int FAIL = 2;
        static final int RESET = 3;
        private List jointGoals;
        private int actionOnCommit;
        private static final /* synthetic */ boolean $noassert;
        
        int getActionOnCommit() {
            return this.actionOnCommit;
        }
        
        public void run() {
            for (final JointGoalStep jointGoalStep : this.jointGoals) {
                if (jointGoalStep.negotiator != null && jointGoalStep.negotiator.getState() != 7 && jointGoalStep.negotiator.getState() != 9 && jointGoalStep.negotiator.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
            }
            switch (this.actionOnCommit) {
                case 1: {
                    GoalStep.this.succeedStepSuper();
                    break;
                }
                case 2: {
                    GoalStep.this.failStepSuper();
                    break;
                }
                case 3: {
                    GoalStep.this.resetStepBody();
                    break;
                }
                default: {
                    throw new AblRuntimeError("Unexpected action type " + this.actionOnCommit);
                }
            }
        }
        
        private final /* synthetic */ void this() {
            this.jointGoals = new Vector(0);
            this.actionOnCommit = 0;
        }
        
        NegotiateSubtreeRemovalThread(final List jointGoals, final int actionOnCommit) {
            super((JointGoalStep)null, GoalStep.this + " NegotiateSubtreeRemovalThread(" + formatAction(actionOnCommit) + ')');
            this.this();
            if (!NegotiateSubtreeRemovalThread.$noassert && (actionOnCommit <= 0 || actionOnCommit > 3)) {
                throw new AssertionError();
            }
            this.jointGoals = jointGoals;
            this.actionOnCommit = actionOnCommit;
        }
        
        static {
            $noassert = (Class.forName("[Labl.runtime.GoalStep;").getComponentType().desiredAssertionStatus() ^ true);
        }
    }
}
