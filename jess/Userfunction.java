package jess;

public interface Userfunction
{
    String getName();
    
    Value call(final ValueVector p0, final Context p1) throws JessException;
}
