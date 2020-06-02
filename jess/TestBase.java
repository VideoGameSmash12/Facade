package jess;

public interface TestBase
{
    public static final int EQ = 0;
    public static final int NEQ = 1;
    
    boolean doTest(final Context p0) throws JessException;
}
