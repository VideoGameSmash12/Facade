package abl.runtime;

import debug.Trace;
import java.io.PrintStream;
import java.util.Map;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Hashtable;

public class JointGoalNegotiator
{
    static final int INVALID = -3;
    static final int FIRST_STATE = -1;
    static final int START = -1;
    static final int INTENTION_TO_ENTER = 0;
    static final int INTENTION_TO_REFUSE_ENTRY = 1;
    static final int COMMIT_TO_ENTER = 2;
    static final int COMMIT_TO_REFUSE_ENTRY = 3;
    static final int RUNNING = 4;
    static final int INTENTION_TO_SUCCEED = 5;
    static final int WAIT_FOR_SUCCESS = 6;
    static final int COMMIT_TO_SUCCEED = 7;
    static final int INTENTION_TO_FAIL = 8;
    static final int COMMIT_TO_FAIL = 9;
    static final int INTENTION_TO_SUSPEND = 10;
    static final int COMMIT_TO_SUSPEND = 11;
    static final int SUSPENDED = 12;
    static final int INTENTION_TO_UNSUSPEND = 13;
    static final int COMMIT_TO_UNSUSPEND = 14;
    static final int INTENTION_TO_REMOVE = 15;
    static final int COMMIT_TO_REMOVE = 16;
    static final int LAST_STATE = 16;
    static final int FIRST_ENTRY_INTENTION = 17;
    static final int ENTER = 17;
    static final int REFUSE_ENTRY = 18;
    static final int LAST_ENTRY_INTENTION = 18;
    static final int FIRST_EXIT_INTENTION = 19;
    static final int SUCCEED = 19;
    static final int FAIL = 20;
    static final int REMOVE = 21;
    static final int SUSPEND = 22;
    static final int UNSUSPEND = 23;
    static final int LAST_EXIT_INTENTION = 23;
    private static long uniqueEntryNegotiationID;
    protected int currentState;
    protected final BehavingEntity receiver;
    protected JointGoalStep negotiatingGoal;
    protected Hashtable runningCommitSet;
    protected Set negotiatingCommitSet;
    protected final Set teamMembers;
    protected JointGoalStep escroedGoalStep;
    private static final /* synthetic */ boolean $noassert;
    
    private final boolean teamMembersAreBehavingEntities(final Set set) {
        final Iterator<BehavingEntity> iterator = set.iterator();
        while (iterator.hasNext()) {
            try {
                final BehavingEntity behavingEntity = iterator.next();
            }
            catch (ClassCastException ex) {
                return false;
            }
        }
        return true;
    }
    
    public static String formatIntention(final int n) {
        if (!JointGoalNegotiator.$noassert && (n < 17 || n > 23)) {
            throw new AssertionError();
        }
        switch (n) {
            case 17: {
                return "ENTER";
            }
            case 18: {
                return "REFUSE_ENTRY";
            }
            case 19: {
                return "SUCCEED";
            }
            case 20: {
                return "FAIL";
            }
            case 21: {
                return "REMOVE";
            }
            case 22: {
                return "SUSPEND";
            }
            case 23: {
                return "UNSUSPEND";
            }
            default: {
                return "NOT_INTENTION";
            }
        }
    }
    
    public static String formatState(final int n) {
        if (!JointGoalNegotiator.$noassert && (n < -1 || n > 16)) {
            throw new AssertionError();
        }
        switch (n) {
            case -1: {
                return "START";
            }
            case 0: {
                return "INTENTION_TO_ENTER";
            }
            case 1: {
                return "INTENTION_TO_REFUSE_ENTRY";
            }
            case 2: {
                return "COMMIT_TO_ENTER";
            }
            case 3: {
                return "COMMIT_TO_REFUSE_ENTRY";
            }
            case 4: {
                return "RUNNING";
            }
            case 5: {
                return "INTENTION_TO_SUCCEED";
            }
            case 6: {
                return "WAIT_FOR_SUCCESS";
            }
            case 7: {
                return "COMMIT_TO_SUCCEED";
            }
            case 8: {
                return "INTENTION_TO_FAIL";
            }
            case 9: {
                return "COMMIT_TO_FAIL";
            }
            case 10: {
                return "INTENTION_TO_SUSPEND";
            }
            case 11: {
                return "COMMIT_TO_SUSPEND";
            }
            case 12: {
                return "SUSPENDED";
            }
            case 13: {
                return "INTENTION_TO_UNSUSPEND";
            }
            case 14: {
                return "COMMIT_TO_UNSUSPEND";
            }
            case 15: {
                return "INTENTION_TO_REMOVE";
            }
            case 16: {
                return "COMMIT_TO_REMOVE";
            }
            default: {
                return "INVALID";
            }
        }
    }
    
    Long getUniqueEntryNegotiationID() {
        return new Long(JointGoalNegotiator.uniqueEntryNegotiationID);
    }
    
    synchronized int getState() {
        return this.currentState;
    }
    
