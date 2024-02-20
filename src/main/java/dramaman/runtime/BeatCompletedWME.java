package dramaman.runtime;

public class BeatCompletedWME extends BeatEventWME implements DramaManagerConstants
{
    public BeatCompletedWME(final Beat beat) {
        super(1, beat, beat.getBeatID());
    }
    
    public BeatCompletedWME() {
        this.setBeatEventID(1);
    }
}
