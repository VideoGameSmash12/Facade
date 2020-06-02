package facade.util;

public interface BeatArguments
{
    public static final int eBeatArgument_txnIn_NONE = -1;
    public static final int eBeatArgument_txnIn_Default = 0;
    public static final int eBeatArgument_txnIn_ReferTo = 1;
    public static final int eBeatArgument_txnIn_Redirect = 2;
    public static final int eBeatArgument_txnIn_InTripletAffinitySwitch = 3;
    public static final int eBeatArgument_txnOut_T2ToT3Transition = 4;
}
