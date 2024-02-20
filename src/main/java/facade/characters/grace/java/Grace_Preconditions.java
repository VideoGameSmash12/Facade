package facade.characters.grace.java;

import facade.characters.wmedef.AmbSipdrinkWME;
import facade.characters.wmedef.ObjectStateWME;
import facade.characters.wmedef.BeatOneOnOneNonAffChrT2WME;
import facade.characters.wmedef.BeatOneOnOneAffChrT2WME;
import facade.characters.wmedef.BeatTAt1WME;
import facade.characters.wmedef.BeatRMp1WME;
import facade.characters.wmedef.UserTestWME;
import facade.characters.wmedef.PostBeatMixinInfoWME;
import facade.characters.wmedef.AnaphoricReferenceWME;
import facade.characters.wmedef.ArmBaseWME;
import facade.characters.wmedef.StagingInfoWME;
import facade.characters.wmedef.ObjectPickupRotationWME;
import facade.characters.wmedef.ObjectPickupPositionWME;
import facade.characters.wmedef.IsPlayerSettledWME;
import facade.characters.wmedef.ObjectRotationWME;
import facade.characters.wmedef.ConverseStagingWME;
import facade.characters.wmedef.PrevStagingInfoWME;
import facade.util.Point3D;
import facade.characters.wmedef.OneCharacterVisibleWME;
import facade.characters.wmedef.DAMiscStatusWME;
import facade.characters.wmedef.BeatGoalStatusWME;
import facade.characters.wmedef.BeatStatusWME;
import dramaman.runtime.TensionStoryValueWME;
import facade.characters.wmedef.MoodWME;
import facade.characters.wmedef.PlayerRecentlyTypedTextWME;
import abl.runtime.BehaviorWME;
import facade.characters.wmedef.BodyResourceWME;
import abl.runtime.GoalStepWME;
import facade.characters.wmedef.SignalWME;
import facade.characters.wmedef.DeflectModeWME;
import facade.characters.wmedef.PlayerInfoWME;
import facade.characters.wmedef.BeatEndingWME;
import facade.characters.wmedef.PlayerUncoopWME;
import facade.characters.wmedef.BeatRevelationsP2WME;
import facade.util.TherapyGameState;
import facade.util.Staging;
import facade.characters.wmedef.BeatC2TGGlueWME;
import facade.characters.wmedef.BeatCrisisP1WME;
import facade.characters.wmedef.BeatRomPrpWME;
import facade.characters.wmedef.BeatFAskDrinkT2WME;
import java.util.ListIterator;
import abl.runtime.AblRuntimeError;
import facade.characters.wmedef.BeatArgumentWME;
import facade.characters.wmedef.AmbFixdrinkWME;
import facade.characters.wmedef.BeatFAskDrinkT1WME;
import facade.characters.wmedef.HeldObjectWME;
import abl.runtime.ObjectWrapper;
import facade.characters.wmedef.BeatAAp1WME;
import dramaman.runtime.BeatAbortWME;
import dramaman.runtime.BeatCompletedWME;
import facade.characters.wmedef.ObjectPositionWME;
import facade.characters.wmedef.BeatFlagWME;
import dramaman.runtime.StoryStatusWME;
import wm.WorkingMemory;
import abl.runtime.BehavingEntity;
import java.util.Hashtable;
import facade.util.MusicDefs;
import facade.util.TherapyGameConstants;
import facade.util.CrisisAccusations;
import facade.util.BackstoryCategories;
import facade.util.EpisodicMemoryConstants;
import facade.util.BeatID;
import facade.util.BeatArguments;
import dramaman.runtime.DramaManagerConstants;
import facade.util.UniversalScript;
import facade.util.ReactionID;
import facade.util.DAType;
import facade.util.ReactionConstants;
import facade.util.BeatConstants;
import facade.util.BeatStatus;
import facade.util.BodyResource;
import facade.util.GestureBodyPart;
import facade.util.PoseScripts;
import facade.util.SpriteID;
import facade.util.FullExpressions;
import facade.util.AnimLayer;
import facade.util.TripScript;
import facade.util.GraceScript;

public class Grace_Preconditions implements GraceScript, TripScript, AnimLayer, FullExpressions, SpriteID, PoseScripts, GestureBodyPart, BodyResource, BeatStatus, BeatConstants, ReactionConstants, DAType, ReactionID, UniversalScript, DramaManagerConstants, BeatArguments, BeatID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, TherapyGameConstants, MusicDefs
{
    public static boolean precondition0(final int n, final Object[] array, final Hashtable hashtable, final BehavingEntity behavingEntity) {
        switch (n) {
            case 0: {
                final ListIterator listIterator = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator.hasNext()) {
                    if (listIterator.next().getCurrentBeat() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 1: {
                return (int)array[0] == 0;
            }
            case 3: {
                return (int)array[0] == 1;
            }
            case 8: {
                final ListIterator listIterator2 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getCurrentBeat() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 32: {
                final ListIterator listIterator3 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator3.hasNext()) {
                    if (listIterator3.next().getCurrentBeat() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 36: {
                final ListIterator listIterator4 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator4.hasNext()) {
                    if (listIterator4.next().getSVal().equals("bTFetchesGT1_playerApproachingKitchen")) {
                        return true;
                    }
                }
                return false;
            }
            case 38: {
                final ListIterator listIterator5 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator5.hasNext()) {
                    if (listIterator5.next().getCurrentBeat() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 67: {
                final ListIterator listIterator6 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator6.hasNext()) {
                    if (listIterator6.next().getSVal().equals("bGGreetsPT1_PraisedPlayer")) {
                        return false;
                    }
                }
                return true;
            }
            case 141: {
                return !((Grace)behavingEntity).gBeatTempBool;
            }
            case 142: {
                return !((Grace)behavingEntity).gBeatTempBool;
            }
            case 143: {
                return ((Grace)behavingEntity).gBeatTempBool;
            }
            case 144: {
                return ((Grace)behavingEntity).gBeatTempBool;
            }
            case 149: {
                return !((Grace)behavingEntity).gBeatTempBool;
            }
            case 150: {
                return !((Grace)behavingEntity).gBeatTempBool;
            }
            case 151: {
                return !((Grace)behavingEntity).gBeatTempBool;
            }
            case 152: {
                return ((Grace)behavingEntity).gBeatTempBool;
            }
            case 153: {
                return ((Grace)behavingEntity).gBeatTempBool;
            }
            case 154: {
                return ((Grace)behavingEntity).gBeatTempBool;
            }
            case 159: {
                return !((Grace)behavingEntity).gBeatTempBool;
            }
            case 160: {
                return !((Grace)behavingEntity).gBeatTempBool;
            }
            case 161: {
                return ((Grace)behavingEntity).gBeatTempBool;
            }
            case 162: {
                return ((Grace)behavingEntity).gBeatTempBool;
            }
            case 170: {
                final ListIterator listIterator7 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator7.hasNext()) {
                    final ObjectPositionWME objectPositionWME = listIterator7.next();
                    final float x;
                    final float z;
                    if (objectPositionWME.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x = objectPositionWME.getX()) && BehavingEntity.constantTrue(z = objectPositionWME.getZ())) {
                        final ListIterator listIterator8 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator8.hasNext()) {
                            final ObjectPositionWME objectPositionWME2 = listIterator8.next();
                            final float x2;
                            final float z2;
                            if (objectPositionWME2.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x2 = objectPositionWME2.getX()) && BehavingEntity.constantTrue(z2 = objectPositionWME2.getZ())) {
                                hashtable.put("playerX", new Float(x2));
                                hashtable.put("myX", new Float(x));
                                hashtable.put("playerZ", new Float(z2));
                                hashtable.put("myZ", new Float(z));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 171: {
                final ListIterator listIterator9 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator9.hasNext()) {
                    if (listIterator9.next().getCurrentBeat() == 4) {
                        return true;
                    }
                }
                return false;
            }
            case 238: {
                final ListIterator listIterator10 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator10.hasNext()) {
                    if (listIterator10.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 239: {
                final ListIterator listIterator11 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator11.hasNext()) {
                    if (listIterator11.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 254: {
                final ListIterator listIterator12 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator12.hasNext()) {
                    if (listIterator12.next().getCurrentBeat() == 5) {
                        return true;
                    }
                }
                return false;
            }
            case 258: {
                final ListIterator listIterator13 = WorkingMemory.lookupWME("StoryMemory", "BeatCompletedWME").listIterator();
                while (listIterator13.hasNext()) {
                    final BeatCompletedWME beatCompletedWME = listIterator13.next();
                    if (beatCompletedWME.getBeatID() >= 9 && beatCompletedWME.getBeatID() <= 11) {
                        return false;
                    }
                }
                final ListIterator listIterator14 = WorkingMemory.lookupWME("StoryMemory", "BeatAbortWME").listIterator();
                while (listIterator14.hasNext()) {
                    final BeatAbortWME beatAbortWME = listIterator14.next();
                    if (beatAbortWME.getBeatID() >= 9 && beatAbortWME.getBeatID() <= 11) {
                        return false;
                    }
                }
                return true;
            }
            case 259: {
                final ListIterator listIterator15 = WorkingMemory.lookupWME("StoryMemory", "BeatCompletedWME").listIterator();
                while (listIterator15.hasNext()) {
                    if (listIterator15.next().getBeatID() == 4) {
                        return false;
                    }
                }
                final ListIterator listIterator16 = WorkingMemory.lookupWME("StoryMemory", "BeatAbortWME").listIterator();
                while (listIterator16.hasNext()) {
                    if (listIterator16.next().getBeatID() == 4) {
                        return false;
                    }
                }
                return true;
            }
            case 263: {
                final ListIterator listIterator17 = WorkingMemory.lookupWME("StoryMemory", "BeatCompletedWME").listIterator();
                while (listIterator17.hasNext()) {
                    final BeatCompletedWME beatCompletedWME2 = listIterator17.next();
                    if (beatCompletedWME2.getBeatID() >= 9 && beatCompletedWME2.getBeatID() <= 11) {
                        return false;
                    }
                }
                final ListIterator listIterator18 = WorkingMemory.lookupWME("StoryMemory", "BeatAbortWME").listIterator();
                while (listIterator18.hasNext()) {
                    final BeatAbortWME beatAbortWME2 = listIterator18.next();
                    if (beatAbortWME2.getBeatID() >= 9 && beatAbortWME2.getBeatID() <= 11) {
                        return false;
                    }
                }
                return true;
            }
            case 264: {
                final ListIterator listIterator19 = WorkingMemory.lookupWME("StoryMemory", "BeatCompletedWME").listIterator();
                while (listIterator19.hasNext()) {
                    if (listIterator19.next().getBeatID() == 4) {
                        return false;
                    }
                }
                final ListIterator listIterator20 = WorkingMemory.lookupWME("StoryMemory", "BeatAbortWME").listIterator();
                while (listIterator20.hasNext()) {
                    if (listIterator20.next().getBeatID() == 4) {
                        return false;
                    }
                }
                return true;
            }
            case 265: {
                final ListIterator listIterator21 = WorkingMemory.lookupWME("StoryMemory", "BeatCompletedWME").listIterator();
                while (listIterator21.hasNext()) {
                    if (listIterator21.next().getBeatID() == 4) {
                        return false;
                    }
                }
                final ListIterator listIterator22 = WorkingMemory.lookupWME("StoryMemory", "BeatAbortWME").listIterator();
                while (listIterator22.hasNext()) {
                    if (listIterator22.next().getBeatID() == 4) {
                        return false;
                    }
                }
                return true;
            }
            case 273: {
                final ListIterator listIterator23 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator23.hasNext()) {
                    final ObjectPositionWME objectPositionWME3 = listIterator23.next();
                    final float x3;
                    final float z3;
                    if (objectPositionWME3.getObjectID() == 10 && BehavingEntity.constantTrue(x3 = objectPositionWME3.getX()) && BehavingEntity.constantTrue(z3 = objectPositionWME3.getZ())) {
                        hashtable.put("phoneX", new Float(x3));
                        hashtable.put("phoneZ", new Float(z3));
                        return true;
                    }
                }
                return false;
            }
            case 279: {
                final ListIterator listIterator24 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator24.hasNext()) {
                    final ObjectPositionWME objectPositionWME4 = listIterator24.next();
                    final float x4;
                    final float z4;
                    if (objectPositionWME4.getObjectID() == 10 && BehavingEntity.constantTrue(x4 = objectPositionWME4.getX()) && BehavingEntity.constantTrue(z4 = objectPositionWME4.getZ())) {
                        hashtable.put("phoneX", new Float(x4));
                        hashtable.put("phoneZ", new Float(z4));
                        return true;
                    }
                }
                return false;
            }
            case 282: {
                return (int)array[0] == 1;
            }
            case 284: {
                return (int)array[0] == 2;
            }
            case 297: {
                final ListIterator listIterator25 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator25.hasNext()) {
                    final ObjectPositionWME objectPositionWME5 = listIterator25.next();
                    final float x5;
                    final float z5;
                    if (objectPositionWME5.getObjectID() == 10 && BehavingEntity.constantTrue(x5 = objectPositionWME5.getX()) && BehavingEntity.constantTrue(z5 = objectPositionWME5.getZ())) {
                        hashtable.put("phoneX", new Float(x5));
                        hashtable.put("phoneZ", new Float(z5));
                        return true;
                    }
                }
                return false;
            }
            case 300: {
                final ListIterator listIterator26 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator26.hasNext()) {
                    if (listIterator26.next().getSVal().equals("player picked up phone")) {
                        return true;
                    }
                }
                return false;
            }
            case 304: {
                final ListIterator listIterator27 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator27.hasNext()) {
                    if (listIterator27.next().getCurrentBeat() == 6) {
                        return true;
                    }
                }
                return false;
            }
            case 308: {
                final ListIterator listIterator28 = WorkingMemory.lookupWME("StoryMemory", "BeatCompletedWME").listIterator();
                while (listIterator28.hasNext()) {
                    final BeatCompletedWME beatCompletedWME3 = listIterator28.next();
                    if (beatCompletedWME3.getBeatID() >= 9 && beatCompletedWME3.getBeatID() <= 11) {
                        return false;
                    }
                }
                final ListIterator listIterator29 = WorkingMemory.lookupWME("StoryMemory", "BeatAbortWME").listIterator();
                while (listIterator29.hasNext()) {
                    final BeatAbortWME beatAbortWME3 = listIterator29.next();
                    if (beatAbortWME3.getBeatID() >= 9 && beatAbortWME3.getBeatID() <= 11) {
                        return false;
                    }
                }
                return true;
            }
            case 309: {
                final ListIterator listIterator30 = WorkingMemory.lookupWME("StoryMemory", "BeatCompletedWME").listIterator();
                while (listIterator30.hasNext()) {
                    if (listIterator30.next().getBeatID() == 4) {
                        return false;
                    }
                }
                final ListIterator listIterator31 = WorkingMemory.lookupWME("StoryMemory", "BeatAbortWME").listIterator();
                while (listIterator31.hasNext()) {
                    if (listIterator31.next().getBeatID() == 4) {
                        return false;
                    }
                }
                return true;
            }
            case 313: {
                final ListIterator listIterator32 = WorkingMemory.lookupWME("StoryMemory", "BeatCompletedWME").listIterator();
                while (listIterator32.hasNext()) {
                    final BeatCompletedWME beatCompletedWME4 = listIterator32.next();
                    if (beatCompletedWME4.getBeatID() >= 9 && beatCompletedWME4.getBeatID() <= 11) {
                        return false;
                    }
                }
                final ListIterator listIterator33 = WorkingMemory.lookupWME("StoryMemory", "BeatAbortWME").listIterator();
                while (listIterator33.hasNext()) {
                    final BeatAbortWME beatAbortWME4 = listIterator33.next();
                    if (beatAbortWME4.getBeatID() >= 9 && beatAbortWME4.getBeatID() <= 11) {
                        return false;
                    }
                }
                return true;
            }
            case 327: {
                return (int)array[0] == 1;
            }
            case 329: {
                return (int)array[0] == 2;
            }
            case 341: {
                final ListIterator listIterator34 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator34.hasNext()) {
                    if (listIterator34.next().getSVal().equals("player hung up phone")) {
                        return true;
                    }
                }
                return false;
            }
            case 352: {
                final ListIterator listIterator35 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator35.hasNext()) {
                    final ObjectPositionWME objectPositionWME6 = listIterator35.next();
                    if (objectPositionWME6.getObjectID() == ((Grace)behavingEntity).me && objectPositionWME6.getZ() > -160.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 355: {
                (int)array[0];
                final ListIterator listIterator36 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator36.hasNext()) {
                    final BeatAAp1WME beatAAp1WME2;
                    final BeatAAp1WME beatAAp1WME = beatAAp1WME2 = listIterator36.next();
                    final int subtopic;
                    final int subtopicObject;
                    if (BehavingEntity.constantTrue(subtopic = beatAAp1WME.getSubtopic()) && BehavingEntity.constantTrue(subtopicObject = beatAAp1WME.getSubtopicObject()) && (subtopic == 97 || subtopic == 80 || subtopic == 89 || subtopic == 88)) {
                        final ListIterator listIterator37 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator37.hasNext()) {
                            final ObjectPositionWME objectPositionWME7 = listIterator37.next();
                            final float x6;
                            final float z6;
                            if (objectPositionWME7.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x6 = objectPositionWME7.getX()) && BehavingEntity.constantTrue(z6 = objectPositionWME7.getZ()) && (x6 < 71.0f || z6 > -246.0f)) {
                                hashtable.put("z", new Float(z6));
                                hashtable.put("SubtopicObject", new Integer(subtopicObject));
                                hashtable.put("beatWME", new ObjectWrapper(beatAAp1WME2));
                                hashtable.put("Subtopic", new Integer(subtopic));
                                hashtable.put("x", new Float(x6));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 356: {
                (int)array[0];
                final ListIterator listIterator38 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator38.hasNext()) {
                    final BeatAAp1WME beatAAp1WME4;
                    final BeatAAp1WME beatAAp1WME3 = beatAAp1WME4 = listIterator38.next();
                    final int subtopic2;
                    final int subtopicObject2;
                    if (BehavingEntity.constantTrue(subtopic2 = beatAAp1WME3.getSubtopic()) && BehavingEntity.constantTrue(subtopicObject2 = beatAAp1WME3.getSubtopicObject()) && subtopic2 == 81) {
                        final ListIterator listIterator39 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator39.hasNext()) {
                            final ObjectPositionWME objectPositionWME8 = listIterator39.next();
                            final float x7;
                            final float z7;
                            if (objectPositionWME8.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x7 = objectPositionWME8.getX()) && BehavingEntity.constantTrue(z7 = objectPositionWME8.getZ()) && (x7 < 60.0f || z7 < -270.0f || z7 > -165.0f)) {
                                hashtable.put("z", new Float(z7));
                                hashtable.put("SubtopicObject", new Integer(subtopicObject2));
                                hashtable.put("beatWME", new ObjectWrapper(beatAAp1WME4));
                                hashtable.put("Subtopic", new Integer(subtopic2));
                                hashtable.put("x", new Float(x7));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 357: {
                (int)array[0];
                final ListIterator listIterator40 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator40.hasNext()) {
                    final BeatAAp1WME beatAAp1WME6;
                    final BeatAAp1WME beatAAp1WME5 = beatAAp1WME6 = listIterator40.next();
                    final int subtopic3;
                    final int subtopicObject3;
                    if (BehavingEntity.constantTrue(subtopic3 = beatAAp1WME5.getSubtopic()) && BehavingEntity.constantTrue(subtopicObject3 = beatAAp1WME5.getSubtopicObject()) && subtopic3 == 90) {
                        final ListIterator listIterator41 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator41.hasNext()) {
                            final ObjectPositionWME objectPositionWME9 = listIterator41.next();
                            final float x8;
                            final float z8;
                            if (objectPositionWME9.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x8 = objectPositionWME9.getX()) && BehavingEntity.constantTrue(z8 = objectPositionWME9.getZ()) && (x8 < 60.0f || z8 < -240.0f || z8 > -105.0f)) {
                                hashtable.put("z", new Float(z8));
                                hashtable.put("SubtopicObject", new Integer(subtopicObject3));
                                hashtable.put("beatWME", new ObjectWrapper(beatAAp1WME6));
                                hashtable.put("Subtopic", new Integer(subtopic3));
                                hashtable.put("x", new Float(x8));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 358: {
                (int)array[0];
                final ListIterator listIterator42 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator42.hasNext()) {
                    final BeatAAp1WME beatAAp1WME8;
                    final BeatAAp1WME beatAAp1WME7 = beatAAp1WME8 = listIterator42.next();
                    final int subtopic4;
                    final int subtopicObject4;
                    if (BehavingEntity.constantTrue(subtopic4 = beatAAp1WME7.getSubtopic()) && BehavingEntity.constantTrue(subtopicObject4 = beatAAp1WME7.getSubtopicObject()) && (subtopic4 == 93 || subtopic4 == 94)) {
                        final ListIterator listIterator43 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator43.hasNext()) {
                            final ObjectPositionWME objectPositionWME10 = listIterator43.next();
                            final float x9;
                            final float z9;
                            if (objectPositionWME10.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x9 = objectPositionWME10.getX()) && BehavingEntity.constantTrue(z9 = objectPositionWME10.getZ()) && (x9 < -40.0f || x9 > 40.0f || z9 > -360.0f)) {
                                hashtable.put("z", new Float(z9));
                                hashtable.put("SubtopicObject", new Integer(subtopicObject4));
                                hashtable.put("beatWME", new ObjectWrapper(beatAAp1WME8));
                                hashtable.put("Subtopic", new Integer(subtopic4));
                                hashtable.put("x", new Float(x9));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 359: {
                (int)array[0];
                final ListIterator listIterator44 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator44.hasNext()) {
                    final BeatAAp1WME beatAAp1WME10;
                    final BeatAAp1WME beatAAp1WME9 = beatAAp1WME10 = listIterator44.next();
                    final int subtopic5;
                    final int subtopicObject5;
                    if (BehavingEntity.constantTrue(subtopic5 = beatAAp1WME9.getSubtopic()) && BehavingEntity.constantTrue(subtopicObject5 = beatAAp1WME9.getSubtopicObject()) && (subtopic5 == 85 || subtopic5 == 92)) {
                        final ListIterator listIterator45 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator45.hasNext()) {
                            final ObjectPositionWME objectPositionWME11 = listIterator45.next();
                            final float x10;
                            final float z10;
                            if (objectPositionWME11.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x10 = objectPositionWME11.getX()) && BehavingEntity.constantTrue(z10 = objectPositionWME11.getZ()) && (x10 > -77.0f || z10 > -350.0f)) {
                                hashtable.put("z", new Float(z10));
                                hashtable.put("SubtopicObject", new Integer(subtopicObject5));
                                hashtable.put("beatWME", new ObjectWrapper(beatAAp1WME10));
                                hashtable.put("Subtopic", new Integer(subtopic5));
                                hashtable.put("x", new Float(x10));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 360: {
                final ListIterator listIterator46 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator46.hasNext()) {
                    if (listIterator46.next().getCurrentBeat() == 11) {
                        return true;
                    }
                }
                return false;
            }
            case 362: {
                final ListIterator listIterator47 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator47.hasNext()) {
                    final int subtopicObject6;
                    if (BehavingEntity.constantTrue(subtopicObject6 = listIterator47.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject6));
                        return true;
                    }
                }
                return false;
            }
            case 367: {
                final ListIterator listIterator48 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator48.hasNext()) {
                    if (listIterator48.next().getSVal().equals("bAAt1N_TxnIn")) {
                        return false;
                    }
                }
                final ListIterator listIterator49 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator49.hasNext()) {
                    if (listIterator49.next().getSVal().equals("bAAt1GPA_TxnIn")) {
                        return false;
                    }
                }
                final ListIterator listIterator50 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator50.hasNext()) {
                    if (listIterator50.next().getSVal().equals("bAAt1TPA_TxnIn")) {
                        return false;
                    }
                }
                return true;
            }
            case 369: {
                final ListIterator listIterator51 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator51.hasNext()) {
                    final int subtopicObject7;
                    if (BehavingEntity.constantTrue(subtopicObject7 = listIterator51.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject7));
                        return true;
                    }
                }
                return false;
            }
            case 370: {
                final ListIterator listIterator52 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator52.hasNext()) {
                    final int subtopicObject8;
                    if (BehavingEntity.constantTrue(subtopicObject8 = listIterator52.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject8));
                        return true;
                    }
                }
                return false;
            }
            case 371: {
                final ListIterator listIterator53 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator53.hasNext()) {
                    final int subtopicObject9;
                    if (BehavingEntity.constantTrue(subtopicObject9 = listIterator53.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject9));
                        return true;
                    }
                }
                return false;
            }
            case 376: {
                final ListIterator listIterator54 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator54.hasNext()) {
                    final int subtopicObject10;
                    if (BehavingEntity.constantTrue(subtopicObject10 = listIterator54.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject10));
                        return true;
                    }
                }
                return false;
            }
            case 377: {
                final ListIterator listIterator55 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator55.hasNext()) {
                    final int subtopicObject11;
                    if (BehavingEntity.constantTrue(subtopicObject11 = listIterator55.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject11));
                        return true;
                    }
                }
                return false;
            }
            case 378: {
                final ListIterator listIterator56 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator56.hasNext()) {
                    final int subtopicObject12;
                    if (BehavingEntity.constantTrue(subtopicObject12 = listIterator56.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject12));
                        return true;
                    }
                }
                return false;
            }
            case 380: {
                final ListIterator listIterator57 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator57.hasNext()) {
                    final int subtopicObject13;
                    if (BehavingEntity.constantTrue(subtopicObject13 = listIterator57.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject13));
                        return true;
                    }
                }
                return false;
            }
            case 381: {
                final ListIterator listIterator58 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator58.hasNext()) {
                    final int subtopicObject14;
                    if (BehavingEntity.constantTrue(subtopicObject14 = listIterator58.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject14));
                        return true;
                    }
                }
                return false;
            }
            case 383: {
                final ListIterator listIterator59 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator59.hasNext()) {
                    final int subtopicObject15;
                    if (BehavingEntity.constantTrue(subtopicObject15 = listIterator59.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject15));
                        return true;
                    }
                }
                return false;
            }
            case 384: {
                final ListIterator listIterator60 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator60.hasNext()) {
                    final int subtopicObject16;
                    if (BehavingEntity.constantTrue(subtopicObject16 = listIterator60.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject16));
                        return true;
                    }
                }
                return false;
            }
            case 385: {
                final ListIterator listIterator61 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator61.hasNext()) {
                    final int subtopicObject17;
                    if (BehavingEntity.constantTrue(subtopicObject17 = listIterator61.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject17));
                        return true;
                    }
                }
                return false;
            }
            case 387: {
                final ListIterator listIterator62 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator62.hasNext()) {
                    final int subtopicObject18;
                    if (BehavingEntity.constantTrue(subtopicObject18 = listIterator62.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject18));
                        return true;
                    }
                }
                return false;
            }
            case 388: {
                final ListIterator listIterator63 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator63.hasNext()) {
                    final int subtopicObject19;
                    if (BehavingEntity.constantTrue(subtopicObject19 = listIterator63.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject19));
                        return true;
                    }
                }
                return false;
            }
            case 390: {
                final ListIterator listIterator64 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator64.hasNext()) {
                    final int subtopicObject20;
                    if (BehavingEntity.constantTrue(subtopicObject20 = listIterator64.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject20));
                        return true;
                    }
                }
                return false;
            }
            case 391: {
                final ListIterator listIterator65 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator65.hasNext()) {
                    final int subtopicObject21;
                    if (BehavingEntity.constantTrue(subtopicObject21 = listIterator65.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject21));
                        return true;
                    }
                }
                return false;
            }
            case 392: {
                final ListIterator listIterator66 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator66.hasNext()) {
                    final int subtopicObject22;
                    if (BehavingEntity.constantTrue(subtopicObject22 = listIterator66.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject22));
                        return true;
                    }
                }
                return false;
            }
            case 394: {
                final ListIterator listIterator67 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator67.hasNext()) {
                    final int subtopicObject23;
                    if (BehavingEntity.constantTrue(subtopicObject23 = listIterator67.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject23));
                        return true;
                    }
                }
                return false;
            }
            case 395: {
                final ListIterator listIterator68 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator68.hasNext()) {
                    final int subtopicObject24;
                    if (BehavingEntity.constantTrue(subtopicObject24 = listIterator68.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject24));
                        return true;
                    }
                }
                return false;
            }
            case 397: {
                final ListIterator listIterator69 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator69.hasNext()) {
                    final int subtopicObject25;
                    if (BehavingEntity.constantTrue(subtopicObject25 = listIterator69.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject25));
                        return true;
                    }
                }
                return false;
            }
            case 398: {
                final ListIterator listIterator70 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator70.hasNext()) {
                    final int subtopicObject26;
                    if (BehavingEntity.constantTrue(subtopicObject26 = listIterator70.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject26));
                        return true;
                    }
                }
                return false;
            }
            case 399: {
                final ListIterator listIterator71 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator71.hasNext()) {
                    final int subtopicObject27;
                    if (BehavingEntity.constantTrue(subtopicObject27 = listIterator71.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject27));
                        return true;
                    }
                }
                return false;
            }
            case 400: {
                (boolean)array[0];
                final ListIterator listIterator72 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator72.hasNext()) {
                    final int subtopicObject28;
                    if (BehavingEntity.constantTrue(subtopicObject28 = listIterator72.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject28));
                        return true;
                    }
                }
                return false;
            }
            case 401: {
                final ListIterator listIterator73 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator73.hasNext()) {
                    final int subtopicObject29;
                    if (BehavingEntity.constantTrue(subtopicObject29 = listIterator73.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject29));
                        return true;
                    }
                }
                return false;
            }
            case 402: {
                final ListIterator listIterator74 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator74.hasNext()) {
                    final int subtopicObject30;
                    if (BehavingEntity.constantTrue(subtopicObject30 = listIterator74.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject30));
                        return true;
                    }
                }
                return false;
            }
            case 404: {
                final ListIterator listIterator75 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator75.hasNext()) {
                    final int subtopicObject31;
                    if (BehavingEntity.constantTrue(subtopicObject31 = listIterator75.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject31));
                        return true;
                    }
                }
                return false;
            }
            case 405: {
                final ListIterator listIterator76 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator76.hasNext()) {
                    final int subtopicObject32;
                    if (BehavingEntity.constantTrue(subtopicObject32 = listIterator76.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject32));
                        return true;
                    }
                }
                return false;
            }
            case 406: {
                final ListIterator listIterator77 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator77.hasNext()) {
                    final int subtopicObject33;
                    if (BehavingEntity.constantTrue(subtopicObject33 = listIterator77.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject33));
                        return true;
                    }
                }
                return false;
            }
            case 408: {
                final ListIterator listIterator78 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator78.hasNext()) {
                    final int subtopicObject34;
                    if (BehavingEntity.constantTrue(subtopicObject34 = listIterator78.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject34));
                        return true;
                    }
                }
                return false;
            }
            case 409: {
                final ListIterator listIterator79 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator79.hasNext()) {
                    final int subtopicObject35;
                    if (BehavingEntity.constantTrue(subtopicObject35 = listIterator79.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject35));
                        return true;
                    }
                }
                return false;
            }
            case 411: {
                final ListIterator listIterator80 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator80.hasNext()) {
                    final int subtopicObject36;
                    if (BehavingEntity.constantTrue(subtopicObject36 = listIterator80.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject36));
                        return true;
                    }
                }
                return false;
            }
            case 412: {
                final ListIterator listIterator81 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator81.hasNext()) {
                    final int subtopicObject37;
                    if (BehavingEntity.constantTrue(subtopicObject37 = listIterator81.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject37));
                        return true;
                    }
                }
                return false;
            }
            case 413: {
                final ListIterator listIterator82 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator82.hasNext()) {
                    final int subtopicObject38;
                    if (BehavingEntity.constantTrue(subtopicObject38 = listIterator82.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject38));
                        return true;
                    }
                }
                return false;
            }
            case 415: {
                final ListIterator listIterator83 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator83.hasNext()) {
                    final int subtopicObject39;
                    if (BehavingEntity.constantTrue(subtopicObject39 = listIterator83.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject39));
                        return true;
                    }
                }
                return false;
            }
            case 416: {
                final ListIterator listIterator84 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator84.hasNext()) {
                    final int subtopicObject40;
                    if (BehavingEntity.constantTrue(subtopicObject40 = listIterator84.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject40));
                        return true;
                    }
                }
                return false;
            }
            case 418: {
                final ListIterator listIterator85 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator85.hasNext()) {
                    final int subtopicObject41;
                    if (BehavingEntity.constantTrue(subtopicObject41 = listIterator85.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject41));
                        return true;
                    }
                }
                return false;
            }
            case 419: {
                final ListIterator listIterator86 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator86.hasNext()) {
                    final int subtopicObject42;
                    if (BehavingEntity.constantTrue(subtopicObject42 = listIterator86.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject42));
                        return true;
                    }
                }
                return false;
            }
            case 420: {
                final ListIterator listIterator87 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator87.hasNext()) {
                    final int subtopicObject43;
                    if (BehavingEntity.constantTrue(subtopicObject43 = listIterator87.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject43));
                        return true;
                    }
                }
                return false;
            }
            case 422: {
                final ListIterator listIterator88 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator88.hasNext()) {
                    final int subtopicObject44;
                    if (BehavingEntity.constantTrue(subtopicObject44 = listIterator88.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject44));
                        return true;
                    }
                }
                return false;
            }
            case 423: {
                final ListIterator listIterator89 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator89.hasNext()) {
                    final int subtopicObject45;
                    if (BehavingEntity.constantTrue(subtopicObject45 = listIterator89.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject45));
                        return true;
                    }
                }
                return false;
            }
            case 425: {
                final ListIterator listIterator90 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator90.hasNext()) {
                    if (listIterator90.next().getSVal().equals("bAA_WaitTimeout_ReestablishStuff")) {
                        return false;
                    }
                }
                return true;
            }
            case 435: {
                final ListIterator listIterator91 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator91.hasNext()) {
                    final int subtopicObject46;
                    if (BehavingEntity.constantTrue(subtopicObject46 = listIterator91.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject46));
                        return true;
                    }
                }
                return false;
            }
            case 446: {
                return true;
            }
            case 447: {
                return false;
            }
            case 455: {
                return false;
            }
            case 456: {
                final ListIterator listIterator92 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator92.hasNext()) {
                    final HeldObjectWME heldObjectWME = listIterator92.next();
                    if (heldObjectWME.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME.getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 457: {
                final ListIterator listIterator93 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator93.hasNext()) {
                    final int subtopicObject47;
                    if (BehavingEntity.constantTrue(subtopicObject47 = listIterator93.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject47));
                        return true;
                    }
                }
                return false;
            }
            case 458: {
                final ListIterator listIterator94 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator94.hasNext()) {
                    final int subtopicObject48;
                    if (BehavingEntity.constantTrue(subtopicObject48 = listIterator94.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject48));
                        return true;
                    }
                }
                return false;
            }
            case 471: {
                final ListIterator listIterator95 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator95.hasNext()) {
                    if (listIterator95.next().getCurrentBeat() == 9) {
                        return true;
                    }
                }
                return false;
            }
            case 474: {
                final ListIterator listIterator96 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator96.hasNext()) {
                    final int subtopicObject49;
                    if (BehavingEntity.constantTrue(subtopicObject49 = listIterator96.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject49));
                        return true;
                    }
                }
                return false;
            }
            case 478: {
                final ListIterator listIterator97 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator97.hasNext()) {
                    if (listIterator97.next().getSVal().equals("bAAt1N_TxnIn")) {
                        return false;
                    }
                }
                final ListIterator listIterator98 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator98.hasNext()) {
                    if (listIterator98.next().getSVal().equals("bAAt1GPA_TxnIn")) {
                        return false;
                    }
                }
                final ListIterator listIterator99 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator99.hasNext()) {
                    if (listIterator99.next().getSVal().equals("bAAt1TPA_TxnIn")) {
                        return false;
                    }
                }
                return true;
            }
            case 480: {
                final ListIterator listIterator100 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator100.hasNext()) {
                    final int subtopicObject50;
                    if (BehavingEntity.constantTrue(subtopicObject50 = listIterator100.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject50));
                        return true;
                    }
                }
                return false;
            }
            case 481: {
                final ListIterator listIterator101 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator101.hasNext()) {
                    final int subtopicObject51;
                    if (BehavingEntity.constantTrue(subtopicObject51 = listIterator101.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject51));
                        return true;
                    }
                }
                return false;
            }
            case 482: {
                (boolean)array[0];
                final ListIterator listIterator102 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator102.hasNext()) {
                    final int subtopicObject52;
                    if (BehavingEntity.constantTrue(subtopicObject52 = listIterator102.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject52));
                        return true;
                    }
                }
                return false;
            }
            case 487: {
                final ListIterator listIterator103 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator103.hasNext()) {
                    final int subtopicObject53;
                    if (BehavingEntity.constantTrue(subtopicObject53 = listIterator103.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject53));
                        return true;
                    }
                }
                return false;
            }
            case 488: {
                final ListIterator listIterator104 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator104.hasNext()) {
                    final int subtopicObject54;
                    if (BehavingEntity.constantTrue(subtopicObject54 = listIterator104.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject54));
                        return true;
                    }
                }
                return false;
            }
            case 489: {
                (boolean)array[0];
                final ListIterator listIterator105 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator105.hasNext()) {
                    final int subtopicObject55;
                    if (BehavingEntity.constantTrue(subtopicObject55 = listIterator105.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject55));
                        return true;
                    }
                }
                return false;
            }
            case 490: {
                final ListIterator listIterator106 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator106.hasNext()) {
                    final int subtopicObject56;
                    if (BehavingEntity.constantTrue(subtopicObject56 = listIterator106.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject56));
                        return true;
                    }
                }
                return false;
            }
            case 491: {
                final ListIterator listIterator107 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator107.hasNext()) {
                    final int subtopicObject57;
                    if (BehavingEntity.constantTrue(subtopicObject57 = listIterator107.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject57));
                        return true;
                    }
                }
                return false;
            }
            case 493: {
                final ListIterator listIterator108 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator108.hasNext()) {
                    final int subtopicObject58;
                    if (BehavingEntity.constantTrue(subtopicObject58 = listIterator108.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject58));
                        return true;
                    }
                }
                return false;
            }
            case 494: {
                final ListIterator listIterator109 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator109.hasNext()) {
                    final int subtopicObject59;
                    if (BehavingEntity.constantTrue(subtopicObject59 = listIterator109.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject59));
                        return true;
                    }
                }
                return false;
            }
            case 495: {
                (boolean)array[0];
                final ListIterator listIterator110 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator110.hasNext()) {
                    final int subtopicObject60;
                    if (BehavingEntity.constantTrue(subtopicObject60 = listIterator110.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject60));
                        return true;
                    }
                }
                return false;
            }
            case 496: {
                final ListIterator listIterator111 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator111.hasNext()) {
                    final int subtopicObject61;
                    if (BehavingEntity.constantTrue(subtopicObject61 = listIterator111.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject61));
                        return true;
                    }
                }
                return false;
            }
            case 497: {
                final ListIterator listIterator112 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator112.hasNext()) {
                    final int subtopicObject62;
                    if (BehavingEntity.constantTrue(subtopicObject62 = listIterator112.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject62));
                        return true;
                    }
                }
                return false;
            }
            case 499: {
                final ListIterator listIterator113 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator113.hasNext()) {
                    final int subtopicObject63;
                    if (BehavingEntity.constantTrue(subtopicObject63 = listIterator113.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject63));
                        return true;
                    }
                }
                return false;
            }
            case 500: {
                final ListIterator listIterator114 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator114.hasNext()) {
                    final int subtopicObject64;
                    if (BehavingEntity.constantTrue(subtopicObject64 = listIterator114.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject64));
                        return true;
                    }
                }
                return false;
            }
            case 501: {
                (boolean)array[0];
                final ListIterator listIterator115 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator115.hasNext()) {
                    final int subtopicObject65;
                    if (BehavingEntity.constantTrue(subtopicObject65 = listIterator115.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject65));
                        return true;
                    }
                }
                return false;
            }
            case 502: {
                final ListIterator listIterator116 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator116.hasNext()) {
                    final int subtopicObject66;
                    if (BehavingEntity.constantTrue(subtopicObject66 = listIterator116.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject66));
                        return true;
                    }
                }
                return false;
            }
            case 503: {
                final ListIterator listIterator117 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator117.hasNext()) {
                    final int subtopicObject67;
                    if (BehavingEntity.constantTrue(subtopicObject67 = listIterator117.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject67));
                        return true;
                    }
                }
                return false;
            }
            case 505: {
                final ListIterator listIterator118 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator118.hasNext()) {
                    final int subtopicObject68;
                    if (BehavingEntity.constantTrue(subtopicObject68 = listIterator118.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject68));
                        return true;
                    }
                }
                return false;
            }
            case 506: {
                final ListIterator listIterator119 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator119.hasNext()) {
                    final int subtopicObject69;
                    if (BehavingEntity.constantTrue(subtopicObject69 = listIterator119.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject69));
                        return true;
                    }
                }
                return false;
            }
            case 507: {
                (boolean)array[0];
                final ListIterator listIterator120 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator120.hasNext()) {
                    final int subtopicObject70;
                    if (BehavingEntity.constantTrue(subtopicObject70 = listIterator120.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject70));
                        return true;
                    }
                }
                return false;
            }
            case 508: {
                final ListIterator listIterator121 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator121.hasNext()) {
                    final int subtopicObject71;
                    if (BehavingEntity.constantTrue(subtopicObject71 = listIterator121.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject71));
                        return true;
                    }
                }
                return false;
            }
            case 509: {
                final ListIterator listIterator122 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator122.hasNext()) {
                    final int subtopicObject72;
                    if (BehavingEntity.constantTrue(subtopicObject72 = listIterator122.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject72));
                        return true;
                    }
                }
                return false;
            }
            case 511: {
                final ListIterator listIterator123 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator123.hasNext()) {
                    final int subtopicObject73;
                    if (BehavingEntity.constantTrue(subtopicObject73 = listIterator123.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject73));
                        return true;
                    }
                }
                return false;
            }
            case 512: {
                final ListIterator listIterator124 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator124.hasNext()) {
                    final int subtopicObject74;
                    if (BehavingEntity.constantTrue(subtopicObject74 = listIterator124.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject74));
                        return true;
                    }
                }
                return false;
            }
            case 513: {
                (boolean)array[0];
                final ListIterator listIterator125 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator125.hasNext()) {
                    final int subtopicObject75;
                    if (BehavingEntity.constantTrue(subtopicObject75 = listIterator125.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject75));
                        return true;
                    }
                }
                return false;
            }
            case 514: {
                final ListIterator listIterator126 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator126.hasNext()) {
                    final int subtopicObject76;
                    if (BehavingEntity.constantTrue(subtopicObject76 = listIterator126.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject76));
                        return true;
                    }
                }
                return false;
            }
            case 515: {
                final ListIterator listIterator127 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator127.hasNext()) {
                    final int subtopicObject77;
                    if (BehavingEntity.constantTrue(subtopicObject77 = listIterator127.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject77));
                        return true;
                    }
                }
                return false;
            }
            case 517: {
                final ListIterator listIterator128 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator128.hasNext()) {
                    final int subtopicObject78;
                    if (BehavingEntity.constantTrue(subtopicObject78 = listIterator128.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject78));
                        return true;
                    }
                }
                return false;
            }
            case 518: {
                final ListIterator listIterator129 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator129.hasNext()) {
                    final int subtopicObject79;
                    if (BehavingEntity.constantTrue(subtopicObject79 = listIterator129.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject79));
                        return true;
                    }
                }
                return false;
            }
            case 519: {
                (boolean)array[0];
                final ListIterator listIterator130 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator130.hasNext()) {
                    final int subtopicObject80;
                    if (BehavingEntity.constantTrue(subtopicObject80 = listIterator130.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject80));
                        return true;
                    }
                }
                return false;
            }
            case 520: {
                final ListIterator listIterator131 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator131.hasNext()) {
                    final int subtopicObject81;
                    if (BehavingEntity.constantTrue(subtopicObject81 = listIterator131.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject81));
                        return true;
                    }
                }
                return false;
            }
            case 521: {
                final ListIterator listIterator132 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator132.hasNext()) {
                    final int subtopicObject82;
                    if (BehavingEntity.constantTrue(subtopicObject82 = listIterator132.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject82));
                        return true;
                    }
                }
                return false;
            }
            case 523: {
                final ListIterator listIterator133 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator133.hasNext()) {
                    final int subtopicObject83;
                    if (BehavingEntity.constantTrue(subtopicObject83 = listIterator133.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject83));
                        return true;
                    }
                }
                return false;
            }
            case 524: {
                final ListIterator listIterator134 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator134.hasNext()) {
                    final int subtopicObject84;
                    if (BehavingEntity.constantTrue(subtopicObject84 = listIterator134.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject84));
                        return true;
                    }
                }
                return false;
            }
            case 525: {
                (boolean)array[0];
                final ListIterator listIterator135 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator135.hasNext()) {
                    final int subtopicObject85;
                    if (BehavingEntity.constantTrue(subtopicObject85 = listIterator135.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject85));
                        return true;
                    }
                }
                return false;
            }
            case 526: {
                final ListIterator listIterator136 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator136.hasNext()) {
                    final int subtopicObject86;
                    if (BehavingEntity.constantTrue(subtopicObject86 = listIterator136.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject86));
                        return true;
                    }
                }
                return false;
            }
            case 527: {
                final ListIterator listIterator137 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator137.hasNext()) {
                    final int subtopicObject87;
                    if (BehavingEntity.constantTrue(subtopicObject87 = listIterator137.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject87));
                        return true;
                    }
                }
                return false;
            }
            case 529: {
                final ListIterator listIterator138 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator138.hasNext()) {
                    if (listIterator138.next().getSVal().equals("bAA_WaitTimeout_ReestablishStuff")) {
                        return false;
                    }
                }
                return true;
            }
            case 541: {
                final ListIterator listIterator139 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator139.hasNext()) {
                    final int subtopicObject88;
                    if (BehavingEntity.constantTrue(subtopicObject88 = listIterator139.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject88));
                        return true;
                    }
                }
                return false;
            }
            case 552: {
                return true;
            }
            case 553: {
                return false;
            }
            case 561: {
                final ListIterator listIterator140 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator140.hasNext()) {
                    final int subtopicObject89;
                    if (BehavingEntity.constantTrue(subtopicObject89 = listIterator140.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject89));
                        return true;
                    }
                }
                return false;
            }
            case 562: {
                final ListIterator listIterator141 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator141.hasNext()) {
                    final int subtopicObject90;
                    if (BehavingEntity.constantTrue(subtopicObject90 = listIterator141.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject90));
                        return true;
                    }
                }
                return false;
            }
            case 571: {
                final ListIterator listIterator142 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator142.hasNext()) {
                    if (listIterator142.next().getCurrentBeat() == 10) {
                        return true;
                    }
                }
                return false;
            }
            case 573: {
                final ListIterator listIterator143 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator143.hasNext()) {
                    final int subtopicObject91;
                    if (BehavingEntity.constantTrue(subtopicObject91 = listIterator143.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject91));
                        return true;
                    }
                }
                return false;
            }
            case 576: {
                final ListIterator listIterator144 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator144.hasNext()) {
                    if (listIterator144.next().getSVal().equals("bAAt1N_TxnIn")) {
                        return false;
                    }
                }
                final ListIterator listIterator145 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator145.hasNext()) {
                    if (listIterator145.next().getSVal().equals("bAAt1GPA_TxnIn")) {
                        return false;
                    }
                }
                final ListIterator listIterator146 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator146.hasNext()) {
                    if (listIterator146.next().getSVal().equals("bAAt1TPA_TxnIn")) {
                        return false;
                    }
                }
                return true;
            }
            case 578: {
                final ListIterator listIterator147 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator147.hasNext()) {
                    final int subtopicObject92;
                    if (BehavingEntity.constantTrue(subtopicObject92 = listIterator147.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject92));
                        return true;
                    }
                }
                return false;
            }
            case 579: {
                final ListIterator listIterator148 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator148.hasNext()) {
                    final int subtopicObject93;
                    if (BehavingEntity.constantTrue(subtopicObject93 = listIterator148.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject93));
                        return true;
                    }
                }
                return false;
            }
            case 580: {
                final ListIterator listIterator149 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator149.hasNext()) {
                    final int subtopicObject94;
                    if (BehavingEntity.constantTrue(subtopicObject94 = listIterator149.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject94));
                        return true;
                    }
                }
                return false;
            }
            case 585: {
                final ListIterator listIterator150 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator150.hasNext()) {
                    final int subtopicObject95;
                    if (BehavingEntity.constantTrue(subtopicObject95 = listIterator150.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject95));
                        return true;
                    }
                }
                return false;
            }
            case 586: {
                final ListIterator listIterator151 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator151.hasNext()) {
                    final int subtopicObject96;
                    if (BehavingEntity.constantTrue(subtopicObject96 = listIterator151.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject96));
                        return true;
                    }
                }
                return false;
            }
            case 587: {
                final ListIterator listIterator152 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator152.hasNext()) {
                    final int subtopicObject97;
                    if (BehavingEntity.constantTrue(subtopicObject97 = listIterator152.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject97));
                        return true;
                    }
                }
                return false;
            }
            case 589: {
                final ListIterator listIterator153 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator153.hasNext()) {
                    final int subtopicObject98;
                    if (BehavingEntity.constantTrue(subtopicObject98 = listIterator153.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject98));
                        return true;
                    }
                }
                return false;
            }
            case 590: {
                final ListIterator listIterator154 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator154.hasNext()) {
                    final int subtopicObject99;
                    if (BehavingEntity.constantTrue(subtopicObject99 = listIterator154.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject99));
                        return true;
                    }
                }
                return false;
            }
            case 592: {
                final ListIterator listIterator155 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator155.hasNext()) {
                    final int subtopicObject100;
                    if (BehavingEntity.constantTrue(subtopicObject100 = listIterator155.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject100));
                        return true;
                    }
                }
                return false;
            }
            case 593: {
                final ListIterator listIterator156 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator156.hasNext()) {
                    final int subtopicObject101;
                    if (BehavingEntity.constantTrue(subtopicObject101 = listIterator156.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject101));
                        return true;
                    }
                }
                return false;
            }
            case 594: {
                final ListIterator listIterator157 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator157.hasNext()) {
                    final int subtopicObject102;
                    if (BehavingEntity.constantTrue(subtopicObject102 = listIterator157.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject102));
                        return true;
                    }
                }
                return false;
            }
            case 596: {
                final ListIterator listIterator158 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator158.hasNext()) {
                    final int subtopicObject103;
                    if (BehavingEntity.constantTrue(subtopicObject103 = listIterator158.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject103));
                        return true;
                    }
                }
                return false;
            }
            case 597: {
                final ListIterator listIterator159 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator159.hasNext()) {
                    final int subtopicObject104;
                    if (BehavingEntity.constantTrue(subtopicObject104 = listIterator159.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject104));
                        return true;
                    }
                }
                return false;
            }
            case 599: {
                final ListIterator listIterator160 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator160.hasNext()) {
                    final int subtopicObject105;
                    if (BehavingEntity.constantTrue(subtopicObject105 = listIterator160.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject105));
                        return true;
                    }
                }
                return false;
            }
            case 600: {
                final ListIterator listIterator161 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator161.hasNext()) {
                    final int subtopicObject106;
                    if (BehavingEntity.constantTrue(subtopicObject106 = listIterator161.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject106));
                        return true;
                    }
                }
                return false;
            }
            case 601: {
                final ListIterator listIterator162 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator162.hasNext()) {
                    final int subtopicObject107;
                    if (BehavingEntity.constantTrue(subtopicObject107 = listIterator162.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject107));
                        return true;
                    }
                }
                return false;
            }
            case 603: {
                final ListIterator listIterator163 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator163.hasNext()) {
                    final int subtopicObject108;
                    if (BehavingEntity.constantTrue(subtopicObject108 = listIterator163.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject108));
                        return true;
                    }
                }
                return false;
            }
            case 604: {
                final ListIterator listIterator164 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator164.hasNext()) {
                    final int subtopicObject109;
                    if (BehavingEntity.constantTrue(subtopicObject109 = listIterator164.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject109));
                        return true;
                    }
                }
                return false;
            }
            case 606: {
                final ListIterator listIterator165 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator165.hasNext()) {
                    final int subtopicObject110;
                    if (BehavingEntity.constantTrue(subtopicObject110 = listIterator165.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject110));
                        return true;
                    }
                }
                return false;
            }
            case 607: {
                final ListIterator listIterator166 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator166.hasNext()) {
                    final int subtopicObject111;
                    if (BehavingEntity.constantTrue(subtopicObject111 = listIterator166.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject111));
                        return true;
                    }
                }
                return false;
            }
            case 608: {
                final ListIterator listIterator167 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator167.hasNext()) {
                    final int subtopicObject112;
                    if (BehavingEntity.constantTrue(subtopicObject112 = listIterator167.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject112));
                        return true;
                    }
                }
                return false;
            }
            case 609: {
                (boolean)array[0];
                final ListIterator listIterator168 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator168.hasNext()) {
                    final int subtopicObject113;
                    if (BehavingEntity.constantTrue(subtopicObject113 = listIterator168.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject113));
                        return true;
                    }
                }
                return false;
            }
            case 610: {
                final ListIterator listIterator169 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator169.hasNext()) {
                    final int subtopicObject114;
                    if (BehavingEntity.constantTrue(subtopicObject114 = listIterator169.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject114));
                        return true;
                    }
                }
                return false;
            }
            case 611: {
                final ListIterator listIterator170 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator170.hasNext()) {
                    final int subtopicObject115;
                    if (BehavingEntity.constantTrue(subtopicObject115 = listIterator170.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject115));
                        return true;
                    }
                }
                return false;
            }
            case 613: {
                final ListIterator listIterator171 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator171.hasNext()) {
                    final int subtopicObject116;
                    if (BehavingEntity.constantTrue(subtopicObject116 = listIterator171.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject116));
                        return true;
                    }
                }
                return false;
            }
            case 614: {
                final ListIterator listIterator172 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator172.hasNext()) {
                    final int subtopicObject117;
                    if (BehavingEntity.constantTrue(subtopicObject117 = listIterator172.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject117));
                        return true;
                    }
                }
                return false;
            }
            case 615: {
                final ListIterator listIterator173 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator173.hasNext()) {
                    final int subtopicObject118;
                    if (BehavingEntity.constantTrue(subtopicObject118 = listIterator173.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject118));
                        return true;
                    }
                }
                return false;
            }
            case 617: {
                final ListIterator listIterator174 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator174.hasNext()) {
                    final int subtopicObject119;
                    if (BehavingEntity.constantTrue(subtopicObject119 = listIterator174.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject119));
                        return true;
                    }
                }
                return false;
            }
            case 618: {
                final ListIterator listIterator175 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator175.hasNext()) {
                    final int subtopicObject120;
                    if (BehavingEntity.constantTrue(subtopicObject120 = listIterator175.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject120));
                        return true;
                    }
                }
                return false;
            }
            case 620: {
                final ListIterator listIterator176 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator176.hasNext()) {
                    final int subtopicObject121;
                    if (BehavingEntity.constantTrue(subtopicObject121 = listIterator176.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject121));
                        return true;
                    }
                }
                return false;
            }
            case 621: {
                final ListIterator listIterator177 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator177.hasNext()) {
                    final int subtopicObject122;
                    if (BehavingEntity.constantTrue(subtopicObject122 = listIterator177.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject122));
                        return true;
                    }
                }
                return false;
            }
            case 622: {
                final ListIterator listIterator178 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator178.hasNext()) {
                    final int subtopicObject123;
                    if (BehavingEntity.constantTrue(subtopicObject123 = listIterator178.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject123));
                        return true;
                    }
                }
                return false;
            }
            case 624: {
                final ListIterator listIterator179 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator179.hasNext()) {
                    final int subtopicObject124;
                    if (BehavingEntity.constantTrue(subtopicObject124 = listIterator179.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject124));
                        return true;
                    }
                }
                return false;
            }
            case 625: {
                final ListIterator listIterator180 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator180.hasNext()) {
                    final int subtopicObject125;
                    if (BehavingEntity.constantTrue(subtopicObject125 = listIterator180.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject125));
                        return true;
                    }
                }
                return false;
            }
            case 627: {
                final ListIterator listIterator181 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator181.hasNext()) {
                    final int subtopicObject126;
                    if (BehavingEntity.constantTrue(subtopicObject126 = listIterator181.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject126));
                        return true;
                    }
                }
                return false;
            }
            case 628: {
                final ListIterator listIterator182 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator182.hasNext()) {
                    final int subtopicObject127;
                    if (BehavingEntity.constantTrue(subtopicObject127 = listIterator182.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject127));
                        return true;
                    }
                }
                return false;
            }
            case 629: {
                final ListIterator listIterator183 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator183.hasNext()) {
                    final int subtopicObject128;
                    if (BehavingEntity.constantTrue(subtopicObject128 = listIterator183.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject128));
                        return true;
                    }
                }
                return false;
            }
            case 631: {
                final ListIterator listIterator184 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator184.hasNext()) {
                    final int subtopicObject129;
                    if (BehavingEntity.constantTrue(subtopicObject129 = listIterator184.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject129));
                        return true;
                    }
                }
                return false;
            }
            case 632: {
                final ListIterator listIterator185 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator185.hasNext()) {
                    final int subtopicObject130;
                    if (BehavingEntity.constantTrue(subtopicObject130 = listIterator185.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject130));
                        return true;
                    }
                }
                return false;
            }
            case 634: {
                final ListIterator listIterator186 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator186.hasNext()) {
                    if (listIterator186.next().getSVal().equals("bAA_WaitTimeout_ReestablishStuff")) {
                        return false;
                    }
                }
                return true;
            }
            case 644: {
                final ListIterator listIterator187 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator187.hasNext()) {
                    final int subtopicObject131;
                    if (BehavingEntity.constantTrue(subtopicObject131 = listIterator187.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject131));
                        return true;
                    }
                }
                return false;
            }
            case 655: {
                return true;
            }
            case 656: {
                return false;
            }
            case 664: {
                return false;
            }
            case 665: {
                final ListIterator listIterator188 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator188.hasNext()) {
                    final HeldObjectWME heldObjectWME2 = listIterator188.next();
                    if (heldObjectWME2.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME2.getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 666: {
                final ListIterator listIterator189 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator189.hasNext()) {
                    final int subtopicObject132;
                    if (BehavingEntity.constantTrue(subtopicObject132 = listIterator189.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject132));
                        return true;
                    }
                }
                return false;
            }
            case 667: {
                final ListIterator listIterator190 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator190.hasNext()) {
                    final int subtopicObject133;
                    if (BehavingEntity.constantTrue(subtopicObject133 = listIterator190.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject133));
                        return true;
                    }
                }
                return false;
            }
            case 676: {
                final ListIterator listIterator191 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator191.hasNext()) {
                    if (listIterator191.next().getCurrentBeat() == 16) {
                        return true;
                    }
                }
                return false;
            }
            case 741: {
                final ListIterator listIterator192 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator192.hasNext()) {
                    if (listIterator192.next().getCurrentBeat() == 14) {
                        return true;
                    }
                }
                return false;
            }
            case 804: {
                final ListIterator listIterator193 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator193.hasNext()) {
                    if (listIterator193.next().getCurrentBeat() == 15) {
                        return true;
                    }
                }
                return false;
            }
            case 872: {
                final ListIterator listIterator194 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator194.hasNext()) {
                    if (listIterator194.next().getCurrentBeat() == 13) {
                        return true;
                    }
                }
                return false;
            }
            case 877: {
                final ListIterator listIterator195 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator195.hasNext()) {
                    final int affinity;
                    if (BehavingEntity.constantTrue(affinity = listIterator195.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity));
                        return true;
                    }
                }
                return false;
            }
            case 878: {
                final ListIterator listIterator196 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator196.hasNext()) {
                    final int affinity2;
                    if (BehavingEntity.constantTrue(affinity2 = listIterator196.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity2));
                        return true;
                    }
                }
                return false;
            }
            case 893: {
                (boolean)array[0];
                final ListIterator listIterator197 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                while (listIterator197.hasNext()) {
                    final BeatFAskDrinkT1WME beatFAskDrinkT1WME = listIterator197.next();
                    final int curDrinkIdea;
                    final int graceDrinkIdea;
                    if (BehavingEntity.constantTrue(curDrinkIdea = beatFAskDrinkT1WME.getCurDrinkIdea()) && BehavingEntity.constantTrue(graceDrinkIdea = beatFAskDrinkT1WME.getGraceDrinkIdea()) && curDrinkIdea >= 5012) {
                        hashtable.put("drink", new Integer(curDrinkIdea));
                        hashtable.put("graceDrink", new Integer(graceDrinkIdea));
                        return true;
                    }
                }
                return false;
            }
            case 895: {
                final boolean booleanValue = (boolean)array[0];
                (int)array[1];
                return booleanValue;
            }
            case 896: {
                final boolean booleanValue2 = (boolean)array[0];
                (int)array[1];
                return booleanValue2;
            }
            case 897: {
                final boolean booleanValue3 = (boolean)array[0];
                (int)array[1];
                return booleanValue3;
            }
            case 898: {
                (boolean)array[0];
                final int intValue = (int)array[1];
                return intValue == 5004 || intValue == 5005 || intValue == 5006 || intValue == 5007 || intValue == 5008 || intValue == 5011;
            }
            case 899: {
                (boolean)array[0];
                return (int)array[1] == 5000;
            }
            case 900: {
                (boolean)array[0];
                return (int)array[1] == 5000;
            }
            case 902: {
                (boolean)array[0];
                final ListIterator listIterator198 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                while (listIterator198.hasNext()) {
                    final BeatFAskDrinkT1WME beatFAskDrinkT1WME2 = listIterator198.next();
                    final int curDrinkIdea2;
                    final int graceDrinkIdea2;
                    if (BehavingEntity.constantTrue(curDrinkIdea2 = beatFAskDrinkT1WME2.getCurDrinkIdea()) && BehavingEntity.constantTrue(graceDrinkIdea2 = beatFAskDrinkT1WME2.getGraceDrinkIdea()) && curDrinkIdea2 < 5012) {
                        hashtable.put("drink", new Integer(curDrinkIdea2));
                        hashtable.put("graceDrink", new Integer(graceDrinkIdea2));
                        return true;
                    }
                }
                return false;
            }
            case 904: {
                final int intValue2 = (int)array[0];
                return intValue2 == 5008 || intValue2 == 5011;
            }
            case 905: {
                final int intValue3 = (int)array[0];
                return intValue3 == 5004 || intValue3 == 5005 || intValue3 == 5006 || intValue3 == 5007;
            }
            case 906: {
                final int intValue4 = (int)array[0];
                return intValue4 == 5009 || intValue4 == 5010;
            }
            case 907: {
                final int intValue5 = (int)array[0];
                return intValue5 == 5002 || intValue5 == 5003;
            }
            case 908: {
                return (int)array[0] == 5000;
            }
            case 958: {
                final ListIterator listIterator199 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator199.hasNext()) {
                    if (listIterator199.next().getCurrentBeat() == 12) {
                        return true;
                    }
                }
                return false;
            }
            case 963: {
                final ListIterator listIterator200 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator200.hasNext()) {
                    final int affinity3;
                    if (BehavingEntity.constantTrue(affinity3 = listIterator200.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity3));
                        return true;
                    }
                }
                return false;
            }
            case 964: {
                final ListIterator listIterator201 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator201.hasNext()) {
                    final int affinity4;
                    if (BehavingEntity.constantTrue(affinity4 = listIterator201.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity4));
                        return true;
                    }
                }
                return false;
            }
            case 979: {
                (boolean)array[0];
                final ListIterator listIterator202 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                while (listIterator202.hasNext()) {
                    final BeatFAskDrinkT1WME beatFAskDrinkT1WME3 = listIterator202.next();
                    final int curDrinkIdea3;
                    final int graceDrinkIdea3;
                    if (BehavingEntity.constantTrue(curDrinkIdea3 = beatFAskDrinkT1WME3.getCurDrinkIdea()) && BehavingEntity.constantTrue(graceDrinkIdea3 = beatFAskDrinkT1WME3.getGraceDrinkIdea()) && curDrinkIdea3 >= 5012) {
                        hashtable.put("drink", new Integer(curDrinkIdea3));
                        hashtable.put("graceDrink", new Integer(graceDrinkIdea3));
                        return true;
                    }
                }
                return false;
            }
            case 981: {
                (boolean)array[0];
                final int intValue6 = (int)array[1];
                return intValue6 == 5004 || intValue6 == 5005 || intValue6 == 5006 || intValue6 == 5007 || intValue6 == 5008 || intValue6 == 5011;
            }
            case 982: {
                (boolean)array[0];
                return (int)array[1] == 5000;
            }
            case 983: {
                (boolean)array[0];
                return (int)array[1] == 5000;
            }
            case 985: {
                (boolean)array[0];
                final ListIterator listIterator203 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                while (listIterator203.hasNext()) {
                    final BeatFAskDrinkT1WME beatFAskDrinkT1WME4 = listIterator203.next();
                    final int curDrinkIdea4;
                    final int graceDrinkIdea4;
                    if (BehavingEntity.constantTrue(curDrinkIdea4 = beatFAskDrinkT1WME4.getCurDrinkIdea()) && BehavingEntity.constantTrue(graceDrinkIdea4 = beatFAskDrinkT1WME4.getGraceDrinkIdea()) && curDrinkIdea4 < 5012) {
                        hashtable.put("drink", new Integer(curDrinkIdea4));
                        hashtable.put("graceDrink", new Integer(graceDrinkIdea4));
                        return true;
                    }
                }
                return false;
            }
            case 987: {
                final int intValue7 = (int)array[0];
                return intValue7 == 5008 || intValue7 == 5011;
            }
            case 988: {
                final int intValue8 = (int)array[0];
                return intValue8 == 5004 || intValue8 == 5005 || intValue8 == 5006 || intValue8 == 5007;
            }
            case 989: {
                final int intValue9 = (int)array[0];
                return intValue9 == 5009 || intValue9 == 5010;
            }
            case 990: {
                final int intValue10 = (int)array[0];
                return intValue10 == 5002 || intValue10 == 5003;
            }
            case 991: {
                return (int)array[0] == 5000;
            }
            case 1027: {
                final ListIterator listIterator204 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                while (listIterator204.hasNext()) {
                    final int curDrinkIdea5;
                    if (BehavingEntity.constantTrue(curDrinkIdea5 = listIterator204.next().getCurDrinkIdea()) && curDrinkIdea5 >= 5015 && curDrinkIdea5 <= 5016) {
                        hashtable.put("drink", new Integer(curDrinkIdea5));
                        return true;
                    }
                }
                return false;
            }
            case 1052: {
                final ListIterator listIterator205 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator205.hasNext()) {
                    if (listIterator205.next().getSVal().equals("bFAskDrinkT1_TxnOut2_TripAsksGrace_CondescendChardonnay")) {
                        return true;
                    }
                }
                return false;
            }
            case 1053: {
                final ListIterator listIterator206 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator206.hasNext()) {
                    if (listIterator206.next().getSVal().equals("bFAskDrinkT1_TxnOut2_TripAsksGrace_CondescendChardonnay")) {
                        return true;
                    }
                }
                return false;
            }
            case 1054: {
                final ListIterator listIterator207 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator207.hasNext()) {
                    if (listIterator207.next().getSVal().equals("bFAskDrinkT1_TxnOut2_TripAsksGrace_CondescendChardonnay")) {
                        return false;
                    }
                }
                return true;
            }
            case 1055: {
                final ListIterator listIterator208 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator208.hasNext()) {
                    if (listIterator208.next().getSVal().equals("bFAskDrinkT1_TxnOut2_TripAsksGrace_CondescendChardonnay")) {
                        return false;
                    }
                }
                return true;
            }
            case 1057: {
                final ListIterator listIterator209 = WorkingMemory.lookupWME("StoryMemory", "AmbFixdrinkWME").listIterator();
                while (listIterator209.hasNext()) {
                    final int playerDrink;
                    if (BehavingEntity.constantTrue(playerDrink = listIterator209.next().getPlayerDrink())) {
                        hashtable.put("playerDrink", new Integer(playerDrink));
                        return true;
                    }
                }
                return false;
            }
            case 1061: {
                final ListIterator listIterator210 = WorkingMemory.lookupWME("StoryMemory", "AmbFixdrinkWME").listIterator();
                while (listIterator210.hasNext()) {
                    final int playerDrink2;
                    if (BehavingEntity.constantTrue(playerDrink2 = listIterator210.next().getPlayerDrink())) {
                        hashtable.put("playerDrink", new Integer(playerDrink2));
                        return true;
                    }
                }
                return false;
            }
            case 1065: {
                final ListIterator listIterator211 = WorkingMemory.lookupWME("StoryMemory", "AmbFixdrinkWME").listIterator();
                while (listIterator211.hasNext()) {
                    final int playerDrink3;
                    if (BehavingEntity.constantTrue(playerDrink3 = listIterator211.next().getPlayerDrink())) {
                        hashtable.put("playerDrink", new Integer(playerDrink3));
                        return true;
                    }
                }
                return false;
            }
            case 1066: {
                final ListIterator listIterator212 = WorkingMemory.lookupWME("StoryMemory", "AmbFixdrinkWME").listIterator();
                while (listIterator212.hasNext()) {
                    if (listIterator212.next().getPlayerDrink() != 4999) {
                        return true;
                    }
                }
                return false;
            }
            case 1067: {
                final ListIterator listIterator213 = WorkingMemory.lookupWME("StoryMemory", "AmbFixdrinkWME").listIterator();
                while (listIterator213.hasNext()) {
                    if (listIterator213.next().getPlayerDrink() != 4999) {
                        return true;
                    }
                }
                return false;
            }
            case 1068: {
                final ListIterator listIterator214 = WorkingMemory.lookupWME("StoryMemory", "AmbFixdrinkWME").listIterator();
                while (listIterator214.hasNext()) {
                    if (listIterator214.next().getPlayerDrink() != 4999) {
                        return true;
                    }
                }
                return false;
            }
            case 1069: {
                final ListIterator listIterator215 = WorkingMemory.lookupWME("StoryMemory", "AmbFixdrinkWME").listIterator();
                while (listIterator215.hasNext()) {
                    if (listIterator215.next().getPlayerDrink() == 4999) {
                        return true;
                    }
                }
                return false;
            }
            case 1086: {
                final ListIterator listIterator216 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator216.hasNext()) {
                    if (listIterator216.next().getCurrentBeat() == 7) {
                        return true;
                    }
                }
                return false;
            }
            case 1111: {
                final ListIterator listIterator217 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator217.hasNext()) {
                    if (listIterator217.next().getCurrentBeat() == 8) {
                        return true;
                    }
                }
                return false;
            }
            case 1128: {
                final ListIterator listIterator218 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator218.hasNext()) {
                    if (listIterator218.next().getCurrentBeat() == 17) {
                        return true;
                    }
                }
                return false;
            }
            case 1131: {
                final ListIterator listIterator219 = WorkingMemory.lookupWME("BeatMemory", "BeatArgumentWME").listIterator();
                while (listIterator219.hasNext()) {
                    if (listIterator219.next().getTxnInType() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 1134: {
                final ListIterator listIterator220 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator220.hasNext()) {
                    final int subtopicObject134;
                    if (BehavingEntity.constantTrue(subtopicObject134 = listIterator220.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject134));
                        return true;
                    }
                }
                return false;
            }
            case 1136: {
                final ListIterator listIterator221 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator221.hasNext()) {
                    if (listIterator221.next().getSVal().equals("bAAt2N_TxnIn")) {
                        return false;
                    }
                }
                final ListIterator listIterator222 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator222.hasNext()) {
                    if (listIterator222.next().getSVal().equals("bAAt2GPA_TxnIn")) {
                        return false;
                    }
                }
                final ListIterator listIterator223 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator223.hasNext()) {
                    if (listIterator223.next().getSVal().equals("bAAt2TPA_TxnIn")) {
                        return false;
                    }
                }
                return true;
            }
            case 1138: {
                final ListIterator listIterator224 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator224.hasNext()) {
                    final int subtopicObject135;
                    if (BehavingEntity.constantTrue(subtopicObject135 = listIterator224.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject135));
                        return true;
                    }
                }
                return false;
            }
            case 1139: {
                final ListIterator listIterator225 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator225.hasNext()) {
                    final int subtopicObject136;
                    if (BehavingEntity.constantTrue(subtopicObject136 = listIterator225.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject136));
                        return true;
                    }
                }
                return false;
            }
            case 1140: {
                (boolean)array[0];
                final ListIterator listIterator226 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator226.hasNext()) {
                    final int subtopicObject137;
                    if (BehavingEntity.constantTrue(subtopicObject137 = listIterator226.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject137));
                        return true;
                    }
                }
                return false;
            }
            case 1145: {
                final ListIterator listIterator227 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator227.hasNext()) {
                    final int subtopicObject138;
                    if (BehavingEntity.constantTrue(subtopicObject138 = listIterator227.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject138));
                        return true;
                    }
                }
                return false;
            }
            case 1146: {
                final ListIterator listIterator228 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator228.hasNext()) {
                    final int subtopicObject139;
                    if (BehavingEntity.constantTrue(subtopicObject139 = listIterator228.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject139));
                        return true;
                    }
                }
                return false;
            }
            case 1147: {
                (boolean)array[0];
                final ListIterator listIterator229 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator229.hasNext()) {
                    final int subtopicObject140;
                    if (BehavingEntity.constantTrue(subtopicObject140 = listIterator229.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject140));
                        return true;
                    }
                }
                return false;
            }
            case 1149: {
                final ListIterator listIterator230 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator230.hasNext()) {
                    final int subtopicObject141;
                    if (BehavingEntity.constantTrue(subtopicObject141 = listIterator230.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject141));
                        return true;
                    }
                }
                return false;
            }
            case 1150: {
                final ListIterator listIterator231 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator231.hasNext()) {
                    final int subtopicObject142;
                    if (BehavingEntity.constantTrue(subtopicObject142 = listIterator231.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject142));
                        return true;
                    }
                }
                return false;
            }
            case 1152: {
                final ListIterator listIterator232 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator232.hasNext()) {
                    final int subtopicObject143;
                    if (BehavingEntity.constantTrue(subtopicObject143 = listIterator232.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject143));
                        return true;
                    }
                }
                return false;
            }
            case 1153: {
                final ListIterator listIterator233 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator233.hasNext()) {
                    final int subtopicObject144;
                    if (BehavingEntity.constantTrue(subtopicObject144 = listIterator233.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject144));
                        return true;
                    }
                }
                return false;
            }
            case 1154: {
                (boolean)array[0];
                final ListIterator listIterator234 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator234.hasNext()) {
                    final int subtopicObject145;
                    if (BehavingEntity.constantTrue(subtopicObject145 = listIterator234.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject145));
                        return true;
                    }
                }
                return false;
            }
            case 1156: {
                final ListIterator listIterator235 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator235.hasNext()) {
                    final int subtopicObject146;
                    if (BehavingEntity.constantTrue(subtopicObject146 = listIterator235.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject146));
                        return true;
                    }
                }
                return false;
            }
            case 1157: {
                final ListIterator listIterator236 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator236.hasNext()) {
                    final int subtopicObject147;
                    if (BehavingEntity.constantTrue(subtopicObject147 = listIterator236.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject147));
                        return true;
                    }
                }
                return false;
            }
            case 1159: {
                final ListIterator listIterator237 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator237.hasNext()) {
                    final int subtopicObject148;
                    if (BehavingEntity.constantTrue(subtopicObject148 = listIterator237.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject148));
                        return true;
                    }
                }
                return false;
            }
            case 1160: {
                final ListIterator listIterator238 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator238.hasNext()) {
                    final int subtopicObject149;
                    if (BehavingEntity.constantTrue(subtopicObject149 = listIterator238.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject149));
                        return true;
                    }
                }
                return false;
            }
            case 1161: {
                (boolean)array[0];
                final ListIterator listIterator239 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator239.hasNext()) {
                    final int subtopicObject150;
                    if (BehavingEntity.constantTrue(subtopicObject150 = listIterator239.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject150));
                        return true;
                    }
                }
                return false;
            }
            case 1163: {
                final ListIterator listIterator240 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator240.hasNext()) {
                    final int subtopicObject151;
                    if (BehavingEntity.constantTrue(subtopicObject151 = listIterator240.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject151));
                        return true;
                    }
                }
                return false;
            }
            case 1164: {
                final ListIterator listIterator241 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator241.hasNext()) {
                    final int subtopicObject152;
                    if (BehavingEntity.constantTrue(subtopicObject152 = listIterator241.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject152));
                        return true;
                    }
                }
                return false;
            }
            case 1166: {
                final ListIterator listIterator242 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator242.hasNext()) {
                    final int subtopicObject153;
                    if (BehavingEntity.constantTrue(subtopicObject153 = listIterator242.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject153));
                        return true;
                    }
                }
                return false;
            }
            case 1167: {
                final ListIterator listIterator243 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator243.hasNext()) {
                    final int subtopicObject154;
                    if (BehavingEntity.constantTrue(subtopicObject154 = listIterator243.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject154));
                        return true;
                    }
                }
                return false;
            }
            case 1168: {
                (boolean)array[0];
                final ListIterator listIterator244 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator244.hasNext()) {
                    final int subtopicObject155;
                    if (BehavingEntity.constantTrue(subtopicObject155 = listIterator244.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject155));
                        return true;
                    }
                }
                return false;
            }
            case 1170: {
                final ListIterator listIterator245 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator245.hasNext()) {
                    final int subtopicObject156;
                    if (BehavingEntity.constantTrue(subtopicObject156 = listIterator245.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject156));
                        return true;
                    }
                }
                return false;
            }
            case 1171: {
                final ListIterator listIterator246 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator246.hasNext()) {
                    final int subtopicObject157;
                    if (BehavingEntity.constantTrue(subtopicObject157 = listIterator246.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject157));
                        return true;
                    }
                }
                return false;
            }
            case 1173: {
                final ListIterator listIterator247 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator247.hasNext()) {
                    final int subtopicObject158;
                    if (BehavingEntity.constantTrue(subtopicObject158 = listIterator247.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject158));
                        return true;
                    }
                }
                return false;
            }
            case 1174: {
                final ListIterator listIterator248 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator248.hasNext()) {
                    final int subtopicObject159;
                    if (BehavingEntity.constantTrue(subtopicObject159 = listIterator248.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject159));
                        return true;
                    }
                }
                return false;
            }
            case 1175: {
                (boolean)array[0];
                final ListIterator listIterator249 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator249.hasNext()) {
                    final int subtopicObject160;
                    if (BehavingEntity.constantTrue(subtopicObject160 = listIterator249.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject160));
                        return true;
                    }
                }
                return false;
            }
            case 1177: {
                final ListIterator listIterator250 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator250.hasNext()) {
                    final int subtopicObject161;
                    if (BehavingEntity.constantTrue(subtopicObject161 = listIterator250.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject161));
                        return true;
                    }
                }
                return false;
            }
            case 1178: {
                final ListIterator listIterator251 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator251.hasNext()) {
                    final int subtopicObject162;
                    if (BehavingEntity.constantTrue(subtopicObject162 = listIterator251.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject162));
                        return true;
                    }
                }
                return false;
            }
            case 1180: {
                final ListIterator listIterator252 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator252.hasNext()) {
                    final int subtopicObject163;
                    if (BehavingEntity.constantTrue(subtopicObject163 = listIterator252.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject163));
                        return true;
                    }
                }
                return false;
            }
            case 1181: {
                final ListIterator listIterator253 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator253.hasNext()) {
                    final int subtopicObject164;
                    if (BehavingEntity.constantTrue(subtopicObject164 = listIterator253.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject164));
                        return true;
                    }
                }
                return false;
            }
            case 1182: {
                (boolean)array[0];
                final ListIterator listIterator254 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator254.hasNext()) {
                    final int subtopicObject165;
                    if (BehavingEntity.constantTrue(subtopicObject165 = listIterator254.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject165));
                        return true;
                    }
                }
                return false;
            }
            case 1184: {
                final ListIterator listIterator255 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator255.hasNext()) {
                    final int subtopicObject166;
                    if (BehavingEntity.constantTrue(subtopicObject166 = listIterator255.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject166));
                        return true;
                    }
                }
                return false;
            }
            case 1185: {
                final ListIterator listIterator256 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator256.hasNext()) {
                    final int subtopicObject167;
                    if (BehavingEntity.constantTrue(subtopicObject167 = listIterator256.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject167));
                        return true;
                    }
                }
                return false;
            }
            case 1187: {
                final ListIterator listIterator257 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator257.hasNext()) {
                    final int subtopicObject168;
                    if (BehavingEntity.constantTrue(subtopicObject168 = listIterator257.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject168));
                        return true;
                    }
                }
                return false;
            }
            case 1188: {
                final ListIterator listIterator258 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator258.hasNext()) {
                    final int subtopicObject169;
                    if (BehavingEntity.constantTrue(subtopicObject169 = listIterator258.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject169));
                        return true;
                    }
                }
                return false;
            }
            case 1189: {
                (boolean)array[0];
                final ListIterator listIterator259 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator259.hasNext()) {
                    final int subtopicObject170;
                    if (BehavingEntity.constantTrue(subtopicObject170 = listIterator259.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject170));
                        return true;
                    }
                }
                return false;
            }
            case 1191: {
                final ListIterator listIterator260 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator260.hasNext()) {
                    final int subtopicObject171;
                    if (BehavingEntity.constantTrue(subtopicObject171 = listIterator260.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject171));
                        return true;
                    }
                }
                return false;
            }
            case 1192: {
                final ListIterator listIterator261 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator261.hasNext()) {
                    final int subtopicObject172;
                    if (BehavingEntity.constantTrue(subtopicObject172 = listIterator261.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject172));
                        return true;
                    }
                }
                return false;
            }
            case 1194: {
                final ListIterator listIterator262 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator262.hasNext()) {
                    if (listIterator262.next().getSVal().equals("bAA_WaitTimeout_ReestablishStuff")) {
                        return false;
                    }
                }
                return true;
            }
            case 1223: {
                final ListIterator listIterator263 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator263.hasNext()) {
                    if (listIterator263.next().getCurrentBeat() == 18) {
                        return true;
                    }
                }
                return false;
            }
            case 1226: {
                final ListIterator listIterator264 = WorkingMemory.lookupWME("BeatMemory", "BeatArgumentWME").listIterator();
                while (listIterator264.hasNext()) {
                    if (listIterator264.next().getTxnInType() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 1229: {
                final ListIterator listIterator265 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator265.hasNext()) {
                    final int subtopicObject173;
                    if (BehavingEntity.constantTrue(subtopicObject173 = listIterator265.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject173));
                        return true;
                    }
                }
                return false;
            }
            case 1231: {
                final ListIterator listIterator266 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator266.hasNext()) {
                    if (listIterator266.next().getSVal().equals("bAAt2N_TxnIn")) {
                        return false;
                    }
                }
                final ListIterator listIterator267 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator267.hasNext()) {
                    if (listIterator267.next().getSVal().equals("bAAt2GPA_TxnIn")) {
                        return false;
                    }
                }
                final ListIterator listIterator268 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator268.hasNext()) {
                    if (listIterator268.next().getSVal().equals("bAAt2TPA_TxnIn")) {
                        return false;
                    }
                }
                return true;
            }
            case 1233: {
                final ListIterator listIterator269 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator269.hasNext()) {
                    final int subtopicObject174;
                    if (BehavingEntity.constantTrue(subtopicObject174 = listIterator269.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject174));
                        return true;
                    }
                }
                return false;
            }
            case 1234: {
                final ListIterator listIterator270 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator270.hasNext()) {
                    final int subtopicObject175;
                    if (BehavingEntity.constantTrue(subtopicObject175 = listIterator270.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject175));
                        return true;
                    }
                }
                return false;
            }
            case 1235: {
                (boolean)array[0];
                final ListIterator listIterator271 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator271.hasNext()) {
                    final int subtopicObject176;
                    if (BehavingEntity.constantTrue(subtopicObject176 = listIterator271.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject176));
                        return true;
                    }
                }
                return false;
            }
            case 1240: {
                final ListIterator listIterator272 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator272.hasNext()) {
                    final int subtopicObject177;
                    if (BehavingEntity.constantTrue(subtopicObject177 = listIterator272.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject177));
                        return true;
                    }
                }
                return false;
            }
            case 1241: {
                final ListIterator listIterator273 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator273.hasNext()) {
                    final int subtopicObject178;
                    if (BehavingEntity.constantTrue(subtopicObject178 = listIterator273.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject178));
                        return true;
                    }
                }
                return false;
            }
            case 1242: {
                (boolean)array[0];
                final ListIterator listIterator274 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator274.hasNext()) {
                    final int subtopicObject179;
                    if (BehavingEntity.constantTrue(subtopicObject179 = listIterator274.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject179));
                        return true;
                    }
                }
                return false;
            }
            case 1244: {
                final ListIterator listIterator275 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator275.hasNext()) {
                    final int subtopicObject180;
                    if (BehavingEntity.constantTrue(subtopicObject180 = listIterator275.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject180));
                        return true;
                    }
                }
                return false;
            }
            case 1245: {
                final ListIterator listIterator276 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator276.hasNext()) {
                    final int subtopicObject181;
                    if (BehavingEntity.constantTrue(subtopicObject181 = listIterator276.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject181));
                        return true;
                    }
                }
                return false;
            }
            case 1247: {
                final ListIterator listIterator277 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator277.hasNext()) {
                    final int subtopicObject182;
                    if (BehavingEntity.constantTrue(subtopicObject182 = listIterator277.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject182));
                        return true;
                    }
                }
                return false;
            }
            case 1248: {
                final ListIterator listIterator278 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator278.hasNext()) {
                    final int subtopicObject183;
                    if (BehavingEntity.constantTrue(subtopicObject183 = listIterator278.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject183));
                        return true;
                    }
                }
                return false;
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
    
    public static boolean precondition1(final int n, final Object[] array, final Hashtable hashtable, final BehavingEntity behavingEntity) {
        switch (n) {
            case 1249: {
                (boolean)array[0];
                final ListIterator listIterator = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator.hasNext()) {
                    final int subtopicObject;
                    if (BehavingEntity.constantTrue(subtopicObject = listIterator.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject));
                        return true;
                    }
                }
                return false;
            }
            case 1251: {
                final ListIterator listIterator2 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator2.hasNext()) {
                    final int subtopicObject2;
                    if (BehavingEntity.constantTrue(subtopicObject2 = listIterator2.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject2));
                        return true;
                    }
                }
                return false;
            }
            case 1252: {
                final ListIterator listIterator3 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator3.hasNext()) {
                    final int subtopicObject3;
                    if (BehavingEntity.constantTrue(subtopicObject3 = listIterator3.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject3));
                        return true;
                    }
                }
                return false;
            }
            case 1254: {
                final ListIterator listIterator4 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator4.hasNext()) {
                    final int subtopicObject4;
                    if (BehavingEntity.constantTrue(subtopicObject4 = listIterator4.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject4));
                        return true;
                    }
                }
                return false;
            }
            case 1255: {
                final ListIterator listIterator5 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator5.hasNext()) {
                    final int subtopicObject5;
                    if (BehavingEntity.constantTrue(subtopicObject5 = listIterator5.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject5));
                        return true;
                    }
                }
                return false;
            }
            case 1256: {
                (boolean)array[0];
                final ListIterator listIterator6 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator6.hasNext()) {
                    final int subtopicObject6;
                    if (BehavingEntity.constantTrue(subtopicObject6 = listIterator6.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject6));
                        return true;
                    }
                }
                return false;
            }
            case 1258: {
                final ListIterator listIterator7 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator7.hasNext()) {
                    final int subtopicObject7;
                    if (BehavingEntity.constantTrue(subtopicObject7 = listIterator7.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject7));
                        return true;
                    }
                }
                return false;
            }
            case 1259: {
                final ListIterator listIterator8 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator8.hasNext()) {
                    final int subtopicObject8;
                    if (BehavingEntity.constantTrue(subtopicObject8 = listIterator8.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject8));
                        return true;
                    }
                }
                return false;
            }
            case 1261: {
                final ListIterator listIterator9 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator9.hasNext()) {
                    final int subtopicObject9;
                    if (BehavingEntity.constantTrue(subtopicObject9 = listIterator9.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject9));
                        return true;
                    }
                }
                return false;
            }
            case 1262: {
                final ListIterator listIterator10 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator10.hasNext()) {
                    final int subtopicObject10;
                    if (BehavingEntity.constantTrue(subtopicObject10 = listIterator10.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject10));
                        return true;
                    }
                }
                return false;
            }
            case 1263: {
                (boolean)array[0];
                final ListIterator listIterator11 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator11.hasNext()) {
                    final int subtopicObject11;
                    if (BehavingEntity.constantTrue(subtopicObject11 = listIterator11.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject11));
                        return true;
                    }
                }
                return false;
            }
            case 1265: {
                final ListIterator listIterator12 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator12.hasNext()) {
                    final int subtopicObject12;
                    if (BehavingEntity.constantTrue(subtopicObject12 = listIterator12.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject12));
                        return true;
                    }
                }
                return false;
            }
            case 1266: {
                final ListIterator listIterator13 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator13.hasNext()) {
                    final int subtopicObject13;
                    if (BehavingEntity.constantTrue(subtopicObject13 = listIterator13.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject13));
                        return true;
                    }
                }
                return false;
            }
            case 1268: {
                final ListIterator listIterator14 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator14.hasNext()) {
                    final int subtopicObject14;
                    if (BehavingEntity.constantTrue(subtopicObject14 = listIterator14.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject14));
                        return true;
                    }
                }
                return false;
            }
            case 1269: {
                final ListIterator listIterator15 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator15.hasNext()) {
                    final int subtopicObject15;
                    if (BehavingEntity.constantTrue(subtopicObject15 = listIterator15.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject15));
                        return true;
                    }
                }
                return false;
            }
            case 1270: {
                (boolean)array[0];
                final ListIterator listIterator16 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator16.hasNext()) {
                    final int subtopicObject16;
                    if (BehavingEntity.constantTrue(subtopicObject16 = listIterator16.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject16));
                        return true;
                    }
                }
                return false;
            }
            case 1272: {
                final ListIterator listIterator17 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator17.hasNext()) {
                    final int subtopicObject17;
                    if (BehavingEntity.constantTrue(subtopicObject17 = listIterator17.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject17));
                        return true;
                    }
                }
                return false;
            }
            case 1273: {
                final ListIterator listIterator18 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator18.hasNext()) {
                    final int subtopicObject18;
                    if (BehavingEntity.constantTrue(subtopicObject18 = listIterator18.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject18));
                        return true;
                    }
                }
                return false;
            }
            case 1275: {
                final ListIterator listIterator19 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator19.hasNext()) {
                    final int subtopicObject19;
                    if (BehavingEntity.constantTrue(subtopicObject19 = listIterator19.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject19));
                        return true;
                    }
                }
                return false;
            }
            case 1276: {
                final ListIterator listIterator20 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator20.hasNext()) {
                    final int subtopicObject20;
                    if (BehavingEntity.constantTrue(subtopicObject20 = listIterator20.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject20));
                        return true;
                    }
                }
                return false;
            }
            case 1277: {
                (boolean)array[0];
                final ListIterator listIterator21 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator21.hasNext()) {
                    final int subtopicObject21;
                    if (BehavingEntity.constantTrue(subtopicObject21 = listIterator21.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject21));
                        return true;
                    }
                }
                return false;
            }
            case 1279: {
                final ListIterator listIterator22 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator22.hasNext()) {
                    final int subtopicObject22;
                    if (BehavingEntity.constantTrue(subtopicObject22 = listIterator22.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject22));
                        return true;
                    }
                }
                return false;
            }
            case 1280: {
                final ListIterator listIterator23 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator23.hasNext()) {
                    final int subtopicObject23;
                    if (BehavingEntity.constantTrue(subtopicObject23 = listIterator23.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject23));
                        return true;
                    }
                }
                return false;
            }
            case 1282: {
                final ListIterator listIterator24 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator24.hasNext()) {
                    final int subtopicObject24;
                    if (BehavingEntity.constantTrue(subtopicObject24 = listIterator24.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject24));
                        return true;
                    }
                }
                return false;
            }
            case 1283: {
                final ListIterator listIterator25 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator25.hasNext()) {
                    final int subtopicObject25;
                    if (BehavingEntity.constantTrue(subtopicObject25 = listIterator25.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject25));
                        return true;
                    }
                }
                return false;
            }
            case 1284: {
                (boolean)array[0];
                final ListIterator listIterator26 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator26.hasNext()) {
                    final int subtopicObject26;
                    if (BehavingEntity.constantTrue(subtopicObject26 = listIterator26.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject26));
                        return true;
                    }
                }
                return false;
            }
            case 1286: {
                final ListIterator listIterator27 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator27.hasNext()) {
                    final int subtopicObject27;
                    if (BehavingEntity.constantTrue(subtopicObject27 = listIterator27.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject27));
                        return true;
                    }
                }
                return false;
            }
            case 1287: {
                final ListIterator listIterator28 = WorkingMemory.lookupWME("StoryMemory", "BeatAAp1WME").listIterator();
                while (listIterator28.hasNext()) {
                    final int subtopicObject28;
                    if (BehavingEntity.constantTrue(subtopicObject28 = listIterator28.next().getSubtopicObject())) {
                        hashtable.put("subtopicObject", new Integer(subtopicObject28));
                        return true;
                    }
                }
                return false;
            }
            case 1289: {
                final ListIterator listIterator29 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator29.hasNext()) {
                    if (listIterator29.next().getSVal().equals("bAA_WaitTimeout_ReestablishStuff")) {
                        return false;
                    }
                }
                return true;
            }
            case 1316: {
                final ListIterator listIterator30 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator30.hasNext()) {
                    if (listIterator30.next().getCurrentBeat() == 21) {
                        return true;
                    }
                }
                return false;
            }
            case 1372: {
                final ListIterator listIterator31 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator31.hasNext()) {
                    if (listIterator31.next().getCurrentBeat() == 22) {
                        return true;
                    }
                }
                return false;
            }
            case 1428: {
                final ListIterator listIterator32 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator32.hasNext()) {
                    if (listIterator32.next().getCurrentBeat() == 20) {
                        return true;
                    }
                }
                return false;
            }
            case 1433: {
                final ListIterator listIterator33 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator33.hasNext()) {
                    if (listIterator33.next().getSVal().equals("bFAskDrinkT2TPA_TxnIn_whatWeReallyNeed")) {
                        return true;
                    }
                }
                return false;
            }
            case 1448: {
                (boolean)array[0];
                final ListIterator listIterator34 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT2WME").listIterator();
                while (listIterator34.hasNext()) {
                    final BeatFAskDrinkT2WME beatFAskDrinkT2WME = listIterator34.next();
                    final int curDrinkIdea;
                    final int graceDrinkIdea;
                    if (BehavingEntity.constantTrue(curDrinkIdea = beatFAskDrinkT2WME.getCurDrinkIdea()) && BehavingEntity.constantTrue(graceDrinkIdea = beatFAskDrinkT2WME.getGraceDrinkIdea()) && curDrinkIdea >= 5012) {
                        hashtable.put("drink", new Integer(curDrinkIdea));
                        hashtable.put("graceDrink", new Integer(graceDrinkIdea));
                        return true;
                    }
                }
                return false;
            }
            case 1450: {
                final boolean booleanValue = (boolean)array[0];
                (int)array[1];
                return booleanValue;
            }
            case 1451: {
                (boolean)array[0];
                final int intValue = (int)array[1];
                return intValue == 5004 || intValue == 5005 || intValue == 5006 || intValue == 5007 || intValue == 5008 || intValue == 5011;
            }
            case 1452: {
                (boolean)array[0];
                return (int)array[1] == 5000;
            }
            case 1453: {
                (boolean)array[0];
                return (int)array[1] == 5000;
            }
            case 1455: {
                (boolean)array[0];
                final ListIterator listIterator35 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT2WME").listIterator();
                while (listIterator35.hasNext()) {
                    final BeatFAskDrinkT2WME beatFAskDrinkT2WME2 = listIterator35.next();
                    final int curDrinkIdea2;
                    final int graceDrinkIdea2;
                    if (BehavingEntity.constantTrue(curDrinkIdea2 = beatFAskDrinkT2WME2.getCurDrinkIdea()) && BehavingEntity.constantTrue(graceDrinkIdea2 = beatFAskDrinkT2WME2.getGraceDrinkIdea()) && curDrinkIdea2 < 5012) {
                        hashtable.put("drink", new Integer(curDrinkIdea2));
                        hashtable.put("graceDrink", new Integer(graceDrinkIdea2));
                        return true;
                    }
                }
                return false;
            }
            case 1457: {
                final int intValue2 = (int)array[0];
                return intValue2 == 5008 || intValue2 == 5011;
            }
            case 1458: {
                final int intValue3 = (int)array[0];
                return intValue3 == 5004 || intValue3 == 5005 || intValue3 == 5006 || intValue3 == 5007;
            }
            case 1459: {
                final int intValue4 = (int)array[0];
                return intValue4 == 5009 || intValue4 == 5010;
            }
            case 1460: {
                final int intValue5 = (int)array[0];
                return intValue5 == 5002 || intValue5 == 5003;
            }
            case 1461: {
                return (int)array[0] == 5000;
            }
            case 1478: {
                return (int)array[0] == 44;
            }
            case 1479: {
                return (int)array[0] != 44;
            }
            case 1482: {
                final ListIterator listIterator36 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator36.hasNext()) {
                    if (listIterator36.next().getCurrentBeat() == 19) {
                        return true;
                    }
                }
                return false;
            }
            case 1494: {
                final ListIterator listIterator37 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator37.hasNext()) {
                    if (listIterator37.next().getSVal().equals("FixDrinksZingerSwizzle")) {
                        return false;
                    }
                }
                return true;
            }
            case 1495: {
                final ListIterator listIterator38 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator38.hasNext()) {
                    if (listIterator38.next().getSVal().equals("FixDrinksZingerGolfScore")) {
                        return false;
                    }
                }
                return true;
            }
            case 1496: {
                final ListIterator listIterator39 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator39.hasNext()) {
                    if (listIterator39.next().getSVal().equals("FixDrinksZingerHello")) {
                        return false;
                    }
                }
                return true;
            }
            case 1497: {
                final ListIterator listIterator40 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator40.hasNext()) {
                    if (listIterator40.next().getSVal().equals("FixDrinksZingerSilver")) {
                        return false;
                    }
                }
                return true;
            }
            case 1505: {
                (boolean)array[0];
                final ListIterator listIterator41 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT2WME").listIterator();
                while (listIterator41.hasNext()) {
                    final BeatFAskDrinkT2WME beatFAskDrinkT2WME3 = listIterator41.next();
                    final int curDrinkIdea3;
                    final int graceDrinkIdea3;
                    if (BehavingEntity.constantTrue(curDrinkIdea3 = beatFAskDrinkT2WME3.getCurDrinkIdea()) && BehavingEntity.constantTrue(graceDrinkIdea3 = beatFAskDrinkT2WME3.getGraceDrinkIdea()) && curDrinkIdea3 >= 5012) {
                        hashtable.put("drink", new Integer(curDrinkIdea3));
                        hashtable.put("graceDrink", new Integer(graceDrinkIdea3));
                        return true;
                    }
                }
                return false;
            }
            case 1507: {
                (boolean)array[0];
                final int intValue6 = (int)array[1];
                return intValue6 == 5004 || intValue6 == 5005 || intValue6 == 5006 || intValue6 == 5007 || intValue6 == 5008 || intValue6 == 5011;
            }
            case 1508: {
                (boolean)array[0];
                return (int)array[1] == 5000;
            }
            case 1509: {
                (boolean)array[0];
                return (int)array[1] == 5000;
            }
            case 1511: {
                (boolean)array[0];
                final ListIterator listIterator42 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT2WME").listIterator();
                while (listIterator42.hasNext()) {
                    final BeatFAskDrinkT2WME beatFAskDrinkT2WME4 = listIterator42.next();
                    final int curDrinkIdea4;
                    final int graceDrinkIdea4;
                    if (BehavingEntity.constantTrue(curDrinkIdea4 = beatFAskDrinkT2WME4.getCurDrinkIdea()) && BehavingEntity.constantTrue(graceDrinkIdea4 = beatFAskDrinkT2WME4.getGraceDrinkIdea()) && curDrinkIdea4 < 5012) {
                        hashtable.put("drink", new Integer(curDrinkIdea4));
                        hashtable.put("graceDrink", new Integer(graceDrinkIdea4));
                        return true;
                    }
                }
                return false;
            }
            case 1513: {
                final int intValue7 = (int)array[0];
                return intValue7 == 5008 || intValue7 == 5011;
            }
            case 1514: {
                final int intValue8 = (int)array[0];
                return intValue8 == 5004 || intValue8 == 5005 || intValue8 == 5006 || intValue8 == 5007;
            }
            case 1515: {
                final int intValue9 = (int)array[0];
                return intValue9 == 5009 || intValue9 == 5010;
            }
            case 1516: {
                final int intValue10 = (int)array[0];
                return intValue10 == 5002 || intValue10 == 5003;
            }
            case 1517: {
                return (int)array[0] == 5000;
            }
            case 1534: {
                return (int)array[0] == 44;
            }
            case 1535: {
                return (int)array[0] != 44;
            }
            case 1538: {
                final ListIterator listIterator43 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator43.hasNext()) {
                    if (listIterator43.next().getCurrentBeat() == 24) {
                        return true;
                    }
                }
                return false;
            }
            case 1566: {
                final ListIterator listIterator44 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator44.hasNext()) {
                    if (listIterator44.next().getCurrentBeat() == 23) {
                        return true;
                    }
                }
                return false;
            }
            case 1588: {
                return (int)array[0] == 0;
            }
            case 1589: {
                return (int)array[0] == 1;
            }
            case 1590: {
                return (int)array[0] == 2;
            }
            case 1591: {
                return (int)array[0] == 3;
            }
            case 1592: {
                return (int)array[0] == 4;
            }
            case 1593: {
                return (int)array[0] == 6;
            }
            case 1594: {
                final int intValue11 = (int)array[0];
                return intValue11 == 7 || intValue11 == 8;
            }
            case 1595: {
                return (int)array[0] == 9;
            }
            case 1596: {
                return (int)array[0] == 9;
            }
            case 1626: {
                final ListIterator listIterator45 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator45.hasNext()) {
                    if (listIterator45.next().getSVal().equals("bOneOnOneGAffChrT2_souffle")) {
                        return true;
                    }
                }
                return false;
            }
            case 1627: {
                final ListIterator listIterator46 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator46.hasNext()) {
                    if (listIterator46.next().getSVal().equals("bOneOnOneGAffChrT2_biscotti")) {
                        return true;
                    }
                }
                return false;
            }
            case 1629: {
                final ListIterator listIterator47 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator47.hasNext()) {
                    if (listIterator47.next().getSVal().equals("bOneOnOneGAffChrT2_souffle")) {
                        return true;
                    }
                }
                return false;
            }
            case 1630: {
                final ListIterator listIterator48 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator48.hasNext()) {
                    if (listIterator48.next().getSVal().equals("bOneOnOneGAffChrT2_biscotti")) {
                        return true;
                    }
                }
                return false;
            }
            case 1646: {
                final ListIterator listIterator49 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator49.hasNext()) {
                    if (listIterator49.next().getCurrentBeat() == 26) {
                        return true;
                    }
                }
                return false;
            }
            case 1660: {
                final ListIterator listIterator50 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator50.hasNext()) {
                    if (listIterator50.next().getCurrentBeat() == 25) {
                        return true;
                    }
                }
                return false;
            }
            case 1670: {
                return (boolean)array[0];
            }
            case 1685: {
                return (boolean)array[0];
            }
            case 1689: {
                return (int)array[0] == 0;
            }
            case 1690: {
                return (int)array[0] == 1;
            }
            case 1691: {
                return (int)array[0] == 2;
            }
            case 1692: {
                return (int)array[0] == 3;
            }
            case 1693: {
                return (int)array[0] == 4;
            }
            case 1694: {
                return (int)array[0] == 6;
            }
            case 1695: {
                final int intValue12 = (int)array[0];
                return intValue12 == 7 || intValue12 == 8;
            }
            case 1696: {
                return (int)array[0] == 9;
            }
            case 1697: {
                return (int)array[0] == 9;
            }
            case 1722: {
                final ListIterator listIterator51 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator51.hasNext()) {
                    if (listIterator51.next().getCurrentBeat() == 27) {
                        return true;
                    }
                }
                return false;
            }
            case 1734: {
                return (int)array[0] != 25;
            }
            case 1737: {
                return (boolean)array[0];
            }
            case 1744: {
                final ListIterator listIterator52 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator52.hasNext()) {
                    if (listIterator52.next().getCurrentBeat() == 28) {
                        return true;
                    }
                }
                return false;
            }
            case 1746: {
                final ListIterator listIterator53 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator53.hasNext()) {
                    if (listIterator53.next().getSVal().equals("bOneOnOneGAffChrT2_FlirtKissOppSex")) {
                        return true;
                    }
                }
                return false;
            }
            case 1750: {
                final ListIterator listIterator54 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator54.hasNext()) {
                    if (listIterator54.next().getSVal().equals("bOneOnOneGAffChrT2_StrongNeg")) {
                        return true;
                    }
                }
                return false;
            }
            case 1766: {
                final ListIterator listIterator55 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator55.hasNext()) {
                    if (listIterator55.next().getCurrentBeat() == 29) {
                        return true;
                    }
                }
                return false;
            }
            case 1771: {
                final ListIterator listIterator56 = WorkingMemory.lookupWME("StoryMemory", "BeatRomPrpWME").listIterator();
                if (!listIterator56.hasNext()) {
                    return false;
                }
                hashtable.put("myWME", new ObjectWrapper(listIterator56.next()));
                return true;
            }
            case 1772: {
                final ListIterator listIterator57 = WorkingMemory.lookupWME("StoryMemory", "BeatRomPrpWME").listIterator();
                while (listIterator57.hasNext()) {
                    final int sprite;
                    if (BehavingEntity.constantTrue(sprite = listIterator57.next().getSprite())) {
                        hashtable.put("sprite", new Integer(sprite));
                        return true;
                    }
                }
                return false;
            }
            case 1773: {
                final ListIterator listIterator58 = WorkingMemory.lookupWME("StoryMemory", "BeatRomPrpWME").listIterator();
                while (listIterator58.hasNext()) {
                    if (listIterator58.next().getSprite() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 1774: {
                final ListIterator listIterator59 = WorkingMemory.lookupWME("StoryMemory", "BeatRomPrpWME").listIterator();
                while (listIterator59.hasNext()) {
                    if (listIterator59.next().getSprite() == 6) {
                        return true;
                    }
                }
                return false;
            }
            case 1775: {
                final ListIterator listIterator60 = WorkingMemory.lookupWME("StoryMemory", "BeatRomPrpWME").listIterator();
                while (listIterator60.hasNext()) {
                    if (listIterator60.next().getSprite() == 7) {
                        return true;
                    }
                }
                return false;
            }
            case 1776: {
                final ListIterator listIterator61 = WorkingMemory.lookupWME("StoryMemory", "BeatRomPrpWME").listIterator();
                while (listIterator61.hasNext()) {
                    if (listIterator61.next().getSprite() == 5) {
                        return true;
                    }
                }
                return false;
            }
            case 1777: {
                final ListIterator listIterator62 = WorkingMemory.lookupWME("StoryMemory", "BeatRomPrpWME").listIterator();
                while (listIterator62.hasNext()) {
                    final int sprite2;
                    if (BehavingEntity.constantTrue(sprite2 = listIterator62.next().getSprite())) {
                        hashtable.put("sprite", new Integer(sprite2));
                        return true;
                    }
                }
                return false;
            }
            case 1793: {
                final ListIterator listIterator63 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator63.hasNext()) {
                    if (listIterator63.next().getCurrentBeat() == 30) {
                        return true;
                    }
                }
                return false;
            }
            case 1794: {
                final ListIterator listIterator64 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator64.hasNext()) {
                    if (listIterator64.next().getCurrentBeat() == 31) {
                        return true;
                    }
                }
                return false;
            }
            case 1795: {
                final ListIterator listIterator65 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator65.hasNext()) {
                    final BeatCrisisP1WME beatCrisisP1WME = listIterator65.next();
                    final int currentAccusationPCType;
                    final int currentAccusationPCParam;
                    if (BehavingEntity.constantTrue(currentAccusationPCType = beatCrisisP1WME.getCurrentAccusationPCType()) && BehavingEntity.constantTrue(currentAccusationPCParam = beatCrisisP1WME.getCurrentAccusationPCParam())) {
                        hashtable.put("currentAccusationPCParam", new Integer(currentAccusationPCParam));
                        hashtable.put("currentAccusationPCType", new Integer(currentAccusationPCType));
                        return true;
                    }
                }
                return false;
            }
            case 1797: {
                final int intValue13 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                return (boolean)array[4] && intValue13 != -1;
            }
            case 1798: {
                (int)array[0];
                final int intValue14 = (int)array[1];
                (int)array[2];
                (int)array[3];
                return (boolean)array[4] && intValue14 != -1;
            }
            case 1799: {
                final ListIterator listIterator66 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator66.hasNext()) {
                    final int currentAccusationID;
                    if (BehavingEntity.constantTrue(currentAccusationID = listIterator66.next().getCurrentAccusationID())) {
                        hashtable.put("currentAccusationID", new Integer(currentAccusationID));
                        return true;
                    }
                }
                return false;
            }
            case 1801: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                return (boolean)array[3];
            }
            case 1804: {
                final int intValue15 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                return (boolean)array[4] && intValue15 != -1;
            }
            case 1805: {
                (int)array[0];
                final int intValue16 = (int)array[1];
                (int)array[2];
                (int)array[3];
                return (boolean)array[4] && intValue16 != -1;
            }
            case 1808: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                return (boolean)array[3];
            }
            case 1811: {
                (int)array[0];
                return (int)array[1] != -1;
            }
            case 1812: {
                return (int)array[0] != -1;
            }
            case 1813: {
                final int intValue17 = (int)array[0];
                (int)array[1];
                (int)array[2];
                return intValue17 != -1;
            }
            case 1820: {
                final ListIterator listIterator67 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator67.hasNext()) {
                    if (listIterator67.next().getCharacterID() == ((Grace)behavingEntity).me) {
                        return false;
                    }
                }
                return true;
            }
            case 1821: {
                final ListIterator listIterator68 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator68.hasNext()) {
                    if (listIterator68.next().getCharacterID() == ((Grace)behavingEntity).me) {
                        return false;
                    }
                }
                return true;
            }
            case 1822: {
                final ListIterator listIterator69 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator69.hasNext()) {
                    if (listIterator69.next().getCharacterID() == ((Grace)behavingEntity).me) {
                        return false;
                    }
                }
                return true;
            }
            case 1823: {
                final ListIterator listIterator70 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator70.hasNext()) {
                    if (listIterator70.next().getCharacterID() == ((Grace)behavingEntity).me) {
                        return false;
                    }
                }
                return true;
            }
            case 1824: {
                final ListIterator listIterator71 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator71.hasNext()) {
                    if (listIterator71.next().getCharacterID() == ((Grace)behavingEntity).me) {
                        return false;
                    }
                }
                return true;
            }
            case 1825: {
                final ListIterator listIterator72 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator72.hasNext()) {
                    if (listIterator72.next().getCharacterID() == ((Grace)behavingEntity).me) {
                        return false;
                    }
                }
                return true;
            }
            case 1842: {
                if ((int)array[0] == ((Grace)behavingEntity).spouse) {
                    final ListIterator listIterator73 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                    while (listIterator73.hasNext()) {
                        if (listIterator73.next().getCurrentAccuserChr() == ((Grace)behavingEntity).spouse) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 1844: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1845: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1846: {
                if ((int)array[0] == ((Grace)behavingEntity).me) {
                    final ListIterator listIterator74 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                    while (listIterator74.hasNext()) {
                        if (listIterator74.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 1847: {
                final ListIterator listIterator75 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator75.hasNext()) {
                    if (listIterator75.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1848: {
                final int intValue18 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue18 == ((Grace)behavingEntity).me;
            }
            case 1849: {
                final int intValue19 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue19 != ((Grace)behavingEntity).me;
            }
            case 1850: {
                final int intValue20 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue20 == ((Grace)behavingEntity).me;
            }
            case 1851: {
                final int intValue21 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue21 != ((Grace)behavingEntity).me;
            }
            case 1852: {
                final ListIterator listIterator76 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                if (!listIterator76.hasNext()) {
                    return false;
                }
                hashtable.put("beatWME", new ObjectWrapper(listIterator76.next()));
                return true;
            }
            case 1853: {
                final ListIterator listIterator77 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator77.hasNext()) {
                    if (listIterator77.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1854: {
                final ListIterator listIterator78 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator78.hasNext()) {
                    if (listIterator78.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1855: {
                final ListIterator listIterator79 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator79.hasNext()) {
                    if (listIterator79.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1856: {
                final ListIterator listIterator80 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator80.hasNext()) {
                    final BeatCrisisP1WME beatCrisisP1WME2;
                    if ((beatCrisisP1WME2 = listIterator80.next()).getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        hashtable.put("beatWME", new ObjectWrapper(beatCrisisP1WME2));
                        return true;
                    }
                }
                return false;
            }
            case 1857: {
                final ListIterator listIterator81 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator81.hasNext()) {
                    if (listIterator81.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1858: {
                final ListIterator listIterator82 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator82.hasNext()) {
                    if (listIterator82.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1859: {
                final ListIterator listIterator83 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator83.hasNext()) {
                    if (listIterator83.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1860: {
                final ListIterator listIterator84 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                if (!listIterator84.hasNext()) {
                    return false;
                }
                hashtable.put("beatWME", new ObjectWrapper(listIterator84.next()));
                return true;
            }
            case 1862: {
                final ListIterator listIterator85 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                if (!listIterator85.hasNext()) {
                    return false;
                }
                hashtable.put("beatWME", new ObjectWrapper(listIterator85.next()));
                return true;
            }
            case 1863: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1864: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1865: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1866: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1867: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1868: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1869: {
                final int intValue22 = (int)array[0];
                (int)array[1];
                if (intValue22 != -1) {
                    final ListIterator listIterator86 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                    while (listIterator86.hasNext()) {
                        if (listIterator86.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 1871: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1872: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1873: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1874: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1875: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1876: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1877: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1878: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1879: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1880: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1881: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1882: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1883: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator87 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator87.hasNext()) {
                    if (listIterator87.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1884: {
                final ListIterator listIterator88 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator88.hasNext()) {
                    if (listIterator88.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1885: {
                final ListIterator listIterator89 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator89.hasNext()) {
                    if (listIterator89.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1887: {
                final int intValue23 = (int)array[0];
                (int)array[1];
                (int)array[2];
                return intValue23 == ((Grace)behavingEntity).me;
            }
            case 1888: {
                final int intValue24 = (int)array[0];
                (int)array[1];
                return intValue24 != -1;
            }
            case 1889: {
                final int intValue25 = (int)array[0];
                (int)array[1];
                return intValue25 == -1;
            }
            case 1890: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1891: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1892: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1893: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1894: {
                final int intValue26 = (int)array[0];
                (int)array[1];
                (int)array[2];
                return intValue26 != ((Grace)behavingEntity).me;
            }
            case 1895: {
                final ListIterator listIterator90 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator90.hasNext()) {
                    if (listIterator90.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1896: {
                final ListIterator listIterator91 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator91.hasNext()) {
                    if (listIterator91.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1897: {
                final ListIterator listIterator92 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator92.hasNext()) {
                    final BeatCrisisP1WME beatCrisisP1WME3;
                    if ((beatCrisisP1WME3 = listIterator92.next()).getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        hashtable.put("beatWME", new ObjectWrapper(beatCrisisP1WME3));
                        return true;
                    }
                }
                return false;
            }
            case 1898: {
                final ListIterator listIterator93 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator93.hasNext()) {
                    if (listIterator93.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1900: {
                final int intValue27 = (int)array[0];
                (int)array[1];
                (int)array[2];
                return intValue27 == ((Grace)behavingEntity).me;
            }
            case 1901: {
                final int intValue28 = (int)array[0];
                (int)array[1];
                return intValue28 != -1;
            }
            case 1902: {
                final int intValue29 = (int)array[0];
                (int)array[1];
                return intValue29 == -1;
            }
            case 1903: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1904: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1905: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1906: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1907: {
                final int intValue30 = (int)array[0];
                (int)array[1];
                (int)array[2];
                return intValue30 != ((Grace)behavingEntity).me;
            }
            case 1908: {
                final ListIterator listIterator94 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator94.hasNext()) {
                    final BeatCrisisP1WME beatCrisisP1WME4 = listIterator94.next();
                    final int currentAccusationID2;
                    if (beatCrisisP1WME4.getCurrentAccuserChr() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(currentAccusationID2 = beatCrisisP1WME4.getCurrentAccusationID()) && currentAccusationID2 != -1) {
                        hashtable.put("currentAccusationID", new Integer(currentAccusationID2));
                        return true;
                    }
                }
                return false;
            }
            case 1909: {
                final ListIterator listIterator95 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator95.hasNext()) {
                    if (listIterator95.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1910: {
                final ListIterator listIterator96 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator96.hasNext()) {
                    final BeatCrisisP1WME beatCrisisP1WME5 = listIterator96.next();
                    final int currentAccusationID3;
                    if (beatCrisisP1WME5.getCurrentAccuserChr() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(currentAccusationID3 = beatCrisisP1WME5.getCurrentAccusationID()) && currentAccusationID3 != -1) {
                        hashtable.put("currentAccusationID", new Integer(currentAccusationID3));
                        return true;
                    }
                }
                return false;
            }
            case 1911: {
                final ListIterator listIterator97 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator97.hasNext()) {
                    if (listIterator97.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1913: {
                final ListIterator listIterator98 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator98.hasNext()) {
                    if (listIterator98.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1915: {
                final ListIterator listIterator99 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator99.hasNext()) {
                    if (listIterator99.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1919: {
                final ListIterator listIterator100 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator100.hasNext()) {
                    if (listIterator100.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1921: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1922: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1923: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1924: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1925: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1926: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1927: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1928: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1929: {
                final int intValue31 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue31 != ((Grace)behavingEntity).me;
            }
            case 1930: {
                final int intValue32 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue32 == ((Grace)behavingEntity).me;
            }
            case 1931: {
                final int intValue33 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue33 != ((Grace)behavingEntity).me;
            }
            case 1932: {
                final int intValue34 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue34 == ((Grace)behavingEntity).me;
            }
            case 1933: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1934: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1935: {
                final int intValue35 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue35 == 0;
            }
            case 1936: {
                final int intValue36 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue36 == 2;
            }
            case 1937: {
                final int intValue37 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue37 == 4;
            }
            case 1938: {
                final int intValue38 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue38 == 3;
            }
            case 1939: {
                final int intValue39 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue39 == 5;
            }
            case 1940: {
                final int intValue40 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue40 == 6;
            }
            case 1941: {
                final int intValue41 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue41 == 1;
            }
            case 1942: {
                final int intValue42 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue42 == 7;
            }
            case 1943: {
                final int intValue43 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue43 == 8;
            }
            case 1944: {
                final int intValue44 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue44 == 9;
            }
            case 1945: {
                final int intValue45 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue45 == 0;
            }
            case 1946: {
                final int intValue46 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue46 == 2;
            }
            case 1947: {
                final int intValue47 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue47 == 4;
            }
            case 1948: {
                final int intValue48 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue48 == 3;
            }
            case 1949: {
                final int intValue49 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue49 == 5;
            }
            case 1950: {
                final int intValue50 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue50 == 6;
            }
            case 1951: {
                final int intValue51 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue51 == 1;
            }
            case 1952: {
                final int intValue52 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue52 == 7;
            }
            case 1953: {
                final int intValue53 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue53 == 8;
            }
            case 1954: {
                final int intValue54 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue54 == 9;
            }
            case 1955: {
                final int intValue55 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue55 == 0;
            }
            case 1956: {
                final int intValue56 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue56 == 2;
            }
            case 1957: {
                final int intValue57 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue57 == 4;
            }
            case 1958: {
                final int intValue58 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue58 == 3;
            }
            case 1959: {
                final int intValue59 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue59 == 5;
            }
            case 1960: {
                final int intValue60 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue60 == 6;
            }
            case 1961: {
                final int intValue61 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue61 == 1;
            }
            case 1962: {
                final int intValue62 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue62 == 7;
            }
            case 1963: {
                final int intValue63 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue63 == 8;
            }
            case 1964: {
                final int intValue64 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue64 == 9;
            }
            case 1965: {
                final int intValue65 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue65 == 0;
            }
            case 1966: {
                final int intValue66 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue66 == 2;
            }
            case 1967: {
                final int intValue67 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue67 == 4;
            }
            case 1968: {
                final int intValue68 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue68 == 3;
            }
            case 1969: {
                final int intValue69 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue69 == 5;
            }
            case 1970: {
                final int intValue70 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue70 == 6;
            }
            case 1971: {
                final int intValue71 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue71 == 1;
            }
            case 1972: {
                final int intValue72 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue72 == 7;
            }
            case 1973: {
                final int intValue73 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue73 == 8;
            }
            case 1974: {
                final int intValue74 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue74 == 9;
            }
            case 1975: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1976: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1977: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1978: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1979: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1980: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1981: {
                final ListIterator listIterator101 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator101.hasNext()) {
                    if (listIterator101.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1984: {
                final ListIterator listIterator102 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator102.hasNext()) {
                    if (listIterator102.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1986: {
                final ListIterator listIterator103 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator103.hasNext()) {
                    if (listIterator103.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1988: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1989: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1990: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1991: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1992: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1993: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1994: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 1995: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1996: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1997: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 1998: {
                (int)array[0];
                final ListIterator listIterator104 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator104.hasNext()) {
                    if (listIterator104.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 1999: {
                final int intValue75 = (int)array[0];
                return intValue75 == 45 || intValue75 == 47;
            }
            case 2000: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2001: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2002: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2003: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2004: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2005: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2006: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2007: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2008: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2009: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2011: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2012: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2013: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2014: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2015: {
                (int)array[0];
                final ListIterator listIterator105 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator105.hasNext()) {
                    if (listIterator105.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2016: {
                final int intValue76 = (int)array[0];
                return intValue76 == 45 || intValue76 == 47;
            }
            case 2018: {
                final ListIterator listIterator106 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator106.hasNext()) {
                    if (listIterator106.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2020: {
                final ListIterator listIterator107 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator107.hasNext()) {
                    if (listIterator107.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2022: {
                final ListIterator listIterator108 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator108.hasNext()) {
                    if (listIterator108.next().getCurrentAccuserChr() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2023: {
                final ListIterator listIterator109 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                while (listIterator109.hasNext()) {
                    if (listIterator109.next().getCurrentAccuserChr() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2024: {
                final ListIterator listIterator110 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                if (!listIterator110.hasNext()) {
                    return false;
                }
                hashtable.put("beatWME", new ObjectWrapper(listIterator110.next()));
                return true;
            }
            case 2025: {
                final int intValue77 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue77 == 0;
            }
            case 2026: {
                final int intValue78 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue78 == 0;
            }
            case 2027: {
                final int intValue79 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue79 == 0;
            }
            case 2028: {
                final int intValue80 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue80 == 0;
            }
            case 2029: {
                final int intValue81 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue81 == 0;
            }
            case 2030: {
                final int intValue82 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue82 == 0;
            }
            case 2031: {
                final int intValue83 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue83 == 1;
            }
            case 2032: {
                final int intValue84 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue84 == 1;
            }
            case 2033: {
                final int intValue85 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue85 == 1;
            }
            case 2034: {
                final int intValue86 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue86 == 1;
            }
            case 2035: {
                final int intValue87 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue87 == 1;
            }
            case 2036: {
                final int intValue88 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue88 == 2;
            }
            case 2037: {
                final int intValue89 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue89 == 2;
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
    
    public static boolean precondition2(final int n, final Object[] array, final Hashtable hashtable, final BehavingEntity behavingEntity) {
        switch (n) {
            case 2038: {
                final int intValue = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue == 2;
            }
            case 2039: {
                final int intValue2 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue2 == 2;
            }
            case 2040: {
                final int intValue3 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue3 == 0;
            }
            case 2041: {
                final int intValue4 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue4 == 0;
            }
            case 2042: {
                final int intValue5 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue5 == 0;
            }
            case 2043: {
                final int intValue6 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue6 == 0;
            }
            case 2044: {
                final int intValue7 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue7 == 0;
            }
            case 2045: {
                final int intValue8 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue8 == 0;
            }
            case 2046: {
                final int intValue9 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue9 == 1;
            }
            case 2047: {
                final int intValue10 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue10 == 1;
            }
            case 2048: {
                final int intValue11 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue11 == 1;
            }
            case 2049: {
                final int intValue12 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue12 == 1;
            }
            case 2050: {
                final int intValue13 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue13 == 1;
            }
            case 2051: {
                final int intValue14 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue14 == 2;
            }
            case 2052: {
                final int intValue15 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue15 == 2;
            }
            case 2053: {
                final int intValue16 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue16 == 2;
            }
            case 2054: {
                final int intValue17 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue17 == 2;
            }
            case 2055: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2056: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2057: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2058: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2059: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2060: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2061: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2062: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2063: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2064: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2065: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2066: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2067: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2068: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2069: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2070: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2071: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2073: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2075: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2077: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2078: {
                (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2080: {
                (int)array[0];
                return ((Grace)behavingEntity).me != ((Grace)behavingEntity).trip;
            }
            case 2081: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2083: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2084: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2086: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2087: {
                (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2089: {
                (int)array[0];
                return ((Grace)behavingEntity).me != ((Grace)behavingEntity).trip;
            }
            case 2090: {
                (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2092: {
                (int)array[0];
                return ((Grace)behavingEntity).me != ((Grace)behavingEntity).grace;
            }
            case 2093: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2095: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2096: {
                final ListIterator listIterator = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator.hasNext()) {
                    if (listIterator.next().getCurrentBeat() == 32) {
                        return true;
                    }
                }
                return false;
            }
            case 2097: {
                (boolean)array[0];
                (boolean)array[1];
                final ListIterator listIterator2 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getCharacterID() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2098: {
                final boolean booleanValue = (boolean)array[0];
                (boolean)array[1];
                final ListIterator listIterator3 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator3.hasNext()) {
                    if (!listIterator3.next().getBSwitchedToKitchen()) {
                        final ListIterator listIterator4 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final ObjectPositionWME objectPositionWME = listIterator4.next();
                            final float x;
                            final float z;
                            if (objectPositionWME.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x = objectPositionWME.getX()) && BehavingEntity.constantTrue(z = objectPositionWME.getZ())) {
                                final ListIterator listIterator5 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator5.hasNext()) {
                                    final ObjectPositionWME objectPositionWME2 = listIterator5.next();
                                    final float x2;
                                    final float z2;
                                    if (objectPositionWME2.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x2 = objectPositionWME2.getX()) && BehavingEntity.constantTrue(z2 = objectPositionWME2.getZ()) && (booleanValue || Staging.getXZDistanceBetweenPoints(x, z, x2, z2) < 100.0f)) {
                                        hashtable.put("playerX", new Float(x2));
                                        hashtable.put("myX", new Float(x));
                                        hashtable.put("playerZ", new Float(z2));
                                        hashtable.put("myZ", new Float(z));
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 2099: {
                return (boolean)array[0];
            }
            case 2100: {
                final ListIterator listIterator6 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator6.hasNext()) {
                    if (listIterator6.next().getWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2101: {
                final ListIterator listIterator7 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator7.hasNext()) {
                    if (listIterator7.next().getWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2102: {
                final ListIterator listIterator8 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator8.hasNext()) {
                    if (listIterator8.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2103: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2104: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2105: {
                final ListIterator listIterator9 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator9.hasNext()) {
                    if (!listIterator9.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2106: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2107: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2108: {
                final ListIterator listIterator10 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator10.hasNext()) {
                    if (listIterator10.next().getWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2109: {
                final ListIterator listIterator11 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator11.hasNext()) {
                    if (listIterator11.next().getWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2110: {
                final ListIterator listIterator12 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator12.hasNext()) {
                    if (listIterator12.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2111: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2112: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2113: {
                final ListIterator listIterator13 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator13.hasNext()) {
                    if (!listIterator13.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2114: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2115: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2116: {
                final ListIterator listIterator14 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator14.hasNext()) {
                    if (listIterator14.next().getWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2117: {
                final ListIterator listIterator15 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator15.hasNext()) {
                    if (listIterator15.next().getWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2118: {
                final ListIterator listIterator16 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator16.hasNext()) {
                    if (listIterator16.next().getWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2119: {
                final ListIterator listIterator17 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator17.hasNext()) {
                    if (listIterator17.next().getWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2120: {
                final ListIterator listIterator18 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator18.hasNext()) {
                    if (listIterator18.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2121: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2122: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2123: {
                final ListIterator listIterator19 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator19.hasNext()) {
                    if (!listIterator19.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2124: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2125: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2126: {
                final ListIterator listIterator20 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator20.hasNext()) {
                    if (listIterator20.next().getWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2127: {
                final ListIterator listIterator21 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator21.hasNext()) {
                    if (listIterator21.next().getWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2128: {
                final ListIterator listIterator22 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator22.hasNext()) {
                    if (listIterator22.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2129: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2130: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2131: {
                final ListIterator listIterator23 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator23.hasNext()) {
                    if (!listIterator23.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2132: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2133: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2134: {
                final ListIterator listIterator24 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator24.hasNext()) {
                    if (listIterator24.next().getWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2135: {
                final ListIterator listIterator25 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator25.hasNext()) {
                    if (listIterator25.next().getWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2136: {
                final ListIterator listIterator26 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator26.hasNext()) {
                    if (listIterator26.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2137: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2138: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2139: {
                final ListIterator listIterator27 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator27.hasNext()) {
                    if (!listIterator27.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2140: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2141: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2142: {
                final ListIterator listIterator28 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator28.hasNext()) {
                    if (listIterator28.next().getWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2143: {
                final ListIterator listIterator29 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator29.hasNext()) {
                    if (listIterator29.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2144: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2145: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2146: {
                final ListIterator listIterator30 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator30.hasNext()) {
                    if (!listIterator30.next().getBFuriousOrUpset()) {
                        return true;
                    }
                }
                return false;
            }
            case 2147: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2148: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2149: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2150: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2151: {
                final ListIterator listIterator31 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator31.hasNext()) {
                    if (listIterator31.next().getWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2153: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2154: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2155: {
                (int)array[0];
                final ListIterator listIterator32 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator32.hasNext()) {
                    if (listIterator32.next().getWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2156: {
                (int)array[0];
                final ListIterator listIterator33 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator33.hasNext()) {
                    if (listIterator33.next().getWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2157: {
                return (int)array[0] == 16;
            }
            case 2158: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2159: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2160: {
                return (int)array[0] == 0;
            }
            case 2161: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2162: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2163: {
                return (int)array[0] == 1;
            }
            case 2164: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2165: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2166: {
                return (int)array[0] == 11;
            }
            case 2167: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2168: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2169: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2170: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2171: {
                return (int)array[0] == 12;
            }
            case 2172: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2173: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2174: {
                return (int)array[0] == 15;
            }
            case 2175: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2176: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2177: {
                return (int)array[0] == 18;
            }
            case 2178: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2179: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2180: {
                return (int)array[0] == 23;
            }
            case 2181: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2182: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2183: {
                return (int)array[0] == 52;
            }
            case 2184: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2185: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2186: {
                return (int)array[0] == 53;
            }
            case 2187: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2188: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2189: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2190: {
                final ListIterator listIterator34 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator34.hasNext()) {
                    if (listIterator34.next().getWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2192: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2193: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2194: {
                final ListIterator listIterator35 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator35.hasNext()) {
                    if (listIterator35.next().getWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2195: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2196: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2197: {
                final ListIterator listIterator36 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator36.hasNext()) {
                    if (listIterator36.next().getCurrentBeat() == 33) {
                        return true;
                    }
                }
                return false;
            }
            case 2199: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                final int intValue18 = (int)array[4];
                (int)array[5];
                (int)array[6];
                (int)array[7];
                return intValue18 != -1;
            }
            case 2200: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                final int intValue19 = (int)array[4];
                (int)array[5];
                (int)array[6];
                (int)array[7];
                (int)array[8];
                return intValue19 != -1;
            }
            case 2201: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                final int intValue20 = (int)array[4];
                (int)array[5];
                (int)array[6];
                (int)array[7];
                (int)array[8];
                (int)array[9];
                (int)array[10];
                (int)array[11];
                (int)array[12];
                (int)array[13];
                (int)array[14];
                (int)array[15];
                return intValue20 != -1;
            }
            case 2202: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                final int intValue21 = (int)array[4];
                (int)array[5];
                (int)array[6];
                (int)array[7];
                (int)array[8];
                (int)array[9];
                (int)array[10];
                (int)array[11];
                (int)array[12];
                (int)array[13];
                (int)array[14];
                (int)array[15];
                (int)array[16];
                (int)array[17];
                (int)array[18];
                (int)array[19];
                (int)array[20];
                (int)array[21];
                (int)array[22];
                return intValue21 != -1;
            }
            case 2203: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                final int intValue22 = (int)array[4];
                (int)array[5];
                (int)array[6];
                (int)array[7];
                (int)array[8];
                (int)array[9];
                (int)array[10];
                (int)array[11];
                (int)array[12];
                (int)array[13];
                (int)array[14];
                (int)array[15];
                (int)array[16];
                (int)array[17];
                (int)array[18];
                (int)array[19];
                (int)array[20];
                (int)array[21];
                (int)array[22];
                (int)array[23];
                (int)array[24];
                (int)array[25];
                (int)array[26];
                (int)array[27];
                (int)array[28];
                return intValue22 != -1;
            }
            case 2204: {
                (int)array[0];
                return !TherapyGameState.bVeryBeginningOfNewMixin;
            }
            case 2207: {
                return TherapyGameState.numMixinsPlayed >= 2 && !TherapyGameState.bMixinCausedByPlayer && !TherapyGameState.bSignaledNewCharFocus && TherapyGameState.prevMixinType != 1 && TherapyGameState.currentMixinType != 2;
            }
            case 2208: {
                (int)array[0];
                final int intValue23 = (int)array[1];
                return TherapyGameState.bMixinCausedByPlayer && intValue23 == -1 && (TherapyGameState.currentMixinDAType == 23 || TherapyGameState.currentMixinDAType == 24 || TherapyGameState.currentMixinDAType == 25 || TherapyGameState.currentMixinDAType == 26 || TherapyGameState.currentMixinDAType == 27 || TherapyGameState.currentMixinDAType == 28) && !TherapyGameState.bSignaledNewMixinScoreIncrease;
            }
            case 2210: {
                (int)array[0];
                (boolean)array[1];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2211: {
                return (boolean)array[0];
            }
            case 2212: {
                return (boolean)array[0];
            }
            case 2214: {
                return TherapyGameState.bVeryBeginningOfNewMixin && TherapyGameState.signalNewCharFocusWho != -1;
            }
            case 2215: {
                return TherapyGameState.bVeryBeginningOfNewMixin && TherapyGameState.newMixinScoreIncreaseWho != -1;
            }
            case 2216: {
                final int intValue24 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                (boolean)array[7];
                return intValue24 == ((Grace)behavingEntity).me;
            }
            case 2217: {
                final int intValue25 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                (boolean)array[7];
                return intValue25 != ((Grace)behavingEntity).me && intValue25 != -1;
            }
            case 2219: {
                return (int)array[0] < 0;
            }
            case 2220: {
                return (int)array[0] >= 0;
            }
            case 2221: {
                final int intValue26 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                (boolean)array[7];
                return intValue26 == -1;
            }
            case 2222: {
                (boolean)array[0];
                (int)array[1];
                final ListIterator listIterator37 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator37.hasNext()) {
                    if (listIterator37.next().getCharacterID() == ((Grace)behavingEntity).me && TherapyGameState.numMixinsPlayed > 2) {
                        return true;
                    }
                }
                return false;
            }
            case 2224: {
                (float)array[0];
                (float)array[1];
                (float)array[2];
                final boolean booleanValue2 = (boolean)array[3];
                (boolean)array[4];
                (int)array[5];
                return booleanValue2;
            }
            case 2225: {
                (float)array[0];
                (float)array[1];
                (float)array[2];
                final boolean booleanValue3 = (boolean)array[3];
                final boolean booleanValue4 = (boolean)array[4];
                (int)array[5];
                return !booleanValue3 && !booleanValue4;
            }
            case 2226: {
                (float)array[0];
                (float)array[1];
                (float)array[2];
                final boolean booleanValue5 = (boolean)array[3];
                final boolean booleanValue6 = (boolean)array[4];
                (int)array[5];
                return !booleanValue5 && booleanValue6;
            }
            case 2227: {
                final int intValue27 = (int)array[0];
                (int)array[1];
                (int)array[2];
                return intValue27 == 0;
            }
            case 2247: {
                final ListIterator listIterator38 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator38.hasNext()) {
                    if (listIterator38.next().getCurrentBeat() == 34) {
                        return true;
                    }
                }
                return false;
            }
            case 2251: {
                final ListIterator listIterator39 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator39.hasNext()) {
                    if (listIterator39.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2255: {
                final ListIterator listIterator40 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator40.hasNext()) {
                    if (listIterator40.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2257: {
                final ListIterator listIterator41 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator41.hasNext()) {
                    if (listIterator41.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2258: {
                final ListIterator listIterator42 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator42.hasNext()) {
                    if (listIterator42.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2259: {
                final ListIterator listIterator43 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator43.hasNext()) {
                    if (listIterator43.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2260: {
                final ListIterator listIterator44 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator44.hasNext()) {
                    if (listIterator44.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2261: {
                final ListIterator listIterator45 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator45.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME = listIterator45.next();
                    if (beatRevelationsP2WME.getRev1Who() == ((Grace)behavingEntity).grace && beatRevelationsP2WME.getRev1CharFocus() != 2) {
                        return true;
                    }
                }
                return false;
            }
            case 2262: {
                final ListIterator listIterator46 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator46.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME2 = listIterator46.next();
                    if (beatRevelationsP2WME2.getRev1Who() == ((Grace)behavingEntity).grace && beatRevelationsP2WME2.getRev1CharFocus() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 2263: {
                final ListIterator listIterator47 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator47.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME3 = listIterator47.next();
                    if (beatRevelationsP2WME3.getRev1Who() == ((Grace)behavingEntity).trip && beatRevelationsP2WME3.getRev1CharFocus() != 2) {
                        return true;
                    }
                }
                return false;
            }
            case 2264: {
                final ListIterator listIterator48 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator48.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME4 = listIterator48.next();
                    if (beatRevelationsP2WME4.getRev1Who() == ((Grace)behavingEntity).trip && beatRevelationsP2WME4.getRev1CharFocus() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 2265: {
                final ListIterator listIterator49 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator49.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME5 = listIterator49.next();
                    if (beatRevelationsP2WME5.getRev1Who() == ((Grace)behavingEntity).grace && beatRevelationsP2WME5.getRev1Topic() == 59) {
                        return true;
                    }
                }
                return false;
            }
            case 2266: {
                final ListIterator listIterator50 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator50.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME6 = listIterator50.next();
                    if (beatRevelationsP2WME6.getRev1Who() == ((Grace)behavingEntity).grace && beatRevelationsP2WME6.getRev1Topic() == 60) {
                        return true;
                    }
                }
                return false;
            }
            case 2267: {
                final ListIterator listIterator51 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator51.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME7 = listIterator51.next();
                    if (beatRevelationsP2WME7.getRev1Who() == ((Grace)behavingEntity).grace && beatRevelationsP2WME7.getRev1Topic() == 61) {
                        return true;
                    }
                }
                return false;
            }
            case 2268: {
                final ListIterator listIterator52 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator52.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME8 = listIterator52.next();
                    if (beatRevelationsP2WME8.getRev1Who() == ((Grace)behavingEntity).trip && beatRevelationsP2WME8.getRev1Topic() == 59) {
                        return true;
                    }
                }
                return false;
            }
            case 2269: {
                final ListIterator listIterator53 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator53.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME9 = listIterator53.next();
                    if (beatRevelationsP2WME9.getRev1Who() == ((Grace)behavingEntity).trip && beatRevelationsP2WME9.getRev1Topic() == 60) {
                        return true;
                    }
                }
                return false;
            }
            case 2270: {
                final ListIterator listIterator54 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator54.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME10 = listIterator54.next();
                    if (beatRevelationsP2WME10.getRev1Who() == ((Grace)behavingEntity).trip && beatRevelationsP2WME10.getRev1Topic() == 61) {
                        return true;
                    }
                }
                return false;
            }
            case 2272: {
                final ListIterator listIterator55 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator55.hasNext()) {
                    if (listIterator55.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2274: {
                final ListIterator listIterator56 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator56.hasNext()) {
                    if (listIterator56.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2276: {
                final ListIterator listIterator57 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator57.hasNext()) {
                    if (listIterator57.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2277: {
                final ListIterator listIterator58 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator58.hasNext()) {
                    if (listIterator58.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2279: {
                final ListIterator listIterator59 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator59.hasNext()) {
                    if (listIterator59.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2280: {
                final ListIterator listIterator60 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator60.hasNext()) {
                    if (listIterator60.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2282: {
                final ListIterator listIterator61 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator61.hasNext()) {
                    if (listIterator61.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2283: {
                final ListIterator listIterator62 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator62.hasNext()) {
                    if (listIterator62.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2284: {
                final ListIterator listIterator63 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator63.hasNext()) {
                    if (listIterator63.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2285: {
                final ListIterator listIterator64 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator64.hasNext()) {
                    if (listIterator64.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2286: {
                final ListIterator listIterator65 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator65.hasNext()) {
                    if (listIterator65.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2288: {
                final ListIterator listIterator66 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator66.hasNext()) {
                    if (listIterator66.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2289: {
                final ListIterator listIterator67 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator67.hasNext()) {
                    if (listIterator67.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2290: {
                final ListIterator listIterator68 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator68.hasNext()) {
                    if (listIterator68.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2292: {
                final ListIterator listIterator69 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator69.hasNext()) {
                    if (listIterator69.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2293: {
                final ListIterator listIterator70 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator70.hasNext()) {
                    if (listIterator70.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2294: {
                final ListIterator listIterator71 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator71.hasNext()) {
                    if (listIterator71.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2295: {
                final ListIterator listIterator72 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator72.hasNext()) {
                    if (listIterator72.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2297: {
                final ListIterator listIterator73 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator73.hasNext()) {
                    if (listIterator73.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2298: {
                final ListIterator listIterator74 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator74.hasNext()) {
                    if (listIterator74.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2300: {
                final ListIterator listIterator75 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator75.hasNext()) {
                    if (listIterator75.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2301: {
                final ListIterator listIterator76 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator76.hasNext()) {
                    if (listIterator76.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2303: {
                final ListIterator listIterator77 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator77.hasNext()) {
                    if (listIterator77.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2304: {
                final ListIterator listIterator78 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator78.hasNext()) {
                    if (listIterator78.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2306: {
                final ListIterator listIterator79 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator79.hasNext()) {
                    if (listIterator79.next().getSVal().equals("bRevBuildupP2_Body2_BodyStuff2")) {
                        return false;
                    }
                }
                return true;
            }
            case 2307: {
                final ListIterator listIterator80 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator80.hasNext()) {
                    if (listIterator80.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        final ListIterator listIterator81 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator81.hasNext()) {
                            if (listIterator81.next().getSVal().equals("handlerDA_DoReaction_bRevBuildupP2_bgBody2_mixin_yes")) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 2308: {
                final ListIterator listIterator82 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator82.hasNext()) {
                    if (listIterator82.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        final ListIterator listIterator83 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator83.hasNext()) {
                            if (listIterator83.next().getSVal().equals("handlerDA_DoReaction_bRevBuildupP2_bgBody2_mixin_no")) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 2309: {
                final ListIterator listIterator84 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator84.hasNext()) {
                    if (listIterator84.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2310: {
                final ListIterator listIterator85 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator85.hasNext()) {
                    if (listIterator85.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2312: {
                final ListIterator listIterator86 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator86.hasNext()) {
                    if (listIterator86.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2313: {
                final ListIterator listIterator87 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator87.hasNext()) {
                    if (listIterator87.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2315: {
                final ListIterator listIterator88 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator88.hasNext()) {
                    if (listIterator88.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2316: {
                final ListIterator listIterator89 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator89.hasNext()) {
                    if (listIterator89.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2317: {
                final ListIterator listIterator90 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator90.hasNext()) {
                    if (listIterator90.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2318: {
                final ListIterator listIterator91 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator91.hasNext()) {
                    if (listIterator91.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2320: {
                final ListIterator listIterator92 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator92.hasNext()) {
                    if (listIterator92.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2321: {
                final ListIterator listIterator93 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator93.hasNext()) {
                    if (listIterator93.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2323: {
                final ListIterator listIterator94 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator94.hasNext()) {
                    if (listIterator94.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2324: {
                final ListIterator listIterator95 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator95.hasNext()) {
                    if (listIterator95.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2326: {
                final ListIterator listIterator96 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator96.hasNext()) {
                    if (listIterator96.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2327: {
                final ListIterator listIterator97 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator97.hasNext()) {
                    if (listIterator97.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2328: {
                final ListIterator listIterator98 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator98.hasNext()) {
                    if (listIterator98.next().getBChallenged()) {
                        return true;
                    }
                }
                return false;
            }
            case 2329: {
                final ListIterator listIterator99 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator99.hasNext()) {
                    if (!listIterator99.next().getBChallenged()) {
                        return true;
                    }
                }
                return false;
            }
            case 2331: {
                final ListIterator listIterator100 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator100.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME11 = listIterator100.next();
                    if (beatRevelationsP2WME11.getRev1Who() == ((Grace)behavingEntity).grace && beatRevelationsP2WME11.getBChallengedALot()) {
                        return true;
                    }
                }
                return false;
            }
            case 2332: {
                final ListIterator listIterator101 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator101.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME12 = listIterator101.next();
                    if (beatRevelationsP2WME12.getRev1Who() == ((Grace)behavingEntity).grace && !beatRevelationsP2WME12.getBChallengedALot()) {
                        return true;
                    }
                }
                return false;
            }
            case 2333: {
                final ListIterator listIterator102 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator102.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME13 = listIterator102.next();
                    if (beatRevelationsP2WME13.getRev1Who() == ((Grace)behavingEntity).trip && beatRevelationsP2WME13.getBChallengedALot()) {
                        return true;
                    }
                }
                return false;
            }
            case 2334: {
                final ListIterator listIterator103 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator103.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME14 = listIterator103.next();
                    if (beatRevelationsP2WME14.getRev1Who() == ((Grace)behavingEntity).trip && !beatRevelationsP2WME14.getBChallengedALot()) {
                        return true;
                    }
                }
                return false;
            }
            case 2336: {
                final ListIterator listIterator104 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator104.hasNext()) {
                    if (listIterator104.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2337: {
                final ListIterator listIterator105 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator105.hasNext()) {
                    if (listIterator105.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2339: {
                final ListIterator listIterator106 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator106.hasNext()) {
                    if (listIterator106.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2340: {
                final ListIterator listIterator107 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator107.hasNext()) {
                    if (listIterator107.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2341: {
                final ListIterator listIterator108 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator108.hasNext()) {
                    if (listIterator108.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2342: {
                final ListIterator listIterator109 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator109.hasNext()) {
                    if (listIterator109.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2344: {
                final ListIterator listIterator110 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator110.hasNext()) {
                    if (listIterator110.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2345: {
                final ListIterator listIterator111 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator111.hasNext()) {
                    if (listIterator111.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2347: {
                final ListIterator listIterator112 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator112.hasNext()) {
                    if (listIterator112.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2348: {
                final ListIterator listIterator113 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator113.hasNext()) {
                    if (listIterator113.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2350: {
                final ListIterator listIterator114 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator114.hasNext()) {
                    if (listIterator114.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2351: {
                final ListIterator listIterator115 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator115.hasNext()) {
                    if (listIterator115.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2352: {
                final ListIterator listIterator116 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator116.hasNext()) {
                    if (listIterator116.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2353: {
                final ListIterator listIterator117 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator117.hasNext()) {
                    if (listIterator117.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2354: {
                final ListIterator listIterator118 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator118.hasNext()) {
                    if (listIterator118.next().getLitanyD() != -1) {
                        return true;
                    }
                }
                return false;
            }
            case 2355: {
                final ListIterator listIterator119 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator119.hasNext()) {
                    if (listIterator119.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2356: {
                final ListIterator listIterator120 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator120.hasNext()) {
                    if (listIterator120.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2358: {
                final ListIterator listIterator121 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator121.hasNext()) {
                    if (listIterator121.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2359: {
                final ListIterator listIterator122 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator122.hasNext()) {
                    if (listIterator122.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2361: {
                final ListIterator listIterator123 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator123.hasNext()) {
                    if (listIterator123.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2362: {
                final ListIterator listIterator124 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator124.hasNext()) {
                    if (listIterator124.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2364: {
                final ListIterator listIterator125 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator125.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME15 = listIterator125.next();
                    if (beatRevelationsP2WME15.getRev1Who() == ((Grace)behavingEntity).grace && beatRevelationsP2WME15.getRev1CharFocus() != 2) {
                        return true;
                    }
                }
                return false;
            }
            case 2365: {
                final ListIterator listIterator126 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator126.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME16 = listIterator126.next();
                    if (beatRevelationsP2WME16.getRev1Who() == ((Grace)behavingEntity).grace && beatRevelationsP2WME16.getRev1CharFocus() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 2366: {
                final ListIterator listIterator127 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator127.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME17 = listIterator127.next();
                    if (beatRevelationsP2WME17.getRev1Who() == ((Grace)behavingEntity).trip && beatRevelationsP2WME17.getRev1CharFocus() != 2) {
                        return true;
                    }
                }
                return false;
            }
            case 2367: {
                final ListIterator listIterator128 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator128.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME18 = listIterator128.next();
                    if (beatRevelationsP2WME18.getRev1Who() == ((Grace)behavingEntity).trip && beatRevelationsP2WME18.getRev1CharFocus() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 2369: {
                final ListIterator listIterator129 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator129.hasNext()) {
                    if (listIterator129.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2370: {
                final ListIterator listIterator130 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator130.hasNext()) {
                    if (listIterator130.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2372: {
                final ListIterator listIterator131 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator131.hasNext()) {
                    if (listIterator131.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2373: {
                final ListIterator listIterator132 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator132.hasNext()) {
                    if (listIterator132.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2375: {
                (int)array[0];
                final ListIterator listIterator133 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator133.hasNext()) {
                    if (listIterator133.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2376: {
                (int)array[0];
                final ListIterator listIterator134 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator134.hasNext()) {
                    if (listIterator134.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2384: {
                final ListIterator listIterator135 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator135.hasNext()) {
                    if (listIterator135.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2385: {
                final ListIterator listIterator136 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator136.hasNext()) {
                    if (listIterator136.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2387: {
                final ListIterator listIterator137 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator137.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME19 = listIterator137.next();
                    if (beatRevelationsP2WME19.getRev1Who() == ((Grace)behavingEntity).grace && beatRevelationsP2WME19.getBChallenged() && beatRevelationsP2WME19.getBChallengedALot()) {
                        return true;
                    }
                }
                return false;
            }
            case 2388: {
                final ListIterator listIterator138 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator138.hasNext()) {
                    if (listIterator138.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2389: {
                final ListIterator listIterator139 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator139.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME20 = listIterator139.next();
                    if (beatRevelationsP2WME20.getRev1Who() == ((Grace)behavingEntity).trip && beatRevelationsP2WME20.getBChallenged() && beatRevelationsP2WME20.getBChallengedALot()) {
                        return true;
                    }
                }
                return false;
            }
            case 2390: {
                final ListIterator listIterator140 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator140.hasNext()) {
                    if (listIterator140.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2391: {
                final ListIterator listIterator141 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator141.hasNext()) {
                    if (listIterator141.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2392: {
                final ListIterator listIterator142 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator142.hasNext()) {
                    if (listIterator142.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2393: {
                final ListIterator listIterator143 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator143.hasNext()) {
                    if (listIterator143.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2394: {
                final ListIterator listIterator144 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator144.hasNext()) {
                    if (listIterator144.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2396: {
                final ListIterator listIterator145 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator145.hasNext()) {
                    if (listIterator145.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2397: {
                final ListIterator listIterator146 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator146.hasNext()) {
                    if (listIterator146.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2399: {
                final ListIterator listIterator147 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator147.hasNext()) {
                    if (listIterator147.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2400: {
                final ListIterator listIterator148 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator148.hasNext()) {
                    if (listIterator148.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2402: {
                final ListIterator listIterator149 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator149.hasNext()) {
                    if (listIterator149.next().getRev1Who() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2403: {
                final ListIterator listIterator150 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator150.hasNext()) {
                    if (listIterator150.next().getRev1Who() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 2404: {
                final ListIterator listIterator151 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator151.hasNext()) {
                    if (listIterator151.next().getBChallenged()) {
                        final ListIterator listIterator152 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator152.hasNext()) {
                            if (listIterator152.next().getSVal().equals("handlerDA_DoReaction_bRevBuildupP2_bgBody5_mixin_yes")) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 2405: {
                final ListIterator listIterator153 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator153.hasNext()) {
                    if (listIterator153.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2406: {
                final ListIterator listIterator154 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator154.hasNext()) {
                    if (listIterator154.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2407: {
                final ListIterator listIterator155 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator155.hasNext()) {
                    if (listIterator155.next().getBChallenged()) {
                        final ListIterator listIterator156 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator156.hasNext()) {
                            if (listIterator156.next().getSVal().equals("handlerDA_DoReaction_bRevBuildupP2_bgBody5_mixin_yes")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 2408: {
                final ListIterator listIterator157 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator157.hasNext()) {
                    if (listIterator157.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2409: {
                final ListIterator listIterator158 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator158.hasNext()) {
                    if (listIterator158.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2410: {
                final ListIterator listIterator159 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator159.hasNext()) {
                    if (!listIterator159.next().getBChallenged()) {
                        final ListIterator listIterator160 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator160.hasNext()) {
                            if (listIterator160.next().getSVal().equals("handlerDA_DoReaction_bRevBuildupP2_bgBody5_mixin_yes")) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 2411: {
                final ListIterator listIterator161 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator161.hasNext()) {
                    if (listIterator161.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2412: {
                final ListIterator listIterator162 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator162.hasNext()) {
                    if (listIterator162.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2413: {
                final ListIterator listIterator163 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator163.hasNext()) {
                    if (!listIterator163.next().getBChallenged()) {
                        final ListIterator listIterator164 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator164.hasNext()) {
                            if (listIterator164.next().getSVal().equals("handlerDA_DoReaction_bRevBuildupP2_bgBody5_mixin_yes")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 2414: {
                final ListIterator listIterator165 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator165.hasNext()) {
                    if (listIterator165.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2415: {
                final ListIterator listIterator166 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator166.hasNext()) {
                    if (listIterator166.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2416: {
                final ListIterator listIterator167 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator167.hasNext()) {
                    if (listIterator167.next().getRev1Who() == ((Grace)behavingEntity).grace) {
                        return true;
                    }
                }
                return false;
            }
            case 2417: {
                final ListIterator listIterator168 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator168.hasNext()) {
                    if (listIterator168.next().getRev1Who() == ((Grace)behavingEntity).trip) {
                        return true;
                    }
                }
                return false;
            }
            case 2418: {
                (boolean)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                final ListIterator listIterator169 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator169.hasNext()) {
                    final PlayerUncoopWME playerUncoopWME = listIterator169.next();
                    final boolean bLeavingApartment;
                    final boolean bLeavingForKitchen;
                    if (BehavingEntity.constantTrue(bLeavingApartment = playerUncoopWME.getBLeavingApartment()) && BehavingEntity.constantTrue(bLeavingForKitchen = playerUncoopWME.getBLeavingForKitchen()) && (bLeavingApartment || bLeavingForKitchen)) {
                        hashtable.put("bLeavingApartment", new Boolean(bLeavingApartment));
                        hashtable.put("bLeavingForKitchen", new Boolean(bLeavingForKitchen));
                        return true;
                    }
                }
                return false;
            }
            case 2419: {
                return (boolean)array[0] && ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2420: {
                return (boolean)array[0] && ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2421: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
    
    public static boolean precondition3(final int n, final Object[] array, final Hashtable hashtable, final BehavingEntity behavingEntity) {
        switch (n) {
            case 2422: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2423: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2424: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2425: {
                final ListIterator listIterator = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator.hasNext()) {
                    if (listIterator.next().getCurrentBeat() == 35) {
                        return true;
                    }
                }
                return false;
            }
            case 2452: {
                final int intValue = (int)array[0];
                (int)array[1];
                return intValue == ((Grace)behavingEntity).me;
            }
            case 2453: {
                final int intValue2 = (int)array[0];
                (int)array[1];
                return intValue2 != ((Grace)behavingEntity).me;
            }
            case 2455: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2456: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2457: {
                final int intValue3 = (int)array[0];
                final int intValue4 = (int)array[1];
                return intValue3 == ((Grace)behavingEntity).me && intValue4 == -1;
            }
            case 2458: {
                final int intValue5 = (int)array[0];
                final int intValue6 = (int)array[1];
                return intValue5 != ((Grace)behavingEntity).me && intValue6 == -1;
            }
            case 2461: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2462: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2463: {
                final int intValue7 = (int)array[0];
                final int intValue8 = (int)array[1];
                return intValue8 == intValue7 && intValue8 == ((Grace)behavingEntity).me;
            }
            case 2465: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2466: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2467: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2468: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2469: {
                final int intValue9 = (int)array[0];
                final int intValue10 = (int)array[1];
                return intValue10 == intValue9 && intValue10 != ((Grace)behavingEntity).me;
            }
            case 2471: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2472: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2473: {
                final int intValue11 = (int)array[0];
                final int intValue12 = (int)array[1];
                return intValue12 != intValue11 && intValue12 == ((Grace)behavingEntity).me;
            }
            case 2475: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2476: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2477: {
                final int intValue13 = (int)array[0];
                final int intValue14 = (int)array[1];
                return intValue14 != intValue13 && intValue14 != ((Grace)behavingEntity).me;
            }
            case 2479: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2480: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2481: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2482: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2483: {
                final int intValue15 = (int)array[0];
                (int)array[1];
                return intValue15 == ((Grace)behavingEntity).me;
            }
            case 2484: {
                final int intValue16 = (int)array[0];
                (int)array[1];
                return intValue16 != ((Grace)behavingEntity).me;
            }
            case 2486: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2487: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2488: {
                final int intValue17 = (int)array[0];
                final int intValue18 = (int)array[1];
                return intValue17 == ((Grace)behavingEntity).me && intValue18 == -1;
            }
            case 2489: {
                final int intValue19 = (int)array[0];
                final int intValue20 = (int)array[1];
                return intValue19 != ((Grace)behavingEntity).me && intValue20 == -1;
            }
            case 2492: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2493: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2494: {
                (int)array[0];
                return (int)array[1] == ((Grace)behavingEntity).me;
            }
            case 2496: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2497: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2498: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2499: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2500: {
                (int)array[0];
                final int intValue21 = (int)array[1];
                return intValue21 != -1 && intValue21 != ((Grace)behavingEntity).me;
            }
            case 2502: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2503: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2504: {
                final int intValue22 = (int)array[0];
                final int intValue23 = (int)array[1];
                final int intValue24 = (int)array[2];
                return (intValue22 != intValue23 || intValue22 != intValue24 || intValue23 != intValue24) && intValue24 == ((Grace)behavingEntity).me;
            }
            case 2505: {
                final int intValue25 = (int)array[0];
                final int intValue26 = (int)array[1];
                final int intValue27 = (int)array[2];
                return (intValue25 != intValue26 || intValue25 != intValue27 || intValue26 != intValue27) && intValue27 != ((Grace)behavingEntity).me;
            }
            case 2506: {
                (int)array[0];
                (int)array[1];
                return (int)array[2] == ((Grace)behavingEntity).me;
            }
            case 2507: {
                (int)array[0];
                (int)array[1];
                return (int)array[2] != ((Grace)behavingEntity).me;
            }
            case 2510: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2511: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2512: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2513: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2519: {
                final ListIterator listIterator2 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getCurrentBeat() == 36) {
                        return true;
                    }
                }
                return false;
            }
            case 2520: {
                final ListIterator listIterator3 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator3.hasNext()) {
                    final ObjectPositionWME objectPositionWME = listIterator3.next();
                    final float x;
                    final float z;
                    if (objectPositionWME.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x = objectPositionWME.getX()) && BehavingEntity.constantTrue(z = objectPositionWME.getZ())) {
                        final ListIterator listIterator4 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator4.hasNext()) {
                            final ObjectPositionWME objectPositionWME2 = listIterator4.next();
                            final float x2;
                            final float z2;
                            if (objectPositionWME2.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x2 = objectPositionWME2.getX()) && BehavingEntity.constantTrue(z2 = objectPositionWME2.getZ()) && Staging.getXZDistanceBetweenPoints(x, z, x2, z2) > 60.0f) {
                                hashtable.put("playerX", new Float(x2));
                                hashtable.put("myX", new Float(x));
                                hashtable.put("playerZ", new Float(z2));
                                hashtable.put("myZ", new Float(z));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 2522: {
                final ListIterator listIterator5 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator5.hasNext()) {
                    final ObjectPositionWME objectPositionWME3 = listIterator5.next();
                    final float x3;
                    final float z3;
                    if (objectPositionWME3.getObjectID() == 47 && BehavingEntity.constantTrue(x3 = objectPositionWME3.getX()) && BehavingEntity.constantTrue(z3 = objectPositionWME3.getZ())) {
                        final ListIterator listIterator6 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator6.hasNext()) {
                            final ObjectPositionWME objectPositionWME4 = listIterator6.next();
                            final float x4;
                            final float z4;
                            if (objectPositionWME4.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x4 = objectPositionWME4.getX()) && BehavingEntity.constantTrue(z4 = objectPositionWME4.getZ()) && Staging.getXZDistanceBetweenPoints(x3, z3, x4, z4) > 250.0f) {
                                hashtable.put("playerX", new Float(x4));
                                hashtable.put("frontDoorZ", new Float(z3));
                                hashtable.put("playerZ", new Float(z4));
                                hashtable.put("frontDoorX", new Float(x3));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 2523: {
                final ListIterator listIterator7 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator7.hasNext()) {
                    final ObjectPositionWME objectPositionWME5 = listIterator7.next();
                    if (objectPositionWME5.getObjectID() == ((Grace)behavingEntity).player && objectPositionWME5.getX() > -180.0f && objectPositionWME5.getZ() < 150.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 2524: {
                final ListIterator listIterator8 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator8.hasNext()) {
                    final ObjectPositionWME objectPositionWME6 = listIterator8.next();
                    final float x5;
                    final float z5;
                    if (objectPositionWME6.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x5 = objectPositionWME6.getX()) && BehavingEntity.constantTrue(z5 = objectPositionWME6.getZ())) {
                        hashtable.put("playerX", new Float(x5));
                        hashtable.put("playerZ", new Float(z5));
                        return true;
                    }
                }
                return false;
            }
            case 2525: {
                final ListIterator listIterator9 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator9.hasNext()) {
                    final ObjectPositionWME objectPositionWME7 = listIterator9.next();
                    if (objectPositionWME7.getObjectID() == ((Grace)behavingEntity).player && objectPositionWME7.getX() > -180.0f && objectPositionWME7.getZ() < 150.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 2529: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2531: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2532: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2533: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2534: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2535: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2536: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2537: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2538: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2539: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2540: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2541: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2543: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2544: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2545: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2546: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2547: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2548: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2550: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2552: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2553: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2554: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2555: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2556: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2558: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2559: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2561: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2563: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2565: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2566: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2567: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2572: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2576: {
                (int)array[0];
                final ListIterator listIterator10 = WorkingMemory.lookupWME("BeatMemory", "BeatEndingWME").listIterator();
                while (listIterator10.hasNext()) {
                    final BeatEndingWME beatEndingWME2;
                    final BeatEndingWME beatEndingWME = beatEndingWME2 = listIterator10.next();
                    final int rxn;
                    final int ctr;
                    if (beatEndingWME.getRxn() >= 0 && BehavingEntity.constantTrue(rxn = beatEndingWME.getRxn()) && BehavingEntity.constantTrue(ctr = beatEndingWME.getCtr())) {
                        hashtable.put("endingWME", new ObjectWrapper(beatEndingWME2));
                        hashtable.put("ctr", new Integer(ctr));
                        hashtable.put("rxn", new Integer(rxn));
                        return true;
                    }
                }
                return false;
            }
            case 2577: {
                final int intValue28 = (int)array[0];
                final int intValue29 = (int)array[1];
                final int intValue30 = (int)array[2];
                return intValue28 == ((Grace)behavingEntity).grace && intValue29 == 45 && intValue30 == 0;
            }
            case 2578: {
                final int intValue31 = (int)array[0];
                final int intValue32 = (int)array[1];
                final int intValue33 = (int)array[2];
                return intValue31 == ((Grace)behavingEntity).grace && intValue32 == 47 && intValue33 == 0;
            }
            case 2579: {
                final int intValue34 = (int)array[0];
                final int intValue35 = (int)array[1];
                final int intValue36 = (int)array[2];
                return intValue34 == ((Grace)behavingEntity).grace && intValue35 == 48 && intValue36 == 0;
            }
            case 2580: {
                final int intValue37 = (int)array[0];
                final int intValue38 = (int)array[1];
                final int intValue39 = (int)array[2];
                return intValue37 == ((Grace)behavingEntity).grace && intValue38 == 37 && intValue39 == 0;
            }
            case 2581: {
                final int intValue40 = (int)array[0];
                final int intValue41 = (int)array[1];
                final int intValue42 = (int)array[2];
                return intValue40 == ((Grace)behavingEntity).grace && intValue41 == 45 && intValue42 == 1;
            }
            case 2582: {
                final int intValue43 = (int)array[0];
                final int intValue44 = (int)array[1];
                final int intValue45 = (int)array[2];
                return intValue43 == ((Grace)behavingEntity).grace && intValue44 == 47 && intValue45 == 1;
            }
            case 2583: {
                final int intValue46 = (int)array[0];
                final int intValue47 = (int)array[1];
                final int intValue48 = (int)array[2];
                return intValue46 == ((Grace)behavingEntity).grace && intValue47 == 48 && intValue48 == 1;
            }
            case 2584: {
                final int intValue49 = (int)array[0];
                final int intValue50 = (int)array[1];
                final int intValue51 = (int)array[2];
                return intValue49 == ((Grace)behavingEntity).grace && intValue50 == 37 && intValue51 == 1;
            }
            case 2585: {
                final int intValue52 = (int)array[0];
                final int intValue53 = (int)array[1];
                final int intValue54 = (int)array[2];
                return intValue52 == ((Grace)behavingEntity).trip && intValue53 == 45 && intValue54 == 0;
            }
            case 2586: {
                final int intValue55 = (int)array[0];
                final int intValue56 = (int)array[1];
                final int intValue57 = (int)array[2];
                return intValue55 == ((Grace)behavingEntity).trip && intValue56 == 47 && intValue57 == 0;
            }
            case 2587: {
                final int intValue58 = (int)array[0];
                final int intValue59 = (int)array[1];
                final int intValue60 = (int)array[2];
                return intValue58 == ((Grace)behavingEntity).trip && intValue59 == 48 && intValue60 == 0;
            }
            case 2588: {
                final int intValue61 = (int)array[0];
                final int intValue62 = (int)array[1];
                final int intValue63 = (int)array[2];
                return intValue61 == ((Grace)behavingEntity).trip && intValue62 == 37 && intValue63 == 0;
            }
            case 2589: {
                final int intValue64 = (int)array[0];
                final int intValue65 = (int)array[1];
                final int intValue66 = (int)array[2];
                return intValue64 == ((Grace)behavingEntity).trip && intValue65 == 45 && intValue66 == 1;
            }
            case 2590: {
                final int intValue67 = (int)array[0];
                final int intValue68 = (int)array[1];
                final int intValue69 = (int)array[2];
                return intValue67 == ((Grace)behavingEntity).trip && intValue68 == 47 && intValue69 == 1;
            }
            case 2591: {
                final int intValue70 = (int)array[0];
                final int intValue71 = (int)array[1];
                final int intValue72 = (int)array[2];
                return intValue70 == ((Grace)behavingEntity).trip && intValue71 == 48 && intValue72 == 1;
            }
            case 2592: {
                final int intValue73 = (int)array[0];
                final int intValue74 = (int)array[1];
                final int intValue75 = (int)array[2];
                return intValue73 == ((Grace)behavingEntity).trip && intValue74 == 37 && intValue75 == 1;
            }
            case 2594: {
                final ListIterator listIterator11 = WorkingMemory.lookupWME("BeatMemory", "BeatEndingWME").listIterator();
                while (listIterator11.hasNext()) {
                    final BeatEndingWME beatEndingWME3;
                    if ((beatEndingWME3 = listIterator11.next()).getRxn() >= 0) {
                        hashtable.put("endingWME", new ObjectWrapper(beatEndingWME3));
                        return true;
                    }
                }
                return false;
            }
            case 2597: {
                return (int)array[0] == 47;
            }
            case 2598: {
                return (int)array[0] == 48;
            }
            case 2599: {
                return (int)array[0] == 37;
            }
            case 2601: {
                final ListIterator listIterator12 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator12.hasNext()) {
                    if (listIterator12.next().getCurrentBeat() == 37) {
                        return true;
                    }
                }
                return false;
            }
            case 2607: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2609: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2610: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2611: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2613: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2614: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2616: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2618: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2619: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2620: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2621: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2622: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2624: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2625: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2627: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2629: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2630: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2631: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2632: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2633: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2635: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2636: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2637: {
                return (int)array[0] != -1;
            }
            case 2638: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2640: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2641: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2642: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2645: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2647: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator13 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator13.hasNext()) {
                        if (listIterator13.next().getEndingNonPrimarySpeaker() == -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2648: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator14 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator14.hasNext()) {
                        if (listIterator14.next().getEndingNonPrimarySpeaker() == -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2649: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator15 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator15.hasNext()) {
                        if (listIterator15.next().getEndingNonPrimarySpeaker() != -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2650: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator16 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator16.hasNext()) {
                        if (listIterator16.next().getEndingNonPrimarySpeaker() != -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2651: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2654: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2655: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2656: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator17 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator17.hasNext()) {
                        if (listIterator17.next().getEndingNonPrimarySpeaker() == -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2657: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator18 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator18.hasNext()) {
                        if (listIterator18.next().getEndingNonPrimarySpeaker() == -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2658: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator19 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator19.hasNext()) {
                        if (listIterator19.next().getEndingNonPrimarySpeaker() != -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2659: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator20 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator20.hasNext()) {
                        if (listIterator20.next().getEndingNonPrimarySpeaker() != -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2661: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2663: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2664: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2665: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2668: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2670: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2672: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2673: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2674: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2675: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2677: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2678: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2680: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2681: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2682: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2683: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2684: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2685: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2686: {
                final int intValue76 = (int)array[0];
                (int)array[1];
                (boolean)array[2];
                return intValue76 == ((Grace)behavingEntity).me;
            }
            case 2687: {
                (int)array[0];
                (boolean)array[1];
                final ListIterator listIterator21 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                while (listIterator21.hasNext()) {
                    final BeatRevelationsP2WME beatRevelationsP2WME2;
                    final BeatRevelationsP2WME beatRevelationsP2WME = beatRevelationsP2WME2 = listIterator21.next();
                    final int rev1Topic;
                    final int rev1CharFocus;
                    final int rev1Who;
                    final int rev2Topic;
                    final int rev2CharFocus;
                    final int rev2Who;
                    final int rev3Topic;
                    final int rev3CharFocus;
                    final int rev3Who;
                    if (BehavingEntity.constantTrue(rev1Topic = beatRevelationsP2WME.getRev1Topic()) && BehavingEntity.constantTrue(rev1CharFocus = beatRevelationsP2WME.getRev1CharFocus()) && BehavingEntity.constantTrue(rev1Who = beatRevelationsP2WME.getRev1Who()) && BehavingEntity.constantTrue(rev2Topic = beatRevelationsP2WME.getRev2Topic()) && BehavingEntity.constantTrue(rev2CharFocus = beatRevelationsP2WME.getRev2CharFocus()) && BehavingEntity.constantTrue(rev2Who = beatRevelationsP2WME.getRev2Who()) && BehavingEntity.constantTrue(rev3Topic = beatRevelationsP2WME.getRev3Topic()) && BehavingEntity.constantTrue(rev3CharFocus = beatRevelationsP2WME.getRev3CharFocus()) && BehavingEntity.constantTrue(rev3Who = beatRevelationsP2WME.getRev3Who())) {
                        hashtable.put("who3", new Integer(rev3Who));
                        hashtable.put("topic1", new Integer(rev1Topic));
                        hashtable.put("topic3", new Integer(rev3Topic));
                        hashtable.put("charFocus1", new Integer(rev1CharFocus));
                        hashtable.put("who1", new Integer(rev1Who));
                        hashtable.put("charFocus3", new Integer(rev3CharFocus));
                        hashtable.put("revWME", new ObjectWrapper(beatRevelationsP2WME2));
                        hashtable.put("topic2", new Integer(rev2Topic));
                        hashtable.put("who2", new Integer(rev2Who));
                        hashtable.put("charFocus2", new Integer(rev2CharFocus));
                        return true;
                    }
                }
                return false;
            }
            case 2688: {
                final int intValue77 = (int)array[0];
                final int intValue78 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue77 == 59 && intValue78 == 0;
            }
            case 2689: {
                final int intValue79 = (int)array[0];
                final int intValue80 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue79 == 60 && intValue80 == 0;
            }
            case 2690: {
                final int intValue81 = (int)array[0];
                final int intValue82 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue81 == 61 && intValue82 == 0;
            }
            case 2691: {
                final int intValue83 = (int)array[0];
                final int intValue84 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue83 == 59 && intValue84 == 1;
            }
            case 2692: {
                final int intValue85 = (int)array[0];
                final int intValue86 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue85 == 60 && intValue86 == 1;
            }
            case 2693: {
                final int intValue87 = (int)array[0];
                final int intValue88 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue87 == 61 && intValue88 == 1;
            }
            case 2694: {
                final int intValue89 = (int)array[0];
                final int intValue90 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue89 == 59 && intValue90 == 2;
            }
            case 2695: {
                final int intValue91 = (int)array[0];
                final int intValue92 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue91 == 60 && intValue92 == 2;
            }
            case 2696: {
                final int intValue93 = (int)array[0];
                final int intValue94 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue93 == 61 && intValue94 == 2;
            }
            case 2697: {
                final int intValue95 = (int)array[0];
                final int intValue96 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue95 == 59 && intValue96 == 2;
            }
            case 2698: {
                final int intValue97 = (int)array[0];
                final int intValue98 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue97 == 60 && intValue98 == 2;
            }
            case 2699: {
                final int intValue99 = (int)array[0];
                final int intValue100 = (int)array[1];
                (int)array[2];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue99 == 61 && intValue100 == 2;
            }
            case 2701: {
                final int intValue101 = (int)array[0];
                (int)array[1];
                (boolean)array[2];
                return intValue101 != ((Grace)behavingEntity).me;
            }
            case 2702: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2704: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2706: {
                (int)array[0];
                final ListIterator listIterator22 = WorkingMemory.lookupWME("BeatMemory", "BeatEndingWME").listIterator();
                while (listIterator22.hasNext()) {
                    final BeatEndingWME beatEndingWME5;
                    final BeatEndingWME beatEndingWME4 = beatEndingWME5 = listIterator22.next();
                    final int rxn2;
                    final int ctr2;
                    if (beatEndingWME4.getRxn() >= 0 && BehavingEntity.constantTrue(rxn2 = beatEndingWME4.getRxn()) && BehavingEntity.constantTrue(ctr2 = beatEndingWME4.getCtr())) {
                        hashtable.put("endingWME", new ObjectWrapper(beatEndingWME5));
                        hashtable.put("ctr", new Integer(ctr2));
                        hashtable.put("rxn", new Integer(rxn2));
                        return true;
                    }
                }
                return false;
            }
            case 2707: {
                (int)array[0];
                final ListIterator listIterator23 = WorkingMemory.lookupWME("BeatMemory", "BeatEndingWME").listIterator();
                while (listIterator23.hasNext()) {
                    final BeatEndingWME beatEndingWME6;
                    final int rxn3;
                    if (BehavingEntity.constantTrue(rxn3 = (beatEndingWME6 = listIterator23.next()).getRxn())) {
                        hashtable.put("endingWME", new ObjectWrapper(beatEndingWME6));
                        hashtable.put("rxn", new Integer(rxn3));
                        return true;
                    }
                }
                return false;
            }
            case 2708: {
                final int intValue102 = (int)array[0];
                final int intValue103 = (int)array[1];
                final int intValue104 = (int)array[2];
                return intValue102 == ((Grace)behavingEntity).grace && intValue103 == 45 && intValue104 == 0;
            }
            case 2709: {
                final int intValue105 = (int)array[0];
                final int intValue106 = (int)array[1];
                final int intValue107 = (int)array[2];
                return intValue105 == ((Grace)behavingEntity).grace && intValue106 == 47 && intValue107 == 0;
            }
            case 2710: {
                final int intValue108 = (int)array[0];
                final int intValue109 = (int)array[1];
                final int intValue110 = (int)array[2];
                return intValue108 == ((Grace)behavingEntity).grace && intValue109 == 48 && intValue110 == 0;
            }
            case 2711: {
                final int intValue111 = (int)array[0];
                final int intValue112 = (int)array[1];
                final int intValue113 = (int)array[2];
                return intValue111 == ((Grace)behavingEntity).grace && intValue112 == 37 && intValue113 == 0;
            }
            case 2712: {
                final int intValue114 = (int)array[0];
                final int intValue115 = (int)array[1];
                final int intValue116 = (int)array[2];
                return intValue114 == ((Grace)behavingEntity).grace && intValue115 == 45 && intValue116 == 1;
            }
            case 2713: {
                final int intValue117 = (int)array[0];
                final int intValue118 = (int)array[1];
                final int intValue119 = (int)array[2];
                return intValue117 == ((Grace)behavingEntity).grace && intValue118 == 47 && intValue119 == 1;
            }
            case 2714: {
                final int intValue120 = (int)array[0];
                final int intValue121 = (int)array[1];
                final int intValue122 = (int)array[2];
                return intValue120 == ((Grace)behavingEntity).grace && intValue121 == 48 && intValue122 == 1;
            }
            case 2715: {
                final int intValue123 = (int)array[0];
                final int intValue124 = (int)array[1];
                final int intValue125 = (int)array[2];
                return intValue123 == ((Grace)behavingEntity).grace && intValue124 == 37 && intValue125 == 1;
            }
            case 2716: {
                final int intValue126 = (int)array[0];
                final int intValue127 = (int)array[1];
                final int intValue128 = (int)array[2];
                return intValue126 == ((Grace)behavingEntity).trip && intValue127 == 45 && intValue128 == 0;
            }
            case 2717: {
                final int intValue129 = (int)array[0];
                final int intValue130 = (int)array[1];
                final int intValue131 = (int)array[2];
                return intValue129 == ((Grace)behavingEntity).trip && intValue130 == 47 && intValue131 == 0;
            }
            case 2718: {
                final int intValue132 = (int)array[0];
                final int intValue133 = (int)array[1];
                final int intValue134 = (int)array[2];
                return intValue132 == ((Grace)behavingEntity).trip && intValue133 == 48 && intValue134 == 0;
            }
            case 2719: {
                final int intValue135 = (int)array[0];
                final int intValue136 = (int)array[1];
                final int intValue137 = (int)array[2];
                return intValue135 == ((Grace)behavingEntity).trip && intValue136 == 37 && intValue137 == 0;
            }
            case 2720: {
                final int intValue138 = (int)array[0];
                final int intValue139 = (int)array[1];
                final int intValue140 = (int)array[2];
                return intValue138 == ((Grace)behavingEntity).trip && intValue139 == 45 && intValue140 == 1;
            }
            case 2721: {
                final int intValue141 = (int)array[0];
                final int intValue142 = (int)array[1];
                final int intValue143 = (int)array[2];
                return intValue141 == ((Grace)behavingEntity).trip && intValue142 == 47 && intValue143 == 1;
            }
            case 2722: {
                final int intValue144 = (int)array[0];
                final int intValue145 = (int)array[1];
                final int intValue146 = (int)array[2];
                return intValue144 == ((Grace)behavingEntity).trip && intValue145 == 48 && intValue146 == 1;
            }
            case 2723: {
                final int intValue147 = (int)array[0];
                final int intValue148 = (int)array[1];
                final int intValue149 = (int)array[2];
                return intValue147 == ((Grace)behavingEntity).trip && intValue148 == 37 && intValue149 == 1;
            }
            case 2725: {
                final ListIterator listIterator24 = WorkingMemory.lookupWME("BeatMemory", "BeatEndingWME").listIterator();
                while (listIterator24.hasNext()) {
                    final BeatEndingWME beatEndingWME7;
                    if ((beatEndingWME7 = listIterator24.next()).getRxn() >= 0) {
                        hashtable.put("endingWME", new ObjectWrapper(beatEndingWME7));
                        return true;
                    }
                }
                return false;
            }
            case 2726: {
                final ListIterator listIterator25 = WorkingMemory.lookupWME("BeatMemory", "BeatEndingWME").listIterator();
                while (listIterator25.hasNext()) {
                    final BeatEndingWME beatEndingWME8;
                    final int rxn4;
                    if (BehavingEntity.constantTrue(rxn4 = (beatEndingWME8 = listIterator25.next()).getRxn())) {
                        hashtable.put("endingWME", new ObjectWrapper(beatEndingWME8));
                        hashtable.put("rxn", new Integer(rxn4));
                        return true;
                    }
                }
                return false;
            }
            case 2728: {
                return (int)array[0] == 47;
            }
            case 2729: {
                return (int)array[0] == 48;
            }
            case 2730: {
                return (int)array[0] == 37;
            }
            case 2732: {
                final ListIterator listIterator26 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator26.hasNext()) {
                    if (listIterator26.next().getCurrentBeat() == 38) {
                        return true;
                    }
                }
                return false;
            }
            case 2734: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2736: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator27 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator27.hasNext()) {
                        if (listIterator27.next().getRev1Who() == ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2737: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator28 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator28.hasNext()) {
                        if (listIterator28.next().getRev1Who() == ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2738: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator29 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator29.hasNext()) {
                        if (listIterator29.next().getRev1Who() != ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2739: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator30 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator30.hasNext()) {
                        if (listIterator30.next().getRev1Who() != ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2740: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2742: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator31 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator31.hasNext()) {
                        if (listIterator31.next().getRev1Who() == ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2743: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator32 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator32.hasNext()) {
                        if (listIterator32.next().getRev1Who() == ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2744: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator33 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator33.hasNext()) {
                        if (listIterator33.next().getRev1Who() != ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2745: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator34 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator34.hasNext()) {
                        if (listIterator34.next().getRev1Who() != ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2748: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2750: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2751: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2752: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2754: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2755: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2757: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2759: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2760: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2761: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2763: {
                final ListIterator listIterator35 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator35.hasNext()) {
                    if (listIterator35.next().getCurrentBeat() == 39) {
                        return true;
                    }
                }
                return false;
            }
            case 2765: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2767: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator36 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator36.hasNext()) {
                        if (listIterator36.next().getEndingSRNotGTR_RelatSpeaker() == ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2768: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator37 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator37.hasNext()) {
                        if (listIterator37.next().getEndingSRNotGTR_RelatSpeaker() == ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2769: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator38 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator38.hasNext()) {
                        if (listIterator38.next().getEndingSRNotGTR_RelatSpeaker() != ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2770: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator39 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator39.hasNext()) {
                        if (listIterator39.next().getEndingSRNotGTR_RelatSpeaker() != ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2771: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2773: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator40 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator40.hasNext()) {
                        if (listIterator40.next().getEndingSRNotGTR_RelatSpeaker() == ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2774: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator41 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator41.hasNext()) {
                        if (listIterator41.next().getEndingSRNotGTR_RelatSpeaker() == ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2775: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace) {
                    final ListIterator listIterator42 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator42.hasNext()) {
                        if (listIterator42.next().getEndingSRNotGTR_RelatSpeaker() != ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2776: {
                if (((Grace)behavingEntity).me == ((Grace)behavingEntity).trip) {
                    final ListIterator listIterator43 = WorkingMemory.lookupWME("StoryMemory", "BeatRevelationsP2WME").listIterator();
                    while (listIterator43.hasNext()) {
                        if (listIterator43.next().getEndingSRNotGTR_RelatSpeaker() != ((Grace)behavingEntity).me) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 2777: {
                return (int)array[0] != -1;
            }
            case 2778: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2780: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2781: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2782: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2785: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2787: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2788: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2789: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2791: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2792: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2793: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2794: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2795: {
                final ListIterator listIterator44 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator44.hasNext()) {
                    if (listIterator44.next().getCurrentBeat() == 40) {
                        return true;
                    }
                }
                return false;
            }
            case 2797: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2799: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2800: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2801: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2803: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2804: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2805: {
                (int)array[0];
                final int intValue150 = (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                return intValue150 != ((Grace)behavingEntity).me;
            }
            case 2807: {
                final int intValue151 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue151 == 59;
            }
            case 2808: {
                final int intValue152 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue152 == 59;
            }
            case 2809: {
                final int intValue153 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue153 == 60;
            }
            case 2810: {
                final int intValue154 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue154 == 60;
            }
            case 2811: {
                final int intValue155 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue155 == 61;
            }
            case 2812: {
                final int intValue156 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue156 == 61;
            }
            case 2813: {
                (int)array[0];
                final int intValue157 = (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                return intValue157 == ((Grace)behavingEntity).me;
            }
            case 2815: {
                final int intValue158 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && (intValue158 == 59 || intValue158 == 60 || intValue158 == 61);
            }
            case 2816: {
                final int intValue159 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && (intValue159 == 59 || intValue159 == 60 || intValue159 == 61);
            }
            case 2817: {
                final int intValue160 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue160 == 59;
            }
            case 2818: {
                final int intValue161 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue161 == 59;
            }
            case 2819: {
                final int intValue162 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue162 == 60;
            }
            case 2820: {
                final int intValue163 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue163 == 60;
            }
            case 2821: {
                final int intValue164 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue164 == 61;
            }
            case 2822: {
                final int intValue165 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && intValue165 == 61;
            }
            case 2824: {
                (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2828: {
                (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2834: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 2837: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 2839: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 2841: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 2843: {
                (int)array[0];
                final ListIterator listIterator45 = WorkingMemory.lookupWME("BeatMemory", "BeatEndingWME").listIterator();
                while (listIterator45.hasNext()) {
                    final BeatEndingWME beatEndingWME10;
                    final BeatEndingWME beatEndingWME9 = beatEndingWME10 = listIterator45.next();
                    final int rxn5;
                    final int ctr3;
                    if (beatEndingWME9.getRxn() >= 0 && BehavingEntity.constantTrue(rxn5 = beatEndingWME9.getRxn()) && BehavingEntity.constantTrue(ctr3 = beatEndingWME9.getCtr())) {
                        hashtable.put("endingWME", new ObjectWrapper(beatEndingWME10));
                        hashtable.put("ctr", new Integer(ctr3));
                        hashtable.put("rxn", new Integer(rxn5));
                        return true;
                    }
                }
                return false;
            }
            case 2844: {
                final int intValue166 = (int)array[0];
                final int intValue167 = (int)array[1];
                final int intValue168 = (int)array[2];
                return intValue166 == ((Grace)behavingEntity).grace && intValue167 == 45 && intValue168 == 0;
            }
            case 2845: {
                final int intValue169 = (int)array[0];
                final int intValue170 = (int)array[1];
                final int intValue171 = (int)array[2];
                return intValue169 == ((Grace)behavingEntity).grace && intValue170 == 47 && intValue171 == 0;
            }
            case 2846: {
                final int intValue172 = (int)array[0];
                final int intValue173 = (int)array[1];
                final int intValue174 = (int)array[2];
                return intValue172 == ((Grace)behavingEntity).grace && intValue173 == 48 && intValue174 == 0;
            }
            case 2847: {
                final int intValue175 = (int)array[0];
                final int intValue176 = (int)array[1];
                final int intValue177 = (int)array[2];
                return intValue175 == ((Grace)behavingEntity).grace && intValue176 == 37 && intValue177 == 0;
            }
            case 2848: {
                final int intValue178 = (int)array[0];
                final int intValue179 = (int)array[1];
                final int intValue180 = (int)array[2];
                return intValue178 == ((Grace)behavingEntity).grace && intValue179 == 45 && intValue180 == 1;
            }
            case 2849: {
                final int intValue181 = (int)array[0];
                final int intValue182 = (int)array[1];
                final int intValue183 = (int)array[2];
                return intValue181 == ((Grace)behavingEntity).grace && intValue182 == 47 && intValue183 == 1;
            }
            case 2850: {
                final int intValue184 = (int)array[0];
                final int intValue185 = (int)array[1];
                final int intValue186 = (int)array[2];
                return intValue184 == ((Grace)behavingEntity).grace && intValue185 == 48 && intValue186 == 1;
            }
            case 2851: {
                final int intValue187 = (int)array[0];
                final int intValue188 = (int)array[1];
                final int intValue189 = (int)array[2];
                return intValue187 == ((Grace)behavingEntity).grace && intValue188 == 37 && intValue189 == 1;
            }
            case 2852: {
                final int intValue190 = (int)array[0];
                final int intValue191 = (int)array[1];
                final int intValue192 = (int)array[2];
                return intValue190 == ((Grace)behavingEntity).trip && intValue191 == 45 && intValue192 == 0;
            }
            case 2853: {
                final int intValue193 = (int)array[0];
                final int intValue194 = (int)array[1];
                final int intValue195 = (int)array[2];
                return intValue193 == ((Grace)behavingEntity).trip && intValue194 == 47 && intValue195 == 0;
            }
            case 2854: {
                final int intValue196 = (int)array[0];
                final int intValue197 = (int)array[1];
                final int intValue198 = (int)array[2];
                return intValue196 == ((Grace)behavingEntity).trip && intValue197 == 48 && intValue198 == 0;
            }
            case 2855: {
                final int intValue199 = (int)array[0];
                final int intValue200 = (int)array[1];
                final int intValue201 = (int)array[2];
                return intValue199 == ((Grace)behavingEntity).trip && intValue200 == 37 && intValue201 == 0;
            }
            case 2856: {
                final int intValue202 = (int)array[0];
                final int intValue203 = (int)array[1];
                final int intValue204 = (int)array[2];
                return intValue202 == ((Grace)behavingEntity).trip && intValue203 == 45 && intValue204 == 1;
            }
            case 2857: {
                final int intValue205 = (int)array[0];
                final int intValue206 = (int)array[1];
                final int intValue207 = (int)array[2];
                return intValue205 == ((Grace)behavingEntity).trip && intValue206 == 47 && intValue207 == 1;
            }
            case 2858: {
                final int intValue208 = (int)array[0];
                final int intValue209 = (int)array[1];
                final int intValue210 = (int)array[2];
                return intValue208 == ((Grace)behavingEntity).trip && intValue209 == 48 && intValue210 == 1;
            }
            case 2859: {
                final int intValue211 = (int)array[0];
                final int intValue212 = (int)array[1];
                final int intValue213 = (int)array[2];
                return intValue211 == ((Grace)behavingEntity).trip && intValue212 == 37 && intValue213 == 1;
            }
            case 2861: {
                final ListIterator listIterator46 = WorkingMemory.lookupWME("BeatMemory", "BeatEndingWME").listIterator();
                while (listIterator46.hasNext()) {
                    final BeatEndingWME beatEndingWME11;
                    if ((beatEndingWME11 = listIterator46.next()).getRxn() >= 0) {
                        hashtable.put("endingWME", new ObjectWrapper(beatEndingWME11));
                        return true;
                    }
                }
                return false;
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
    
    public static boolean precondition4(final int n, final Object[] array, final Hashtable hashtable, final BehavingEntity behavingEntity) {
        switch (n) {
            case 2864: {
                return (int)array[0] == 47;
            }
            case 2865: {
                return (int)array[0] == 48;
            }
            case 2866: {
                return (int)array[0] == 37;
            }
            case 2902: {
                final ListIterator listIterator = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator.hasNext()) {
                    if (listIterator.next().getObjectCategory() == 1) {
                        return false;
                    }
                }
                return true;
            }
            case 2903: {
                final ListIterator listIterator2 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2915: {
                final ListIterator listIterator3 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator3.hasNext()) {
                    if (listIterator3.next().getGender() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 2916: {
                final ListIterator listIterator4 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator4.hasNext()) {
                    if (listIterator4.next().getGender() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2926: {
                final ListIterator listIterator5 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator5.hasNext()) {
                    if (listIterator5.next().getGender() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 2927: {
                final ListIterator listIterator6 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator6.hasNext()) {
                    if (listIterator6.next().getGender() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2938: {
                final ListIterator listIterator7 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator7.hasNext()) {
                    if (listIterator7.next().getGender() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 2939: {
                final ListIterator listIterator8 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator8.hasNext()) {
                    if (listIterator8.next().getGender() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2951: {
                final ListIterator listIterator9 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator9.hasNext()) {
                    if (listIterator9.next().getGender() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 2952: {
                final ListIterator listIterator10 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator10.hasNext()) {
                    if (listIterator10.next().getGender() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2953: {
                final ListIterator listIterator11 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator11.hasNext()) {
                    if (listIterator11.next().getObjectCategory() == 1) {
                        return false;
                    }
                }
                return true;
            }
            case 2954: {
                final ListIterator listIterator12 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator12.hasNext()) {
                    if (listIterator12.next().getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2955: {
                final ListIterator listIterator13 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator13.hasNext()) {
                    if (listIterator13.next().getObjectCategory() == 1) {
                        return false;
                    }
                }
                return true;
            }
            case 2956: {
                final ListIterator listIterator14 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator14.hasNext()) {
                    if (listIterator14.next().getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2970: {
                final ListIterator listIterator15 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator15.hasNext()) {
                    if (listIterator15.next().getGender() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 2971: {
                final ListIterator listIterator16 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator16.hasNext()) {
                    if (listIterator16.next().getGender() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2981: {
                final ListIterator listIterator17 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator17.hasNext()) {
                    if (listIterator17.next().getGender() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 2982: {
                final ListIterator listIterator18 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator18.hasNext()) {
                    if (listIterator18.next().getGender() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2983: {
                final ListIterator listIterator19 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator19.hasNext()) {
                    if (listIterator19.next().getObjectCategory() == 1) {
                        return false;
                    }
                }
                return true;
            }
            case 2984: {
                final ListIterator listIterator20 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator20.hasNext()) {
                    if (listIterator20.next().getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2985: {
                final ListIterator listIterator21 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator21.hasNext()) {
                    if (listIterator21.next().getObjectCategory() == 1) {
                        return false;
                    }
                }
                return true;
            }
            case 2986: {
                final ListIterator listIterator22 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator22.hasNext()) {
                    if (listIterator22.next().getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 2997: {
                return (int)array[0] == 0;
            }
            case 3000: {
                return (int)array[0] == 1;
            }
            case 3002: {
                return (int)array[0] == 2;
            }
            case 3005: {
                return (int)array[0] == 3;
            }
            case 3010: {
                return (int)array[0] == 0;
            }
            case 3013: {
                return (int)array[0] == 1;
            }
            case 3016: {
                return (int)array[0] == 2;
            }
            case 3019: {
                return (int)array[0] == 3;
            }
            case 3115: {
                final ListIterator listIterator23 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator23.hasNext()) {
                    if (listIterator23.next().getSVal().equals("gmL1_Obj_BrassBull")) {
                        return false;
                    }
                }
                return true;
            }
            case 3144: {
                final ListIterator listIterator24 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator24.hasNext()) {
                    final int affinity;
                    if (BehavingEntity.constantTrue(affinity = listIterator24.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity));
                        return true;
                    }
                }
                return false;
            }
            case 3145: {
                final ListIterator listIterator25 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator25.hasNext()) {
                    final int affinity2;
                    if (BehavingEntity.constantTrue(affinity2 = listIterator25.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity2));
                        return true;
                    }
                }
                return false;
            }
            case 3147: {
                final ListIterator listIterator26 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator26.hasNext()) {
                    final int affinity3;
                    if (BehavingEntity.constantTrue(affinity3 = listIterator26.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity3));
                        return true;
                    }
                }
                return false;
            }
            case 3148: {
                final ListIterator listIterator27 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator27.hasNext()) {
                    final int affinity4;
                    if (BehavingEntity.constantTrue(affinity4 = listIterator27.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity4));
                        return true;
                    }
                }
                return false;
            }
            case 3256: {
                (int)array[0];
                final ListIterator listIterator28 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator28.hasNext()) {
                    final int affinity5;
                    if (BehavingEntity.constantTrue(affinity5 = listIterator28.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity5));
                        return true;
                    }
                }
                return false;
            }
            case 3257: {
                (int)array[0];
                final ListIterator listIterator29 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator29.hasNext()) {
                    if (listIterator29.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3258: {
                (int)array[0];
                final ListIterator listIterator30 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator30.hasNext()) {
                    if (listIterator30.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3259: {
                (int)array[0];
                final ListIterator listIterator31 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator31.hasNext()) {
                    if (listIterator31.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3260: {
                (int)array[0];
                final ListIterator listIterator32 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator32.hasNext()) {
                    if (listIterator32.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3261: {
                (int)array[0];
                final ListIterator listIterator33 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator33.hasNext()) {
                    if (listIterator33.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3262: {
                (int)array[0];
                final ListIterator listIterator34 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator34.hasNext()) {
                    if (listIterator34.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3263: {
                return (int)array[0] == 34;
            }
            case 3264: {
                return (int)array[0] == 34;
            }
            case 3265: {
                return (int)array[0] == 34;
            }
            case 3266: {
                (int)array[0];
                final ListIterator listIterator35 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator35.hasNext()) {
                    if (listIterator35.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3267: {
                (int)array[0];
                final ListIterator listIterator36 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator36.hasNext()) {
                    if (listIterator36.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3268: {
                (int)array[0];
                final ListIterator listIterator37 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator37.hasNext()) {
                    if (listIterator37.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3269: {
                (int)array[0];
                final ListIterator listIterator38 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator38.hasNext()) {
                    if (listIterator38.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3270: {
                (int)array[0];
                final ListIterator listIterator39 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator39.hasNext()) {
                    if (listIterator39.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3271: {
                (int)array[0];
                final ListIterator listIterator40 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator40.hasNext()) {
                    if (listIterator40.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3272: {
                return (int)array[0] == 34;
            }
            case 3273: {
                return (int)array[0] == 34;
            }
            case 3274: {
                return (int)array[0] == 34;
            }
            case 3275: {
                (int)array[0];
                final ListIterator listIterator41 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator41.hasNext()) {
                    if (listIterator41.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3276: {
                (int)array[0];
                final ListIterator listIterator42 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator42.hasNext()) {
                    if (listIterator42.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3277: {
                (int)array[0];
                final ListIterator listIterator43 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator43.hasNext()) {
                    if (listIterator43.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3278: {
                (int)array[0];
                final ListIterator listIterator44 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator44.hasNext()) {
                    if (listIterator44.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3279: {
                (int)array[0];
                final ListIterator listIterator45 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator45.hasNext()) {
                    if (listIterator45.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3280: {
                (int)array[0];
                final ListIterator listIterator46 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator46.hasNext()) {
                    if (listIterator46.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3281: {
                return (int)array[0] == 34;
            }
            case 3282: {
                return (int)array[0] == 34;
            }
            case 3283: {
                return (int)array[0] == 34;
            }
            case 3284: {
                final ListIterator listIterator47 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator47.hasNext()) {
                    if (listIterator47.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3285: {
                final ListIterator listIterator48 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator48.hasNext()) {
                    if (listIterator48.next().getAffinity() <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3286: {
                final ListIterator listIterator49 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator49.hasNext()) {
                    if (listIterator49.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3287: {
                final ListIterator listIterator50 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator50.hasNext()) {
                    if (listIterator50.next().getAffinity() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3406: {
                final ListIterator listIterator51 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator51.hasNext()) {
                    if (listIterator51.next().getSVal().equals("gmL1_Satl_Marriage")) {
                        return false;
                    }
                }
                return true;
            }
            case 3410: {
                final ListIterator listIterator52 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator52.hasNext()) {
                    if (listIterator52.next().getSVal().equals("gmL1_Satl_Marriage")) {
                        return true;
                    }
                }
                return false;
            }
            case 3494: {
                (int)array[0];
                final ListIterator listIterator53 = BehavingEntity.getBehavingEntity().lookupWME("MiscFlagWME").listIterator();
                if (!listIterator53.hasNext()) {
                    return false;
                }
                hashtable.put("miscFlagWME", new ObjectWrapper(listIterator53.next()));
                return true;
            }
            case 3496: {
                return !(boolean)array[0];
            }
            case 3502: {
                return (boolean)array[0];
            }
            case 3579: {
                final int intValue = (int)array[0];
                final ListIterator listIterator54 = BehavingEntity.getBehavingEntity().lookupWME("GazeWME").listIterator();
                while (listIterator54.hasNext()) {
                    final GazeWME gazeWME = listIterator54.next();
                    final int type;
                    final int objectID;
                    if (BehavingEntity.constantTrue(type = gazeWME.getType()) && BehavingEntity.constantTrue(objectID = gazeWME.getObjectID()) && (intValue != objectID || (type != 0 && type != 5))) {
                        hashtable.put("curType", new Integer(type));
                        hashtable.put("curWho", new Integer(objectID));
                        return true;
                    }
                }
                return false;
            }
            case 3580: {
                final int intValue2 = (int)array[0];
                final ListIterator listIterator55 = BehavingEntity.getBehavingEntity().lookupWME("GazeWME").listIterator();
                while (listIterator55.hasNext()) {
                    final GazeWME gazeWME2 = listIterator55.next();
                    final int type2;
                    final int objectID2;
                    if (BehavingEntity.constantTrue(type2 = gazeWME2.getType()) && BehavingEntity.constantTrue(objectID2 = gazeWME2.getObjectID()) && (intValue2 != objectID2 || (type2 != 0 && type2 != 5))) {
                        hashtable.put("curType", new Integer(type2));
                        hashtable.put("curWho", new Integer(objectID2));
                        return true;
                    }
                }
                return false;
            }
            case 3581: {
                final int intValue3 = (int)array[0];
                final ListIterator listIterator56 = BehavingEntity.getBehavingEntity().lookupWME("GazeWME").listIterator();
                while (listIterator56.hasNext()) {
                    final GazeWME gazeWME3 = listIterator56.next();
                    final int type3;
                    final int objectID3;
                    if (BehavingEntity.constantTrue(type3 = gazeWME3.getType()) && BehavingEntity.constantTrue(objectID3 = gazeWME3.getObjectID()) && (intValue3 != objectID3 || (type3 != 1 && type3 != 6))) {
                        hashtable.put("curType", new Integer(type3));
                        hashtable.put("curWho", new Integer(objectID3));
                        return true;
                    }
                }
                return false;
            }
            case 3582: {
                final int intValue4 = (int)array[0];
                final ListIterator listIterator57 = BehavingEntity.getBehavingEntity().lookupWME("GazeWME").listIterator();
                while (listIterator57.hasNext()) {
                    final GazeWME gazeWME4 = listIterator57.next();
                    final int type4;
                    final int objectID4;
                    if (BehavingEntity.constantTrue(type4 = gazeWME4.getType()) && BehavingEntity.constantTrue(objectID4 = gazeWME4.getObjectID()) && (intValue4 != objectID4 || (type4 != 1 && type4 != 6))) {
                        hashtable.put("curType", new Integer(type4));
                        hashtable.put("curWho", new Integer(objectID4));
                        return true;
                    }
                }
                return false;
            }
            case 3583: {
                return (int)array[0] != 0;
            }
            case 3584: {
                return (int)array[0] != 1;
            }
            case 3585: {
                return (int)array[0] != 2;
            }
            case 3586: {
                return (int)array[0] != 3;
            }
            case 3587: {
                return (int)array[0] != 4;
            }
            case 3590: {
                final int intValue5 = (int)array[0];
                (int)array[1];
                return intValue5 != -1;
            }
            case 3591: {
                final int intValue6 = (int)array[0];
                (int)array[1];
                return intValue6 == -1;
            }
            case 3597: {
                (int)array[0];
                final ListIterator listIterator58 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator58.hasNext()) {
                    final ObjectPositionWME objectPositionWME = listIterator58.next();
                    final float x;
                    final float z;
                    if (objectPositionWME.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x = objectPositionWME.getX()) && BehavingEntity.constantTrue(z = objectPositionWME.getZ())) {
                        final ListIterator listIterator59 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator59.hasNext()) {
                            final ObjectPositionWME objectPositionWME2 = listIterator59.next();
                            final float x2;
                            final float z2;
                            if (objectPositionWME2.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x2 = objectPositionWME2.getX()) && BehavingEntity.constantTrue(z2 = objectPositionWME2.getZ())) {
                                hashtable.put("playerX", new Float(x2));
                                hashtable.put("myX", new Float(x));
                                hashtable.put("playerZ", new Float(z2));
                                hashtable.put("myZ", new Float(z));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 3598: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                final ListIterator listIterator60 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator60.hasNext()) {
                    final ObjectPositionWME objectPositionWME3 = listIterator60.next();
                    final float x3;
                    final float z3;
                    if (objectPositionWME3.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x3 = objectPositionWME3.getX()) && BehavingEntity.constantTrue(z3 = objectPositionWME3.getZ())) {
                        final ListIterator listIterator61 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator61.hasNext()) {
                            final ObjectPositionWME objectPositionWME4 = listIterator61.next();
                            final float x4;
                            final float z4;
                            if (objectPositionWME4.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x4 = objectPositionWME4.getX()) && BehavingEntity.constantTrue(z4 = objectPositionWME4.getZ())) {
                                hashtable.put("playerX", new Float(x4));
                                hashtable.put("myX", new Float(x3));
                                hashtable.put("playerZ", new Float(z4));
                                hashtable.put("myZ", new Float(z3));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 3600: {
                (int)array[0];
                return (int)array[1] >= 0;
            }
            case 3605: {
                final ListIterator listIterator62 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator62.hasNext()) {
                    final ObjectPositionWME objectPositionWME5 = listIterator62.next();
                    final float x5;
                    final float z5;
                    if (objectPositionWME5.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x5 = objectPositionWME5.getX()) && BehavingEntity.constantTrue(z5 = objectPositionWME5.getZ())) {
                        final ListIterator listIterator63 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator63.hasNext()) {
                            final ObjectPositionWME objectPositionWME6 = listIterator63.next();
                            final float x6;
                            final float z6;
                            if (objectPositionWME6.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x6 = objectPositionWME6.getX()) && BehavingEntity.constantTrue(z6 = objectPositionWME6.getZ()) && Staging.getXZDistanceBetweenPoints(x5, z5, x6, z6) < 45.0f) {
                                hashtable.put("playerX", new Float(x6));
                                hashtable.put("myX", new Float(x5));
                                hashtable.put("playerZ", new Float(z6));
                                hashtable.put("myZ", new Float(z5));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 3606: {
                final long longValue = (long)array[0];
                if (longValue == 0L || longValue > System.currentTimeMillis()) {
                    final ListIterator listIterator64 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                    while (listIterator64.hasNext()) {
                        final ObjectPositionWME objectPositionWME7 = listIterator64.next();
                        final float x7;
                        final float z7;
                        if (objectPositionWME7.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x7 = objectPositionWME7.getX()) && BehavingEntity.constantTrue(z7 = objectPositionWME7.getZ())) {
                            final ListIterator listIterator65 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                            while (listIterator65.hasNext()) {
                                final ObjectPositionWME objectPositionWME8 = listIterator65.next();
                                final float x8;
                                final float z8;
                                if (objectPositionWME8.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x8 = objectPositionWME8.getX()) && BehavingEntity.constantTrue(z8 = objectPositionWME8.getZ())) {
                                    final ListIterator listIterator66 = BehavingEntity.getBehavingEntity().lookupWME("MiscFlagWME").listIterator();
                                    if (!listIterator66.hasNext()) {
                                        continue;
                                    }
                                    final MiscFlagWME miscFlagWME = listIterator66.next();
                                    hashtable.put("playerX", new Float(x8));
                                    hashtable.put("myX", new Float(x7));
                                    hashtable.put("playerZ", new Float(z8));
                                    hashtable.put("miscFlagWME", new ObjectWrapper(miscFlagWME));
                                    hashtable.put("myZ", new Float(z7));
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 3607: {
                final float floatValue = (float)array[0];
                (float)array[1];
                return floatValue != -999.0f;
            }
            case 3608: {
                (float)array[0];
                return (float)array[1] != ((Grace)behavingEntity).DONTCAREANGLE;
            }
            case 3609: {
                final ListIterator listIterator67 = BehavingEntity.getBehavingEntity().lookupWME("MiscFlagWME").listIterator();
                if (!listIterator67.hasNext()) {
                    return false;
                }
                hashtable.put("miscFlagWME", new ObjectWrapper(listIterator67.next()));
                return true;
            }
            case 3610: {
                final ListIterator listIterator68 = BehavingEntity.getBehavingEntity().lookupWME("MiscFlagWME").listIterator();
                if (!listIterator68.hasNext()) {
                    return false;
                }
                hashtable.put("miscFlagWME", new ObjectWrapper(listIterator68.next()));
                return true;
            }
            case 3611: {
                final int intValue7 = (int)array[0];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && intValue7 != -1;
            }
            case 3613: {
                return (int)array[0] != -1;
            }
            case 3615: {
                final int intValue8 = (int)array[0];
                (int)array[1];
                return intValue8 != -1;
            }
            case 3616: {
                return (int)array[0] != -1;
            }
            case 3625: {
                final int intValue9 = (int)array[0];
                (int)array[1];
                return intValue9 != -1;
            }
            case 3626: {
                return (int)array[0] != -1;
            }
            case 3635: {
                final int intValue10 = (int)array[0];
                (int)array[1];
                return intValue10 != -1;
            }
            case 3636: {
                return (int)array[0] != -1;
            }
            case 3644: {
                final ListIterator listIterator69 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator69.hasNext()) {
                    if (listIterator69.next().getReestWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 3645: {
                final ListIterator listIterator70 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator70.hasNext()) {
                    final DeflectModeWME deflectModeWME = listIterator70.next();
                    final int reestPlayer;
                    final int reestDialog1;
                    final int reestFEBase1;
                    final int reestMood1;
                    if (BehavingEntity.constantTrue(reestPlayer = deflectModeWME.getReestPlayer()) && BehavingEntity.constantTrue(reestDialog1 = deflectModeWME.getReestDialog1()) && BehavingEntity.constantTrue(reestFEBase1 = deflectModeWME.getReestFEBase1()) && BehavingEntity.constantTrue(reestMood1 = deflectModeWME.getReestMood1())) {
                        hashtable.put("FEBase", new Integer(reestFEBase1));
                        hashtable.put("dia1", new Integer(reestPlayer));
                        hashtable.put("dia2", new Integer(reestDialog1));
                        hashtable.put("mood", new Integer(reestMood1));
                        return true;
                    }
                }
                return false;
            }
            case 3650: {
                final ListIterator listIterator71 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator71.hasNext()) {
                    if (listIterator71.next().getReestWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 3654: {
                final ListIterator listIterator72 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator72.hasNext()) {
                    if (listIterator72.next().getReestWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 3656: {
                final ListIterator listIterator73 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator73.hasNext()) {
                    final DeflectModeWME deflectModeWME2 = listIterator73.next();
                    if (deflectModeWME2.getReestWho() != ((Grace)behavingEntity).me && deflectModeWME2.getReestOtherFinalSigh() >= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3657: {
                final ListIterator listIterator74 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator74.hasNext()) {
                    final int reestOtherFinalSigh;
                    if (BehavingEntity.constantTrue(reestOtherFinalSigh = listIterator74.next().getReestOtherFinalSigh())) {
                        hashtable.put("reestOtherFinalSigh", new Integer(reestOtherFinalSigh));
                        return true;
                    }
                }
                return false;
            }
            case 3658: {
                final ListIterator listIterator75 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator75.hasNext()) {
                    if (listIterator75.next().getReestWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 3659: {
                final ListIterator listIterator76 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator76.hasNext()) {
                    final DeflectModeWME deflectModeWME3 = listIterator76.next();
                    final int reestPlayer2;
                    final int reestDialog2;
                    final int reestFEBase2;
                    final int reestMood2;
                    if (BehavingEntity.constantTrue(reestPlayer2 = deflectModeWME3.getReestPlayer()) && BehavingEntity.constantTrue(reestDialog2 = deflectModeWME3.getReestDialog2()) && BehavingEntity.constantTrue(reestFEBase2 = deflectModeWME3.getReestFEBase2()) && BehavingEntity.constantTrue(reestMood2 = deflectModeWME3.getReestMood2())) {
                        hashtable.put("FEBase", new Integer(reestFEBase2));
                        hashtable.put("dia1", new Integer(reestPlayer2));
                        hashtable.put("dia2", new Integer(reestDialog2));
                        hashtable.put("mood", new Integer(reestMood2));
                        return true;
                    }
                }
                return false;
            }
            case 3664: {
                final ListIterator listIterator77 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator77.hasNext()) {
                    if (listIterator77.next().getReestWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 3668: {
                final ListIterator listIterator78 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator78.hasNext()) {
                    if (listIterator78.next().getReestWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 3670: {
                final ListIterator listIterator79 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator79.hasNext()) {
                    final DeflectModeWME deflectModeWME4 = listIterator79.next();
                    if (deflectModeWME4.getReestWho() != ((Grace)behavingEntity).me && deflectModeWME4.getReestOtherFinalSigh() >= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3671: {
                final ListIterator listIterator80 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator80.hasNext()) {
                    final int reestOtherFinalSigh2;
                    if (BehavingEntity.constantTrue(reestOtherFinalSigh2 = listIterator80.next().getReestOtherFinalSigh())) {
                        hashtable.put("reestOtherFinalSigh", new Integer(reestOtherFinalSigh2));
                        return true;
                    }
                }
                return false;
            }
            case 3672: {
                final ListIterator listIterator81 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator81.hasNext()) {
                    if (listIterator81.next().getReestWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 3673: {
                final ListIterator listIterator82 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator82.hasNext()) {
                    final DeflectModeWME deflectModeWME5 = listIterator82.next();
                    final int reestPlayer3;
                    final int reestDialog3;
                    final int reestFEBase3;
                    final int reestMood3;
                    if (BehavingEntity.constantTrue(reestPlayer3 = deflectModeWME5.getReestPlayer()) && BehavingEntity.constantTrue(reestDialog3 = deflectModeWME5.getReestDialog3()) && BehavingEntity.constantTrue(reestFEBase3 = deflectModeWME5.getReestFEBase3()) && BehavingEntity.constantTrue(reestMood3 = deflectModeWME5.getReestMood3())) {
                        hashtable.put("FEBase", new Integer(reestFEBase3));
                        hashtable.put("dia1", new Integer(reestPlayer3));
                        hashtable.put("dia2", new Integer(reestDialog3));
                        hashtable.put("mood", new Integer(reestMood3));
                        return true;
                    }
                }
                return false;
            }
            case 3678: {
                final ListIterator listIterator83 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator83.hasNext()) {
                    if (listIterator83.next().getReestWho() != ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 3682: {
                final ListIterator listIterator84 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator84.hasNext()) {
                    if (listIterator84.next().getReestWho() == ((Grace)behavingEntity).me) {
                        return true;
                    }
                }
                return false;
            }
            case 3684: {
                final ListIterator listIterator85 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator85.hasNext()) {
                    final DeflectModeWME deflectModeWME6 = listIterator85.next();
                    if (deflectModeWME6.getReestWho() != ((Grace)behavingEntity).me && deflectModeWME6.getReestOtherFinalSigh() >= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3685: {
                final ListIterator listIterator86 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                while (listIterator86.hasNext()) {
                    final int reestOtherFinalSigh3;
                    if (BehavingEntity.constantTrue(reestOtherFinalSigh3 = listIterator86.next().getReestOtherFinalSigh())) {
                        hashtable.put("reestOtherFinalSigh", new Integer(reestOtherFinalSigh3));
                        return true;
                    }
                }
                return false;
            }
            case 3686: {
                (int)array[0];
                final int intValue11 = (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                return intValue11 == ((Grace)behavingEntity).me;
            }
            case 3688: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 3689: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 3690: {
                (int)array[0];
                (boolean)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 3691: {
                (int)array[0];
                (boolean)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).trip;
            }
            case 3692: {
                (int)array[0];
                final int intValue12 = (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                return intValue12 != ((Grace)behavingEntity).me;
            }
            case 3717: {
                final ListIterator listIterator87 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator87.hasNext()) {
                    final HeldObjectWME heldObjectWME = listIterator87.next();
                    if (heldObjectWME.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME.getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 3726: {
                final ListIterator listIterator88 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator88.hasNext()) {
                    if (listIterator88.next().getGender() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3727: {
                final ListIterator listIterator89 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator89.hasNext()) {
                    if (listIterator89.next().getGender() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 3738: {
                final ListIterator listIterator90 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator90.hasNext()) {
                    if (listIterator90.next().getGender() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3739: {
                final ListIterator listIterator91 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator91.hasNext()) {
                    if (listIterator91.next().getGender() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 3751: {
                final ListIterator listIterator92 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator92.hasNext()) {
                    if (listIterator92.next().getGender() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3752: {
                final ListIterator listIterator93 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator93.hasNext()) {
                    if (listIterator93.next().getGender() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 3762: {
                final ListIterator listIterator94 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator94.hasNext()) {
                    if (listIterator94.next().getGender() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3763: {
                final ListIterator listIterator95 = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                while (listIterator95.hasNext()) {
                    if (listIterator95.next().getGender() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 3764: {
                final ListIterator listIterator96 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator96.hasNext()) {
                    if (listIterator96.next().getObjectCategory() == 1) {
                        return false;
                    }
                }
                return true;
            }
            case 3765: {
                final ListIterator listIterator97 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator97.hasNext()) {
                    if (listIterator97.next().getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 3766: {
                final ListIterator listIterator98 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator98.hasNext()) {
                    if (listIterator98.next().getObjectCategory() == 1) {
                        return false;
                    }
                }
                return true;
            }
            case 3767: {
                final ListIterator listIterator99 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator99.hasNext()) {
                    if (listIterator99.next().getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 3778: {
                return (int)array[0] == 0;
            }
            case 3781: {
                return (int)array[0] == 1;
            }
            case 3784: {
                return (int)array[0] == 2;
            }
            case 3787: {
                return (int)array[0] == 3;
            }
            case 3792: {
                return (int)array[0] == 0;
            }
            case 3795: {
                return (int)array[0] == 1;
            }
            case 3798: {
                return (int)array[0] == 2;
            }
            case 3801: {
                return (int)array[0] == 3;
            }
            case 3897: {
                final ListIterator listIterator100 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator100.hasNext()) {
                    if (listIterator100.next().getSVal().equals("gmL1_Obj_BrassBull")) {
                        return false;
                    }
                }
                return true;
            }
            case 3926: {
                final ListIterator listIterator101 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator101.hasNext()) {
                    final int affinity6;
                    if (BehavingEntity.constantTrue(affinity6 = listIterator101.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity6));
                        return true;
                    }
                }
                return false;
            }
            case 3927: {
                final ListIterator listIterator102 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator102.hasNext()) {
                    final int affinity7;
                    if (BehavingEntity.constantTrue(affinity7 = listIterator102.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity7));
                        return true;
                    }
                }
                return false;
            }
            case 3929: {
                final ListIterator listIterator103 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator103.hasNext()) {
                    final int affinity8;
                    if (BehavingEntity.constantTrue(affinity8 = listIterator103.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity8));
                        return true;
                    }
                }
                return false;
            }
            case 3930: {
                final ListIterator listIterator104 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator104.hasNext()) {
                    final int affinity9;
                    if (BehavingEntity.constantTrue(affinity9 = listIterator104.next().getAffinity())) {
                        hashtable.put("affinity", new Integer(affinity9));
                        return true;
                    }
                }
                return false;
            }
            case 4123: {
                final ListIterator listIterator105 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator105.hasNext()) {
                    if (listIterator105.next().getSVal().equals("gmL1_Satl_Marriage")) {
                        return false;
                    }
                }
                return true;
            }
            case 4127: {
                final ListIterator listIterator106 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator106.hasNext()) {
                    if (listIterator106.next().getSVal().equals("gmL1_Satl_Marriage")) {
                        return true;
                    }
                }
                return false;
            }
            case 4289: {
                (int)array[0];
                return (int)array[1] >= 0;
            }
            case 4294: {
                final int intValue13 = (int)array[0];
                (int)array[1];
                return intValue13 != -1;
            }
            case 4295: {
                return (int)array[0] != -1;
            }
            case 4304: {
                final int intValue14 = (int)array[0];
                (int)array[1];
                return intValue14 != -1;
            }
            case 4305: {
                return (int)array[0] != -1;
            }
            case 4314: {
                final int intValue15 = (int)array[0];
                (int)array[1];
                return intValue15 != -1;
            }
            case 4315: {
                return (int)array[0] != -1;
            }
            case 4327: {
                final int intValue16 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                return intValue16 == ((Grace)behavingEntity).me;
            }
            case 4329: {
                final int intValue17 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                return intValue17 != ((Grace)behavingEntity).me;
            }
            case 4331: {
                final int intValue18 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                return intValue18 == ((Grace)behavingEntity).me;
            }
            case 4333: {
                final int intValue19 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                return intValue19 != ((Grace)behavingEntity).me;
            }
            case 4336: {
                return true;
            }
            case 4338: {
                final String s = (String)array[0];
                final ListIterator listIterator107 = WorkingMemory.lookupWME("TripMemory", "SignalWME").listIterator();
                while (listIterator107.hasNext()) {
                    final SignalWME signalWME;
                    if ((signalWME = listIterator107.next()).getName().equals(s)) {
                        hashtable.put("signalWME", new ObjectWrapper(signalWME));
                        return true;
                    }
                }
                return false;
            }
            case 4344: {
                final ListIterator<GoalStepWME> listIterator108 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "BodyResources_CleanupRoot()").listIterator();
                while (listIterator108.hasNext()) {
                    if (listIterator108.next().getSignature().equals("BodyResources_CleanupRoot()")) {
                        return true;
                    }
                }
                return false;
            }
            case 4347: {
                final int intValue20 = (int)array[0];
                final ListIterator listIterator109 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator109.hasNext()) {
                    final BodyResourceWME bodyResourceWME = listIterator109.next();
                    if (bodyResourceWME.getResourceID() == intValue20 && bodyResourceWME.getOwner() == null) {
                        return true;
                    }
                }
                return false;
            }
            case 4349: {
                final int intValue21 = (int)array[0];
                final ListIterator listIterator110 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator110.hasNext()) {
                    final BodyResourceWME bodyResourceWME3;
                    final BodyResourceWME bodyResourceWME2 = bodyResourceWME3 = listIterator110.next();
                    final BehaviorWME owner;
                    if (bodyResourceWME2.getResourceID() == intValue21 && BehavingEntity.constantTrue(owner = bodyResourceWME2.getOwner())) {
                        hashtable.put("owner", new ObjectWrapper(owner));
                        hashtable.put("resourceWME", new ObjectWrapper(bodyResourceWME3));
                        return true;
                    }
                }
                return false;
            }
            case 4350: {
                final int intValue22 = (int)array[0];
                final ListIterator listIterator111 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator111.hasNext()) {
                    final BodyResourceWME bodyResourceWME4 = listIterator111.next();
                    final BehaviorWME owner2;
                    if (bodyResourceWME4.getResourceID() == intValue22 && BehavingEntity.constantTrue(owner2 = bodyResourceWME4.getOwner())) {
                        hashtable.put("owner", new ObjectWrapper(owner2));
                        return true;
                    }
                }
                return false;
            }
            case 4351: {
                final String s2 = (String)array[0];
                final BehaviorWME behaviorWME = (BehaviorWME)array[1];
                return behaviorWME.isValid() && behaviorWME.getBehaviorType() == 0;
            }
            case 4352: {
                final String s3 = (String)array[0];
                final BehaviorWME behaviorWME2 = (BehaviorWME)array[1];
                return behaviorWME2.isValid() && behaviorWME2.getBehaviorType() == 1;
            }
            case 4353: {
                final String s4 = (String)array[0];
                final BehaviorWME behaviorWME3 = (BehaviorWME)array[1];
                return behaviorWME3.isValid() && behaviorWME3.getBehaviorType() == 2;
            }
            case 4354: {
                final int intValue23 = (int)array[0];
                (int)array[1];
                final BehaviorWME behaviorWME4 = (BehaviorWME)array[2];
                final ListIterator listIterator112 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator112.hasNext()) {
                    final BodyResourceWME bodyResourceWME6;
                    final BodyResourceWME bodyResourceWME5 = bodyResourceWME6 = listIterator112.next();
                    if (bodyResourceWME5.getResourceID() == intValue23 && bodyResourceWME5.getOwner() == behaviorWME4) {
                        hashtable.put("bodyResourceWME", new ObjectWrapper(bodyResourceWME6));
                        return true;
                    }
                }
                return false;
            }
            case 4355: {
                final int intValue24 = (int)array[0];
                final ListIterator listIterator113 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator113.hasNext()) {
                    final BodyResourceWME bodyResourceWME8;
                    final BodyResourceWME bodyResourceWME7 = bodyResourceWME8 = listIterator113.next();
                    if (bodyResourceWME7.getResourceID() == intValue24 && bodyResourceWME7.getOwner() != null) {
                        hashtable.put("bodyResourceWME", new ObjectWrapper(bodyResourceWME8));
                        return true;
                    }
                }
                return false;
            }
            case 4356: {
                final int intValue25 = (int)array[0];
                final ListIterator listIterator114 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator114.hasNext()) {
                    final BodyResourceWME bodyResourceWME10;
                    final BodyResourceWME bodyResourceWME9 = bodyResourceWME10 = listIterator114.next();
                    if (bodyResourceWME9.getResourceID() == intValue25 && bodyResourceWME9.getOwner() != null) {
                        hashtable.put("bodyResourceWME", new ObjectWrapper(bodyResourceWME10));
                        return true;
                    }
                }
                return false;
            }
            case 4357: {
                final int intValue26 = (int)array[0];
                final ListIterator listIterator115 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator115.hasNext()) {
                    final BodyResourceWME bodyResourceWME11 = listIterator115.next();
                    if (bodyResourceWME11.getResourceID() == intValue26 && bodyResourceWME11.getOwner() == null) {
                        return true;
                    }
                }
                return false;
            }
            case 4358: {
                final int intValue27 = (int)array[0];
                final ListIterator listIterator116 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator116.hasNext()) {
                    if (listIterator116.next().getResourceID() == intValue27) {
                        return false;
                    }
                }
                return true;
            }
            case 4359: {
                final boolean booleanValue = (boolean)array[0];
                (int)array[1];
                return booleanValue;
            }
            case 4360: {
                final boolean booleanValue2 = (boolean)array[0];
                (int)array[1];
                return !booleanValue2;
            }
            case 4364: {
                final int intValue28 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                final BehaviorWME behaviorWME5 = (BehaviorWME)array[4];
                final ListIterator listIterator117 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator117.hasNext()) {
                    final BodyResourceWME bodyResourceWME13;
                    final BodyResourceWME bodyResourceWME12 = bodyResourceWME13 = listIterator117.next();
                    if (bodyResourceWME12.getResourceID() == intValue28 && bodyResourceWME12.getOwner() == behaviorWME5) {
                        hashtable.put("resourceWME", new ObjectWrapper(bodyResourceWME13));
                        return true;
                    }
                }
                return false;
            }
            case 4365: {
                final int intValue29 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                final BehaviorWME behaviorWME6 = (BehaviorWME)array[4];
                final ListIterator listIterator118 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator118.hasNext()) {
                    final BodyResourceWME bodyResourceWME15;
                    final BodyResourceWME bodyResourceWME14 = bodyResourceWME15 = listIterator118.next();
                    final BehaviorWME owner3;
                    if (bodyResourceWME14.getResourceID() == intValue29 && BehavingEntity.constantTrue(owner3 = bodyResourceWME14.getOwner())) {
                        hashtable.put("owner", new ObjectWrapper(owner3));
                        hashtable.put("resourceWME", new ObjectWrapper(bodyResourceWME15));
                        return true;
                    }
                }
                return false;
            }
            case 4366: {
                final int intValue30 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                final BehaviorWME behaviorWME7 = (BehaviorWME)array[4];
                final ListIterator listIterator119 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator119.hasNext()) {
                    final BodyResourceWME bodyResourceWME17;
                    final BodyResourceWME bodyResourceWME16 = bodyResourceWME17 = listIterator119.next();
                    if (bodyResourceWME16.getResourceID() == intValue30 && bodyResourceWME16.getOwner() == null) {
                        hashtable.put("resourceWME", new ObjectWrapper(bodyResourceWME17));
                        return true;
                    }
                }
                return false;
            }
            case 4367: {
                final int intValue31 = (int)array[0];
                final int intValue32 = (int)array[1];
                (int)array[2];
                (int)array[3];
                final BehaviorWME behaviorWME8 = (BehaviorWME)array[4];
                final ListIterator listIterator120 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator120.hasNext()) {
                    final BodyResourceWME bodyResourceWME19;
                    final BodyResourceWME bodyResourceWME18 = bodyResourceWME19 = listIterator120.next();
                    final int resourcePriority;
                    final BehaviorWME owner4;
                    if (bodyResourceWME18.getResourceID() == intValue31 && BehavingEntity.constantTrue(resourcePriority = bodyResourceWME18.getResourcePriority()) && BehavingEntity.constantTrue(owner4 = bodyResourceWME18.getOwner()) && (intValue32 == Integer.MAX_VALUE || resourcePriority <= intValue32)) {
                        hashtable.put("currentPriority", new Integer(resourcePriority));
                        hashtable.put("owner", new ObjectWrapper(owner4));
                        hashtable.put("resourceWME", new ObjectWrapper(bodyResourceWME19));
                        return true;
                    }
                }
                return false;
            }
            case 4368: {
                final boolean booleanValue3 = (boolean)array[0];
                (int)array[1];
                return !booleanValue3;
            }
            case 4369: {
                final int intValue33 = (int)array[0];
                (int)array[1];
                (int)array[2];
                final int intValue34 = (int)array[3];
                final BehaviorWME behaviorWME9 = (BehaviorWME)array[4];
                final ListIterator listIterator121 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator121.hasNext()) {
                    final BodyResourceWME bodyResourceWME20 = listIterator121.next();
                    final BehaviorWME owner5;
                    if (bodyResourceWME20.getResourceID() == intValue33 && BehavingEntity.constantTrue(owner5 = bodyResourceWME20.getOwner()) && intValue34 == 0) {
                        hashtable.put("owner", new ObjectWrapper(owner5));
                        return true;
                    }
                }
                return false;
            }
            case 4370: {
                final int intValue35 = (int)array[0];
                (int)array[1];
                (int)array[2];
                final int intValue36 = (int)array[3];
                final BehaviorWME behaviorWME10 = (BehaviorWME)array[4];
                final ListIterator listIterator122 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator122.hasNext()) {
                    final BodyResourceWME bodyResourceWME22;
                    final BodyResourceWME bodyResourceWME21 = bodyResourceWME22 = listIterator122.next();
                    final BehaviorWME owner6;
                    if (bodyResourceWME21.getResourceID() == intValue35 && BehavingEntity.constantTrue(owner6 = bodyResourceWME21.getOwner()) && intValue36 == 1) {
                        hashtable.put("owner", new ObjectWrapper(owner6));
                        hashtable.put("resourceWME", new ObjectWrapper(bodyResourceWME22));
                        return true;
                    }
                }
                return false;
            }
            case 4371: {
                final int intValue37 = (int)array[0];
                final ListIterator listIterator123 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator123.hasNext()) {
                    final BodyResourceWME bodyResourceWME23;
                    if ((bodyResourceWME23 = listIterator123.next()).getResourceID() == intValue37) {
                        hashtable.put("resourceWME", new ObjectWrapper(bodyResourceWME23));
                        return true;
                    }
                }
                return false;
            }
            case 4374: {
                (int)array[0];
                final int intValue38 = (int)array[1];
                final BehaviorWME behaviorWME11 = (BehaviorWME)array[2];
                return intValue38 > 0;
            }
            case 4376: {
                (int)array[0];
                final int intValue39 = (int)array[1];
                (int)array[2];
                final BehaviorWME behaviorWME12 = (BehaviorWME)array[3];
                return intValue39 != -1;
            }
            case 4377: {
                final int intValue40 = (int)array[0];
                final int intValue41 = (int)array[1];
                (int)array[2];
                final BehaviorWME behaviorWME13 = (BehaviorWME)array[3];
                if (intValue41 == -1) {
                    final ListIterator listIterator124 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                    while (listIterator124.hasNext()) {
                        final BodyResourceWME bodyResourceWME24 = listIterator124.next();
                        if (bodyResourceWME24.getResourceID() == intValue40 && bodyResourceWME24.getResourcePriority() == -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4378: {
                final int intValue42 = (int)array[0];
                final int intValue43 = (int)array[1];
                (int)array[2];
                final BehaviorWME behaviorWME14 = (BehaviorWME)array[3];
                if (intValue43 == -1) {
                    final ListIterator listIterator125 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                    while (listIterator125.hasNext()) {
                        final BodyResourceWME bodyResourceWME25 = listIterator125.next();
                        if (bodyResourceWME25.getResourceID() == intValue42 && bodyResourceWME25.getResourcePriority() != -1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4381: {
                final int intValue44 = (int)array[0];
                (int)array[1];
                final ListIterator listIterator126 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator126.hasNext()) {
                    final BodyResourceWME bodyResourceWME26 = listIterator126.next();
                    final int resourcePriority2;
                    if (bodyResourceWME26.getResourceID() == intValue44 && BehavingEntity.constantTrue(resourcePriority2 = bodyResourceWME26.getResourcePriority())) {
                        hashtable.put("resourcePriority", new Integer(resourcePriority2));
                        return true;
                    }
                }
                return false;
            }
            case 4383: {
                final ListIterator listIterator127 = WorkingMemory.lookupWME("PlayerMemory", "PlayerRecentlyTypedTextWME").listIterator();
                while (listIterator127.hasNext()) {
                    final PlayerRecentlyTypedTextWME playerRecentlyTypedTextWME = listIterator127.next();
                    final long graceIgnoreTillTimestamp;
                    final long tripIgnoreTillTimestamp;
                    if (BehavingEntity.constantTrue(graceIgnoreTillTimestamp = playerRecentlyTypedTextWME.getGraceIgnoreTillTimestamp()) && BehavingEntity.constantTrue(tripIgnoreTillTimestamp = playerRecentlyTypedTextWME.getTripIgnoreTillTimestamp()) && ((((Grace)behavingEntity).me == ((Grace)behavingEntity).trip && System.currentTimeMillis() > tripIgnoreTillTimestamp) || (((Grace)behavingEntity).me == ((Grace)behavingEntity).grace && System.currentTimeMillis() > graceIgnoreTillTimestamp))) {
                        hashtable.put("graceIgnoreTillTimestamp", new Long(graceIgnoreTillTimestamp));
                        hashtable.put("tripIgnoreTillTimestamp", new Long(tripIgnoreTillTimestamp));
                        return true;
                    }
                }
                return false;
            }
            case 4384: {
                (int)array[0];
                (float)array[1];
                final ListIterator listIterator128 = WorkingMemory.lookupWME("PlayerMemory", "PlayerRecentlyTypedTextWME").listIterator();
                if (!listIterator128.hasNext()) {
                    return false;
                }
                hashtable.put("prtWme", new ObjectWrapper(listIterator128.next()));
                return true;
            }
            case 4385: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                final ListIterator listIterator129 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                if (!listIterator129.hasNext()) {
                    return false;
                }
                hashtable.put("moodWME", new ObjectWrapper(listIterator129.next()));
                return true;
            }
            case 4386: {
                (int)array[0];
                (int)array[1];
                final int intValue45 = (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                return intValue45 == 1 || intValue45 == 0;
            }
            case 4387: {
                (int)array[0];
                (int)array[1];
                final int intValue46 = (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                return intValue46 != 1 && intValue46 != 0;
            }
            case 4389: {
                final int intValue47 = (int)array[0];
                final int intValue48 = (int)array[1];
                (int)array[2];
                return intValue47 == 0 && intValue48 == 0;
            }
            case 4390: {
                final int intValue49 = (int)array[0];
                final int intValue50 = (int)array[1];
                final int intValue51 = (int)array[2];
                return intValue49 == 0 && intValue50 == 1 && (intValue51 == 0 || intValue51 == 1);
            }
            case 4391: {
                final int intValue52 = (int)array[0];
                final int intValue53 = (int)array[1];
                final int intValue54 = (int)array[2];
                return intValue52 == 0 && intValue53 == 1 && intValue54 == 2;
            }
            case 4392: {
                final int intValue55 = (int)array[0];
                final int intValue56 = (int)array[1];
                final int intValue57 = (int)array[2];
                return intValue55 == 0 && intValue56 == 1 && intValue57 == 3;
            }
            case 4393: {
                final int intValue58 = (int)array[0];
                final int intValue59 = (int)array[1];
                final int intValue60 = (int)array[2];
                return intValue58 == 0 && intValue59 == 2 && (intValue60 == 0 || intValue60 == 1);
            }
            case 4394: {
                final int intValue61 = (int)array[0];
                final int intValue62 = (int)array[1];
                final int intValue63 = (int)array[2];
                return intValue61 == 0 && intValue62 == 2 && intValue63 == 2;
            }
            case 4395: {
                final int intValue64 = (int)array[0];
                final int intValue65 = (int)array[1];
                final int intValue66 = (int)array[2];
                return intValue64 == 0 && intValue65 == 2 && intValue66 == 3;
            }
            case 4396: {
                final int intValue67 = (int)array[0];
                final int intValue68 = (int)array[1];
                final int intValue69 = (int)array[2];
                return intValue67 == 0 && intValue68 == 3 && (intValue69 == 0 || intValue69 == 1);
            }
            case 4397: {
                final int intValue70 = (int)array[0];
                final int intValue71 = (int)array[1];
                final int intValue72 = (int)array[2];
                return intValue70 == 0 && intValue71 == 3 && intValue72 == 2;
            }
            case 4398: {
                final int intValue73 = (int)array[0];
                final int intValue74 = (int)array[1];
                final int intValue75 = (int)array[2];
                return intValue73 == 0 && intValue74 == 3 && intValue75 == 3;
            }
            case 4399: {
                final int intValue76 = (int)array[0];
                final int intValue77 = (int)array[1];
                final int intValue78 = (int)array[2];
                return intValue76 == 0 && intValue77 == 4 && (intValue78 == 0 || intValue78 == 1);
            }
            case 4400: {
                final int intValue79 = (int)array[0];
                final int intValue80 = (int)array[1];
                final int intValue81 = (int)array[2];
                return intValue79 == 0 && intValue80 == 4 && intValue81 == 2;
            }
            case 4401: {
                final int intValue82 = (int)array[0];
                final int intValue83 = (int)array[1];
                final int intValue84 = (int)array[2];
                return intValue82 == 0 && intValue83 == 4 && intValue84 == 3;
            }
            case 4402: {
                final int intValue85 = (int)array[0];
                final int intValue86 = (int)array[1];
                final int intValue87 = (int)array[2];
                return intValue85 == 0 && intValue86 == 5 && (intValue87 == 0 || intValue87 == 1);
            }
            case 4403: {
                final int intValue88 = (int)array[0];
                final int intValue89 = (int)array[1];
                final int intValue90 = (int)array[2];
                return intValue88 == 0 && intValue89 == 5 && intValue90 == 2;
            }
            case 4404: {
                final int intValue91 = (int)array[0];
                final int intValue92 = (int)array[1];
                final int intValue93 = (int)array[2];
                return intValue91 == 0 && intValue92 == 5 && intValue93 == 3;
            }
            case 4405: {
                final int intValue94 = (int)array[0];
                final int intValue95 = (int)array[1];
                (int)array[2];
                return intValue94 == 1 && intValue95 == 0;
            }
            case 4406: {
                final int intValue96 = (int)array[0];
                final int intValue97 = (int)array[1];
                final int intValue98 = (int)array[2];
                return intValue96 == 1 && intValue97 == 1 && intValue98 == 0;
            }
            case 4407: {
                final int intValue99 = (int)array[0];
                final int intValue100 = (int)array[1];
                final int intValue101 = (int)array[2];
                return intValue99 == 1 && intValue100 == 2 && intValue101 == 0;
            }
            case 4408: {
                final int intValue102 = (int)array[0];
                final int intValue103 = (int)array[1];
                final int intValue104 = (int)array[2];
                return intValue102 == 1 && intValue103 == 3 && intValue104 == 0;
            }
            case 4409: {
                final int intValue105 = (int)array[0];
                final int intValue106 = (int)array[1];
                final int intValue107 = (int)array[2];
                return intValue105 == 1 && intValue106 == 4 && intValue107 == 0;
            }
            case 4410: {
                final int intValue108 = (int)array[0];
                final int intValue109 = (int)array[1];
                final int intValue110 = (int)array[2];
                return intValue108 == 1 && intValue109 == 5 && intValue110 == 0;
            }
            case 4411: {
                final int intValue111 = (int)array[0];
                final int intValue112 = (int)array[1];
                final int intValue113 = (int)array[2];
                return intValue111 == 1 && intValue112 == 1 && intValue113 == 1;
            }
            case 4412: {
                final int intValue114 = (int)array[0];
                final int intValue115 = (int)array[1];
                final int intValue116 = (int)array[2];
                return intValue114 == 1 && intValue115 == 2 && intValue116 == 1;
            }
            case 4413: {
                final int intValue117 = (int)array[0];
                final int intValue118 = (int)array[1];
                final int intValue119 = (int)array[2];
                return intValue117 == 1 && intValue118 == 3 && intValue119 == 1;
            }
            case 4414: {
                final int intValue120 = (int)array[0];
                final int intValue121 = (int)array[1];
                final int intValue122 = (int)array[2];
                return intValue120 == 1 && intValue121 == 4 && intValue122 == 1;
            }
            case 4415: {
                final int intValue123 = (int)array[0];
                final int intValue124 = (int)array[1];
                final int intValue125 = (int)array[2];
                return intValue123 == 1 && intValue124 == 5 && intValue125 == 1;
            }
            case 4416: {
                final int intValue126 = (int)array[0];
                final int intValue127 = (int)array[1];
                final int intValue128 = (int)array[2];
                return intValue126 == 1 && intValue127 == 1 && intValue128 == 2;
            }
            case 4417: {
                final int intValue129 = (int)array[0];
                final int intValue130 = (int)array[1];
                final int intValue131 = (int)array[2];
                return intValue129 == 1 && intValue130 == 2 && intValue131 == 2;
            }
            case 4418: {
                final int intValue132 = (int)array[0];
                final int intValue133 = (int)array[1];
                final int intValue134 = (int)array[2];
                return intValue132 == 1 && intValue133 == 3 && intValue134 == 2;
            }
            case 4419: {
                final int intValue135 = (int)array[0];
                final int intValue136 = (int)array[1];
                final int intValue137 = (int)array[2];
                return intValue135 == 1 && intValue136 == 4 && intValue137 == 2;
            }
            case 4420: {
                final int intValue138 = (int)array[0];
                final int intValue139 = (int)array[1];
                final int intValue140 = (int)array[2];
                return intValue138 == 1 && intValue139 == 5 && intValue140 == 2;
            }
            case 4421: {
                final int intValue141 = (int)array[0];
                final int intValue142 = (int)array[1];
                final int intValue143 = (int)array[2];
                return intValue141 == 1 && intValue142 == 1 && intValue143 == 3;
            }
            case 4422: {
                final int intValue144 = (int)array[0];
                final int intValue145 = (int)array[1];
                final int intValue146 = (int)array[2];
                return intValue144 == 1 && intValue145 == 2 && intValue146 == 3;
            }
            case 4423: {
                final int intValue147 = (int)array[0];
                final int intValue148 = (int)array[1];
                final int intValue149 = (int)array[2];
                return intValue147 == 1 && intValue148 == 3 && intValue149 == 3;
            }
            case 4424: {
                final int intValue150 = (int)array[0];
                final int intValue151 = (int)array[1];
                final int intValue152 = (int)array[2];
                return intValue150 == 1 && intValue151 == 4 && intValue152 == 3;
            }
            case 4425: {
                final int intValue153 = (int)array[0];
                final int intValue154 = (int)array[1];
                final int intValue155 = (int)array[2];
                return intValue153 == 1 && intValue154 == 5 && intValue155 == 3;
            }
            case 4436: {
                final int intValue156 = (int)array[0];
                (float)array[1];
                return intValue156 == 0;
            }
            case 4437: {
                final int intValue157 = (int)array[0];
                (float)array[1];
                return intValue157 == 1;
            }
            case 4438: {
                final int intValue158 = (int)array[0];
                (float)array[1];
                return intValue158 == 2;
            }
            case 4439: {
                final int intValue159 = (int)array[0];
                (float)array[1];
                return intValue159 == 3;
            }
            case 4440: {
                return (int)array[0] >= 0;
            }
            case 4482: {
                final int intValue160 = (int)array[0];
                (float)array[1];
                return intValue160 != -1;
            }
            case 4493: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (float)array[4];
                (int)array[5];
                (float)array[6];
                (int)array[7];
                (int)array[8];
                final ListIterator listIterator130 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                if (!listIterator130.hasNext()) {
                    return false;
                }
                hashtable.put("moodWME", new ObjectWrapper(listIterator130.next()));
                return true;
            }
            case 4494: {
                (int)array[0];
                final int intValue161 = (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                return intValue161 == 1 || intValue161 == 0;
            }
            case 4495: {
                (int)array[0];
                final int intValue162 = (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                return intValue162 != 1 && intValue162 != 0;
            }
            case 4497: {
                (float)array[0];
                (float)array[1];
                final ListIterator listIterator131 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator131.hasNext()) {
                    final int affinity10;
                    if (BehavingEntity.constantTrue(affinity10 = listIterator131.next().getAffinity())) {
                        final ListIterator listIterator132 = WorkingMemory.lookupWME("StoryMemory", "TensionStoryValueWME").listIterator();
                        while (listIterator132.hasNext()) {
                            final float value;
                            if (BehavingEntity.constantTrue(value = listIterator132.next().getValue())) {
                                final ListIterator listIterator133 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                                if (!listIterator133.hasNext()) {
                                    continue;
                                }
                                hashtable.put("moodWME", new ObjectWrapper(listIterator133.next()));
                                hashtable.put("affinity", new Integer(affinity10));
                                hashtable.put("tension", new Float(value));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4498: {
                final ListIterator listIterator134 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator134.hasNext()) {
                    final MoodWME moodWME = listIterator134.next();
                    final ListIterator listIterator135 = BehavingEntity.getBehavingEntity().lookupWME("MoodTempWME").listIterator();
                    if (!listIterator135.hasNext()) {
                        continue;
                    }
                    final MoodTempWME moodTempWME = listIterator135.next();
                    hashtable.put("moodWME", new ObjectWrapper(moodWME));
                    hashtable.put("moodTempWME", new ObjectWrapper(moodTempWME));
                    return true;
                }
                return false;
            }
            case 4499: {
                final ListIterator listIterator136 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator136.hasNext()) {
                    if (listIterator136.next().getCharacterID() == ((Grace)behavingEntity).me) {
                        final ListIterator listIterator137 = BehavingEntity.getBehavingEntity().lookupWME("MoodTempWME").listIterator();
                        if (!listIterator137.hasNext()) {
                            continue;
                        }
                        hashtable.put("moodTempWME", new ObjectWrapper(listIterator137.next()));
                        return true;
                    }
                }
                return false;
            }
            case 4500: {
                final ListIterator listIterator138 = BehavingEntity.getBehavingEntity().lookupWME("MoodTempWME").listIterator();
                if (!listIterator138.hasNext()) {
                    return false;
                }
                hashtable.put("moodTempWME", new ObjectWrapper(listIterator138.next()));
                return true;
            }
            case 4502: {
                (boolean)array[0];
                final ListIterator listIterator139 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator139.hasNext()) {
                    final MoodWME moodWME2 = listIterator139.next();
                    final int type5;
                    final int strength;
                    final float burstDecay;
                    if (BehavingEntity.constantTrue(type5 = moodWME2.getType()) && BehavingEntity.constantTrue(strength = moodWME2.getStrength()) && BehavingEntity.constantTrue(burstDecay = moodWME2.getBurstDecay())) {
                        hashtable.put("strength", new Integer(strength));
                        hashtable.put("type", new Integer(type5));
                        hashtable.put("burstDecay", new Float(burstDecay));
                        return true;
                    }
                }
                return false;
            }
            case 4503: {
                final ListIterator listIterator140 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator140.hasNext()) {
                    final MoodWME moodWME4;
                    final MoodWME moodWME3 = moodWME4 = listIterator140.next();
                    final long decayAtMillis;
                    if (moodWME3.getDecay() > 0.0f && BehavingEntity.constantTrue(decayAtMillis = moodWME3.getDecayAtMillis())) {
                        hashtable.put("moodWME", new ObjectWrapper(moodWME4));
                        hashtable.put("decayAtMillis", new Long(decayAtMillis));
                        return true;
                    }
                }
                return false;
            }
            case 4504: {
                final ListIterator listIterator141 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator141.hasNext()) {
                    final MoodWME moodWME6;
                    final MoodWME moodWME5 = moodWME6 = listIterator141.next();
                    final long burstDecayAtMillis;
                    if (moodWME5.getBurstDecay() > 0.0f && BehavingEntity.constantTrue(burstDecayAtMillis = moodWME5.getBurstDecayAtMillis())) {
                        hashtable.put("moodWME", new ObjectWrapper(moodWME6));
                        hashtable.put("burstDecayAtMillis", new Long(burstDecayAtMillis));
                        return true;
                    }
                }
                return false;
            }
            case 4507: {
                (int)array[0];
                (int)array[1];
                return !(boolean)array[2];
            }
            case 4509: {
                (int)array[0];
                (int)array[1];
                return !(boolean)array[2];
            }
            case 4511: {
                (int)array[0];
                (int)array[1];
                return !(boolean)array[2];
            }
            case 4513: {
                final BehaviorWME behaviorWME15 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator142 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator142.hasNext()) {
                    if (listIterator142.next().getType() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4514: {
                (boolean)array[0];
                final ListIterator listIterator143 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator143.hasNext()) {
                    if (listIterator143.next().getType() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4515: {
                final BehaviorWME behaviorWME16 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator144 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator144.hasNext()) {
                    final MoodWME moodWME7 = listIterator144.next();
                    if (moodWME7.getType() == 1 && moodWME7.getStrength() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4516: {
                (boolean)array[0];
                final ListIterator listIterator145 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator145.hasNext()) {
                    final MoodWME moodWME8 = listIterator145.next();
                    if (moodWME8.getType() == 1 && moodWME8.getStrength() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4517: {
                final BehaviorWME behaviorWME17 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator146 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator146.hasNext()) {
                    final MoodWME moodWME9 = listIterator146.next();
                    if (moodWME9.getType() == 1 && moodWME9.getStrength() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 4518: {
                (boolean)array[0];
                final ListIterator listIterator147 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator147.hasNext()) {
                    final MoodWME moodWME10 = listIterator147.next();
                    if (moodWME10.getType() == 1 && moodWME10.getStrength() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 4519: {
                final BehaviorWME behaviorWME18 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator148 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator148.hasNext()) {
                    final MoodWME moodWME11 = listIterator148.next();
                    if (moodWME11.getType() == 1 && moodWME11.getStrength() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4520: {
                (boolean)array[0];
                final ListIterator listIterator149 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator149.hasNext()) {
                    final MoodWME moodWME12 = listIterator149.next();
                    if (moodWME12.getType() == 1 && moodWME12.getStrength() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4521: {
                final BehaviorWME behaviorWME19 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator150 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator150.hasNext()) {
                    final MoodWME moodWME13 = listIterator150.next();
                    if (moodWME13.getType() == 1 && moodWME13.getStrength() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 4522: {
                (boolean)array[0];
                final ListIterator listIterator151 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator151.hasNext()) {
                    final MoodWME moodWME14 = listIterator151.next();
                    if (moodWME14.getType() == 1 && moodWME14.getStrength() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 4523: {
                final BehaviorWME behaviorWME20 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator152 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator152.hasNext()) {
                    final MoodWME moodWME15 = listIterator152.next();
                    if (moodWME15.getType() == 2 && moodWME15.getStrength() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4524: {
                (boolean)array[0];
                final ListIterator listIterator153 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator153.hasNext()) {
                    final MoodWME moodWME16 = listIterator153.next();
                    if (moodWME16.getType() == 2 && moodWME16.getStrength() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4525: {
                final BehaviorWME behaviorWME21 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator154 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator154.hasNext()) {
                    final MoodWME moodWME17 = listIterator154.next();
                    if (moodWME17.getType() == 2 && moodWME17.getStrength() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 4526: {
                (boolean)array[0];
                final ListIterator listIterator155 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator155.hasNext()) {
                    final MoodWME moodWME18 = listIterator155.next();
                    if (moodWME18.getType() == 2 && moodWME18.getStrength() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 4527: {
                final BehaviorWME behaviorWME22 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator156 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator156.hasNext()) {
                    final MoodWME moodWME19 = listIterator156.next();
                    if (moodWME19.getType() == 2 && moodWME19.getStrength() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4528: {
                (boolean)array[0];
                final ListIterator listIterator157 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator157.hasNext()) {
                    final MoodWME moodWME20 = listIterator157.next();
                    if (moodWME20.getType() == 2 && moodWME20.getStrength() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4529: {
                final BehaviorWME behaviorWME23 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator158 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator158.hasNext()) {
                    final MoodWME moodWME21 = listIterator158.next();
                    if (moodWME21.getType() == 2 && moodWME21.getStrength() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 4530: {
                (boolean)array[0];
                final ListIterator listIterator159 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator159.hasNext()) {
                    final MoodWME moodWME22 = listIterator159.next();
                    if (moodWME22.getType() == 2 && moodWME22.getStrength() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 4531: {
                final BehaviorWME behaviorWME24 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator160 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator160.hasNext()) {
                    final MoodWME moodWME23 = listIterator160.next();
                    if (moodWME23.getType() == 3 && moodWME23.getStrength() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4532: {
                (boolean)array[0];
                final ListIterator listIterator161 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator161.hasNext()) {
                    final MoodWME moodWME24 = listIterator161.next();
                    if (moodWME24.getType() == 3 && moodWME24.getStrength() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4533: {
                final BehaviorWME behaviorWME25 = (BehaviorWME)array[0];
                final boolean booleanValue4 = (boolean)array[1];
                final ListIterator listIterator162 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator162.hasNext()) {
                    final MoodWME moodWME25 = listIterator162.next();
                    final int alt;
                    if (moodWME25.getType() == 3 && moodWME25.getStrength() == 1 && BehavingEntity.constantTrue(alt = moodWME25.getAlt()) && (alt == 0 || alt == -1 || booleanValue4)) {
                        hashtable.put("alt", new Integer(alt));
                        return true;
                    }
                }
                return false;
            }
            case 4534: {
                final boolean booleanValue5 = (boolean)array[0];
                final ListIterator listIterator163 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator163.hasNext()) {
                    final MoodWME moodWME27;
                    final MoodWME moodWME26 = moodWME27 = listIterator163.next();
                    final int alt2;
                    if (moodWME26.getType() == 3 && moodWME26.getStrength() == 1 && BehavingEntity.constantTrue(alt2 = moodWME26.getAlt()) && (alt2 == 0 || alt2 == -1 || booleanValue5)) {
                        final ListIterator listIterator164 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                        while (listIterator164.hasNext()) {
                            final MoodWME moodWME28 = listIterator164.next();
                            final int charID1;
                            final int charID2;
                            if (BehavingEntity.constantTrue(charID1 = moodWME28.getCharID1()) && BehavingEntity.constantTrue(charID2 = moodWME28.getCharID2())) {
                                final ListIterator listIterator165 = BehavingEntity.getBehavingEntity().lookupWME("MoodTempWME").listIterator();
                                if (!listIterator165.hasNext()) {
                                    continue;
                                }
                                final MoodTempWME moodTempWME2 = listIterator165.next();
                                hashtable.put("charID2", new Integer(charID2));
                                hashtable.put("moodWME", new ObjectWrapper(moodWME27));
                                hashtable.put("charID1", new Integer(charID1));
                                hashtable.put("alt", new Integer(alt2));
                                hashtable.put("tempWME", new ObjectWrapper(moodTempWME2));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4536: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator166 = BehavingEntity.getBehavingEntity().lookupWME("MoodTempWME").listIterator();
                while (listIterator166.hasNext()) {
                    final MoodTempWME moodTempWME3;
                    if ((moodTempWME3 = listIterator166.next()).getVal() > 0) {
                        final ListIterator listIterator167 = BehavingEntity.getBehavingEntity().lookupWME("GazeWME").listIterator();
                        while (listIterator167.hasNext()) {
                            final GazeWME gazeWME5 = listIterator167.next();
                            final int objectID5;
                            final int speed;
                            final int type6;
                            if (BehavingEntity.constantTrue(objectID5 = gazeWME5.getObjectID()) && BehavingEntity.constantTrue(speed = gazeWME5.getSpeed()) && BehavingEntity.constantTrue(type6 = gazeWME5.getType())) {
                                hashtable.put("origGazeSpeed", new Integer(speed));
                                hashtable.put("origGazeObjectID", new Integer(objectID5));
                                hashtable.put("origGazeType", new Integer(type6));
                                hashtable.put("tempWME", new ObjectWrapper(moodTempWME3));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4537: {
                final BehaviorWME behaviorWME26 = (BehaviorWME)array[0];
                final boolean booleanValue6 = (boolean)array[1];
                final ListIterator listIterator168 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator168.hasNext()) {
                    final MoodWME moodWME29 = listIterator168.next();
                    final int alt3;
                    if (moodWME29.getType() == 3 && moodWME29.getStrength() == 1 && BehavingEntity.constantTrue(alt3 = moodWME29.getAlt()) && (alt3 == 1 || alt3 == -1) && !booleanValue6) {
                        hashtable.put("alt", new Integer(alt3));
                        return true;
                    }
                }
                return false;
            }
            case 4538: {
                final boolean booleanValue7 = (boolean)array[0];
                final ListIterator listIterator169 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator169.hasNext()) {
                    final MoodWME moodWME31;
                    final MoodWME moodWME30 = moodWME31 = listIterator169.next();
                    final int alt4;
                    if (moodWME30.getType() == 3 && moodWME30.getStrength() == 1 && BehavingEntity.constantTrue(alt4 = moodWME30.getAlt()) && (alt4 == 1 || alt4 == -1) && !booleanValue7) {
                        hashtable.put("moodWME", new ObjectWrapper(moodWME31));
                        hashtable.put("alt", new Integer(alt4));
                        return true;
                    }
                }
                return false;
            }
            case 4540: {
                final BehaviorWME behaviorWME27 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator170 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator170.hasNext()) {
                    final MoodWME moodWME32 = listIterator170.next();
                    if (moodWME32.getType() == 3 && moodWME32.getStrength() == 1 && moodWME32.getAlt() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4541: {
                (boolean)array[0];
                final ListIterator listIterator171 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator171.hasNext()) {
                    final MoodWME moodWME33 = listIterator171.next();
                    final int alt5;
                    if (moodWME33.getType() == 3 && moodWME33.getStrength() == 1 && BehavingEntity.constantTrue(alt5 = moodWME33.getAlt()) && alt5 == 2) {
                        hashtable.put("alt", new Integer(alt5));
                        return true;
                    }
                }
                return false;
            }
            case 4542: {
                final BehaviorWME behaviorWME28 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator172 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator172.hasNext()) {
                    final MoodWME moodWME34 = listIterator172.next();
                    if (moodWME34.getType() == 3 && moodWME34.getStrength() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4543: {
                (boolean)array[0];
                final ListIterator listIterator173 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator173.hasNext()) {
                    final MoodWME moodWME35 = listIterator173.next();
                    if (moodWME35.getType() == 3 && moodWME35.getStrength() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4544: {
                final BehaviorWME behaviorWME29 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator174 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator174.hasNext()) {
                    final MoodWME moodWME36 = listIterator174.next();
                    if (moodWME36.getType() == 3 && moodWME36.getStrength() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 4545: {
                (boolean)array[0];
                final ListIterator listIterator175 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator175.hasNext()) {
                    final MoodWME moodWME37 = listIterator175.next();
                    if (moodWME37.getType() == 3 && moodWME37.getStrength() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 4546: {
                final BehaviorWME behaviorWME30 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator176 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator176.hasNext()) {
                    final MoodWME moodWME38 = listIterator176.next();
                    if (moodWME38.getType() == 4 && moodWME38.getStrength() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4547: {
                (boolean)array[0];
                final ListIterator listIterator177 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator177.hasNext()) {
                    final MoodWME moodWME39 = listIterator177.next();
                    if (moodWME39.getType() == 4 && moodWME39.getStrength() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4548: {
                final BehaviorWME behaviorWME31 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator178 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator178.hasNext()) {
                    final MoodWME moodWME40 = listIterator178.next();
                    if (moodWME40.getType() == 4 && moodWME40.getStrength() == 1) {
                        final ListIterator listIterator179 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                        while (listIterator179.hasNext()) {
                            if (listIterator179.next().getBurstDecay() > 0.0f) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4549: {
                final BehaviorWME behaviorWME32 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator180 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator180.hasNext()) {
                    final MoodWME moodWME41 = listIterator180.next();
                    if (moodWME41.getType() == 4 && moodWME41.getStrength() == 1) {
                        final ListIterator listIterator181 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                        while (listIterator181.hasNext()) {
                            final MoodWME moodWME42;
                            if ((moodWME42 = listIterator181.next()).getBurstDecay() > 0.0f) {
                                hashtable.put("moodWME", new ObjectWrapper(moodWME42));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4550: {
                (boolean)array[0];
                final ListIterator listIterator182 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator182.hasNext()) {
                    final MoodWME moodWME44;
                    final MoodWME moodWME43 = moodWME44 = listIterator182.next();
                    if (moodWME43.getType() == 4 && moodWME43.getStrength() == 1) {
                        final ListIterator listIterator183 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                        while (listIterator183.hasNext()) {
                            if (listIterator183.next().getBurstDecay() > 0.0f) {
                                hashtable.put("moodWME", new ObjectWrapper(moodWME44));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4551: {
                (boolean)array[0];
                final ListIterator listIterator184 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator184.hasNext()) {
                    final float stagingConverseDist;
                    if (BehavingEntity.constantTrue(stagingConverseDist = listIterator184.next().getStagingConverseDist())) {
                        hashtable.put("stagingConverseDist", new Float(stagingConverseDist));
                        return true;
                    }
                }
                return false;
            }
            case 4552: {
                final BehaviorWME behaviorWME33 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator185 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator185.hasNext()) {
                    final MoodWME moodWME45 = listIterator185.next();
                    if (moodWME45.getType() == 4 && moodWME45.getStrength() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 4553: {
                (boolean)array[0];
                final ListIterator listIterator186 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator186.hasNext()) {
                    final MoodWME moodWME47;
                    final MoodWME moodWME46 = moodWME47 = listIterator186.next();
                    if (moodWME46.getType() == 4 && moodWME46.getStrength() == 1) {
                        hashtable.put("moodWME", new ObjectWrapper(moodWME47));
                        return true;
                    }
                }
                return false;
            }
            case 4554: {
                (boolean)array[0];
                final ListIterator listIterator187 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator187.hasNext()) {
                    final MoodWME moodWME48 = listIterator187.next();
                    final int alt6;
                    if (moodWME48.getType() == 4 && moodWME48.getStrength() == 1 && BehavingEntity.constantTrue(alt6 = moodWME48.getAlt()) && (alt6 == -1 || alt6 == 0)) {
                        hashtable.put("alt", new Integer(alt6));
                        return true;
                    }
                }
                return false;
            }
            case 4555: {
                (boolean)array[0];
                final ListIterator listIterator188 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator188.hasNext()) {
                    final MoodWME moodWME49 = listIterator188.next();
                    if (moodWME49.getType() == 4 && moodWME49.getStrength() == 1 && moodWME49.getAlt() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 4556: {
                final BehaviorWME behaviorWME34 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator189 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator189.hasNext()) {
                    final MoodWME moodWME50 = listIterator189.next();
                    if (moodWME50.getType() == 4 && moodWME50.getStrength() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4557: {
                (boolean)array[0];
                final ListIterator listIterator190 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator190.hasNext()) {
                    final MoodWME moodWME51 = listIterator190.next();
                    if (moodWME51.getType() == 4 && moodWME51.getStrength() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4558: {
                final BehaviorWME behaviorWME35 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator191 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator191.hasNext()) {
                    final MoodWME moodWME52 = listIterator191.next();
                    if (moodWME52.getType() == 4 && moodWME52.getStrength() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 4559: {
                (boolean)array[0];
                final ListIterator listIterator192 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator192.hasNext()) {
                    final MoodWME moodWME53 = listIterator192.next();
                    if (moodWME53.getType() == 4 && moodWME53.getStrength() == 3) {
                        return true;
                    }
                }
                return false;
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
    
    public static boolean precondition5(final int n, final Object[] array, final Hashtable hashtable, final BehavingEntity behavingEntity) {
        switch (n) {
            case 4560: {
                final BehaviorWME behaviorWME = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator.hasNext()) {
                    final MoodWME moodWME = listIterator.next();
                    if (moodWME.getType() == 5 && moodWME.getStrength() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4561: {
                (boolean)array[0];
                final ListIterator listIterator2 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator2.hasNext()) {
                    final MoodWME moodWME2 = listIterator2.next();
                    if (moodWME2.getType() == 5 && moodWME2.getStrength() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 4562: {
                final BehaviorWME behaviorWME2 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator3 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator3.hasNext()) {
                    final MoodWME moodWME3 = listIterator3.next();
                    if (moodWME3.getType() == 5 && moodWME3.getStrength() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 4563: {
                (boolean)array[0];
                final ListIterator listIterator4 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator4.hasNext()) {
                    final MoodWME moodWME4 = listIterator4.next();
                    if (moodWME4.getType() == 5 && moodWME4.getStrength() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 4566: {
                final BehaviorWME behaviorWME3 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator5 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator5.hasNext()) {
                    final MoodWME moodWME5 = listIterator5.next();
                    if (moodWME5.getType() == 5 && moodWME5.getStrength() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4567: {
                (boolean)array[0];
                final ListIterator listIterator6 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator6.hasNext()) {
                    final MoodWME moodWME6 = listIterator6.next();
                    if (moodWME6.getType() == 5 && moodWME6.getStrength() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 4568: {
                final BehaviorWME behaviorWME4 = (BehaviorWME)array[0];
                (boolean)array[1];
                final ListIterator listIterator7 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator7.hasNext()) {
                    final MoodWME moodWME7 = listIterator7.next();
                    if (moodWME7.getType() == 5 && moodWME7.getStrength() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 4569: {
                (boolean)array[0];
                final ListIterator listIterator8 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator8.hasNext()) {
                    final MoodWME moodWME8 = listIterator8.next();
                    if (moodWME8.getType() == 5 && moodWME8.getStrength() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 4570: {
                (boolean)array[0];
                final ListIterator listIterator9 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                if (!listIterator9.hasNext()) {
                    return false;
                }
                hashtable.put("statusWME", new ObjectWrapper(listIterator9.next()));
                return true;
            }
            case 4571: {
                (boolean)array[0];
                final ListIterator listIterator10 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                if (!listIterator10.hasNext()) {
                    return false;
                }
                hashtable.put("statusWME", new ObjectWrapper(listIterator10.next()));
                return true;
            }
            case 4572: {
                return (boolean)array[0];
            }
            case 4573: {
                final ListIterator listIterator11 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                if (!listIterator11.hasNext()) {
                    return false;
                }
                hashtable.put("statusWME", new ObjectWrapper(listIterator11.next()));
                return true;
            }
            case 4574: {
                final ListIterator<GoalStepWME> listIterator12 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator12.hasNext()) {
                    final GoalStepWME goalStepWME = listIterator12.next();
                    final String signature;
                    if (BehavingEntity.constantTrue(signature = goalStepWME.getSignature()) && goalStepWME.getProperty("isBeatGoal") != null && goalStepWME.getIsExecuting()) {
                        final ListIterator listIterator13 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                        while (listIterator13.hasNext()) {
                            final BeatGoalStatusWME beatGoalStatusWME;
                            if ((beatGoalStatusWME = listIterator13.next()).getBgSig().equals(signature)) {
                                hashtable.put("bgSig", new ObjectWrapper(signature));
                                hashtable.put("statusWME", new ObjectWrapper(beatGoalStatusWME));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4576: {
                final ListIterator<GoalStepWME> listIterator14 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator14.hasNext()) {
                    final GoalStepWME goalStepWME2 = listIterator14.next();
                    final String signature2;
                    if (BehavingEntity.constantTrue(signature2 = goalStepWME2.getSignature()) && goalStepWME2.getProperty("isBeatGoal") != null && goalStepWME2.getIsExecuting()) {
                        final ListIterator listIterator15 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                        while (listIterator15.hasNext()) {
                            final BeatGoalStatusWME beatGoalStatusWME2;
                            if ((beatGoalStatusWME2 = listIterator15.next()).getBgSig().equals(signature2)) {
                                hashtable.put("bgSig", new ObjectWrapper(signature2));
                                hashtable.put("statusWME", new ObjectWrapper(beatGoalStatusWME2));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4578: {
                final boolean booleanValue = (boolean)array[0];
                return ((Grace)behavingEntity).gDeflectReestablish && booleanValue;
            }
            case 4580: {
                (boolean)array[0];
                final ListIterator<GoalStepWME> listIterator16 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator16.hasNext()) {
                    final GoalStepWME goalStepWME3 = listIterator16.next();
                    final String signature3;
                    if (BehavingEntity.constantTrue(signature3 = goalStepWME3.getSignature()) && goalStepWME3.getProperty("isBeatGoal") != null && goalStepWME3.getIsExecuting()) {
                        final ListIterator listIterator17 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                        while (listIterator17.hasNext()) {
                            final BeatGoalStatusWME beatGoalStatusWME3;
                            if ((beatGoalStatusWME3 = listIterator17.next()).getBgSig().equals(signature3)) {
                                hashtable.put("bgSig", new ObjectWrapper(signature3));
                                hashtable.put("statusWME", new ObjectWrapper(beatGoalStatusWME3));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4581: {
                (boolean)array[0];
                final ListIterator<GoalStepWME> listIterator18 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator18.hasNext()) {
                    final GoalStepWME goalStepWME4 = listIterator18.next();
                    final String signature4;
                    if (BehavingEntity.constantTrue(signature4 = goalStepWME4.getSignature()) && goalStepWME4.getProperty("isBeatGoal") != null && goalStepWME4.getIsExecuting()) {
                        hashtable.put("bgSig", new ObjectWrapper(signature4));
                        return true;
                    }
                }
                return false;
            }
            case 4582: {
                (boolean)array[0];
                final ListIterator listIterator19 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                if (!listIterator19.hasNext()) {
                    return true;
                }
                final BeatGoalStatusWME beatGoalStatusWME4 = listIterator19.next();
                return false;
            }
            case 4585: {
                final String s = (String)array[0];
                (boolean)array[1];
                final ListIterator listIterator20 = WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", s).listIterator();
                while (listIterator20.hasNext()) {
                    final GoalStepWME goalStepWME6;
                    final GoalStepWME goalStepWME5 = goalStepWME6 = listIterator20.next();
                    if (goalStepWME5.getSignature().equals(s) && goalStepWME5.getIsExpanded()) {
                        hashtable.put("beatGoal", new ObjectWrapper(goalStepWME6));
                        return true;
                    }
                }
                return false;
            }
            case 4586: {
                final String s2 = (String)array[0];
                (boolean)array[1];
                final ListIterator listIterator21 = WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", s2).listIterator();
                while (listIterator21.hasNext()) {
                    final GoalStepWME goalStepWME7;
                    if ((goalStepWME7 = listIterator21.next()).getSignature().equals(s2)) {
                        hashtable.put("beatGoal", new ObjectWrapper(goalStepWME7));
                        return true;
                    }
                }
                return false;
            }
            case 4588: {
                (float)array[0];
                final ListIterator listIterator22 = WorkingMemory.lookupWME("PlayerMemory", "PlayerRecentlyTypedTextWME").listIterator();
                while (listIterator22.hasNext()) {
                    if (listIterator22.next().getB()) {
                        return true;
                    }
                }
                return false;
            }
            case 4591: {
                final ListIterator listIterator23 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                if (!listIterator23.hasNext()) {
                    return false;
                }
                hashtable.put("storyStatusWME", new ObjectWrapper(listIterator23.next()));
                return true;
            }
            case 4593: {
                (int)array[0];
                final ListIterator listIterator24 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                if (!listIterator24.hasNext()) {
                    return false;
                }
                hashtable.put("modeWME", new ObjectWrapper(listIterator24.next()));
                return true;
            }
            case 4595: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                (int)array[7];
                (int)array[8];
                (int)array[9];
                (int)array[10];
                (int)array[11];
                (boolean)array[12];
                if (((Grace)behavingEntity).gDeflectReestablish) {
                    final ListIterator listIterator25 = WorkingMemory.lookupWME("StoryMemory", "DeflectModeWME").listIterator();
                    if (listIterator25.hasNext()) {
                        hashtable.put("modeWME", new ObjectWrapper(listIterator25.next()));
                        return true;
                    }
                }
                return false;
            }
            case 4598: {
                final String s3 = (String)array[0];
                final ListIterator<GoalStepWME> listIterator26 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isAmb").listIterator();
                while (listIterator26.hasNext()) {
                    final GoalStepWME goalStepWME8 = listIterator26.next();
                    final String signature5;
                    if (goalStepWME8.getProperty("isAmb") != null && goalStepWME8.getIsExecuting() && BehavingEntity.constantTrue(signature5 = goalStepWME8.getSignature())) {
                        final ListIterator<GoalStepWME> listIterator27 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isAmb").listIterator();
                        while (listIterator27.hasNext()) {
                            final GoalStepWME goalStepWME9 = listIterator27.next();
                            if (goalStepWME9.getProperty("isAmb") != null && goalStepWME9.getIsExecuting() && goalStepWME9.getSignature() != signature5) {
                                return false;
                            }
                        }
                        hashtable.put("sig", new ObjectWrapper(signature5));
                        return true;
                    }
                }
                return false;
            }
            case 4602: {
                final ListIterator<GoalStepWME> listIterator28 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator28.hasNext()) {
                    final GoalStepWME goalStepWME10 = listIterator28.next();
                    final String signature6;
                    if (BehavingEntity.constantTrue(signature6 = goalStepWME10.getSignature()) && goalStepWME10.getProperty("isBeatGoal") != null && goalStepWME10.getIsExecuting()) {
                        final ListIterator listIterator29 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                        while (listIterator29.hasNext()) {
                            final BeatGoalStatusWME beatGoalStatusWME6;
                            final BeatGoalStatusWME beatGoalStatusWME5 = beatGoalStatusWME6 = listIterator29.next();
                            if (beatGoalStatusWME5.getBgSig().equals(signature6) && beatGoalStatusWME5.getBGistPointReached()) {
                                hashtable.put("bgSig", new ObjectWrapper(signature6));
                                hashtable.put("statusWME", new ObjectWrapper(beatGoalStatusWME6));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4604: {
                (boolean)array[0];
                final ListIterator listIterator30 = WorkingMemory.lookupWME("BeatMemory", "DAMiscStatusWME").listIterator();
                if (!listIterator30.hasNext()) {
                    return false;
                }
                hashtable.put("dAMiscStatusWME", new ObjectWrapper(listIterator30.next()));
                return true;
            }
            case 4613: {
                if (array[0]) {
                    final ListIterator<GoalStepWME> listIterator31 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isOneCharacterVisibleYouRefHandler").listIterator();
                    while (listIterator31.hasNext()) {
                        if (listIterator31.next().getProperty("isOneCharacterVisibleYouRefHandler") != null) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            case 4614: {
                if (array[0]) {
                    final ListIterator listIterator32 = WorkingMemory.lookupWME("BeatMemory", "OneCharacterVisibleWME").listIterator();
                    if (listIterator32.hasNext()) {
                        final OneCharacterVisibleWME oneCharacterVisibleWME = listIterator32.next();
                        return false;
                    }
                    final ListIterator<GoalStepWME> listIterator33 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isOneCharacterVisibleYouRefHandler").listIterator();
                    while (listIterator33.hasNext()) {
                        if (listIterator33.next().getProperty("isOneCharacterVisibleYouRefHandler") != null) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4615: {
                if (array[0]) {
                    final ListIterator listIterator34 = WorkingMemory.lookupWME("BeatMemory", "OneCharacterVisibleWME").listIterator();
                    while (listIterator34.hasNext()) {
                        final OneCharacterVisibleWME oneCharacterVisibleWME2 = listIterator34.next();
                        final ListIterator<GoalStepWME> listIterator35 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isOneCharacterVisibleYouRefHandler").listIterator();
                        while (listIterator35.hasNext()) {
                            if (listIterator35.next().getProperty("isOneCharacterVisibleYouRefHandler") != null) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4618: {
                final ListIterator listIterator36 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator36.hasNext()) {
                    if (!listIterator36.next().getCommitPointReached()) {
                        return true;
                    }
                }
                return false;
            }
            case 4626: {
                (boolean)array[0];
                final ListIterator<GoalStepWME> listIterator37 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator37.hasNext()) {
                    final GoalStepWME goalStepWME11 = listIterator37.next();
                    final String signature7;
                    if (BehavingEntity.constantTrue(signature7 = goalStepWME11.getSignature()) && goalStepWME11.getProperty("isBeatGoal") != null && goalStepWME11.getIsExecuting()) {
                        hashtable.put("origSig", new ObjectWrapper(signature7));
                        return true;
                    }
                }
                return false;
            }
            case 4627: {
                (boolean)array[0];
                final String s4 = (String)array[1];
                final ListIterator<GoalStepWME> listIterator38 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator38.hasNext()) {
                    final GoalStepWME goalStepWME12 = listIterator38.next();
                    final String signature8;
                    if (BehavingEntity.constantTrue(signature8 = goalStepWME12.getSignature()) && goalStepWME12.getProperty("isBeatGoal") != null && goalStepWME12.getIsExecuting() && s4.equals(signature8)) {
                        hashtable.put("bgSig", new ObjectWrapper(signature8));
                        return true;
                    }
                }
                return false;
            }
            case 4628: {
                (boolean)array[0];
                final String s5 = (String)array[1];
                final ListIterator<GoalStepWME> listIterator39 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator39.hasNext()) {
                    final GoalStepWME goalStepWME13 = listIterator39.next();
                    final String signature9;
                    if (BehavingEntity.constantTrue(signature9 = goalStepWME13.getSignature()) && goalStepWME13.getProperty("isBeatGoal") != null && goalStepWME13.getIsExecuting()) {
                        hashtable.put("bgSig", new ObjectWrapper(signature9));
                        return true;
                    }
                }
                return false;
            }
            case 4631: {
                (boolean)array[0];
                final ListIterator<GoalStepWME> listIterator40 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator40.hasNext()) {
                    final GoalStepWME goalStepWME14 = listIterator40.next();
                    final String signature10;
                    if (BehavingEntity.constantTrue(signature10 = goalStepWME14.getSignature()) && goalStepWME14.getProperty("isBeatGoal") != null && goalStepWME14.getIsExecuting()) {
                        hashtable.put("origSig", new ObjectWrapper(signature10));
                        return true;
                    }
                }
                return false;
            }
            case 4632: {
                (boolean)array[0];
                final String s6 = (String)array[1];
                final ListIterator<GoalStepWME> listIterator41 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator41.hasNext()) {
                    final GoalStepWME goalStepWME15 = listIterator41.next();
                    final String signature11;
                    if (BehavingEntity.constantTrue(signature11 = goalStepWME15.getSignature()) && goalStepWME15.getProperty("isBeatGoal") != null && goalStepWME15.getIsExecuting() && s6.equals(signature11)) {
                        hashtable.put("bgSig", new ObjectWrapper(signature11));
                        return true;
                    }
                }
                return false;
            }
            case 4633: {
                (boolean)array[0];
                final String s7 = (String)array[1];
                final ListIterator<GoalStepWME> listIterator42 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator42.hasNext()) {
                    final GoalStepWME goalStepWME16 = listIterator42.next();
                    final String signature12;
                    if (BehavingEntity.constantTrue(signature12 = goalStepWME16.getSignature()) && goalStepWME16.getProperty("isBeatGoal") != null && goalStepWME16.getIsExecuting()) {
                        hashtable.put("bgSig", new ObjectWrapper(signature12));
                        return true;
                    }
                }
                return false;
            }
            case 4635: {
                (int)array[0];
                final int intValue = (int)array[1];
                return intValue == ((Grace)behavingEntity).grace || intValue == ((Grace)behavingEntity).trip;
            }
            case 4637: {
                (int)array[0];
                return (int)array[1] == ((Grace)behavingEntity).grace;
            }
            case 4638: {
                (int)array[0];
                return (int)array[1] == ((Grace)behavingEntity).trip;
            }
            case 4641: {
                final int intValue2 = (int)array[0];
                (int)array[1];
                return intValue2 == ((Grace)behavingEntity).grace || intValue2 == ((Grace)behavingEntity).trip;
            }
            case 4645: {
                return (int)array[0] == ((Grace)behavingEntity).grace;
            }
            case 4646: {
                final int intValue3 = (int)array[0];
                (int)array[1];
                return intValue3 == ((Grace)behavingEntity).grace;
            }
            case 4647: {
                return (int)array[0] == ((Grace)behavingEntity).trip;
            }
            case 4648: {
                final int intValue4 = (int)array[0];
                (int)array[1];
                return intValue4 == ((Grace)behavingEntity).trip;
            }
            case 4649: {
                return (int)array[0] == ((Grace)behavingEntity).grace;
            }
            case 4650: {
                return (int)array[0] == ((Grace)behavingEntity).trip;
            }
            case 4653: {
                (int)array[0];
                final int intValue5 = (int)array[1];
                (int)array[2];
                (int)array[3];
                if (intValue5 != -1) {
                    final ListIterator listIterator43 = BehavingEntity.getBehavingEntity().lookupWME("GazeWME").listIterator();
                    if (listIterator43.hasNext()) {
                        hashtable.put("gazeWME", new ObjectWrapper(listIterator43.next()));
                        return true;
                    }
                }
                return false;
            }
            case 4654: {
                final ListIterator listIterator44 = BehavingEntity.getBehavingEntity().lookupWME("GazeWME").listIterator();
                while (listIterator44.hasNext()) {
                    final GazeWME gazeWME = listIterator44.next();
                    final int objectID;
                    final int type;
                    final int speed;
                    if (BehavingEntity.constantTrue(objectID = gazeWME.getObjectID()) && BehavingEntity.constantTrue(type = gazeWME.getType()) && BehavingEntity.constantTrue(speed = gazeWME.getSpeed())) {
                        hashtable.put("spriteIDForGaze", new Integer(objectID));
                        hashtable.put("gazeType", new Integer(type));
                        hashtable.put("gazeSpeed", new Integer(speed));
                        return true;
                    }
                }
                return false;
            }
            case 4655: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                final ListIterator listIterator45 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator45.hasNext()) {
                    final BodyResourceWME bodyResourceWME;
                    if ((bodyResourceWME = listIterator45.next()).getResourceID() == 4) {
                        hashtable.put("gazeTorsoResourceWME", new ObjectWrapper(bodyResourceWME));
                        return true;
                    }
                }
                return false;
            }
            case 4656: {
                (int)array[0];
                final int intValue6 = (int)array[1];
                (int)array[2];
                (int)array[3];
                if (intValue6 == -1) {
                    final ListIterator listIterator46 = BehavingEntity.getBehavingEntity().lookupWME("GazeWME").listIterator();
                    if (listIterator46.hasNext()) {
                        hashtable.put("gazeWME", new ObjectWrapper(listIterator46.next()));
                        return true;
                    }
                }
                return false;
            }
            case 4659: {
                (int)array[0];
                (int)array[1];
                final Point3D point3D = (Point3D)array[2];
                (float)array[3];
                (int)array[4];
                final ListIterator listIterator47 = BehavingEntity.getBehavingEntity().lookupWME("PrevStagingInfoWME").listIterator();
                if (!listIterator47.hasNext()) {
                    return false;
                }
                hashtable.put("prevStagingInfoWME", new ObjectWrapper(listIterator47.next()));
                return true;
            }
            case 4660: {
                final ListIterator listIterator48 = WorkingMemory.lookupWME("StoryMemory", "ConverseStagingWME").listIterator();
                if (!listIterator48.hasNext()) {
                    return false;
                }
                hashtable.put("converseStagingWME", new ObjectWrapper(listIterator48.next()));
                return true;
            }
            case 4661: {
                final ListIterator<GoalStepWME> listIterator49 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isStagingBodyGoal").listIterator();
                while (listIterator49.hasNext()) {
                    final GoalStepWME goalStepWME17;
                    if ((goalStepWME17 = listIterator49.next()).getProperty("isStagingBodyGoal") != null) {
                        hashtable.put("stagingGoal", new ObjectWrapper(goalStepWME17));
                        return true;
                    }
                }
                return false;
            }
            case 4662: {
                final ListIterator<GoalStepWME> listIterator50 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isStagingGoal").listIterator();
                while (listIterator50.hasNext()) {
                    final GoalStepWME goalStepWME18;
                    if ((goalStepWME18 = listIterator50.next()).getProperty("isStagingGoal") != null) {
                        hashtable.put("stagingGoal", new ObjectWrapper(goalStepWME18));
                        return true;
                    }
                }
                return false;
            }
            case 4666: {
                (int)array[0];
                final Point3D point3D2 = (Point3D)array[1];
                (float)array[2];
                final int intValue7 = (int)array[3];
                (int)array[4];
                if (intValue7 != -1) {
                    final ListIterator listIterator51 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                    while (listIterator51.hasNext()) {
                        final ObjectPositionWME objectPositionWME = listIterator51.next();
                        final float x;
                        final float z;
                        if (objectPositionWME.getObjectID() == intValue7 && BehavingEntity.constantTrue(x = objectPositionWME.getX()) && BehavingEntity.constantTrue(z = objectPositionWME.getZ())) {
                            hashtable.put("objZPos", new Float(z));
                            hashtable.put("objXPos", new Float(x));
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4672: {
                (int)array[0];
                final int intValue8 = (int)array[1];
                (int)array[2];
                (float)array[3];
                (int)array[4];
                (float)array[5];
                final ListIterator listIterator52 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator52.hasNext()) {
                    final ObjectPositionWME objectPositionWME3;
                    final ObjectPositionWME objectPositionWME2 = objectPositionWME3 = listIterator52.next();
                    final float x2;
                    final float z2;
                    if (objectPositionWME2.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x2 = objectPositionWME2.getX()) && BehavingEntity.constantTrue(z2 = objectPositionWME2.getZ())) {
                        final ListIterator listIterator53 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator53.hasNext()) {
                            final ObjectRotationWME objectRotationWME2;
                            final ObjectRotationWME objectRotationWME = objectRotationWME2 = listIterator53.next();
                            final float y;
                            if (objectRotationWME.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(y = objectRotationWME.getY())) {
                                final ListIterator listIterator54 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator54.hasNext()) {
                                    final ObjectPositionWME objectPositionWME5;
                                    final ObjectPositionWME objectPositionWME4 = objectPositionWME5 = listIterator54.next();
                                    final float x3;
                                    final float z3;
                                    if (objectPositionWME4.getObjectID() == intValue8 && BehavingEntity.constantTrue(x3 = objectPositionWME4.getX()) && BehavingEntity.constantTrue(z3 = objectPositionWME4.getZ())) {
                                        final ListIterator listIterator55 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                                        while (listIterator55.hasNext()) {
                                            final ObjectRotationWME objectRotationWME4;
                                            final ObjectRotationWME objectRotationWME3 = objectRotationWME4 = listIterator55.next();
                                            final float y2;
                                            if (objectRotationWME3.getObjectID() == intValue8 && BehavingEntity.constantTrue(y2 = objectRotationWME3.getY())) {
                                                final ListIterator listIterator56 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                                while (listIterator56.hasNext()) {
                                                    final ObjectPositionWME objectPositionWME6 = listIterator56.next();
                                                    final float x4;
                                                    final float z4;
                                                    if (objectPositionWME6.getObjectID() == ((Grace)behavingEntity).spouse && BehavingEntity.constantTrue(x4 = objectPositionWME6.getX()) && BehavingEntity.constantTrue(z4 = objectPositionWME6.getZ())) {
                                                        final ListIterator listIterator57 = WorkingMemory.lookupWME("StoryMemory", "ConverseStagingWME").listIterator();
                                                        while (listIterator57.hasNext()) {
                                                            final ConverseStagingWME converseStagingWME = listIterator57.next();
                                                            final ListIterator listIterator58 = WorkingMemory.lookupWME("PlayerMemory", "IsPlayerSettledWME").listIterator();
                                                            while (listIterator58.hasNext()) {
                                                                final IsPlayerSettledWME isPlayerSettledWME = listIterator58.next();
                                                                final ListIterator listIterator59 = BehavingEntity.getBehavingEntity().lookupWME("PrevStagingInfoWME").listIterator();
                                                                while (listIterator59.hasNext()) {
                                                                    final PrevStagingInfoWME prevStagingInfoWME = listIterator59.next();
                                                                    final ListIterator listIterator60 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                                                                    if (!listIterator60.hasNext()) {
                                                                        continue;
                                                                    }
                                                                    final MoodWME moodWME9 = listIterator60.next();
                                                                    hashtable.put("myX", new Float(x2));
                                                                    hashtable.put("myAngle", new Float(y));
                                                                    hashtable.put("stagingObjectRotWME", new ObjectWrapper(objectRotationWME4));
                                                                    hashtable.put("objZ", new Float(z3));
                                                                    hashtable.put("myRotWME", new ObjectWrapper(objectRotationWME2));
                                                                    hashtable.put("stagingObjectPosWME", new ObjectWrapper(objectPositionWME5));
                                                                    hashtable.put("otherCharZ", new Float(z4));
                                                                    hashtable.put("objRot", new Float(y2));
                                                                    hashtable.put("prevStagingInfoWME", new ObjectWrapper(prevStagingInfoWME));
                                                                    hashtable.put("moodWME", new ObjectWrapper(moodWME9));
                                                                    hashtable.put("objX", new Float(x3));
                                                                    hashtable.put("myPosWME", new ObjectWrapper(objectPositionWME3));
                                                                    hashtable.put("myZ", new Float(z2));
                                                                    hashtable.put("converseStagingWME", new ObjectWrapper(converseStagingWME));
                                                                    hashtable.put("otherCharX", new Float(x4));
                                                                    hashtable.put("playerSettledWME", new ObjectWrapper(isPlayerSettledWME));
                                                                    return true;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 4676: {
                (int)array[0];
                final int intValue9 = (int)array[1];
                (float)array[2];
                final ListIterator listIterator61 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator61.hasNext()) {
                    final ObjectPositionWME objectPositionWME7 = listIterator61.next();
                    final float x5;
                    final float z5;
                    if (objectPositionWME7.getObjectID() == intValue9 && BehavingEntity.constantTrue(x5 = objectPositionWME7.getX()) && BehavingEntity.constantTrue(z5 = objectPositionWME7.getZ())) {
                        final ListIterator listIterator62 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator62.hasNext()) {
                            final ObjectPositionWME objectPositionWME8 = listIterator62.next();
                            final float x6;
                            final float z6;
                            if (objectPositionWME8.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x6 = objectPositionWME8.getX()) && BehavingEntity.constantTrue(z6 = objectPositionWME8.getZ())) {
                                final ListIterator listIterator63 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                                while (listIterator63.hasNext()) {
                                    final ObjectRotationWME objectRotationWME5 = listIterator63.next();
                                    final float y3;
                                    if (objectRotationWME5.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(y3 = objectRotationWME5.getY())) {
                                        hashtable.put("myXPos", new Float(x6));
                                        hashtable.put("myYRot", new Float(y3));
                                        hashtable.put("myZPos", new Float(z6));
                                        hashtable.put("objZPos", new Float(z5));
                                        hashtable.put("objXPos", new Float(x5));
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 4677: {
                (int)array[0];
                (float)array[1];
                final ListIterator listIterator64 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator64.hasNext()) {
                    final ObjectPositionWME objectPositionWME9 = listIterator64.next();
                    final float x7;
                    final float z7;
                    if (objectPositionWME9.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x7 = objectPositionWME9.getX()) && BehavingEntity.constantTrue(z7 = objectPositionWME9.getZ())) {
                        final ListIterator listIterator65 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator65.hasNext()) {
                            final ObjectRotationWME objectRotationWME6 = listIterator65.next();
                            final float y4;
                            if (objectRotationWME6.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(y4 = objectRotationWME6.getY())) {
                                hashtable.put("myXPos", new Float(x7));
                                hashtable.put("myYRot", new Float(y4));
                                hashtable.put("myZPos", new Float(z7));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4679: {
                (int)array[0];
                final int intValue10 = (int)array[1];
                final ListIterator listIterator66 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator66.hasNext()) {
                    final ObjectPositionWME objectPositionWME11;
                    final ObjectPositionWME objectPositionWME10 = objectPositionWME11 = listIterator66.next();
                    final float x8;
                    final float z8;
                    if (objectPositionWME10.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x8 = objectPositionWME10.getX()) && BehavingEntity.constantTrue(z8 = objectPositionWME10.getZ())) {
                        final ListIterator listIterator67 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator67.hasNext()) {
                            final ObjectRotationWME objectRotationWME8;
                            final ObjectRotationWME objectRotationWME7 = objectRotationWME8 = listIterator67.next();
                            final float y5;
                            if (objectRotationWME7.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(y5 = objectRotationWME7.getY())) {
                                final ListIterator listIterator68 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator68.hasNext()) {
                                    final ObjectPositionWME objectPositionWME13;
                                    final ObjectPositionWME objectPositionWME12 = objectPositionWME13 = listIterator68.next();
                                    final float x9;
                                    final float z9;
                                    if (objectPositionWME12.getObjectID() == intValue10 && BehavingEntity.constantTrue(x9 = objectPositionWME12.getX()) && BehavingEntity.constantTrue(z9 = objectPositionWME12.getZ()) && !Staging.isPointWithinCharCone(x9, z9, x8, z8, y5, 45.0f, 0.0f, 9999.0f)) {
                                        hashtable.put("myX", new Float(x8));
                                        hashtable.put("myRot", new Float(y5));
                                        hashtable.put("objX", new Float(x9));
                                        hashtable.put("objZ", new Float(z9));
                                        hashtable.put("myPosWME", new ObjectWrapper(objectPositionWME11));
                                        hashtable.put("myRotWME", new ObjectWrapper(objectRotationWME8));
                                        hashtable.put("myZ", new Float(z8));
                                        hashtable.put("stagingObjectPosWME", new ObjectWrapper(objectPositionWME13));
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 4681: {
                (int)array[0];
                (int)array[1];
                final int intValue11 = (int)array[2];
                (int)array[3];
                if (intValue11 == 0) {
                    final ListIterator listIterator69 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                    while (listIterator69.hasNext()) {
                        final HeldObjectWME heldObjectWME = listIterator69.next();
                        if (heldObjectWME.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME.getAttachPointID() == ((Grace)behavingEntity).g_leftHand) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4682: {
                (int)array[0];
                (int)array[1];
                final int intValue12 = (int)array[2];
                (int)array[3];
                if (intValue12 == 1) {
                    final ListIterator listIterator70 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                    while (listIterator70.hasNext()) {
                        final HeldObjectWME heldObjectWME2 = listIterator70.next();
                        if (heldObjectWME2.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME2.getAttachPointID() == ((Grace)behavingEntity).g_rightHand) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4683: {
                (int)array[0];
                final int intValue13 = (int)array[1];
                (int)array[2];
                (int)array[3];
                final ListIterator listIterator71 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupPositionWME").listIterator();
                while (listIterator71.hasNext()) {
                    final ObjectPickupPositionWME objectPickupPositionWME = listIterator71.next();
                    final float x10;
                    final float y6;
                    final float z10;
                    if (objectPickupPositionWME.getObjectID() == intValue13 && BehavingEntity.constantTrue(x10 = objectPickupPositionWME.getX()) && BehavingEntity.constantTrue(y6 = objectPickupPositionWME.getY()) && BehavingEntity.constantTrue(z10 = objectPickupPositionWME.getZ())) {
                        final ListIterator listIterator72 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupRotationWME").listIterator();
                        while (listIterator72.hasNext()) {
                            final ObjectPickupRotationWME objectPickupRotationWME = listIterator72.next();
                            final float y7;
                            if (objectPickupRotationWME.getObjectID() == intValue13 && BehavingEntity.constantTrue(y7 = objectPickupRotationWME.getY())) {
                                hashtable.put("walkToAngle", new Float(y7));
                                hashtable.put("walkToX", new Float(x10));
                                hashtable.put("walkToZ", new Float(z10));
                                hashtable.put("walkToY", new Float(y6));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4684: {
                (int)array[0];
                final float floatValue = (float)array[1];
                final float floatValue2 = (float)array[2];
                return floatValue < -1000.0f || floatValue > 1000.0f || floatValue2 < -1000.0f || floatValue2 > 1000.0f;
            }
            case 4686: {
                (int)array[0];
                final int intValue14 = (int)array[1];
                final ListIterator listIterator73 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupPositionWME").listIterator();
                while (listIterator73.hasNext()) {
                    if (listIterator73.next().getObjectID() == intValue14) {
                        return false;
                    }
                }
                return true;
            }
            case 4687: {
                (int)array[0];
                final int intValue15 = (int)array[1];
                final ListIterator listIterator74 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupRotationWME").listIterator();
                while (listIterator74.hasNext()) {
                    if (listIterator74.next().getObjectID() == intValue15) {
                        return false;
                    }
                }
                return true;
            }
            case 4690: {
                (int)array[0];
                final int intValue16 = (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                if (intValue16 == 0) {
                    final ListIterator listIterator75 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                    while (listIterator75.hasNext()) {
                        final HeldObjectWME heldObjectWME3 = listIterator75.next();
                        if (heldObjectWME3.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME3.getAttachPointID() == ((Grace)behavingEntity).g_leftHand) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            case 4691: {
                (int)array[0];
                final int intValue17 = (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                if (intValue17 == 1) {
                    final ListIterator listIterator76 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                    while (listIterator76.hasNext()) {
                        final HeldObjectWME heldObjectWME4 = listIterator76.next();
                        if (heldObjectWME4.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME4.getAttachPointID() == ((Grace)behavingEntity).g_rightHand) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            case 4692: {
                (int)array[0];
                (int)array[1];
                final int intValue18 = (int)array[2];
                (int)array[3];
                (int)array[4];
                final ListIterator listIterator77 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupPositionWME").listIterator();
                while (listIterator77.hasNext()) {
                    final ObjectPickupPositionWME objectPickupPositionWME2 = listIterator77.next();
                    final float x11;
                    final float y8;
                    final float z11;
                    if (objectPickupPositionWME2.getObjectID() == intValue18 && BehavingEntity.constantTrue(x11 = objectPickupPositionWME2.getX()) && BehavingEntity.constantTrue(y8 = objectPickupPositionWME2.getY()) && BehavingEntity.constantTrue(z11 = objectPickupPositionWME2.getZ())) {
                        final ListIterator listIterator78 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupRotationWME").listIterator();
                        while (listIterator78.hasNext()) {
                            final ObjectPickupRotationWME objectPickupRotationWME3;
                            final ObjectPickupRotationWME objectPickupRotationWME2 = objectPickupRotationWME3 = listIterator78.next();
                            final float y9;
                            if (objectPickupRotationWME2.getObjectID() == intValue18 && BehavingEntity.constantTrue(y9 = objectPickupRotationWME2.getY())) {
                                hashtable.put("walkToAngle", new Float(y9));
                                hashtable.put("xDropPos", new Float(x11));
                                hashtable.put("dropOnObjectRotWME", new ObjectWrapper(objectPickupRotationWME3));
                                hashtable.put("zDropPos", new Float(z11));
                                hashtable.put("yDropPos", new Float(y8));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4693: {
                (int)array[0];
                (int)array[1];
                final int intValue19 = (int)array[2];
                (int)array[3];
                final ListIterator listIterator79 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupPositionWME").listIterator();
                while (listIterator79.hasNext()) {
                    if (listIterator79.next().getObjectID() == intValue19) {
                        return false;
                    }
                }
                return true;
            }
            case 4694: {
                (int)array[0];
                (int)array[1];
                final int intValue20 = (int)array[2];
                (int)array[3];
                final ListIterator listIterator80 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupRotationWME").listIterator();
                while (listIterator80.hasNext()) {
                    if (listIterator80.next().getObjectID() == intValue20) {
                        return false;
                    }
                }
                return true;
            }
            case 4696: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                if (((Grace)behavingEntity).g_objArm == 0) {
                    final ListIterator listIterator81 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                    while (listIterator81.hasNext()) {
                        final HeldObjectWME heldObjectWME5 = listIterator81.next();
                        if (heldObjectWME5.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME5.getAttachPointID() == ((Grace)behavingEntity).g_leftHand) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            case 4697: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                if (((Grace)behavingEntity).g_objArm == 1) {
                    final ListIterator listIterator82 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                    while (listIterator82.hasNext()) {
                        final HeldObjectWME heldObjectWME6 = listIterator82.next();
                        if (heldObjectWME6.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME6.getAttachPointID() == ((Grace)behavingEntity).g_rightHand) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            case 4699: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator83 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator83.hasNext()) {
                    if (listIterator83.next().getCharacterID() == 2) {
                        return false;
                    }
                }
                return true;
            }
            case 4703: {
                (int)array[0];
                final ListIterator listIterator84 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator84.hasNext()) {
                    final HeldObjectWME heldObjectWME7 = listIterator84.next();
                    if (heldObjectWME7.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME7.getAttachPointID() == ((Grace)behavingEntity).g_objHand) {
                        return true;
                    }
                }
                return false;
            }
            case 4706: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                if (((Grace)behavingEntity).g_objArm == 0) {
                    final ListIterator listIterator85 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                    while (listIterator85.hasNext()) {
                        final HeldObjectWME heldObjectWME8 = listIterator85.next();
                        if (heldObjectWME8.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME8.getAttachPointID() == ((Grace)behavingEntity).g_leftHand) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4707: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                if (((Grace)behavingEntity).g_objArm == 1) {
                    final ListIterator listIterator86 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                    while (listIterator86.hasNext()) {
                        final HeldObjectWME heldObjectWME9 = listIterator86.next();
                        if (heldObjectWME9.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME9.getAttachPointID() == ((Grace)behavingEntity).g_rightHand) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4712: {
                (int)array[0];
                final ListIterator listIterator87 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator87.hasNext()) {
                    final HeldObjectWME heldObjectWME10 = listIterator87.next();
                    if (heldObjectWME10.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME10.getAttachPointID() == ((Grace)behavingEntity).g_objHand) {
                        return true;
                    }
                }
                return false;
            }
            case 4716: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 4717: {
                return ((Grace)behavingEntity).me == ((Grace)behavingEntity).grace;
            }
            case 4722: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator88 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator88.hasNext()) {
                    final ObjectPositionWME objectPositionWME14 = listIterator88.next();
                    final float x12;
                    final float z12;
                    if (objectPositionWME14.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x12 = objectPositionWME14.getX()) && BehavingEntity.constantTrue(z12 = objectPositionWME14.getZ())) {
                        final ListIterator listIterator89 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator89.hasNext()) {
                            final ObjectRotationWME objectRotationWME9 = listIterator89.next();
                            final float y10;
                            if (objectRotationWME9.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(y10 = objectRotationWME9.getY())) {
                                hashtable.put("playerX", new Float(x12));
                                hashtable.put("playerRotY", new Float(y10));
                                hashtable.put("playerZ", new Float(z12));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4726: {
                return !(boolean)array[0];
            }
            case 4727: {
                return (boolean)array[0];
            }
            case 4731: {
                final ListIterator listIterator90 = BehavingEntity.getBehavingEntity().lookupWME("StagingInfoWME").listIterator();
                while (listIterator90.hasNext()) {
                    final StagingInfoWME stagingInfoWME = listIterator90.next();
                    final float targetX;
                    final float targetZ;
                    final float targetRot;
                    if (BehavingEntity.constantTrue(targetX = stagingInfoWME.getTargetX()) && BehavingEntity.constantTrue(targetZ = stagingInfoWME.getTargetZ()) && BehavingEntity.constantTrue(targetRot = stagingInfoWME.getTargetRot())) {
                        final ListIterator listIterator91 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator91.hasNext()) {
                            final ObjectPositionWME objectPositionWME15 = listIterator91.next();
                            if (objectPositionWME15.getObjectID() == ((Grace)behavingEntity).me && objectPositionWME15.getX() == targetX && objectPositionWME15.getZ() == targetZ && targetRot == ((Grace)behavingEntity).DONTCAREANGLE) {
                                hashtable.put("targetX", new Float(targetX));
                                hashtable.put("targetRot", new Float(targetRot));
                                hashtable.put("targetZ", new Float(targetZ));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4732: {
                final ListIterator listIterator92 = BehavingEntity.getBehavingEntity().lookupWME("StagingInfoWME").listIterator();
                while (listIterator92.hasNext()) {
                    final StagingInfoWME stagingInfoWME2 = listIterator92.next();
                    final float targetX2;
                    final float targetZ2;
                    final float targetRot2;
                    if (BehavingEntity.constantTrue(targetX2 = stagingInfoWME2.getTargetX()) && BehavingEntity.constantTrue(targetZ2 = stagingInfoWME2.getTargetZ()) && BehavingEntity.constantTrue(targetRot2 = stagingInfoWME2.getTargetRot())) {
                        final ListIterator listIterator93 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator93.hasNext()) {
                            final ObjectPositionWME objectPositionWME16 = listIterator93.next();
                            if (objectPositionWME16.getObjectID() == ((Grace)behavingEntity).me && objectPositionWME16.getX() == targetX2 && objectPositionWME16.getZ() == targetZ2) {
                                final ListIterator listIterator94 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                                while (listIterator94.hasNext()) {
                                    final ObjectRotationWME objectRotationWME10 = listIterator94.next();
                                    final float y11;
                                    if (objectRotationWME10.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(y11 = objectRotationWME10.getY()) && Staging.normalize0to360(y11) == Staging.normalize0to360(targetRot2)) {
                                        hashtable.put("targetX", new Float(targetX2));
                                        hashtable.put("targetRot", new Float(targetRot2));
                                        hashtable.put("targetZ", new Float(targetZ2));
                                        hashtable.put("myYRotation", new Float(y11));
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 4733: {
                final ListIterator listIterator95 = BehavingEntity.getBehavingEntity().lookupWME("StagingInfoWME").listIterator();
                while (listIterator95.hasNext()) {
                    final StagingInfoWME stagingInfoWME3 = listIterator95.next();
                    final float targetX3;
                    final float targetZ3;
                    final float targetRot3;
                    if (BehavingEntity.constantTrue(targetX3 = stagingInfoWME3.getTargetX()) && BehavingEntity.constantTrue(targetZ3 = stagingInfoWME3.getTargetZ()) && BehavingEntity.constantTrue(targetRot3 = stagingInfoWME3.getTargetRot())) {
                        final ListIterator listIterator96 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator96.hasNext()) {
                            final ObjectPositionWME objectPositionWME17 = listIterator96.next();
                            final float x13;
                            final float z13;
                            if (objectPositionWME17.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x13 = objectPositionWME17.getX()) && BehavingEntity.constantTrue(z13 = objectPositionWME17.getZ())) {
                                final ListIterator listIterator97 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                                while (listIterator97.hasNext()) {
                                    final ObjectRotationWME objectRotationWME11 = listIterator97.next();
                                    final float y12;
                                    if (objectRotationWME11.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(y12 = objectRotationWME11.getY())) {
                                        hashtable.put("targetX", new Float(targetX3));
                                        hashtable.put("targetRot", new Float(targetRot3));
                                        hashtable.put("curZ", new Float(z13));
                                        hashtable.put("targetZ", new Float(targetZ3));
                                        hashtable.put("curYRotation", new Float(y12));
                                        hashtable.put("curX", new Float(x13));
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 4734: {
                final ListIterator listIterator98 = BehavingEntity.getBehavingEntity().lookupWME("StagingInfoWME").listIterator();
                while (listIterator98.hasNext()) {
                    final StagingInfoWME stagingInfoWME4 = listIterator98.next();
                    final float targetX4;
                    final float targetZ4;
                    final float targetRot4;
                    final int walkType;
                    if (stagingInfoWME4.getTargetObjectID() != ((Grace)behavingEntity).player && BehavingEntity.constantTrue(targetX4 = stagingInfoWME4.getTargetX()) && BehavingEntity.constantTrue(targetZ4 = stagingInfoWME4.getTargetZ()) && BehavingEntity.constantTrue(targetRot4 = stagingInfoWME4.getTargetRot()) && BehavingEntity.constantTrue(walkType = stagingInfoWME4.getWalkType())) {
                        hashtable.put("targetX", new Float(targetX4));
                        hashtable.put("targetRot", new Float(targetRot4));
                        hashtable.put("targetZ", new Float(targetZ4));
                        hashtable.put("walkType", new Integer(walkType));
                        return true;
                    }
                }
                return false;
            }
            case 4735: {
                final ListIterator listIterator99 = BehavingEntity.getBehavingEntity().lookupWME("StagingInfoWME").listIterator();
                while (listIterator99.hasNext()) {
                    final StagingInfoWME stagingInfoWME5 = listIterator99.next();
                    final float targetX5;
                    final float targetZ5;
                    final float targetRot5;
                    final int walkType2;
                    if (stagingInfoWME5.getTargetObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(targetX5 = stagingInfoWME5.getTargetX()) && BehavingEntity.constantTrue(targetZ5 = stagingInfoWME5.getTargetZ()) && BehavingEntity.constantTrue(targetRot5 = stagingInfoWME5.getTargetRot()) && BehavingEntity.constantTrue(walkType2 = stagingInfoWME5.getWalkType())) {
                        hashtable.put("targetX", new Float(targetX5));
                        hashtable.put("targetRot", new Float(targetRot5));
                        hashtable.put("targetZ", new Float(targetZ5));
                        hashtable.put("walkType", new Integer(walkType2));
                        return true;
                    }
                }
                return false;
            }
            case 4737: {
                (boolean)array[0];
                final ListIterator listIterator100 = BehavingEntity.getBehavingEntity().lookupWME("StagingInfoWME").listIterator();
                while (listIterator100.hasNext()) {
                    final StagingInfoWME stagingInfoWME6 = listIterator100.next();
                    final float targetX6;
                    final float targetZ6;
                    if (BehavingEntity.constantTrue(targetX6 = stagingInfoWME6.getTargetX()) && BehavingEntity.constantTrue(targetZ6 = stagingInfoWME6.getTargetZ())) {
                        final ListIterator listIterator101 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator101.hasNext()) {
                            final ObjectPositionWME objectPositionWME18 = listIterator101.next();
                            final float x14;
                            final float z14;
                            if (objectPositionWME18.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x14 = objectPositionWME18.getX()) && BehavingEntity.constantTrue(z14 = objectPositionWME18.getZ())) {
                                boolean b2;
                                boolean b = b2 = false;
                                if (x14 == targetX6 && z14 == targetZ6) {
                                    b = (b2 = true);
                                }
                                final boolean b3 = b2;
                                if (BehavingEntity.constantTrue(b)) {
                                    hashtable.put("myOrigX", new Float(x14));
                                    hashtable.put("myOrigZ", new Float(z14));
                                    hashtable.put("targetX", new Float(targetX6));
                                    hashtable.put("targetZ", new Float(targetZ6));
                                    hashtable.put("bIAmOnlyTurningInPlace", new Boolean(b3));
                                    return true;
                                }
                                continue;
                            }
                        }
                    }
                }
                return false;
            }
            case 4739: {
                final ListIterator listIterator102 = BehavingEntity.getBehavingEntity().lookupWME("StagingInfoWME").listIterator();
                if (!listIterator102.hasNext()) {
                    return false;
                }
                hashtable.put("stagingInfoWME", new ObjectWrapper(listIterator102.next()));
                return true;
            }
            case 4740: {
                (int)array[0];
                final int intValue21 = (int)array[1];
                (int)array[2];
                (boolean)array[3];
                return intValue21 == -1;
            }
            case 4741: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                return !(boolean)array[3];
            }
            case 4742: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                return (boolean)array[3];
            }
            case 4743: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator103 = BehavingEntity.getBehavingEntity().lookupWME("DoGestureTempWME").listIterator();
                while (listIterator103.hasNext()) {
                    if (listIterator103.next().getVal() == -2) {
                        return true;
                    }
                }
                return false;
            }
            case 4744: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator104 = BehavingEntity.getBehavingEntity().lookupWME("DoGestureTempWME").listIterator();
                while (listIterator104.hasNext()) {
                    final int val;
                    if (BehavingEntity.constantTrue(val = listIterator104.next().getVal())) {
                        hashtable.put("newGestureIndex", new Integer(val));
                        return true;
                    }
                }
                return false;
            }
            case 4745: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                final boolean booleanValue2 = (boolean)array[3];
                (int)array[4];
                return !booleanValue2;
            }
            case 4746: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                final boolean booleanValue3 = (boolean)array[3];
                (int)array[4];
                return booleanValue3;
            }
            case 4747: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                final ListIterator listIterator105 = BehavingEntity.getBehavingEntity().lookupWME("DoGestureTempWME").listIterator();
                while (listIterator105.hasNext()) {
                    if (listIterator105.next().getVal() == -2) {
                        return true;
                    }
                }
                return false;
            }
            case 4748: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                final ListIterator listIterator106 = BehavingEntity.getBehavingEntity().lookupWME("DoGestureTempWME").listIterator();
                while (listIterator106.hasNext()) {
                    final int val2;
                    if (BehavingEntity.constantTrue(val2 = listIterator106.next().getVal())) {
                        hashtable.put("newGestureIndex", new Integer(val2));
                        return true;
                    }
                }
                return false;
            }
            case 4749: {
                (int)array[0];
                (int)array[1];
                final int intValue22 = (int)array[2];
                final ListIterator listIterator107 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator107.hasNext()) {
                    final HeldObjectWME heldObjectWME11 = listIterator107.next();
                    if (heldObjectWME11.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME11.getObjectID() == intValue22) {
                        return true;
                    }
                }
                return false;
            }
            case 4751: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                final boolean booleanValue4 = (boolean)array[3];
                (int)array[4];
                (int)array[5];
                (float)array[6];
                (float)array[7];
                (float)array[8];
                (int)array[9];
                return !booleanValue4;
            }
            case 4752: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                final boolean booleanValue5 = (boolean)array[3];
                (int)array[4];
                (int)array[5];
                (float)array[6];
                (float)array[7];
                (float)array[8];
                (int)array[9];
                return booleanValue5;
            }
            case 4753: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (float)array[4];
                (float)array[5];
                (float)array[6];
                (int)array[7];
                final ListIterator listIterator108 = BehavingEntity.getBehavingEntity().lookupWME("DoGestureTempWME").listIterator();
                while (listIterator108.hasNext()) {
                    if (listIterator108.next().getVal() == -2) {
                        return true;
                    }
                }
                return false;
            }
            case 4754: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (float)array[4];
                (float)array[5];
                (float)array[6];
                (int)array[7];
                final ListIterator listIterator109 = BehavingEntity.getBehavingEntity().lookupWME("DoGestureTempWME").listIterator();
                while (listIterator109.hasNext()) {
                    final int val3;
                    if (BehavingEntity.constantTrue(val3 = listIterator109.next().getVal())) {
                        hashtable.put("newGestureIndex", new Integer(val3));
                        return true;
                    }
                }
                return false;
            }
            case 4755: {
                (int)array[0];
                final int intValue23 = (int)array[1];
                (int)array[2];
                return intValue23 == 0;
            }
            case 4757: {
                (int)array[0];
                final int intValue24 = (int)array[1];
                (int)array[2];
                (int)array[3];
                return intValue24 == 0;
            }
            case 4759: {
                (int)array[0];
                final int intValue25 = (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (float)array[5];
                (float)array[6];
                (float)array[7];
                (int)array[8];
                return intValue25 == 0;
            }
            case 4761: {
                (int)array[0];
                final int intValue26 = (int)array[1];
                (int)array[2];
                return intValue26 == 1;
            }
            case 4763: {
                (int)array[0];
                final int intValue27 = (int)array[1];
                (int)array[2];
                (int)array[3];
                return intValue27 == 1;
            }
            case 4765: {
                (int)array[0];
                final int intValue28 = (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (float)array[5];
                (float)array[6];
                (float)array[7];
                (int)array[8];
                return intValue28 == 1;
            }
            case 4767: {
                (int)array[0];
                final int intValue29 = (int)array[1];
                (int)array[2];
                return intValue29 == 2;
            }
            case 4772: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                return (int)array[5] == 0;
            }
            case 4773: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                return (int)array[5] == 1;
            }
            case 4774: {
                final int intValue30 = (int)array[0];
                (int)array[1];
                if (intValue30 != 0 && intValue30 != 1 && intValue30 != 2) {
                    final ListIterator listIterator110 = BehavingEntity.getBehavingEntity().lookupWME("DoGestureTempWME").listIterator();
                    if (listIterator110.hasNext()) {
                        hashtable.put("gestureTempWME", new ObjectWrapper(listIterator110.next()));
                        return true;
                    }
                }
                return false;
            }
            case 4775: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator111 = BehavingEntity.getBehavingEntity().lookupWME("ArmBaseWME").listIterator();
                while (listIterator111.hasNext()) {
                    final ArmBaseWME armBaseWME = listIterator111.next();
                    final int base;
                    if (armBaseWME.getCharacterID() == ((Grace)behavingEntity).me && armBaseWME.getGestureLayer() == 4 && BehavingEntity.constantTrue(base = armBaseWME.getBase())) {
                        final ListIterator listIterator112 = BehavingEntity.getBehavingEntity().lookupWME("ArmBaseWME").listIterator();
                        while (listIterator112.hasNext()) {
                            final ArmBaseWME armBaseWME2 = listIterator112.next();
                            final int base2;
                            if (armBaseWME2.getCharacterID() == ((Grace)behavingEntity).me && armBaseWME2.getGestureLayer() == 5 && BehavingEntity.constantTrue(base2 = armBaseWME2.getBase())) {
                                final ListIterator listIterator113 = BehavingEntity.getBehavingEntity().lookupWME("DoGestureTempWME").listIterator();
                                if (!listIterator113.hasNext()) {
                                    continue;
                                }
                                final DoGestureTempWME doGestureTempWME = listIterator113.next();
                                hashtable.put("armLBase", new Integer(base));
                                hashtable.put("gestureTempWME", new ObjectWrapper(doGestureTempWME));
                                hashtable.put("armRBase", new Integer(base2));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4776: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator114 = BehavingEntity.getBehavingEntity().lookupWME("ArmBaseWME").listIterator();
                while (listIterator114.hasNext()) {
                    final ArmBaseWME armBaseWME3 = listIterator114.next();
                    final int base3;
                    if (armBaseWME3.getCharacterID() == ((Grace)behavingEntity).me && armBaseWME3.getGestureLayer() == 6 && BehavingEntity.constantTrue(base3 = armBaseWME3.getBase())) {
                        final ListIterator listIterator115 = BehavingEntity.getBehavingEntity().lookupWME("DoGestureTempWME").listIterator();
                        if (!listIterator115.hasNext()) {
                            continue;
                        }
                        final DoGestureTempWME doGestureTempWME2 = listIterator115.next();
                        hashtable.put("armsBothBase", new Integer(base3));
                        hashtable.put("gestureTempWME", new ObjectWrapper(doGestureTempWME2));
                        return true;
                    }
                }
                return false;
            }
            case 4791: {
                return (int)array[0] == ((Grace)behavingEntity).me;
            }
            case 4792: {
                return (int)array[0] != ((Grace)behavingEntity).me;
            }
            case 4796: {
                return (boolean)array[0];
            }
            case 4798: {
                final String s8 = (String)array[0];
                final ListIterator listIterator116 = BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", s8).listIterator();
                while (listIterator116.hasNext()) {
                    final GoalStepWME goalStepWME19;
                    if ((goalStepWME19 = listIterator116.next()).getSignature().equals(s8)) {
                        hashtable.put("goal", new ObjectWrapper(goalStepWME19));
                        return true;
                    }
                }
                return false;
            }
            case 4800: {
                final String s9 = (String)array[0];
                final ListIterator listIterator117 = BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", s9).listIterator();
                while (listIterator117.hasNext()) {
                    final GoalStepWME goalStepWME20;
                    if ((goalStepWME20 = listIterator117.next()).getSignature().equals(s9)) {
                        hashtable.put("goal", new ObjectWrapper(goalStepWME20));
                        return true;
                    }
                }
                return false;
            }
            case 4807: {
                (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                (int)array[7];
                (int)array[8];
                (int)array[9];
                (int)array[10];
                (int)array[11];
                (int)array[12];
                (int)array[13];
                (int)array[14];
                (int)array[15];
                (int)array[16];
                (int)array[17];
                (int)array[18];
                (int)array[19];
                (int)array[20];
                (int)array[21];
                (int)array[22];
                (int)array[23];
                (int)array[24];
                (int)array[25];
                (int)array[26];
                (int)array[27];
                (int)array[28];
                (int)array[29];
                (int)array[30];
                (int)array[31];
                (int)array[32];
                (int)array[33];
                (int)array[34];
                (int)array[35];
                (int)array[36];
                (int)array[37];
                (int)array[38];
                (int)array[39];
                (int)array[40];
                (int)array[41];
                (int)array[42];
                final ListIterator listIterator118 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator118.hasNext()) {
                    final MoodWME moodWME10 = listIterator118.next();
                    final ListIterator listIterator119 = BehavingEntity.getBehavingEntity().lookupWME("SetPerfTempWME").listIterator();
                    while (listIterator119.hasNext()) {
                        final SetPerfTempWME setPerfTempWME = listIterator119.next();
                        final ListIterator listIterator120 = BehavingEntity.getBehavingEntity().lookupWME("SetPerfArmBaseWME").listIterator();
                        if (!listIterator120.hasNext()) {
                            continue;
                        }
                        final SetPerfArmBaseWME setPerfArmBaseWME = listIterator120.next();
                        hashtable.put("moodWME", new ObjectWrapper(moodWME10));
                        hashtable.put("setPerfArmBaseWME", new ObjectWrapper(setPerfArmBaseWME));
                        hashtable.put("setPerfTempWME", new ObjectWrapper(setPerfTempWME));
                        return true;
                    }
                }
                return false;
            }
            case 4808: {
                final int intValue31 = (int)array[0];
                final ListIterator listIterator121 = BehavingEntity.getBehavingEntity().lookupWME("SetPerfTempWME").listIterator();
                while (listIterator121.hasNext()) {
                    final SetPerfTempWME setPerfTempWME2 = listIterator121.next();
                    final ListIterator listIterator122 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                    while (listIterator122.hasNext()) {
                        final BodyResourceWME bodyResourceWME2 = listIterator122.next();
                        if (bodyResourceWME2.getResourceID() == intValue31 && bodyResourceWME2.getOwner() == null) {
                            hashtable.put("setPerfTempWME", new ObjectWrapper(setPerfTempWME2));
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4809: {
                (int)array[0];
                final ListIterator listIterator123 = BehavingEntity.getBehavingEntity().lookupWME("SetPerfTempWME").listIterator();
                if (!listIterator123.hasNext()) {
                    return false;
                }
                hashtable.put("setPerfTempWME", new ObjectWrapper(listIterator123.next()));
                return true;
            }
            case 4810: {
                (int)array[0];
                final int intValue32 = (int)array[1];
                final BehaviorWME behaviorWME5 = (BehaviorWME)array[2];
                return intValue32 >= 0;
            }
            case 4811: {
                (int)array[0];
                final int intValue33 = (int)array[1];
                final BehaviorWME behaviorWME6 = (BehaviorWME)array[2];
                return intValue33 < 0;
            }
            case 4812: {
                (int)array[0];
                final ListIterator listIterator124 = BehavingEntity.getBehavingEntity().lookupWME("SetPerfTempWME").listIterator();
                if (!listIterator124.hasNext()) {
                    return false;
                }
                hashtable.put("setPerfTempWME", new ObjectWrapper(listIterator124.next()));
                return true;
            }
            case 4813: {
                (int)array[0];
                final ListIterator listIterator125 = BehavingEntity.getBehavingEntity().lookupWME("SetPerfTempWME").listIterator();
                if (!listIterator125.hasNext()) {
                    return false;
                }
                hashtable.put("setPerfTempWME", new ObjectWrapper(listIterator125.next()));
                return true;
            }
            case 4814: {
                final int intValue34 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                return intValue34 == 999;
            }
            case 4815: {
                final int intValue35 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                return intValue35 != 999;
            }
            case 4816: {
                final int intValue36 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                (int)array[7];
                (int)array[8];
                (int)array[9];
                (int)array[10];
                return intValue36 == 999;
            }
            case 4817: {
                final int intValue37 = (int)array[0];
                (int)array[1];
                (int)array[2];
                (int)array[3];
                (int)array[4];
                (int)array[5];
                (int)array[6];
                (int)array[7];
                (int)array[8];
                (int)array[9];
                (int)array[10];
                return intValue37 != 999;
            }
            case 4818: {
                final int intValue38 = (int)array[0];
                final int intValue39 = (int)array[1];
                return intValue38 != -1 && intValue39 != -1;
            }
            case 4819: {
                final int intValue40 = (int)array[0];
                final int intValue41 = (int)array[1];
                return intValue40 == -1 || intValue41 == -1;
            }
            case 4820: {
                return (int)array[0] > 0;
            }
            case 4821: {
                final ListIterator listIterator126 = BehavingEntity.getBehavingEntity().lookupWME("ArmBaseWME").listIterator();
                while (listIterator126.hasNext()) {
                    final ArmBaseWME armBaseWME4 = listIterator126.next();
                    final int base4;
                    if (armBaseWME4.getCharacterID() == ((Grace)behavingEntity).me && armBaseWME4.getGestureLayer() == 4 && BehavingEntity.constantTrue(base4 = armBaseWME4.getBase())) {
                        final ListIterator listIterator127 = BehavingEntity.getBehavingEntity().lookupWME("ArmBaseWME").listIterator();
                        while (listIterator127.hasNext()) {
                            final ArmBaseWME armBaseWME5 = listIterator127.next();
                            final int base5;
                            if (armBaseWME5.getCharacterID() == ((Grace)behavingEntity).me && armBaseWME5.getGestureLayer() == 5 && BehavingEntity.constantTrue(base5 = armBaseWME5.getBase())) {
                                final ListIterator listIterator128 = BehavingEntity.getBehavingEntity().lookupWME("SetPerfArmBaseWME").listIterator();
                                if (!listIterator128.hasNext()) {
                                    continue;
                                }
                                final SetPerfArmBaseWME setPerfArmBaseWME2 = listIterator128.next();
                                hashtable.put("armLBase", new Integer(base4));
                                hashtable.put("setPerfArmBaseWME", new ObjectWrapper(setPerfArmBaseWME2));
                                hashtable.put("armRBase", new Integer(base5));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4822: {
                final ListIterator listIterator129 = BehavingEntity.getBehavingEntity().lookupWME("ArmBaseWME").listIterator();
                while (listIterator129.hasNext()) {
                    final ArmBaseWME armBaseWME6 = listIterator129.next();
                    final int base6;
                    if (armBaseWME6.getCharacterID() == ((Grace)behavingEntity).me && armBaseWME6.getGestureLayer() == 6 && BehavingEntity.constantTrue(base6 = armBaseWME6.getBase())) {
                        final ListIterator listIterator130 = BehavingEntity.getBehavingEntity().lookupWME("SetPerfArmBaseWME").listIterator();
                        if (!listIterator130.hasNext()) {
                            continue;
                        }
                        final SetPerfArmBaseWME setPerfArmBaseWME3 = listIterator130.next();
                        hashtable.put("armsBothBase", new Integer(base6));
                        hashtable.put("setPerfArmBaseWME", new ObjectWrapper(setPerfArmBaseWME3));
                        return true;
                    }
                }
                return false;
            }
            case 4823: {
                final ListIterator listIterator131 = BehavingEntity.getBehavingEntity().lookupWME("SetPerfArmBaseWME").listIterator();
                if (!listIterator131.hasNext()) {
                    return false;
                }
                hashtable.put("setPerfArmBaseWME", new ObjectWrapper(listIterator131.next()));
                return true;
            }
            case 4829: {
                return (int)array[0] != ((Grace)behavingEntity).noOne;
            }
            case 4838: {
                (boolean)array[0];
                (boolean)array[1];
                (boolean)array[2];
                final ListIterator listIterator132 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                if (!listIterator132.hasNext()) {
                    return false;
                }
                hashtable.put("w", new ObjectWrapper(listIterator132.next()));
                return true;
            }
            case 4839: {
                (float)array[0];
                final ListIterator listIterator133 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                if (!listIterator133.hasNext()) {
                    return false;
                }
                hashtable.put("w", new ObjectWrapper(listIterator133.next()));
                return true;
            }
            case 4840: {
                final ListIterator<GoalStepWME> listIterator134 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isLongTermGoal").listIterator();
                while (listIterator134.hasNext()) {
                    final GoalStepWME goalStepWME21 = listIterator134.next();
                    final String signature13;
                    if (goalStepWME21.getProperty("isLongTermGoal") != null && BehavingEntity.constantTrue(signature13 = goalStepWME21.getSignature())) {
                        final ListIterator<GoalStepWME> listIterator135 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isLongTermGoal").listIterator();
                        while (listIterator135.hasNext()) {
                            final GoalStepWME goalStepWME22 = listIterator135.next();
                            if (goalStepWME22.getProperty("isLongTermGoal") != null && goalStepWME22.getSignature() != signature13) {
                                return false;
                            }
                        }
                        hashtable.put("sig", new ObjectWrapper(signature13));
                        return true;
                    }
                }
                return false;
            }
            case 4841: {
                final ListIterator<GoalStepWME> listIterator136 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isLongTermGoal").listIterator();
                while (listIterator136.hasNext()) {
                    final GoalStepWME goalStepWME24;
                    final GoalStepWME goalStepWME23 = goalStepWME24 = listIterator136.next();
                    final String signature14;
                    final Object property;
                    if (goalStepWME23.getProperty("isLongTermGoal") != null && BehavingEntity.constantTrue(signature14 = goalStepWME23.getSignature()) && BehavingEntity.constantTrue(property = goalStepWME23.getProperty("oneAtATime"))) {
                        final ListIterator<GoalStepWME> listIterator137 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isLongTermGoal").listIterator();
                        while (listIterator137.hasNext()) {
                            final GoalStepWME goalStepWME26;
                            final GoalStepWME goalStepWME25 = goalStepWME26 = listIterator137.next();
                            final Object property2;
                            if (goalStepWME25.getProperty("isLongTermGoal") != null && goalStepWME25.getSignature() != signature14 && BehavingEntity.constantTrue(property2 = goalStepWME25.getProperty("oneAtATime"))) {
                                hashtable.put("longTermGoal2", new ObjectWrapper(goalStepWME26));
                                hashtable.put("oneAtATimeObj2", new ObjectWrapper(property2));
                                hashtable.put("longTermGoal1", new ObjectWrapper(goalStepWME24));
                                hashtable.put("sig1", new ObjectWrapper(signature14));
                                hashtable.put("oneAtATimeObj1", new ObjectWrapper(property));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4843: {
                (int)array[0];
                final ListIterator listIterator138 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator138.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator138.next()));
                return true;
            }
            case 4845: {
                (int)array[0];
                final ListIterator listIterator139 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator139.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator139.next()));
                return true;
            }
            case 4847: {
                (int)array[0];
                final ListIterator listIterator140 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator140.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator140.next()));
                return true;
            }
            case 4849: {
                (int)array[0];
                final ListIterator listIterator141 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator141.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator141.next()));
                return true;
            }
            case 4851: {
                (int)array[0];
                final ListIterator listIterator142 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator142.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator142.next()));
                return true;
            }
            case 4853: {
                (int)array[0];
                final ListIterator listIterator143 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator143.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator143.next()));
                return true;
            }
            case 4855: {
                (int)array[0];
                final ListIterator listIterator144 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator144.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator144.next()));
                return true;
            }
            case 4857: {
                (int)array[0];
                final ListIterator listIterator145 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator145.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator145.next()));
                return true;
            }
            case 4859: {
                (int)array[0];
                final ListIterator listIterator146 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator146.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator146.next()));
                return true;
            }
            case 4861: {
                (int)array[0];
                final ListIterator listIterator147 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator147.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator147.next()));
                return true;
            }
            case 4864: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator148 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                while (listIterator148.hasNext()) {
                    final int itRef;
                    if (BehavingEntity.constantTrue(itRef = listIterator148.next().getItRef())) {
                        hashtable.put("origItRef", new Integer(itRef));
                        return true;
                    }
                }
                return false;
            }
            case 4865: {
                (int)array[0];
                final ListIterator listIterator149 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator149.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator149.next()));
                return true;
            }
            case 4867: {
                (int)array[0];
                final ListIterator listIterator150 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator150.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator150.next()));
                return true;
            }
            case 4869: {
                (int)array[0];
                final ListIterator listIterator151 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator151.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator151.next()));
                return true;
            }
            case 4871: {
                (int)array[0];
                final ListIterator listIterator152 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator152.hasNext()) {
                    final HeldObjectWME heldObjectWME12 = listIterator152.next();
                    final int objectID2;
                    if (heldObjectWME12.getCharacterID() == 2 && BehavingEntity.constantTrue(objectID2 = heldObjectWME12.getObjectID())) {
                        hashtable.put("heldObjSpriteID", new Integer(objectID2));
                        return true;
                    }
                }
                return false;
            }
            case 4872: {
                (int)array[0];
                final ListIterator listIterator153 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator153.hasNext()) {
                    if (listIterator153.next().getCharacterID() == 2) {
                        return false;
                    }
                }
                return true;
            }
            case 4873: {
                (int)array[0];
                final ListIterator listIterator154 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator154.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator154.next()));
                return true;
            }
            case 4875: {
                (int)array[0];
                final ListIterator listIterator155 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator155.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator155.next()));
                return true;
            }
            case 4877: {
                (int)array[0];
                final ListIterator listIterator156 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                if (!listIterator156.hasNext()) {
                    return false;
                }
                hashtable.put("anaphoricRefWME", new ObjectWrapper(listIterator156.next()));
                return true;
            }
            case 4880: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator157 = WorkingMemory.lookupWME("StoryMemory", "PostBeatMixinInfoWME").listIterator();
                if (!listIterator157.hasNext()) {
                    return false;
                }
                hashtable.put("pbmWME", new ObjectWrapper(listIterator157.next()));
                return true;
            }
            case 4882: {
                (int)array[0];
                (boolean)array[1];
                final ListIterator listIterator158 = WorkingMemory.lookupWME("StoryMemory", "PostBeatMixinInfoWME").listIterator();
                if (!listIterator158.hasNext()) {
                    return false;
                }
                hashtable.put("pbmWME", new ObjectWrapper(listIterator158.next()));
                return true;
            }
            case 4884: {
                final ListIterator listIterator159 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator159.hasNext()) {
                    final HeldObjectWME heldObjectWME13 = listIterator159.next();
                    if (heldObjectWME13.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME13.getAttachPointID() == ((Grace)behavingEntity).g_objHand) {
                        return true;
                    }
                }
                return false;
            }
            case 4885: {
                final ListIterator listIterator160 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator160.hasNext()) {
                    final HeldObjectWME heldObjectWME14 = listIterator160.next();
                    if (heldObjectWME14.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME14.getAttachPointID() == ((Grace)behavingEntity).g_drinkHand) {
                        return true;
                    }
                }
                return false;
            }
            case 4886: {
                final ListIterator<GoalStepWME> listIterator161 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "StagingObjectDrop(int, int, int, int, int)").listIterator();
                while (listIterator161.hasNext()) {
                    if (listIterator161.next().getSignature().equals("StagingObjectDrop(int, int, int, int, int)")) {
                        return false;
                    }
                }
                return true;
            }
            case 4887: {
                final ListIterator<GoalStepWME> listIterator162 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "StagingObjectDrop(int, int, int, int, int)").listIterator();
                while (listIterator162.hasNext()) {
                    if (listIterator162.next().getSignature().equals("StagingObjectDrop(int, int, int, int, int)")) {
                        return false;
                    }
                }
                return true;
            }
            case 4889: {
                final ListIterator listIterator163 = BehavingEntity.getBehavingEntity().lookupWME("UserTestWME").listIterator();
                while (listIterator163.hasNext()) {
                    final UserTestWME userTestWME2;
                    final UserTestWME userTestWME = userTestWME2 = listIterator163.next();
                    final int param2;
                    final int param3;
                    final int param4;
                    if (userTestWME.getParam1() == 0 && BehavingEntity.constantTrue(param2 = userTestWME.getParam2()) && BehavingEntity.constantTrue(param3 = userTestWME.getParam3()) && BehavingEntity.constantTrue(param4 = userTestWME.getParam4())) {
                        hashtable.put("param2", new Integer(param2));
                        hashtable.put("param4", new Integer(param4));
                        hashtable.put("userTestWME", new ObjectWrapper(userTestWME2));
                        hashtable.put("param3", new Integer(param3));
                        return true;
                    }
                }
                return false;
            }
            case 4890: {
                final ListIterator listIterator164 = BehavingEntity.getBehavingEntity().lookupWME("UserTestWME").listIterator();
                while (listIterator164.hasNext()) {
                    final UserTestWME userTestWME4;
                    final UserTestWME userTestWME3 = userTestWME4 = listIterator164.next();
                    final int param5;
                    final int param6;
                    if (userTestWME3.getParam1() == 1 && BehavingEntity.constantTrue(param5 = userTestWME3.getParam2()) && BehavingEntity.constantTrue(param6 = userTestWME3.getParam3())) {
                        hashtable.put("param2", new Integer(param5));
                        hashtable.put("userTestWME", new ObjectWrapper(userTestWME4));
                        hashtable.put("param3", new Integer(param6));
                        return true;
                    }
                }
                return false;
            }
            case 4891: {
                final ListIterator listIterator165 = BehavingEntity.getBehavingEntity().lookupWME("UserTestWME").listIterator();
                while (listIterator165.hasNext()) {
                    final UserTestWME userTestWME6;
                    final UserTestWME userTestWME5 = userTestWME6 = listIterator165.next();
                    final int param7;
                    if (userTestWME5.getParam1() == 2 && BehavingEntity.constantTrue(param7 = userTestWME5.getParam2())) {
                        hashtable.put("param2", new Integer(param7));
                        hashtable.put("userTestWME", new ObjectWrapper(userTestWME6));
                        return true;
                    }
                }
                return false;
            }
            case 4892: {
                final ListIterator listIterator166 = BehavingEntity.getBehavingEntity().lookupWME("UserTestWME").listIterator();
                while (listIterator166.hasNext()) {
                    final UserTestWME userTestWME8;
                    final UserTestWME userTestWME7 = userTestWME8 = listIterator166.next();
                    final int param8;
                    final int param9;
                    if (userTestWME7.getParam1() == 3 && BehavingEntity.constantTrue(param8 = userTestWME7.getParam2()) && BehavingEntity.constantTrue(param9 = userTestWME7.getParam3()) && ((Grace)behavingEntity).me == 1) {
                        hashtable.put("param2", new Integer(param8));
                        hashtable.put("userTestWME", new ObjectWrapper(userTestWME8));
                        hashtable.put("param3", new Integer(param9));
                        return true;
                    }
                }
                return false;
            }
            case 4893: {
                final ListIterator listIterator167 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator167.hasNext()) {
                    final ObjectPositionWME objectPositionWME19 = listIterator167.next();
                    final float x15;
                    final float z15;
                    if (objectPositionWME19.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x15 = objectPositionWME19.getX()) && BehavingEntity.constantTrue(z15 = objectPositionWME19.getZ())) {
                        hashtable.put("myX", new Float(x15));
                        hashtable.put("myZ", new Float(z15));
                        return true;
                    }
                }
                return false;
            }
            case 4900: {
                (int)array[0];
                final ListIterator listIterator168 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator168.hasNext()) {
                    if (listIterator168.next().getSVal().equals("bOneOnOneAffChrT2_interaction")) {
                        return false;
                    }
                }
                return true;
            }
            case 4901: {
                (int)array[0];
                final ListIterator listIterator169 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator169.hasNext()) {
                    if (listIterator169.next().getSVal().equals("bOneOnOneAffChrT2_interaction")) {
                        return true;
                    }
                }
                return false;
            }
            case 4903: {
                (int)array[0];
                final ListIterator listIterator170 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator170.hasNext()) {
                    if (listIterator170.next().getSVal().equals("bOneOnOneAffChrT2_interaction")) {
                        return false;
                    }
                }
                return true;
            }
            case 4904: {
                return (int)array[0] != -1;
            }
            case 4906: {
                return (boolean)array[0];
            }
            case 4908: {
                final ListIterator listIterator171 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator171.hasNext()) {
                    final StoryStatusWME storyStatusWME = listIterator171.next();
                    final ListIterator listIterator172 = WorkingMemory.lookupWME("StoryMemory", "TensionStoryValueWME").listIterator();
                    while (listIterator172.hasNext()) {
                        final float value;
                        if (BehavingEntity.constantTrue(value = listIterator172.next().getValue())) {
                            hashtable.put("storyStatusWME", new ObjectWrapper(storyStatusWME));
                            hashtable.put("tension", new Float(value));
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4909: {
                final ListIterator listIterator173 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator173.hasNext()) {
                    final StoryStatusWME storyStatusWME2 = listIterator173.next();
                    final ListIterator listIterator174 = WorkingMemory.lookupWME("StoryMemory", "TensionStoryValueWME").listIterator();
                    while (listIterator174.hasNext()) {
                        final float value2;
                        if (BehavingEntity.constantTrue(value2 = listIterator174.next().getValue())) {
                            hashtable.put("storyStatusWME", new ObjectWrapper(storyStatusWME2));
                            hashtable.put("tension", new Float(value2));
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4910: {
                final ListIterator listIterator175 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                if (!listIterator175.hasNext()) {
                    return false;
                }
                hashtable.put("storyStatusWME", new ObjectWrapper(listIterator175.next()));
                return true;
            }
            case 4911: {
                final ListIterator listIterator176 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                if (!listIterator176.hasNext()) {
                    return false;
                }
                hashtable.put("storyStatusWME", new ObjectWrapper(listIterator176.next()));
                return true;
            }
            case 4912: {
                final ListIterator listIterator177 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                if (!listIterator177.hasNext()) {
                    return false;
                }
                hashtable.put("storyStatusWME", new ObjectWrapper(listIterator177.next()));
                return true;
            }
            case 4913: {
                final ListIterator listIterator178 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                if (!listIterator178.hasNext()) {
                    return false;
                }
                hashtable.put("storyStatusWME", new ObjectWrapper(listIterator178.next()));
                return true;
            }
            case 4914: {
                final ListIterator listIterator179 = WorkingMemory.lookupWME("StoryMemory", "BeatRMp1WME").listIterator();
                if (!listIterator179.hasNext()) {
                    return true;
                }
                final BeatRMp1WME beatRMp1WME = listIterator179.next();
                return false;
            }
            case 4916: {
                final ListIterator listIterator180 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator180.hasNext()) {
                    final ObjectPositionWME objectPositionWME20 = listIterator180.next();
                    final float x16;
                    final float z16;
                    if (objectPositionWME20.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x16 = objectPositionWME20.getX()) && BehavingEntity.constantTrue(z16 = objectPositionWME20.getZ()) && (x16 < 0.0f || z16 > -180.0f)) {
                        hashtable.put("z", new Float(z16));
                        hashtable.put("x", new Float(x16));
                        return true;
                    }
                }
                return false;
            }
            case 4918: {
                final ListIterator listIterator181 = BehavingEntity.getBehavingEntity().lookupWME("BeatTAt1WME").listIterator();
                if (!listIterator181.hasNext()) {
                    return true;
                }
                final BeatTAt1WME beatTAt1WME = listIterator181.next();
                return false;
            }
            case 4919: {
                (int)array[0];
                final ListIterator listIterator182 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                if (!listIterator182.hasNext()) {
                    return true;
                }
                final BeatFAskDrinkT1WME beatFAskDrinkT1WME = listIterator182.next();
                return false;
            }
            case 4920: {
                (int)array[0];
                final ListIterator listIterator183 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                if (!listIterator183.hasNext()) {
                    return false;
                }
                final BeatFAskDrinkT1WME beatFAskDrinkT1WME2 = listIterator183.next();
                return true;
            }
            case 4921: {
                (int)array[0];
                final ListIterator listIterator184 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                if (!listIterator184.hasNext()) {
                    return false;
                }
                hashtable.put("beatFAskDrinkT1WME", new ObjectWrapper(listIterator184.next()));
                return true;
            }
            case 4922: {
                final ListIterator listIterator185 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                if (!listIterator185.hasNext()) {
                    return false;
                }
                hashtable.put("beatFAskDrinkT1WME", new ObjectWrapper(listIterator185.next()));
                return true;
            }
            case 4923: {
                (int)array[0];
                final ListIterator listIterator186 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                if (!listIterator186.hasNext()) {
                    return false;
                }
                hashtable.put("beatFAskDrinkT1WME", new ObjectWrapper(listIterator186.next()));
                return true;
            }
            case 4924: {
                final ListIterator listIterator187 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                if (!listIterator187.hasNext()) {
                    return false;
                }
                hashtable.put("beatFAskDrinkT1WME", new ObjectWrapper(listIterator187.next()));
                return true;
            }
            case 4925: {
                final int intValue42 = (int)array[0];
                final ListIterator listIterator188 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT1WME").listIterator();
                while (listIterator188.hasNext()) {
                    if (listIterator188.next().getWhenToGoToBar() == intValue42) {
                        return true;
                    }
                }
                return false;
            }
            case 4926: {
                final ListIterator<GoalStepWME> listIterator189 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "LongTermBehavior_FixDrink()").listIterator();
                while (listIterator189.hasNext()) {
                    if (listIterator189.next().getSignature().equals("LongTermBehavior_FixDrink()")) {
                        return false;
                    }
                }
                return true;
            }
            case 4928: {
                (int)array[0];
                final ListIterator listIterator190 = WorkingMemory.lookupWME("StoryMemory", "AmbFixdrinkWME").listIterator();
                if (!listIterator190.hasNext()) {
                    return false;
                }
                hashtable.put("ambFixdrinkWME", new ObjectWrapper(listIterator190.next()));
                return true;
            }
            case 4929: {
                (int)array[0];
                final ListIterator listIterator191 = WorkingMemory.lookupWME("StoryMemory", "AmbFixdrinkWME").listIterator();
                if (!listIterator191.hasNext()) {
                    return false;
                }
                hashtable.put("ambFixdrinkWME", new ObjectWrapper(listIterator191.next()));
                return true;
            }
            case 4930: {
                (int)array[0];
                final ListIterator listIterator192 = WorkingMemory.lookupWME("StoryMemory", "AmbFixdrinkWME").listIterator();
                if (!listIterator192.hasNext()) {
                    return false;
                }
                hashtable.put("ambFixdrinkWME", new ObjectWrapper(listIterator192.next()));
                return true;
            }
            case 4931: {
                return (int)array[0] > 4999;
            }
            case 4933: {
                return (int)array[0] > 4999;
            }
            case 4935: {
                return (int)array[0] > 4999;
            }
            case 4937: {
                (int)array[0];
                final ListIterator listIterator193 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT2WME").listIterator();
                if (!listIterator193.hasNext()) {
                    return true;
                }
                final BeatFAskDrinkT2WME beatFAskDrinkT2WME = listIterator193.next();
                return false;
            }
            case 4938: {
                (int)array[0];
                final ListIterator listIterator194 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT2WME").listIterator();
                if (!listIterator194.hasNext()) {
                    return false;
                }
                final BeatFAskDrinkT2WME beatFAskDrinkT2WME2 = listIterator194.next();
                return true;
            }
            case 4939: {
                (int)array[0];
                final ListIterator listIterator195 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT2WME").listIterator();
                if (!listIterator195.hasNext()) {
                    return false;
                }
                hashtable.put("beatFAskDrinkT2WME", new ObjectWrapper(listIterator195.next()));
                return true;
            }
            case 4940: {
                (int)array[0];
                final ListIterator listIterator196 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT2WME").listIterator();
                if (!listIterator196.hasNext()) {
                    return false;
                }
                hashtable.put("beatFAskDrinkT2WME", new ObjectWrapper(listIterator196.next()));
                return true;
            }
            case 4941: {
                final ListIterator listIterator197 = WorkingMemory.lookupWME("StoryMemory", "BeatFAskDrinkT2WME").listIterator();
                if (!listIterator197.hasNext()) {
                    return false;
                }
                hashtable.put("beatFAskDrinkT2WME", new ObjectWrapper(listIterator197.next()));
                return true;
            }
            case 4942: {
                final ListIterator listIterator198 = WorkingMemory.lookupWME("StoryMemory", "BeatOneOnOneAffChrT2WME").listIterator();
                if (!listIterator198.hasNext()) {
                    final ListIterator listIterator199 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                    while (listIterator199.hasNext()) {
                        final ObjectPositionWME objectPositionWME21 = listIterator199.next();
                        final float x17;
                        final float z17;
                        if (objectPositionWME21.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x17 = objectPositionWME21.getX()) && BehavingEntity.constantTrue(z17 = objectPositionWME21.getZ())) {
                            hashtable.put("playerX", new Float(x17));
                            hashtable.put("playerZ", new Float(z17));
                            return true;
                        }
                    }
                    return false;
                }
                final BeatOneOnOneAffChrT2WME beatOneOnOneAffChrT2WME = listIterator198.next();
                return false;
            }
            case 4943: {
                final ListIterator listIterator200 = WorkingMemory.lookupWME("StoryMemory", "BeatOneOnOneNonAffChrT2WME").listIterator();
                if (!listIterator200.hasNext()) {
                    final ListIterator listIterator201 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                    while (listIterator201.hasNext()) {
                        final ObjectPositionWME objectPositionWME22 = listIterator201.next();
                        final float x18;
                        final float z18;
                        if (objectPositionWME22.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x18 = objectPositionWME22.getX()) && BehavingEntity.constantTrue(z18 = objectPositionWME22.getZ())) {
                            hashtable.put("playerX", new Float(x18));
                            hashtable.put("playerZ", new Float(z18));
                            return true;
                        }
                    }
                    return false;
                }
                final BeatOneOnOneNonAffChrT2WME beatOneOnOneNonAffChrT2WME = listIterator200.next();
                return false;
            }
            case 4944: {
                final ListIterator listIterator202 = WorkingMemory.lookupWME("StoryMemory", "BeatRomPrpWME").listIterator();
                if (!listIterator202.hasNext()) {
                    final ListIterator listIterator203 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                    while (listIterator203.hasNext()) {
                        final ObjectPositionWME objectPositionWME23 = listIterator203.next();
                        final float x19;
                        final float z19;
                        if (objectPositionWME23.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x19 = objectPositionWME23.getX()) && BehavingEntity.constantTrue(z19 = objectPositionWME23.getZ())) {
                            hashtable.put("playerX", new Float(x19));
                            hashtable.put("playerZ", new Float(z19));
                            return true;
                        }
                    }
                    return false;
                }
                final BeatRomPrpWME beatRomPrpWME = listIterator202.next();
                return false;
            }
            case 4945: {
                final ListIterator listIterator204 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                if (!listIterator204.hasNext()) {
                    return true;
                }
                final BeatCrisisP1WME beatCrisisP1WME = listIterator204.next();
                return false;
            }
            case 4946: {
                (boolean)array[0];
                final ListIterator listIterator205 = WorkingMemory.lookupWME("StoryMemory", "BeatCrisisP1WME").listIterator();
                if (!listIterator205.hasNext()) {
                    return false;
                }
                hashtable.put("beatWME", new ObjectWrapper(listIterator205.next()));
                return true;
            }
            case 4947: {
                final ListIterator listIterator206 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator206.hasNext()) {
                    final ObjectPositionWME objectPositionWME24 = listIterator206.next();
                    final float x20;
                    final float z20;
                    if (objectPositionWME24.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x20 = objectPositionWME24.getX()) && BehavingEntity.constantTrue(z20 = objectPositionWME24.getZ())) {
                        final ListIterator listIterator207 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator207.hasNext()) {
                            final ObjectPositionWME objectPositionWME25 = listIterator207.next();
                            final float x21;
                            final float z21;
                            if (objectPositionWME25.getObjectID() == ((Grace)behavingEntity).spouse && BehavingEntity.constantTrue(x21 = objectPositionWME25.getX()) && BehavingEntity.constantTrue(z21 = objectPositionWME25.getZ())) {
                                final ListIterator listIterator208 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator208.hasNext()) {
                                    final ObjectPositionWME objectPositionWME26 = listIterator208.next();
                                    final float x22;
                                    final float z22;
                                    if (objectPositionWME26.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x22 = objectPositionWME26.getX()) && BehavingEntity.constantTrue(z22 = objectPositionWME26.getZ())) {
                                        final ListIterator listIterator209 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                                        while (listIterator209.hasNext()) {
                                            final ObjectRotationWME objectRotationWME12 = listIterator209.next();
                                            final float y13;
                                            if (objectRotationWME12.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(y13 = objectRotationWME12.getY())) {
                                                hashtable.put("playerX", new Float(x22));
                                                hashtable.put("spouseX", new Float(x21));
                                                hashtable.put("myX", new Float(x20));
                                                hashtable.put("spouseZ", new Float(z21));
                                                hashtable.put("playerRotY", new Float(y13));
                                                hashtable.put("playerZ", new Float(z22));
                                                hashtable.put("myZ", new Float(z20));
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 4948: {
                return (boolean)array[0];
            }
            case 4951: {
                final ListIterator listIterator210 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator210.hasNext()) {
                    final HeldObjectWME heldObjectWME15 = listIterator210.next();
                    if (heldObjectWME15.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME15.getAttachPointID() == ((Grace)behavingEntity).g_drinkHand && heldObjectWME15.getObjectCategory() == 1) {
                        final ListIterator<GoalStepWME> listIterator211 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "LongTermBehavior_FixDrink()").listIterator();
                        while (listIterator211.hasNext()) {
                            if (listIterator211.next().getSignature().equals("LongTermBehavior_FixDrink()")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 4955: {
                final ListIterator listIterator212 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator212.hasNext()) {
                    final HeldObjectWME heldObjectWME16 = listIterator212.next();
                    if (heldObjectWME16.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME16.getAttachPointID() == ((Grace)behavingEntity).g_drinkHand && heldObjectWME16.getObjectCategory() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 4956: {
                final ListIterator<GoalStepWME> listIterator213 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator213.hasNext()) {
                    final GoalStepWME goalStepWME27 = listIterator213.next();
                    if (goalStepWME27.getProperty("isBeatGoal") != null && goalStepWME27.getProperty("isAmbSafe") != null && goalStepWME27.getIsExecuting()) {
                        final ListIterator listIterator214 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                        while (listIterator214.hasNext()) {
                            final BodyResourceWME bodyResourceWME3 = listIterator214.next();
                            if (bodyResourceWME3.getResourceID() == ((Grace)behavingEntity).g_drinkArmResource && bodyResourceWME3.getOwner() == null) {
                                final ListIterator listIterator215 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                                while (listIterator215.hasNext()) {
                                    final BodyResourceWME bodyResourceWME4 = listIterator215.next();
                                    if (bodyResourceWME4.getResourceID() == 3 && bodyResourceWME4.getOwner() == null) {
                                        final ListIterator listIterator216 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                                        while (listIterator216.hasNext()) {
                                            final BodyResourceWME bodyResourceWME5 = listIterator216.next();
                                            if (bodyResourceWME5.getResourceID() == 0 && bodyResourceWME5.getOwner() == null) {
                                                final ListIterator listIterator217 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                                                while (listIterator217.hasNext()) {
                                                    final HeldObjectWME heldObjectWME17 = listIterator217.next();
                                                    final int objectID3;
                                                    if (heldObjectWME17.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME17.getAttachPointID() == ((Grace)behavingEntity).g_drinkHand && heldObjectWME17.getObjectCategory() == 1 && BehavingEntity.constantTrue(objectID3 = heldObjectWME17.getObjectID())) {
                                                        final ListIterator listIterator218 = BehavingEntity.getBehavingEntity().lookupWME("ObjectStateWME").listIterator();
                                                        while (listIterator218.hasNext()) {
                                                            final ObjectStateWME objectStateWME = listIterator218.next();
                                                            if (objectStateWME.getObjectID() == objectID3 && objectStateWME.getState() > 0) {
                                                                final ListIterator listIterator219 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                                                while (listIterator219.hasNext()) {
                                                                    final ObjectPositionWME objectPositionWME27 = listIterator219.next();
                                                                    final float x23;
                                                                    final float z23;
                                                                    if (objectPositionWME27.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x23 = objectPositionWME27.getX()) && BehavingEntity.constantTrue(z23 = objectPositionWME27.getZ())) {
                                                                        final ListIterator listIterator220 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                                                        while (listIterator220.hasNext()) {
                                                                            final ObjectPositionWME objectPositionWME28 = listIterator220.next();
                                                                            final float x24;
                                                                            final float z24;
                                                                            if (objectPositionWME28.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x24 = objectPositionWME28.getX()) && BehavingEntity.constantTrue(z24 = objectPositionWME28.getZ())) {
                                                                                final ListIterator listIterator221 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                                                                                while (listIterator221.hasNext()) {
                                                                                    final ObjectRotationWME objectRotationWME13 = listIterator221.next();
                                                                                    final float y14;
                                                                                    if (objectRotationWME13.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(y14 = objectRotationWME13.getY()) && Staging.isPointWithinCharCone(x23, z23, x24, z24, y14, 60.0f, 0.0f, 9999.0f)) {
                                                                                        final ListIterator listIterator222 = BehavingEntity.getBehavingEntity().lookupWME("GazeWME").listIterator();
                                                                                        while (listIterator222.hasNext()) {
                                                                                            final GazeWME gazeWME2 = listIterator222.next();
                                                                                            final int objectID4;
                                                                                            final int speed2;
                                                                                            final int type2;
                                                                                            if (BehavingEntity.constantTrue(objectID4 = gazeWME2.getObjectID()) && BehavingEntity.constantTrue(speed2 = gazeWME2.getSpeed()) && BehavingEntity.constantTrue(type2 = gazeWME2.getType())) {
                                                                                                hashtable.put("playerX", new Float(x23));
                                                                                                hashtable.put("myX", new Float(x24));
                                                                                                hashtable.put("myRot", new Float(y14));
                                                                                                hashtable.put("origGazeSpeed", new Integer(speed2));
                                                                                                hashtable.put("playerZ", new Float(z23));
                                                                                                hashtable.put("myZ", new Float(z24));
                                                                                                hashtable.put("drinkObjectID", new Integer(objectID3));
                                                                                                hashtable.put("origGazeObjectID", new Integer(objectID4));
                                                                                                hashtable.put("origGazeType", new Integer(type2));
                                                                                                return true;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 4960: {
                final ListIterator listIterator223 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator223.hasNext()) {
                    final HeldObjectWME heldObjectWME18 = listIterator223.next();
                    final int objectID5;
                    if (heldObjectWME18.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME18.getAttachPointID() == ((Grace)behavingEntity).g_drinkHand && heldObjectWME18.getObjectCategory() == 1 && BehavingEntity.constantTrue(objectID5 = heldObjectWME18.getObjectID())) {
                        final ListIterator listIterator224 = BehavingEntity.getBehavingEntity().lookupWME("ObjectStateWME").listIterator();
                        while (listIterator224.hasNext()) {
                            final ObjectStateWME objectStateWME2 = listIterator224.next();
                            if (objectStateWME2.getObjectID() == objectID5 && objectStateWME2.getState() <= 0) {
                                hashtable.put("drinkObjectID", new Integer(objectID5));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4961: {
                final ListIterator listIterator225 = BehavingEntity.getBehavingEntity().lookupWME("AmbSipdrinkWME").listIterator();
                while (listIterator225.hasNext()) {
                    final int chance;
                    if (BehavingEntity.constantTrue(chance = listIterator225.next().getChance())) {
                        hashtable.put("chance", new Integer(chance));
                        return true;
                    }
                }
                return false;
            }
            case 4963: {
                if (array[0]) {
                    final ListIterator listIterator226 = BehavingEntity.getBehavingEntity().lookupWME("AmbSipdrinkWME").listIterator();
                    while (listIterator226.hasNext()) {
                        if (listIterator226.next().getFinishScript() == ((Grace)behavingEntity).g_armGesture_drinkHold) {
                            return true;
                        }
                    }
                }
                return false;
            }
            case 4965: {
                final boolean booleanValue6 = (boolean)array[0];
                (int)array[1];
                return booleanValue6;
            }
            case 4967: {
                final boolean booleanValue7 = (boolean)array[0];
                (int)array[1];
                return booleanValue7;
            }
            case 4968: {
                final ListIterator listIterator227 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator227.hasNext()) {
                    final HeldObjectWME heldObjectWME19 = listIterator227.next();
                    final int objectID6;
                    if (heldObjectWME19.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME19.getAttachPointID() == ((Grace)behavingEntity).g_drinkHand && heldObjectWME19.getObjectCategory() == 1 && BehavingEntity.constantTrue(objectID6 = heldObjectWME19.getObjectID())) {
                        final ListIterator listIterator228 = BehavingEntity.getBehavingEntity().lookupWME("ObjectStateWME").listIterator();
                        while (listIterator228.hasNext()) {
                            final ObjectStateWME objectStateWME3 = listIterator228.next();
                            if (objectStateWME3.getObjectID() == objectID6 && objectStateWME3.getState() <= 0) {
                                hashtable.put("drinkObjectID", new Integer(objectID6));
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 4969: {
                (int)array[0];
                final ListIterator listIterator229 = BehavingEntity.getBehavingEntity().lookupWME("AmbSipdrinkWME").listIterator();
                if (!listIterator229.hasNext()) {
                    return false;
                }
                hashtable.put("ambSipdrinkWME", new ObjectWrapper(listIterator229.next()));
                return true;
            }
            case 4970: {
                (int)array[0];
                (int)array[1];
                final ListIterator listIterator230 = BehavingEntity.getBehavingEntity().lookupWME("AmbSipdrinkWME").listIterator();
                if (!listIterator230.hasNext()) {
                    return false;
                }
                hashtable.put("ambSipdrinkWME", new ObjectWrapper(listIterator230.next()));
                return true;
            }
            case 5073: {
                return true;
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
}
