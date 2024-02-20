package abl.runtime;

import java.util.Collection;
import java.util.HashSet;
import java.lang.reflect.Method;
import java.util.Set;

public class InitiatedJointGoalStep extends JointGoalStep
{
    private static final int INITIATED_JOINT_GOAL_STEP_ID = -4;
    private static final short defaultPriority = 0;
    private static final short defaultPriorityModifier = 0;
    private final Set teamMembers;
    private final Object[] args;
    
    void execute() {
        final Behavior chooseJointBehavior = BehavingEntity.getBehavingEntity().chooseJointBehavior(this.args, this.failedBehaviors, this, this.teamMembers);
        if (chooseJointBehavior != null) {
            this.addChild(chooseJointBehavior);
            this.executeBookkeeping();
        }
        else {
            this.failStep();
        }
    }
    
    public InitiatedJointGoalStep(final Behavior behavior, final String s, final Set set, final Object[] args, final boolean b) {
        super(-4, behavior, false, false, false, false, false, false, (short)0, (short)0, false, null, null, null, null, null, s, null, b);
        this.teamMembers = new HashSet(set);
        this.args = args;
        this.negotiator = new JointGoalNegotiator(this.teamMembers, this);
    }
}
