package facade.util;

public interface BeatStatus
{
    public static final int eBeatStatus_notRunning = 0;
    public static final int eBeatStatus_running = 1;
    public static final int eBeatStatus_ambMetaCommentaryMixinPoint = 2;
    public static final int eBeatStatus_ambLastMixinPoint = 3;
    public static final int eBeatStatus_ambNextDecisionPoint = 4;
    public static final int eBeatStatus_completed = 5;
    public static final int eBeatStatus_aborted = 6;
    public static final int eBeatStatus = 7;
}