    protected synchronized void setState(final int currentState) {
        if (!JointGoalNegotiator.$noassert && (currentState < -1 || currentState > 16)) {
            throw new AssertionError();
        }
        this.currentState = currentState;
        if (currentState == 2 || currentState == 3 || currentState == 7 || currentState == 9 || currentState == 11 || currentState == 14 || currentState == 16) {
            BehavingEntity.getBehavingEntity().jointGoalNegotiatorCommitted();
        }
    }
    
    Set getTeamMembers() {
        return new HashSet(this.teamMembers);
    }
    
    void setCommitSet(final Hashtable hashtable) {
        this.runningCommitSet = new Hashtable(hashtable);
        this.negotiatingGoal = this.runningCommitSet.get(this.receiver);
        if (!JointGoalNegotiator.$noassert && this.negotiatingGoal == null) {
            throw new AssertionError();
        }
    }
    
    Hashtable getCommitSet() {
        return new Hashtable(this.runningCommitSet);
    }
    
    static boolean isLegalState(final int n) {
        return n >= -1 && n <= 16;
    }
    
    protected void initiateNegotiationAction(final JointGoalStep jointGoalStep, final int n) {
    }
    
    protected void completeNegotiationAction(final JointGoalStep jointGoalStep, final int n) {
    }
    
    protected void initiateIntentionAction(final BehavingEntity behavingEntity, final JointGoalStep jointGoalStep, final int n) {
    }
    
    protected void commitToIntentionAction(final JointGoalStep jointGoalStep, final int n) {
    }
    
    protected void processIntentionAction(final BehavingEntity behavingEntity, final JointGoalStep jointGoalStep, final int n) {
    }
    
    void printNegotiationHistory() {
    }
    
    void printNegotiationHistory(final PrintStream printStream) {
    }
    
    private final int convertCommitStateToIntention(final int n) {
        switch (n) {
            case 2: {
                return 17;
            }
            case 3: {
                return 18;
            }
            case 7: {
                return 19;
            }
            case 9: {
                return 20;
            }
            case 11:
            case 12: {
                return 22;
            }
            case 4:
            case 14: {
                return 23;
            }
            case 16: {
                return 21;
            }
            default: {
                return 24;
            }
        }
    }
    
    public Hashtable negotiateEntry(final Object[] array, final JointGoalStep escroedGoalStep) {
        Trace.ablTrace("Negotiating entry for " + escroedGoalStep + ", teamNeededForSuccess = " + escroedGoalStep.getTeamNeededForSuccess());
        if (this.getState() != -1) {
            throw new UnexpectedStateError(this.getState());
        }
        this.setState(0);
        final Long n = new Long(JointGoalNegotiator.uniqueEntryNegotiationID);
        this.initiateNegotiationAction(this.escroedGoalStep = escroedGoalStep, 17);
        this.runningCommitSet.put(BehavingEntity.getBehavingEntity(), escroedGoalStep);
        this.broadcastIntentionToEnter(n, array, escroedGoalStep.getTeamNeededForSuccess(), escroedGoalStep);
        while (this.getState() != 2 && this.getState() != 3) {
            ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
        }
        Trace.ablTrace("Entry negotiated");
        if (this.getState() == 2) {
            this.completeNegotiationAction(escroedGoalStep, 17);
        }
        else {
            this.completeNegotiationAction(escroedGoalStep, 18);
        }
        if (this.getState() == 2) {
            this.setState(4);
            return this.getCommitSet();
        }
        if (this.getState() == 3) {
            return null;
        }
        throw new UnexpectedStateError(this.getState());
    }
    
