package debug;

import abl.runtime.BehavingEntity;

public class Trace
{
    static final boolean traceAll = false;
    static final boolean traceFreeze = false;
    static final boolean traceTrip = false;
    static final boolean traceGrace = true;
    static final int eTraceType_traceFreeze = 0;
    
    public static void ablTrace(final String s) {
        final String behavingEntityShortName = BehavingEntity.getBehavingEntity().getBehavingEntityShortName();
        behavingEntityShortName.equals("Trip");
        if (behavingEntityShortName.equals("Grace")) {}
    }
}
