package facade.characters.wmedef;

import facade.util.PrintUtilities;
import wm.TransientWME;

public class AnimationCueWME extends TransientWME
{
    private int characterID;
    private int layerIndex;
    private int cue;
    
    public synchronized String formatCharacterID() {
        return PrintUtilities.spriteID_EnumToString(this.getCharacterID());
    }
    
    public synchronized String formatLayerIndex() {
        return PrintUtilities.animLayer_EnumToString(this.getLayerIndex());
    }
    
    public synchronized int getCharacterID() {
        return this.characterID;
    }
    
    public synchronized int getLayerIndex() {
        return this.layerIndex;
    }
    
    public synchronized int getCue() {
        return this.cue;
    }
    
    public synchronized void setCharacterID(final int characterID) {
        this.characterID = characterID;
    }
    
    public synchronized void setLayerIndex(final int layerIndex) {
        this.layerIndex = layerIndex;
    }
    
    public synchronized void setCue(final int cue) {
        this.cue = cue;
    }
    
    public AnimationCueWME(final int characterID, final int layerIndex, final int cue) {
        this.characterID = characterID;
        this.layerIndex = layerIndex;
        this.cue = cue;
    }
    
    public AnimationCueWME() {
    }
}
