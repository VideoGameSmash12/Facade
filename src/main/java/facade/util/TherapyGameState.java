package facade.util;

import java.util.LinkedList;
import java.util.Random;

public class TherapyGameState implements TherapyGameConstants, DAType, SpriteID
{
    public static TherapyGameState state;
    public static int maxNumMixinsTimeout;
    public static int minNumMixinsTimeout;
    public static int noScoreStretchEarlyEnd;
    public static int calculusScoreThreshold;
    public static int initialAccuser;
    public static int currentMixinID;
    public static int currentMixinType;
    public static int prevMixinType;
    public static int currentMixinDAType;
    public static boolean bMixinCausedByPlayer;
    public static int currentStoryTopic;
    public static int currentCharFocus;
    public static int previousStoryTopic;
    public static int previousCharFocus;
    public static boolean bVeryBeginningOfNewMixin;
    public static long currentMixinTestBeganMillis;
    public static boolean bSignaledNewCharFocus;
    public static boolean bSignaledNewMixinScoreIncrease;
    public static int signalNewCharFocusWho;
    public static boolean bChangedCharFocus;
    public static int newMixinScoreIncreaseWho;
    public static int numSignalsPlayed;
    public static int numNewMixinsSinceSwitch;
    public static int previousPlayerStandPositionCharFocus;
    public static int currentMood;
    public static int currentMoodCause;
    public static int currentPastPresent;
    public static int numMixinsPlayed;
    public static int numTestMixinsPlayed;
    public static int numCajolesPlayed;
    public static int numLeaveRoomCajolesPlayed;
    public static int cajoleCharFocus;
    public static int cajolePrevCharFocus;
    public static int cajoleSpeaker;
    public static boolean bCajoleToChangePosition;
    public static int strongMoodDialogStage;
    public static int currentPostAskPlayer;
    public static int lastTimeDidAskPlayer;
    public static int numTimesScoreChanged;
    public static int lastTimeScoreChanged;
    public static int currentStagingID;
    public static float curGraceX;
    public static float curGraceZ;
    public static float curGraceRot;
    public static float curTripX;
    public static float curTripZ;
    public static float curTripRot;
    public static int calculusScore_AA_G;
    public static int calculusScore_AA_T;
    public static int calculusScore_AA_R;
    public static int calculusScore_F_G;
    public static int calculusScore_F_T;
    public static int calculusScore_F_R;
    public static int calculusScore_RM_G;
    public static int calculusScore_RM_T;
    public static int calculusScore_RM_R;
    public static int calculusScoreWhenCtr_AA_G;
    public static int calculusScoreWhenCtr_AA_T;
    public static int calculusScoreWhenCtr_AA_R;
    public static int calculusScoreWhenCtr_F_G;
    public static int calculusScoreWhenCtr_F_T;
    public static int calculusScoreWhenCtr_F_R;
    public static int calculusScoreWhenCtr_RM_G;
    public static int calculusScoreWhenCtr_RM_T;
    public static int calculusScoreWhenCtr_RM_R;
    public static boolean bDidRevelationOutburst_AA_G;
    public static boolean bDidRevelationOutburst_AA_T;
    public static boolean bDidRevelationOutburst_AA_R;
    public static boolean bDidRevelationOutburst_F_G;
    public static boolean bDidRevelationOutburst_F_T;
    public static boolean bDidRevelationOutburst_F_R;
    public static boolean bDidRevelationOutburst_RM_G;
    public static boolean bDidRevelationOutburst_RM_T;
    public static boolean bDidRevelationOutburst_RM_R;
    public static long lastAccusationMillis;
    public static long timeTherapyGameBegan;
    public static long lastLeftRoomCajoleMillis;
    public static boolean bPlayerInitiallyInKitchen;
    private static final Random randGen;
    public static LinkedList mixinList;
    public static LinkedList stagingList;
    private static final /* synthetic */ boolean $noassert;
    
    public void AddMixin(final boolean bAutonomouslyChoosable, final int scoreIncr, final int who_or1, final int daType_or1, final int param_or1, final int param2_or1, final int param3_or1, final int who_or2, final int daType_or2, final int param_or2, final int param2_or2, final int param3_or2, final int who_or3, final int daType_or3, final int param_or3, final int param2_or3, final int param3_or3, final int who_or4, final int daType_or4, final int param_or4, final int param2_or4, final int param3_or4, final int mixinType, final int storyTopic, final int charFocus, final int repeatCategory, final int mood, final int pastPresent, final int redirectWho, final int redirectDaType, final int redirectParam, final int redirectParam2, final int redirectParam3) {
        final TherapyGameMixin therapyGameMixin = new TherapyGameMixin();
        therapyGameMixin.who_or1 = who_or1;
        therapyGameMixin.daType_or1 = daType_or1;
        therapyGameMixin.param_or1 = param_or1;
        therapyGameMixin.param2_or1 = param2_or1;
        therapyGameMixin.param3_or1 = param3_or1;
        therapyGameMixin.who_or2 = who_or2;
        therapyGameMixin.daType_or2 = daType_or2;
        therapyGameMixin.param_or2 = param_or2;
        therapyGameMixin.param2_or2 = param2_or2;
        therapyGameMixin.param3_or2 = param3_or2;
        therapyGameMixin.who_or3 = who_or3;
        therapyGameMixin.daType_or3 = daType_or3;
        therapyGameMixin.param_or3 = param_or3;
        therapyGameMixin.param2_or3 = param2_or3;
        therapyGameMixin.param3_or3 = param3_or3;
        therapyGameMixin.who_or4 = who_or4;
        therapyGameMixin.daType_or4 = daType_or4;
        therapyGameMixin.param_or4 = param_or4;
        therapyGameMixin.param2_or4 = param2_or4;
        therapyGameMixin.param3_or4 = param3_or4;
        therapyGameMixin.mixinType = mixinType;
        therapyGameMixin.storyTopic = storyTopic;
        therapyGameMixin.charFocus = charFocus;
        therapyGameMixin.repeatCategory = repeatCategory;
        therapyGameMixin.availability = 0;
        if (mixinType == 2 || mixinType == 3 || mixinType == 4) {
            therapyGameMixin.bFinalRxnPlayed = true;
        }
        else {
            therapyGameMixin.bFinalRxnPlayed = false;
        }
        therapyGameMixin.mood = mood;
        therapyGameMixin.pastPresent = pastPresent;
        therapyGameMixin.redirectWho = redirectWho;
        therapyGameMixin.redirectDaType = redirectDaType;
        therapyGameMixin.redirectParam = redirectParam;
        therapyGameMixin.redirectParam2 = redirectParam2;
        therapyGameMixin.redirectParam3 = redirectParam3;
        therapyGameMixin.bAutonomouslyChoosable = bAutonomouslyChoosable;
        therapyGameMixin.scoreIncr = scoreIncr;
        TherapyGameState.mixinList.add(therapyGameMixin);
    }
    
    public void AddMixin(final boolean b, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10, final int n11, final int n12, final int n13, final int n14, final int n15, final int n16, final int n17, final int n18, final int n19, final int n20, final int n21, final int n22, final int n23, final int n24, final int n25, final int n26, final int n27) {
        this.AddMixin(b, n, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, -1, -1, -1, -1, -1, n17, n18, n19, n20, n21, n22, n23, n24, n25, n26, n27);
    }
    
    public void AddMixin(final boolean b, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10, final int n11, final int n12, final int n13, final int n14, final int n15, final int n16, final int n17, final int n18, final int n19, final int n20, final int n21, final int n22) {
        this.AddMixin(b, n, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, n12, n13, n14, n15, n16, n17, n18, n19, n20, n21, n22);
    }
    
    public void AddMixin(final boolean b, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10, final int n11, final int n12, final int n13, final int n14, final int n15, final int n16, final int n17) {
        this.AddMixin(b, n, n2, n3, n4, n5, n6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, n7, n8, n9, n10, n11, n12, n13, n14, n15, n16, n17);
    }
    
    public int GetNumMixins() {
        return TherapyGameState.mixinList.size();
    }
    
    public void GetMixinInfo(final int n, final IntegerRef integerRef, final IntegerRef integerRef2, final IntegerRef integerRef3, final IntegerRef integerRef4, final IntegerRef integerRef5, final IntegerRef integerRef6, final IntegerRef integerRef7, final IntegerRef integerRef8, final IntegerRef integerRef9, final IntegerRef integerRef10, final IntegerRef integerRef11, final IntegerRef integerRef12, final IntegerRef integerRef13, final IntegerRef integerRef14, final IntegerRef integerRef15) {
        if (!TherapyGameState.$noassert && (n < 0 || n >= TherapyGameState.mixinList.size())) {
            throw new AssertionError();
        }
        final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(n);
        integerRef.i = therapyGameMixin.who_or1;
        integerRef2.i = therapyGameMixin.daType_or1;
        integerRef3.i = therapyGameMixin.param_or1;
        integerRef4.i = therapyGameMixin.param2_or1;
        integerRef5.i = therapyGameMixin.param3_or1;
        integerRef6.i = therapyGameMixin.mixinType;
        integerRef7.i = therapyGameMixin.storyTopic;
        integerRef8.i = therapyGameMixin.charFocus;
        integerRef9.i = therapyGameMixin.mood;
        integerRef10.i = therapyGameMixin.pastPresent;
        integerRef11.i = therapyGameMixin.redirectWho;
        integerRef12.i = therapyGameMixin.redirectDaType;
        integerRef13.i = therapyGameMixin.redirectParam;
        integerRef14.i = therapyGameMixin.redirectParam2;
        integerRef15.i = therapyGameMixin.redirectParam3;
    }
    
    public void DeleteMixin(final int n) {
        if (!TherapyGameState.$noassert && (n < 0 || n >= TherapyGameState.mixinList.size())) {
            throw new AssertionError();
        }
        TherapyGameState.mixinList.remove(n);
    }
    
    public int ChooseNewAccusation(final int n, int n2) {
        final IntegerRef integerRef = new IntegerRef();
        final IntegerRef integerRef2 = new IntegerRef();
        final BooleanRef booleanRef = new BooleanRef();
        int n3;
        int n4;
        int n5;
        if (n != -1) {
            n3 = n;
            n4 = n;
            n5 = n;
        }
        else {
            final int nextInt = TherapyGameState.randGen.nextInt(3);
            if (nextInt == 0) {
                n3 = 59;
            }
            else if (nextInt == 1) {
                n3 = 60;
            }
            else {
                n3 = 61;
            }
            if (n3 == 59) {
                n4 = 60;
                n5 = 61;
            }
            else if (n3 == 60) {
                n4 = 59;
                n5 = 61;
            }
            else {
                n4 = 59;
                n5 = 60;
            }
            if (TherapyGameState.randGen.nextInt(2) == 0) {
                final int n6 = n4;
                n4 = n5;
                n5 = n6;
            }
        }
        if (n2 == -1) {
            if (TherapyGameState.randGen.nextInt(2) == 0) {
                n2 = 0;
            }
            else {
                n2 = 1;
            }
        }
        int currentStoryTopic = n3;
        this.GetMixinID(-1, -1, -1, -1, -1, 6, currentStoryTopic, n2, integerRef, integerRef2, booleanRef);
        int n7;
        if (integerRef2.i == 0) {
            n7 = integerRef.i;
        }
        else {
            n7 = -1;
        }
        if (n7 == -1) {
            currentStoryTopic = n4;
            this.GetMixinID(-1, -1, -1, -1, -1, 6, currentStoryTopic, n2, integerRef, integerRef2, booleanRef);
            if (integerRef2.i == 0) {
                n7 = integerRef.i;
            }
            else {
                n7 = -1;
            }
        }
        if (n7 == -1) {
            currentStoryTopic = n5;
            this.GetMixinID(-1, -1, -1, -1, -1, 6, currentStoryTopic, n2, integerRef, integerRef2, booleanRef);
            if (integerRef2.i == 0) {
                n7 = integerRef.i;
            }
            else {
                n7 = -1;
            }
        }
        if (n7 != -1) {
            TherapyGameState.currentStoryTopic = currentStoryTopic;
            TherapyGameState.lastAccusationMillis = System.currentTimeMillis();
        }
        return n7;
    }
    
