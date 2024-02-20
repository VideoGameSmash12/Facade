package facade.characters.wmedef;

import wm.WME;

public class IsPlayerTranslatingOrRotatingWME extends WME
{
    private boolean b;
    
    public synchronized boolean getB() {
        return this.b;
    }
    
    public synchronized void setB(final boolean b) {
        this.b = b;
    }
    
    public IsPlayerTranslatingOrRotatingWME(final boolean b) {
        this.b = b;
    }
    
    public IsPlayerTranslatingOrRotatingWME() {
    }
}
