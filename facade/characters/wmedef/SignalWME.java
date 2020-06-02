package facade.characters.wmedef;

import wm.WME;

public class SignalWME extends WME
{
    private String name;
    
    public synchronized String getName() {
        return this.name;
    }
    
    public synchronized void setName(final String s) {
        this.name = this.name;
    }
    
    public SignalWME(final String name) {
        this.name = name;
    }
    
    public SignalWME() {
    }
}
