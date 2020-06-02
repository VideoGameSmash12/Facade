package facade.util;

public class IntegerRef
{
    public int i;
    
    public synchronized int getI() {
        return this.i;
    }
    
    public synchronized void setI(final int i) {
        this.i = i;
    }
    
    public synchronized boolean bSetI(final int i) {
        this.i = i;
        return true;
    }
    
    public IntegerRef() {
        this.i = 0;
    }
    
    public IntegerRef(final int i) {
        this.i = i;
    }
}