    public int ChooseNewCajoleMixin(final float n, final float n2, final int cajoleSpeaker) {
        if (cajoleSpeaker < 0) {
            StringUtil.println("ChooseNewCajoleMixin for player leaving room " + n);
            TherapyGameState.cajoleSpeaker = cajoleSpeaker;
        }
        else {
            if (!TherapyGameState.$noassert && TherapyGameState.previousPlayerStandPositionCharFocus == -1) {
                throw new AssertionError();
            }
            final int getPlayerStandPositionCharFocus = this.GetPlayerStandPositionCharFocus(n, n2);
            if (getPlayerStandPositionCharFocus != TherapyGameState.previousPlayerStandPositionCharFocus && getPlayerStandPositionCharFocus != TherapyGameState.cajolePrevCharFocus) {
                TherapyGameState.cajoleCharFocus = getPlayerStandPositionCharFocus;
            }
            else {
                if (TherapyGameState.cajolePrevCharFocus == -1) {
                    if (TherapyGameState.randGen.nextInt(2) == 0) {
                        TherapyGameState.cajolePrevCharFocus = 2;
                    }
                    else {
                        TherapyGameState.cajolePrevCharFocus = 0;
                    }
                }
                if (TherapyGameState.cajolePrevCharFocus == 2) {
                    if (TherapyGameState.currentMood < 4) {
                        TherapyGameState.cajoleCharFocus = 0;
                    }
                    else {
                        TherapyGameState.cajoleCharFocus = 1;
                    }
                }
                else {
                    TherapyGameState.cajoleCharFocus = 2;
                }
            }
            if (TherapyGameState.cajoleCharFocus == 0) {
                TherapyGameState.cajoleSpeaker = 1;
            }
            else if (TherapyGameState.cajoleCharFocus == 1) {
                TherapyGameState.cajoleSpeaker = 0;
            }
            else if (TherapyGameState.currentMood < 4) {
                TherapyGameState.cajoleSpeaker = 1;
            }
            else {
                TherapyGameState.cajoleSpeaker = 0;
            }
            TherapyGameState.currentCharFocus = TherapyGameState.cajoleCharFocus;
            if (TherapyGameState.currentCharFocus == getPlayerStandPositionCharFocus) {
                TherapyGameState.bCajoleToChangePosition = false;
            }
            else {
                TherapyGameState.bCajoleToChangePosition = true;
            }
        }
        for (int i = 0; i < TherapyGameState.mixinList.size(); ++i) {
            if (((TherapyGameMixin)TherapyGameState.mixinList.get(i)).mixinType == 2) {
                return i;
            }
        }
        if (!TherapyGameState.$noassert) {
            throw new AssertionError();
        }
        return -1;
    }
    
    public int ChooseStrongMoodMixin() {
        for (int i = 0; i < TherapyGameState.mixinList.size(); ++i) {
            if (((TherapyGameMixin)TherapyGameState.mixinList.get(i)).mixinType == 3) {
                return i;
            }
        }
        if (!TherapyGameState.$noassert) {
            throw new AssertionError();
        }
        return -1;
    }
    
