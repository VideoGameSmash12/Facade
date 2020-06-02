package dramaman.compiler;

import java.io.IOException;
import java.io.PrintStream;

public class BeatParserTokenManager implements BeatParserConstants
{
    public static PrintStream debugStream;
    static final long[] jjbitVec0;
    static final long[] jjbitVec2;
    static final long[] jjbitVec3;
    static final long[] jjbitVec4;
    static final long[] jjbitVec5;
    static final long[] jjbitVec6;
    static final long[] jjbitVec7;
    static final long[] jjbitVec8;
    static final long[] jjbitVec9;
    static final long[] jjbitVec10;
    static final long[] jjbitVec11;
    static final long[] jjbitVec12;
    static final long[] jjbitVec13;
    static final long[] jjbitVec14;
    static final long[] jjbitVec15;
    static final int[] jjnextStates;
    public static final String[] jjstrLiteralImages;
    public static final String[] lexStateNames;
    public static final int[] jjnewLexState;
    static final long[] jjtoToken;
    static final long[] jjtoSkip;
    static final long[] jjtoSpecial;
    static final long[] jjtoMore;
    protected static JavaCharStream input_stream;
    private static final int[] jjrounds;
    private static final int[] jjstateSet;
    static StringBuffer image;
    static int jjimageLen;
    static int lengthOfMatch;
    protected static char curChar;
    static int curLexState;
    static int defaultLexState;
    static int jjnewStateCnt;
    static int jjround;
    static int jjmatchedPos;
    static int jjmatchedKind;
    
    public static void setDebugStream(final PrintStream debugStream) {
        BeatParserTokenManager.debugStream = debugStream;
    }
    
