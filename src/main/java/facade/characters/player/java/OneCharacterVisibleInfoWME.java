package facade.characters.player.java;

import wm.WME;

public class OneCharacterVisibleInfoWME extends WME
{
    private float lookDistance;
    
    public synchronized float getLookDistance() {
        return this.lookDistance;
    }
    
    public synchronized void setLookDistance(final float lookDistance) {
        this.lookDistance = lookDistance;
    }
    
    public OneCharacterVisibleInfoWME(final float lookDistance) {
        this.lookDistance = lookDistance;
    }
    
    public OneCharacterVisibleInfoWME() {
    }
}
