package wordnet.wn;

public interface PointerTarget
{
    POS getPOS();
    
    String getDescription();
    
    String getLongDescription();
    
    Pointer[] getPointers();
    
    Pointer[] getPointers(final PointerType p0);
    
    PointerTarget[] getTargets();
    
    PointerTarget[] getTargets(final PointerType p0);
}
