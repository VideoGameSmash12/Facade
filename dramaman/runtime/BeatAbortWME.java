package dramaman.runtime;

public class BeatAbortWME extends BeatEventWME implements DramaManagerConstants
{
    private int beatAbortReason;
    
    public int getBeatAbortReason() {
        return this.beatAbortReason;
    }
    
    public void setBeatAbortReason(final int beatAbortReason) {
        this.beatAbortReason = beatAbortReason;
    }
    
    public BeatAbortWME(final Beat beat) {
        super(2, beat, beat.getBeatID());
        this.beatAbortReason = 0;
    }
    
    public BeatAbortWME(final Beat beat, final int beatAbortReason) {
        super(2, beat, beat.getBeatID());
        this.beatAbortReason = beatAbortReason;
    }
    
    public BeatAbortWME() {
        this.setBeatEventID(2);
    }
}
