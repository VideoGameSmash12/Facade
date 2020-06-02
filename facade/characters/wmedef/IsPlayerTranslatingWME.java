package facade.characters.wmedef;

import wm.WME;

public class IsPlayerTranslatingWME extends WME
{
    private boolean b;
    
    public synchronized boolean getB() {
        return this.b;
    }
    
    public synchronized void setB(final boolean b) {
        this.b = b;
    }
    
    public IsPlayerTranslatingWME(final boolean b) {
        this.b = b;
    }
    
    public IsPlayerTranslatingWME() {
    }
}
