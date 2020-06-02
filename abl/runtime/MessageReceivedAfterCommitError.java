package abl.runtime;

public class MessageReceivedAfterCommitError extends JointGoalNegotiationError
{
    protected static String messageName(final int n) {
        switch (n) {
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
                return "UNKNOWN MESSAGE";
            }
        }
    }
    
    public MessageReceivedAfterCommitError(final int n, final int n2) {
        super("Received message " + messageName(n) + " in commit state " + JointGoalNegotiationError.stateName(n2));
    }
    
    public MessageReceivedAfterCommitError(final int n, final int n2, final JointGoalStep jointGoalStep) {
        super("Received message " + messageName(n) + " in commit state " + JointGoalNegotiationError.stateName(n2) + " in goal " + jointGoalStep);
    }
}
