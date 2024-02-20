package facade.util;

import java.util.Random;
import dramaman.runtime.DramaManagerConstants;

public class CrisisCalculus implements SpriteID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, DAType, DramaManagerConstants, BeatConstants
{
    public static CrisisCalculus calculus;
    public static int firstPostGreetingBeatCtr;
    public static int firstT2BeatCtr;
    public static int incitingContentID;
    public static int incitingContentType;
    public static int incitingContentParam;
    public static int incitingContentChr;
    public static int gpta;
    public static int tpta;
    public static int gbp;
    public static int tbp;
    public static int mostBuggedChr;
    public static int focusStoryTopic;
    public static int focusMetaTopic;
    public static int dramaticQuestion;
    public static int dramaticQuestionWho;
    public static int overallConstructiveness;
    public static int initialAccuserChr;
    public static int initialAccusedChr;
    public static int secondAccuserChr;
    public static int secondAccusedChr;
    public static int accusation2ID;
    public static int accusation2PcType;
    public static int accusation2PcParam;
    public static int accusation3ID;
    public static int accusation3PcType;
    public static int accusation3PcParam;
    public static boolean bWantYesToBigQuestion;
    public static boolean bGotYesNoAnswerToBigQuestion;
    public static boolean bGotRightAnswerToBigQuestion;
    public static boolean bGotHelpfulAnswerToBigQuestion;
    public static int whoSelfRevelation;
    public static int whichSelfRevelation;
    public static boolean bFuriousOrUpsetAtEndOfCrisis;
    public static int numLeaveRoomCajolesPlayed;
    public static int tempInt;
    private static final Random randomGen;
    private static final /* synthetic */ boolean $noassert;
    
    public void CalculateTerms() {
        StringUtil.println("### CrisisCalculus.CalculateTerms()");
        final IntegerRef integerRef = new IntegerRef();
        final IntegerRef integerRef2 = new IntegerRef();
        final IntegerRef integerRef3 = new IntegerRef();
        final IntegerRef integerRef4 = new IntegerRef();
        final BooleanRef booleanRef = new BooleanRef();
        final BooleanRef booleanRef2 = new BooleanRef();
        final IntegerRef integerRef5 = new IntegerRef();
        final IntegerRef integerRef6 = new IntegerRef();
        final IntegerRef integerRef7 = new IntegerRef();
        final IntegerRef integerRef8 = new IntegerRef();
        final IntegerRef integerRef9 = new IntegerRef();
        final IntegerRef integerRef10 = new IntegerRef();
        final BooleanRef booleanRef3 = new BooleanRef();
        final int getNumContents = ProvocativeContentArchive.archive.GetNumContents();
        CrisisCalculus.gpta = 0;
        CrisisCalculus.tpta = 0;
        CrisisCalculus.gbp = 0;
        CrisisCalculus.tbp = 0;
        for (int i = 0; i < getNumContents; ++i) {
            ProvocativeContentArchive.archive.GetContentInfo(i, integerRef, integerRef2, integerRef3, integerRef4, booleanRef, booleanRef2, integerRef5, integerRef6, integerRef7, integerRef8, integerRef9, integerRef10, booleanRef3);
            if (integerRef3.i == 0) {
                CrisisCalculus.gpta += integerRef6.i;
                CrisisCalculus.gbp += integerRef5.i;
            }
            if (integerRef3.i == 1) {
                CrisisCalculus.tpta += integerRef6.i;
                CrisisCalculus.tbp += integerRef5.i;
            }
        }
        final int n = CrisisCalculus.tpta - CrisisCalculus.gpta + (CrisisCalculus.gbp - CrisisCalculus.tbp);
        if (n > 0) {
            CrisisCalculus.mostBuggedChr = 0;
        }
        else if (n < 0) {
            CrisisCalculus.mostBuggedChr = 1;
        }
        else if (CrisisCalculus.randomGen.nextInt(2) == 0) {
            CrisisCalculus.mostBuggedChr = 0;
        }
        else {
            CrisisCalculus.mostBuggedChr = 1;
        }
        StringUtil.println("  gpta = " + CrisisCalculus.gpta);
        StringUtil.println("  tpta = " + CrisisCalculus.tpta);
        StringUtil.println("  gbp = " + CrisisCalculus.gbp);
        StringUtil.println("  tbp = " + CrisisCalculus.tbp);
        StringUtil.println("  mostBuggedChr = " + CrisisCalculus.mostBuggedChr);
    }
    
