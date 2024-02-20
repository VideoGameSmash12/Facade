package facade.characters.wmedef;

import wm.WME;

public class PlayerInfoWME extends WME
{
    private int gender;
    private int nameIndex;
    
    public synchronized int getGender() {
        return this.gender;
    }
    
    public synchronized int getNameIndex() {
        return this.nameIndex;
    }
    
    public synchronized void setGender(final int gender) {
        this.gender = gender;
    }
    
    public synchronized void setNameIndex(final int nameIndex) {
        this.nameIndex = nameIndex;
    }
    
    public PlayerInfoWME(final int gender, final int nameIndex) {
        this.gender = gender;
        this.nameIndex = nameIndex;
    }
    
    public PlayerInfoWME() {
        this.gender = Integer.MIN_VALUE;
        this.nameIndex = Integer.MIN_VALUE;
    }
}
