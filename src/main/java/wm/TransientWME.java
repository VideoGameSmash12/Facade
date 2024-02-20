package wm;

public abstract class TransientWME extends WME
{
    private boolean marked;
    
    public void mark() {
        this.marked = true;
    }
    
    public boolean getMarked() {
        return this.marked;
    }
    
    public boolean isTransient() {
        return true;
    }
    
    public TransientWME() {
        this.marked = false;
    }
}
