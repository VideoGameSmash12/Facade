package abl.runtime;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Vector;
import debug.Trace;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Hashtable;

public class JointGoalStep extends GoalStep
{
    JointGoalNegotiator negotiator;
    private boolean isNegotiating;
    protected boolean teamNeededForSuccess;
    private static final /* synthetic */ boolean $noassert;
    
    protected JointGoalNegotiator getNewJointGoalNegotiator(final Hashtable hashtable) {
        return new JointGoalNegotiator(hashtable);
    }
    
    protected JointGoalNegotiator getNewJointGoalNegotiator(final Set set) {
        return new JointGoalNegotiator(set, this);
    }
    
    protected JointGoalNegotiator getNewJointGoalNegotiator(final Hashtable hashtable, final int n) {
        return new JointGoalNegotiator(hashtable, n);
    }
    
    protected JointGoalNegotiator getNewJointGoalNegotiator(final Set set, final boolean b) {
        return new JointGoalNegotiator(set, b, this);
    }
    
    boolean isJointGoal() {
        return true;
    }
    
    Set getTeamMembers() {
        if (this.negotiator == null) {
            return null;
        }
        return this.negotiator.getTeamMembers();
    }
    
    synchronized boolean getIsNegotiating() {
        return this.isNegotiating;
    }
    
    synchronized void setIsNegotiating(final boolean isNegotiating) {
        this.isNegotiating = isNegotiating;
    }
    
    boolean getTeamNeededForSuccess() {
        return this.teamNeededForSuccess;
    }
    
    void resetNegotiator(final Hashtable hashtable, final int n) {
        this.negotiator = this.getNewJointGoalNegotiator(hashtable, n);
    }
    
    void chooseBehavior(final Object[] array) {
        final Behavior chooseJointBehavior = BehavingEntity.getBehavingEntity().chooseJointBehavior(array, this.failedBehaviors, this);
        final JointGoalNegotiationThread jointGoalNegotiationThread = new JointGoalNegotiationThread(this.negotiator, this + " negotiateEntryThread") {
            public final void run() {
                JointGoalStep.this.negotiator = JointGoalStep.this.getNewJointGoalNegotiator(chooseJointBehavior.getTeamMembers(), true);
                if (BehavingEntity.getBehavingEntity().negotiateEntry(JointGoalStep.this, array) != null) {
                    JointGoalStep.this.addChild(chooseJointBehavior);
                    JointGoalStep.this.executeBookkeeping();
                }
                else {
                    JointGoalStep.this.addFailedBehavior(chooseJointBehavior);
                    JointGoalStep.this.negotiator = null;
                }
                JointGoalStep.this.setIsNegotiating(false);
            }
        };
        final JointGoalNegotiationThread jointGoalNegotiationThread2 = new JointGoalNegotiationThread(this.negotiator, this + " negotiateFailureOfOtherGoalsThread") {
            final /* synthetic */ JointGoalNegotiationThread val$negotiateEntryThread = jointGoalNegotiationThread;
            
            public final void run() {
                if (JointGoalStep.this.negotiator != null) {
                    JointGoalStep.this.negotiator.negotiateFailure();
                    JointGoalStep.this.removeChild(true);
                    BehavingEntity.getBehavingEntity().registerNegotiationThread(this.val$negotiateEntryThread);
                }
            }
        };
        if (!JointGoalStep.$noassert && this.getIsNegotiating()) {
            throw new AssertionError();
        }
        if (chooseJointBehavior != null) {
            if (this.negotiator == null) {
                this.setIsNegotiating(true);
                BehavingEntity.getBehavingEntity().registerNegotiationThread(jointGoalNegotiationThread);
            }
            else if (!this.negotiator.getTeamMembers().equals(chooseJointBehavior.getTeamMembers())) {
                this.setIsNegotiating(true);
                BehavingEntity.getBehavingEntity().registerNegotiationThread(jointGoalNegotiationThread2);
            }
            else {
                this.addChild(chooseJointBehavior);
                this.executeBookkeeping();
            }
        }
        else {
            this.failStep();
        }
    }
    
