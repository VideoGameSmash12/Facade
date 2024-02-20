package dramaman.runtime;

public class BeatStartWME extends BeatEventWME implements DramaManagerConstants
{
    public BeatStartWME(final Beat beat) {
        super(0, beat, beat.getBeatID());
    }
    
    public BeatStartWME() {
        this.setBeatEventID(0);
    }
}