    private static final int jjStopStringLiteralDfa_0(final int n, final long n2, final long n3, final long n4) {
        switch (n) {
            case 0: {
                if ((n3 & 0x8014000000000000L) != 0x0L) {
                    return 52;
                }
                if ((n2 & 0x140L) != 0x0L || (n3 & 0x40000000000000L) != 0x0L || (n4 & (long)2) != 0x0L) {
                    return 2;
                }
                if ((n3 & 0x800000000L) != 0x0L) {
                    return 8;
                }
                if ((n2 & 0xFFFFFFFFFFFFE000L) != 0x0L || (n3 & 0x3FFFL) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 87;
                    return 55;
                }
                return -1;
            }
            case 1: {
                if ((n2 & 0x100L) != 0x0L) {
                    return 0;
                }
                if ((n2 & 0xFFFFFFFBFCFFE000L) != 0x0L || (n3 & 0x3FFFL) != 0x0L) {
                    if (BeatParserTokenManager.jjmatchedPos != 1) {
                        BeatParserTokenManager.jjmatchedKind = 87;
                        BeatParserTokenManager.jjmatchedPos = 1;
                    }
                    return 55;
                }
                if ((n2 & 0x403000000L) != 0x0L) {
                    return 55;
                }
                return -1;
            }
            case 2: {
                if ((n2 & 0x80004C100000000L) != 0x0L) {
                    return 55;
                }
                if ((n2 & 0xF7FFFB3AFEFFE000L) != 0x0L || (n3 & 0x3FFFL) != 0x0L) {
                    if (BeatParserTokenManager.jjmatchedPos != 2) {
                        BeatParserTokenManager.jjmatchedKind = 87;
                        BeatParserTokenManager.jjmatchedPos = 2;
                    }
                    return 55;
                }
                return -1;
            }
            case 3: {
                if ((n2 & 0x14400902040B0000L) != 0x0L) {
                    return 55;
                }
                if ((n2 & 0xE3BFF2B8FAF4E000L) != 0x0L || (n3 & 0x3FFFL) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 87;
                    BeatParserTokenManager.jjmatchedPos = 3;
                    return 55;
                }
                return -1;
            }
            case 4: {
                if ((n2 & 0xA235F2B80AC06000L) != 0x0L || (n3 & 0x3FF7L) != 0x0L) {
                    if (BeatParserTokenManager.jjmatchedPos != 4) {
                        BeatParserTokenManager.jjmatchedKind = 87;
                        BeatParserTokenManager.jjmatchedPos = 4;
                    }
                    return 55;
                }
                if ((n2 & 0x418A0000F0348000L) != 0x0L || (n3 & 0x8L) != 0x0L) {
                    return 55;
                }
                return -1;
            }
            case 5: {
                if ((n2 & 0xA22070A848C06000L) != 0x0L || (n3 & 0xFFDL) != 0x0L) {
                    if (BeatParserTokenManager.jjmatchedPos != 5) {
                        BeatParserTokenManager.jjmatchedKind = 87;
                        BeatParserTokenManager.jjmatchedPos = 5;
                    }
                    return 55;
                }
                if ((n2 & 0x115821002000000L) != 0x0L || (n3 & 0x3002L) != 0x0L) {
                    return 55;
                }
                return -1;
            }
            case 6: {
                if ((n2 & 0x300048804000L) != 0x0L || (n3 & 0x21L) != 0x0L) {
                    return 55;
                }
                if ((n2 & 0xA22040A800402000L) != 0x0L || (n3 & 0x2FDCL) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 87;
                    BeatParserTokenManager.jjmatchedPos = 6;
                    return 55;
                }
                return -1;
            }
            case 7: {
                if ((n2 & 0x822040A800000000L) != 0x0L || (n3 & 0x2CDCL) != 0x0L) {
                    if (BeatParserTokenManager.jjmatchedPos != 7) {
                        BeatParserTokenManager.jjmatchedKind = 87;
                        BeatParserTokenManager.jjmatchedPos = 7;
                    }
                    return 55;
                }
                if ((n2 & 0x2000000000402000L) != 0x0L || (n3 & 0x300L) != 0x0L) {
                    return 55;
                }
                return -1;
            }
            case 8: {
                if ((n2 & 0x8020002800000000L) != 0x0L || (n3 & 0x2ED0L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 87;
                    BeatParserTokenManager.jjmatchedPos = 8;
                    return 55;
                }
                if ((n2 & 0x200408000000000L) != 0x0L || (n3 & 0xCL) != 0x0L) {
                    return 55;
                }
                return -1;
            }
            case 9: {
                if ((n2 & 0x2800000000L) != 0x0L) {
                    return 55;
                }
                if ((n2 & 0x8020000000000000L) != 0x0L || (n3 & 0x2ED0L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 87;
                    BeatParserTokenManager.jjmatchedPos = 9;
                    return 55;
                }
                return -1;
            }
            case 10: {
                if ((n2 & 0x8020000000000000L) != 0x0L || (n3 & 0xE50L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 87;
                    BeatParserTokenManager.jjmatchedPos = 10;
                    return 55;
                }
                if ((n3 & 0x2080L) != 0x0L) {
                    return 55;
                }
                return -1;
            }
            case 11: {
                if ((n2 & 0x8020000000000000L) != 0x0L || (n3 & 0x40L) != 0x0L) {
                    return 55;
                }
                if ((n3 & 0xE10L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 87;
                    BeatParserTokenManager.jjmatchedPos = 11;
                    return 55;
                }
                return -1;
            }
            case 12: {
                if ((n3 & 0x600L) != 0x0L) {
                    return 55;
                }
                if ((n3 & 0x810L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 87;
                    BeatParserTokenManager.jjmatchedPos = 12;
                    return 55;
                }
                return -1;
            }
            case 13: {
                if ((n3 & 0x10L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 87;
                    BeatParserTokenManager.jjmatchedPos = 13;
                    return 55;
                }
                if ((n3 & 0x800L) != 0x0L) {
                    return 55;
                }
                return -1;
            }
            default: {
                return -1;
            }
        }
    }
    
    private static final int jjStartNfa_0(final int n, final long n2, final long n3, final long n4) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(n, n2, n3, n4), n + 1);
    }
    
    private static final int jjStopAtPos(final int jjmatchedPos, final int jjmatchedKind) {
        BeatParserTokenManager.jjmatchedKind = jjmatchedKind;
        return (BeatParserTokenManager.jjmatchedPos = jjmatchedPos) + 1;
    }
    
    private static final int jjStartNfaWithStates_0(final int jjmatchedPos, final int jjmatchedKind, final int n) {
        BeatParserTokenManager.jjmatchedKind = jjmatchedKind;
        BeatParserTokenManager.jjmatchedPos = jjmatchedPos;
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            return jjmatchedPos + 1;
        }
        return jjMoveNfa_0(n, jjmatchedPos + 1);
    }
    
    private static final int jjMoveStringLiteralDfa0_0() {
        switch (BeatParserTokenManager.curChar) {
            case '!': {
                BeatParserTokenManager.jjmatchedKind = 103;
                return jjMoveStringLiteralDfa1_0(0L, 70368744177664L, 0L);
            }
            case '%': {
                BeatParserTokenManager.jjmatchedKind = 122;
                return jjMoveStringLiteralDfa1_0(0L, 0L, 32L);
            }
            case '&': {
                BeatParserTokenManager.jjmatchedKind = 119;
                return jjMoveStringLiteralDfa1_0(0L, 281474976710656L, 4);
            }
            case '(': {
                return jjStopAtPos(0, 91);
            }
            case ')': {
                return jjStopAtPos(0, 92);
            }
            case '*': {
                BeatParserTokenManager.jjmatchedKind = 117;
                return jjMoveStringLiteralDfa1_0(0L, 0L, 1L);
            }
            case '+': {
                BeatParserTokenManager.jjmatchedKind = 115;
                return jjMoveStringLiteralDfa1_0(0L, 4612248968380809216L, 0L);
            }
            case ',': {
                return jjStopAtPos(0, 98);
            }
            case '-': {
                BeatParserTokenManager.jjmatchedKind = 116;
                return jjMoveStringLiteralDfa1_0(0L, -9222246136947933184L, 0L);
            }
            case '.': {
                return jjStartNfaWithStates_0(0, 99, 8);
            }
            case '/': {
                BeatParserTokenManager.jjmatchedKind = 118;
                return jjMoveStringLiteralDfa1_0(320L, 0L, 2);
            }
            case ':': {
                BeatParserTokenManager.jjmatchedKind = 106;
                return jjMoveStringLiteralDfa1_0(0L, 16384L, 512L);
            }
            case ';': {
                return jjStopAtPos(0, 97);
            }
            case '<': {
                BeatParserTokenManager.jjmatchedKind = 102;
                return jjMoveStringLiteralDfa1_0(0L, 576478344489467904L, 64L);
            }
            case '=': {
                BeatParserTokenManager.jjmatchedKind = 100;
                return jjMoveStringLiteralDfa1_0(0L, 8796093022208L, 0L);
            }
            case '>': {
                BeatParserTokenManager.jjmatchedKind = 101;
                return jjMoveStringLiteralDfa1_0(0L, 3458799698192629760L, 384L);
            }
            case '?': {
                return jjStopAtPos(0, 105);
            }
            case '[': {
                return jjStopAtPos(0, 95);
            }
            case '\\': {
                return jjStopAtPos(0, 90);
            }
            case ']': {
                return jjStopAtPos(0, 96);
            }
            case '^': {
                BeatParserTokenManager.jjmatchedKind = 121;
                return jjMoveStringLiteralDfa1_0(0L, 0L, 16L);
            }
            case 'a': {
                return jjMoveStringLiteralDfa1_0(-9223372036854767616L, 0L, 0L);
            }
            case 'b': {
                return jjMoveStringLiteralDfa1_0(114688L, 6L, 0L);
            }
            case 'c': {
                return jjMoveStringLiteralDfa1_0(8257536L, 8L, 0L);
            }
            case 'd': {
                return jjMoveStringLiteralDfa1_0(58720256L, 17L, 0L);
            }
            case 'e': {
                return jjMoveStringLiteralDfa1_0(201326592L, 32L, 0L);
            }
            case 'f': {
                return jjMoveStringLiteralDfa1_0(8321499136L, 0L, 0L);
            }
            case 'g': {
                return jjMoveStringLiteralDfa1_0(8589934592L, 0L, 0L);
            }
            case 'i': {
                return jjMoveStringLiteralDfa1_0(1082331758592L, 128L, 0L);
            }
            case 'l': {
                return jjMoveStringLiteralDfa1_0(1099511627776L, 0L, 0L);
            }
            case 'n': {
                return jjMoveStringLiteralDfa1_0(15393162788864L, 0L, 0L);
            }
            case 'p': {
                return jjMoveStringLiteralDfa1_0(263882790666240L, 832L, 0L);
            }
            case 'r': {
                return jjMoveStringLiteralDfa1_0(281474976710656L, 0L, 0L);
            }
            case 's': {
                return jjMoveStringLiteralDfa1_0(17451448556060672L, 3072L, 0L);
            }
            case 't': {
                return jjMoveStringLiteralDfa1_0(1134907106097364992L, 0L, 0L);
            }
            case 'v': {
                return jjMoveStringLiteralDfa1_0(3458764513820540928L, 0L, 0L);
            }
            case 'w': {
                return jjMoveStringLiteralDfa1_0(4611686018427387904L, 12288L, 0L);
            }
            case '{': {
                return jjStopAtPos(0, 93);
            }
            case '|': {
                BeatParserTokenManager.jjmatchedKind = 120;
                return jjMoveStringLiteralDfa1_0(0L, 140737488355328L, 8L);
            }
            case '}': {
                return jjStopAtPos(0, 94);
            }
            case '~': {
                return jjStopAtPos(0, 104);
            }
            default: {
                return jjMoveNfa_0(3, 0);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa1_0(final long n, final long n2, final long n3) {
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(0, n, n2, n3);
            return 1;
        }
        switch (BeatParserTokenManager.curChar) {
            case '&': {
                if ((n2 & 0x1000000000000L) != 0x0L) {
                    return jjStopAtPos(1, 112);
                }
                break;
            }
            case '*': {
                if ((n & 0x100L) != 0x0L) {
                    return jjStartNfaWithStates_0(1, 8, 0);
                }
                break;
            }
            case '+': {
                if ((n2 & 0x2000000000000L) != 0x0L) {
                    return jjStopAtPos(1, 113);
                }
                break;
            }
            case '-': {
                if ((n2 & 0x4000000000000L) != 0x0L) {
                    return jjStopAtPos(1, 114);
                }
                break;
            }
            case '/': {
                if ((n & 0x40L) != 0x0L) {
                    return jjStopAtPos(1, 6);
                }
                break;
            }
            case ':': {
                if ((n2 & 0x4000L) != 0x0L) {
                    return jjStopAtPos(1, 78);
                }
                break;
            }
            case '<': {
                if ((n2 & 0x800000000000000L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 123;
                    BeatParserTokenManager.jjmatchedPos = 1;
                }
                return jjMoveStringLiteralDfa2_0(n, 0L, n2, 0L, n3, 64L);
            }
            case '=': {
                if ((n2 & 0x80000000000L) != 0x0L) {
                    return jjStopAtPos(1, 107);
                }
                if ((n2 & 0x100000000000L) != 0x0L) {
                    return jjStopAtPos(1, 108);
                }
                if ((n2 & 0x200000000000L) != 0x0L) {
                    return jjStopAtPos(1, 109);
                }
                if ((n2 & 0x400000000000L) != 0x0L) {
                    return jjStopAtPos(1, 110);
                }
                if ((n2 & 0x4000000000000000L) != 0x0L) {
                    return jjStopAtPos(1, 126);
                }
                if ((n2 & Long.MIN_VALUE) != 0x0L) {
                    return jjStopAtPos(1, 127);
                }
                if ((n3 & 0x1L) != 0x0L) {
                    return jjStopAtPos(1, 128);
                }
                if ((n3 & (long)2) != 0x0L) {
                    return jjStopAtPos(1, 129);
                }
                if ((n3 & (long)4) != 0x0L) {
                    return jjStopAtPos(1, 130);
                }
                if ((n3 & 0x8L) != 0x0L) {
                    return jjStopAtPos(1, 131);
                }
                if ((n3 & 0x10L) != 0x0L) {
                    return jjStopAtPos(1, 132);
                }
                if ((n3 & 0x20L) != 0x0L) {
                    return jjStopAtPos(1, 133);
                }
                break;
            }
            case '>': {
                if ((n2 & 0x1000000000000000L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 124;
                    BeatParserTokenManager.jjmatchedPos = 1;
                }
                return jjMoveStringLiteralDfa2_0(n, 0L, n2, 2305843009213693952L, n3, 384L);
            }
            case '\\': {
                if ((n3 & 0x200L) != 0x0L) {
                    return jjStopAtPos(1, 137);
                }
                break;
            }
            case 'a': {
                return jjMoveStringLiteralDfa2_0(n, 19791478128640L, n2, 0L, n3, 0L);
            }
            case 'b': {
                return jjMoveStringLiteralDfa2_0(n, -9223372036854767616L, n2, 0L, n3, 0L);
            }
            case 'e': {
                return jjMoveStringLiteralDfa2_0(n, 285873031610368L, n2, 13319L, n3, 0L);
            }
            case 'f': {
                if ((n & 0x400000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(1, 34, 55);
                }
                return jjMoveStringLiteralDfa2_0(n, 0L, n2, 32L, n3, 0L);
            }
            case 'h': {
                return jjMoveStringLiteralDfa2_0(n, 4738349757947707392L, n2, 0L, n3, 0L);
            }
            case 'i': {
                return jjMoveStringLiteralDfa2_0(n, 1610612736L, n2, 16L, n3, 0L);
            }
            case 'l': {
                return jjMoveStringLiteralDfa2_0(n, 2215641088L, n2, 0L, n3, 0L);
            }
            case 'm': {
                return jjMoveStringLiteralDfa2_0(n, 103079215104L, n2, 0L, n3, 0L);
            }
            case 'n': {
                return jjMoveStringLiteralDfa2_0(n, 962072674304L, n2, 128L, n3, 0L);
            }
            case 'o': {
                if ((n & 0x1000000L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 24;
                    BeatParserTokenManager.jjmatchedPos = 1;
                }
                return jjMoveStringLiteralDfa2_0(n, 3458765626256932864L, n2, 8L, n3, 0L);
            }
            case 'r': {
                return jjMoveStringLiteralDfa2_0(n, 1008911869647290368L, n2, 832L, n3, 0L);
            }
            case 't': {
                return jjMoveStringLiteralDfa2_0(n, 1125899906842624L, n2, 0L, n3, 0L);
            }
            case 'u': {
                return jjMoveStringLiteralDfa2_0(n, 2401333395062784L, n2, 2048L, n3, 0L);
            }
            case 'w': {
                return jjMoveStringLiteralDfa2_0(n, 4503599627370496L, n2, 0L, n3, 0L);
            }
            case 'x': {
                return jjMoveStringLiteralDfa2_0(n, 134217728L, n2, 0L, n3, 0L);
            }
            case 'y': {
                return jjMoveStringLiteralDfa2_0(n, 9007199254806528L, n2, 0L, n3, 0L);
            }
            case '|': {
                if ((n2 & 0x800000000000L) != 0x0L) {
                    return jjStopAtPos(1, 111);
                }
                break;
            }
        }
        return jjStartNfa_0(0, n, n2, n3);
    }
    
    private static final int jjMoveStringLiteralDfa2_0(final long n, long n2, final long n3, long n4, final long n5, long n6) {
        if (((n2 &= n) | (n4 &= n3) | (n6 &= n5)) == 0x0L) {
            return jjStartNfa_0(0, n, n3, n5);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(1, n2, n4, n6);
            return 2;
        }
        switch (BeatParserTokenManager.curChar) {
            case '=': {
                if ((n6 & 0x40L) != 0x0L) {
                    return jjStopAtPos(2, 134);
                }
                if ((n6 & 0x80L) != 0x0L) {
                    return jjStopAtPos(2, 135);
                }
                break;
            }
            case '>': {
                if ((n4 & 0x2000000000000000L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 125;
                    BeatParserTokenManager.jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(n2, 0L, n4, 0L, n6, 256L);
            }
            case 'a': {
                return jjMoveStringLiteralDfa3_0(n2, 145241087984271360L, n4, 2, n6, 0L);
            }
            case 'b': {
                return jjMoveStringLiteralDfa3_0(n2, 140737488355328L, n4, 0L, n6, 0L);
            }
            case 'c': {
                return jjMoveStringLiteralDfa3_0(n2, 17592186044416L, n4, 2048L, n6, 0L);
            }
            case 'e': {
                return jjMoveStringLiteralDfa3_0(n2, 32768L, n4, 64L, n6, 0L);
            }
            case 'f': {
                return jjMoveStringLiteralDfa3_0(n2, 8388608L, n4, 33L, n6, 0L);
            }
            case 'h': {
                return jjMoveStringLiteralDfa3_0(n2, 0L, n4, 4, n6, 0L);
            }
            case 'i': {
                return jjMoveStringLiteralDfa3_0(n2, 5787160705543176192L, n4, 13184L, n6, 0L);
            }
            case 'l': {
                return jjMoveStringLiteralDfa3_0(n2, 2305851805575151616L, n4, 1024L, n6, 0L);
            }
            case 'n': {
                return jjMoveStringLiteralDfa3_0(n2, 9008300383272960L, n4, 8L, n6, 0L);
            }
            case 'o': {
                return jjMoveStringLiteralDfa3_0(n2, -9222738716009676800L, n4, 0L, n6, 0L);
            }
            case 'p': {
                return jjMoveStringLiteralDfa3_0(n2, 2251902892900352L, n4, 0L, n6, 0L);
            }
            case 'r': {
                if ((n2 & 0x100000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(2, 32, 55);
                }
                return jjMoveStringLiteralDfa3_0(n2, 108086391056891904L, n4, 0L, n6, 0L);
            }
            case 's': {
                return jjMoveStringLiteralDfa3_0(n2, 137506201600L, n4, 16L, n6, 0L);
            }
            case 't': {
                if ((n2 & 0x4000000000L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 38;
                    BeatParserTokenManager.jjmatchedPos = 2;
                }
                return jjMoveStringLiteralDfa3_0(n2, 284232480260096L, n4, 0L, n6, 0L);
            }
            case 'u': {
                return jjMoveStringLiteralDfa3_0(n2, 288230376185266176L, n4, 0L, n6, 0L);
            }
            case 'w': {
                if ((n2 & 0x40000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(2, 42, 55);
                }
                break;
            }
            case 'y': {
                if ((n2 & 0x800000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(2, 59, 55);
                }
                break;
            }
        }
        return jjStartNfa_0(1, n2, n4, n6);
    }
    
    private static final int jjMoveStringLiteralDfa3_0(final long n, long n2, final long n3, long n4, final long n5, long n6) {
        if (((n2 &= n) | (n4 &= n3) | (n6 &= n5)) == 0x0L) {
            return jjStartNfa_0(1, n, n3, n5);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(2, n2, n4, n6);
            return 3;
        }
        switch (BeatParserTokenManager.curChar) {
            case '=': {
                if ((n6 & 0x100L) != 0x0L) {
                    return jjStopAtPos(3, 136);
                }
                break;
            }
            case 'a': {
                return jjMoveStringLiteralDfa4_0(n2, 2305843012980211712L, n4, 4, n6, 0L);
            }
            case 'b': {
                return jjMoveStringLiteralDfa4_0(n2, 33554432L, n4, 1L, n6, 0L);
            }
            case 'c': {
                return jjMoveStringLiteralDfa4_0(n2, 9007199255003136L, n4, 2128L, n6, 0L);
            }
            case 'd': {
                if ((n2 & 0x1000000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(3, 60, 55);
                }
                break;
            }
            case 'e': {
                if ((n2 & 0x10000L) != 0x0L) {
                    return jjStartNfaWithStates_0(3, 16, 55);
                }
                if ((n2 & 0x20000L) != 0x0L) {
                    return jjStartNfaWithStates_0(3, 17, 55);
                }
                if ((n2 & 0x4000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(3, 26, 55);
                }
                if ((n2 & 0x400000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(3, 58, 55);
                }
                return jjMoveStringLiteralDfa4_0(n2, 2252349703716864L, n4, 1056L, n6, 0L);
            }
            case 'g': {
                if ((n2 & 0x10000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(3, 40, 55);
                }
                return jjMoveStringLiteralDfa4_0(n2, 0L, n4, 12288L, n6, 0L);
            }
            case 'i': {
                return jjMoveStringLiteralDfa4_0(n2, 2199023255552L, n4, 0L, n6, 0L);
            }
            case 'k': {
                return jjMoveStringLiteralDfa4_0(n2, 17592186044416L, n4, 0L, n6, 0L);
            }
            case 'l': {
                if ((n2 & 0x80000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(3, 43, 55);
                }
                return jjMoveStringLiteralDfa4_0(n2, 4611826790275497984L, n4, 0L, n6, 0L);
            }
            case 'n': {
                return jjMoveStringLiteralDfa4_0(n2, 144115188075855872L, n4, 0L, n6, 0L);
            }
            case 'o': {
                if ((n2 & 0x200000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(3, 33, 55);
                }
                return jjMoveStringLiteralDfa4_0(n2, 108086459776368640L, n4, 768L, n6, 0L);
            }
            case 'r': {
                if ((n2 & 0x80000L) != 0x0L) {
                    return jjStartNfaWithStates_0(3, 19, 55);
                }
                return jjMoveStringLiteralDfa4_0(n2, -9222809086901354496L, n4, 0L, n6, 0L);
            }
            case 's': {
                if ((n2 & 0x40000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(3, 54, 55);
                }
                return jjMoveStringLiteralDfa4_0(n2, 271581184L, n4, 8L, n6, 0L);
            }
            case 't': {
                return jjMoveStringLiteralDfa4_0(n2, 5700005721546752L, n4, 130L, n6, 0L);
            }
            case 'u': {
                return jjMoveStringLiteralDfa4_0(n2, 281474976710656L, n4, 0L, n6, 0L);
            }
            case 'v': {
                return jjMoveStringLiteralDfa4_0(n2, 35184372088832L, n4, 0L, n6, 0L);
            }
        }
        return jjStartNfa_0(2, n2, n4, n6);
    }
    
    private static final int jjMoveStringLiteralDfa4_0(final long n, long n2, final long n3, long n4, final long n5, long n6) {
        if (((n2 &= n) | (n4 &= n3) | (n6 &= n5)) == 0x0L) {
            return jjStartNfa_0(2, n, n3, n5);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(3, n2, n4, 0L);
            return 4;
        }
        switch (BeatParserTokenManager.curChar) {
            case '_': {
                return jjMoveStringLiteralDfa5_0(n2, 0L, n4, 128L);
            }
            case 'a': {
                return jjMoveStringLiteralDfa5_0(n2, 52913997086720L, n4, 0L);
            }
            case 'c': {
                return jjMoveStringLiteralDfa5_0(n2, 4503599627370496L, n4, 1056L);
            }
            case 'e': {
                if ((n2 & 0x10000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(4, 28, 55);
                }
                if ((n2 & 0x4000000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(4, 62, 55);
                }
                return jjMoveStringLiteralDfa5_0(n2, 70403103932416L, n4, 2049L);
            }
            case 'h': {
                if ((n2 & 0x40000L) != 0x0L) {
                    return jjStartNfaWithStates_0(4, 18, 55);
                }
                return jjMoveStringLiteralDfa5_0(n2, 9007199254740992L, n4, 12288L);
            }
            case 'i': {
                return jjMoveStringLiteralDfa5_0(n2, 1266637399392256L, n4, 2);
            }
            case 'k': {
                if ((n2 & 0x8000L) != 0x0L) {
                    return jjStartNfaWithStates_0(4, 15, 55);
                }
                break;
            }
            case 'l': {
                if ((n2 & 0x20000000L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 29;
                    BeatParserTokenManager.jjmatchedPos = 4;
                }
                return jjMoveStringLiteralDfa5_0(n2, 1107296256L, n4, 0L);
            }
            case 'n': {
                return jjMoveStringLiteralDfa5_0(n2, 134217728L, n4, 0L);
            }
            case 'o': {
                return jjMoveStringLiteralDfa5_0(n2, 0L, n4, 80L);
            }
            case 'r': {
                if ((n2 & 0x8000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(4, 51, 55);
                }
                return jjMoveStringLiteralDfa5_0(n2, 282093452009472L, n4, 768L);
            }
            case 's': {
                if ((n2 & 0x100000L) != 0x0L) {
                    return jjStartNfaWithStates_0(4, 20, 55);
                }
                return jjMoveStringLiteralDfa5_0(n2, 144115188075855872L, n4, 0L);
            }
            case 't': {
                if ((n2 & 0x200000L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 21;
                    BeatParserTokenManager.jjmatchedPos = 4;
                }
                else {
                    if ((n2 & 0x80000000L) != 0x0L) {
                        return jjStartNfaWithStates_0(4, 31, 55);
                    }
                    if ((n2 & 0x2000000000000L) != 0x0L) {
                        return jjStartNfaWithStates_0(4, 49, 55);
                    }
                }
                return jjMoveStringLiteralDfa5_0(n2, -6917529027641081856L, n4, 8L);
            }
            case 'u': {
                return jjMoveStringLiteralDfa5_0(n2, 8388608L, n4, 0L);
            }
            case 'v': {
                return jjMoveStringLiteralDfa5_0(n2, 2199023255552L, n4, 4);
            }
            case 'w': {
                if ((n2 & 0x80000000000000L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 55;
                    BeatParserTokenManager.jjmatchedPos = 4;
                }
                return jjMoveStringLiteralDfa5_0(n2, 72057594037927936L, n4, 0L);
            }
        }
        return jjStartNfa_0(3, n2, n4, 0L);
    }
    
    private static final int jjMoveStringLiteralDfa5_0(final long n, long n2, final long n3, long n4) {
        if (((n2 &= n) | (n4 &= n3)) == 0x0L) {
            return jjStartNfa_0(3, n, n3, 0L);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(4, n2, n4, 0L);
            return 5;
        }
        switch (BeatParserTokenManager.curChar) {
            case '_': {
                return jjMoveStringLiteralDfa6_0(n2, Long.MIN_VALUE, n4, 0L);
            }
            case 'a': {
                return jjMoveStringLiteralDfa6_0(n2, 24576L, n4, 137L);
            }
            case 'c': {
                if ((n2 & 0x800000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(5, 47, 55);
                }
                if ((n2 & 0x4000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(5, 50, 55);
                }
                return jjMoveStringLiteralDfa6_0(n2, 70368744177664L, n4, 0L);
            }
            case 'd': {
                if ((n4 & (long)2) != 0x0L) {
                    return jjStartNfaWithStates_0(5, 65, 55);
                }
                return jjMoveStringLiteralDfa6_0(n2, 134217728L, n4, 0L);
            }
            case 'e': {
                if ((n2 & 0x2000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(5, 25, 55);
                }
                if ((n2 & 0x20000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(5, 41, 55);
                }
                return jjMoveStringLiteralDfa6_0(n2, 0L, n4, 2048L);
            }
            case 'f': {
                return jjMoveStringLiteralDfa6_0(n2, 549755813888L, n4, 0L);
            }
            case 'g': {
                return jjMoveStringLiteralDfa6_0(n2, 17592186044416L, n4, 0L);
            }
            case 'h': {
                if ((n2 & 0x10000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(5, 52, 55);
                }
                break;
            }
            case 'i': {
                return jjMoveStringLiteralDfa6_0(n2, 2449958197289549824L, n4, 772L);
            }
            case 'l': {
                return jjMoveStringLiteralDfa6_0(n2, 1082130432L, n4, 0L);
            }
            case 'm': {
                return jjMoveStringLiteralDfa6_0(n2, 34359738368L, n4, 0L);
            }
            case 'n': {
                if ((n2 & 0x1000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(5, 48, 55);
                }
                return jjMoveStringLiteralDfa6_0(n2, 137443147776L, n4, 64L);
            }
            case 'r': {
                return jjMoveStringLiteralDfa6_0(n2, 9007199254740992L, n4, 0L);
            }
            case 's': {
                if ((n2 & 0x100000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(5, 56, 55);
                }
                break;
            }
            case 't': {
                if ((n2 & 0x1000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(5, 36, 55);
                }
                if ((n4 & 0x1000L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 76;
                    BeatParserTokenManager.jjmatchedPos = 5;
                }
                return jjMoveStringLiteralDfa6_0(n2, 35184372088832L, n4, 9248L);
            }
            case 'u': {
                return jjMoveStringLiteralDfa6_0(n2, 0L, n4, 16L);
            }
        }
        return jjStartNfa_0(4, n2, n4, 0L);
    }
    
    private static final int jjMoveStringLiteralDfa6_0(final long n, long n2, final long n3, long n4) {
        if (((n2 &= n) | (n4 &= n3)) == 0x0L) {
            return jjStartNfa_0(4, n, n3, 0L);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(5, n2, n4, 0L);
            return 6;
        }
        switch (BeatParserTokenManager.curChar) {
            case '_': {
                return jjMoveStringLiteralDfa7_0(n2, 0L, n4, 9216L);
            }
            case 'a': {
                return jjMoveStringLiteralDfa7_0(n2, -9223371487098961920L, n4, 0L);
            }
            case 'c': {
                return jjMoveStringLiteralDfa7_0(n2, 137438961664L, n4, 128L);
            }
            case 'd': {
                return jjMoveStringLiteralDfa7_0(n2, 0L, n4, 2112L);
            }
            case 'e': {
                if ((n2 & 0x100000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 44, 55);
                }
                if ((n2 & 0x200000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 45, 55);
                }
                return jjMoveStringLiteralDfa7_0(n2, 144115222435594240L, n4, 0L);
            }
            case 'l': {
                return jjMoveStringLiteralDfa7_0(n2, 2305843009213693952L, n4, 0L);
            }
            case 'n': {
                if ((n2 & 0x4000L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 14, 55);
                }
                return jjMoveStringLiteralDfa7_0(n2, 0L, n4, 8L);
            }
            case 'o': {
                return jjMoveStringLiteralDfa7_0(n2, 9007199254740992L, n4, 4);
            }
            case 'r': {
                return jjMoveStringLiteralDfa7_0(n2, 0L, n4, 16L);
            }
            case 's': {
                if ((n2 & 0x8000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 27, 55);
                }
                if ((n4 & 0x20L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 69, 55);
                }
                break;
            }
            case 't': {
                if ((n2 & 0x800000L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 23, 55);
                }
                if ((n4 & 0x1L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 64, 55);
                }
                return jjMoveStringLiteralDfa7_0(n2, 70368744177664L, n4, 768L);
            }
            case 'u': {
                return jjMoveStringLiteralDfa7_0(n2, 4194304L, n4, 0L);
            }
            case 'y': {
                if ((n2 & 0x40000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 30, 55);
                }
                break;
            }
        }
        return jjStartNfa_0(5, n2, n4, 0L);
    }
    
    private static final int jjMoveStringLiteralDfa7_0(final long n, long n2, final long n3, long n4) {
        if (((n2 &= n) | (n4 &= n3)) == 0x0L) {
            return jjStartNfa_0(5, n, n3, 0L);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(6, n2, n4, 0L);
            return 7;
        }
        switch (BeatParserTokenManager.curChar) {
            case '_': {
                return jjMoveStringLiteralDfa8_0(n2, 0L, n4, 2048L);
            }
            case 'a': {
                return jjMoveStringLiteralDfa8_0(n2, 0L, n4, 1024L);
            }
            case 'c': {
                return jjMoveStringLiteralDfa8_0(n2, -9223371487098961920L, n4, 0L);
            }
            case 'e': {
                if ((n2 & 0x400000L) != 0x0L) {
                    return jjStartNfaWithStates_0(7, 22, 55);
                }
                if ((n2 & 0x2000000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(7, 61, 55);
                }
                return jjMoveStringLiteralDfa8_0(n2, 70506183131136L, n4, 0L);
            }
            case 'i': {
                return jjMoveStringLiteralDfa8_0(n2, 0L, n4, 64L);
            }
            case 'n': {
                return jjMoveStringLiteralDfa8_0(n2, 153122421690335232L, n4, 0L);
            }
            case 'r': {
                return jjMoveStringLiteralDfa8_0(n2, 0L, n4, 4);
            }
            case 's': {
                return jjMoveStringLiteralDfa8_0(n2, 0L, n4, 16L);
            }
            case 't': {
                if ((n2 & 0x2000L) != 0x0L) {
                    return jjStartNfaWithStates_0(7, 13, 55);
                }
                return jjMoveStringLiteralDfa8_0(n2, 0L, n4, 8328L);
            }
            case 'y': {
                if ((n4 & 0x100L) != 0x0L) {
                    BeatParserTokenManager.jjmatchedKind = 72;
                    BeatParserTokenManager.jjmatchedPos = 7;
                }
                return jjMoveStringLiteralDfa8_0(n2, 0L, n4, 512L);
            }
            default: {
                return jjStartNfa_0(6, n2, n4, 0L);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa8_0(final long n, long n2, final long n3, long n4) {
        if (((n2 &= n) | (n4 &= n3)) == 0x0L) {
            return jjStartNfa_0(6, n, n3, 0L);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(7, n2, n4, 0L);
            return 8;
        }
        switch (BeatParserTokenManager.curChar) {
            case '_': {
                return jjMoveStringLiteralDfa9_0(n2, 0L, n4, 512L);
            }
            case 'a': {
                return jjMoveStringLiteralDfa9_0(n2, 0L, n4, 2048L);
            }
            case 'c': {
                return jjMoveStringLiteralDfa9_0(n2, 0L, n4, 1024L);
            }
            case 'd': {
                if ((n2 & 0x400000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(8, 46, 55);
                }
                break;
            }
            case 'e': {
                if ((n2 & 0x8000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(8, 39, 55);
                }
                return jjMoveStringLiteralDfa9_0(n2, 0L, n4, 8208L);
            }
            case 'i': {
                return jjMoveStringLiteralDfa9_0(n2, 9007199254740992L, n4, 128L);
            }
            case 'o': {
                return jjMoveStringLiteralDfa9_0(n2, 137438953472L, n4, 0L);
            }
            case 's': {
                if ((n4 & (long)4) != 0x0L) {
                    return jjStartNfaWithStates_0(8, 66, 55);
                }
                if ((n4 & 0x8L) != 0x0L) {
                    return jjStartNfaWithStates_0(8, 67, 55);
                }
                break;
            }
            case 't': {
                if ((n2 & 0x200000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(8, 57, 55);
                }
                return jjMoveStringLiteralDfa9_0(n2, -9223372002495037440L, n4, 64L);
            }
        }
        return jjStartNfa_0(7, n2, n4, 0L);
    }
    
    private static final int jjMoveStringLiteralDfa9_0(final long n, long n2, final long n3, long n4) {
        if (((n2 &= n) | (n4 &= n3)) == 0x0L) {
            return jjStartNfa_0(7, n, n3, 0L);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(8, n2, n4, 0L);
            return 9;
        }
        switch (BeatParserTokenManager.curChar) {
            case '_': {
                return jjMoveStringLiteralDfa10_0(n2, 0L, n4, 16L);
            }
            case 'c': {
                return jjMoveStringLiteralDfa10_0(n2, 0L, n4, 2048L);
            }
            case 'f': {
                if ((n2 & 0x2000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(9, 37, 55);
                }
                break;
            }
            case 'i': {
                return jjMoveStringLiteralDfa10_0(n2, Long.MIN_VALUE, n4, 64L);
            }
            case 'o': {
                return jjMoveStringLiteralDfa10_0(n2, 0L, n4, 128L);
            }
            case 's': {
                if ((n2 & 0x800000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(9, 35, 55);
                }
                return jjMoveStringLiteralDfa10_0(n2, 0L, n4, 8192L);
            }
            case 't': {
                return jjMoveStringLiteralDfa10_0(n2, 0L, n4, 1536L);
            }
            case 'z': {
                return jjMoveStringLiteralDfa10_0(n2, 9007199254740992L, n4, 0L);
            }
        }
        return jjStartNfa_0(8, n2, n4, 0L);
    }
    
    private static final int jjMoveStringLiteralDfa10_0(final long n, long n2, final long n3, long n4) {
        if (((n2 &= n) | (n4 &= n3)) == 0x0L) {
            return jjStartNfa_0(8, n, n3, 0L);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(9, n2, n4, 0L);
            return 10;
        }
        switch (BeatParserTokenManager.curChar) {
            case 'e': {
                return jjMoveStringLiteralDfa11_0(n2, 9007199254740992L, n4, 512L);
            }
            case 'i': {
                return jjMoveStringLiteralDfa11_0(n2, 0L, n4, 1024L);
            }
            case 'n': {
                if ((n4 & 0x80L) != 0x0L) {
                    return jjStartNfaWithStates_0(10, 71, 55);
                }
                break;
            }
            case 'o': {
                return jjMoveStringLiteralDfa11_0(n2, Long.MIN_VALUE, n4, 64L);
            }
            case 'r': {
                return jjMoveStringLiteralDfa11_0(n2, 0L, n4, 16L);
            }
            case 't': {
                if ((n4 & 0x2000L) != 0x0L) {
                    return jjStartNfaWithStates_0(10, 77, 55);
                }
                return jjMoveStringLiteralDfa11_0(n2, 0L, n4, 2048L);
            }
        }
        return jjStartNfa_0(9, n2, n4, 0L);
    }
    
    private static final int jjMoveStringLiteralDfa11_0(final long n, long n2, final long n3, long n4) {
        if (((n2 &= n) | (n4 &= n3)) == 0x0L) {
            return jjStartNfa_0(9, n, n3, 0L);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(10, n2, n4, 0L);
            return 11;
        }
        switch (BeatParserTokenManager.curChar) {
            case 'd': {
                if ((n2 & 0x20000000000000L) != 0x0L) {
                    return jjStartNfaWithStates_0(11, 53, 55);
                }
                break;
            }
            case 'i': {
                return jjMoveStringLiteralDfa12_0(n2, 0L, n4, 2048L);
            }
            case 'n': {
                if ((n2 & Long.MIN_VALUE) != 0x0L) {
                    return jjStartNfaWithStates_0(11, 63, 55);
                }
                if ((n4 & 0x40L) != 0x0L) {
                    return jjStartNfaWithStates_0(11, 70, 55);
                }
                break;
            }
            case 'o': {
                return jjMoveStringLiteralDfa12_0(n2, 0L, n4, 1024L);
            }
            case 's': {
                return jjMoveStringLiteralDfa12_0(n2, 0L, n4, 512L);
            }
            case 'u': {
                return jjMoveStringLiteralDfa12_0(n2, 0L, n4, 16L);
            }
        }
        return jjStartNfa_0(10, n2, n4, 0L);
    }
    
    private static final int jjMoveStringLiteralDfa12_0(final long n, long n2, final long n3, long n4) {
        n2 &= n;
        if ((n2 | (n4 &= n3)) == 0x0L) {
            return jjStartNfa_0(10, n, n3, 0L);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(11, 0L, n4, 0L);
            return 12;
        }
        switch (BeatParserTokenManager.curChar) {
            case 'l': {
                return jjMoveStringLiteralDfa13_0(n4, 16L);
            }
            case 'n': {
                if ((n4 & 0x400L) != 0x0L) {
                    return jjStartNfaWithStates_0(12, 74, 55);
                }
                break;
            }
            case 'o': {
                return jjMoveStringLiteralDfa13_0(n4, 2048L);
            }
            case 't': {
                if ((n4 & 0x200L) != 0x0L) {
                    return jjStartNfaWithStates_0(12, 73, 55);
                }
                break;
            }
        }
        return jjStartNfa_0(11, 0L, n4, 0L);
    }
    
    private static final int jjMoveStringLiteralDfa13_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(11, 0L, n, 0L);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(12, 0L, n2, 0L);
            return 13;
        }
        switch (BeatParserTokenManager.curChar) {
            case 'e': {
                return jjMoveStringLiteralDfa14_0(n2, 16L);
            }
            case 'n': {
                if ((n2 & 0x800L) != 0x0L) {
                    return jjStartNfaWithStates_0(13, 75, 55);
                }
                break;
            }
        }
        return jjStartNfa_0(12, 0L, n2, 0L);
    }
    
    private static final int jjMoveStringLiteralDfa14_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(12, 0L, n, 0L);
        }
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(13, 0L, n2, 0L);
            return 14;
        }
        switch (BeatParserTokenManager.curChar) {
            case 's': {
                if ((n2 & 0x10L) != 0x0L) {
                    return jjStartNfaWithStates_0(14, 68, 55);
                }
                break;
            }
        }
        return jjStartNfa_0(13, 0L, n2, 0L);
    }
    
    private static final void jjCheckNAdd(final int n) {
        if (BeatParserTokenManager.jjrounds[n] != BeatParserTokenManager.jjround) {
            BeatParserTokenManager.jjstateSet[BeatParserTokenManager.jjnewStateCnt++] = n;
            BeatParserTokenManager.jjrounds[n] = BeatParserTokenManager.jjround;
        }
    }
    
    private static final void jjAddStates(int n, final int n2) {
        do {
            BeatParserTokenManager.jjstateSet[BeatParserTokenManager.jjnewStateCnt++] = BeatParserTokenManager.jjnextStates[n];
        } while (n++ != n2);
    }
    
    private static final void jjCheckNAddTwoStates(final int n, final int n2) {
        jjCheckNAdd(n);
        jjCheckNAdd(n2);
    }
    
    private static final void jjCheckNAddStates(int n, final int n2) {
        do {
            jjCheckNAdd(BeatParserTokenManager.jjnextStates[n]);
        } while (n++ != n2);
    }
    
    private static final void jjCheckNAddStates(final int n) {
        jjCheckNAdd(BeatParserTokenManager.jjnextStates[n]);
        jjCheckNAdd(BeatParserTokenManager.jjnextStates[n + 1]);
    }
    
    private static final int jjMoveNfa_0(final int n, int jjmatchedPos) {
        int jjnewStateCnt = 0;
        BeatParserTokenManager.jjnewStateCnt = 56;
        int i = 1;
        BeatParserTokenManager.jjstateSet[0] = n;
        int jjmatchedKind = Integer.MAX_VALUE;
        while (true) {
            if (++BeatParserTokenManager.jjround == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (BeatParserTokenManager.curChar < '@') {
                final long n2 = 1L << BeatParserTokenManager.curChar;
                do {
                    switch (BeatParserTokenManager.jjstateSet[--i]) {
                        case 4: {
                            if ((0x3FE000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 79) {
                                jjmatchedKind = 79;
                            }
                            jjCheckNAddTwoStates(5, 6);
                            continue;
                        }
                        case 5: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 79) {
                                jjmatchedKind = 79;
                            }
                            jjCheckNAddTwoStates(5, 6);
                            continue;
                        }
                        case 8: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 83) {
                                jjmatchedKind = 83;
                            }
                            jjCheckNAddStates(20, 22);
                            continue;
                        }
                        case 11: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 83) {
                                jjmatchedKind = 83;
                            }
                            jjCheckNAddTwoStates(11, 12);
                            continue;
                        }
                        case 34: {
                            if (BeatParserTokenManager.curChar != '.') {
                                continue;
                            }
                            if (jjmatchedKind > 83) {
                                jjmatchedKind = 83;
                            }
                            jjCheckNAddStates(27, 29);
                            continue;
                        }
                        case 35: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 83) {
                                jjmatchedKind = 83;
                            }
                            jjCheckNAddStates(27, 29);
                            continue;
                        }
                        case 38: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 83) {
                                jjmatchedKind = 83;
                            }
                            jjCheckNAddTwoStates(38, 12);
                            continue;
                        }
                        case 42: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 83) {
                                jjmatchedKind = 83;
                            }
                            jjCheckNAddTwoStates(42, 12);
                            continue;
                        }
                        case 47: {
                            if (BeatParserTokenManager.curChar != '0') {
                                continue;
                            }
                            if (jjmatchedKind > 79) {
                                jjmatchedKind = 79;
                            }
                            jjCheckNAddStates(17, 19);
                            continue;
                        }
                        case 49: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 79) {
                                jjmatchedKind = 79;
                            }
                            jjCheckNAddTwoStates(49, 6);
                            continue;
                        }
                        case 50: {
                            if ((0xFF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 79) {
                                jjmatchedKind = 79;
                            }
                            jjCheckNAddTwoStates(50, 6);
                            continue;
                        }
                        case 53: {
                            if (BeatParserTokenManager.curChar != '0') {
                                continue;
                            }
                            if (jjmatchedKind > 79) {
                                jjmatchedKind = 79;
                            }
                            jjCheckNAddTwoStates(50, 6);
                            continue;
                        }
                        case 54: {
                            if (BeatParserTokenManager.curChar != '$') {
                                continue;
                            }
                            if (jjmatchedKind > 87) {
                                jjmatchedKind = 87;
                            }
                            jjCheckNAdd(55);
                            continue;
                        }
                        case 55: {
                            if ((0x3FF001000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 87) {
                                jjmatchedKind = 87;
                            }
                            jjCheckNAdd(55);
                            continue;
                        }
                        default: {
                            continue;
                        }
                        case 52: {
                            if ((0x3FF000000000000L & n2) != 0x0L) {
                                jjCheckNAddStates(0, 6);
                            }
                            else if (BeatParserTokenManager.curChar == '.') {
                                jjCheckNAdd(8);
                            }
                            if ((0x3FE000000000000L & n2) != 0x0L) {
                                if (jjmatchedKind > 79) {
                                    jjmatchedKind = 79;
                                }
                                jjCheckNAddTwoStates(5, 6);
                            }
                            else if (BeatParserTokenManager.curChar == '0') {
                                if (jjmatchedKind > 79) {
                                    jjmatchedKind = 79;
                                }
                                jjCheckNAddTwoStates(50, 6);
                            }
                            if (BeatParserTokenManager.curChar != '0') {
                                continue;
                            }
                            jjCheckNAdd(48);
                            continue;
                        }
                        case 3: {
                            if ((0x3FF000000000000L & n2) != 0x0L) {
                                jjCheckNAddStates(0, 6);
                            }
                            else if (BeatParserTokenManager.curChar == '$') {
                                if (jjmatchedKind > 87) {
                                    jjmatchedKind = 87;
                                }
                                jjCheckNAdd(55);
                            }
                            else if (BeatParserTokenManager.curChar == '-') {
                                jjAddStates(7, 11);
                            }
                            else if (BeatParserTokenManager.curChar == '\"') {
                                jjCheckNAddStates(12, 14);
                            }
                            else if (BeatParserTokenManager.curChar == '\'') {
                                jjAddStates(15, 16);
                            }
                            else if (BeatParserTokenManager.curChar == '.') {
                                jjCheckNAdd(8);
                            }
                            else if (BeatParserTokenManager.curChar == '/') {
                                BeatParserTokenManager.jjstateSet[BeatParserTokenManager.jjnewStateCnt++] = 2;
                            }
                            if ((0x3FF000000000000L & n2) != 0x0L && jjmatchedKind > 89) {
                                jjmatchedKind = 89;
                            }
                            if ((0x3FE000000000000L & n2) != 0x0L) {
                                if (jjmatchedKind > 79) {
                                    jjmatchedKind = 79;
                                }
                                jjCheckNAddTwoStates(5, 6);
                            }
                            else {
                                if (BeatParserTokenManager.curChar != '0') {
                                    continue;
                                }
                                if (jjmatchedKind > 79) {
                                    jjmatchedKind = 79;
                                }
                                jjCheckNAddStates(17, 19);
                            }
                            continue;
                        }
                        case 0: {
                            if (BeatParserTokenManager.curChar != '*') {
                                continue;
                            }
                            BeatParserTokenManager.jjstateSet[BeatParserTokenManager.jjnewStateCnt++] = 1;
                            continue;
                        }
                        case 1: {
                            if ((0xFFFF7FFFFFFFFFFFL & n2) == 0x0L || jjmatchedKind <= 7) {
                                continue;
                            }
                            jjmatchedKind = 7;
                            continue;
                        }
                        case 2: {
                            if (BeatParserTokenManager.curChar != '*') {
                                continue;
                            }
                            BeatParserTokenManager.jjstateSet[BeatParserTokenManager.jjnewStateCnt++] = 0;
                            continue;
                        }
                        case 7: {
                            if (BeatParserTokenManager.curChar != '.') {
                                continue;
                            }
                            jjCheckNAdd(8);
                            continue;
                        }
                        case 10: {
                            if ((0x280000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(11);
                            continue;
                        }
                        case 13: {
                            if (BeatParserTokenManager.curChar != '\'') {
                                continue;
                            }
                            jjAddStates(15, 16);
                            continue;
                        }
                        case 14: {
                            if ((0xFFFFFF7FFFFFDBFFL & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(15);
                            continue;
                        }
                        case 15: {
                            if (BeatParserTokenManager.curChar != '\'' || jjmatchedKind <= 85) {
                                continue;
                            }
                            jjmatchedKind = 85;
                            continue;
                        }
                        case 17: {
                            if ((0x8400000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(15);
                            continue;
                        }
                        case 18: {
                            if ((0xFF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddTwoStates(19, 15);
                            continue;
                        }
                        case 19: {
                            if ((0xFF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(15);
                            continue;
                        }
                        case 20: {
                            if ((0xF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            BeatParserTokenManager.jjstateSet[BeatParserTokenManager.jjnewStateCnt++] = 21;
                            continue;
                        }
                        case 21: {
                            if ((0xFF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(19);
                            continue;
                        }
                        case 22: {
                            if (BeatParserTokenManager.curChar != '\"') {
                                continue;
                            }
                            jjCheckNAddStates(12, 14);
                            continue;
                        }
                        case 23: {
                            if ((0xFFFFFFFBFFFFDBFFL & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddStates(12, 14);
                            continue;
                        }
                        case 25: {
                            if ((0x8400000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddStates(12, 14);
                            continue;
                        }
                        case 26: {
                            if (BeatParserTokenManager.curChar != '\"' || jjmatchedKind <= 86) {
                                continue;
                            }
                            jjmatchedKind = 86;
                            continue;
                        }
                        case 27: {
                            if ((0xFF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddStates(23, 26);
                            continue;
                        }
                        case 28: {
                            if ((0xFF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddStates(12, 14);
                            continue;
                        }
                        case 29: {
                            if ((0xF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            BeatParserTokenManager.jjstateSet[BeatParserTokenManager.jjnewStateCnt++] = 30;
                            continue;
                        }
                        case 30: {
                            if ((0xFF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(28);
                            continue;
                        }
                        case 31: {
                            if ((0x3FF000000000000L & n2) == 0x0L || jjmatchedKind <= 89) {
                                continue;
                            }
                            jjmatchedKind = 89;
                            continue;
                        }
                        case 32: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddStates(0, 6);
                            continue;
                        }
                        case 33: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddTwoStates(33, 34);
                            continue;
                        }
                        case 37: {
                            if ((0x280000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(38);
                            continue;
                        }
                        case 39: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddTwoStates(39, 40);
                            continue;
                        }
                        case 41: {
                            if ((0x280000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(42);
                            continue;
                        }
                        case 43: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddStates(30, 32);
                            continue;
                        }
                        case 45: {
                            if ((0x280000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(46);
                            continue;
                        }
                        case 46: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddTwoStates(46, 12);
                            continue;
                        }
                        case 51: {
                            if (BeatParserTokenManager.curChar != '-') {
                                continue;
                            }
                            jjAddStates(7, 11);
                            continue;
                        }
                    }
                } while (i != jjnewStateCnt);
            }
            else if (BeatParserTokenManager.curChar < '\u0080') {
                final long n3 = 1L << (BeatParserTokenManager.curChar & '?');
                do {
                    switch (BeatParserTokenManager.jjstateSet[--i]) {
                        case 3:
                        case 55: {
                            if ((0x7FFFFFE87FFFFFEL & n3) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 87) {
                                jjmatchedKind = 87;
                            }
                            jjCheckNAdd(55);
                            continue;
                        }
                        case 49: {
                            if ((0x7E0000007EL & n3) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 79) {
                                jjmatchedKind = 79;
                            }
                            jjCheckNAddTwoStates(49, 6);
                            continue;
                        }
                        default: {
                            continue;
                        }
                        case 1: {
                            if (jjmatchedKind <= 7) {
                                continue;
                            }
                            jjmatchedKind = 7;
                            continue;
                        }
                        case 6: {
                            if ((0x100000001000L & n3) == 0x0L || jjmatchedKind <= 79) {
                                continue;
                            }
                            jjmatchedKind = 79;
                            continue;
                        }
                        case 9: {
                            if ((0x2000000020L & n3) == 0x0L) {
                                continue;
                            }
                            jjAddStates(33, 34);
                            continue;
                        }
                        case 12: {
                            if ((0x5000000050L & n3) == 0x0L || jjmatchedKind <= 83) {
                                continue;
                            }
                            jjmatchedKind = 83;
                            continue;
                        }
                        case 14: {
                            if ((0xFFFFFFFFEFFFFFFFL & n3) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(15);
                            continue;
                        }
                        case 16: {
                            if (BeatParserTokenManager.curChar != '\\') {
                                continue;
                            }
                            jjAddStates(35, 37);
                            continue;
                        }
                        case 17: {
                            if ((0x14404410000000L & n3) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(15);
                            continue;
                        }
                        case 23: {
                            if ((0xFFFFFFFFEFFFFFFFL & n3) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddStates(12, 14);
                            continue;
                        }
                        case 24: {
                            if (BeatParserTokenManager.curChar != '\\') {
                                continue;
                            }
                            jjAddStates(38, 40);
                            continue;
                        }
                        case 25: {
                            if ((0x14404410000000L & n3) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddStates(12, 14);
                            continue;
                        }
                        case 36: {
                            if ((0x2000000020L & n3) == 0x0L) {
                                continue;
                            }
                            jjAddStates(41, 42);
                            continue;
                        }
                        case 40: {
                            if ((0x2000000020L & n3) == 0x0L) {
                                continue;
                            }
                            jjAddStates(43, 44);
                            continue;
                        }
                        case 44: {
                            if ((0x2000000020L & n3) == 0x0L) {
                                continue;
                            }
                            jjAddStates(45, 46);
                            continue;
                        }
                        case 48: {
                            if ((0x100000001000000L & n3) == 0x0L) {
                                continue;
                            }
                            jjCheckNAdd(49);
                            continue;
                        }
                    }
                } while (i != jjnewStateCnt);
            }
            else {
                final int n4 = BeatParserTokenManager.curChar >> 8;
                final int n5 = n4 >> 6;
                final long n6 = 1L << (n4 & 0x3F);
                final int n7 = (BeatParserTokenManager.curChar & '\u00ff') >> 6;
                final long n8 = 1L << (BeatParserTokenManager.curChar & '?');
                do {
                    switch (BeatParserTokenManager.jjstateSet[--i]) {
                        case 54:
                        case 55: {
                            if (!jjCanMove_2(n4, n5, n7, n6, n8)) {
                                continue;
                            }
                            if (jjmatchedKind > 87) {
                                jjmatchedKind = 87;
                            }
                            jjCheckNAdd(55);
                            continue;
                        }
                        default: {
                            continue;
                        }
                        case 3: {
                            if (jjCanMove_1(n4, n5, n7, n6, n8) && jjmatchedKind > 89) {
                                jjmatchedKind = 89;
                            }
                            if (!jjCanMove_2(n4, n5, n7, n6, n8)) {
                                continue;
                            }
                            if (jjmatchedKind > 87) {
                                jjmatchedKind = 87;
                            }
                            jjCheckNAdd(55);
                            continue;
                        }
                        case 1: {
                            if (!jjCanMove_0(n4, n5, n7, n6, n8) || jjmatchedKind <= 7) {
                                continue;
                            }
                            jjmatchedKind = 7;
                            continue;
                        }
                        case 14: {
                            if (!jjCanMove_0(n4, n5, n7, n6, n8)) {
                                continue;
                            }
                            BeatParserTokenManager.jjstateSet[BeatParserTokenManager.jjnewStateCnt++] = 15;
                            continue;
                        }
                        case 23: {
                            if (!jjCanMove_0(n4, n5, n7, n6, n8)) {
                                continue;
                            }
                            jjAddStates(12, 14);
                            continue;
                        }
                        case 31: {
                            if (!jjCanMove_1(n4, n5, n7, n6, n8) || jjmatchedKind <= 89) {
                                continue;
                            }
                            jjmatchedKind = 89;
                            continue;
                        }
                    }
                } while (i != jjnewStateCnt);
            }
            if (jjmatchedKind != Integer.MAX_VALUE) {
                BeatParserTokenManager.jjmatchedKind = jjmatchedKind;
                BeatParserTokenManager.jjmatchedPos = jjmatchedPos;
                jjmatchedKind = Integer.MAX_VALUE;
            }
            ++jjmatchedPos;
            if ((i = BeatParserTokenManager.jjnewStateCnt) == (jjnewStateCnt = 56 - (BeatParserTokenManager.jjnewStateCnt = jjnewStateCnt))) {
                break;
            }
            try {
                BeatParserTokenManager.curChar = JavaCharStream.readChar();
            }
            catch (IOException ex) {
                return jjmatchedPos;
            }
        }
        return jjmatchedPos;
    }
    
    private static final int jjMoveStringLiteralDfa0_3() {
        switch (BeatParserTokenManager.curChar) {
            case '*': {
                return jjMoveStringLiteralDfa1_3(2048L);
            }
            default: {
                return 1;
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa1_3(final long n) {
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            return 1;
        }
        switch (BeatParserTokenManager.curChar) {
            case '/': {
                if ((n & 0x800L) != 0x0L) {
                    return jjStopAtPos(1, 11);
                }
                return 2;
            }
            default: {
                return 2;
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa0_1() {
        return jjMoveNfa_1(0, 0);
    }
    
    private static final int jjMoveNfa_1(final int n, int jjmatchedPos) {
        int jjnewStateCnt = 0;
        BeatParserTokenManager.jjnewStateCnt = 3;
        int i = 1;
        BeatParserTokenManager.jjstateSet[0] = n;
        int jjmatchedKind = Integer.MAX_VALUE;
        while (true) {
            if (++BeatParserTokenManager.jjround == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (BeatParserTokenManager.curChar < '@') {
                final long n2 = 1L << BeatParserTokenManager.curChar;
                do {
                    switch (BeatParserTokenManager.jjstateSet[--i]) {
                        default: {
                            continue;
                        }
                        case 0: {
                            if ((0x2400L & n2) != 0x0L && jjmatchedKind > 9) {
                                jjmatchedKind = 9;
                            }
                            if (BeatParserTokenManager.curChar != '\r') {
                                continue;
                            }
                            BeatParserTokenManager.jjstateSet[BeatParserTokenManager.jjnewStateCnt++] = 1;
                            continue;
                        }
                        case 1: {
                            if (BeatParserTokenManager.curChar != '\n' || jjmatchedKind <= 9) {
                                continue;
                            }
                            jjmatchedKind = 9;
                            continue;
                        }
                        case 2: {
                            if (BeatParserTokenManager.curChar != '\r') {
                                continue;
                            }
                            BeatParserTokenManager.jjstateSet[BeatParserTokenManager.jjnewStateCnt++] = 1;
                            continue;
                        }
                    }
                } while (i != jjnewStateCnt);
            }
            else if (BeatParserTokenManager.curChar < '\u0080') {
                final long n3 = 1L << (BeatParserTokenManager.curChar & '?');
                do {
                    final int n4 = BeatParserTokenManager.jjstateSet[--i];
                } while (i != jjnewStateCnt);
            }
            else {
                final int n5 = BeatParserTokenManager.curChar >> 8;
                final int n6 = (BeatParserTokenManager.curChar & '\u00ff') >> 6;
                final long n7 = 1L << (BeatParserTokenManager.curChar & '?');
                do {
                    final int n8 = BeatParserTokenManager.jjstateSet[--i];
                } while (i != jjnewStateCnt);
            }
            if (jjmatchedKind != Integer.MAX_VALUE) {
                BeatParserTokenManager.jjmatchedKind = jjmatchedKind;
                BeatParserTokenManager.jjmatchedPos = jjmatchedPos;
                jjmatchedKind = Integer.MAX_VALUE;
            }
            ++jjmatchedPos;
            if ((i = BeatParserTokenManager.jjnewStateCnt) == (jjnewStateCnt = 3 - (BeatParserTokenManager.jjnewStateCnt = jjnewStateCnt))) {
                break;
            }
            try {
                BeatParserTokenManager.curChar = JavaCharStream.readChar();
            }
            catch (IOException ex) {
                return jjmatchedPos;
            }
        }
        return jjmatchedPos;
    }
    
    private static final int jjMoveStringLiteralDfa0_2() {
        switch (BeatParserTokenManager.curChar) {
            case '*': {
                return jjMoveStringLiteralDfa1_2(1024L);
            }
            default: {
                return 1;
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa1_2(final long n) {
        try {
            BeatParserTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            return 1;
        }
        switch (BeatParserTokenManager.curChar) {
            case '/': {
                if ((n & 0x400L) != 0x0L) {
                    return jjStopAtPos(1, 10);
                }
                return 2;
            }
            default: {
                return 2;
            }
        }
    }
    
    private static final boolean jjCanMove_0(final int n, final int n2, final int n3, final long n4, final long n5) {
        switch (n) {
            case 0: {
                boolean b = false;
                if ((BeatParserTokenManager.jjbitVec2[n3] & n5) != 0x0L) {
                    b = true;
                }
                return b;
            }
            default: {
                return (BeatParserTokenManager.jjbitVec0[n2] & n4) != 0x0L;
            }
        }
    }
    
    private static final boolean jjCanMove_1(final int n, final int n2, final int n3, final long n4, final long n5) {
        switch (n) {
            case 6: {
                boolean b = false;
                if ((BeatParserTokenManager.jjbitVec5[n3] & n5) != 0x0L) {
                    b = true;
                }
                return b;
            }
            case 11: {
                boolean b2 = false;
                if ((BeatParserTokenManager.jjbitVec6[n3] & n5) != 0x0L) {
                    b2 = true;
                }
                return b2;
            }
            case 13: {
                boolean b3 = false;
                if ((BeatParserTokenManager.jjbitVec7[n3] & n5) != 0x0L) {
                    b3 = true;
                }
                return b3;
            }
            case 14: {
                boolean b4 = false;
                if ((BeatParserTokenManager.jjbitVec8[n3] & n5) != 0x0L) {
                    b4 = true;
                }
                return b4;
            }
            case 16: {
                boolean b5 = false;
                if ((BeatParserTokenManager.jjbitVec9[n3] & n5) != 0x0L) {
                    b5 = true;
                }
                return b5;
            }
            default: {
                return (BeatParserTokenManager.jjbitVec3[n2] & n4) != 0x0L && (BeatParserTokenManager.jjbitVec4[n3] & n5) != 0x0L;
            }
        }
    }
    
    private static final boolean jjCanMove_2(final int n, final int n2, final int n3, final long n4, final long n5) {
        switch (n) {
            case 0: {
                boolean b = false;
                if ((BeatParserTokenManager.jjbitVec11[n3] & n5) != 0x0L) {
                    b = true;
                }
                return b;
            }
            case 48: {
                boolean b2 = false;
                if ((BeatParserTokenManager.jjbitVec12[n3] & n5) != 0x0L) {
                    b2 = true;
                }
                return b2;
            }
            case 49: {
                boolean b3 = false;
                if ((BeatParserTokenManager.jjbitVec13[n3] & n5) != 0x0L) {
                    b3 = true;
                }
                return b3;
            }
            case 51: {
                boolean b4 = false;
                if ((BeatParserTokenManager.jjbitVec14[n3] & n5) != 0x0L) {
                    b4 = true;
                }
                return b4;
            }
            case 61: {
                boolean b5 = false;
                if ((BeatParserTokenManager.jjbitVec15[n3] & n5) != 0x0L) {
                    b5 = true;
                }
                return b5;
            }
            default: {
                return (BeatParserTokenManager.jjbitVec10[n2] & n4) != 0x0L;
            }
        }
    }
    
    public static void ReInit(final JavaCharStream input_stream) {
        BeatParserTokenManager.jjmatchedPos = (BeatParserTokenManager.jjnewStateCnt = 0);
        BeatParserTokenManager.curLexState = BeatParserTokenManager.defaultLexState;
        BeatParserTokenManager.input_stream = input_stream;
        ReInitRounds();
    }
    
    private static final void ReInitRounds() {
        BeatParserTokenManager.jjround = -2147483647;
        int n = 56;
        while (n-- > 0) {
            BeatParserTokenManager.jjrounds[n] = Integer.MIN_VALUE;
        }
    }
    
    public static void ReInit(final JavaCharStream javaCharStream, final int n) {
        ReInit(javaCharStream);
        SwitchTo(n);
    }
    
    public static void SwitchTo(final int curLexState) {
        if (curLexState >= 4 || curLexState < 0) {
            throw new TokenMgrError("Error: Ignoring invalid lexical state : " + curLexState + ". State unchanged.", 2);
        }
        BeatParserTokenManager.curLexState = curLexState;
    }
    
    protected static Token jjFillToken() {
        final Token token = Token.newToken(BeatParserTokenManager.jjmatchedKind);
        token.kind = BeatParserTokenManager.jjmatchedKind;
        final String s = BeatParserTokenManager.jjstrLiteralImages[BeatParserTokenManager.jjmatchedKind];
        token.image = ((s == null) ? JavaCharStream.GetImage() : s);
        token.beginLine = JavaCharStream.getBeginLine();
        token.beginColumn = JavaCharStream.getBeginColumn();
        token.endLine = JavaCharStream.getEndLine();
        token.endColumn = JavaCharStream.getEndColumn();
        return token;
    }
    
    public static Token getNextToken() {
        Token specialToken = null;
        int n = 0;
    Label_0599:
        while (true) {
            try {
                BeatParserTokenManager.curChar = JavaCharStream.BeginToken();
            }
            catch (IOException ex) {
                BeatParserTokenManager.jjmatchedKind = 0;
                final Token jjFillToken = jjFillToken();
                jjFillToken.specialToken = specialToken;
                return jjFillToken;
            }
            BeatParserTokenManager.image = null;
            BeatParserTokenManager.jjimageLen = 0;
            while (true) {
                switch (BeatParserTokenManager.curLexState) {
                    case 0: {
                        try {
                            JavaCharStream.backup(0);
                            while (BeatParserTokenManager.curChar <= ' ' && (0x100003600L & 1L << BeatParserTokenManager.curChar) != 0x0L) {
                                BeatParserTokenManager.curChar = JavaCharStream.BeginToken();
                            }
                        }
                        catch (IOException ex2) {
                            continue Label_0599;
                        }
                        BeatParserTokenManager.jjmatchedKind = Integer.MAX_VALUE;
                        BeatParserTokenManager.jjmatchedPos = 0;
                        n = jjMoveStringLiteralDfa0_0();
                        break;
                    }
                    case 1: {
                        BeatParserTokenManager.jjmatchedKind = Integer.MAX_VALUE;
                        BeatParserTokenManager.jjmatchedPos = 0;
                        n = jjMoveStringLiteralDfa0_1();
                        if (BeatParserTokenManager.jjmatchedPos == 0 && BeatParserTokenManager.jjmatchedKind > 12) {
                            BeatParserTokenManager.jjmatchedKind = 12;
                        }
                        break;
                    }
                    case 2: {
                        BeatParserTokenManager.jjmatchedKind = Integer.MAX_VALUE;
                        BeatParserTokenManager.jjmatchedPos = 0;
                        n = jjMoveStringLiteralDfa0_2();
                        if (BeatParserTokenManager.jjmatchedPos == 0 && BeatParserTokenManager.jjmatchedKind > 12) {
                            BeatParserTokenManager.jjmatchedKind = 12;
                        }
                        break;
                    }
                    case 3: {
                        BeatParserTokenManager.jjmatchedKind = Integer.MAX_VALUE;
                        BeatParserTokenManager.jjmatchedPos = 0;
                        n = jjMoveStringLiteralDfa0_3();
                        if (BeatParserTokenManager.jjmatchedPos == 0 && BeatParserTokenManager.jjmatchedKind > 12) {
                            BeatParserTokenManager.jjmatchedKind = 12;
                            break;
                        }
                        break;
                    }
                }
                if (BeatParserTokenManager.jjmatchedKind == Integer.MAX_VALUE) {
                    break Label_0599;
                }
                if (BeatParserTokenManager.jjmatchedPos + 1 < n) {
                    JavaCharStream.backup(n - BeatParserTokenManager.jjmatchedPos - 1);
                }
                if ((BeatParserTokenManager.jjtoToken[BeatParserTokenManager.jjmatchedKind >> 6] & 1L << (BeatParserTokenManager.jjmatchedKind & 0x3F)) != 0x0L) {
                    final Token jjFillToken2 = jjFillToken();
                    jjFillToken2.specialToken = specialToken;
                    if (BeatParserTokenManager.jjnewLexState[BeatParserTokenManager.jjmatchedKind] != -1) {
                        BeatParserTokenManager.curLexState = BeatParserTokenManager.jjnewLexState[BeatParserTokenManager.jjmatchedKind];
                    }
                    return jjFillToken2;
                }
                if ((BeatParserTokenManager.jjtoSkip[BeatParserTokenManager.jjmatchedKind >> 6] & 1L << (BeatParserTokenManager.jjmatchedKind & 0x3F)) != 0x0L) {
                    if ((BeatParserTokenManager.jjtoSpecial[BeatParserTokenManager.jjmatchedKind >> 6] & 1L << (BeatParserTokenManager.jjmatchedKind & 0x3F)) != 0x0L) {
                        final Token jjFillToken3 = jjFillToken();
                        if (specialToken == null) {
                            specialToken = jjFillToken3;
                        }
                        else {
                            jjFillToken3.specialToken = specialToken;
                            final Token token = specialToken;
                            final Token next = jjFillToken3;
                            token.next = next;
                            specialToken = next;
                        }
                        SkipLexicalActions(jjFillToken3);
                    }
                    else {
                        SkipLexicalActions(null);
                    }
                    if (BeatParserTokenManager.jjnewLexState[BeatParserTokenManager.jjmatchedKind] != -1) {
                        BeatParserTokenManager.curLexState = BeatParserTokenManager.jjnewLexState[BeatParserTokenManager.jjmatchedKind];
                    }
                    break;
                }
                MoreLexicalActions();
                if (BeatParserTokenManager.jjnewLexState[BeatParserTokenManager.jjmatchedKind] != -1) {
                    BeatParserTokenManager.curLexState = BeatParserTokenManager.jjnewLexState[BeatParserTokenManager.jjmatchedKind];
                }
                n = 0;
                BeatParserTokenManager.jjmatchedKind = Integer.MAX_VALUE;
                try {
                    BeatParserTokenManager.curChar = JavaCharStream.readChar();
                    continue;
                }
                catch (IOException ex3) {}
                break Label_0599;
            }
        }
        int endLine = JavaCharStream.getEndLine();
        int endColumn = JavaCharStream.getEndColumn();
        String s = null;
        boolean b = false;
        try {
            JavaCharStream.readChar();
            JavaCharStream.backup(1);
        }
        catch (IOException ex4) {
            b = true;
            s = ((n <= 1) ? "" : JavaCharStream.GetImage());
            if (BeatParserTokenManager.curChar == '\n' || BeatParserTokenManager.curChar == '\r') {
                ++endLine;
                endColumn = 0;
            }
            else {
                ++endColumn;
            }
        }
        if (!b) {
            JavaCharStream.backup(1);
            s = ((n <= 1) ? "" : JavaCharStream.GetImage());
        }
        throw new TokenMgrError(b, BeatParserTokenManager.curLexState, endLine, endColumn, s, BeatParserTokenManager.curChar, 0);
    }
    
    static void SkipLexicalActions(final Token token) {
        final int jjmatchedKind = BeatParserTokenManager.jjmatchedKind;
    }
    
    static void MoreLexicalActions() {
        BeatParserTokenManager.jjimageLen += (BeatParserTokenManager.lengthOfMatch = BeatParserTokenManager.jjmatchedPos + 1);
        switch (BeatParserTokenManager.jjmatchedKind) {
            case 7: {
                if (BeatParserTokenManager.image == null) {
                    BeatParserTokenManager.image = new StringBuffer(new String(JavaCharStream.GetSuffix(BeatParserTokenManager.jjimageLen)));
                }
                else {
                    BeatParserTokenManager.image.append(JavaCharStream.GetSuffix(BeatParserTokenManager.jjimageLen));
                }
                BeatParserTokenManager.jjimageLen = 0;
                JavaCharStream.backup(1);
                break;
            }
        }
    }
    
    public BeatParserTokenManager(final JavaCharStream input_stream) {
        if (BeatParserTokenManager.input_stream != null) {
            throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", 1);
        }
        BeatParserTokenManager.input_stream = input_stream;
    }
    
    public BeatParserTokenManager(final JavaCharStream javaCharStream, final int n) {
        this(javaCharStream);
        SwitchTo(n);
    }
    
    static {
        BeatParserTokenManager.debugStream = System.out;
        jjbitVec0 = new long[] { -2L, -1, -1, -1 };
        jjbitVec2 = new long[] { 0L, 0L, -1, -1 };
        final long[] jjbitVec16 = new long[4];
        jjbitVec16[0] = 5632L;
        jjbitVec3 = jjbitVec16;
        jjbitVec4 = new long[] { 0L, 281200098803712L, 0L, 281200098803712L };
        jjbitVec5 = new long[] { 0L, 4393751543808L, 0L, 287948901175001088L };
        jjbitVec6 = new long[] { 0L, 281200098803712L, 0L, 280925220896768L };
        jjbitVec7 = new long[] { 0L, 281200098803712L, 0L, 0L };
        jjbitVec8 = new long[] { 0L, 67043328L, 0L, 67043328L };
        jjbitVec9 = new long[] { 0L, 1023L, 0L, 0L };
        jjbitVec10 = new long[] { 2301339413881290750L, -16384L, 4294967295L, 432345564227567616L };
        jjbitVec11 = new long[] { 0L, 0L, 0L, -36028797027352577L };
        jjbitVec12 = new long[] { 0L, -1, -1, -1 };
        jjbitVec13 = new long[] { -1, -1, 65535L, 0L };
        jjbitVec14 = new long[] { -1, -1, 0L, 0L };
        final long[] jjbitVec17 = new long[4];
        jjbitVec17[0] = 70368744177663L;
        jjbitVec15 = jjbitVec17;
        jjnextStates = new int[] { 33, 34, 39, 40, 43, 44, 12, 4, 52, 53, 7, 32, 23, 24, 26, 14, 16, 48, 50, 6, 8, 9, 12, 23, 24, 28, 26, 35, 36, 12, 43, 44, 12, 10, 11, 17, 18, 20, 25, 27, 29, 37, 38, 41, 42, 45, 46 };
        jjstrLiteralImages = new String[] { "", null, null, null, null, null, null, null, null, null, null, null, null, "abstract", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while", "abort_action", "defbeat", "beatid", "behaviors", "constants", "discourse_rules", "effects", "precondition", "init_action", "priority", "priority_test", "select_action", "succeed_action", "weight", "weight_test", "::", null, null, null, null, null, null, null, null, null, null, null, "\\", "(", ")", "{", "}", "[", "]", ";", ",", ".", "=", ">", "<", "!", "~", "?", ":", "==", "<=", ">=", "!=", "||", "&&", "++", "--", "+", "-", "*", "/", "&", "|", "^", "%", "<<", ">>", ">>>", "+=", "-=", "*=", "/=", "&=", "|=", "^=", "%=", "<<=", ">>=", ">>>=", ":\\" };
        lexStateNames = new String[] { "DEFAULT", "IN_SINGLE_LINE_COMMENT", "IN_FORMAL_COMMENT", "IN_MULTI_LINE_COMMENT" };
        jjnewLexState = new int[] { -1, -1, -1, -1, -1, -1, 1, 2, 3, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        jjtoToken = new long[] { -8191L, -1507329L, 1023L };
        jjtoSkip = new long[] { 3646L, 0L, 0L };
        jjtoSpecial = new long[] { 3584L, 0L, 0L };
        jjtoMore = new long[] { 4544L, 0L, 0L };
        jjrounds = new int[56];
        jjstateSet = new int[112];
        BeatParserTokenManager.curLexState = 0;
        BeatParserTokenManager.defaultLexState = 0;
    }
}
