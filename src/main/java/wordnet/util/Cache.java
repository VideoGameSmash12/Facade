package wordnet.util;

public interface Cache
{
    void put(final Object p0, final Object p1);
    
    Object get(final Object p0);
    
    void clear();
}
