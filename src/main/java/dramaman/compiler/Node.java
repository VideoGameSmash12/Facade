package dramaman.compiler;

public interface Node
{
    void jjtOpen();
    
    void jjtClose();
    
    void jjtSetParent(final Node p0);
    
    Node jjtGetParent();
    
    void jjtAddChild(final Node p0, final int p1);
    
    Node jjtGetChild(final int p0);
    
    int jjtGetNumChildren();
}