    public void processIntentionToEnter(final Long n, final BehavingEntity behavingEntity, final Object[] array, final boolean b, final Set set, final JointGoalStep jointGoalStep, final JointGoalStep jointGoalStep2) {
        final BehavingEntity behavingEntity2 = BehavingEntity.getBehavingEntity();
        Trace.ablTrace("Process intention to enter in " + behavingEntity2 + " for goal " + jointGoalStep);
        this.processIntentionAction(behavingEntity, jointGoalStep, 17);
        if (this.getState() == -1) {
            final Behavior chooseJointBehavior = BehavingEntity.getBehavingEntity().chooseJointBehavior(array, new HashSet(), jointGoalStep2, set);
            if (chooseJointBehavior != null) {
                this.setState(0);
                this.initiateIntentionAction(behavingEntity, jointGoalStep2, 17);
                this.runningCommitSet.put(behavingEntity, jointGoalStep);
                this.runningCommitSet.put(behavingEntity2, jointGoalStep2);
                this.broadcastIntentionToEnter(n, array, jointGoalStep2.getTeamNeededForSuccess(), jointGoalStep2);
                if (this.runningCommitSet.keySet().equals(set)) {
                    this.setState(2);
                    this.commitToIntentionAction(jointGoalStep2, 17);
                    behavingEntity2.terminateEntryNegotiation(n);
                    jointGoalStep2.resetNegotiator(this.runningCommitSet, 4);
                    behavingEntity2.getRootCollectionBehavior().addChild(jointGoalStep2);
                    jointGoalStep2.addChild(chooseJointBehavior);
                    jointGoalStep2.executeBookkeeping();
                }
                else {
                    while (this.getState() != 2 && this.getState() != 3) {
                        ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                    }
                    this.commitToIntentionAction(jointGoalStep2, this.convertCommitStateToIntention(this.getState()));
                    behavingEntity2.terminateEntryNegotiation(n);
                    if (this.getState() == 2) {
                        jointGoalStep2.resetNegotiator(this.runningCommitSet, 4);
                        behavingEntity2.getRootCollectionBehavior().addChild(jointGoalStep2);
                        jointGoalStep2.addChild(chooseJointBehavior);
                        jointGoalStep2.executeBookkeeping();
                    }
                    else if (this.getState() != 3) {
                        throw new UnexpectedStateError(this.getState());
                    }
                }
            }
            else {
                this.setState(1);
                this.initiateIntentionAction(null, jointGoalStep2, 18);
                this.runningCommitSet.put(behavingEntity2, new Integer(0));
                this.broadcastIntentionToRefuseEntry(n);
                while (this.getState() != 3) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                this.commitToIntentionAction(jointGoalStep2, 18);
                behavingEntity2.terminateEntryNegotiation(n);
            }
        }
        else if (this.getState() == 0) {
            if (this.runningCommitSet.get(behavingEntity) == null) {
                this.runningCommitSet.put(behavingEntity, jointGoalStep);
            }
            if (this.runningCommitSet.keySet().equals(set)) {
                this.setState(2);
            }
        }
        else {
            if (this.getState() != 1) {
                throw new UnexpectedStateError(this.getState());
            }
            this.runningCommitSet.remove(behavingEntity);
            this.broadcastIntentionToRefuseEntry(n);
        }
    }
    
    public void processIntentionToRefuseEntry(final Long n, final BehavingEntity behavingEntity) {
        this.processIntentionAction(behavingEntity, this.escroedGoalStep, 18);
        final BehavingEntity behavingEntity2 = BehavingEntity.getBehavingEntity();
        if (this.getState() == -1) {
            this.initiateIntentionAction(behavingEntity, null, 18);
            this.setState(1);
            this.runningCommitSet.put(behavingEntity2, new Integer(0));
            this.runningCommitSet.put(behavingEntity, new Integer(0));
            this.broadcastIntentionToRefuseEntry(n);
            if (this.runningCommitSet.keySet().equals(this.teamMembers)) {
                this.setState(3);
                this.commitToIntentionAction(this.escroedGoalStep, 18);
                BehavingEntity.getBehavingEntity().terminateEntryNegotiation(n);
            }
            else {
                while (this.getState() != 3) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                this.commitToIntentionAction(this.escroedGoalStep, 18);
                BehavingEntity.getBehavingEntity().terminateEntryNegotiation(n);
            }
        }
        else if (this.getState() == 0) {
            this.setState(1);
            this.initiateIntentionAction(null, this.escroedGoalStep, 18);
            (this.runningCommitSet = new Hashtable()).put(behavingEntity2, new Integer(0));
            this.runningCommitSet.put(behavingEntity, new Integer(0));
            this.broadcastIntentionToRefuseEntry(n);
            if (this.runningCommitSet.keySet().equals(this.teamMembers)) {
                this.setState(3);
                this.commitToIntentionAction(null, 18);
                BehavingEntity.getBehavingEntity().terminateEntryNegotiation(n);
            }
            else {
                while (this.getState() != 3) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                this.commitToIntentionAction(this.escroedGoalStep, 18);
                BehavingEntity.getBehavingEntity().terminateEntryNegotiation(n);
            }
        }
        else {
            if (this.getState() != 1) {
                throw new UnexpectedStateError(this.getState());
            }
            if (this.runningCommitSet.get(behavingEntity) == null) {
                this.runningCommitSet.put(behavingEntity, new Integer(0));
            }
            if (this.runningCommitSet.keySet().equals(this.teamMembers)) {
                this.setState(3);
            }
        }
    }
    
    private final boolean initiateSuccessNegotiation() {
        final BehavingEntity behavingEntity = BehavingEntity.getBehavingEntity();
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(behavingEntity);
        this.initiateNegotiationAction(jointGoalStep, 19);
        this.setState(5);
        this.negotiatingCommitSet.clear();
        this.negotiatingCommitSet.add(behavingEntity);
        this.broadcastIntentionToExit(19);
        while (this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
            ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
        }
        this.completeNegotiationAction(jointGoalStep, this.convertCommitStateToIntention(this.getState()));
        return this.getState() == 7;
    }
    
