package facade.characters.wmedef;

import wm.WME;

public class PlayerTextWME extends WME
{
    private String playerString;
    
    public synchronized String getPlayerString() {
        return new String(this.playerString);
    }
    
    public synchronized void setPlayerString(final String s) {
        this.playerString = new String(s);
    }
    
    public PlayerTextWME(final String playerString) {
        this.playerString = playerString;
    }
    
    public PlayerTextWME() {
    }
}
