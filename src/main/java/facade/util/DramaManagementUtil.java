package facade.util;

public class DramaManagementUtil implements BeatID, DAType
{
    private static final /* synthetic */ boolean $noassert;
    
    public static boolean topicAvailable(final int n, final int[] array) {
        if (!DramaManagementUtil.$noassert && (n < 58 || n > 61)) {
            throw new AssertionError();
        }
        for (int i = 0; i < array.length; ++i) {
            if (((array[i] >= 9 && array[i] <= 11) || (array[i] >= 17 && array[i] <= 18)) && n == 59) {
                return true;
            }
            if (((array[i] >= 12 && array[i] <= 13) || (array[i] >= 19 && array[i] <= 20)) && n == 60) {
                return true;
            }
            if (((array[i] >= 14 && array[i] <= 16) || (array[i] >= 21 && array[i] <= 22)) && n == 61) {
                return true;
            }
        }
        return false;
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.util.DramaManagementUtil;").getComponentType().desiredAssertionStatus() ^ true);
    }
}
