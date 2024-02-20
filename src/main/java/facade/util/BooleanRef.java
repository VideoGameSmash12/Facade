package facade.util;

public class BooleanRef
{
    public boolean b;
    
    public synchronized boolean getB() {
        return this.b;
    }
    
    public synchronized void setB(final boolean b) {
        this.b = b;
    }
    
    public synchronized boolean bSetB(final boolean b) {
        this.b = b;
        return true;
    }
    
    public BooleanRef() {
        this.b = false;
    }
    
    public BooleanRef(final boolean b) {
        this.b = b;
    }
}
