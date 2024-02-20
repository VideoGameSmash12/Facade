package jess;

public interface Strategy
{
    int compare(final Activation p0, final Activation p1);
    
    String getName();
}
