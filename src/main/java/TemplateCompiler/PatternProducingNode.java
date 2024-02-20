package TemplateCompiler;

import java.util.List;
import java.util.HashSet;

interface PatternProducingNode extends Node
{
    String getRuleName();
    
    String getPatternHead();
    
    String getPatternToMatch(final int p0);
    
    HashSet getPatternBindingVariables();
    
    List getPatternBindingVariablesCanonical();
}
