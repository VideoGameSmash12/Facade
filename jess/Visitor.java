package jess;

public interface Visitor
{
    Object visitDeffacts(final Deffacts p0);
    
    Object visitDeftemplate(final Deftemplate p0);
    
    Object visitDeffunction(final Deffunction p0);
    
    Object visitDefglobal(final Defglobal p0);
    
    Object visitDefrule(final Defrule p0);
    
    Object visitDefquery(final Defquery p0);
    
    Object visitPattern(final Pattern p0);
    
    Object visitGroup(final Group p0);
    
    Object visitTest1(final Test1 p0);
}