    public void DetermineFocusStoryTopicAndMetaTopic() {
        StringUtil.println("### CrisisCalculus.DetermineFocusStoryTopicAndMetaTopic()");
        final IntegerRef integerRef = new IntegerRef();
        final IntegerRef integerRef2 = new IntegerRef();
        final IntegerRef integerRef3 = new IntegerRef();
        final IntegerRef integerRef4 = new IntegerRef();
        final IntegerRef integerRef5 = new IntegerRef();
        final int getNumContents = IntermediateContentArchive.archive.GetNumContents();
        boolean b = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        boolean b5 = false;
        boolean b6 = false;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < getNumContents; ++i) {
            IntermediateContentArchive.archive.GetContentInfo(i, integerRef, integerRef2, integerRef3, integerRef4, integerRef5);
            if (integerRef.i == 2) {
                if (integerRef3.i == 60) {
                    if (integerRef4.i == 1) {
                        b = true;
                    }
                    if (integerRef4.i == 2) {
                        b2 = true;
                    }
                }
                if (integerRef3.i == 59) {
                    if (integerRef4.i == 1) {
                        b3 = true;
                    }
                    if (integerRef4.i == 2) {
                        b4 = true;
                    }
                }
                if (integerRef3.i == 61) {
                    if (integerRef4.i == 1) {
                        b5 = true;
                    }
                    if (integerRef4.i == 2) {
                        b6 = true;
                    }
                }
            }
        }
        if (b && b2) {
            ++n;
        }
        if (b3 && b4) {
            ++n;
        }
        if (b5 && b6) {
            ++n;
        }
        if (n == 1) {
            if (b && b2) {
                CrisisCalculus.focusStoryTopic = 60;
            }
            if (b3 && b4) {
                CrisisCalculus.focusStoryTopic = 59;
            }
            if (b5 && b6) {
                CrisisCalculus.focusStoryTopic = 61;
            }
        }
        if (b3) {
            ++n2;
        }
        if (b4) {
            ++n2;
        }
        if (b) {
            ++n2;
        }
        if (b2) {
            ++n2;
        }
        if (b3) {
            ++n3;
        }
        if (b4) {
            ++n3;
        }
        if (b5) {
            ++n3;
        }
        if (b6) {
            ++n3;
        }
        if (n2 > n3) {
            CrisisCalculus.focusMetaTopic = 0;
        }
        else if (n2 < n3) {
            CrisisCalculus.focusMetaTopic = 1;
        }
        else if (CrisisCalculus.randomGen.nextInt(2) == 0) {
            CrisisCalculus.focusMetaTopic = 0;
        }
        else {
            CrisisCalculus.focusMetaTopic = 1;
        }
        StringUtil.println("  focusStoryTopic = " + CrisisCalculus.focusStoryTopic);
        StringUtil.println("  focusMetaTopic = " + CrisisCalculus.focusMetaTopic);
    }
    
    public void DetermineInitialAccuserChr() {
        StringUtil.println("### CrisisCalculus.DetermineInitialAccuserChr()");
        if (!CrisisCalculus.$noassert && CrisisCalculus.mostBuggedChr == -1) {
            throw new AssertionError();
        }
        if (CrisisCalculus.gpta < CrisisCalculus.tpta) {
            CrisisCalculus.initialAccuserChr = 0;
        }
        else if (CrisisCalculus.tpta < CrisisCalculus.gpta) {
            CrisisCalculus.initialAccuserChr = 1;
        }
        else {
            CrisisCalculus.initialAccuserChr = CrisisCalculus.mostBuggedChr;
        }
        if (CrisisCalculus.initialAccuserChr == 0) {
            CrisisCalculus.initialAccusedChr = 1;
        }
        else {
            CrisisCalculus.initialAccusedChr = 0;
        }
        StringUtil.println("  initialAccuserChr = " + CrisisCalculus.initialAccuserChr);
    }
    
    public int ChooseProvocativeContent(final int n, final boolean b, final boolean b2, final int n2, final int n3) {
        StringUtil.println("### CrisisCalculus.ChooseProvocativeContent() chr " + n + " bWantPlayerDirect " + b + " bWantAccusable " + b2 + " matchBackstoryCategory " + n2 + " matchStoryTopic " + n3);
        final IntegerRef integerRef = new IntegerRef();
        final IntegerRef integerRef2 = new IntegerRef();
        final IntegerRef integerRef3 = new IntegerRef();
        final IntegerRef integerRef4 = new IntegerRef();
        final BooleanRef booleanRef = new BooleanRef();
        final BooleanRef booleanRef2 = new BooleanRef();
        final IntegerRef integerRef5 = new IntegerRef();
        final IntegerRef integerRef6 = new IntegerRef();
        final IntegerRef integerRef7 = new IntegerRef();
        final IntegerRef integerRef8 = new IntegerRef();
        final IntegerRef integerRef9 = new IntegerRef();
        final IntegerRef integerRef10 = new IntegerRef();
        final BooleanRef booleanRef3 = new BooleanRef();
        final int getNumContents = ProvocativeContentArchive.archive.GetNumContents();
        int n4 = -1;
        int i = 999;
        int j = -1;
        int k = -1;
        int n5 = 0;
        for (int l = 0; l < getNumContents; ++l) {
            ProvocativeContentArchive.archive.GetContentInfo(l, integerRef, integerRef2, integerRef3, integerRef4, booleanRef, booleanRef2, integerRef5, integerRef6, integerRef7, integerRef8, integerRef9, integerRef10, booleanRef3);
            if (!booleanRef3.b && (integerRef3.i == n || integerRef3.i == -1) && integerRef4.i < i && (booleanRef.b || !b) && (booleanRef2.b || !b2) && integerRef.i != 7 && integerRef2.i != 61 && integerRef2.i != 62 && (n2 == integerRef8.i || n2 == integerRef9.i || n2 == integerRef10.i || n2 == -1) && (this.DoesBCMatchST(integerRef8.i, n3) || this.DoesBCMatchST(integerRef9.i, n3) || this.DoesBCMatchST(integerRef10.i, n3) || n3 == -1)) {
                i = integerRef4.i;
                ++n5;
            }
        }
        if (n5 > 0) {
            final int nextInt = CrisisCalculus.randomGen.nextInt(n5);
            int n6 = 0;
            int m = 999;
            for (int n7 = 0; n7 < getNumContents && n4 == -1; ++n7) {
                ProvocativeContentArchive.archive.GetContentInfo(n7, integerRef, integerRef2, integerRef3, integerRef4, booleanRef, booleanRef2, integerRef5, integerRef6, integerRef7, integerRef8, integerRef9, integerRef10, booleanRef3);
                if (!booleanRef3.b && (integerRef3.i == n || integerRef3.i == -1) && integerRef4.i < m && (booleanRef.b || !b) && (booleanRef2.b || !b2) && integerRef.i != 7 && integerRef2.i != 61 && integerRef2.i != 62 && (n2 == integerRef8.i || n2 == integerRef9.i || n2 == integerRef10.i || n2 == -1) && (this.DoesBCMatchST(integerRef8.i, n3) || this.DoesBCMatchST(integerRef9.i, n3) || this.DoesBCMatchST(integerRef10.i, n3) || n3 == -1)) {
                    m = integerRef4.i;
                    if (n6 == nextInt) {
                        n4 = n7;
                        j = integerRef.i;
                        k = integerRef2.i;
                    }
                    ++n6;
                }
            }
            if (!CrisisCalculus.$noassert && n4 == -1) {
                throw new AssertionError();
            }
            ProvocativeContentArchive.archive.SetReactedToInCrisis(n4, true);
            StringUtil.println("ChooseProvocativeContent chose id " + n4 + " type " + j + " param " + k);
        }
        else {
            StringUtil.println("ChooseProvocativeContent: no match!");
        }
        return n4;
    }
    
    public boolean DoesBCMatchST(final int n, final int n2) {
        switch (n) {
            case 0:
            case 2:
            case 4: {
                if (n2 == 59) {
                    return true;
                }
                break;
            }
            case 3:
            case 5:
            case 6: {
                if (n2 == 60) {
                    return true;
                }
                break;
            }
            case 1:
            case 7:
            case 8:
            case 9: {
                if (n2 == 61) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
    
    public void ChooseDramaticQuestion(final boolean b) {
        StringUtil.println("### CrisisCalculus.ChooseDramaticQuestion()");
        CrisisCalculus.dramaticQuestion = this.GetMostAddressedBackstoryCategory(b);
        StringUtil.println("  dramaticQuestion = " + CrisisCalculus.dramaticQuestion);
        if (CrisisCalculus.randomGen.nextInt(3) == 0) {
            StringUtil.println("    but going to mix it up!");
            if (CrisisCalculus.dramaticQuestion == 0 || CrisisCalculus.dramaticQuestion == 2 || CrisisCalculus.dramaticQuestion == 4) {
                final int nextInt = CrisisCalculus.randomGen.nextInt(3);
                if (nextInt == 0) {
                    CrisisCalculus.dramaticQuestion = 0;
                }
                else if (nextInt == 1) {
                    CrisisCalculus.dramaticQuestion = 2;
                }
                else {
                    CrisisCalculus.dramaticQuestion = 4;
                }
            }
            if (CrisisCalculus.dramaticQuestion == 3 || CrisisCalculus.dramaticQuestion == 5 || CrisisCalculus.dramaticQuestion == 6) {
                final int nextInt2 = CrisisCalculus.randomGen.nextInt(3);
                if (nextInt2 == 0) {
                    CrisisCalculus.dramaticQuestion = 3;
                }
                else if (nextInt2 == 1) {
                    CrisisCalculus.dramaticQuestion = 5;
                }
                else {
                    CrisisCalculus.dramaticQuestion = 6;
                }
            }
            if (CrisisCalculus.dramaticQuestion == 1 || CrisisCalculus.dramaticQuestion == 4 || CrisisCalculus.dramaticQuestion == 9) {
                final int nextInt3 = CrisisCalculus.randomGen.nextInt(5);
                if (nextInt3 == 0) {
                    CrisisCalculus.dramaticQuestion = 1;
                }
                else if (nextInt3 == 1) {
                    CrisisCalculus.dramaticQuestion = 4;
                }
                else if (nextInt3 == 2) {
                    CrisisCalculus.dramaticQuestion = 7;
                }
                else if (nextInt3 == 3) {
                    CrisisCalculus.dramaticQuestion = 8;
                }
                else {
                    CrisisCalculus.dramaticQuestion = 9;
                }
            }
            StringUtil.println("  new dramaticQuestion = " + CrisisCalculus.dramaticQuestion);
        }
    }
    
    public int GetMostAddressedBackstoryCategory(final boolean b) {
        StringUtil.println("### CrisisCalculus.GetMostAddressedBackstoryCategory()");
        final IntegerRef integerRef = new IntegerRef();
        final IntegerRef integerRef2 = new IntegerRef();
        final IntegerRef integerRef3 = new IntegerRef();
        final IntegerRef integerRef4 = new IntegerRef();
        final BooleanRef booleanRef = new BooleanRef();
        final BooleanRef booleanRef2 = new BooleanRef();
        final IntegerRef integerRef5 = new IntegerRef();
        final IntegerRef integerRef6 = new IntegerRef();
        final IntegerRef integerRef7 = new IntegerRef();
        final IntegerRef integerRef8 = new IntegerRef();
        final IntegerRef integerRef9 = new IntegerRef();
        final IntegerRef integerRef10 = new IntegerRef();
        final BooleanRef booleanRef3 = new BooleanRef();
        final int getNumContents = ProvocativeContentArchive.archive.GetNumContents();
        final int[] array = new int[10];
        int n = 0;
        int n2 = -1;
        for (int i = 0; i < 10; ++i) {
            array[i] = 0;
        }
        for (int j = 0; j < getNumContents; ++j) {
            ProvocativeContentArchive.archive.GetContentInfo(j, integerRef, integerRef2, integerRef3, integerRef4, booleanRef, booleanRef2, integerRef5, integerRef6, integerRef7, integerRef8, integerRef9, integerRef10, booleanRef3);
            if (!b || booleanRef2.b) {
                if (integerRef8.i >= 0 && integerRef8.i < 10) {
                    final int[] array2 = array;
                    final int k = integerRef8.i;
                    ++array2[k];
                    if (array[integerRef8.i] > n || (array[integerRef8.i] == n && CrisisCalculus.randomGen.nextInt(2) == 0)) {
                        n = array[integerRef8.i];
                        n2 = integerRef8.i;
                    }
                }
                if (integerRef9.i >= 0 && integerRef9.i < 10) {
                    final int[] array3 = array;
                    final int l = integerRef9.i;
                    ++array3[l];
                    if (array[integerRef9.i] > n || (array[integerRef9.i] == n && CrisisCalculus.randomGen.nextInt(2) == 0)) {
                        n = array[integerRef9.i];
                        n2 = integerRef9.i;
                    }
                }
                if (integerRef10.i >= 0 && integerRef10.i < 10) {
                    final int[] array4 = array;
                    final int m = integerRef10.i;
                    ++array4[m];
                    if (array[integerRef10.i] > n || (array[integerRef10.i] == n && CrisisCalculus.randomGen.nextInt(2) == 0)) {
                        n = array[integerRef10.i];
                        n2 = integerRef10.i;
                    }
                }
            }
        }
        if (n2 == -1) {
            StringUtil.println("### WARNING: GetMostAddressedBackstoryCategory got no results, randomly choosing");
            n2 = CrisisCalculus.randomGen.nextInt(10);
        }
        return n2;
    }
    
    public void CalculateConstructiveness() {
        StringUtil.println("### CrisisCalculus.CalculateConstructiveness()");
        final IntegerRef integerRef = new IntegerRef();
        final IntegerRef integerRef2 = new IntegerRef();
        final IntegerRef integerRef3 = new IntegerRef();
        final IntegerRef integerRef4 = new IntegerRef();
        final BooleanRef booleanRef = new BooleanRef();
        final BooleanRef booleanRef2 = new BooleanRef();
        final IntegerRef integerRef5 = new IntegerRef();
        final IntegerRef integerRef6 = new IntegerRef();
        final IntegerRef integerRef7 = new IntegerRef();
        final IntegerRef integerRef8 = new IntegerRef();
        final IntegerRef integerRef9 = new IntegerRef();
        final IntegerRef integerRef10 = new IntegerRef();
        final BooleanRef booleanRef3 = new BooleanRef();
        final int getNumContents = ProvocativeContentArchive.archive.GetNumContents();
        CrisisCalculus.overallConstructiveness = 0;
        for (int i = 0; i < getNumContents; ++i) {
            ProvocativeContentArchive.archive.GetContentInfo(i, integerRef, integerRef2, integerRef3, integerRef4, booleanRef, booleanRef2, integerRef5, integerRef6, integerRef7, integerRef8, integerRef9, integerRef10, booleanRef3);
            CrisisCalculus.overallConstructiveness += integerRef7.i;
        }
        StringUtil.println("  overallConstructiveness = " + CrisisCalculus.overallConstructiveness);
    }
    
    public void RecognizePatternsAndAddProvocativeContent() {
        StringUtil.println("### CrisisCalculus.RecognizePatternsAndAddProvocativeContent()");
        final IntegerRef integerRef = new IntegerRef();
        final IntegerRef integerRef2 = new IntegerRef();
        final IntegerRef integerRef3 = new IntegerRef();
        final IntegerRef integerRef4 = new IntegerRef();
        final IntegerRef integerRef5 = new IntegerRef();
        final IntegerRef integerRef6 = new IntegerRef();
        final IntegerRef integerRef7 = new IntegerRef();
        final IntegerRef integerRef8 = new IntegerRef();
        final BooleanRef booleanRef = new BooleanRef();
        final int getNumContents = IntermediateContentArchive.archive.GetNumContents();
        final int getNumContents2 = ProvocativeContentArchive.archive.GetNumContents();
        boolean b = false;
        for (int n = 0; n <= 1 && !b; ++n) {
            boolean b2 = false;
            for (int n2 = 0; n2 < getNumContents && !b2; ++n2) {
                IntermediateContentArchive.archive.GetContentInfo(n2, integerRef, integerRef2, integerRef3, integerRef4, integerRef5);
                if (integerRef.i == 1) {
                    if (n == 0 && integerRef3.i < 0) {
                        b2 = true;
                    }
                    if (n == 1 && integerRef3.i > 0) {
                        b2 = true;
                    }
                    if (integerRef2.i >= CrisisCalculus.firstPostGreetingBeatCtr && integerRef3.i == 0) {
                        b2 = true;
                    }
                }
            }
            if (!b2) {
                ProvocativeContentArchive.archive.AddContent(5, 60, n, -1, -1, -1);
                b = true;
            }
        }
        boolean b3 = false;
        for (int n3 = 0; n3 <= 1 && !b3; ++n3) {
            boolean b4 = false;
            for (int n4 = 0; n4 < getNumContents && !b4; ++n4) {
                IntermediateContentArchive.archive.GetContentInfo(n4, integerRef, integerRef2, integerRef3, integerRef4, integerRef5);
                if (integerRef.i == 1) {
                    if (n3 == 0 && integerRef3.i < 0) {
                        b4 = true;
                    }
                    if (n3 == 1 && integerRef3.i > 0) {
                        b4 = true;
                    }
                    if (integerRef2.i >= CrisisCalculus.firstT2BeatCtr && integerRef3.i == 0) {
                        b4 = true;
                    }
                }
            }
            if (!b4) {
                ProvocativeContentArchive.archive.AddContent(5, 61, n3, -1, -1, -1);
                b3 = true;
            }
        }
        boolean b5 = false;
        for (int n5 = 0; n5 <= 1 && !b5; ++n5) {
            boolean b6 = false;
            int n6 = 0;
            for (int n7 = 0; n7 < getNumContents && !b6; ++n7) {
                IntermediateContentArchive.archive.GetContentInfo(n7, integerRef, integerRef2, integerRef3, integerRef4, integerRef5);
                if (integerRef.i == 1) {
                    if (n6 == 0) {
                        if (n5 == 0 && integerRef3.i < 0) {
                            n6 = 1;
                        }
                        if (n5 == 1 && integerRef3.i > 0) {
                            n6 = 1;
                        }
                    }
                    if (n6 == 1) {
                        if (n5 == 0 && integerRef3.i > 0) {
                            n6 = 2;
                        }
                        if (n5 == 1 && integerRef3.i < 0) {
                            n6 = 2;
                        }
                    }
                    if (n6 == 2) {
                        if (n5 == 0 && integerRef3.i >= 0) {
                            b6 = true;
                        }
                        if (n5 == 1 && integerRef3.i <= 0) {
                            b6 = true;
                        }
                    }
                }
            }
            if (n6 == 2 && !b6) {
                ProvocativeContentArchive.archive.AddContent(5, 62, n5, -1, -1, -1);
                b5 = true;
            }
        }
        for (int i = 0; i <= 1; ++i) {
            int n8 = 0;
            int n9 = 0;
            int n10 = 0;
            int n11 = 0;
            for (int j = 0; j < getNumContents; ++j) {
                IntermediateContentArchive.archive.GetContentInfo(j, integerRef, integerRef2, integerRef3, integerRef4, integerRef5);
                if (integerRef.i == 0) {
                    if (integerRef2.i == 20 && integerRef5.i != i) {
                        ++n8;
                    }
                    if (integerRef2.i == 21 && integerRef5.i == i) {
                        ++n9;
                    }
                    if (integerRef2.i == 22 && integerRef5.i != i) {
                        ++n10;
                    }
                    if (integerRef2.i == 23 && integerRef5.i != i) {
                        ++n11;
                    }
                }
            }
            for (int k = 0; k < getNumContents2; ++k) {
                ProvocativeContentArchive.archive.GetContentInfo(k, integerRef, integerRef2, integerRef5, integerRef6, integerRef7, integerRef8, booleanRef);
                if (integerRef.i == 1) {
                    if (integerRef2.i == 20 && integerRef5.i != i) {
                        n8 = 0;
                    }
                    if (integerRef2.i == 21 && integerRef5.i == i) {
                        n9 = 0;
                    }
                    if (integerRef2.i == 22 && integerRef5.i != i) {
                        n10 = 0;
                        n11 = 0;
                    }
                    if (integerRef2.i == 23 && integerRef5.i != i) {
                        n10 = 0;
                        n11 = 0;
                    }
                }
            }
            if (n8 > 0) {
                StringUtil.println("ActedSomewhat praise chr " + i);
                ProvocativeContentArchive.archive.AddContent(2, 20, i, -1, -1, -1);
            }
            if (n9 > 0) {
                StringUtil.println("ActedSomewhat criticize chr " + i);
                ProvocativeContentArchive.archive.AddContent(2, 21, i, -1, -1, -1);
            }
            if (n10 > 0) {
                StringUtil.println("ActedSomewhat flirt chr " + i);
                ProvocativeContentArchive.archive.AddContent(2, 22, i, -1, -1, -1);
            }
            if (n11 > 0) {
                StringUtil.println("ActedSomewhat kiss chr " + i);
                ProvocativeContentArchive.archive.AddContent(2, 23, i, -1, -1, -1);
            }
        }
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        for (int l = 0; l < getNumContents; ++l) {
            IntermediateContentArchive.archive.GetContentInfo(l, integerRef, integerRef2, integerRef3, integerRef4, integerRef5);
            if (integerRef.i == 0) {
                if (integerRef2.i == 27) {
                    ++n12;
                }
                if (integerRef2.i == 28) {
                    ++n13;
                }
                if (integerRef2.i == 29) {
                    ++n14;
                }
                if (integerRef2.i == 30) {
                    ++n15;
                }
            }
        }
        if (n13 >= 4) {
            StringUtil.println("ActedOverly negative");
            ProvocativeContentArchive.archive.AddContent(1, 28, -1, -1, -1, -1);
            n12 = 0;
        }
        if (n12 >= 4) {
            StringUtil.println("ActedOverly positive");
            ProvocativeContentArchive.archive.AddContent(1, 27, -1, -1, -1, -1);
        }
        if (n14 >= 6) {
            StringUtil.println("ActedOverly quiet");
            ProvocativeContentArchive.archive.AddContent(1, 29, -1, -1, -1, -1);
        }
        if (n15 >= 4) {
            StringUtil.println("ActedOverly uncooperative");
            ProvocativeContentArchive.archive.AddContent(1, 30, -1, -1, -1, -1);
        }
    }
    
    public void AssignValuesToProvocativeContent() {
        StringUtil.println("### CrisisCalculus.AssignValuesToProvocativeContent()");
        final IntegerRef integerRef = new IntegerRef();
        final IntegerRef integerRef2 = new IntegerRef();
        final IntegerRef integerRef3 = new IntegerRef();
        final IntegerRef integerRef4 = new IntegerRef();
        final IntegerRef integerRef5 = new IntegerRef();
        final IntegerRef integerRef6 = new IntegerRef();
        final BooleanRef booleanRef = new BooleanRef();
        for (int getNumContents = ProvocativeContentArchive.archive.GetNumContents(), i = 0; i < getNumContents; ++i) {
            ProvocativeContentArchive.archive.GetContentInfo(i, integerRef, integerRef2, integerRef3, integerRef4, integerRef5, integerRef6, booleanRef);
            int n = -1;
            boolean b = false;
            boolean b2 = false;
            int n2 = -1;
            int n3 = -1;
            int n4 = -1;
            boolean b3 = false;
            switch (integerRef.i) {
                case 0: {
                    switch (integerRef2.i) {
                        case 4:
                        case 10: {
                            n = 1;
                            b = true;
                            b2 = true;
                            n2 = 3;
                            n3 = -3;
                            n4 = 2;
                            break;
                        }
                        case 1:
                        case 3:
                        case 7:
                        case 9:
                        case 11:
                        case 12:
                        case 13: {
                            n = 2;
                            b = true;
                            b2 = true;
                            n2 = 2;
                            n3 = -2;
                            n4 = 2;
                            break;
                        }
                        case 0:
                        case 2:
                        case 5:
                        case 8: {
                            n = 3;
                            b = true;
                            b2 = true;
                            n2 = 2;
                            n3 = -2;
                            n4 = 2;
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (integerRef2.i) {
                        case 22:
                        case 23:
                        case 26: {
                            n = 1;
                            b = true;
                            b2 = true;
                            n2 = 3;
                            n3 = -3;
                            n4 = -2;
                            break;
                        }
                        case 21: {
                            n = 2;
                            b = true;
                            b2 = true;
                            n2 = 2;
                            n3 = -2;
                            n4 = -1;
                            break;
                        }
                        case 31: {
                            n = 3;
                            b = true;
                            b2 = true;
                            n2 = 2;
                            n3 = 0;
                            n4 = -1;
                            break;
                        }
                        case 20:
                        case 24:
                        case 25: {
                            n = 5;
                            b = true;
                            b2 = false;
                            n2 = 1;
                            n3 = -1;
                            n4 = -1;
                            break;
                        }
                        case 27:
                        case 28:
                        case 29:
                        case 30: {
                            n = 6;
                            b = true;
                            b2 = false;
                            n2 = 0;
                            n3 = 0;
                            n4 = 0;
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (integerRef2.i) {
                        case 22:
                        case 23: {
                            n = 4;
                            b = true;
                            b2 = false;
                            n2 = 2;
                            n3 = -2;
                            n4 = -1;
                            break;
                        }
                        case 20:
                        case 21: {
                            b3 = true;
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    n = 3;
                    b = true;
                    b2 = true;
                    n2 = 2;
                    n3 = -2;
                    n4 = 2;
                    break;
                }
                case 4: {
                    n = 5;
                    b = true;
                    b2 = false;
                    n2 = 1;
                    n3 = 0;
                    n4 = 1;
                    break;
                }
                case 5: {
                    switch (integerRef2.i) {
                        case 60: {
                            n = 3;
                            b = true;
                            b2 = true;
                            n2 = 2;
                            n3 = -3;
                            n4 = -1;
                            break;
                        }
                        case 61:
                        case 62: {
                            n = 5;
                            b = true;
                            b2 = false;
                            n2 = 1;
                            n3 = -1;
                            n4 = 0;
                            break;
                        }
                    }
                    break;
                }
                case 6: {
                    n = 3;
                    b = false;
                    b2 = true;
                    n2 = 2;
                    n3 = 0;
                    n4 = 0;
                    break;
                }
                case 7: {
                    if (integerRef3.i != -1) {
                        n = 5;
                        b = false;
                        b2 = false;
                        n2 = 1;
                        n3 = 0;
                        n4 = 0;
                    }
                    else {
                        n = 6;
                        b = false;
                        b2 = false;
                        n2 = 0;
                        n3 = 0;
                        n4 = 0;
                    }
                    break;
                }
                default: {
                    StringUtil.println("### Unknown type in AssignValuesToProvocativeContent");
                    if (!CrisisCalculus.$noassert) {
                        throw new AssertionError();
                    }
                    break;
                }
            }
            if (!b3) {
                if (n == -1 && !b && !b2 && n2 == -1 && n3 == -1 && n4 == -1) {
                    StringUtil.println("### Bug in AssignValuesToProvocativeContent type " + integerRef.i + " param " + integerRef2.i);
                    if (!CrisisCalculus.$noassert) {
                        throw new AssertionError();
                    }
                }
                ProvocativeContentArchive.archive.SetContentInfo(i, integerRef.i, integerRef2.i, integerRef3.i, n, b, b2, n2, n3, n4, integerRef4.i, integerRef5.i, integerRef6.i, booleanRef.b);
                if (b2) {
                    StringUtil.println("Provocative content type " + integerRef.i + " param " + integerRef2.i + " is accusable");
                }
            }
        }
    }
    
    public void CalculateSelfRevelation(final int whoSelfRevelation) {
        final int n = 3;
        StringUtil.println("### CrisisCalculus.CalculateSelfRevelation()");
        CrisisCalculus.whoSelfRevelation = whoSelfRevelation;
        if (CrisisCalculus.overallConstructiveness <= 0) {
            if ((whoSelfRevelation == 0 && CrisisCalculus.gbp >= n) || (whoSelfRevelation == 1 && CrisisCalculus.tbp >= n)) {
                CrisisCalculus.whichSelfRevelation = 0;
                CrisisCalculus.bFuriousOrUpsetAtEndOfCrisis = true;
            }
            else {
                CrisisCalculus.whichSelfRevelation = 1;
                CrisisCalculus.bFuriousOrUpsetAtEndOfCrisis = false;
            }
        }
        else {
            CrisisCalculus.whichSelfRevelation = 2;
            CrisisCalculus.bFuriousOrUpsetAtEndOfCrisis = false;
        }
    }
    
    public CrisisCalculus() {
        CrisisCalculus.calculus = this;
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.util.CrisisCalculus;").getComponentType().desiredAssertionStatus() ^ true);
        CrisisCalculus.firstPostGreetingBeatCtr = -1;
        CrisisCalculus.firstT2BeatCtr = -1;
        CrisisCalculus.incitingContentID = -1;
        CrisisCalculus.incitingContentType = -1;
        CrisisCalculus.incitingContentParam = -1;
        CrisisCalculus.incitingContentChr = -1;
        CrisisCalculus.gpta = 0;
        CrisisCalculus.tpta = 0;
        CrisisCalculus.gbp = 0;
        CrisisCalculus.tbp = 0;
        CrisisCalculus.mostBuggedChr = -1;
        CrisisCalculus.focusStoryTopic = -1;
        CrisisCalculus.focusMetaTopic = -1;
        CrisisCalculus.dramaticQuestion = -1;
        CrisisCalculus.dramaticQuestionWho = -1;
        CrisisCalculus.overallConstructiveness = 0;
        CrisisCalculus.initialAccuserChr = -1;
        CrisisCalculus.initialAccusedChr = -1;
        CrisisCalculus.secondAccuserChr = -1;
        CrisisCalculus.secondAccusedChr = -1;
        CrisisCalculus.accusation2ID = -1;
        CrisisCalculus.accusation2PcType = -1;
        CrisisCalculus.accusation2PcParam = -1;
        CrisisCalculus.accusation3ID = -1;
        CrisisCalculus.accusation3PcType = -1;
        CrisisCalculus.accusation3PcParam = -1;
        CrisisCalculus.bWantYesToBigQuestion = false;
        CrisisCalculus.bGotYesNoAnswerToBigQuestion = false;
        CrisisCalculus.bGotRightAnswerToBigQuestion = false;
        CrisisCalculus.bGotHelpfulAnswerToBigQuestion = false;
        CrisisCalculus.whoSelfRevelation = -1;
        CrisisCalculus.whichSelfRevelation = -1;
        CrisisCalculus.bFuriousOrUpsetAtEndOfCrisis = false;
        CrisisCalculus.numLeaveRoomCajolesPlayed = 0;
        CrisisCalculus.tempInt = 0;
        randomGen = new Random();
    }
}