    static void blockOnSubtreeNegotiation(final List<JointGoalStep> list) {
        if (!JointGoalStep.$noassert && Thread.currentThread() == BehavingEntity.getBehavingEntity().getDecisionCycleThread()) {
            throw new AssertionError();
        }
        for (final JointGoalStep jointGoalStep : list) {
            if (jointGoalStep.negotiator != null && jointGoalStep.negotiator.getState() != 7 && jointGoalStep.negotiator.getState() != 9 && jointGoalStep.negotiator.getState() != 16 && jointGoalStep.negotiator.getState() != 11) {
                ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
            }
        }
    }
    
    void succeedStep() {
        if (this.negotiator == null) {
            super.succeedStep();
        }
        else if (this.negotiator.getState() == 7) {
            super.succeedStep();
        }
        else {
            BehavingEntity.getBehavingEntity().registerNegotiationThread(new JointGoalNegotiationThread(this.negotiator, this + " negotiateSuccessThread") {
                final /* synthetic */ List val$jointGoals = JointGoalStep.this.freezeSubtreeAndNegotiateRemovalEntry();
                
                public final void run() {
                    JointGoalStep.this.setIsNegotiating(true);
                    JointGoalStep.blockOnSubtreeNegotiation(this.val$jointGoals);
                    if (JointGoalStep.this.negotiator != null) {
                        if (JointGoalStep.this.negotiator.getState() == 6) {
                            JointGoalStep.this.negotiator.negotiateSuccess();
                        }
                        else if (JointGoalStep.this.negotiator.negotiateSuccess()) {
                            JointGoalStep.this.succeedStepSuper();
                            JointGoalStep.this.setIsNegotiating(false);
                        }
                    }
                }
            });
        }
    }
    
    void failStep() {
        Trace.ablTrace("(JointGoalStep)" + this.getSignature() + "failStep()");
        if (this.negotiator == null) {
            super.failStep();
        }
        else if (this.negotiator.getState() == 9) {
            super.failStep();
        }
        else {
            BehavingEntity.getBehavingEntity().registerNegotiationThread(new JointGoalNegotiationThread(this.negotiator, this + " negotiateFailureThread") {
                final /* synthetic */ List val$jointGoals = JointGoalStep.this.freezeSubtreeAndNegotiateRemovalEntry();
                
                public final void run() {
                    JointGoalStep.this.setIsNegotiating(true);
                    JointGoalStep.blockOnSubtreeNegotiation(this.val$jointGoals);
                    if (JointGoalStep.this.negotiator != null && JointGoalStep.this.negotiator.negotiateFailure()) {
                        JointGoalStep.this.failStepSuper();
                        JointGoalStep.this.setIsNegotiating(false);
                    }
                }
            });
        }
    }
    
    private final void negotiateSuspend(final ExecutableStep executableStep) {
        BehavingEntity.getBehavingEntity().registerNegotiationThread(new JointGoalNegotiationThread(this.negotiator, this + " negotiateSuspensionThread") {
            final /* synthetic */ List val$jointGoals = JointGoalStep.this.negotiateSuspensionOfSubtreeEntry(executableStep);
            
            public final void run() {
                JointGoalStep.this.setIsNegotiating(true);
                JointGoalStep.blockOnSubtreeNegotiation(this.val$jointGoals);
                if (JointGoalStep.this.negotiator != null && JointGoalStep.this.negotiator.negotiateSuspend()) {
                    if (executableStep != null) {
                        JointGoalStep.this.suspendSuper(executableStep, false);
                    }
                    else {
                        JointGoalStep.this.metaSuspendSuper(false);
                    }
                    JointGoalStep.this.negotiator.setState(12);
                    JointGoalStep.this.setIsNegotiating(false);
                }
            }
        });
    }
    
    void suspend(final ExecutableStep executableStep) {
        if (this.negotiator == null) {
            super.suspend(executableStep);
        }
        else {
            this.negotiateSuspend(executableStep);
        }
    }
    
