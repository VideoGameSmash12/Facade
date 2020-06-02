package dramaman.runtime;

import facade.util.PrintUtilities;
import wm.TimeStampedWME;

public class BeatEventWME extends TimeStampedWME
{
    private int beatEventID;
    private int beatID;
    private Beat beat;
    
    public String formatBeatID() {
        return PrintUtilities.beatID_EnumToString(this.getBeatID());
    }
    
    public synchronized int getBeatEventID() {
        return this.beatEventID;
    }
    
    public synchronized void setBeatEventID(final int beatEventID) {
        this.beatEventID = beatEventID;
    }
    
    public synchronized int getBeatID() {
        return this.beatID;
    }
    
    public synchronized void setBeatID(final int beatID) {
        this.beatID = beatID;
    }
    
    public synchronized Beat getBeat() {
        return this.beat;
    }
    
    public synchronized void setBeat(final Beat beat) {
        this.beat = beat;
    }
    
    public BeatEventWME(final int beatEventID, final Beat beat, final int beatID) {
        this.beatEventID = beatEventID;
        this.beat = beat;
        this.beatID = beatID;
    }
    
    public BeatEventWME() {
    }
}
