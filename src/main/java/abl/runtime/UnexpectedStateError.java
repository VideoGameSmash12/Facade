package abl.runtime;

public class UnexpectedStateError extends JointGoalNegotiationError
{
    private JointGoalStep s;
    
    public String getMessage() {
        if (this.s != null && this.s.negotiator.getClass().getName().equals("abl.runtime.JointGoalNegotiatorDebug")) {
            System.err.println("UnexpectedStateError");
            this.s.negotiator.printNegotiationHistory();
            return super.getMessage();
        }
        return super.getMessage();
    }
    
    private final /* synthetic */ void this() {
        this.s = null;
    }
    
    public UnexpectedStateError(final int n) {
        super("Unexpected state " + JointGoalNegotiationError.stateName(n));
        this.this();
    }
    
    public UnexpectedStateError(final int n, final BehavingEntity behavingEntity) {
        super(behavingEntity + ": Unexpected state " + JointGoalNegotiationError.stateName(n));
        this.this();
    }
    
    public UnexpectedStateError(final int n, final JointGoalStep s) {
        super("Unexpected state " + JointGoalNegotiationError.stateName(n) + "in goal " + s);
        this.this();
        this.s = s;
    }
    
    public UnexpectedStateError(final int n, final BehavingEntity behavingEntity, final JointGoalStep s) {
        super(behavingEntity + ": Unexpected state " + JointGoalNegotiationError.stateName(n) + "in goal " + s);
        this.this();
        this.s = s;
    }
}
