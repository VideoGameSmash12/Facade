package facade.util;

import java.util.Random;

public class BeatHelperFxns implements SpriteID, BeatConstants, DAType, BeatID
{
    private static final Random randGen;
    private static final /* synthetic */ boolean $noassert;
    
    public static int getDecoratingObjectToLookAt() {
        final int nextInt = BeatHelperFxns.randGen.nextInt(3);
        if (nextInt == 0) {
            return 34;
        }
        if (nextInt == 1) {
            return 6;
        }
        return 38;
    }
    
    public static int mapObjSatlToBuggedChr(final int n) {
        if (n == 80 || n == 85 || n == 92 || n == 88 || n == 97 || n == 81 || n == 83 || n == 84 || n == 89 || n == 86 || n == 87 || n == 93 || n == 94 || n == 71 || n == 74 || n == 73 || n == 98) {
            return 0;
        }
        if (n == 95 || n == 90 || n == 91 || n == 72 || n == 82 || n == 96 || n == 75) {
            return 1;
        }
        StringUtil.println("### Error: unknown obj or satl in mapObjSatlToBuggedChr");
        if (!BeatHelperFxns.$noassert) {
            throw new AssertionError();
        }
        return 0;
    }
    
    public static int mapBeatIDToStoryID(final int n) {
        if ((n >= 9 && n <= 11) || (n >= 17 && n <= 18)) {
            return 59;
        }
        if ((n >= 12 && n <= 13) || (n >= 19 && n <= 20)) {
            return 60;
        }
        if ((n >= 14 && n <= 16) || (n >= 21 && n <= 22) || n == 29) {
            return 61;
        }
        return 58;
    }
    
    public static int mapSpriteIDToDAObjectParam(final int n) {
        int n2 = -1;
        switch (n) {
            case 3: {
                n2 = 80;
                break;
            }
            case 4: {
                n2 = 81;
                break;
            }
            case 5: {
                n2 = 82;
                break;
            }
            case 6: {
                n2 = 85;
                break;
            }
            case 7: {
                n2 = 86;
                break;
            }
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 20:
            case 21:
            case 22: {
                n2 = 87;
                break;
            }
            case 33: {
                n2 = 82;
                break;
            }
            case 34:
            case 35:
            case 36: {
                n2 = 88;
                break;
            }
            case 38: {
                n2 = 90;
                break;
            }
            case 39: {
                n2 = 91;
                break;
            }
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45: {
                n2 = 82;
                break;
            }
            case 24: {
                n2 = 96;
                break;
            }
            case 46: {
                n2 = 93;
                break;
            }
            case 23: {
                n2 = 95;
                break;
            }
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32: {
                n2 = 92;
                break;
            }
            case 11: {
                n2 = 99;
                break;
            }
        }
        return n2;
    }
    
    public static int mapDAObjectParamToStoryTopic(final int n) {
        switch (n) {
            case 80:
            case 81:
            case 82:
            case 84:
            case 85:
            case 88:
            case 89:
            case 90:
            case 92:
            case 93:
            case 94:
            case 97: {
                return 59;
            }
            case 86:
            case 87: {
                return 60;
            }
            case 91: {
                return 61;
            }
            default: {
                return 58;
            }
        }
    }
    
    public static boolean isAASubtopic(final int n) {
        return n == 97 || n == 80 || n == 85 || n == 92 || n == 93 || n == 88 || n == 90;
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.util.BeatHelperFxns;").getComponentType().desiredAssertionStatus() ^ true);
        randGen = new Random();
    }
}
