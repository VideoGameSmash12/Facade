package TemplateCompiler;

import java.io.IOException;
import java.io.PrintStream;

public class NLUTokenManager implements NLUConstants
{
    public static PrintStream debugStream;
    static final long[] jjbitVec0;
    static final long[] jjbitVec2;
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
    protected static char curChar;
    static int curLexState;
    static int defaultLexState;
    static int jjnewStateCnt;
    static int jjround;
    static int jjmatchedPos;
    static int jjmatchedKind;
    
    public static void setDebugStream(final PrintStream debugStream) {
        NLUTokenManager.debugStream = debugStream;
    }
    
    private static final int jjStopStringLiteralDfa_0(final int n, final long n2) {
        switch (n) {
            case 0: {
                if ((n2 & 0x2000000000000000L) != 0x0L) {
                    return 3;
                }
                if ((n2 & 0xC000000L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 25;
                    return -1;
                }
                if ((n2 & 0x381F80L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 29;
                    return 9;
                }
                return -1;
            }
            case 1: {
                if ((n2 & 0x281F80L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 29;
                    NLUTokenManager.jjmatchedPos = 1;
                    return 9;
                }
                if ((n2 & 0xC000000L) != 0x0L) {
                    if (NLUTokenManager.jjmatchedPos == 0) {
                        NLUTokenManager.jjmatchedKind = 25;
                        NLUTokenManager.jjmatchedPos = 0;
                    }
                    return -1;
                }
                if ((n2 & 0x100000L) != 0x0L) {
                    return 9;
                }
                return -1;
            }
            case 2: {
                if ((n2 & 0x81F80L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 29;
                    NLUTokenManager.jjmatchedPos = 2;
                    return 9;
                }
                if ((n2 & 0x200000L) != 0x0L) {
                    return 9;
                }
                return -1;
            }
            case 3: {
                if ((n2 & 0x81F80L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 29;
                    NLUTokenManager.jjmatchedPos = 3;
                    return 9;
                }
                return -1;
            }
            case 4: {
                if ((n2 & 0x81F80L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 29;
                    NLUTokenManager.jjmatchedPos = 4;
                    return 9;
                }
                return -1;
            }
            case 5: {
                if ((n2 & 0x81D80L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 29;
                    NLUTokenManager.jjmatchedPos = 5;
                    return 9;
                }
                if ((n2 & 0x200L) != 0x0L) {
                    return 9;
                }
                return -1;
            }
            case 6: {
                if ((n2 & 0x80L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 29;
                    NLUTokenManager.jjmatchedPos = 6;
                    return 9;
                }
                if ((n2 & 0x81D00L) != 0x0L) {
                    return 9;
                }
                return -1;
            }
            case 7: {
                if ((n2 & 0x80L) != 0x0L) {
                    return 9;
                }
                return -1;
            }
            default: {
                return -1;
            }
        }
    }
    
    private static final int jjStartNfa_0(final int n, final long n2) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(n, n2), n + 1);
    }
    
    private static final int jjStopAtPos(final int jjmatchedPos, final int jjmatchedKind) {
        NLUTokenManager.jjmatchedKind = jjmatchedKind;
        return (NLUTokenManager.jjmatchedPos = jjmatchedPos) + 1;
    }
    
    private static final int jjStartNfaWithStates_0(final int jjmatchedPos, final int jjmatchedKind, final int n) {
        NLUTokenManager.jjmatchedKind = jjmatchedKind;
        NLUTokenManager.jjmatchedPos = jjmatchedPos;
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            return jjmatchedPos + 1;
        }
        return jjMoveNfa_0(n, jjmatchedPos + 1);
    }
    
    private static final int jjMoveStringLiteralDfa0_0() {
        switch (NLUTokenManager.curChar) {
            case '\r': {
                NLUTokenManager.jjmatchedKind = 4;
                return jjMoveStringLiteralDfa1_0(64L);
            }
            case '%': {
                return jjMoveStringLiteralDfa1_0(268697600L);
            }
            case '&': {
                return jjStopAtPos(0, 24);
            }
            case '(': {
                return jjStopAtPos(0, 13);
            }
            case ')': {
                return jjStopAtPos(0, 14);
            }
            case '/': {
                return jjMoveStringLiteralDfa1_0(2305843009213693952L);
            }
            case ':': {
                return jjStopAtPos(0, 23);
            }
            case ';': {
                return jjStopAtPos(0, 22);
            }
            case '<': {
                return jjMoveStringLiteralDfa1_0(134217728L);
            }
            case '=': {
                return jjMoveStringLiteralDfa1_0(67108864L);
            }
            case '[': {
                return jjStopAtPos(0, 15);
            }
            case ']': {
                return jjStopAtPos(0, 16);
            }
            case 'a': {
                return jjMoveStringLiteralDfa1_0(2097152L);
            }
            case 'd': {
                return jjMoveStringLiteralDfa1_0(7936L);
            }
            case 'i': {
                return jjMoveStringLiteralDfa1_0(524288L);
            }
            case 'o': {
                return jjMoveStringLiteralDfa1_0(1048576L);
            }
            case 't': {
                return jjMoveStringLiteralDfa1_0(128L);
            }
            case '|': {
                return jjStopAtPos(0, 17);
            }
            default: {
                return jjMoveNfa_0(0, 0);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa1_0(final long n) {
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(0, n);
            return 1;
        }
        switch (NLUTokenManager.curChar) {
            case '\n': {
                if ((n & 0x40L) != 0x0L) {
                    return jjStopAtPos(1, 6);
                }
                break;
            }
            case '%': {
                return jjMoveStringLiteralDfa2_0(n, 268435456L);
            }
            case '*': {
                if ((n & 0x2000000000000000L) != 0x0L) {
                    return jjStopAtPos(1, 61);
                }
                break;
            }
            case '-': {
                if ((n & 0x8000000L) != 0x0L) {
                    return jjStopAtPos(1, 27);
                }
                break;
            }
            case '>': {
                if ((n & 0x4000000L) != 0x0L) {
                    return jjStopAtPos(1, 26);
                }
                break;
            }
            case 'e': {
                return jjMoveStringLiteralDfa2_0(n, 8064L);
            }
            case 'f': {
                return jjMoveStringLiteralDfa2_0(n, 262144L);
            }
            case 'n': {
                return jjMoveStringLiteralDfa2_0(n, 2621440L);
            }
            case 'r': {
                if ((n & 0x100000L) != 0x0L) {
                    return jjStartNfaWithStates_0(1, 20, 9);
                }
                break;
            }
        }
        return jjStartNfa_0(0, n);
    }
    
    private static final int jjMoveStringLiteralDfa2_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(0, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(1, n2);
            return 2;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa3_0(n2, 268435456L);
            }
            case 'c': {
                return jjMoveStringLiteralDfa3_0(n2, 528384L);
            }
            case 'd': {
                if ((n2 & 0x200000L) != 0x0L) {
                    return jjStartNfaWithStates_0(2, 21, 9);
                }
                break;
            }
            case 'f': {
                return jjMoveStringLiteralDfa3_0(n2, 3840L);
            }
            case 'm': {
                return jjMoveStringLiteralDfa3_0(n2, 128L);
            }
            case 'r': {
                return jjMoveStringLiteralDfa3_0(n2, 262144L);
            }
        }
        return jjStartNfa_0(1, n2);
    }
    
    private static final int jjMoveStringLiteralDfa3_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(1, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(2, n2);
            return 3;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa4_0(n2, 268435456L);
            }
            case 'b': {
                return jjMoveStringLiteralDfa4_0(n2, 2048L);
            }
            case 'l': {
                return jjMoveStringLiteralDfa4_0(n2, 528384L);
            }
            case 'm': {
                return jjMoveStringLiteralDfa4_0(n2, 512L);
            }
            case 'o': {
                return jjMoveStringLiteralDfa4_0(n2, 262144L);
            }
            case 'p': {
                return jjMoveStringLiteralDfa4_0(n2, 128L);
            }
            case 'r': {
                return jjMoveStringLiteralDfa4_0(n2, 256L);
            }
            case 't': {
                return jjMoveStringLiteralDfa4_0(n2, 1024L);
            }
            default: {
                return jjStartNfa_0(2, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa4_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(2, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(3, n2);
            return 4;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa5_0(n2, 268435456L);
            }
            case 'a': {
                return jjMoveStringLiteralDfa5_0(n2, 4608L);
            }
            case 'e': {
                return jjMoveStringLiteralDfa5_0(n2, 2048L);
            }
            case 'l': {
                return jjMoveStringLiteralDfa5_0(n2, 128L);
            }
            case 'm': {
                return jjMoveStringLiteralDfa5_0(n2, 262144L);
            }
            case 'u': {
                return jjMoveStringLiteralDfa5_0(n2, 524544L);
            }
            case 'y': {
                return jjMoveStringLiteralDfa5_0(n2, 1024L);
            }
            default: {
                return jjStartNfa_0(3, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa5_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(3, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(4, n2);
            return 5;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa6_0(n2, 268435456L);
            }
            case 'a': {
                return jjMoveStringLiteralDfa6_0(n2, 2176L);
            }
            case 'd': {
                return jjMoveStringLiteralDfa6_0(n2, 524288L);
            }
            case 'f': {
                return jjMoveStringLiteralDfa6_0(n2, 262144L);
            }
            case 'l': {
                return jjMoveStringLiteralDfa6_0(n2, 256L);
            }
            case 'p': {
                if ((n2 & 0x200L) != 0x0L) {
                    return jjStartNfaWithStates_0(5, 9, 9);
                }
                return jjMoveStringLiteralDfa6_0(n2, 1024L);
            }
            case 'r': {
                return jjMoveStringLiteralDfa6_0(n2, 4096L);
            }
            default: {
                return jjStartNfa_0(4, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa6_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(4, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(5, n2);
            return 6;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa7_0(n2, 268435456L);
            }
            case 'e': {
                if ((n2 & 0x100L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 8, 9);
                }
                if ((n2 & 0x400L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 10, 9);
                }
                if ((n2 & 0x1000L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 12, 9);
                }
                if ((n2 & 0x80000L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 19, 9);
                }
                break;
            }
            case 'i': {
                return jjMoveStringLiteralDfa7_0(n2, 262144L);
            }
            case 't': {
                if ((n2 & 0x800L) != 0x0L) {
                    return jjStartNfaWithStates_0(6, 11, 9);
                }
                return jjMoveStringLiteralDfa7_0(n2, 128L);
            }
        }
        return jjStartNfa_0(5, n2);
    }
    
    private static final int jjMoveStringLiteralDfa7_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(5, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(6, n2);
            return 7;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa8_0(n2, 268435456L);
            }
            case 'e': {
                if ((n2 & 0x80L) != 0x0L) {
                    return jjStartNfaWithStates_0(7, 7, 9);
                }
                break;
            }
            case 'l': {
                return jjMoveStringLiteralDfa8_0(n2, 262144L);
            }
        }
        return jjStartNfa_0(6, n2);
    }
    
    private static final int jjMoveStringLiteralDfa8_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(6, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(7, n2);
            return 8;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa9_0(n2, 268435456L);
            }
            case 'e': {
                if ((n2 & 0x40000L) != 0x0L) {
                    return jjStopAtPos(8, 18);
                }
                break;
            }
        }
        return jjStartNfa_0(7, n2);
    }
    
    private static final int jjMoveStringLiteralDfa9_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(7, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(8, n2);
            return 9;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa10_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(8, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa10_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(8, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(9, n2);
            return 10;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa11_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(9, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa11_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(9, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(10, n2);
            return 11;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa12_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(10, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa12_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(10, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(11, n2);
            return 12;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa13_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(11, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa13_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(11, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(12, n2);
            return 13;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa14_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(12, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa14_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(12, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(13, n2);
            return 14;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa15_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(13, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa15_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(13, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(14, n2);
            return 15;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa16_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(14, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa16_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(14, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(15, n2);
            return 16;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa17_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(15, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa17_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(15, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(16, n2);
            return 17;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa18_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(16, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa18_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(16, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(17, n2);
            return 18;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa19_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(17, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa19_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(17, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(18, n2);
            return 19;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa20_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(18, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa20_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(18, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(19, n2);
            return 20;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa21_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(19, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa21_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(19, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(20, n2);
            return 21;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa22_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(20, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa22_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(20, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(21, n2);
            return 22;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa23_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(21, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa23_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(21, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(22, n2);
            return 23;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa24_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(22, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa24_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(22, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(23, n2);
            return 24;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa25_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(23, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa25_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(23, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(24, n2);
            return 25;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa26_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(24, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa26_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(24, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(25, n2);
            return 26;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa27_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(25, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa27_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(25, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(26, n2);
            return 27;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa28_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(26, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa28_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(26, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(27, n2);
            return 28;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa29_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(27, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa29_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(27, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(28, n2);
            return 29;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa30_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(28, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa30_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(28, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(29, n2);
            return 30;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa31_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(29, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa31_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(29, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(30, n2);
            return 31;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa32_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(30, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa32_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(30, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(31, n2);
            return 32;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa33_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(31, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa33_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(31, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(32, n2);
            return 33;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                return jjMoveStringLiteralDfa34_0(n2, 268435456L);
            }
            default: {
                return jjStartNfa_0(32, n2);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa34_0(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_0(32, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_0(33, n2);
            return 34;
        }
        switch (NLUTokenManager.curChar) {
            case '%': {
                if ((n2 & 0x10000000L) != 0x0L) {
                    return jjStopAtPos(34, 28);
                }
                break;
            }
        }
        return jjStartNfa_0(33, n2);
    }
    
    private static final void jjCheckNAdd(final int n) {
        if (NLUTokenManager.jjrounds[n] != NLUTokenManager.jjround) {
            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = n;
            NLUTokenManager.jjrounds[n] = NLUTokenManager.jjround;
        }
    }
    
    private static final void jjAddStates(int n, final int n2) {
        do {
            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = NLUTokenManager.jjnextStates[n];
        } while (n++ != n2);
    }
    
    private static final void jjCheckNAddTwoStates(final int n, final int n2) {
        jjCheckNAdd(n);
        jjCheckNAdd(n2);
    }
    
    private static final void jjCheckNAddStates(int n, final int n2) {
        do {
            jjCheckNAdd(NLUTokenManager.jjnextStates[n]);
        } while (n++ != n2);
    }
    
    private static final void jjCheckNAddStates(final int n) {
        jjCheckNAdd(NLUTokenManager.jjnextStates[n]);
        jjCheckNAdd(NLUTokenManager.jjnextStates[n + 1]);
    }
    
    private static final int jjMoveNfa_0(final int n, int jjmatchedPos) {
        int jjnewStateCnt = 0;
        NLUTokenManager.jjnewStateCnt = 9;
        int i = 1;
        NLUTokenManager.jjstateSet[0] = n;
        int jjmatchedKind = Integer.MAX_VALUE;
        while (true) {
            if (++NLUTokenManager.jjround == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (NLUTokenManager.curChar < '@') {
                final long n2 = 1L << NLUTokenManager.curChar;
                do {
                    switch (NLUTokenManager.jjstateSet[--i]) {
                        case 1: {
                            if ((0x83FF6C0000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 29) {
                                jjmatchedKind = 29;
                            }
                            jjCheckNAdd(1);
                            continue;
                        }
                        case 2: {
                            if ((0x3FF600000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 30) {
                                jjmatchedKind = 30;
                            }
                            jjCheckNAdd(2);
                            continue;
                        }
                        default: {
                            continue;
                        }
                        case 9: {
                            if ((0x83FF6C0000000000L & n2) != 0x0L) {
                                if (jjmatchedKind > 29) {
                                    jjmatchedKind = 29;
                                }
                                jjCheckNAdd(1);
                            }
                            if ((0x3FF600000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 30) {
                                jjmatchedKind = 30;
                            }
                            jjCheckNAdd(2);
                            continue;
                        }
                        case 0: {
                            if ((0x83FF6C0000000000L & n2) != 0x0L) {
                                if (jjmatchedKind > 29) {
                                    jjmatchedKind = 29;
                                }
                                jjCheckNAdd(1);
                            }
                            else if ((0x7000000000000000L & n2) != 0x0L) {
                                if (jjmatchedKind > 25) {
                                    jjmatchedKind = 25;
                                }
                            }
                            else if (NLUTokenManager.curChar == '/') {
                                NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 3;
                            }
                            if ((0x3FF600000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 30) {
                                jjmatchedKind = 30;
                            }
                            jjCheckNAdd(2);
                            continue;
                        }
                        case 3: {
                            if (NLUTokenManager.curChar != '/') {
                                continue;
                            }
                            jjCheckNAddStates(0, 2);
                            continue;
                        }
                        case 4: {
                            if ((0xFFFFFFFFFFFFDBFFL & n2) == 0x0L) {
                                continue;
                            }
                            jjCheckNAddStates(0, 2);
                            continue;
                        }
                        case 5: {
                            if ((0x2400L & n2) == 0x0L || jjmatchedKind <= 60) {
                                continue;
                            }
                            jjmatchedKind = 60;
                            continue;
                        }
                        case 6: {
                            if (NLUTokenManager.curChar != '\n' || jjmatchedKind <= 60) {
                                continue;
                            }
                            jjmatchedKind = 60;
                            continue;
                        }
                        case 7: {
                            if (NLUTokenManager.curChar != '\r') {
                                continue;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 6;
                            continue;
                        }
                        case 8: {
                            if (NLUTokenManager.curChar != '/') {
                                continue;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 3;
                            continue;
                        }
                    }
                } while (i != jjnewStateCnt);
            }
            else if (NLUTokenManager.curChar < '\u0080') {
                final long n3 = 1L << (NLUTokenManager.curChar & '?');
                do {
                    switch (NLUTokenManager.jjstateSet[--i]) {
                        case 1: {
                            if ((0x7FFFFFE87FFFFFEL & n3) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 29) {
                                jjmatchedKind = 29;
                            }
                            jjCheckNAdd(1);
                            continue;
                        }
                        case 2: {
                            if ((0x7FFFFFE97FFFFFEL & n3) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 30) {
                                jjmatchedKind = 30;
                            }
                            jjCheckNAdd(2);
                            continue;
                        }
                        default: {
                            continue;
                        }
                        case 9: {
                            if ((0x7FFFFFE97FFFFFEL & n3) != 0x0L) {
                                if (jjmatchedKind > 30) {
                                    jjmatchedKind = 30;
                                }
                                jjCheckNAdd(2);
                            }
                            if ((0x7FFFFFE87FFFFFEL & n3) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 29) {
                                jjmatchedKind = 29;
                            }
                            jjCheckNAdd(1);
                            continue;
                        }
                        case 0: {
                            if ((0x7FFFFFE97FFFFFEL & n3) != 0x0L) {
                                if (jjmatchedKind > 30) {
                                    jjmatchedKind = 30;
                                }
                                jjCheckNAdd(2);
                            }
                            if ((0x7FFFFFE87FFFFFEL & n3) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 29) {
                                jjmatchedKind = 29;
                            }
                            jjCheckNAdd(1);
                            continue;
                        }
                        case 4: {
                            jjAddStates(0, 2);
                            continue;
                        }
                    }
                } while (i != jjnewStateCnt);
            }
            else {
                final int n4 = NLUTokenManager.curChar >> 8;
                final int n5 = n4 >> 6;
                final long n6 = 1L << (n4 & 0x3F);
                final int n7 = (NLUTokenManager.curChar & '\u00ff') >> 6;
                final long n8 = 1L << (NLUTokenManager.curChar & '?');
                do {
                    switch (NLUTokenManager.jjstateSet[--i]) {
                        case 4: {
                            if (!jjCanMove_0(n4, n5, n7, n6, n8)) {
                                continue;
                            }
                            jjAddStates(0, 2);
                        }
                        default: {
                            continue;
                        }
                    }
                } while (i != jjnewStateCnt);
            }
            if (jjmatchedKind != Integer.MAX_VALUE) {
                NLUTokenManager.jjmatchedKind = jjmatchedKind;
                NLUTokenManager.jjmatchedPos = jjmatchedPos;
                jjmatchedKind = Integer.MAX_VALUE;
            }
            ++jjmatchedPos;
            if ((i = NLUTokenManager.jjnewStateCnt) == (jjnewStateCnt = 9 - (NLUTokenManager.jjnewStateCnt = jjnewStateCnt))) {
                break;
            }
            try {
                NLUTokenManager.curChar = JavaCharStream.readChar();
            }
            catch (IOException ex) {
                return jjmatchedPos;
            }
        }
        return jjmatchedPos;
    }
    
    private static final int jjMoveStringLiteralDfa0_2() {
        switch (NLUTokenManager.curChar) {
            case '*': {
                return jjMoveStringLiteralDfa1_2(4611686018427387904L);
            }
            default: {
                return 1;
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa1_2(final long n) {
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            return 1;
        }
        switch (NLUTokenManager.curChar) {
            case '/': {
                if ((n & 0x4000000000000000L) != 0x0L) {
                    return jjStopAtPos(1, 62);
                }
                return 2;
            }
            default: {
                return 2;
            }
        }
    }
    
    private static final int jjStopStringLiteralDfa_1(final int n, final long n2) {
        switch (n) {
            case 0: {
                if ((n2 & 0x780000000L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 46;
                    return 2;
                }
                return -1;
            }
            case 1: {
                if ((n2 & 0x780000000L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 46;
                    NLUTokenManager.jjmatchedPos = 1;
                    return 2;
                }
                return -1;
            }
            case 2: {
                if ((n2 & 0x300000000L) != 0x0L) {
                    return 2;
                }
                if ((n2 & 0x480000000L) != 0x0L) {
                    NLUTokenManager.jjmatchedKind = 46;
                    return NLUTokenManager.jjmatchedPos = 2;
                }
                return -1;
            }
            default: {
                return -1;
            }
        }
    }
    
    private static final int jjStartNfa_1(final int n, final long n2) {
        return jjMoveNfa_1(jjStopStringLiteralDfa_1(n, n2), n + 1);
    }
    
    private static final int jjStartNfaWithStates_1(final int jjmatchedPos, final int jjmatchedKind, final int n) {
        NLUTokenManager.jjmatchedKind = jjmatchedKind;
        NLUTokenManager.jjmatchedPos = jjmatchedPos;
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            return jjmatchedPos + 1;
        }
        return jjMoveNfa_1(n, jjmatchedPos + 1);
    }
    
    private static final int jjMoveStringLiteralDfa0_1() {
        switch (NLUTokenManager.curChar) {
            case '\r': {
                NLUTokenManager.jjmatchedKind = 57;
                return jjMoveStringLiteralDfa1_1(576460752303423488L);
            }
            case '(': {
                return jjStopAtPos(0, 35);
            }
            case ')': {
                return jjStopAtPos(0, 36);
            }
            case '-': {
                return jjStopAtPos(0, 41);
            }
            case '<': {
                return jjStopAtPos(0, 39);
            }
            case '>': {
                return jjStopAtPos(0, 40);
            }
            case '[': {
                return jjStopAtPos(0, 37);
            }
            case ']': {
                return jjStopAtPos(0, 38);
            }
            case 't': {
                return jjMoveStringLiteralDfa1_1(32212254720L);
            }
            case '{': {
                return jjStopAtPos(0, 42);
            }
            case '|': {
                return jjStopAtPos(0, 44);
            }
            case '}': {
                return jjStopAtPos(0, 43);
            }
            default: {
                return jjMoveNfa_1(0, 0);
            }
        }
    }
    
    private static final int jjMoveStringLiteralDfa1_1(final long n) {
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_1(0, n);
            return 1;
        }
        switch (NLUTokenManager.curChar) {
            case '\n': {
                if ((n & 0x800000000000000L) != 0x0L) {
                    return jjStopAtPos(1, 59);
                }
                break;
            }
            case 'a': {
                return jjMoveStringLiteralDfa2_1(n, 2147483648L);
            }
            case 'n': {
                return jjMoveStringLiteralDfa2_1(n, 17179869184L);
            }
            case 'o': {
                return jjMoveStringLiteralDfa2_1(n, 12884901888L);
            }
        }
        return jjStartNfa_1(0, n);
    }
    
    private static final int jjMoveStringLiteralDfa2_1(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_1(0, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_1(1, n2);
            return 2;
        }
        switch (NLUTokenManager.curChar) {
            case 'c': {
                if ((n2 & 0x200000000L) != 0x0L) {
                    return jjStartNfaWithStates_1(2, 33, 2);
                }
                break;
            }
            case 'n': {
                return jjMoveStringLiteralDfa3_1(n2, 2147483648L);
            }
            case 'o': {
                return jjMoveStringLiteralDfa3_1(n2, 17179869184L);
            }
            case 'r': {
                if ((n2 & 0x100000000L) != 0x0L) {
                    return jjStartNfaWithStates_1(2, 32, 2);
                }
                break;
            }
        }
        return jjStartNfa_1(1, n2);
    }
    
    private static final int jjMoveStringLiteralDfa3_1(final long n, long n2) {
        if ((n2 &= n) == 0x0L) {
            return jjStartNfa_1(1, n);
        }
        try {
            NLUTokenManager.curChar = JavaCharStream.readChar();
        }
        catch (IOException ex) {
            jjStopStringLiteralDfa_1(2, n2);
            return 3;
        }
        switch (NLUTokenManager.curChar) {
            case 'd': {
                if ((n2 & 0x80000000L) != 0x0L) {
                    return jjStartNfaWithStates_1(3, 31, 2);
                }
                break;
            }
            case 't': {
                if ((n2 & 0x400000000L) != 0x0L) {
                    return jjStartNfaWithStates_1(3, 34, 2);
                }
                break;
            }
        }
        return jjStartNfa_1(2, n2);
    }
    
    private static final int jjMoveNfa_1(final int n, int jjmatchedPos) {
        int jjnewStateCnt = 0;
        NLUTokenManager.jjnewStateCnt = 33;
        int i = 1;
        NLUTokenManager.jjstateSet[0] = n;
        int jjmatchedKind = Integer.MAX_VALUE;
        while (true) {
            if (++NLUTokenManager.jjround == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (NLUTokenManager.curChar < '@') {
                final long n2 = 1L << NLUTokenManager.curChar;
                do {
                    switch (NLUTokenManager.jjstateSet[--i]) {
                        case 1: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 46) {
                                jjmatchedKind = 46;
                            }
                            jjCheckNAdd(2);
                            continue;
                        }
                        case 2: {
                            if ((0x83FF6C0000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 46) {
                                jjmatchedKind = 46;
                            }
                            jjCheckNAdd(2);
                            continue;
                        }
                        case 4: {
                            if ((0x3FF000000000000L & n2) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 52) {
                                jjmatchedKind = 52;
                            }
                            jjCheckNAdd(4);
                            continue;
                        }
                        default: {
                            continue;
                        }
                        case 0: {
                            if ((0x3FF000000000000L & n2) != 0x0L) {
                                if (jjmatchedKind > 46) {
                                    jjmatchedKind = 46;
                                }
                                jjCheckNAdd(2);
                            }
                            else if (NLUTokenManager.curChar == ':') {
                                jjCheckNAddStates(3, 20);
                            }
                            else if (NLUTokenManager.curChar == ';') {
                                jjCheckNAddStates(21, 24);
                            }
                            else if ((0x8000040000000000L & n2) != 0x0L && jjmatchedKind > 45) {
                                jjmatchedKind = 45;
                            }
                            if (NLUTokenManager.curChar != '?') {
                                continue;
                            }
                            jjCheckNAdd(4);
                            continue;
                        }
                        case 3: {
                            if (NLUTokenManager.curChar != '?') {
                                continue;
                            }
                            jjCheckNAdd(4);
                            continue;
                        }
                        case 5: {
                            if (NLUTokenManager.curChar != ';') {
                                continue;
                            }
                            jjCheckNAddStates(21, 24);
                            continue;
                        }
                        case 6: {
                            if (NLUTokenManager.curChar != ')') {
                                continue;
                            }
                            jjmatchedKind = 53;
                            continue;
                        }
                        case 7:
                        case 27: {
                            if (NLUTokenManager.curChar != '-') {
                                continue;
                            }
                            jjCheckNAdd(6);
                            continue;
                        }
                        case 9:
                        case 30: {
                            if (NLUTokenManager.curChar != '-') {
                                continue;
                            }
                            jjCheckNAdd(8);
                            continue;
                        }
                        case 10: {
                            if (NLUTokenManager.curChar != ':') {
                                continue;
                            }
                            jjCheckNAddStates(3, 20);
                            continue;
                        }
                        case 28: {
                            if (NLUTokenManager.curChar != '(') {
                                continue;
                            }
                            jjmatchedKind = 53;
                            continue;
                        }
                        case 29: {
                            if (NLUTokenManager.curChar != '-') {
                                continue;
                            }
                            jjCheckNAdd(28);
                            continue;
                        }
                        case 31: {
                            if (NLUTokenManager.curChar != '<') {
                                continue;
                            }
                            jjmatchedKind = 53;
                            continue;
                        }
                        case 32: {
                            if (NLUTokenManager.curChar != '-') {
                                continue;
                            }
                            jjCheckNAdd(31);
                            continue;
                        }
                    }
                } while (i != jjnewStateCnt);
            }
            else if (NLUTokenManager.curChar < '\u0080') {
                final long n3 = 1L << (NLUTokenManager.curChar & '?');
                do {
                    switch (NLUTokenManager.jjstateSet[--i]) {
                        case 0: {
                            if ((0x7FFFFFE07FFFFFEL & n3) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 46) {
                                jjmatchedKind = 46;
                            }
                            jjCheckNAdd(2);
                            continue;
                        }
                        case 2: {
                            if ((0x7FFFFFE87FFFFFEL & n3) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 46) {
                                jjmatchedKind = 46;
                            }
                            jjCheckNAdd(2);
                            continue;
                        }
                        case 4: {
                            if ((0x7FFFFFE07FFFFFEL & n3) == 0x0L) {
                                continue;
                            }
                            if (jjmatchedKind > 52) {
                                jjmatchedKind = 52;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 4;
                            continue;
                        }
                        default: {
                            continue;
                        }
                        case 8: {
                            if (NLUTokenManager.curChar != 'D' || jjmatchedKind <= 53) {
                                continue;
                            }
                            jjmatchedKind = 53;
                            continue;
                        }
                        case 11: {
                            if (NLUTokenManager.curChar != 'N' || jjmatchedKind <= 50) {
                                continue;
                            }
                            jjmatchedKind = 50;
                            continue;
                        }
                        case 12: {
                            if (NLUTokenManager.curChar != 'n' || jjmatchedKind <= 50) {
                                continue;
                            }
                            jjmatchedKind = 50;
                            continue;
                        }
                        case 13: {
                            if (NLUTokenManager.curChar != 'V' || jjmatchedKind <= 50) {
                                continue;
                            }
                            jjmatchedKind = 50;
                            continue;
                        }
                        case 14: {
                            if (NLUTokenManager.curChar != 'v' || jjmatchedKind <= 50) {
                                continue;
                            }
                            jjmatchedKind = 50;
                            continue;
                        }
                        case 15: {
                            if (NLUTokenManager.curChar != 'J' || jjmatchedKind <= 50) {
                                continue;
                            }
                            jjmatchedKind = 50;
                            continue;
                        }
                        case 16: {
                            if (NLUTokenManager.curChar != 'D') {
                                continue;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 15;
                            continue;
                        }
                        case 17: {
                            if (NLUTokenManager.curChar != 'A') {
                                continue;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 16;
                            continue;
                        }
                        case 18: {
                            if (NLUTokenManager.curChar != 'j' || jjmatchedKind <= 50) {
                                continue;
                            }
                            jjmatchedKind = 50;
                            continue;
                        }
                        case 19: {
                            if (NLUTokenManager.curChar != 'd') {
                                continue;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 18;
                            continue;
                        }
                        case 20: {
                            if (NLUTokenManager.curChar != 'a') {
                                continue;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 19;
                            continue;
                        }
                        case 21: {
                            if (NLUTokenManager.curChar != 'D') {
                                continue;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 13;
                            continue;
                        }
                        case 22: {
                            if (NLUTokenManager.curChar != 'A') {
                                continue;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 21;
                            continue;
                        }
                        case 23: {
                            if (NLUTokenManager.curChar != 'd') {
                                continue;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 14;
                            continue;
                        }
                        case 24: {
                            if (NLUTokenManager.curChar != 'a') {
                                continue;
                            }
                            NLUTokenManager.jjstateSet[NLUTokenManager.jjnewStateCnt++] = 23;
                            continue;
                        }
                        case 25: {
                            if (NLUTokenManager.curChar != 'R' || jjmatchedKind <= 51) {
                                continue;
                            }
                            jjmatchedKind = 51;
                            continue;
                        }
                        case 26: {
                            if (NLUTokenManager.curChar != 'r' || jjmatchedKind <= 51) {
                                continue;
                            }
                            jjmatchedKind = 51;
                            continue;
                        }
                    }
                } while (i != jjnewStateCnt);
            }
            else {
                final int n4 = NLUTokenManager.curChar >> 8;
                final int n5 = (NLUTokenManager.curChar & '\u00ff') >> 6;
                final long n6 = 1L << (NLUTokenManager.curChar & '?');
                do {
                    final int n7 = NLUTokenManager.jjstateSet[--i];
                } while (i != jjnewStateCnt);
            }
            if (jjmatchedKind != Integer.MAX_VALUE) {
                NLUTokenManager.jjmatchedKind = jjmatchedKind;
                NLUTokenManager.jjmatchedPos = jjmatchedPos;
                jjmatchedKind = Integer.MAX_VALUE;
            }
            ++jjmatchedPos;
            if ((i = NLUTokenManager.jjnewStateCnt) == (jjnewStateCnt = 33 - (NLUTokenManager.jjnewStateCnt = jjnewStateCnt))) {
                break;
            }
            try {
                NLUTokenManager.curChar = JavaCharStream.readChar();
            }
            catch (IOException ex) {
                return jjmatchedPos;
            }
        }
        return jjmatchedPos;
    }
    
    private static final boolean jjCanMove_0(final int n, final int n2, final int n3, final long n4, final long n5) {
        switch (n) {
            case 0: {
                boolean b = false;
                if ((NLUTokenManager.jjbitVec2[n3] & n5) != 0x0L) {
                    b = true;
                }
                return b;
            }
            default: {
                return (NLUTokenManager.jjbitVec0[n2] & n4) != 0x0L;
            }
        }
    }
    
    public static void ReInit(final JavaCharStream input_stream) {
        NLUTokenManager.jjmatchedPos = (NLUTokenManager.jjnewStateCnt = 0);
        NLUTokenManager.curLexState = NLUTokenManager.defaultLexState;
        NLUTokenManager.input_stream = input_stream;
        ReInitRounds();
    }
    
    private static final void ReInitRounds() {
        NLUTokenManager.jjround = -2147483647;
        int n = 33;
        while (n-- > 0) {
            NLUTokenManager.jjrounds[n] = Integer.MIN_VALUE;
        }
    }
    
    public static void ReInit(final JavaCharStream javaCharStream, final int n) {
        ReInit(javaCharStream);
        SwitchTo(n);
    }
    
    public static void SwitchTo(final int curLexState) {
        if (curLexState >= 3 || curLexState < 0) {
            throw new TokenMgrError("Error: Ignoring invalid lexical state : " + curLexState + ". State unchanged.", 2);
        }
        NLUTokenManager.curLexState = curLexState;
    }
    
    protected static Token jjFillToken() {
        final Token token = Token.newToken(NLUTokenManager.jjmatchedKind);
        token.kind = NLUTokenManager.jjmatchedKind;
        final String s = NLUTokenManager.jjstrLiteralImages[NLUTokenManager.jjmatchedKind];
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
    Label_0561:
        while (true) {
            try {
                NLUTokenManager.curChar = JavaCharStream.BeginToken();
            }
            catch (IOException ex) {
                NLUTokenManager.jjmatchedKind = 0;
                final Token jjFillToken = jjFillToken();
                jjFillToken.specialToken = specialToken;
                return jjFillToken;
            }
            while (true) {
                switch (NLUTokenManager.curLexState) {
                    case 0: {
                        try {
                            JavaCharStream.backup(0);
                            while (NLUTokenManager.curChar <= ' ' && (0x100001600L & 1L << NLUTokenManager.curChar) != 0x0L) {
                                NLUTokenManager.curChar = JavaCharStream.BeginToken();
                            }
                        }
                        catch (IOException ex2) {
                            continue Label_0561;
                        }
                        NLUTokenManager.jjmatchedKind = Integer.MAX_VALUE;
                        NLUTokenManager.jjmatchedPos = 0;
                        n = jjMoveStringLiteralDfa0_0();
                        break;
                    }
                    case 1: {
                        try {
                            JavaCharStream.backup(0);
                            while (NLUTokenManager.curChar <= ' ' && (0x100001600L & 1L << NLUTokenManager.curChar) != 0x0L) {
                                NLUTokenManager.curChar = JavaCharStream.BeginToken();
                            }
                        }
                        catch (IOException ex3) {
                            continue Label_0561;
                        }
                        NLUTokenManager.jjmatchedKind = Integer.MAX_VALUE;
                        NLUTokenManager.jjmatchedPos = 0;
                        n = jjMoveStringLiteralDfa0_1();
                        break;
                    }
                    case 2: {
                        NLUTokenManager.jjmatchedKind = Integer.MAX_VALUE;
                        NLUTokenManager.jjmatchedPos = 0;
                        n = jjMoveStringLiteralDfa0_2();
                        if (NLUTokenManager.jjmatchedPos == 0 && NLUTokenManager.jjmatchedKind > 63) {
                            NLUTokenManager.jjmatchedKind = 63;
                            break;
                        }
                        break;
                    }
                }
                if (NLUTokenManager.jjmatchedKind == Integer.MAX_VALUE) {
                    break Label_0561;
                }
                if (NLUTokenManager.jjmatchedPos + 1 < n) {
                    JavaCharStream.backup(n - NLUTokenManager.jjmatchedPos - 1);
                }
                if ((NLUTokenManager.jjtoToken[NLUTokenManager.jjmatchedKind >> 6] & 1L << (NLUTokenManager.jjmatchedKind & 0x3F)) != 0x0L) {
                    final Token jjFillToken2 = jjFillToken();
                    jjFillToken2.specialToken = specialToken;
                    if (NLUTokenManager.jjnewLexState[NLUTokenManager.jjmatchedKind] != -1) {
                        NLUTokenManager.curLexState = NLUTokenManager.jjnewLexState[NLUTokenManager.jjmatchedKind];
                    }
                    return jjFillToken2;
                }
                if ((NLUTokenManager.jjtoSkip[NLUTokenManager.jjmatchedKind >> 6] & 1L << (NLUTokenManager.jjmatchedKind & 0x3F)) != 0x0L) {
                    if ((NLUTokenManager.jjtoSpecial[NLUTokenManager.jjmatchedKind >> 6] & 1L << (NLUTokenManager.jjmatchedKind & 0x3F)) != 0x0L) {
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
                    }
                    if (NLUTokenManager.jjnewLexState[NLUTokenManager.jjmatchedKind] != -1) {
                        NLUTokenManager.curLexState = NLUTokenManager.jjnewLexState[NLUTokenManager.jjmatchedKind];
                    }
                    break;
                }
                if (NLUTokenManager.jjnewLexState[NLUTokenManager.jjmatchedKind] != -1) {
                    NLUTokenManager.curLexState = NLUTokenManager.jjnewLexState[NLUTokenManager.jjmatchedKind];
                }
                n = 0;
                NLUTokenManager.jjmatchedKind = Integer.MAX_VALUE;
                try {
                    NLUTokenManager.curChar = JavaCharStream.readChar();
                    continue;
                }
                catch (IOException ex4) {}
                break Label_0561;
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
        catch (IOException ex5) {
            b = true;
            s = ((n <= 1) ? "" : JavaCharStream.GetImage());
            if (NLUTokenManager.curChar == '\n' || NLUTokenManager.curChar == '\r') {
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
        throw new TokenMgrError(b, NLUTokenManager.curLexState, endLine, endColumn, s, NLUTokenManager.curChar, 0);
    }
    
    public NLUTokenManager(final JavaCharStream input_stream) {
        if (NLUTokenManager.input_stream != null) {
            throw new TokenMgrError("ERROR: Second call to constructor of static lexer. You must use ReInit() to initialize the static variables.", 1);
        }
        NLUTokenManager.input_stream = input_stream;
    }
    
    public NLUTokenManager(final JavaCharStream javaCharStream, final int n) {
        this(javaCharStream);
        SwitchTo(n);
    }
    
    static {
        NLUTokenManager.debugStream = System.out;
        jjbitVec0 = new long[] { -2L, -1, -1, -1 };
        jjbitVec2 = new long[] { 0L, 0L, -1, -1 };
        jjnextStates = new int[] { 4, 5, 7, 11, 12, 13, 14, 17, 20, 22, 24, 25, 26, 6, 27, 29, 28, 30, 8, 31, 32, 6, 7, 9, 8 };
        jjstrLiteralImages = new String[] { "", null, null, null, null, null, null, "template", "defrule", "defmap", "deftype", "defbeat", "declare", "(", ")", "[", "]", "|", "%fromfile", "include", "or", "and", ";", ":", "&", null, "=>", "<-", "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%", null, null, "tand", "tor", "toc", "tnot", "(", ")", "[", "]", "<", ">", "-", "{", "}", "|", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null };
        lexStateNames = new String[] { "DEFAULT", "TEMPLATE", "MultiComment" };
        jjnewLexState = new int[] { -1, -1, -1, -1, -1, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2, 0, -1 };
        jjtoToken = new long[] { 17029236090994561L, 0L };
        jjtoSkip = new long[] { 9205357638345293950L, 0L };
        jjtoSpecial = new long[] { 1152921504606846976L, 0L };
        jjtoMore = new long[] { Long.MIN_VALUE, 0L };
        jjrounds = new int[33];
        jjstateSet = new int[66];
        NLUTokenManager.curLexState = 0;
        NLUTokenManager.defaultLexState = 0;
    }
}