    void metaSuspend() {
        if (this.negotiator == null) {
            super.metaSuspend();
        }
        else {
            this.negotiateSuspend(null);
        }
    }
    
    private final void negotiateUnsuspend(final ExecutableStep executableStep) {
        BehavingEntity.getBehavingEntity().registerNegotiationThread(new JointGoalNegotiationThread(this.negotiator, this + " negotiateUnsuspensionThread") {
            public final void run() {
                JointGoalStep.this.setIsNegotiating(true);
                if (JointGoalStep.this.negotiator != null && JointGoalStep.this.negotiator.negotiateUnsuspend()) {
                    if (executableStep != null) {
                        JointGoalStep.this.unsuspendSuper(executableStep);
                    }
                    else {
                        JointGoalStep.this.metaUnsuspendSuper();
                    }
                    JointGoalStep.this.setIsNegotiating(false);
                    if (JointGoalStep.this.isSuspended()) {
                        JointGoalStep.this.negotiator.setState(12);
                    }
                    else {
                        JointGoalStep.this.negotiator.setState(4);
                    }
                }
            }
        });
    }
    
    private final void unsuspendSuper(final ExecutableStep executableStep) {
        super.unsuspend(executableStep);
    }
    
    private final void metaUnsuspendSuper() {
        super.metaUnsuspend();
    }
    
    private final void jointUnsuspendSuper() {
        super.jointUnsuspend();
    }
    
    private final void suspendSuper(final ExecutableStep executableStep, final boolean b) {
        super.suspend(executableStep, b);
    }
    
    private final void metaSuspendSuper(final boolean b) {
        super.metaSuspend(b);
    }
    
    private final void jointSuspendSuper() {
        super.jointSuspend();
    }
    
    private final void failStepSuper() {
        super.failStep();
    }
    
    private final void succeedStepSuper() {
        super.succeedStep();
    }
    
    void unsuspend(final ExecutableStep executableStep) {
        if (this.negotiator != null) {
            this.negotiateUnsuspend(executableStep);
        }
        else {
            super.unsuspend(executableStep);
        }
    }
    
    void metaUnsuspend() {
        if (this.negotiator != null) {
            this.negotiateUnsuspend(null);
        }
        else {
            super.metaUnsuspend();
        }
    }
    
    void jointUnsuspendEntry() {
        super.jointUnsuspend();
    }
    
    void jointUnsuspend() {
        final JointGoalNegotiationThread jointGoalNegotiationThread = new JointGoalNegotiationThread(this.negotiator, this + " jointUnsuspendThread") {
            public final void run() {
                JointGoalStep.this.setIsNegotiating(true);
                if (JointGoalStep.this.negotiator != null && JointGoalStep.this.negotiator.negotiateUnsuspend()) {
                    JointGoalStep.this.jointUnsuspendSuper();
                    JointGoalStep.this.setIsNegotiating(false);
                    if (JointGoalStep.this.isSuspended()) {
                        JointGoalStep.this.negotiator.setState(12);
                    }
                    else {
                        JointGoalStep.this.negotiator.setState(4);
                    }
                }
            }
        };
        if (this.negotiator != null) {
            BehavingEntity.getBehavingEntity().registerNegotiationThread(jointGoalNegotiationThread);
        }
        else {
            super.jointUnsuspend();
        }
    }
    
    void resetStep() {
        super.resetStep();
    }
    
    void cleanupParentIfRoot() {
        if (this.parent.isRootBehavior()) {
            this.parent.removeChild(this, true);
        }
    }
    
    List freezeSubtreeAndNegotiateRemovalEntry() {
        return super.freezeSubtreeAndNegotiateRemoval();
    }
    
