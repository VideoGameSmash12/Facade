package abl.runtime;

public class CompletedGoalWME extends CompletedExecutableStepWME
{
    public CompletedGoalWME(final String s, final int n, final String s2, final String s3, final long n2) {
        super(s, n, s2, s3, n2);
    }
    
    public CompletedGoalWME(final String s, final int n, final String s2, final String s3) {
        super(s, n, s2, s3);
    }
}
