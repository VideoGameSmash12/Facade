package abl.runtime;

import java.util.Hashtable;
import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintStream;
import java.util.List;
import abl.compiler.AblDebuggerConstants;

class JointGoalNegotiatorDebug extends JointGoalNegotiator implements AblDebuggerConstants
{
    private final byte debugLevel;
    private final List negotiationEvents;
    
    protected synchronized void setState(final int state) {
        this.negotiationEvents.add(new JointGoalNegotiationEvent(((JointGoalNegotiationThread)Thread.currentThread()).descriptorString, null, state));
        super.setState(state);
    }
    
    protected final void initiateNegotiationAction(final JointGoalStep jointGoalStep, final int n) {
        final JointGoalNegotiationInfo jointGoalNegotiationInfo = new JointGoalNegotiationInfo(jointGoalStep, null, n);
        if (this.debugLevel == 2) {
            ((DebuggableJointGoalStep)this.negotiatingGoal).traceAblNegotiationEvent(20, jointGoalNegotiationInfo);
        }
        this.negotiationEvents.add(new JointGoalNegotiationEvent("INITIATE_NEGOTIATION", jointGoalNegotiationInfo, this.getState()));
    }
    
    protected final void completeNegotiationAction(final JointGoalStep jointGoalStep, final int n) {
        final JointGoalNegotiationInfo jointGoalNegotiationInfo = new JointGoalNegotiationInfo(jointGoalStep, null, n);
        if (this.debugLevel == 2) {
            ((DebuggableJointGoalStep)this.negotiatingGoal).traceAblNegotiationEvent(21, jointGoalNegotiationInfo);
        }
        this.negotiationEvents.add(new JointGoalNegotiationEvent("COMPLETE_NEGOTIATION", jointGoalNegotiationInfo, this.getState()));
    }
    
    protected final void initiateIntentionAction(final BehavingEntity behavingEntity, final JointGoalStep jointGoalStep, final int n) {
        final JointGoalNegotiationInfo jointGoalNegotiationInfo = new JointGoalNegotiationInfo(jointGoalStep, behavingEntity, n);
        if (this.debugLevel == 2) {
            ((DebuggableJointGoalStep)this.negotiatingGoal).traceAblNegotiationEvent(22, jointGoalNegotiationInfo);
        }
        this.negotiationEvents.add(new JointGoalNegotiationEvent("INITIATE_INTENTION", jointGoalNegotiationInfo, this.getState()));
    }
    
    protected final void commitToIntentionAction(final JointGoalStep jointGoalStep, final int n) {
        final JointGoalNegotiationInfo jointGoalNegotiationInfo = new JointGoalNegotiationInfo(jointGoalStep, null, n);
        if (this.debugLevel == 2) {
            ((DebuggableJointGoalStep)this.negotiatingGoal).traceAblNegotiationEvent(23, jointGoalNegotiationInfo);
        }
        this.negotiationEvents.add(new JointGoalNegotiationEvent("COMMIT_TO_INTENTION", jointGoalNegotiationInfo, this.getState()));
    }
    
    protected final void processIntentionAction(final BehavingEntity behavingEntity, final JointGoalStep jointGoalStep, final int n) {
        final JointGoalNegotiationInfo jointGoalNegotiationInfo = new JointGoalNegotiationInfo(jointGoalStep, behavingEntity, n);
        if (this.debugLevel == 2) {
            ((DebuggableJointGoalStep)this.negotiatingGoal).traceAblNegotiationEvent(24, jointGoalNegotiationInfo);
        }
        this.negotiationEvents.add(new JointGoalNegotiationEvent("PROCESS_INTENTION", jointGoalNegotiationInfo, this.getState()));
    }
    
    void printNegotiationHistory(final PrintStream printStream) {
        final Iterator<JointGoalNegotiationEvent> iterator = this.negotiationEvents.iterator();
        printStream.println("Negotiation history:  for " + this.negotiatingGoal + ':');
        printStream.println("   Current state: " + JointGoalNegotiator.formatState(this.getState()));
        while (iterator.hasNext()) {
            printStream.println("   " + iterator.next());
        }
    }
    
    final void printNegotiationHistory() {
        this.printNegotiationHistory(System.err);
    }

    JointGoalNegotiatorDebug(final Set set, final boolean b, final JointGoalStep jointGoalStep, final byte debugLevel) {
        super(set, b, jointGoalStep);
        this.negotiationEvents = new ArrayList(20);
        this.debugLevel = debugLevel;
    }
    
    JointGoalNegotiatorDebug(final Hashtable hashtable, final byte debugLevel) {
        super(hashtable);
        this.negotiationEvents = new ArrayList(20);
        this.debugLevel = debugLevel;
    }
    
    JointGoalNegotiatorDebug(final Hashtable hashtable, final int n, final byte debugLevel) {
        super(hashtable, n);
        this.negotiationEvents = new ArrayList(20);
        this.debugLevel = debugLevel;
    }
    
    JointGoalNegotiatorDebug(final Set set, final JointGoalStep jointGoalStep, final byte debugLevel) {
        super(set, jointGoalStep);
        this.negotiationEvents = new ArrayList(20);
        this.debugLevel = debugLevel;
    }
    
    class JointGoalNegotiationInfo
    {
        final JointGoalStep g;
        final BehavingEntity behavingEntity;
        final int intention;
        
        JointGoalNegotiationInfo(final JointGoalStep g, final BehavingEntity behavingEntity, final int intention) {
            this.g = g;
            this.behavingEntity = behavingEntity;
            this.intention = intention;
        }
    }
    
    class JointGoalNegotiationEvent
    {
        String negotiation;
        JointGoalNegotiationInfo info;
        int currentState;
        
        public String toString() {
            if (this.info != null) {
                String behavingEntityShortName;
                if (this.info.behavingEntity != null) {
                    behavingEntityShortName = this.info.behavingEntity.getBehavingEntityShortName();
                }
                else {
                    behavingEntityShortName = "self";
                }
                return this.negotiation + " from: " + behavingEntityShortName + ", intention: " + JointGoalNegotiator.formatIntention(this.info.intention) + ", state: " + JointGoalNegotiator.formatState(this.currentState);
            }
            return "state changed by " + this.negotiation + " to: " + JointGoalNegotiator.formatState(this.currentState);
        }
        
        JointGoalNegotiationEvent(final String negotiation, final JointGoalNegotiationInfo info, final int currentState) {
            this.negotiation = negotiation;
            this.info = info;
            this.currentState = currentState;
        }
    }
}
