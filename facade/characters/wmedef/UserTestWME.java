package facade.characters.wmedef;

import wm.WME;

public class UserTestWME extends WME
{
    private int param1;
    private int param2;
    private int param3;
    private int param4;
    
    public synchronized int getParam1() {
        return this.param1;
    }
    
    public synchronized int getParam2() {
        return this.param2;
    }
    
    public synchronized int getParam3() {
        return this.param3;
    }
    
    public synchronized int getParam4() {
        return this.param4;
    }
    
    public synchronized void setParam1(final int param1) {
        this.param1 = param1;
    }
    
    public synchronized void setParam2(final int param2) {
        this.param2 = param2;
    }
    
    public synchronized void setParam3(final int param3) {
        this.param3 = param3;
    }
    
    public synchronized void setParam4(final int param4) {
        this.param4 = param4;
    }
    
    public UserTestWME(final int param1, final int param2, final int param3, final int param4) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
        this.param4 = param4;
    }
    
    public UserTestWME() {
    }
}
