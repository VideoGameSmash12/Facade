package dramaman.runtime;

import facade.util.PrintUtilities;
import java.util.List;
import wm.TimeStampedWME;

public class BeatDistributionWME extends TimeStampedWME
{
    private List beatIDs;
    private List beats;
    private static final /* synthetic */ boolean $noassert;
    
    public synchronized String formatBeatIDs() {
        final StringBuffer sb = new StringBuffer();
        sb.append("{");
        if (!this.beatIDs.isEmpty()) {
            for (int i = 0; i < this.beatIDs.size() - 1; ++i) {
                sb.append(PrintUtilities.beatID_EnumToString((int)this.beatIDs.get(i)) + ", ");
            }
            sb.append(PrintUtilities.beatID_EnumToString(this.beatIDs.get(this.beatIDs.size() - 1)) + '}');
        }
        else {
            sb.append("}");
        }
        return sb.toString();
    }
    
    public synchronized List getBeatIDs() {
        return this.beatIDs;
    }
    
    public synchronized void setBeatIDs(final List beatIDs) {
        this.beatIDs = beatIDs;
    }
    
    public synchronized List getBeats() {
        return this.beats;
    }
    
    public synchronized void setBeats(final List beats) {
        this.beats = beats;
    }
    
    public BeatDistributionWME(final List beatIDs, final List beats) {
        if (!BeatDistributionWME.$noassert && beatIDs.size() != 0 && !beatIDs.get(0).getClass().getName().equals("java.lang.Integer")) {
            throw new AssertionError((Object)"Type error in first argument of BeatDistributionWME constructor");
        }
        if (!BeatDistributionWME.$noassert && beats.size() != 0 && !beats.get(0).getClass().getName().equals("dramaman.runtime.Beat")) {
            throw new AssertionError((Object)"Type error in second argument of BeatDistributionWME constructor");
        }
        if (!BeatDistributionWME.$noassert && beatIDs.size() != beats.size()) {
            throw new AssertionError((Object)"BeatDistributionWME constructor arguments must be the same size");
        }
        this.beatIDs = beatIDs;
        this.beats = beats;
    }
    
    public BeatDistributionWME() {
    }
    
    static {
        $noassert = (Class.forName("[Ldramaman.runtime.BeatDistributionWME;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
