package jess;

import java.io.Serializable;

public interface ConditionalElement extends Serializable
{
    String getName();
    
    String getBoundName();
    
    int getGroupSize();
    
    boolean isGroup();
    
    ConditionalElement getConditionalElement(final int p0);
}
