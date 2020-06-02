package facade.util;

public interface ReactionConstants
{
    public static final int cMixInThreshold_pushTooFar = 2;
    public static final int cMixInPriority_immediateAbortBeat = 100;
    public static final int cMixInPriority_immediateNoAbort = 99;
    public static final int cMixInPriority_veryStrongDA = 70;
    public static final int cMixInPriority_strongerDA = 60;
    public static final int cMixInPriority_satelliteFreebie = 51;
    public static final int cMixInPriority_satellite = 50;
    public static final int cMixInPriority_strongDA = 40;
    public static final int cMixInPriority_postBeatMixin = 35;
    public static final int cMixInPriority_objectFreebie = 31;
    public static final int cMixInPriority_object = 30;
    public static final int cMixInPriority_mildDA = 20;
    public static final int cMixInPriority_deflectSpecial = 15;
    public static final int cMixInPriority_deflect = 10;
    public static final int cMixInPriority_deflectCatchall = 5;
    public static final int cMixInPriority_pattern = 10;
    public static final int cContextPriority_global = 10;
    public static final int cContextPriority_postBeatGlobal = 20;
    public static final int cContextPriority_beat = 30;
    public static final int cContextPriority_duringMixIn = 40;
    public static final int ePostBeatMixinType_none = -1;
    public static final int ePostBeatMixinType_ArtistAdv_zzz = 0;
    public static final int ePostBeatMixinType_ExplDatAnniv_zzz = 10;
    public static final int ePostBeatMixinType_FAskDrink_zzz = 20;
    public static final int ePostBeatMixinType_GGreetsP_zzz = 30;
    public static final int ePostBeatMixinType_RockyMarriage_zzz = 40;
    public static final int ePostBeatMixinType_TripsAffairs_zzz = 50;
    public static final int ePostBeatMixinType_DoneBefore = 999;
}
