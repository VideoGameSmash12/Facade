package jess;

import java.util.Map;

interface LHSComponent extends Cloneable
{
    void setBoundName(final String p0) throws JessException;
    
    void setNegated();
    
    void setExplicit();
    
    void setLogical();
    
    boolean getLogical();
    
    boolean getNegated();
    
    LHSComponent canonicalize() throws JessException;
    
    boolean getBackwardChaining();
    
    void addToGroup(final Group p0) throws JessException;
    
    void addDirectlyMatchedVariables(final Map p0) throws JessException;
    
    void renameUnmentionedVariables(final Map p0, final Map p1, final int p2, final HasLHS p3) throws JessException;
    
    boolean isBackwardChainingTrigger();
    
    int getPatternCount();
    
    Object clone();
    
    String getName();
    
    String getBoundName();
    
    int getGroupSize();
    
    LHSComponent getLHSComponent(final int p0);
}
