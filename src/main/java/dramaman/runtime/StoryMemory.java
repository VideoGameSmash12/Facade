package dramaman.runtime;

import java.util.LinkedList;
import wm.WorkingMemory;

public class StoryMemory extends WorkingMemory
{
    public static StoryMemory memory;
    
    public static StoryMemory getStoryMemory() {
        return StoryMemory.memory;
    }
    
    public StoryStatusWME getStoryStatusWME() {
        final LinkedList lookupWME = this.lookupWME("StoryStatusWME");
        if (lookupWME.size() != 1) {
            throw new DramaManagerError("Number of StoryStatusWME's " + lookupWME.size() + " != 1");
        }
        return (StoryStatusWME)lookupWME.get(0);
    }
    
    public float getStoryValue(final String s) {
        final LinkedList lookupWME = this.lookupWME(s);
        if (lookupWME.size() == 0) {
            throw new DramaManagerError("No WME found in story memory for story value " + s);
        }
        if (lookupWME.size() > 1) {
            throw new DramaManagerError("More than one WME found in story memory for story value " + s);
        }
        return lookupWME.get(0).getValue();
    }
    
    public void setStoryValue(final String s, final float value) {
        final LinkedList lookupWME = this.lookupWME(s);
        if (lookupWME.size() == 0) {
            throw new DramaManagerError("No WME found in story memory for story value " + s);
        }
        if (lookupWME.size() > 1) {
            throw new DramaManagerError("More than one WME found in story memory for story value " + s);
        }
        lookupWME.get(0).setValue(value);
    }
    
    public StoryMemory() {
        super("StoryMemory");
        StoryMemory.memory = this;
    }
}
