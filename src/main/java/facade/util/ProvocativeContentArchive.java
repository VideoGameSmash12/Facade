package facade.util;

import java.util.LinkedList;

public class ProvocativeContentArchive implements SpriteID, EpisodicMemoryConstants
{
    public static ProvocativeContentArchive archive;
    public static LinkedList pcList;
    private static final /* synthetic */ boolean $noassert;
    
    public int AddContent(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return this.AddContent(n, n2, n3, n4, n5, n6, false);
    }
    
    public int AddContent(final int n, final int n2, final int buggedChr, final int backstoryCategory1, final int backstoryCategory2, final int backstoryCategory3, final boolean b) {
        final ProvocativeContent provocativeContent = new ProvocativeContent();
        provocativeContent.uniqueID = ProvocativeContentArchive.pcList.size();
        provocativeContent.type = n;
        provocativeContent.param = n2;
        provocativeContent.buggedChr = buggedChr;
        provocativeContent.backstoryCategory1 = backstoryCategory1;
        provocativeContent.backstoryCategory2 = backstoryCategory2;
        provocativeContent.backstoryCategory3 = backstoryCategory3;
        ProvocativeContentArchive.pcList.add(provocativeContent);
        StringUtil.println("### ProvocativeContentArchive added type " + n + " param " + n2 + " buggedChr " + buggedChr + " backstoryCategories " + backstoryCategory1 + ' ' + backstoryCategory2 + ' ' + backstoryCategory3);
        if (b) {
            CrisisCalculus.incitingContentID = provocativeContent.uniqueID;
            CrisisCalculus.incitingContentType = n;
            CrisisCalculus.incitingContentParam = n2;
            if (buggedChr == 0) {
                CrisisCalculus.incitingContentChr = 1;
            }
            else {
                CrisisCalculus.incitingContentChr = 0;
            }
        }
        return provocativeContent.uniqueID;
    }
    
    public int GetNumContents() {
        return ProvocativeContentArchive.pcList.size();
    }
    
    public void GetContentInfo(final int n, final IntegerRef integerRef, final IntegerRef integerRef2) {
        if (!ProvocativeContentArchive.$noassert && (n < 0 || n >= ProvocativeContentArchive.pcList.size())) {
            throw new AssertionError();
        }
        final ProvocativeContent provocativeContent = ProvocativeContentArchive.pcList.get(n);
        integerRef.i = provocativeContent.type;
        integerRef2.i = provocativeContent.param;
    }
    
    public void GetContentInfo(final int n, final IntegerRef integerRef, final IntegerRef integerRef2, final IntegerRef integerRef3, final IntegerRef integerRef4, final IntegerRef integerRef5, final IntegerRef integerRef6, final BooleanRef booleanRef) {
        if (!ProvocativeContentArchive.$noassert && (n < 0 || n >= ProvocativeContentArchive.pcList.size())) {
            throw new AssertionError();
        }
        final ProvocativeContent provocativeContent = ProvocativeContentArchive.pcList.get(n);
        integerRef.i = provocativeContent.type;
        integerRef2.i = provocativeContent.param;
        integerRef3.i = provocativeContent.buggedChr;
        integerRef4.i = provocativeContent.backstoryCategory1;
        integerRef5.i = provocativeContent.backstoryCategory2;
        integerRef6.i = provocativeContent.backstoryCategory3;
        booleanRef.b = provocativeContent.bReactedToInCrisis;
    }
    
    public void GetContentInfo(final int n, final IntegerRef integerRef, final IntegerRef integerRef2, final IntegerRef integerRef3, final IntegerRef integerRef4, final BooleanRef booleanRef, final BooleanRef booleanRef2, final IntegerRef integerRef5, final IntegerRef integerRef6, final IntegerRef integerRef7, final IntegerRef integerRef8, final IntegerRef integerRef9, final IntegerRef integerRef10, final BooleanRef booleanRef3) {
        if (!ProvocativeContentArchive.$noassert && (n < 0 || n >= ProvocativeContentArchive.pcList.size())) {
            throw new AssertionError();
        }
        final ProvocativeContent provocativeContent = ProvocativeContentArchive.pcList.get(n);
        integerRef.i = provocativeContent.type;
        integerRef2.i = provocativeContent.param;
        integerRef3.i = provocativeContent.buggedChr;
        integerRef4.i = provocativeContent.provocativeTier;
        booleanRef.b = provocativeContent.bPlayerDirect;
        booleanRef2.b = provocativeContent.bAccusable;
        integerRef5.i = provocativeContent.buttonPush;
        integerRef6.i = provocativeContent.affinityEffect;
        integerRef7.i = provocativeContent.constructiveness;
        integerRef8.i = provocativeContent.backstoryCategory1;
        integerRef9.i = provocativeContent.backstoryCategory2;
        integerRef10.i = provocativeContent.backstoryCategory3;
        booleanRef3.b = provocativeContent.bReactedToInCrisis;
    }
    
