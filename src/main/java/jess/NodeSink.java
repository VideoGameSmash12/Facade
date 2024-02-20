package jess;

public interface NodeSink
{
    String listNodes();
    
    void addNode(final Node p0) throws JessException;
}
