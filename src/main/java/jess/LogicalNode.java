package jess;

import java.util.Map;

interface LogicalNode
{
    void dependsOn(final Fact p0, final Token p1);
    
    int getTokenSize();
    
    Map getLogicalDependencies();
}