    List freezeSubtreeAndNegotiateRemoval() {
        final JointGoalNegotiationThread jointGoalNegotiationThread = new JointGoalNegotiationThread(this.negotiator, this + " negotiateRemovalThread") {
            public final void run() {
                JointGoalStep.this.setIsNegotiating(true);
                if (JointGoalStep.this.negotiator != null && JointGoalStep.this.negotiator.negotiateRemoval()) {
                    JointGoalStep.this.removeGoal();
                    JointGoalStep.this.setIsNegotiating(false);
                }
            }
        };
        if (!JointGoalStep.$noassert && this.child != null && this.negotiator == null) {
            throw new AssertionError((Object)("step = " + this + " negotiator = " + this.negotiator + ", child = " + this.child));
        }
        if (this.negotiator != null) {
            BehavingEntity.getBehavingEntity().registerNegotiationThread(jointGoalNegotiationThread);
            final Vector<JointGoalStep> vector = new Vector<JointGoalStep>(super.freezeSubtreeAndNegotiateRemoval());
            vector.add(this);
            return vector;
        }
        return new Vector(0);
    }
    
    List negotiateSuspensionOfSubtreeEntry() {
        if (this.child != null) {
            return this.child.negotiateSuspensionOfSubtree();
        }
        return new Vector(0);
    }
    
    List negotiateSuspensionOfSubtree() {
        BehavingEntity.getBehavingEntity().registerNegotiationThread(new JointGoalNegotiationThread(this.negotiator, this + " negotiateSuspendThread") {
            public final void run() {
                JointGoalStep.this.setIsNegotiating(true);
                if (JointGoalStep.this.negotiator != null) {
                    if (JointGoalStep.this.negotiator.negotiateSuspend()) {
                        JointGoalStep.this.jointSuspendSuper();
                    }
                    JointGoalStep.this.setIsNegotiating(false);
                }
            }
        });
        final Vector<JointGoalStep> vector = new Vector<JointGoalStep>(this.negotiateSuspensionOfSubtreeEntry());
        vector.add(this);
        return vector;
    }
    
    List negotiateSuspensionOfSubtreeEntry(final ExecutableStep executableStep) {
        if (this.child != null) {
            return this.child.negotiateSuspensionOfSubtree(executableStep);
        }
        return new Vector(0);
    }
    
    List negotiateSuspensionOfSubtree(final ExecutableStep executableStep) {
        BehavingEntity.getBehavingEntity().registerNegotiationThread(new JointGoalNegotiationThread(this.negotiator, this + " negotiateSuspendThread") {
            public final void run() {
                JointGoalStep.this.setIsNegotiating(true);
                if (JointGoalStep.this.negotiator != null && JointGoalStep.this.negotiator.negotiateSuspend()) {
                    if (executableStep != null) {
                        JointGoalStep.this.suspendSuper(executableStep, false);
                    }
                    else {
                        JointGoalStep.this.metaSuspendSuper(false);
                    }
                    JointGoalStep.this.setIsNegotiating(false);
                }
            }
        });
        final Vector<JointGoalStep> vector = new Vector<JointGoalStep>(this.negotiateSuspensionOfSubtreeEntry(executableStep));
        vector.add(this);
        return vector;
    }
    
    public JointGoalStep(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final String s2, final String[] array, final boolean teamNeededForSuccess) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, s2, array);
        this.negotiator = null;
        this.isNegotiating = false;
        this.teamNeededForSuccess = teamNeededForSuccess;
    }
    
    public JointGoalStep(final int n, final Behavior behavior, final boolean b, final boolean b2, final boolean b3, final boolean b4, final boolean b5, final boolean b6, final short n2, final short n3, final boolean b7, final String s, final Method method, final Method method2, final Method method3, final AblNamedPropertySupport ablNamedPropertySupport, final String s2, final String[] array, final short n4, final boolean teamNeededForSuccess) {
        super(n, behavior, b, b2, b3, b4, b5, b6, n2, n3, b7, s, method, method2, method3, ablNamedPropertySupport, s2, array, n4);
        this.negotiator = null;
        this.isNegotiating = false;
        this.teamNeededForSuccess = teamNeededForSuccess;
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.JointGoalStep;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
