package facade.util;

import java.util.LinkedList;

public class IntermediateContentArchive implements SpriteID, EpisodicMemoryConstants
{
    public static IntermediateContentArchive archive;
    public static LinkedList icList;
    private static final /* synthetic */ boolean $noassert;
    
    public void AddContent(final int type, final int param1, final int param2, final int param3, final int chr) {
        final IntermediateContent intermediateContent = new IntermediateContent();
        intermediateContent.type = type;
        intermediateContent.param1 = param1;
        intermediateContent.param2 = param2;
        intermediateContent.param3 = param3;
        intermediateContent.chr = chr;
        StringUtil.println("### IntermediateContentArchive added type " + type + " param1 " + param1 + " param2 " + param2 + " param3 " + param3 + " chr " + chr);
        IntermediateContentArchive.icList.add(intermediateContent);
    }
    
    public int GetNumContents() {
        return IntermediateContentArchive.icList.size();
    }
    
    public void GetContentInfo(final int n, final IntegerRef integerRef, final IntegerRef integerRef2, final IntegerRef integerRef3, final IntegerRef integerRef4, final IntegerRef integerRef5) {
        if (!IntermediateContentArchive.$noassert && (n < 0 || n >= IntermediateContentArchive.icList.size())) {
            throw new AssertionError();
        }
        final IntermediateContent intermediateContent = IntermediateContentArchive.icList.get(n);
        integerRef.i = intermediateContent.type;
        integerRef2.i = intermediateContent.param1;
        integerRef3.i = intermediateContent.param2;
        integerRef4.i = intermediateContent.param3;
        integerRef5.i = intermediateContent.chr;
    }
    
    public void SetContentInfo(final int n, final int type, final int param1, final int param2, final int param3, final int chr) {
        if (!IntermediateContentArchive.$noassert && (n < 0 || n >= IntermediateContentArchive.icList.size())) {
            throw new AssertionError();
        }
        final IntermediateContent intermediateContent = IntermediateContentArchive.icList.get(n);
        intermediateContent.type = type;
        intermediateContent.param1 = param1;
        intermediateContent.param2 = param2;
        intermediateContent.param3 = param3;
        intermediateContent.chr = chr;
    }
    
    public void DeleteContent(final int n) {
        if (!IntermediateContentArchive.$noassert && (n < 0 || n >= IntermediateContentArchive.icList.size())) {
            throw new AssertionError();
        }
        IntermediateContentArchive.icList.remove(n);
    }
    
    public boolean DoesExist(final int n, final int n2, final int n3, final int n4) {
        for (int i = 0; i < IntermediateContentArchive.icList.size(); ++i) {
            final IntermediateContent intermediateContent = IntermediateContentArchive.icList.get(i);
            if (n == intermediateContent.type && n2 == intermediateContent.param1 && n3 == intermediateContent.param2 && n4 == intermediateContent.param3) {
                return true;
            }
        }
        return false;
    }
    
    public IntermediateContentArchive() {
        IntermediateContentArchive.archive = this;
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.util.IntermediateContentArchive;").getComponentType().desiredAssertionStatus() ^ true);
        IntermediateContentArchive.icList = new LinkedList();
    }
    
    class IntermediateContent
    {
        public int type;
        public int param1;
        public int param2;
        public int param3;
        public int chr;
        
        private final /* synthetic */ void this() {
            this.type = -1;
            this.param1 = -1;
            this.param2 = -1;
            this.param3 = -1;
            this.chr = -1;
        }
        
        IntermediateContent() {
            this.this();
        }
    }
}
