package facade.util;

import java.util.LinkedList;

public class RawReactionDAArchive
{
    public static RawReactionDAArchive archive;
    public static LinkedList icList;
    private static final /* synthetic */ boolean $noassert;
    
    public void AddContent(final int daType, final int charID, final int param1, final int param2, final int param3, final long timestamp) {
        final RawReactionDA rawReactionDA = new RawReactionDA();
        rawReactionDA.daType = daType;
        rawReactionDA.charID = charID;
        rawReactionDA.param1 = param1;
        rawReactionDA.param2 = param2;
        rawReactionDA.param3 = param3;
        rawReactionDA.timestamp = timestamp;
        StringUtil.println("### RawReactionDAArchive added daType " + daType + " charID " + charID + " param1 " + param1 + " param2 " + param2 + " param3 " + param3 + " timestamp " + timestamp);
        RawReactionDAArchive.icList.add(rawReactionDA);
    }
    
    public int GetNumContents() {
        return RawReactionDAArchive.icList.size();
    }
    
    public long GetContentInfo(final int n, final IntegerRef integerRef, final IntegerRef integerRef2, final IntegerRef integerRef3, final IntegerRef integerRef4, final IntegerRef integerRef5) {
        if (!RawReactionDAArchive.$noassert && (n < 0 || n >= RawReactionDAArchive.icList.size())) {
            throw new AssertionError();
        }
        final RawReactionDA rawReactionDA = RawReactionDAArchive.icList.get(n);
        integerRef.i = rawReactionDA.daType;
        integerRef2.i = rawReactionDA.charID;
        integerRef3.i = rawReactionDA.param1;
        integerRef4.i = rawReactionDA.param2;
        integerRef5.i = rawReactionDA.param3;
        return rawReactionDA.timestamp;
    }
    
    public void SetContentInfo(final int n, final int daType, final int charID, final int param1, final int param2, final int param3, final long timestamp) {
        if (!RawReactionDAArchive.$noassert && (n < 0 || n >= RawReactionDAArchive.icList.size())) {
            throw new AssertionError();
        }
        final RawReactionDA rawReactionDA = RawReactionDAArchive.icList.get(n);
        rawReactionDA.daType = daType;
        rawReactionDA.charID = charID;
        rawReactionDA.param1 = param1;
        rawReactionDA.param2 = param2;
        rawReactionDA.param3 = param3;
        rawReactionDA.timestamp = timestamp;
    }
    
    public void DeleteContent(final int n) {
        if (!RawReactionDAArchive.$noassert && (n < 0 || n >= RawReactionDAArchive.icList.size())) {
            throw new AssertionError();
        }
        RawReactionDAArchive.icList.remove(n);
    }
    
    public boolean DoesExist(final int n, final int n2, final int n3, final int n4, final int n5) {
        for (int i = 0; i < RawReactionDAArchive.icList.size(); ++i) {
            final RawReactionDA rawReactionDA = RawReactionDAArchive.icList.get(i);
            if (n == rawReactionDA.daType && n2 == rawReactionDA.charID && (n3 == -2 || n3 == rawReactionDA.param1) && (n4 == -2 || n4 == rawReactionDA.param2) && (n5 == -2 || n5 == rawReactionDA.param3)) {
                return true;
            }
        }
        return false;
    }
    
    public RawReactionDAArchive() {
        RawReactionDAArchive.archive = this;
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.util.RawReactionDAArchive;").getComponentType().desiredAssertionStatus() ^ true);
        RawReactionDAArchive.icList = new LinkedList();
    }
    
    class RawReactionDA
    {
        public int daType;
        public int charID;
        public int param1;
        public int param2;
        public int param3;
        public long timestamp;
        
        private final /* synthetic */ void this() {
            this.daType = -1;
            this.charID = -1;
            this.param1 = -1;
            this.param2 = -1;
            this.param3 = -1;
            this.timestamp = 0L;
        }
        
        RawReactionDA() {
            this.this();
        }
    }
}
