package abl.runtime;

public class ObjectWrapper
{
    private Object o;
    
    public Object objectValue() {
        return this.o;
    }
    
    public ObjectWrapper(final Object o) {
        this.o = o;
    }
}