    public void SetContentInfo(final int n, final int type, final int param, final int buggedChr, final int provocativeTier, final boolean bPlayerDirect, final boolean bAccusable, final int buttonPush, final int affinityEffect, final int constructiveness, final int backstoryCategory1, final int backstoryCategory2, final int backstoryCategory3, final boolean bReactedToInCrisis) {
        if (!ProvocativeContentArchive.$noassert && (n < 0 || n >= ProvocativeContentArchive.pcList.size())) {
            throw new AssertionError();
        }
        final ProvocativeContent provocativeContent = ProvocativeContentArchive.pcList.get(n);
        provocativeContent.type = type;
        provocativeContent.param = param;
        provocativeContent.buggedChr = buggedChr;
        provocativeContent.provocativeTier = provocativeTier;
        provocativeContent.bPlayerDirect = bPlayerDirect;
        provocativeContent.bAccusable = bAccusable;
        provocativeContent.buttonPush = buttonPush;
        provocativeContent.affinityEffect = affinityEffect;
        provocativeContent.constructiveness = constructiveness;
        provocativeContent.backstoryCategory1 = backstoryCategory1;
        provocativeContent.backstoryCategory2 = backstoryCategory2;
        provocativeContent.backstoryCategory3 = backstoryCategory3;
        provocativeContent.bReactedToInCrisis = bReactedToInCrisis;
    }
    
    public void DeleteContent(final int n) {
        if (!ProvocativeContentArchive.$noassert && (n < 0 || n >= ProvocativeContentArchive.pcList.size())) {
            throw new AssertionError();
        }
        ProvocativeContentArchive.pcList.remove(n);
    }
    
    public boolean GetReactedToInCrisis(final int n) {
        if (!ProvocativeContentArchive.$noassert && (n < 0 || n >= ProvocativeContentArchive.pcList.size())) {
            throw new AssertionError();
        }
        return ProvocativeContentArchive.pcList.get(n).bReactedToInCrisis;
    }
    
    public void SetReactedToInCrisis(final int n, final boolean bReactedToInCrisis) {
        if (!ProvocativeContentArchive.$noassert && (n < 0 || n >= ProvocativeContentArchive.pcList.size())) {
            throw new AssertionError();
        }
        ProvocativeContentArchive.pcList.get(n).bReactedToInCrisis = bReactedToInCrisis;
    }
    
    public ProvocativeContentArchive() {
        ProvocativeContentArchive.archive = this;
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.util.ProvocativeContentArchive;").getComponentType().desiredAssertionStatus() ^ true);
        ProvocativeContentArchive.pcList = new LinkedList();
    }
    
    class ProvocativeContent
    {
        public int uniqueID;
        public int type;
        public int param;
        public int buggedChr;
        public int provocativeTier;
        public boolean bPlayerDirect;
        public boolean bAccusable;
        public int buttonPush;
        public int affinityEffect;
        public int constructiveness;
        public int backstoryCategory1;
        public int backstoryCategory2;
        public int backstoryCategory3;
        public boolean bReactedToInCrisis;
        
        private final /* synthetic */ void this() {
            this.uniqueID = -1;
            this.type = -1;
            this.param = -1;
            this.buggedChr = -1;
            this.provocativeTier = -1;
            this.bPlayerDirect = false;
            this.bAccusable = false;
            this.buttonPush = 0;
            this.affinityEffect = 0;
            this.constructiveness = 0;
            this.backstoryCategory1 = -1;
            this.backstoryCategory2 = -1;
            this.backstoryCategory3 = -1;
            this.bReactedToInCrisis = false;
        }
        
        ProvocativeContent() {
            this.this();
        }
    }
}