    public boolean negotiateSuccess() {
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(BehavingEntity.getBehavingEntity());
        Trace.ablTrace("Initiating success in state " + this.getState());
        switch (this.getState()) {
            case -1:
            case 0:
            case 1:
            case 2: {
                while (this.getState() != 4 && this.getState() != 3 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4) {
                    jointGoalStep.removeChild(true);
                    return this.initiateSuccessNegotiation();
                }
                if (this.getState() == 3) {
                    return false;
                }
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 7:
            case 9:
            case 16: {
                return false;
            }
            case 3:
            case 5:
            case 8:
            case 15: {
                return false;
            }
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14: {
                return this.initiateSuccessNegotiation();
            }
            case 6: {
                this.initiateNegotiationAction(jointGoalStep, 19);
                this.setState(5);
                while (this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                this.completeNegotiationAction(jointGoalStep, this.convertCommitStateToIntention(this.getState()));
                return this.getState() == 7;
            }
            default: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
        }
    }
    
    private final void initiateIntentionToSucceed(final BehavingEntity behavingEntity) {
        final BehavingEntity behavingEntity2 = BehavingEntity.getBehavingEntity();
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(behavingEntity2);
        Trace.ablTrace("Initiating intention to succeed on " + behavingEntity2);
        Trace.ablTrace("Goal to succeed " + jointGoalStep + ", teamNeededForSuccess = " + jointGoalStep.getTeamNeededForSuccess());
        this.setState(5);
        this.initiateIntentionAction(behavingEntity, jointGoalStep, 19);
        this.negotiatingCommitSet.clear();
        this.negotiatingCommitSet.add(behavingEntity);
        this.negotiatingCommitSet.add(behavingEntity2);
        if (jointGoalStep.getTeamNeededForSuccess()) {
            Trace.ablTrace("waiting for success in " + jointGoalStep);
            this.setState(6);
            while (this.getState() != 5 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
            }
            Trace.ablTrace("goal succeeded: " + jointGoalStep);
        }
        if (this.getState() == 5) {
            JointGoalStep.blockOnSubtreeNegotiation(jointGoalStep.freezeSubtreeAndNegotiateRemovalEntry());
            this.broadcastIntentionToExit(19);
            if (this.negotiatingCommitSet.equals(this.teamMembers)) {
                this.setState(7);
                this.commitToIntentionAction(jointGoalStep, 19);
                jointGoalStep.succeedStep();
            }
            else {
                while (this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                this.commitToIntentionAction(jointGoalStep, this.convertCommitStateToIntention(this.getState()));
                if (this.getState() == 7) {
                    jointGoalStep.succeedStep();
                }
            }
        }
    }
    
    public void processIntentionToSucceed(final BehavingEntity behavingEntity) {
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(BehavingEntity.getBehavingEntity());
        this.processIntentionAction(behavingEntity, jointGoalStep, 19);
        switch (this.getState()) {
            case -1:
            case 1:
            case 3: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 0:
            case 2: {
                while (this.getState() != 4 && this.getState() != 3 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                switch (this.getState()) {
                    case 4: {
                        this.initiateIntentionToSucceed(behavingEntity);
                    }
                    case 3: {
                        throw new UnexpectedStateError(this.getState(), jointGoalStep);
                    }
                }
                break;
            }
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14: {
                this.initiateIntentionToSucceed(behavingEntity);
                break;
            }
            case 15: {}
            case 5:
            case 6: {
                this.negotiatingCommitSet.add(behavingEntity);
                if (this.negotiatingCommitSet.equals(this.teamMembers)) {
                    this.setState(7);
                }
                break;
            }
            case 7:
            case 9:
            case 16: {
                throw new MessageReceivedAfterCommitError(19, this.getState(), jointGoalStep);
            }
            case 8: {
                this.negotiatingCommitSet.remove(behavingEntity);
                break;
            }
            default: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
        }
    }
    
    private final void initiateFailureNegotiation() {
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(BehavingEntity.getBehavingEntity());
        this.initiateNegotiationAction(jointGoalStep, 20);
        this.setState(8);
        this.negotiatingCommitSet.clear();
        this.negotiatingCommitSet.add(BehavingEntity.getBehavingEntity());
        this.broadcastIntentionToExit(20);
        while (this.getState() != 9) {
            ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
        }
        this.completeNegotiationAction(jointGoalStep, this.convertCommitStateToIntention(this.getState()));
    }
    
    public boolean negotiateFailure() {
        Trace.ablTrace("Negotiating failure");
        switch (this.getState()) {
            case -1:
            case 0:
            case 1:
            case 2: {
                while (this.getState() != 4 && this.getState() != 3 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4) {
                    this.negotiatingGoal.removeChild(true);
                    this.initiateFailureNegotiation();
                    return true;
                }
                if (this.getState() == 3) {
                    return false;
                }
                throw new UnexpectedStateError(this.getState(), this.negotiatingGoal);
            }
            case 7:
            case 9:
            case 16: {
                return false;
            }
            case 3:
            case 8:
            case 15: {
                return false;
            }
            case 4:
            case 5:
            case 6:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14: {
                this.initiateFailureNegotiation();
                return true;
            }
            default: {
                throw new UnexpectedStateError(this.getState(), this.negotiatingGoal);
            }
        }
    }
    
    private final void initiateIntentionToFail(final BehavingEntity behavingEntity) {
        final BehavingEntity behavingEntity2 = BehavingEntity.getBehavingEntity();
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(behavingEntity2);
        this.setState(8);
        this.initiateIntentionAction(behavingEntity, jointGoalStep, 20);
        this.negotiatingCommitSet.clear();
        this.negotiatingCommitSet.add(behavingEntity);
        this.negotiatingCommitSet.add(behavingEntity2);
        JointGoalStep.blockOnSubtreeNegotiation(jointGoalStep.freezeSubtreeAndNegotiateRemovalEntry());
        this.broadcastIntentionToExit(20);
        if (this.negotiatingCommitSet.equals(this.teamMembers)) {
            this.setState(9);
            this.commitToIntentionAction(jointGoalStep, 20);
            ((JointGoalStep)this.runningCommitSet.get(behavingEntity2)).failStep();
        }
        else {
            while (this.getState() != 9) {
                ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
            }
            this.commitToIntentionAction(jointGoalStep, 20);
            ((JointGoalStep)this.runningCommitSet.get(behavingEntity2)).failStep();
        }
    }
    
    public void processIntentionToFail(final BehavingEntity behavingEntity) {
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(BehavingEntity.getBehavingEntity());
        this.processIntentionAction(behavingEntity, jointGoalStep, 20);
        switch (this.getState()) {
            case -1:
            case 1:
            case 3: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 0:
            case 2: {
                while (this.getState() != 4 && this.getState() != 3 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4) {
                    this.initiateIntentionToFail(behavingEntity);
                    break;
                }
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 7:
            case 9:
            case 16: {
                throw new MessageReceivedAfterCommitError(20, this.getState(), jointGoalStep);
            }
            case 4:
            case 5:
            case 6:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14: {
                this.initiateIntentionToFail(behavingEntity);
                break;
            }
            case 15: {
                break;
            }
            case 8: {
                this.negotiatingCommitSet.add(behavingEntity);
                if (this.negotiatingCommitSet.equals(this.teamMembers)) {
                    this.setState(9);
                }
                break;
            }
            default: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
        }
    }
    
    private final boolean initiateSuspendNegotiation() {
        final BehavingEntity behavingEntity = BehavingEntity.getBehavingEntity();
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(behavingEntity);
        this.initiateNegotiationAction(jointGoalStep, 22);
        this.setState(10);
        this.negotiatingCommitSet.clear();
        this.negotiatingCommitSet.add(behavingEntity);
        this.broadcastIntentionToExit(22);
        while (this.getState() != 16 && this.getState() != 9 && this.getState() != 7 && this.getState() != 11) {
            ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
        }
        this.completeNegotiationAction(jointGoalStep, this.convertCommitStateToIntention(this.getState()));
        return this.getState() == 11;
    }
    
    public boolean negotiateSuspend() {
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(BehavingEntity.getBehavingEntity());
        Trace.ablTrace("Initiating suspend in state " + this.getState());
        switch (this.getState()) {
            case -1:
            case 0:
            case 1:
            case 2: {
                while (this.getState() != 4 && this.getState() != 3 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4) {
                    return this.initiateSuspendNegotiation();
                }
                if (this.getState() == 3) {
                    return false;
                }
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 7:
            case 9:
            case 16: {
                return false;
            }
            case 3:
            case 5:
            case 8:
            case 10:
            case 12:
            case 15: {
                return false;
            }
            case 4:
            case 6: {
                return this.initiateSuspendNegotiation();
            }
            case 11:
            case 13:
            case 14: {
                while (this.getState() != 7 && this.getState() != 9 && this.getState() != 16 && this.getState() != 4 && this.getState() != 12) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                return (this.getState() == 4 || this.getState() == 12) && this.initiateSuspendNegotiation();
            }
            default: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
        }
    }
    
    private final void initiateIntentionToSuspend(final BehavingEntity behavingEntity) {
        final BehavingEntity behavingEntity2 = BehavingEntity.getBehavingEntity();
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(behavingEntity2);
        this.initiateIntentionAction(behavingEntity, jointGoalStep, 22);
        this.setState(10);
        this.negotiatingCommitSet.clear();
        this.negotiatingCommitSet.add(behavingEntity);
        this.negotiatingCommitSet.add(behavingEntity2);
        JointGoalStep.blockOnSubtreeNegotiation(jointGoalStep.negotiateSuspensionOfSubtreeEntry());
        this.broadcastIntentionToExit(22);
        if (this.negotiatingCommitSet.equals(this.teamMembers)) {
            this.commitToIntentionAction(jointGoalStep, 22);
            this.setState(12);
            jointGoalStep.jointSuspend();
        }
        else {
            while (this.getState() != 7 && this.getState() != 9 && this.getState() != 16 && this.getState() != 11) {
                ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
            }
            this.commitToIntentionAction(jointGoalStep, this.convertCommitStateToIntention(this.getState()));
            if (this.getState() == 11) {
                jointGoalStep.jointSuspend();
                this.setState(12);
            }
        }
    }
    
    public void processIntentionToSuspend(final BehavingEntity behavingEntity) {
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(BehavingEntity.getBehavingEntity());
        this.processIntentionAction(behavingEntity, jointGoalStep, 22);
        switch (this.getState()) {
            case -1:
            case 1:
            case 3: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 0:
            case 2: {
                while (this.getState() != 4 && this.getState() != 3 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4) {
                    this.initiateIntentionToSuspend(behavingEntity);
                    break;
                }
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 7:
            case 9:
            case 16: {
                throw new MessageReceivedAfterCommitError(20, this.getState(), jointGoalStep);
            }
            case 4:
            case 6:
            case 12: {
                this.initiateIntentionToSuspend(behavingEntity);
                break;
            }
            case 13: {
                final HashSet negotiatingCommitSet = new HashSet(this.negotiatingCommitSet);
                this.initiateIntentionToSuspend(behavingEntity);
                while (this.getState() != 4 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16 && this.getState() != 12) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4 || this.getState() == 12) {
                    this.setState(13);
                    this.negotiatingCommitSet = negotiatingCommitSet;
                }
                break;
            }
            case 11:
            case 14: {
                while (this.getState() != 4 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16 && this.getState() != 12) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4 || this.getState() == 12) {
                    this.initiateIntentionToSuspend(behavingEntity);
                }
                break;
            }
            case 5:
            case 8:
            case 15: {
                this.negotiatingCommitSet.remove(behavingEntity);
                break;
            }
            case 10: {
                this.negotiatingCommitSet.add(behavingEntity);
                if (this.negotiatingCommitSet.equals(this.teamMembers)) {
                    this.setState(11);
                }
                break;
            }
            default: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
        }
    }
    
    private final boolean initiateUnsuspendNegotiation() {
        final BehavingEntity behavingEntity = BehavingEntity.getBehavingEntity();
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(behavingEntity);
        this.initiateNegotiationAction(jointGoalStep, 23);
        this.setState(13);
        this.negotiatingCommitSet.clear();
        this.negotiatingCommitSet.add(behavingEntity);
        this.broadcastIntentionToExit(23);
        while (this.getState() != 16 && this.getState() != 9 && this.getState() != 7 && this.getState() != 14) {
            ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
        }
        this.completeNegotiationAction(jointGoalStep, this.convertCommitStateToIntention(this.getState()));
        return this.getState() == 14;
    }
    
    public boolean negotiateUnsuspend() {
        Trace.ablTrace("Initiating unsuspend in state " + this.getState());
        switch (this.getState()) {
            case -1:
            case 0:
            case 1:
            case 2: {
                while (this.getState() != 4 && this.getState() != 3 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4) {
                    return this.initiateUnsuspendNegotiation();
                }
                if (this.getState() == 3) {
                    return false;
                }
                throw new UnexpectedStateError(this.getState(), this.negotiatingGoal);
            }
            case 7:
            case 9:
            case 16: {
                return false;
            }
            case 11:
            case 14: {
                while (this.getState() != 16 && this.getState() != 9 && this.getState() != 7 && this.getState() != 12 && this.getState() != 4) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                return (this.getState() == 12 || this.getState() == 4) && this.initiateUnsuspendNegotiation();
            }
            case 10:
            case 13: {
                while (this.getState() != 16 && this.getState() != 9 && this.getState() != 7 && this.getState() != 12 && this.getState() != 4) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                return this.getState() == 12 && this.initiateUnsuspendNegotiation();
            }
            case 3:
            case 4:
            case 5:
            case 8:
            case 15: {
                return false;
            }
            case 12: {
                return this.initiateUnsuspendNegotiation();
            }
            default: {
                throw new UnexpectedStateError(this.getState(), this.negotiatingGoal);
            }
        }
    }
    
    private final void initiateIntentionToUnsuspend(final BehavingEntity behavingEntity) {
        final BehavingEntity behavingEntity2 = BehavingEntity.getBehavingEntity();
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(behavingEntity2);
        this.initiateIntentionAction(behavingEntity, jointGoalStep, 23);
        this.setState(13);
        this.negotiatingCommitSet.clear();
        this.negotiatingCommitSet.add(behavingEntity);
        this.negotiatingCommitSet.add(behavingEntity2);
        this.broadcastIntentionToExit(23);
        if (this.negotiatingCommitSet.equals(this.teamMembers)) {
            this.commitToIntentionAction(jointGoalStep, 23);
            jointGoalStep.jointUnsuspendEntry();
            if (jointGoalStep.isSuspended()) {
                this.setState(12);
            }
            else {
                this.setState(4);
            }
        }
        else {
            while (this.getState() != 7 && this.getState() != 9 && this.getState() != 16 && this.getState() != 14) {
                ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
            }
            this.commitToIntentionAction(jointGoalStep, this.convertCommitStateToIntention(this.getState()));
            if (this.getState() == 14) {
                jointGoalStep.jointUnsuspendEntry();
                if (jointGoalStep.isSuspended()) {
                    this.setState(12);
                }
                else {
                    this.setState(4);
                }
            }
        }
    }
    
    public void processIntentionToUnsuspend(final BehavingEntity behavingEntity) {
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(BehavingEntity.getBehavingEntity());
        this.processIntentionAction(behavingEntity, jointGoalStep, 23);
        switch (this.getState()) {
            case -1:
            case 1:
            case 3: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 0:
            case 2: {
                while (this.getState() != 4 && this.getState() != 3 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4) {
                    this.initiateIntentionToUnsuspend(behavingEntity);
                    break;
                }
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 7:
            case 9:
            case 16: {
                throw new MessageReceivedAfterCommitError(20, this.getState(), jointGoalStep);
            }
            case 12: {
                this.initiateIntentionToUnsuspend(behavingEntity);
                break;
            }
            case 4: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 10:
            case 11:
            case 14: {
                while (this.getState() != 4 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16 && this.getState() != 12) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4 || this.getState() == 12) {
                    this.initiateIntentionToUnsuspend(behavingEntity);
                }
                break;
            }
            case 5:
            case 8:
            case 15: {
                break;
            }
            case 13: {
                this.negotiatingCommitSet.add(behavingEntity);
                if (this.negotiatingCommitSet.equals(this.teamMembers)) {
                    this.setState(14);
                }
                break;
            }
            default: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
        }
    }
    
    private final boolean initiateRemovalNegotiation() {
        final BehavingEntity behavingEntity = BehavingEntity.getBehavingEntity();
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(behavingEntity);
        this.initiateNegotiationAction(jointGoalStep, 21);
        this.setState(15);
        this.negotiatingCommitSet.clear();
        this.negotiatingCommitSet.add(behavingEntity);
        this.broadcastIntentionToExit(21);
        while (this.getState() != 16 && this.getState() != 9 && this.getState() != 7) {
            ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
        }
        this.completeNegotiationAction(jointGoalStep, this.convertCommitStateToIntention(this.getState()));
        return this.getState() == 16;
    }
    
    public boolean negotiateRemoval() {
        Trace.ablTrace("Negotiating removal");
        switch (this.getState()) {
            case -1:
            case 0:
            case 1:
            case 2: {
                while (this.getState() != 4 && this.getState() != 3 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4) {
                    this.negotiatingGoal.removeChild(true);
                    return this.initiateRemovalNegotiation();
                }
                if (this.getState() == 3) {
                    return false;
                }
                throw new UnexpectedStateError(this.getState(), this.negotiatingGoal);
            }
            case 7:
            case 9:
            case 16: {
                return false;
            }
            case 3:
            case 8:
            case 15: {
                return false;
            }
            case 4:
            case 5:
            case 6:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14: {
                return this.initiateRemovalNegotiation();
            }
            default: {
                throw new UnexpectedStateError(this.getState(), this.negotiatingGoal);
            }
        }
    }
    
    private final void removeGoal(final JointGoalStep jointGoalStep) {
        jointGoalStep.removeGoal();
        jointGoalStep.cleanupParentIfRoot();
    }
    
    private final void initiateIntentionToRemove(final BehavingEntity behavingEntity) {
        final BehavingEntity behavingEntity2 = BehavingEntity.getBehavingEntity();
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(behavingEntity2);
        this.initiateIntentionAction(behavingEntity, jointGoalStep, 21);
        this.setState(15);
        this.negotiatingCommitSet.clear();
        this.negotiatingCommitSet.add(behavingEntity);
        this.negotiatingCommitSet.add(behavingEntity2);
        JointGoalStep.blockOnSubtreeNegotiation(jointGoalStep.freezeSubtreeAndNegotiateRemovalEntry());
        this.broadcastIntentionToExit(21);
        if (this.negotiatingCommitSet.equals(this.teamMembers)) {
            this.commitToIntentionAction(jointGoalStep, 21);
            this.setState(16);
            this.removeGoal((JointGoalStep)this.runningCommitSet.get(behavingEntity2));
        }
        else {
            while (this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
            }
            this.commitToIntentionAction(jointGoalStep, this.convertCommitStateToIntention(this.getState()));
            if (this.getState() == 16) {
                this.removeGoal((JointGoalStep)this.runningCommitSet.get(behavingEntity2));
            }
        }
    }
    
    public void processIntentionToRemove(final BehavingEntity behavingEntity) {
        final JointGoalStep jointGoalStep = this.runningCommitSet.get(BehavingEntity.getBehavingEntity());
        this.processIntentionAction(behavingEntity, jointGoalStep, 21);
        switch (this.getState()) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 3: {
                while (this.getState() != 4 && this.getState() != 3 && this.getState() != 7 && this.getState() != 9 && this.getState() != 16) {
                    ((JointGoalNegotiationThread)Thread.currentThread()).waitForDecisionCycle();
                }
                if (this.getState() == 4) {
                    this.initiateIntentionToRemove(behavingEntity);
                    break;
                }
                if (this.getState() == 3) {
                    return;
                }
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
            case 4:
            case 5:
            case 6:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14: {
                this.initiateIntentionToRemove(behavingEntity);
                break;
            }
            case 15: {
                this.negotiatingCommitSet.add(behavingEntity);
                if (this.negotiatingCommitSet.equals(this.teamMembers)) {
                    this.setState(16);
                }
                break;
            }
            case 8: {
                this.negotiatingCommitSet.remove(behavingEntity);
                break;
            }
            case 7:
            case 9:
            case 16: {
                throw new MessageReceivedAfterCommitError(19, this.getState(), jointGoalStep);
            }
            default: {
                throw new UnexpectedStateError(this.getState(), jointGoalStep);
            }
        }
    }
    
    private final void broadcastIntentionToEnter(final Long n, final Object[] array, final boolean b, final JointGoalStep jointGoalStep) {
        final BehavingEntity behavingEntity = BehavingEntity.getBehavingEntity();
        final HashSet set = new HashSet<BehavingEntity>(this.teamMembers);
        set.remove(behavingEntity);
        final Iterator<BehavingEntity> iterator = set.iterator();
        while (iterator.hasNext()) {
            iterator.next().queueIntentionToEnter(n, behavingEntity, array, b, this.teamMembers, jointGoalStep);
        }
    }
    
    private final void broadcastIntentionToRefuseEntry(final Long n) {
        final BehavingEntity behavingEntity = BehavingEntity.getBehavingEntity();
        final HashSet set = new HashSet<BehavingEntity>(this.teamMembers);
        set.remove(behavingEntity);
        final Iterator<BehavingEntity> iterator = set.iterator();
        while (iterator.hasNext()) {
            iterator.next().queueIntentionToRefuseEntry(n, behavingEntity, this.teamMembers);
        }
    }
    
    private final void broadcastIntentionToExit(final int n) {
        final BehavingEntity behavingEntity = BehavingEntity.getBehavingEntity();
        final HashSet set = new HashSet<BehavingEntity>(this.teamMembers);
        set.remove(behavingEntity);
        for (final BehavingEntity behavingEntity2 : set) {
            behavingEntity2.queueIntentionToExit(behavingEntity, (JointGoalStep)this.runningCommitSet.get(behavingEntity2), n);
        }
    }
    
    private final /* synthetic */ void this() {
        this.receiver = BehavingEntity.getBehavingEntity();
        this.runningCommitSet = new Hashtable();
        this.negotiatingCommitSet = new HashSet();
        this.escroedGoalStep = null;
    }
    
    JointGoalNegotiator(final Set set, final JointGoalStep negotiatingGoal) {
        this.this();
        if (!JointGoalNegotiator.$noassert && !this.teamMembersAreBehavingEntities(set)) {
            throw new AssertionError();
        }
        this.teamMembers = new HashSet(set);
        this.currentState = -1;
        this.negotiatingGoal = negotiatingGoal;
    }
    
    JointGoalNegotiator(final Set set, final boolean b, final JointGoalStep negotiatingGoal) {
        this.this();
        if (!JointGoalNegotiator.$noassert && !this.teamMembersAreBehavingEntities(set)) {
            throw new AssertionError();
        }
        this.teamMembers = new HashSet(set);
        this.currentState = -1;
        if (b) {
            ++JointGoalNegotiator.uniqueEntryNegotiationID;
        }
        this.negotiatingGoal = negotiatingGoal;
    }
    
    JointGoalNegotiator(final Hashtable hashtable) {
        this.this();
        this.teamMembers = new HashSet(hashtable.keySet());
        if (!JointGoalNegotiator.$noassert && !this.teamMembersAreBehavingEntities(this.teamMembers)) {
            throw new AssertionError();
        }
        this.runningCommitSet = new Hashtable(hashtable);
        this.currentState = -1;
        this.negotiatingGoal = this.runningCommitSet.get(this.receiver);
        if (!JointGoalNegotiator.$noassert && this.negotiatingGoal == null) {
            throw new AssertionError();
        }
    }
    
    JointGoalNegotiator(final Hashtable hashtable, final int currentState) {
        this.this();
        this.teamMembers = new HashSet(hashtable.keySet());
        if (!JointGoalNegotiator.$noassert && !this.teamMembersAreBehavingEntities(this.teamMembers)) {
            throw new AssertionError();
        }
        this.runningCommitSet = new Hashtable(hashtable);
        if (!JointGoalNegotiator.$noassert && !isLegalState(currentState)) {
            throw new AssertionError((Object)Integer.toString(currentState));
        }
        this.currentState = currentState;
        this.negotiatingGoal = this.runningCommitSet.get(this.receiver);
        if (!JointGoalNegotiator.$noassert && this.negotiatingGoal == null) {
            throw new AssertionError();
        }
    }
    
    static {
        $noassert = (Class.forName("[Labl.runtime.JointGoalNegotiator;").getComponentType().desiredAssertionStatus() ^ true);
        JointGoalNegotiator.uniqueEntryNegotiationID = 0L;
    }
}