    public int ChooseRepeatVersionOfMixinID(final int n) {
        final int getMixinRepeatCategory = this.GetMixinRepeatCategory(n);
        StringUtil.println("## ChooseRepeatVersionOfMixinID for mixin " + n + " repeatCategory " + getMixinRepeatCategory);
        for (int i = 0; i < TherapyGameState.mixinList.size(); ++i) {
            final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(i);
            if (therapyGameMixin.mixinType == 5 && therapyGameMixin.repeatCategory == getMixinRepeatCategory && therapyGameMixin.availability == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public int GetMixinType(final int n) {
        return TherapyGameState.mixinList.get(n).mixinType;
    }
    
    public int GetMixinAvailability(final int n) {
        return TherapyGameState.mixinList.get(n).availability;
    }
    
    public int GetMixinRedirectID(final int n) {
        final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(n);
        if (this.GetMixinType(n) != 1) {
            return n;
        }
        final int doesMixinExist = this.DoesMixinExist(therapyGameMixin.redirectWho, therapyGameMixin.redirectDaType, therapyGameMixin.redirectParam, therapyGameMixin.redirectParam2, therapyGameMixin.redirectParam3, -2, -1, -1);
        if (!TherapyGameState.$noassert && doesMixinExist == -1) {
            throw new AssertionError();
        }
        return doesMixinExist;
    }
    
    public int GetMixinRepeatCategory(final int n) {
        return TherapyGameState.mixinList.get(n).repeatCategory;
    }
    
    public int ChooseNewMixin(final int n) {
        int n2 = this.ChooseNewMixin_Body(true, n);
        if (n2 != -1) {
            StringUtil.println("ChooseNewMixin kept the current mood " + TherapyGameState.currentMood + " and pastPresent " + TherapyGameState.currentPastPresent);
        }
        else {
            n2 = this.ChooseNewMixin_Body(false, n);
            StringUtil.println("ChooseNewMixin did not keep the current mood " + TherapyGameState.currentMood + " and pastPresent " + TherapyGameState.currentPastPresent);
        }
        return n2;
    }
    
    public int ChooseNewMixin_Body(boolean n, int currentCharFocus) {
        final LinkedList list = new LinkedList<IntegerRef>();
        int n2 = -1;
        final int currentCharFocus2 = TherapyGameState.currentCharFocus;
        StringUtil.println("## ChooseNewMixin starting with requested charFocus " + currentCharFocus);
        if (TherapyGameState.randGen.nextInt(3) == 0) {
            list.clear();
            for (int i = 0; i < TherapyGameState.mixinList.size(); ++i) {
                final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(i);
                if (therapyGameMixin.mixinType == 7 && therapyGameMixin.storyTopic == TherapyGameState.currentStoryTopic && therapyGameMixin.charFocus == currentCharFocus && therapyGameMixin.availability == 0 && (n == 0 || (therapyGameMixin.mood == TherapyGameState.currentMood && therapyGameMixin.pastPresent == TherapyGameState.currentPastPresent))) {
                    list.add(new IntegerRef(i));
                }
            }
            if (list.size() > 0) {
                n2 = list.get(TherapyGameState.randGen.nextInt(list.size())).i;
                TherapyGameState.currentCharFocus = currentCharFocus;
                StringUtil.println("ChooseNewMixin chose miscAutonomous " + n2 + " bMatchMoodAndPP " + (boolean)(n != 0));
            }
            else {
                StringUtil.println("ChooseNewMixin no luck choosing a new miscAutonomous, bMatchMoodAndPP " + (boolean)(n != 0));
            }
        }
        if (n2 == -1) {
            if (TherapyGameState.numNewMixinsSinceSwitch > 3 && TherapyGameState.currentCharFocus == currentCharFocus) {
                if (TherapyGameState.currentCharFocus == 0) {
                    if (TherapyGameState.randGen.nextInt(2) == 0) {
                        TherapyGameState.currentCharFocus = 1;
                    }
                    else {
                        TherapyGameState.currentCharFocus = 2;
                    }
                }
                else if (TherapyGameState.currentCharFocus == 1) {
                    if (TherapyGameState.randGen.nextInt(2) == 0) {
                        TherapyGameState.currentCharFocus = 0;
                    }
                    else {
                        TherapyGameState.currentCharFocus = 2;
                    }
                }
                else if (TherapyGameState.randGen.nextInt(2) == 0) {
                    TherapyGameState.currentCharFocus = 0;
                }
                else {
                    TherapyGameState.currentCharFocus = 1;
                }
                StringUtil.println("ChooseNewMixin autonomously chose new charFocus " + TherapyGameState.currentCharFocus);
                currentCharFocus = TherapyGameState.currentCharFocus;
            }
            list.clear();
            for (int j = 0; j < TherapyGameState.mixinList.size(); ++j) {
                final TherapyGameMixin therapyGameMixin2 = TherapyGameState.mixinList.get(j);
                if (therapyGameMixin2.mixinType == 0 && therapyGameMixin2.bAutonomouslyChoosable && therapyGameMixin2.storyTopic == TherapyGameState.currentStoryTopic && therapyGameMixin2.charFocus == currentCharFocus && therapyGameMixin2.availability == 0 && (n == 0 || (therapyGameMixin2.mood == TherapyGameState.currentMood && therapyGameMixin2.pastPresent == TherapyGameState.currentPastPresent))) {
                    list.add(new IntegerRef(j));
                }
            }
            if (list.size() > 0) {
                n2 = list.get(TherapyGameState.randGen.nextInt(list.size())).i;
                TherapyGameState.currentCharFocus = currentCharFocus;
                StringUtil.println("ChooseNewMixin chose among " + list.size() + " for same storytopic new mixin " + n2 + " charFocus " + TherapyGameState.currentCharFocus + " bMatchMoodAndPP " + (boolean)(n != 0));
            }
            else {
                StringUtil.println("ChooseNewMixin no luck choosing for same storytopic, with reqCharFocus, bMatchMoodAndPP " + (boolean)(n != 0));
            }
        }
        if (n2 == -1) {
            list.clear();
            for (int k = 0; k < TherapyGameState.mixinList.size(); ++k) {
                final TherapyGameMixin therapyGameMixin3 = TherapyGameState.mixinList.get(k);
                if (therapyGameMixin3.mixinType == 0 && therapyGameMixin3.bAutonomouslyChoosable && therapyGameMixin3.charFocus == currentCharFocus && therapyGameMixin3.availability == 0 && (n == 0 || (therapyGameMixin3.mood == TherapyGameState.currentMood && therapyGameMixin3.pastPresent == TherapyGameState.currentPastPresent))) {
                    list.add(new IntegerRef(k));
                }
            }
            if (list.size() > 0) {
                n2 = list.get(TherapyGameState.randGen.nextInt(list.size())).i;
                TherapyGameState.currentStoryTopic = ((TherapyGameMixin)TherapyGameState.mixinList.get(n2)).storyTopic;
                TherapyGameState.currentCharFocus = currentCharFocus;
                StringUtil.println("ChooseNewMixin chose among " + list.size() + " for new mixin " + n2 + " storyTopic " + TherapyGameState.currentStoryTopic + " charFocus " + TherapyGameState.currentCharFocus + " bMatchMoodAndPP " + (boolean)(n != 0));
            }
            else {
                StringUtil.println("ChooseNewMixin no luck choosing for any storytopic, but with reqCharFocus, bMatchMoodAndPP " + (boolean)(n != 0));
            }
        }
        if (n2 == -1 && n == 0) {
            for (int l = 0; l < 2; ++l) {
                if (l == 0) {
                    n = 1;
                }
                else {
                    n = 0;
                }
                list.clear();
                for (int n3 = 0; n3 < TherapyGameState.mixinList.size(); ++n3) {
                    final TherapyGameMixin therapyGameMixin4 = TherapyGameState.mixinList.get(n3);
                    if (therapyGameMixin4.mixinType == 0 && therapyGameMixin4.bAutonomouslyChoosable && therapyGameMixin4.availability == 0 && (n == 0 || (therapyGameMixin4.mood == TherapyGameState.currentMood && therapyGameMixin4.pastPresent == TherapyGameState.currentPastPresent))) {
                        list.add(new IntegerRef(n3));
                    }
                }
                if (list.size() > 0) {
                    n2 = list.get(TherapyGameState.randGen.nextInt(list.size())).i;
                    final TherapyGameMixin therapyGameMixin5 = TherapyGameState.mixinList.get(n2);
                    TherapyGameState.currentStoryTopic = therapyGameMixin5.storyTopic;
                    TherapyGameState.currentCharFocus = therapyGameMixin5.charFocus;
                    StringUtil.println("ChooseNewMixin chose among " + list.size() + " for new mixin " + n2 + " storyTopic " + TherapyGameState.currentStoryTopic + " charFocus " + TherapyGameState.currentCharFocus + " bMatchMoodAndPP " + (boolean)(n != 0));
                }
                else {
                    StringUtil.println("ChooseNewMixin no luck choosing for any storytopic and any charFocus, bMatchMoodAndPP " + (boolean)(n != 0));
                }
            }
        }
        if (n == 0 && !TherapyGameState.$noassert && n2 == -1) {
            throw new AssertionError((Object)("TherapyGameState.ChooseNewMixin() can't find a mixin, bMatchMoodAndPP" + (boolean)(n != 0)));
        }
        if (n2 == -1) {
            TherapyGameState.currentCharFocus = currentCharFocus2;
        }
        return n2;
    }
    
    public int GetPlayerStandPositionCharFocus(final float n, final float n2) {
        final float n3 = 70.0f;
        int n4;
        if (n < n3 && n < n2) {
            n4 = 0;
        }
        else if (n2 < n3 && n2 < n) {
            n4 = 1;
        }
        else {
            n4 = 2;
        }
        return n4;
    }
    
    public void GetMixinID(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final IntegerRef integerRef, final IntegerRef integerRef2, final BooleanRef booleanRef) {
        final int doesMixinExist = this.DoesMixinExist(n, n2, n3, n4, n5, n6, n7, n8);
        integerRef.i = doesMixinExist;
        if (doesMixinExist != -1) {
            final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(doesMixinExist);
            integerRef2.i = therapyGameMixin.availability;
            booleanRef.b = therapyGameMixin.bCausedByPlayer;
        }
        else {
            integerRef2.i = -1;
        }
    }
    
    public int GetRelatedMixin(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        final IntegerRef integerRef = new IntegerRef();
        final IntegerRef integerRef2 = new IntegerRef();
        final IntegerRef integerRef3 = new IntegerRef();
        final BooleanRef booleanRef = new BooleanRef();
        StringUtil.println("## GetRelatedMixin for who " + n + " daType " + n2 + " param " + n3 + " param2 " + n4 + " param3 " + n5 + " storyTopic " + TherapyGameState.currentStoryTopic + " charFocus " + TherapyGameState.currentCharFocus + " reqCharFocus " + n6);
        int n7;
        int n8;
        if (TherapyGameState.currentStoryTopic == 59) {
            n7 = 60;
            n8 = 61;
        }
        else if (TherapyGameState.currentStoryTopic == 60) {
            n7 = 59;
            n8 = 61;
        }
        else {
            n7 = 59;
            n8 = 60;
        }
        if (TherapyGameState.randGen.nextInt(2) == 0) {
            final int n9 = n7;
            n7 = n8;
            n8 = n9;
        }
        StringUtil.println("## Attempting other story topic " + n7 + " reqCharFocus " + n6);
        this.GetMixinID(n, n2, n3, n4, n5, 0, n7, n6, integerRef, integerRef3, booleanRef);
        int n10 = integerRef.i;
        final int i = integerRef3.i;
        if (n10 != -1 && i == 0) {
            TherapyGameState.currentStoryTopic = n7;
            TherapyGameState.currentCharFocus = n6;
            StringUtil.println("## Found other story topic, new currentStoryTopic " + TherapyGameState.currentStoryTopic + ", charFocus " + TherapyGameState.currentCharFocus);
        }
        else {
            StringUtil.println("## Attempting other story topic " + n8 + " reqCharFocus " + n6);
            this.GetMixinID(n, n2, n3, n4, n5, 0, n8, n6, integerRef, integerRef3, booleanRef);
            n10 = integerRef.i;
            final int j = integerRef3.i;
            if (n10 != -1 && j == 0) {
                TherapyGameState.currentStoryTopic = n8;
                TherapyGameState.currentCharFocus = n6;
                StringUtil.println("## Found other story topic, new currentStoryTopic " + TherapyGameState.currentStoryTopic + ", charFocus " + TherapyGameState.currentCharFocus);
            }
            else {
                StringUtil.println("## Attempting GTRSibling current story topic " + TherapyGameState.currentStoryTopic + " reqCharFocus " + n6);
                this.GetMixinGTRSibling(n, n2, n3, n4, n5, 0, TherapyGameState.currentStoryTopic, n6, integerRef, integerRef3, integerRef2);
                n10 = integerRef.i;
                final int k = integerRef3.i;
                if (n10 != -1 && k == 0) {
                    TherapyGameState.currentCharFocus = integerRef2.i;
                    StringUtil.println("## Found GTR sibling, new currentCharFocus " + TherapyGameState.currentCharFocus);
                }
                else {
                    StringUtil.println("## Attempting GTRSibling other story topic " + n7 + " reqCharFocus " + n6);
                    this.GetMixinGTRSibling(n, n2, n3, n4, n5, 0, n7, n6, integerRef, integerRef3, integerRef2);
                    n10 = integerRef.i;
                    final int l = integerRef3.i;
                    if (n10 != -1 && l == 0) {
                        TherapyGameState.currentStoryTopic = n7;
                        TherapyGameState.currentCharFocus = integerRef2.i;
                        StringUtil.println("## Found other story topic and GTR sibling, new currentStoryTopic " + TherapyGameState.currentStoryTopic + " and new currentCharFocus " + TherapyGameState.currentCharFocus);
                    }
                    else {
                        StringUtil.println("## Attempting GTRSibling other story topic " + n8 + " reqCharFocus " + n6);
                        this.GetMixinGTRSibling(n, n2, n3, n4, n5, 0, n8, n6, integerRef, integerRef3, integerRef2);
                        n10 = integerRef.i;
                        final int m = integerRef3.i;
                        if (n10 != -1 && m == 0) {
                            TherapyGameState.currentStoryTopic = n8;
                            TherapyGameState.currentCharFocus = integerRef2.i;
                            StringUtil.println("## Found other story topic and GTR sibling, new currentStoryTopic " + TherapyGameState.currentStoryTopic + " and new currentCharFocus " + TherapyGameState.currentCharFocus);
                        }
                        else {
                            StringUtil.println("## Could not find related mixin!");
                            n10 = -1;
                        }
                    }
                }
            }
        }
        return n10;
    }
    
    public void GetMixinGTRSibling(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final IntegerRef integerRef, final IntegerRef integerRef2, final IntegerRef integerRef3) {
        final BooleanRef booleanRef = new BooleanRef();
        integerRef.i = -1;
        integerRef3.i = -1;
        int i;
        int j;
        if (n8 == 0) {
            i = 1;
            j = 2;
        }
        else if (n8 == 1) {
            i = 0;
            j = 2;
        }
        else {
            i = 0;
            j = 1;
        }
        if (TherapyGameState.randGen.nextInt(2) == 0) {
            final int n9 = i;
            i = j;
            j = n9;
        }
        StringUtil.println(" GetMixinGTRSibling for who " + n + " daType " + n2 + " param " + n3 + " storyTopic " + n7 + " charFocus " + i);
        this.GetMixinID(n, n2, n3, n4, n5, 0, n7, i, integerRef, integerRef2, booleanRef);
        final int k = integerRef.i;
        integerRef3.i = i;
        if (k == -1) {
            StringUtil.println(" GetMixinGTRSibling for who " + n + " daType " + n2 + " param " + n3 + " storyTopic " + n7 + " charFocus " + j);
            this.GetMixinID(n, n2, n3, n4, n5, 0, n7, j, integerRef, integerRef2, booleanRef);
            final int l = integerRef.i;
            integerRef3.i = j;
        }
    }
    
    public int DoesMixinExist(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        for (int i = 0; i < TherapyGameState.mixinList.size(); ++i) {
            final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(i);
            if (((n == therapyGameMixin.who_or1 || therapyGameMixin.who_or1 == 3 || (n == 0 && therapyGameMixin.who_or1 == 2) || (n == 2 && therapyGameMixin.who_or1 == 0) || (n == 1 && therapyGameMixin.who_or1 == 2) || (n == 2 && therapyGameMixin.who_or1 == 1)) && n2 == therapyGameMixin.daType_or1 && n3 == therapyGameMixin.param_or1 && n4 == therapyGameMixin.param2_or1 && n5 == therapyGameMixin.param3_or1) || ((n == therapyGameMixin.who_or2 || therapyGameMixin.who_or2 == 3 || (n == 0 && therapyGameMixin.who_or2 == 2) || (n == 2 && therapyGameMixin.who_or2 == 0) || (n == 1 && therapyGameMixin.who_or2 == 2) || (n == 2 && therapyGameMixin.who_or2 == 1)) && n2 == therapyGameMixin.daType_or2 && n3 == therapyGameMixin.param_or2 && n4 == therapyGameMixin.param2_or2 && n5 == therapyGameMixin.param3_or2) || ((n == therapyGameMixin.who_or3 || therapyGameMixin.who_or3 == 3 || (n == 0 && therapyGameMixin.who_or3 == 2) || (n == 2 && therapyGameMixin.who_or3 == 0) || (n == 1 && therapyGameMixin.who_or3 == 2) || (n == 2 && therapyGameMixin.who_or3 == 1)) && n2 == therapyGameMixin.daType_or3 && n3 == therapyGameMixin.param_or3 && n4 == therapyGameMixin.param2_or3 && n5 == therapyGameMixin.param3_or3) || ((n == therapyGameMixin.who_or4 || therapyGameMixin.who_or4 == 3 || (n == 0 && therapyGameMixin.who_or4 == 2) || (n == 2 && therapyGameMixin.who_or4 == 0) || (n == 1 && therapyGameMixin.who_or4 == 2) || (n == 2 && therapyGameMixin.who_or4 == 1)) && n2 == therapyGameMixin.daType_or4 && n3 == therapyGameMixin.param_or4 && n4 == therapyGameMixin.param2_or4 && n5 == therapyGameMixin.param3_or4)) {
                switch (n6) {
                    case 0: {
                        if ((therapyGameMixin.mixinType == 0 && therapyGameMixin.storyTopic == n7 && therapyGameMixin.charFocus == n8) || therapyGameMixin.mixinType == 1 || therapyGameMixin.mixinType == 4) {
                            return i;
                        }
                        break;
                    }
                    case 1:
                    case 4: {
                        if (therapyGameMixin.mixinType == n6 && therapyGameMixin.storyTopic == n7) {
                            return i;
                        }
                        break;
                    }
                    case 6:
                    case 7: {
                        if (therapyGameMixin.mixinType == n6 && therapyGameMixin.storyTopic == n7 && therapyGameMixin.charFocus == n8) {
                            return i;
                        }
                        break;
                    }
                    case -2: {
                        return i;
                    }
                    default: {
                        if (!TherapyGameState.$noassert) {
                            throw new AssertionError((Object)("DoesMixinExist: requesting illegal mixinType " + n6));
                        }
                        break;
                    }
                }
            }
        }
        return -1;
    }
    
    public void SetMixinAndGTRSiblingsAsUsed(final int n) {
        StringUtil.println("SetMixinAndGTRSiblingsAsUsed for mixinID " + n + "...");
        if (n != -1) {
            final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(n);
            final int who_or1 = therapyGameMixin.who_or1;
            final int daType_or1 = therapyGameMixin.daType_or1;
            final int param_or1 = therapyGameMixin.param_or1;
            final int param2_or1 = therapyGameMixin.param2_or1;
            final int param3_or1 = therapyGameMixin.param3_or1;
            final int mixinType = therapyGameMixin.mixinType;
            final int storyTopic = therapyGameMixin.storyTopic;
            if (mixinType == 2 || mixinType == 3) {
                return;
            }
            if (mixinType == 5) {
                return;
            }
            final int doesMixinExist = this.DoesMixinExist(who_or1, daType_or1, param_or1, param2_or1, param3_or1, mixinType, storyTopic, 0);
            final int doesMixinExist2 = this.DoesMixinExist(who_or1, daType_or1, param_or1, param2_or1, param3_or1, mixinType, storyTopic, 1);
            final int doesMixinExist3 = this.DoesMixinExist(who_or1, daType_or1, param_or1, param2_or1, param3_or1, mixinType, storyTopic, 2);
            if (!TherapyGameState.$noassert && doesMixinExist == -1 && doesMixinExist2 == -1 && doesMixinExist3 == -1) {
                throw new AssertionError();
            }
            if (!TherapyGameState.$noassert && doesMixinExist != n && doesMixinExist2 != n && doesMixinExist3 != n) {
                throw new AssertionError();
            }
            this.SetMixinAsUsed(doesMixinExist);
            this.SetMixinAsUsed(doesMixinExist2);
            this.SetMixinAsUsed(doesMixinExist3);
        }
    }
    
    public void SetMixinCousinsAsUsed(final int n) {
        StringUtil.println("SetMixinCousinsAsUsed for mixinID " + n + "...");
        if (n != -1) {
            final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(n);
            final int who_or1 = therapyGameMixin.who_or1;
            final int daType_or1 = therapyGameMixin.daType_or1;
            int param_or1 = therapyGameMixin.param_or1;
            final int param2_or1 = therapyGameMixin.param2_or1;
            final int param3_or1 = therapyGameMixin.param3_or1;
            final int mixinType = therapyGameMixin.mixinType;
            final int storyTopic = therapyGameMixin.storyTopic;
            if (who_or1 == 2 && (daType_or1 == 23 || daType_or1 == 24 || daType_or1 == 25 || daType_or1 == 26)) {
                int n2;
                if (param_or1 == 111 || param_or1 == 112) {
                    param_or1 = 111;
                    n2 = 112;
                }
                else {
                    n2 = -1;
                }
                for (int i = 0; i < 2; ++i) {
                    int n3 = -1;
                    if (i == 0) {
                        n3 = param_or1;
                    }
                    if (i == 1) {
                        n3 = n2;
                    }
                    if (n3 != -1) {
                        for (int j = 0; j <= 1; ++j) {
                            for (int k = 59; k <= 61; ++k) {
                                for (int l = 23; l <= 26; ++l) {
                                    for (int n4 = 0; n4 <= 2; ++n4) {
                                        final int doesMixinExist = this.DoesMixinExist(j, l, n3, param2_or1, param3_or1, 0, k, n4);
                                        if (doesMixinExist != -1 && this.SetMixinAsUsed(doesMixinExist)) {
                                            StringUtil.println("### Setting cousin mixin " + doesMixinExist + " as used: who " + j + " daType " + daType_or1 + " param " + n3 + " storyTopic " + k + " charFocus " + n4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (mixinType == 0) {
                for (int n5 = 0; n5 < TherapyGameState.mixinList.size(); ++n5) {
                    final TherapyGameMixin therapyGameMixin2 = TherapyGameState.mixinList.get(n5);
                    if (who_or1 == therapyGameMixin2.redirectWho && daType_or1 == therapyGameMixin2.redirectDaType && param_or1 == therapyGameMixin2.redirectParam && param2_or1 == therapyGameMixin2.redirectParam2 && param3_or1 == therapyGameMixin2.redirectParam3 && this.SetMixinAsUsed(n5)) {
                        StringUtil.println("### Setting redirect cousin mixin " + n5 + " as used: who " + therapyGameMixin2.redirectWho + " daType " + therapyGameMixin2.redirectDaType + " param " + therapyGameMixin2.redirectParam + " storyTopic " + therapyGameMixin2.storyTopic + " charFocus " + therapyGameMixin2.charFocus);
                    }
                }
            }
        }
    }
    
    public boolean SetMixinAsUsed(final int n) {
        if (n != -1) {
            final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(n);
            if (therapyGameMixin.availability == 0) {
                therapyGameMixin.availability = 1;
                StringUtil.println("SetMixinAsUsed " + n);
                return true;
            }
        }
        return false;
    }
    
    public boolean GetIfMixinCausedByPlayer(final int n) {
        return n != -1 && TherapyGameState.mixinList.get(n).bCausedByPlayer;
    }
    
    public void SetMixinAsCausedByPlayer(final int n) {
        if (n != -1) {
            TherapyGameState.mixinList.get(n).bCausedByPlayer = true;
            StringUtil.println("SetMixinAsCausedByPlayer " + n);
        }
    }
    
    public boolean GetIfFinalRxnOfMixinAvailable(final int n) {
        if (!TherapyGameState.$noassert && (n < 0 || n >= TherapyGameState.mixinList.size())) {
            throw new AssertionError();
        }
        final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(n);
        return (therapyGameMixin.mixinType == 0 || therapyGameMixin.mixinType == 6 || therapyGameMixin.mixinType == 7) && !therapyGameMixin.bFinalRxnPlayed;
    }
    
    public void SetFinalRxnOfMixinAsUsed(final int n) {
        if (n != -1) {
            TherapyGameState.mixinList.get(n).bFinalRxnPlayed = true;
        }
    }
    
    public void AddMixinScore(final int n) {
        if (n != -1) {
            final TherapyGameMixin therapyGameMixin = TherapyGameState.mixinList.get(n);
            StringUtil.println("AddMixinScore mixinID " + n + " scoreIncr " + therapyGameMixin.scoreIncr);
            this.AddToScore(therapyGameMixin.storyTopic, therapyGameMixin.charFocus, therapyGameMixin.scoreIncr);
        }
    }
    
    public void AddToScore(final int n, final int n2, final int n3) {
        ++TherapyGameState.numTimesScoreChanged;
        TherapyGameState.lastTimeScoreChanged = TherapyGameState.numMixinsPlayed;
        if (n == 59) {
            if (n2 == 0) {
                TherapyGameState.calculusScore_AA_G += n3;
                TherapyGameState.calculusScoreWhenCtr_AA_G = TherapyGameState.numMixinsPlayed;
            }
            if (n2 == 1) {
                TherapyGameState.calculusScore_AA_T += n3;
                TherapyGameState.calculusScoreWhenCtr_AA_T = TherapyGameState.numMixinsPlayed;
            }
            if (n2 == 2) {
                TherapyGameState.calculusScore_AA_R += n3;
                TherapyGameState.calculusScoreWhenCtr_AA_R = TherapyGameState.numMixinsPlayed;
            }
        }
        if (n == 60) {
            if (n2 == 0) {
                TherapyGameState.calculusScore_F_G += n3;
                TherapyGameState.calculusScoreWhenCtr_F_G = TherapyGameState.numMixinsPlayed;
            }
            if (n2 == 1) {
                TherapyGameState.calculusScore_F_T += n3;
                TherapyGameState.calculusScoreWhenCtr_F_T = TherapyGameState.numMixinsPlayed;
            }
            if (n2 == 2) {
                TherapyGameState.calculusScore_F_R += n3;
                TherapyGameState.calculusScoreWhenCtr_F_R = TherapyGameState.numMixinsPlayed;
            }
        }
        if (n == 61) {
            if (n2 == 0) {
                TherapyGameState.calculusScore_RM_G += n3;
                TherapyGameState.calculusScoreWhenCtr_RM_G = TherapyGameState.numMixinsPlayed;
            }
            if (n2 == 1) {
                TherapyGameState.calculusScore_RM_T += n3;
                TherapyGameState.calculusScoreWhenCtr_RM_T = TherapyGameState.numMixinsPlayed;
            }
            if (n2 == 2) {
                TherapyGameState.calculusScore_RM_R += n3;
                TherapyGameState.calculusScoreWhenCtr_RM_R = TherapyGameState.numMixinsPlayed;
            }
        }
        StringUtil.println("### TherapyGame AddToScore storyTopic " + n + " charFocus " + n2 + " val " + n3);
        StringUtil.println("AA_G = " + TherapyGameState.calculusScore_AA_G);
        StringUtil.println("AA_T = " + TherapyGameState.calculusScore_AA_T);
        StringUtil.println("AA_R = " + TherapyGameState.calculusScore_AA_R);
        StringUtil.println("F_G = " + TherapyGameState.calculusScore_F_G);
        StringUtil.println("F_T = " + TherapyGameState.calculusScore_F_T);
        StringUtil.println("F_R = " + TherapyGameState.calculusScore_F_R);
        StringUtil.println("RM_G = " + TherapyGameState.calculusScore_RM_G);
        StringUtil.println("RM_T = " + TherapyGameState.calculusScore_RM_T);
        StringUtil.println("RM_R = " + TherapyGameState.calculusScore_RM_R);
    }
    
    public boolean DoWeHaveGTRRevelations() {
        boolean b = false;
        if (TherapyGameState.calculusScore_AA_G + TherapyGameState.calculusScore_F_G + TherapyGameState.calculusScore_RM_G >= TherapyGameState.calculusScoreThreshold && TherapyGameState.calculusScore_AA_T + TherapyGameState.calculusScore_F_T + TherapyGameState.calculusScore_RM_T >= TherapyGameState.calculusScoreThreshold && TherapyGameState.calculusScore_AA_R + TherapyGameState.calculusScore_F_R + TherapyGameState.calculusScore_RM_R >= TherapyGameState.calculusScoreThreshold) {
            b = true;
        }
        return b;
    }
    
    public void InitTherapyGame() {
        StringUtil.println("### InitTherapyGame...");
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 6, 59, 0, -1, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 6, 59, 1, -1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 6, 60, 0, -1, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 6, 60, 1, -1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 6, 61, 0, -1, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 6, 61, 1, -1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 7, 59, 1, -1, 5, 0, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 7, 61, 0, -1, 1, 0, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 7, 61, 1, -1, 5, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 23, 100, -1, -1, 0, 23, 101, -1, -1, 1, 26, 100, -1, -1, 1, 26, 101, -1, -1, 0, 59, 0, 0, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 23, 100, -1, -1, 0, 23, 101, -1, -1, 1, 26, 100, -1, -1, 1, 26, 101, -1, -1, 0, 59, 1, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 23, 100, -1, -1, 0, 23, 101, -1, -1, 1, 26, 100, -1, -1, 1, 26, 101, -1, -1, 0, 59, 2, 0, 1, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 23, 100, -1, -1, 0, 23, 101, -1, -1, 1, 26, 100, -1, -1, 1, 26, 101, -1, -1, 0, 61, 2, 0, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 24, 102, -1, -1, 1, 24, 103, -1, -1, 0, 25, 102, -1, -1, 1, 25, 103, -1, -1, 0, 61, 0, 0, 1, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 24, 102, -1, -1, 1, 24, 103, -1, -1, 0, 25, 102, -1, -1, 1, 25, 103, -1, -1, 0, 61, 1, 0, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 24, 102, -1, -1, 1, 24, 103, -1, -1, 0, 25, 102, -1, -1, 1, 25, 103, -1, -1, 0, 61, 2, 0, 5, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 23, 102, -1, -1, 0, 23, 103, -1, -1, 0, 25, 103, -1, -1, 1, 25, 102, -1, -1, 0, 61, 0, 0, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 23, 102, -1, -1, 0, 23, 103, -1, -1, 0, 25, 103, -1, -1, 1, 25, 102, -1, -1, 0, 61, 1, 0, 5, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 23, 102, -1, -1, 0, 23, 103, -1, -1, 0, 25, 103, -1, -1, 1, 25, 102, -1, -1, 0, 61, 2, 0, 4, 0, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 23, 105, -1, -1, 0, 26, 105, -1, -1, 0, 59, 0, 0, 1, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 23, 105, -1, -1, 0, 26, 105, -1, -1, 0, 59, 2, 0, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 23, 105, -1, -1, 0, 26, 105, -1, -1, 0, 60, 0, 0, 1, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 23, 105, -1, -1, 0, 26, 105, -1, -1, 0, 61, 0, 0, 1, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 24, 106, -1, -1, 1, 25, 106, -1, -1, 0, 61, 1, 0, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 24, 106, -1, -1, 1, 25, 106, -1, -1, 0, 61, 2, 0, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 23, 107, -1, -1, 0, 26, 107, -1, -1, 0, 59, 0, 0, 1, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 23, 107, -1, -1, 0, 26, 107, -1, -1, 0, 59, 2, 0, 1, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 23, 107, -1, -1, 0, 26, 107, -1, -1, 0, 60, 0, 0, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 23, 107, -1, -1, 0, 26, 107, -1, -1, 0, 60, 2, 0, 1, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 23, 107, -1, -1, 1, 26, 107, -1, -1, 0, 60, 1, 0, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 23, 107, -1, -1, 1, 26, 107, -1, -1, 0, 60, 2, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 23, 107, -1, -1, 0, 26, 107, -1, -1, 0, 61, 0, 0, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 23, 107, -1, -1, 0, 26, 107, -1, -1, 0, 61, 1, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 23, 107, -1, -1, 0, 26, 107, -1, -1, 0, 61, 2, 0, 1, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 23, 107, -1, -1, 1, 26, 107, -1, -1, 0, 59, 1, 0, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 23, 107, -1, -1, 1, 26, 107, -1, -1, 0, 61, 0, 0, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 23, 107, -1, -1, 1, 26, 107, -1, -1, 0, 61, 1, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 23, 107, -1, -1, 1, 26, 107, -1, -1, 0, 61, 2, 0, 4, 0, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 24, 111, -1, -1, 2, 26, 111, -1, -1, 0, 61, 2, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 24, 112, -1, -1, 2, 26, 112, -1, -1, 0, 61, 2, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 23, 113, -1, -1, 2, 25, 113, -1, -1, 0, 59, 2, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 23, 113, -1, -1, 2, 25, 113, -1, -1, 0, 60, 2, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 23, 113, -1, -1, 2, 25, 113, -1, -1, 0, 61, 2, 0, 1, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 0, 23, 117, -1, -1, 0, 25, 117, -1, -1, 0, 59, 0, 0, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 23, 118, -1, -1, 0, 25, 118, -1, -1, 0, 24, 118, -1, -1, 0, 26, 118, -1, -1, 0, 59, 0, 0, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 2, 1, 23, 118, -1, -1, 1, 25, 118, -1, -1, 0, 60, 1, 0, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 24, 100, -1, -1, 0, 24, 101, -1, -1, 1, -1, -1, -1, -1, -1, 1, 23, 100, -1, -1);
        this.AddMixin(true, 0, 0, 23, 102, -1, -1, 1, 23, 103, -1, -1, 0, 61, 0, 1, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 0, 23, 102, -1, -1, 1, 23, 103, -1, -1, 0, 61, 1, 1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 0, 23, 102, -1, -1, 1, 23, 103, -1, -1, 0, 61, 2, 1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 24, 102, -1, -1, 0, 24, 103, -1, -1, 1, -1, -1, -1, -1, -1, 1, 23, 102, -1, -1);
        this.AddMixin(false, 0, 0, 24, 105, -1, -1, 1, -1, -1, -1, -1, -1, 0, 23, 105, -1, -1);
        this.AddMixin(false, 0, 0, 23, 109, -1, -1, 0, 25, 109, -1, -1, 0, 26, 109, -1, -1, 1, 24, 109, -1, -1, 0, 59, 0, 1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 0, 23, 109, -1, -1, 0, 25, 109, -1, -1, 0, 26, 109, -1, -1, 1, 24, 109, -1, -1, 0, 59, 1, 1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 0, 23, 109, -1, -1, 0, 25, 109, -1, -1, 0, 26, 109, -1, -1, 1, 24, 109, -1, -1, 0, 59, 2, 1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 0, 23, 109, -1, -1, 0, 25, 109, -1, -1, 0, 26, 109, -1, -1, 1, 24, 109, -1, -1, 0, 60, 0, 1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 23, 109, -1, -1, 0, 25, 109, -1, -1, 0, 26, 109, -1, -1, 1, 24, 109, -1, -1, 0, 61, 0, 1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 1, 23, 109, -1, -1, 1, 25, 109, -1, -1, 1, 26, 109, -1, -1, 0, 24, 109, -1, -1, 0, 59, 0, 1, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 1, 23, 109, -1, -1, 1, 25, 109, -1, -1, 1, 26, 109, -1, -1, 0, 24, 109, -1, -1, 0, 59, 1, 1, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 1, 23, 109, -1, -1, 1, 25, 109, -1, -1, 1, 26, 109, -1, -1, 0, 24, 109, -1, -1, 0, 59, 2, 1, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 1, 23, 109, -1, -1, 1, 25, 109, -1, -1, 1, 26, 109, -1, -1, 0, 24, 109, -1, -1, 0, 60, 2, 1, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 23, 109, -1, -1, 1, 25, 109, -1, -1, 1, 26, 109, -1, -1, 0, 24, 109, -1, -1, 0, 61, 1, 1, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 23, 110, -1, -1, 0, 25, 110, -1, -1, 1, 24, 110, -1, -1, 1, 26, 110, -1, -1, 0, 59, 0, 1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 0, 23, 110, -1, -1, 0, 25, 110, -1, -1, 1, 24, 110, -1, -1, 1, 26, 110, -1, -1, 0, 59, 1, 1, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 0, 23, 110, -1, -1, 0, 25, 110, -1, -1, 1, 24, 110, -1, -1, 1, 26, 110, -1, -1, 0, 59, 2, 1, 4, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 0, 23, 110, -1, -1, 0, 25, 110, -1, -1, 1, 24, 110, -1, -1, 1, 26, 110, -1, -1, 0, 60, 1, 1, 4, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 0, 23, 110, -1, -1, 0, 25, 110, -1, -1, 1, 24, 110, -1, -1, 1, 26, 110, -1, -1, 0, 61, 0, 1, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 1, 23, 110, -1, -1, 1, 25, 110, -1, -1, 0, 24, 110, -1, -1, 0, 26, 110, -1, -1, 0, 59, 0, 1, 1, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 1, 23, 110, -1, -1, 1, 25, 110, -1, -1, 0, 24, 110, -1, -1, 0, 26, 110, -1, -1, 0, 59, 1, 1, 1, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 1, 23, 110, -1, -1, 1, 25, 110, -1, -1, 0, 24, 110, -1, -1, 0, 26, 110, -1, -1, 0, 59, 2, 1, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 1, 23, 110, -1, -1, 1, 25, 110, -1, -1, 0, 24, 110, -1, -1, 0, 26, 110, -1, -1, 0, 60, 0, 1, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, -1, 1, 23, 110, -1, -1, 1, 25, 110, -1, -1, 0, 24, 110, -1, -1, 0, 26, 110, -1, -1, 0, 61, 1, 1, 4, 0, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 23, 106, -1, -1, 1, -1, -1, -1, -1, -1, 1, 24, 106, -1, -1);
        this.AddMixin(false, 0, 0, 24, 107, -1, -1, 1, -1, -1, -1, -1, -1, 0, 23, 107, -1, -1);
        this.AddMixin(false, 0, 1, 24, 107, -1, -1, 1, -1, -1, -1, -1, -1, 1, 23, 107, -1, -1);
        this.AddMixin(false, 0, 2, 23, 111, -1, -1, 2, 25, 111, -1, -1, 0, 61, 2, 1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 23, 112, -1, -1, 2, 25, 112, -1, -1, 0, 61, 2, 1, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 24, 113, -1, -1, 2, 26, 113, -1, -1, 1, -1, -1, -1, -1, -1, 2, 23, 113, -1, -1);
        this.AddMixin(false, 0, 2, 23, 115, -1, -1, 2, 25, 115, -1, -1, 0, 61, 2, 1, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 24, 117, -1, -1, 0, 26, 117, -1, -1, 1, -1, -1, -1, -1, -1, 0, 23, 117, -1, -1);
        this.AddMixin(false, 0, 1, 24, 118, -1, -1, 1, 26, 118, -1, -1, 1, -1, -1, -1, -1, -1, 1, 23, 118, -1, -1);
        this.AddMixin(false, 0, 0, 24, 100, -1, -1, 1, 24, 101, -1, -1, 1, -1, -1, -1, -1, -1, 1, 23, 100, -1, -1);
        this.AddMixin(true, 0, 0, 23, 104, -1, -1, 0, 26, 104, -1, -1, 4, -1, -1, 0, 1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 1, 23, 105, -1, -1, 1, 26, 105, -1, -1, 0, 59, 1, 0, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 23, 105, -1, -1, 1, 26, 105, -1, -1, 0, 61, 1, 0, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 0, 23, 106, -1, -1, 0, 61, 0, 0, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 0, 23, 108, -1, -1, 0, 25, 108, -1, -1, 0, 26, 108, -1, -1, 0, 59, 0, 0, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 0, 23, 108, -1, -1, 0, 25, 108, -1, -1, 0, 26, 108, -1, -1, 0, 59, 1, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 0, 23, 108, -1, -1, 0, 25, 108, -1, -1, 0, 26, 108, -1, -1, 0, 59, 2, 0, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 0, 23, 108, -1, -1, 0, 25, 108, -1, -1, 0, 26, 108, -1, -1, 0, 61, 0, 0, 0, 0, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 0, 23, 108, -1, -1, 0, 25, 108, -1, -1, 0, 26, 108, -1, -1, 0, 61, 2, 0, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 1, 23, 108, -1, -1, 1, 25, 108, -1, -1, 1, 26, 108, -1, -1, 0, 59, 0, 0, 0, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 1, 23, 108, -1, -1, 1, 25, 108, -1, -1, 1, 26, 108, -1, -1, 0, 59, 1, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 1, 23, 108, -1, -1, 1, 25, 108, -1, -1, 1, 26, 108, -1, -1, 0, 59, 2, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 1, 23, 108, -1, -1, 1, 25, 108, -1, -1, 1, 26, 108, -1, -1, 0, 61, 1, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 1, 1, 23, 108, -1, -1, 1, 25, 108, -1, -1, 1, 26, 108, -1, -1, 0, 61, 2, 0, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 24, 115, -1, -1, 2, 26, 115, -1, -1, 0, 61, 2, 0, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 23, 116, -1, -1, 2, 25, 116, -1, -1, 2, 24, 116, -1, -1, 2, 26, 116, -1, -1, 4, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 23, 117, -1, -1, 1, 25, 117, -1, -1, 0, 59, 1, 0, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 1, 24, 104, -1, -1, 4, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 0, 23, 100, -1, -1, 0, 26, 100, -1, -1, 1, 23, 101, -1, -1, 1, 26, 101, -1, -1, 4, -1, -1, 1, 0, -1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 0, 24, 104, -1, -1, 4, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 1, 23, 104, -1, -1, 1, 26, 104, -1, -1, 4, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 24, 105, -1, -1, 1, -1, -1, -1, -1, -1, 1, 23, 105, -1, -1);
        this.AddMixin(true, 0, 0, 24, 106, -1, -1, 0, 25, 106, -1, -1, 4, -1, -1, 1, 0, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 24, 108, -1, -1, 1, -1, -1, -1, -1, -1, 0, 23, 108, -1, -1);
        this.AddMixin(false, 0, 1, 24, 108, -1, -1, 1, -1, -1, -1, -1, -1, 1, 23, 108, -1, -1);
        this.AddMixin(false, 0, 2, 24, 114, -1, -1, 2, 26, 114, -1, -1, 4, -1, -1, 1, 5, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 24, 117, -1, -1, 1, 26, 117, -1, -1, 1, -1, -1, -1, -1, -1, 1, 23, 117, -1, -1);
        this.AddMixin(false, 0, 0, 25, 100, -1, -1, 1, 25, 100, -1, -1, 0, 25, 101, -1, -1, 1, 25, 101, -1, -1, 4, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 27, 125, 128, 127, 2, 28, 125, 128, 127, 0, 61, 1, 0, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 128, 129, 2, 28, 123, 128, 129, 2, 27, 123, 129, 128, 2, 28, 123, 129, 128, 1, -1, -1, -1, -1, -1, 1, 27, 125, 128, 127);
        this.AddMixin(false, 0, 2, 27, 124, 128, 129, 2, 28, 124, 128, 129, 2, 27, 124, 129, 128, 2, 28, 124, 129, 128, 1, -1, -1, -1, -1, -1, 1, 27, 125, 128, 127);
        this.AddMixin(false, 0, 2, 27, 125, 127, 128, 2, 28, 125, 127, 128, 0, 61, 0, 0, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 127, 130, 2, 28, 123, 127, 130, 2, 27, 123, 130, 127, 2, 28, 123, 130, 127, 1, -1, -1, -1, -1, -1, 0, 27, 125, 127, 128);
        this.AddMixin(false, 0, 2, 27, 124, 127, 130, 2, 28, 124, 127, 130, 2, 27, 124, 130, 127, 2, 28, 124, 130, 127, 1, -1, -1, -1, -1, -1, 0, 27, 125, 127, 128);
        this.AddMixin(false, 0, 2, 27, 123, 127, 131, 2, 28, 123, 127, 131, 1, -1, -1, -1, -1, -1, 3, 10, 78, -1, -1);
        this.AddMixin(false, 0, 2, 27, 124, 127, 131, 2, 28, 124, 127, 131, 1, -1, -1, -1, -1, -1, 3, 10, 78, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 128, 131, 2, 28, 123, 128, 131, 1, -1, -1, -1, -1, -1, 3, 10, 78, -1, -1);
        this.AddMixin(false, 0, 2, 27, 124, 128, 131, 2, 28, 124, 128, 131, 1, -1, -1, -1, -1, -1, 3, 10, 78, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 131, 127, 2, 28, 123, 131, 127, 1, -1, -1, -1, -1, -1, 3, 10, 78, -1, -1);
        this.AddMixin(false, 0, 2, 27, 124, 131, 127, 2, 28, 124, 131, 127, 1, -1, -1, -1, -1, -1, 3, 10, 78, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 131, 128, 2, 28, 123, 131, 128, 1, -1, -1, -1, -1, -1, 3, 10, 78, -1, -1);
        this.AddMixin(false, 0, 2, 27, 124, 131, 128, 2, 28, 124, 131, 128, 1, -1, -1, -1, -1, -1, 3, 10, 78, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 131, 132, 2, 28, 123, 131, 132, 2, 27, 124, 131, 132, 2, 28, 124, 131, 132, 1, -1, -1, -1, -1, -1, 3, 10, 78, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 127, 132, 2, 28, 123, 127, 132, 1, -1, -1, -1, -1, -1, 3, 10, 79, -1, -1);
        this.AddMixin(false, 0, 2, 27, 124, 127, 132, 2, 28, 124, 127, 132, 1, -1, -1, -1, -1, -1, 3, 10, 79, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 128, 132, 2, 28, 123, 128, 132, 1, -1, -1, -1, -1, -1, 3, 10, 79, -1, -1);
        this.AddMixin(false, 0, 2, 27, 124, 128, 132, 2, 28, 124, 128, 132, 1, -1, -1, -1, -1, -1, 3, 10, 79, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 132, 127, 2, 28, 123, 132, 127, 1, -1, -1, -1, -1, -1, 3, 10, 79, -1, -1);
        this.AddMixin(false, 0, 2, 27, 124, 132, 127, 2, 28, 124, 132, 127, 1, -1, -1, -1, -1, -1, 3, 10, 79, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 132, 128, 2, 28, 123, 132, 128, 1, -1, -1, -1, -1, -1, 3, 10, 79, -1, -1);
        this.AddMixin(false, 0, 2, 27, 124, 132, 128, 2, 28, 124, 132, 128, 1, -1, -1, -1, -1, -1, 3, 10, 79, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 132, 131, 2, 28, 123, 132, 131, 2, 27, 124, 132, 131, 2, 28, 124, 132, 131, 1, -1, -1, -1, -1, -1, 3, 10, 79, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 127, 128, 2, 28, 123, 127, 128, 2, 27, 124, 127, 128, 2, 28, 124, 127, 128, 0, 61, 2, 1, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 128, 127, 2, 28, 123, 128, 127, 2, 27, 124, 128, 127, 2, 28, 124, 128, 127, 0, 61, 2, 1, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 28, 123, 128, 130, 2, 27, 124, 128, 130, 2, 28, 123, 130, 128, 2, 27, 124, 130, 128, 4, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 128, 130, 2, 28, 124, 128, 130, 2, 27, 123, 130, 128, 2, 28, 124, 130, 128, 4, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 27, 123, 132, 129, 4, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 71, -1, -1, 3, 10, 61, -1, -1, 0, 61, 1, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 71, -1, -1, 0, 61, 2, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 72, -1, -1, 0, 61, 0, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 72, -1, -1, 0, 61, 2, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 73, -1, -1, 0, 61, 0, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 73, -1, -1, 0, 61, 1, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 74, -1, -1, 1, -1, -1, -1, -1, -1, 2, 23, 113, -1, -1);
        this.AddMixin(false, 0, 3, 10, 75, -1, -1, 0, 61, 0, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 75, -1, -1, 0, 61, 1, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 96, -1, -1, 0, 61, 2, 5, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 3, 10, 97, -1, -1, 3, 10, 80, -1, -1, 3, 10, 92, -1, -1, 3, 10, 95, -1, -1, 0, 60, 0, 4, 5, 1, -1, -1, -1, -1, -1);
        this.AddMixin(true, 0, 3, 10, 97, -1, -1, 3, 10, 80, -1, -1, 3, 10, 93, -1, -1, 3, 10, 60, -1, -1, 0, 60, 1, 4, 4, 1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 90, -1, -1, 0, 60, 0, 5, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 91, -1, -1, 0, 60, 1, 5, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 88, -1, -1, 3, 10, 59, -1, -1, 0, 59, 0, 4, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 98, -1, -1, 0, 59, 0, 4, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 76, -1, -1, 0, 61, 2, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 77, -1, -1, 0, 59, 2, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 78, -1, -1, 0, 59, 2, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 78, -1, -1, 0, 60, 0, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 79, -1, -1, 3, 10, 99, -1, -1, 0, 60, 2, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 16, -1, -1, -1, 0, 17, -1, -1, -1, 0, 22, -1, -1, -1, 0, 19, -1, -1, -1, 4, -1, -1, 8, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 20, -1, -1, -1, 0, 21, -1, -1, -1, 0, 29, -1, -1, -1, 1, -1, -1, -1, -1, -1, 0, 16, -1, -1, -1);
        this.AddMixin(false, 0, 1, 16, -1, -1, -1, 1, 17, -1, -1, -1, 1, 22, -1, -1, -1, 1, 19, -1, -1, -1, 4, -1, -1, 9, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 20, -1, -1, -1, 1, 21, -1, -1, -1, 1, 29, -1, -1, -1, 1, -1, -1, -1, -1, -1, 1, 16, -1, -1, -1);
        this.AddMixin(false, 0, 0, 11, -1, -1, -1, 0, 13, -1, -1, -1, 4, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 11, -1, -1, -1, 1, 13, -1, -1, -1, 4, -1, -1, 7, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 0, 12, -1, -1, -1, 4, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 1, 12, -1, -1, -1, 4, -1, -1, 11, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 15, -1, -1, -1, 4, -1, -1, 12, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 3, 10, 87, -1, -1, 3, 10, 86, -1, -1, 4, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, 2, 14, -1, -1, -1, 2, 18, -1, -1, -1, 2, 34, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 0, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 1, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 2, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 3, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 6, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 7, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 8, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 9, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 11, -1, -1, -1, -1, -1, -1, -1);
        this.AddMixin(false, 0, -1, -1, -1, -1, -1, 5, -1, -1, 12, -1, -1, -1, -1, -1, -1, -1);
        this.AddStaging(69.0f, -389.0f, 84.0f, -124.0f, -209.0f, 332.0f);
        this.AddStaging(-134.0f, -349.0f, 12.0f, 144.0f, -180.0f, 166.0f);
        this.AddStaging(19.0f, -455.0f, 68.0f, 103.0f, -228.0f, 204.0f);
        this.AddStaging(30.0f, -472.0f, 60.0f, -135.0f, -290.0f, 276.0f);
    }
    
    public void TestTherapyGamePermutations() {
        StringUtil.println("### TestTherapyGamePermutations testing Explain, Advice");
        for (int i = 23; i <= 26; ++i) {
            for (int j = 100; j <= 122; ++j) {
                for (int k = 59; k <= 61; ++k) {
                    for (int l = 0; l <= 1; ++l) {
                        for (int n = 0; n <= 2; ++n) {
                            final int doesMixinExist = this.DoesMixinExist(l, i, j, -1, -1, 0, k, n);
                            if (doesMixinExist != -1) {
                                StringUtil.println("### TGM " + doesMixinExist + " exists: who " + l + " daType " + i + " param " + j + " storyTopic " + k + " charFocus " + n);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void AddStaging(final float graceX, final float graceZ, final float graceRot, final float tripX, final float tripZ, final float tripRot) {
        final TherapyGameStaging therapyGameStaging = new TherapyGameStaging();
        therapyGameStaging.graceX = graceX;
        therapyGameStaging.graceZ = graceZ;
        therapyGameStaging.graceRot = graceRot;
        therapyGameStaging.tripX = tripX;
        therapyGameStaging.tripZ = tripZ;
        therapyGameStaging.tripRot = tripRot;
        TherapyGameState.stagingList.add(therapyGameStaging);
    }
    
    public int ChooseStaging() {
        boolean b = false;
        for (int i = 0; i < TherapyGameState.stagingList.size(); ++i) {
            if (!((TherapyGameStaging)TherapyGameState.stagingList.get(i)).bUsed) {
                b = true;
            }
        }
        if (!b) {
            for (int j = 0; j < TherapyGameState.stagingList.size(); ++j) {
                ((TherapyGameStaging)TherapyGameState.stagingList.get(j)).bUsed = false;
            }
        }
        TherapyGameState.currentStagingID = -1;
        for (int n = 0; n < 100 && TherapyGameState.currentStagingID == -1; ++n) {
            final int nextInt = TherapyGameState.randGen.nextInt(TherapyGameState.stagingList.size());
            if (!((TherapyGameStaging)TherapyGameState.stagingList.get(nextInt)).bUsed) {
                TherapyGameState.currentStagingID = nextInt;
            }
        }
        if (TherapyGameState.currentStagingID == -1) {
            TherapyGameState.currentStagingID = 0;
        }
        return this.UpdateStagingVariables();
    }
    
    public int UpdateStagingVariables() {
        int n = 0;
        int n2 = -1;
        final float n3 = 0.3f;
        final float n4 = 0.2f;
        if (TherapyGameState.currentStoryTopic == 59 && TherapyGameState.currentCharFocus == 0) {
            n = TherapyGameState.calculusScore_AA_G;
            n2 = 0;
        }
        if (TherapyGameState.currentStoryTopic == 59 && TherapyGameState.currentCharFocus == 1) {
            n = TherapyGameState.calculusScore_AA_T;
            n2 = 1;
        }
        if (TherapyGameState.currentStoryTopic == 59 && TherapyGameState.currentCharFocus == 2) {
            n = TherapyGameState.calculusScore_AA_R;
            n2 = 2;
        }
        if (TherapyGameState.currentStoryTopic == 60 && TherapyGameState.currentCharFocus == 0) {
            n = TherapyGameState.calculusScore_F_G;
            n2 = 0;
        }
        if (TherapyGameState.currentStoryTopic == 60 && TherapyGameState.currentCharFocus == 1) {
            n = TherapyGameState.calculusScore_F_T;
            n2 = 1;
        }
        if (TherapyGameState.currentStoryTopic == 60 && TherapyGameState.currentCharFocus == 2) {
            n = TherapyGameState.calculusScore_F_R;
            n2 = 2;
        }
        if (TherapyGameState.currentStoryTopic == 61 && TherapyGameState.currentCharFocus == 0) {
            n = TherapyGameState.calculusScore_RM_G;
            n2 = 0;
        }
        if (TherapyGameState.currentStoryTopic == 61 && TherapyGameState.currentCharFocus == 1) {
            n = TherapyGameState.calculusScore_RM_T;
            n2 = 1;
        }
        if (TherapyGameState.currentStoryTopic == 61 && TherapyGameState.currentCharFocus == 2) {
            n = TherapyGameState.calculusScore_RM_R;
            n2 = 2;
        }
        float n5 = n / (float)4;
        if (n5 < 0.0f) {
            n5 = 0.0f;
        }
        if (n5 > 1.0f) {
            n5 = 1.0f;
        }
        final TherapyGameStaging therapyGameStaging = TherapyGameState.stagingList.get(TherapyGameState.currentStagingID);
        TherapyGameState.curGraceX = therapyGameStaging.graceX;
        TherapyGameState.curGraceZ = therapyGameStaging.graceZ;
        TherapyGameState.curGraceRot = therapyGameStaging.graceRot;
        TherapyGameState.curTripX = therapyGameStaging.tripX;
        TherapyGameState.curTripZ = therapyGameStaging.tripZ;
        TherapyGameState.curTripRot = therapyGameStaging.tripRot;
        if (n2 == 0) {
            final float graceX = therapyGameStaging.graceX;
            final float graceZ = therapyGameStaging.graceZ;
            final float n6 = therapyGameStaging.graceX + (therapyGameStaging.tripX - therapyGameStaging.graceX) * n3;
            final float n7 = therapyGameStaging.graceZ + (therapyGameStaging.tripZ - therapyGameStaging.graceZ) * n3;
            TherapyGameState.curGraceX = graceX + (n6 - graceX) * n5;
            TherapyGameState.curGraceZ = graceZ + (n7 - graceZ) * n5;
        }
        else if (n2 == 1) {
            final float tripX = therapyGameStaging.tripX;
            final float tripZ = therapyGameStaging.tripZ;
            final float n8 = therapyGameStaging.tripX + (therapyGameStaging.graceX - therapyGameStaging.tripX) * n3;
            final float n9 = therapyGameStaging.tripZ + (therapyGameStaging.graceZ - therapyGameStaging.tripZ) * n3;
            TherapyGameState.curTripX = tripX + (n8 - tripX) * n5;
            TherapyGameState.curTripZ = tripZ + (n9 - tripZ) * n5;
        }
        else if (n2 == 2) {
            final float graceX2 = therapyGameStaging.graceX;
            final float graceZ2 = therapyGameStaging.graceZ;
            final float n10 = therapyGameStaging.graceX + (therapyGameStaging.tripX - therapyGameStaging.graceX) * n4;
            final float n11 = therapyGameStaging.graceZ + (therapyGameStaging.tripZ - therapyGameStaging.graceZ) * n4;
            TherapyGameState.curGraceX = graceX2 + (n10 - graceX2) * n5;
            TherapyGameState.curGraceZ = graceZ2 + (n11 - graceZ2) * n5;
            final float tripX2 = therapyGameStaging.tripX;
            final float tripZ2 = therapyGameStaging.tripZ;
            final float n12 = therapyGameStaging.tripX + (therapyGameStaging.graceX - therapyGameStaging.tripX) * n4;
            final float n13 = therapyGameStaging.tripZ + (therapyGameStaging.graceZ - therapyGameStaging.tripZ) * n4;
            TherapyGameState.curTripX = tripX2 + (n12 - tripX2) * n5;
            TherapyGameState.curTripZ = tripZ2 + (n13 - tripZ2) * n5;
        }
        return TherapyGameState.currentStagingID;
    }
    
    public void SetCurrentTherapyGameMood(final int currentMood) {
        TherapyGameState.currentMood = currentMood;
        if (TherapyGameState.bMixinCausedByPlayer) {
            TherapyGameState.currentMoodCause = 2;
        }
        else {
            TherapyGameState.currentMoodCause = -1;
        }
        if (currentMood == 2 || currentMood == 6 || currentMood == 1 || currentMood == 5) {
            TherapyGameState.strongMoodDialogStage = 0;
        }
    }
    
    public void InitRevBuildup(final IntegerRef integerRef, final IntegerRef integerRef2, final IntegerRef integerRef3, final IntegerRef integerRef4, final IntegerRef integerRef5, final IntegerRef integerRef6, final IntegerRef integerRef7, final IntegerRef integerRef8, final IntegerRef integerRef9, final IntegerRef integerRef10, final IntegerRef integerRef11, final IntegerRef integerRef12) {
        int i = -1;
        int j = -1;
        int k = -1;
        int l = -1;
        int m = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        boolean b = false;
        int n = 0;
        int n2 = -1;
        int n3 = -1;
        int n4 = -1;
        boolean b2 = false;
        int n5 = 0;
        int n6 = -1;
        int n7 = -1;
        int n8 = -1;
        boolean b3 = false;
        int n9 = 0;
        int n10 = -1;
        int n11 = -1;
        int n12 = -1;
        int n13 = 0;
        if (TherapyGameState.calculusScore_AA_G + TherapyGameState.calculusScore_F_G + TherapyGameState.calculusScore_RM_G >= TherapyGameState.calculusScoreThreshold) {
            b = true;
            ++n13;
        }
        if (TherapyGameState.calculusScore_AA_T + TherapyGameState.calculusScore_F_T + TherapyGameState.calculusScore_RM_T >= TherapyGameState.calculusScoreThreshold) {
            b2 = true;
            ++n13;
        }
        if (TherapyGameState.calculusScore_AA_R + TherapyGameState.calculusScore_F_R + TherapyGameState.calculusScore_RM_R >= TherapyGameState.calculusScoreThreshold) {
            b3 = true;
            ++n13;
        }
        StringUtil.println("## ");
        StringUtil.println("## InitRevBuildup");
        StringUtil.println("## numRevThresholdsReached " + n13);
        if (b && TherapyGameState.calculusScore_AA_G > n) {
            n = TherapyGameState.calculusScore_AA_G;
            n3 = 59;
            n2 = 0;
            n4 = TherapyGameState.calculusScoreWhenCtr_AA_G;
            StringUtil.println("calculusScore_AA_G is currently chosen, score " + n);
        }
        if (b && TherapyGameState.calculusScore_F_G > n) {
            n = TherapyGameState.calculusScore_F_G;
            n3 = 60;
            n2 = 0;
            n4 = TherapyGameState.calculusScoreWhenCtr_F_G;
            StringUtil.println("calculusScore_F_G is currently chosen, score " + n);
        }
        if (b && TherapyGameState.calculusScore_RM_G > n) {
            final int calculusScore_RM_G = TherapyGameState.calculusScore_RM_G;
            n3 = 61;
            n2 = 0;
            n4 = TherapyGameState.calculusScoreWhenCtr_RM_G;
            StringUtil.println("calculusScore_RM_G is currently chosen, score " + calculusScore_RM_G);
        }
        if (b2 && TherapyGameState.calculusScore_AA_T > n5) {
            n5 = TherapyGameState.calculusScore_AA_T;
            n7 = 59;
            n6 = 1;
            n8 = TherapyGameState.calculusScoreWhenCtr_AA_T;
            StringUtil.println("calculusScore_AA_T is currently chosen, score " + n5);
        }
        if (b2 && TherapyGameState.calculusScore_F_T > n5) {
            n5 = TherapyGameState.calculusScore_F_T;
            n7 = 60;
            n6 = 1;
            n8 = TherapyGameState.calculusScoreWhenCtr_F_T;
            StringUtil.println("calculusScore_F_T is currently chosen, score " + n5);
        }
        if (b2 && TherapyGameState.calculusScore_RM_T > n5) {
            final int calculusScore_RM_T = TherapyGameState.calculusScore_RM_T;
            n7 = 61;
            n6 = 1;
            n8 = TherapyGameState.calculusScoreWhenCtr_RM_T;
            StringUtil.println("calculusScore_RM_T is currently chosen, score " + calculusScore_RM_T);
        }
        if (b3 && TherapyGameState.calculusScore_AA_R > n9) {
            n9 = TherapyGameState.calculusScore_AA_R;
            n11 = 59;
            n10 = 0;
            n12 = TherapyGameState.calculusScoreWhenCtr_AA_R;
            StringUtil.println("calculusScore_AA_R is currently chosen, score " + n9);
        }
        if (b3 && TherapyGameState.calculusScore_F_R > n9) {
            n9 = TherapyGameState.calculusScore_F_R;
            n11 = 60;
            n10 = 1;
            n12 = TherapyGameState.calculusScoreWhenCtr_F_R;
            StringUtil.println("calculusScore_F_R is currently chosen, score " + n9);
        }
        if (b3 && TherapyGameState.calculusScore_RM_R > n9) {
            final int calculusScore_RM_R = TherapyGameState.calculusScore_RM_R;
            n11 = 61;
            n10 = 1;
            n12 = TherapyGameState.calculusScoreWhenCtr_RM_R;
            StringUtil.println("calculusScore_RM_R is currently chosen, score " + calculusScore_RM_R);
        }
        if (n13 <= 0) {
            if (TherapyGameState.randGen.nextInt(2) == 0) {
                i = 0;
            }
            else {
                i = 1;
            }
        }
        else {
            if (!TherapyGameState.$noassert && n2 == -1 && n6 == -1 && n10 == -1) {
                throw new AssertionError();
            }
            if (n2 != -1) {
                i = n2;
                j = n3;
                k = 0;
                l = n4;
                StringUtil.println("G currently rev1");
            }
            if (n6 != -1) {
                if (i == -1) {
                    i = n6;
                    j = n7;
                    k = 1;
                    l = n8;
                    StringUtil.println("T currently rev1");
                }
                else {
                    m = n6;
                    i2 = n7;
                    i3 = 1;
                    i4 = n8;
                    StringUtil.println("T currently rev2");
                }
            }
            if (n10 != -1) {
                if (i == -1) {
                    i = n10;
                    j = n11;
                    k = 2;
                    l = n12;
                    StringUtil.println("R currently rev1");
                }
                else if (m == -1) {
                    m = n10;
                    i2 = n11;
                    i3 = 2;
                    i4 = n12;
                    StringUtil.println("R currently rev2");
                }
                else {
                    i5 = n10;
                    i6 = n11;
                    i7 = 2;
                    i8 = n12;
                    StringUtil.println("R currently rev3");
                }
            }
        }
        if (m != -1 && i4 > l) {
            final int n14 = i;
            i = m;
            m = n14;
            final int n15 = j;
            j = i2;
            i2 = n15;
            final int n16 = k;
            k = i3;
            i3 = n16;
            final int n17 = l;
            l = i4;
            i4 = n17;
            StringUtil.println("swap rev1 and 2");
        }
        if (i5 != -1 && i8 > l) {
            final int n18 = i;
            i = i5;
            i5 = n18;
            final int n19 = j;
            j = i6;
            i6 = n19;
            final int n20 = k;
            k = i7;
            i7 = n20;
            final int n21 = l;
            l = i8;
            i8 = n21;
            StringUtil.println("then swap rev1 and 3");
        }
        if (i5 != -1 && (k == 0 || i3 == 0 || i7 == 0) && (k == 1 || i3 == 1 || i7 == 1) && i == m) {
            final int n22 = m;
            m = i5;
            i5 = n22;
            final int n23 = i2;
            i2 = i6;
            i6 = n23;
            final int n24 = i3;
            i3 = i7;
            i7 = n24;
            final int n25 = i4;
            i4 = i8;
            i8 = n25;
            StringUtil.println("then swap rev2 and 3");
        }
        integerRef.i = i;
        integerRef2.i = j;
        integerRef3.i = k;
        integerRef4.i = l;
        integerRef5.i = m;
        integerRef6.i = i2;
        integerRef7.i = i3;
        integerRef8.i = i4;
        integerRef9.i = i5;
        integerRef10.i = i6;
        integerRef11.i = i7;
        integerRef12.i = i8;
        StringUtil.println("## rev1 who " + i + " topic " + j + " charFocus " + k + " whenCtr " + l);
        StringUtil.println("## rev2 who " + m + " topic " + i2 + " charFocus " + i3 + " whenCtr " + i4);
        StringUtil.println("## rev3 who " + i5 + " topic " + i6 + " charFocus " + i7 + " whenCtr " + i8);
        StringUtil.println("## ");
    }
    
    public boolean PossibleManualHackMapping(final int n, final int n2, final int n3, final int n4, final int n5, final IntegerRef integerRef, final IntegerRef integerRef2, final IntegerRef integerRef3, final IntegerRef integerRef4, final IntegerRef integerRef5) {
        if (n2 == 26 && (n == 0 || n == 1) && (n3 == 102 || n3 == 103 || n3 == 106)) {
            StringUtil.println("## hack map grace should not be loving, etc. to grace advice controlling");
            integerRef.i = 0;
            integerRef2.i = 25;
            integerRef3.i = 100;
            integerRef4.i = -1;
            integerRef5.i = -1;
            return true;
        }
        if (n2 == 25 && (n == 0 || n == 1) && (n3 == 104 || n3 == 105 || n3 == 107)) {
            StringUtil.println("## hack map grace should be depressing, etc. to grace advice controlling");
            integerRef.i = 0;
            integerRef2.i = 25;
            integerRef3.i = 100;
            integerRef4.i = -1;
            integerRef5.i = -1;
            return true;
        }
        if ((n == 0 || n == 1) && (n3 == 119 || n3 == 120 || n3 == 121)) {
            StringUtil.println("## hack map kill, etc. to grace advice controlling");
            integerRef.i = 0;
            integerRef2.i = 25;
            integerRef3.i = 100;
            integerRef4.i = -1;
            integerRef5.i = -1;
            return true;
        }
        if (n2 != 27 && n2 != 28) {
            return false;
        }
        if (n3 == 125 && (n4 != 127 || n5 != 128) && (n4 != 128 || n5 != 127)) {
            StringUtil.println("## hack map cheating to trip loves vince");
            integerRef.i = n;
            integerRef2.i = 27;
            integerRef3.i = 123;
            integerRef4.i = 128;
            integerRef5.i = 130;
            return true;
        }
        if ((n4 != 128 || n5 != 129) && (n4 != 129 || n5 != 128) && (n4 != 127 || n5 != 130) && (n4 != 130 || n5 != 127) && (n4 != 127 || n5 != 131) && (n4 != 131 || n5 != 127) && (n4 != 128 || n5 != 132) && (n4 != 132 || n5 != 128) && (n4 != 127 || n5 != 128) && (n4 != 128 || n5 != 127) && (n4 != 128 || n5 != 130) && (n4 != 130 || n5 != 128)) {
            StringUtil.println("## hack map to tripsparents loves maria");
            integerRef.i = n;
            integerRef2.i = 27;
            integerRef3.i = 123;
            integerRef4.i = 132;
            integerRef5.i = 129;
            return true;
        }
        return false;
    }
    
    public TherapyGameState() {
        TherapyGameState.state = this;
    }
    
    static {
        $noassert = (Class.forName("[Lfacade.util.TherapyGameState;").getComponentType().desiredAssertionStatus() ^ true);
        TherapyGameState.maxNumMixinsTimeout = 25;
        TherapyGameState.minNumMixinsTimeout = 17;
        TherapyGameState.noScoreStretchEarlyEnd = 6;
        TherapyGameState.calculusScoreThreshold = 1;
        TherapyGameState.initialAccuser = -1;
        TherapyGameState.currentMixinID = -1;
        TherapyGameState.currentMixinType = -1;
        TherapyGameState.prevMixinType = -1;
        TherapyGameState.currentMixinDAType = -1;
        TherapyGameState.bMixinCausedByPlayer = false;
        TherapyGameState.currentStoryTopic = 58;
        TherapyGameState.currentCharFocus = -1;
        TherapyGameState.previousStoryTopic = 58;
        TherapyGameState.previousCharFocus = -1;
        TherapyGameState.bVeryBeginningOfNewMixin = false;
        TherapyGameState.currentMixinTestBeganMillis = -1;
        TherapyGameState.bSignaledNewCharFocus = false;
        TherapyGameState.bSignaledNewMixinScoreIncrease = false;
        TherapyGameState.signalNewCharFocusWho = -1;
        TherapyGameState.bChangedCharFocus = false;
        TherapyGameState.newMixinScoreIncreaseWho = -1;
        TherapyGameState.numSignalsPlayed = 0;
        TherapyGameState.numNewMixinsSinceSwitch = 0;
        TherapyGameState.previousPlayerStandPositionCharFocus = -1;
        TherapyGameState.currentMood = -1;
        TherapyGameState.currentMoodCause = -1;
        TherapyGameState.currentPastPresent = -1;
        TherapyGameState.numMixinsPlayed = 0;
        TherapyGameState.numTestMixinsPlayed = 0;
        TherapyGameState.numCajolesPlayed = 0;
        TherapyGameState.numLeaveRoomCajolesPlayed = 0;
        TherapyGameState.cajoleCharFocus = -1;
        TherapyGameState.cajolePrevCharFocus = -1;
        TherapyGameState.cajoleSpeaker = -1;
        TherapyGameState.bCajoleToChangePosition = false;
        TherapyGameState.strongMoodDialogStage = -1;
        TherapyGameState.currentPostAskPlayer = -1;
        TherapyGameState.lastTimeDidAskPlayer = -1;
        TherapyGameState.numTimesScoreChanged = 0;
        TherapyGameState.lastTimeScoreChanged = 0;
        TherapyGameState.currentStagingID = -1;
        TherapyGameState.curGraceX = 0.0f;
        TherapyGameState.curGraceZ = 0.0f;
        TherapyGameState.curGraceRot = 0.0f;
        TherapyGameState.curTripX = 0.0f;
        TherapyGameState.curTripZ = 0.0f;
        TherapyGameState.curTripRot = 0.0f;
        TherapyGameState.calculusScore_AA_G = 0;
        TherapyGameState.calculusScore_AA_T = 0;
        TherapyGameState.calculusScore_AA_R = 0;
        TherapyGameState.calculusScore_F_G = 0;
        TherapyGameState.calculusScore_F_T = 0;
        TherapyGameState.calculusScore_F_R = 0;
        TherapyGameState.calculusScore_RM_G = 0;
        TherapyGameState.calculusScore_RM_T = 0;
        TherapyGameState.calculusScore_RM_R = 0;
        TherapyGameState.calculusScoreWhenCtr_AA_G = -1;
        TherapyGameState.calculusScoreWhenCtr_AA_T = -1;
        TherapyGameState.calculusScoreWhenCtr_AA_R = -1;
        TherapyGameState.calculusScoreWhenCtr_F_G = -1;
        TherapyGameState.calculusScoreWhenCtr_F_T = -1;
        TherapyGameState.calculusScoreWhenCtr_F_R = -1;
        TherapyGameState.calculusScoreWhenCtr_RM_G = -1;
        TherapyGameState.calculusScoreWhenCtr_RM_T = -1;
        TherapyGameState.calculusScoreWhenCtr_RM_R = -1;
        TherapyGameState.bDidRevelationOutburst_AA_G = false;
        TherapyGameState.bDidRevelationOutburst_AA_T = false;
        TherapyGameState.bDidRevelationOutburst_AA_R = false;
        TherapyGameState.bDidRevelationOutburst_F_G = false;
        TherapyGameState.bDidRevelationOutburst_F_T = false;
        TherapyGameState.bDidRevelationOutburst_F_R = false;
        TherapyGameState.bDidRevelationOutburst_RM_G = false;
        TherapyGameState.bDidRevelationOutburst_RM_T = false;
        TherapyGameState.bDidRevelationOutburst_RM_R = false;
        TherapyGameState.lastAccusationMillis = -1;
        TherapyGameState.timeTherapyGameBegan = -1;
        TherapyGameState.lastLeftRoomCajoleMillis = -1;
        TherapyGameState.bPlayerInitiallyInKitchen = false;
        randGen = new Random();
        TherapyGameState.mixinList = new LinkedList();
        TherapyGameState.stagingList = new LinkedList();
    }
    
    class TherapyGameMixin
    {
        public int who_or1;
        public int daType_or1;
        public int param_or1;
        public int param2_or1;
        public int param3_or1;
        public int who_or2;
        public int daType_or2;
        public int param_or2;
        public int param2_or2;
        public int param3_or2;
        public int who_or3;
        public int daType_or3;
        public int param_or3;
        public int param2_or3;
        public int param3_or3;
        public int who_or4;
        public int daType_or4;
        public int param_or4;
        public int param2_or4;
        public int param3_or4;
        public int mixinType;
        public int storyTopic;
        public int charFocus;
        public int repeatCategory;
        public int availability;
        public boolean bFinalRxnPlayed;
        public int mood;
        public int pastPresent;
        public int redirectWho;
        public int redirectDaType;
        public int redirectParam;
        public int redirectParam2;
        public int redirectParam3;
        public boolean bAutonomouslyChoosable;
        public int scoreIncr;
        public boolean bCausedByPlayer;
        
        private final /* synthetic */ void this() {
            this.who_or1 = -1;
            this.daType_or1 = -1;
            this.param_or1 = -1;
            this.param2_or1 = -1;
            this.param3_or1 = -1;
            this.who_or2 = -1;
            this.daType_or2 = -1;
            this.param_or2 = -1;
            this.param2_or2 = -1;
            this.param3_or2 = -1;
            this.who_or3 = -1;
            this.daType_or3 = -1;
            this.param_or3 = -1;
            this.param2_or3 = -1;
            this.param3_or3 = -1;
            this.who_or4 = -1;
            this.daType_or4 = -1;
            this.param_or4 = -1;
            this.param2_or4 = -1;
            this.param3_or4 = -1;
            this.mixinType = -1;
            this.storyTopic = -1;
            this.charFocus = -1;
            this.repeatCategory = -1;
            this.availability = -1;
            this.bFinalRxnPlayed = false;
            this.mood = -1;
            this.pastPresent = -1;
            this.redirectWho = -1;
            this.redirectDaType = -1;
            this.redirectParam = -1;
            this.redirectParam2 = -1;
            this.redirectParam3 = -1;
            this.bAutonomouslyChoosable = false;
            this.scoreIncr = 0;
            this.bCausedByPlayer = false;
        }
        
        TherapyGameMixin() {
            this.this();
        }
    }
    
    class TherapyGameStaging
    {
        public float graceX;
        public float graceZ;
        public float graceRot;
        public float tripX;
        public float tripZ;
        public float tripRot;
        public boolean bUsed;
        
        private final /* synthetic */ void this() {
            this.bUsed = false;
        }
        
        TherapyGameStaging() {
            this.this();
        }
    }
}
