package abl.runtime;

public class JointGoalNegotiationError extends AblRuntimeError
{
    protected static String stateName(final int n) {
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
                return "UNKNOWN_STATE";
            }
        }
    }
    
    public JointGoalNegotiationError(final String s) {
        super(s);
    }
}
