package facade.characters.trip.java;

import java.util.ListIterator;
import abl.runtime.AblRuntimeError;
import dramaman.runtime.TensionStoryValueWME;
import facade.characters.wmedef.UserTestWME;
import facade.characters.wmedef.IsPlayerTranslatingOrRotatingWME;
import facade.characters.wmedef.StagingInfoWME;
import facade.characters.wmedef.HeldObjectWME;
import facade.characters.wmedef.AnimationCueWME;
import facade.characters.wmedef.MoodWME;
import facade.characters.wmedef.PlayerRecentlyTypedTextWME;
import abl.runtime.BehaviorWME;
import facade.characters.wmedef.BodyResourceWME;
import facade.characters.wmedef.PlayerUncoopWME;
import facade.characters.wmedef.ObjectRotationWME;
import facade.characters.wmedef.BeatC2TGGlueWME;
import facade.characters.wmedef.BeatRMp1WME;
import abl.runtime.ParallelBehaviorWME;
import facade.characters.wmedef.BeatFlagWME;
import facade.util.Staging;
import facade.util.Point3D;
import facade.characters.wmedef.ObjectPositionWME;
import facade.characters.wmedef.AnaphoricReferenceWME;
import facade.characters.wmedef.OneCharacterVisibleWME;
import facade.characters.wmedef.PhysicallyFavorWME;
import facade.characters.wmedef.PlayerGestureWME;
import facade.characters.wmedef.DAMiscStatusWME;
import facade.characters.wmedef.BeatGoalStatusWME;
import facade.characters.wmedef.ReactionWME;
import facade.characters.wmedef.DAWME;
import facade.characters.wmedef.ObjectActivationWME;
import facade.characters.wmedef.SignalWME;
import abl.runtime.__ValueTypes;
import abl.runtime.GoalStepWME;
import facade.characters.wmedef.BeatStatusWME;
import dramaman.runtime.StoryStatusWME;
import facade.characters.wmedef.PlayerInfoWME;
import wm.WorkingMemory;
import abl.runtime.BehavingEntity;
import facade.util.MusicDefs;
import facade.util.TherapyGameConstants;
import facade.util.CrisisAccusations;
import facade.util.BackstoryCategories;
import facade.util.EpisodicMemoryConstants;
import facade.util.BeatID;
import facade.util.BeatArguments;
import facade.util.PlayerGestureID;
import dramaman.runtime.DramaManagerConstants;
import facade.util.UniversalScript;
import facade.util.DAType;
import facade.util.ReactionConstants;
import facade.util.ReactionID;
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

public class Trip_SuccessTests implements GraceScript, TripScript, AnimLayer, FullExpressions, SpriteID, PoseScripts, GestureBodyPart, BodyResource, BeatStatus, BeatConstants, ReactionID, ReactionConstants, DAType, UniversalScript, DramaManagerConstants, PlayerGestureID, BeatArguments, BeatID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, TherapyGameConstants, MusicDefs
{
    public static boolean successTest0(final int n, final Object[] array, final BehavingEntity behavingEntity) {
        switch (n) {
            case 1: {
                final ListIterator listIterator = WorkingMemory.lookupWME("StoryMemory", "PlayerInfoWME").listIterator();
                if (!listIterator.hasNext()) {
                    return false;
                }
                final PlayerInfoWME playerInfoWME = listIterator.next();
                return true;
            }
            case 3: {
                final ListIterator listIterator2 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getCurrentBeat() == -1) {
                        return false;
                    }
                }
                return true;
            }
            case 21: {
                final ListIterator listIterator3 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator3.hasNext()) {
                    if (listIterator3.next().getStatus() == 5) {
                        return true;
                    }
                }
                return false;
            }
            case 31: {
                final ListIterator<GoalStepWME> listIterator4 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "LastBeatGoalForThisBeat()").listIterator();
                while (listIterator4.hasNext()) {
                    if (listIterator4.next().getSignature().equals("LastBeatGoalForThisBeat()")) {
                        return true;
                    }
                }
                return false;
            }
            case 32: {
                final ListIterator<GoalStepWME> listIterator5 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "LastBeatGoalForThisBeat()").listIterator();
                while (listIterator5.hasNext()) {
                    if (listIterator5.next().getSignature().equals("LastBeatGoalForThisBeat()")) {
                        return false;
                    }
                }
                return true;
            }
            case 38: {
                final ListIterator listIterator6 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator6.hasNext()) {
                    if (listIterator6.next().getCurrentBeat() != ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 55: {
                return !((GoalStepWME)array[0]).isValid();
            }
            case 68: {
                return !((GoalStepWME)array[1]).getIsExecuting();
            }
            case 73: {
                final ListIterator<GoalStepWME> listIterator7 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", (String)array[0]).listIterator();
                while (listIterator7.hasNext()) {
                    if (listIterator7.next().getSignature().equals(array[0])) {
                        return true;
                    }
                }
                return false;
            }
            case 74: {
                final ListIterator<GoalStepWME> listIterator8 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", (String)array[0]).listIterator();
                while (listIterator8.hasNext()) {
                    if (listIterator8.next().getSignature().equals(array[0])) {
                        return false;
                    }
                }
                return true;
            }
            case 87: {
                final ListIterator<GoalStepWME> listIterator9 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", (String)array[0]).listIterator();
                while (listIterator9.hasNext()) {
                    if (listIterator9.next().getSignature().equals(array[0])) {
                        return false;
                    }
                }
                return true;
            }
            case 100: {
                final ListIterator<GoalStepWME> listIterator10 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator10.hasNext()) {
                    final GoalStepWME goalStepWME = listIterator10.next();
                    final String signature;
                    if (goalStepWME.getProperty("isBeatGoal") != null && goalStepWME.getIsExecuting() && BehavingEntity.constantTrue(signature = goalStepWME.getSignature())) {
                        final ListIterator listIterator11 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                        while (listIterator11.hasNext()) {
                            final String curBGSig;
                            if (BehavingEntity.constantTrue(curBGSig = listIterator11.next().getCurBGSig()) && signature != curBGSig) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 108: {
                final ListIterator<GoalStepWME> listIterator12 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", (String)array[0]).listIterator();
                while (listIterator12.hasNext()) {
                    if (listIterator12.next().getSignature().equals(array[0])) {
                        return false;
                    }
                }
                return true;
            }
            case 110: {
                final ListIterator listIterator13 = WorkingMemory.lookupWME("GraceMemory", "SignalWME").listIterator();
                while (listIterator13.hasNext()) {
                    if (listIterator13.next().getName().equals(array[0])) {
                        return true;
                    }
                }
                return false;
            }
            case 130: {
                final ListIterator listIterator14 = BehavingEntity.getBehavingEntity().lookupWME("ObjectActivationWME").listIterator();
                while (listIterator14.hasNext()) {
                    final ObjectActivationWME objectActivationWME = listIterator14.next();
                    if (objectActivationWME.getObjectID() == 48 && objectActivationWME.getActivationID() == 4) {
                        return true;
                    }
                }
                return false;
            }
            case 152: {
                final ListIterator<GoalStepWME> listIterator15 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "TurnOffLocalPhysicallyFavorsWithTimeout(int, int)").listIterator();
                while (listIterator15.hasNext()) {
                    if (listIterator15.next().getSignature().equals("TurnOffLocalPhysicallyFavorsWithTimeout(int, int)")) {
                        return false;
                    }
                }
                return true;
            }
            case 162: {
                final ListIterator<GoalStepWME> listIterator16 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "TurnOffPhysicallyFavorsWithTimeout(int, int)").listIterator();
                while (listIterator16.hasNext()) {
                    if (listIterator16.next().getSignature().equals("TurnOffPhysicallyFavorsWithTimeout(int, int)")) {
                        return false;
                    }
                }
                return true;
            }
            case 171: {
                final ListIterator<GoalStepWME> listIterator17 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "TurnOffPhysicallyFavorsWithTimeout(int, int)").listIterator();
                while (listIterator17.hasNext()) {
                    if (listIterator17.next().getSignature().equals("TurnOffPhysicallyFavorsWithTimeout(int, int)")) {
                        return false;
                    }
                }
                return true;
            }
            case 177: {
                final ListIterator listIterator18 = BehavingEntity.getBehavingEntity().lookupWME("DAWME").listIterator();
                while (listIterator18.hasNext()) {
                    if (listIterator18.next().getHandledStatus() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 189: {
                final ListIterator listIterator19 = BehavingEntity.getBehavingEntity().lookupWME("ReactionWME").listIterator();
                if (!listIterator19.hasNext()) {
                    return false;
                }
                final ReactionWME reactionWME = listIterator19.next();
                return true;
            }
            case 214: {
                final ListIterator<GoalStepWME> listIterator20 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isMixinBeatGoal").listIterator();
                while (listIterator20.hasNext()) {
                    if (listIterator20.next().getProperty("isMixinBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 230: {
                final ListIterator<GoalStepWME> listIterator21 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator21.hasNext()) {
                    final GoalStepWME goalStepWME2 = listIterator21.next();
                    final String signature2;
                    if (BehavingEntity.constantTrue(signature2 = goalStepWME2.getSignature()) && goalStepWME2.getProperty("isBeatGoal") != null && goalStepWME2.getIsExecuting()) {
                        final ListIterator listIterator22 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                        while (listIterator22.hasNext()) {
                            final BeatGoalStatusWME beatGoalStatusWME = listIterator22.next();
                            if (beatGoalStatusWME.getBgSig().equals(signature2) && !beatGoalStatusWME.getBLetBeatGoalFinish()) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 231: {
                final ListIterator<GoalStepWME> listIterator23 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator23.hasNext()) {
                    final GoalStepWME goalStepWME3 = listIterator23.next();
                    if (goalStepWME3.getProperty("isBeatGoal") != null && goalStepWME3.getIsExecuting()) {
                        return false;
                    }
                }
                return true;
            }
            case 233: {
                final ListIterator listIterator24 = BehavingEntity.getBehavingEntity().lookupWME("DAWME").listIterator();
                while (listIterator24.hasNext()) {
                    final long timestamp;
                    if (BehavingEntity.constantTrue(timestamp = listIterator24.next().getTimestamp())) {
                        final ListIterator listIterator25 = WorkingMemory.lookupWME("BeatMemory", "DAMiscStatusWME").listIterator();
                        while (listIterator25.hasNext()) {
                            final DAMiscStatusWME daMiscStatusWME = listIterator25.next();
                            if (!daMiscStatusWME.getBHandlersActive() && daMiscStatusWME.getLastDAHandlersActiveCheck() < timestamp) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 238: {
                final ListIterator listIterator26 = BehavingEntity.getBehavingEntity().lookupWME("DAWME").listIterator();
                while (listIterator26.hasNext()) {
                    final long timestamp2;
                    if (BehavingEntity.constantTrue(timestamp2 = listIterator26.next().getTimestamp())) {
                        final ListIterator listIterator27 = WorkingMemory.lookupWME("BeatMemory", "DAMiscStatusWME").listIterator();
                        while (listIterator27.hasNext()) {
                            if (listIterator27.next().getLastDACommitCheck() < timestamp2) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 242: {
                final ListIterator listIterator28 = BehavingEntity.getBehavingEntity().lookupWME("PlayerGestureWME").listIterator();
                if (!listIterator28.hasNext()) {
                    return false;
                }
                final PlayerGestureWME playerGestureWME = listIterator28.next();
                return true;
            }
            case 244: {
                final ListIterator listIterator29 = WorkingMemory.lookupWME("BeatMemory", "PhysicallyFavorWME").listIterator();
                while (listIterator29.hasNext()) {
                    if (listIterator29.next().getFavoringCharID() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 260: {
                final ListIterator listIterator30 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                if (!listIterator30.hasNext()) {
                    return false;
                }
                final BeatStatusWME beatStatusWME = listIterator30.next();
                return true;
            }
            case 262: {
                final ListIterator listIterator31 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator31.hasNext()) {
                    final long nlpProcessingStarted;
                    if (BehavingEntity.constantTrue(nlpProcessingStarted = listIterator31.next().getNLPProcessingStarted()) && nlpProcessingStarted > 0L) {
                        return true;
                    }
                }
                return false;
            }
            case 263: {
                final ListIterator listIterator32 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator32.hasNext()) {
                    final long nlpProcessingStarted2;
                    if (BehavingEntity.constantTrue(nlpProcessingStarted2 = listIterator32.next().getNLPProcessingStarted()) && System.currentTimeMillis() > nlpProcessingStarted2 + 8000L) {
                        return true;
                    }
                }
                return false;
            }
            case 280: {
                final ListIterator listIterator33 = BehavingEntity.getBehavingEntity().lookupWME("PlayerGestureWME").listIterator();
                if (!listIterator33.hasNext()) {
                    return false;
                }
                final PlayerGestureWME playerGestureWME2 = listIterator33.next();
                return true;
            }
            case 282: {
                final ListIterator listIterator34 = BehavingEntity.getBehavingEntity().lookupWME("ObjectActivationWME").listIterator();
                while (listIterator34.hasNext()) {
                    final ObjectActivationWME objectActivationWME2 = listIterator34.next();
                    final int activationID;
                    final int objectID;
                    if (objectActivationWME2.getActivatorID() == 2 && BehavingEntity.constantTrue(activationID = objectActivationWME2.getActivationID()) && BehavingEntity.constantTrue(objectID = objectActivationWME2.getObjectID()) && (activationID == 0 || activationID == 1)) {
                        final __ValueTypes.IntVar intVar = (__ValueTypes.IntVar)array[0];
                        final int i = objectID;
                        intVar.i = i;
                        if (BehavingEntity.constantTrue(i)) {
                            return true;
                        }
                        continue;
                    }
                }
                return false;
            }
            case 286: {
                final ListIterator listIterator35 = WorkingMemory.lookupWME("BeatMemory", "OneCharacterVisibleWME").listIterator();
                while (listIterator35.hasNext()) {
                    final OneCharacterVisibleWME oneCharacterVisibleWME = listIterator35.next();
                    final __ValueTypes.IntVar intVar2 = (__ValueTypes.IntVar)array[0];
                    final int visibleCharID = oneCharacterVisibleWME.getVisibleCharID();
                    intVar2.i = visibleCharID;
                    if (BehavingEntity.constantTrue(visibleCharID)) {
                        final ListIterator listIterator36 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                        while (listIterator36.hasNext()) {
                            final AnaphoricReferenceWME anaphoricReferenceWME = listIterator36.next();
                            array[2] = anaphoricReferenceWME;
                            final __ValueTypes.IntVar intVar3 = (__ValueTypes.IntVar)array[1];
                            final int youRef = anaphoricReferenceWME.getYouRef();
                            intVar3.i = youRef;
                            if (BehavingEntity.constantTrue(youRef)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 292: {
                final ListIterator listIterator37 = WorkingMemory.lookupWME("BeatMemory", "OneCharacterVisibleWME").listIterator();
                if (!listIterator37.hasNext()) {
                    final ListIterator listIterator38 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                    while (listIterator38.hasNext()) {
                        final AnaphoricReferenceWME anaphoricReferenceWME2 = listIterator38.next();
                        array[2] = anaphoricReferenceWME2;
                        final __ValueTypes.IntVar intVar4 = (__ValueTypes.IntVar)array[0];
                        final int youRefNoOverride = anaphoricReferenceWME2.getYouRefNoOverride();
                        intVar4.i = youRefNoOverride;
                        if (BehavingEntity.constantTrue(youRefNoOverride)) {
                            final __ValueTypes.IntVar intVar5 = (__ValueTypes.IntVar)array[1];
                            final int youRefDefaultNoOverride = anaphoricReferenceWME2.getYouRefDefaultNoOverride();
                            intVar5.i = youRefDefaultNoOverride;
                            if (BehavingEntity.constantTrue(youRefDefaultNoOverride)) {
                                return true;
                            }
                            continue;
                        }
                    }
                    return false;
                }
                final OneCharacterVisibleWME oneCharacterVisibleWME2 = listIterator37.next();
                return false;
            }
            case 294: {
                final ListIterator listIterator39 = WorkingMemory.lookupWME("BeatMemory", "OneCharacterVisibleWME").listIterator();
                while (listIterator39.hasNext()) {
                    final OneCharacterVisibleWME oneCharacterVisibleWME3 = listIterator39.next();
                    if (oneCharacterVisibleWME3.getVisibleCharID() != ((__ValueTypes.IntVar)array[0]).i) {
                        final __ValueTypes.IntVar intVar6 = (__ValueTypes.IntVar)array[1];
                        final int visibleCharID2 = oneCharacterVisibleWME3.getVisibleCharID();
                        intVar6.i = visibleCharID2;
                        if (!BehavingEntity.constantTrue(visibleCharID2)) {
                            continue;
                        }
                        final ListIterator listIterator40 = WorkingMemory.lookupWME("StoryMemory", "AnaphoricReferenceWME").listIterator();
                        if (!listIterator40.hasNext()) {
                            continue;
                        }
                        array[2] = listIterator40.next();
                        return true;
                    }
                }
                return false;
            }
            case 365: {
                final ListIterator listIterator41 = BehavingEntity.getBehavingEntity().lookupWME("ObjectActivationWME").listIterator();
                while (listIterator41.hasNext()) {
                    final ObjectActivationWME objectActivationWME3 = listIterator41.next();
                    if (objectActivationWME3.getObjectID() == 47 && objectActivationWME3.getActivationID() == 4) {
                        return true;
                    }
                }
                return false;
            }
            case 425: {
                final ListIterator listIterator42 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator42.hasNext()) {
                    final ObjectPositionWME objectPositionWME = listIterator42.next();
                    if (objectPositionWME.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME.getZ() < 100.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 608: {
                final ListIterator<GoalStepWME> listIterator43 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isStagingGoal").listIterator();
                while (listIterator43.hasNext()) {
                    if (listIterator43.next().getProperty("isStagingGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 609: {
                final ListIterator listIterator44 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator44.hasNext()) {
                    final ObjectPositionWME objectPositionWME2 = listIterator44.next();
                    final float x;
                    final float z;
                    if (objectPositionWME2.getObjectID() == ((Trip)behavingEntity).player && BehavingEntity.constantTrue(x = objectPositionWME2.getX()) && BehavingEntity.constantTrue(z = objectPositionWME2.getZ())) {
                        final ListIterator listIterator45 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator45.hasNext()) {
                            final ObjectPositionWME objectPositionWME3 = listIterator45.next();
                            final float x2;
                            final float z2;
                            if (objectPositionWME3.getObjectID() == ((Trip)behavingEntity).me && BehavingEntity.constantTrue(x2 = objectPositionWME3.getX()) && BehavingEntity.constantTrue(z2 = objectPositionWME3.getZ()) && Staging.getXZDistanceBetweenPoints(new Point3D(x, 0.0f, z), new Point3D(x2, 0.0f, z2)) <= 100.0f) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 628: {
                final ListIterator listIterator46 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator46.hasNext()) {
                    final ObjectPositionWME objectPositionWME4 = listIterator46.next();
                    if (objectPositionWME4.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME4.getX() > -180.0f && objectPositionWME4.getZ() < 150.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 1089: {
                final ListIterator<GoalStepWME> listIterator47 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isStagingGoal").listIterator();
                while (listIterator47.hasNext()) {
                    if (listIterator47.next().getProperty("isStagingGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 1104: {
                final ListIterator<GoalStepWME> listIterator48 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isStagingGoal").listIterator();
                while (listIterator48.hasNext()) {
                    if (listIterator48.next().getProperty("isStagingGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 1118: {
                final ListIterator<GoalStepWME> listIterator49 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isStagingGoal").listIterator();
                while (listIterator49.hasNext()) {
                    if (listIterator49.next().getProperty("isStagingGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 1177: {
                final ListIterator listIterator50 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator50.hasNext()) {
                    final ObjectPositionWME objectPositionWME5 = listIterator50.next();
                    if (objectPositionWME5.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME5.getX() > 50.0f && objectPositionWME5.getZ() > 0.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 1178: {
                final ListIterator listIterator51 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator51.hasNext()) {
                    if (listIterator51.next().getSVal().equals("GreetingPlayerBargedIn")) {
                        return true;
                    }
                }
                return false;
            }
            case 1179: {
                final ListIterator listIterator52 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator52.hasNext()) {
                    final ObjectPositionWME objectPositionWME6 = listIterator52.next();
                    if (objectPositionWME6.getObjectID() == ((Trip)behavingEntity).trip && objectPositionWME6.getX() < -100.0f && objectPositionWME6.getZ() < 80.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 1483: {
                final ListIterator listIterator53 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator53.hasNext()) {
                    final ObjectPositionWME objectPositionWME7 = listIterator53.next();
                    final float x3;
                    final float z3;
                    if (objectPositionWME7.getObjectID() == ((Trip)behavingEntity).grace && BehavingEntity.constantTrue(x3 = objectPositionWME7.getX()) && BehavingEntity.constantTrue(z3 = objectPositionWME7.getZ())) {
                        final ListIterator listIterator54 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator54.hasNext()) {
                            final ObjectPositionWME objectPositionWME8 = listIterator54.next();
                            final float x4;
                            final float z4;
                            if (objectPositionWME8.getObjectID() == ((Trip)behavingEntity).player && BehavingEntity.constantTrue(x4 = objectPositionWME8.getX()) && BehavingEntity.constantTrue(z4 = objectPositionWME8.getZ()) && Staging.getXZDistanceBetweenPoints(x3, z3, x4, z4) < 50.0f) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 1485: {
                final ListIterator listIterator55 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator55.hasNext()) {
                    final ObjectPositionWME objectPositionWME9 = listIterator55.next();
                    final float x5;
                    final float z5;
                    if (objectPositionWME9.getObjectID() == ((Trip)behavingEntity).grace && BehavingEntity.constantTrue(x5 = objectPositionWME9.getX()) && BehavingEntity.constantTrue(z5 = objectPositionWME9.getZ())) {
                        final ListIterator listIterator56 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator56.hasNext()) {
                            final ObjectPositionWME objectPositionWME10 = listIterator56.next();
                            final float x6;
                            final float z6;
                            if (objectPositionWME10.getObjectID() == ((Trip)behavingEntity).player && BehavingEntity.constantTrue(x6 = objectPositionWME10.getX()) && BehavingEntity.constantTrue(z6 = objectPositionWME10.getZ()) && Staging.getXZDistanceBetweenPoints(x5, z5, x6, z6) > 50.0f) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 2561: {
                final ListIterator listIterator57 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator57.hasNext()) {
                    if (listIterator57.next().getSVal().equals("player picked up phone")) {
                        return true;
                    }
                }
                return false;
            }
            case 2664: {
                final ListIterator listIterator58 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator58.hasNext()) {
                    if (listIterator58.next().getSVal().equals("player picked up phone")) {
                        return true;
                    }
                }
                return false;
            }
            case 2839: {
                final ListIterator listIterator59 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator59.hasNext()) {
                    if (listIterator59.next().getSVal().equals("player picked up phone")) {
                        return true;
                    }
                }
                return false;
            }
            case 2841: {
                final ListIterator listIterator60 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator60.hasNext()) {
                    if (listIterator60.next().getSVal().equals("started leaving message")) {
                        return true;
                    }
                }
                return false;
            }
            case 2844: {
                final ListIterator listIterator61 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator61.hasNext()) {
                    if (listIterator61.next().getSVal().equals("answering machine outgoing message")) {
                        return true;
                    }
                }
                return false;
            }
            case 2933: {
                final ListIterator listIterator62 = BehavingEntity.getBehavingEntity().lookupWME("ObjectActivationWME").listIterator();
                while (listIterator62.hasNext()) {
                    final ObjectActivationWME objectActivationWME4 = listIterator62.next();
                    if (objectActivationWME4.getActivatorID() == 2 && objectActivationWME4.getObjectID() == 10 && objectActivationWME4.getActivationID() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 2946: {
                final ListIterator listIterator63 = BehavingEntity.getBehavingEntity().lookupWME("ObjectActivationWME").listIterator();
                while (listIterator63.hasNext()) {
                    final ObjectActivationWME objectActivationWME5 = listIterator63.next();
                    if (objectActivationWME5.getActivatorID() == 2 && objectActivationWME5.getObjectID() == 10 && objectActivationWME5.getActivationID() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 3004: {
                final ListIterator listIterator64 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator64.hasNext()) {
                    if (listIterator64.next().getSVal().equals("player picked up phone")) {
                        return true;
                    }
                }
                return false;
            }
            case 3095: {
                final ListIterator listIterator65 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator65.hasNext()) {
                    if (listIterator65.next().getSVal().equals("player picked up phone")) {
                        return true;
                    }
                }
                return false;
            }
            case 3256: {
                final ListIterator listIterator66 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator66.hasNext()) {
                    if (listIterator66.next().getSVal().equals("player picked up phone")) {
                        return true;
                    }
                }
                return false;
            }
            case 3258: {
                final ListIterator listIterator67 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator67.hasNext()) {
                    if (listIterator67.next().getSVal().equals("started leaving message")) {
                        return true;
                    }
                }
                return false;
            }
            case 3261: {
                final ListIterator listIterator68 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator68.hasNext()) {
                    if (listIterator68.next().getSVal().equals("answering machine outgoing message")) {
                        return true;
                    }
                }
                return false;
            }
            case 3344: {
                final ListIterator listIterator69 = BehavingEntity.getBehavingEntity().lookupWME("ObjectActivationWME").listIterator();
                while (listIterator69.hasNext()) {
                    final ObjectActivationWME objectActivationWME6 = listIterator69.next();
                    if (objectActivationWME6.getActivatorID() == 2 && objectActivationWME6.getObjectID() == 10 && objectActivationWME6.getActivationID() == 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3357: {
                final ListIterator listIterator70 = BehavingEntity.getBehavingEntity().lookupWME("ObjectActivationWME").listIterator();
                while (listIterator70.hasNext()) {
                    final ObjectActivationWME objectActivationWME7 = listIterator70.next();
                    if (objectActivationWME7.getActivatorID() == 2 && objectActivationWME7.getObjectID() == 10 && objectActivationWME7.getActivationID() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 3376: {
                final ListIterator<ParallelBehaviorWME> listIterator71 = (ListIterator<ParallelBehaviorWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("ParallelBehaviorWME", "BeatGoals_Body()").listIterator();
                while (listIterator71.hasNext()) {
                    if (listIterator71.next().getSignature().equals("BeatGoals_Body()")) {
                        return true;
                    }
                }
                return false;
            }
            case 3378: {
                final ListIterator listIterator72 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator72.hasNext()) {
                    if (listIterator72.next().getAffinity() != ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 3383: {
                final ListIterator listIterator73 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator73.hasNext()) {
                    final int affinity;
                    if (BehavingEntity.constantTrue(affinity = listIterator73.next().getAffinity()) && affinity <= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 3388: {
                final ListIterator listIterator74 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator74.hasNext()) {
                    final int affinity2;
                    if (BehavingEntity.constantTrue(affinity2 = listIterator74.next().getAffinity()) && affinity2 >= 0) {
                        return true;
                    }
                }
                return false;
            }
            case 6303: {
                final ListIterator listIterator75 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                while (listIterator75.hasNext()) {
                    final BeatGoalStatusWME beatGoalStatusWME2 = listIterator75.next();
                    if (beatGoalStatusWME2.getBgSig().equals(((Trip)behavingEntity).sig_bRMt1N_bgLurePlayer) && !beatGoalStatusWME2.getBLetBeatGoalFinish()) {
                        return true;
                    }
                }
                return false;
            }
            case 6536: {
                final ListIterator<GoalStepWME> listIterator76 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "bRMt1N_Demon_FirstGuessTimeout()").listIterator();
                while (listIterator76.hasNext()) {
                    if (listIterator76.next().getSignature().equals("bRMt1N_Demon_FirstGuessTimeout()")) {
                        return false;
                    }
                }
                return true;
            }
            case 6729: {
                final ListIterator listIterator77 = WorkingMemory.lookupWME("StoryMemory", "BeatRMp1WME").listIterator();
                while (listIterator77.hasNext()) {
                    final long tempMillis;
                    if (BehavingEntity.constantTrue(tempMillis = listIterator77.next().getTempMillis()) && System.currentTimeMillis() > tempMillis + 3000L) {
                        return true;
                    }
                }
                return false;
            }
            case 6773: {
                final ListIterator listIterator78 = WorkingMemory.lookupWME("StoryMemory", "BeatRMp1WME").listIterator();
                while (listIterator78.hasNext()) {
                    final long tempMillis2;
                    if (BehavingEntity.constantTrue(tempMillis2 = listIterator78.next().getTempMillis()) && System.currentTimeMillis() > tempMillis2 + 3000L) {
                        return true;
                    }
                }
                return false;
            }
            case 6956: {
                final ListIterator listIterator79 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                while (listIterator79.hasNext()) {
                    final BeatGoalStatusWME beatGoalStatusWME3 = listIterator79.next();
                    if (beatGoalStatusWME3.getBgSig().equals(((Trip)behavingEntity).sig_bRMt1GPA_bgLurePlayer) && !beatGoalStatusWME3.getBLetBeatGoalFinish()) {
                        return true;
                    }
                }
                return false;
            }
            case 7199: {
                final ListIterator<GoalStepWME> listIterator80 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "bRMt1GPA_Demon_FirstGuessTimeout()").listIterator();
                while (listIterator80.hasNext()) {
                    if (listIterator80.next().getSignature().equals("bRMt1GPA_Demon_FirstGuessTimeout()")) {
                        return false;
                    }
                }
                return true;
            }
            case 7598: {
                final ListIterator listIterator81 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                while (listIterator81.hasNext()) {
                    final BeatGoalStatusWME beatGoalStatusWME4 = listIterator81.next();
                    if (beatGoalStatusWME4.getBgSig().equals(((Trip)behavingEntity).sig_bRMt1TPA_bgLurePlayer) && !beatGoalStatusWME4.getBLetBeatGoalFinish()) {
                        return true;
                    }
                }
                return false;
            }
            case 7820: {
                final ListIterator<GoalStepWME> listIterator82 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "bRMt1TPA_Demon_FirstGuessTimeout()").listIterator();
                while (listIterator82.hasNext()) {
                    if (listIterator82.next().getSignature().equals("bRMt1TPA_Demon_FirstGuessTimeout()")) {
                        return false;
                    }
                }
                return true;
            }
            case 8025: {
                final ListIterator listIterator83 = WorkingMemory.lookupWME("StoryMemory", "BeatRMp1WME").listIterator();
                while (listIterator83.hasNext()) {
                    final long tempMillis3;
                    if (BehavingEntity.constantTrue(tempMillis3 = listIterator83.next().getTempMillis()) && System.currentTimeMillis() > tempMillis3 + 3000L) {
                        return true;
                    }
                }
                return false;
            }
            case 8061: {
                final ListIterator listIterator84 = WorkingMemory.lookupWME("StoryMemory", "BeatRMp1WME").listIterator();
                while (listIterator84.hasNext()) {
                    final long tempMillis4;
                    if (BehavingEntity.constantTrue(tempMillis4 = listIterator84.next().getTempMillis()) && System.currentTimeMillis() > tempMillis4 + 3000L) {
                        return true;
                    }
                }
                return false;
            }
            case 12013: {
                final ListIterator listIterator85 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                while (listIterator85.hasNext()) {
                    final BeatGoalStatusWME beatGoalStatusWME5 = listIterator85.next();
                    if (beatGoalStatusWME5.getBgSig().equals(((Trip)behavingEntity).sig_bRMt2GPA_bgLurePlayer) && !beatGoalStatusWME5.getBLetBeatGoalFinish()) {
                        return true;
                    }
                }
                return false;
            }
            case 12267: {
                final ListIterator<GoalStepWME> listIterator86 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "bRMt2GPA_Demon_FirstGuessTimeout()").listIterator();
                while (listIterator86.hasNext()) {
                    if (listIterator86.next().getSignature().equals("bRMt2GPA_Demon_FirstGuessTimeout()")) {
                        return false;
                    }
                }
                return true;
            }
            case 12602: {
                final ListIterator listIterator87 = WorkingMemory.lookupWME("BeatMemory", "BeatGoalStatusWME").listIterator();
                while (listIterator87.hasNext()) {
                    final BeatGoalStatusWME beatGoalStatusWME6 = listIterator87.next();
                    if (beatGoalStatusWME6.getBgSig().equals(((Trip)behavingEntity).sig_bRMt2TPA_bgLurePlayer) && !beatGoalStatusWME6.getBLetBeatGoalFinish()) {
                        return true;
                    }
                }
                return false;
            }
            case 12828: {
                final ListIterator<GoalStepWME> listIterator88 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "bRMt2TPA_Demon_FirstGuessTimeout()").listIterator();
                while (listIterator88.hasNext()) {
                    if (listIterator88.next().getSignature().equals("bRMt2TPA_Demon_FirstGuessTimeout()")) {
                        return false;
                    }
                }
                return true;
            }
            case 15464: {
                final ListIterator<GoalStepWME> listIterator89 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", ((Trip)behavingEntity).sig_bNonAffChrGReturnsT2_bgTxnIn_Veronica).listIterator();
                while (listIterator89.hasNext()) {
                    if (listIterator89.next().getSignature().equals(((Trip)behavingEntity).sig_bNonAffChrGReturnsT2_bgTxnIn_Veronica)) {
                        return true;
                    }
                }
                return false;
            }
            case 15466: {
                final ListIterator<GoalStepWME> listIterator90 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", ((Trip)behavingEntity).sig_bNonAffChrGReturnsT2_bgTxnIn_Veronica).listIterator();
                while (listIterator90.hasNext()) {
                    if (listIterator90.next().getSignature().equals(((Trip)behavingEntity).sig_bNonAffChrGReturnsT2_bgTxnIn_Veronica)) {
                        return false;
                    }
                }
                return true;
            }
            case 15470: {
                final ListIterator<GoalStepWME> listIterator91 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", ((Trip)behavingEntity).sig_bNonAffChrGReturnsT2_bgTxnIn_Veronica).listIterator();
                while (listIterator91.hasNext()) {
                    if (listIterator91.next().getSignature().equals(((Trip)behavingEntity).sig_bNonAffChrGReturnsT2_bgTxnIn_Veronica)) {
                        return true;
                    }
                }
                return false;
            }
            case 15473: {
                final ListIterator listIterator92 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator92.hasNext()) {
                    final ObjectPositionWME objectPositionWME11 = listIterator92.next();
                    if (objectPositionWME11.getObjectID() == 2 && objectPositionWME11.getZ() > 80.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 17582: {
                final ListIterator listIterator93 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator93.hasNext()) {
                    final ObjectPositionWME objectPositionWME12 = listIterator93.next();
                    if (objectPositionWME12.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME12.getX() < -150.0f && objectPositionWME12.getZ() > 50.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 17586: {
                final ListIterator listIterator94 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator94.hasNext()) {
                    final ObjectPositionWME objectPositionWME13 = listIterator94.next();
                    if (objectPositionWME13.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME13.getX() > 0.0f && objectPositionWME13.getZ() > 215.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 17599: {
                final ListIterator listIterator95 = WorkingMemory.lookupWME("StoryMemory", "BeatC2TGGlueWME").listIterator();
                while (listIterator95.hasNext()) {
                    if (listIterator95.next().getBSwitchedToKitchen()) {
                        return true;
                    }
                }
                return false;
            }
            case 17601: {
                final ListIterator listIterator96 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator96.hasNext()) {
                    final ObjectPositionWME objectPositionWME14 = listIterator96.next();
                    if (objectPositionWME14.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME14.getX() > 50.0f && objectPositionWME14.getZ() < 175.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 19279: {
                final ListIterator<GoalStepWME> listIterator97 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator97.hasNext()) {
                    final GoalStepWME goalStepWME4 = listIterator97.next();
                    if (goalStepWME4.getProperty("isBeatGoal") != null && goalStepWME4.getIsExecuting() && goalStepWME4.getSignature().equals(((Trip)behavingEntity).sig_bRevBuildupP2_bgBody4a)) {
                        return true;
                    }
                }
                return false;
            }
            case 19280: {
                final ListIterator<GoalStepWME> listIterator98 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator98.hasNext()) {
                    final GoalStepWME goalStepWME5 = listIterator98.next();
                    if (goalStepWME5.getProperty("isBeatGoal") != null && goalStepWME5.getIsExecuting() && goalStepWME5.getSignature().equals(((Trip)behavingEntity).sig_bRevBuildupP2_bgBody4a)) {
                        return false;
                    }
                }
                return true;
            }
            case 19304: {
                final ListIterator<GoalStepWME> listIterator99 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator99.hasNext()) {
                    final GoalStepWME goalStepWME6 = listIterator99.next();
                    if (goalStepWME6.getProperty("isBeatGoal") != null && goalStepWME6.getIsExecuting() && goalStepWME6.getSignature().equals(((Trip)behavingEntity).sig_bRevBuildupP2_bgBody4b)) {
                        return true;
                    }
                }
                return false;
            }
            case 19305: {
                final ListIterator<GoalStepWME> listIterator100 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator100.hasNext()) {
                    final GoalStepWME goalStepWME7 = listIterator100.next();
                    if (goalStepWME7.getProperty("isBeatGoal") != null && goalStepWME7.getIsExecuting() && goalStepWME7.getSignature().equals(((Trip)behavingEntity).sig_bRevBuildupP2_bgBody4b)) {
                        return false;
                    }
                }
                return true;
            }
            case 19318: {
                final ListIterator<GoalStepWME> listIterator101 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator101.hasNext()) {
                    final GoalStepWME goalStepWME8 = listIterator101.next();
                    if (goalStepWME8.getProperty("isBeatGoal") != null && goalStepWME8.getIsExecuting() && goalStepWME8.getSignature().equals(((Trip)behavingEntity).sig_bRevBuildupP2_bgBody4_mixin)) {
                        return false;
                    }
                }
                return true;
            }
            case 19322: {
                final ListIterator<GoalStepWME> listIterator102 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator102.hasNext()) {
                    final GoalStepWME goalStepWME9 = listIterator102.next();
                    if (goalStepWME9.getProperty("isBeatGoal") != null && goalStepWME9.getIsExecuting() && goalStepWME9.getSignature().equals(((Trip)behavingEntity).sig_bRevBuildupP2_bgLitany)) {
                        return true;
                    }
                }
                return false;
            }
            case 19323: {
                final ListIterator<GoalStepWME> listIterator103 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator103.hasNext()) {
                    final GoalStepWME goalStepWME10 = listIterator103.next();
                    if (goalStepWME10.getProperty("isBeatGoal") != null && goalStepWME10.getIsExecuting() && goalStepWME10.getSignature().equals(((Trip)behavingEntity).sig_bRevBuildupP2_bgLitany)) {
                        return false;
                    }
                }
                return true;
            }
            case 20581: {
                final ListIterator listIterator104 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator104.hasNext()) {
                    final ObjectPositionWME objectPositionWME15 = listIterator104.next();
                    if (objectPositionWME15.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME15.getX() < -150.0f && objectPositionWME15.getZ() > 50.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 20585: {
                final ListIterator listIterator105 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator105.hasNext()) {
                    final ObjectPositionWME objectPositionWME16 = listIterator105.next();
                    if (objectPositionWME16.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME16.getX() > 0.0f && objectPositionWME16.getZ() > 215.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 20620: {
                final ListIterator listIterator106 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                while (listIterator106.hasNext()) {
                    final ObjectRotationWME objectRotationWME = listIterator106.next();
                    if (objectRotationWME.getObjectID() == 47 && objectRotationWME.getY() <= 0.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 20622: {
                final ListIterator listIterator107 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                while (listIterator107.hasNext()) {
                    final ObjectRotationWME objectRotationWME2 = listIterator107.next();
                    if (objectRotationWME2.getObjectID() == 47 && objectRotationWME2.getY() > 25.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 20967: {
                final ListIterator listIterator108 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator108.hasNext()) {
                    final ObjectPositionWME objectPositionWME17 = listIterator108.next();
                    if (objectPositionWME17.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME17.getX() < -150.0f && objectPositionWME17.getZ() > 50.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 20971: {
                final ListIterator listIterator109 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator109.hasNext()) {
                    final ObjectPositionWME objectPositionWME18 = listIterator109.next();
                    if (objectPositionWME18.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME18.getX() > 0.0f && objectPositionWME18.getZ() > 215.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 21045: {
                final ListIterator listIterator110 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                while (listIterator110.hasNext()) {
                    final ObjectRotationWME objectRotationWME3 = listIterator110.next();
                    if (objectRotationWME3.getObjectID() == 47 && objectRotationWME3.getY() <= 0.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 21047: {
                final ListIterator listIterator111 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                while (listIterator111.hasNext()) {
                    final ObjectRotationWME objectRotationWME4 = listIterator111.next();
                    if (objectRotationWME4.getObjectID() == 47 && objectRotationWME4.getY() <= -60.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 21051: {
                final ListIterator listIterator112 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator112.hasNext()) {
                    if (listIterator112.next().getBLeavingApartment()) {
                        return true;
                    }
                }
                return false;
            }
            case 21449: {
                final ListIterator listIterator113 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator113.hasNext()) {
                    final ObjectPositionWME objectPositionWME19 = listIterator113.next();
                    if (objectPositionWME19.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME19.getX() < -150.0f && objectPositionWME19.getZ() > 50.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 21453: {
                final ListIterator listIterator114 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator114.hasNext()) {
                    final ObjectPositionWME objectPositionWME20 = listIterator114.next();
                    if (objectPositionWME20.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME20.getX() > 0.0f && objectPositionWME20.getZ() > 215.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 21658: {
                final ListIterator listIterator115 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator115.hasNext()) {
                    final ObjectPositionWME objectPositionWME21 = listIterator115.next();
                    if (objectPositionWME21.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME21.getX() < -150.0f && objectPositionWME21.getZ() > 50.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 21662: {
                final ListIterator listIterator116 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator116.hasNext()) {
                    final ObjectPositionWME objectPositionWME22 = listIterator116.next();
                    if (objectPositionWME22.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME22.getX() > 0.0f && objectPositionWME22.getZ() > 215.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 21862: {
                final ListIterator listIterator117 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator117.hasNext()) {
                    final ObjectPositionWME objectPositionWME23 = listIterator117.next();
                    if (objectPositionWME23.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME23.getX() < -150.0f && objectPositionWME23.getZ() > 50.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 21866: {
                final ListIterator listIterator118 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator118.hasNext()) {
                    final ObjectPositionWME objectPositionWME24 = listIterator118.next();
                    if (objectPositionWME24.getObjectID() == ((Trip)behavingEntity).player && objectPositionWME24.getX() > 0.0f && objectPositionWME24.getZ() > 215.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 22202: {
                final ListIterator<GoalStepWME> listIterator119 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", (String)array[0]).listIterator();
                while (listIterator119.hasNext()) {
                    if (listIterator119.next().getSignature().equals(array[0])) {
                        return false;
                    }
                }
                return true;
            }
            case 26614: {
                final ListIterator listIterator120 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator120.hasNext()) {
                    final ObjectPositionWME objectPositionWME25 = listIterator120.next();
                    final float x7;
                    final float z7;
                    if (objectPositionWME25.getObjectID() == ((Trip)behavingEntity).me && BehavingEntity.constantTrue(x7 = objectPositionWME25.getX()) && BehavingEntity.constantTrue(z7 = objectPositionWME25.getZ())) {
                        final ListIterator listIterator121 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator121.hasNext()) {
                            final ObjectRotationWME objectRotationWME5 = listIterator121.next();
                            final float y;
                            if (objectRotationWME5.getObjectID() == ((Trip)behavingEntity).me && BehavingEntity.constantTrue(y = objectRotationWME5.getY())) {
                                final ListIterator listIterator122 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator122.hasNext()) {
                                    final ObjectPositionWME objectPositionWME26 = listIterator122.next();
                                    final float x8;
                                    final float z8;
                                    if (objectPositionWME26.getObjectID() == 47 && BehavingEntity.constantTrue(x8 = objectPositionWME26.getX()) && BehavingEntity.constantTrue(z8 = objectPositionWME26.getZ()) && Staging.isPointWithinCharCone(x8, z8, x7, z7, y, 60.0f, 0.0f, 80.0f)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 31243: {
                final ListIterator listIterator123 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator123.hasNext()) {
                    final BodyResourceWME bodyResourceWME = listIterator123.next();
                    if (bodyResourceWME.getResourceID() == ((__ValueTypes.IntVar)array[0]).i && bodyResourceWME.getOwner() != null) {
                        return true;
                    }
                }
                return false;
            }
            case 31247: {
                final ListIterator<GoalStepWME> listIterator124 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "resourceOwner").listIterator();
                while (listIterator124.hasNext()) {
                    if (listIterator124.next().getProperty("resourceOwner") == array[1]) {
                        return false;
                    }
                }
                return true;
            }
            case 31275: {
                final ListIterator listIterator125 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator125.hasNext()) {
                    final BodyResourceWME bodyResourceWME2 = listIterator125.next();
                    final int resourcePriority;
                    final BehaviorWME owner;
                    if (bodyResourceWME2.getResourceID() == ((__ValueTypes.IntVar)array[0]).i && BehavingEntity.constantTrue(resourcePriority = bodyResourceWME2.getResourcePriority()) && BehavingEntity.constantTrue(owner = bodyResourceWME2.getOwner()) && (owner == null || resourcePriority <= ((__ValueTypes.IntVar)array[1]).i)) {
                        return true;
                    }
                }
                return false;
            }
            case 31290: {
                final ListIterator listIterator126 = WorkingMemory.lookupWME("PlayerMemory", "PlayerRecentlyTypedTextWME").listIterator();
                while (listIterator126.hasNext()) {
                    final PlayerRecentlyTypedTextWME playerRecentlyTypedTextWME = listIterator126.next();
                    final long timestamp3;
                    if (playerRecentlyTypedTextWME.getB() && BehavingEntity.constantTrue(timestamp3 = playerRecentlyTypedTextWME.getTimestamp()) && System.currentTimeMillis() < timestamp3 + 1000L) {
                        return true;
                    }
                }
                return false;
            }
            case 31625: {
                return System.currentTimeMillis() > ((MoodWME)array[1]).getDecayAtMillis();
            }
            case 31627: {
                return System.currentTimeMillis() > ((MoodWME)array[1]).getBurstDecayAtMillis();
            }
            case 31717: {
                final ListIterator listIterator127 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator127.hasNext()) {
                    if (listIterator127.next().getBurstDecay() == 0.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 31777: {
                final ListIterator listIterator128 = WorkingMemory.lookupWME("PlayerMemory", "PlayerRecentlyTypedTextWME").listIterator();
                while (listIterator128.hasNext()) {
                    if (!listIterator128.next().getB()) {
                        return true;
                    }
                }
                return false;
            }
            case 31779: {
                return ((StoryStatusWME)array[0]).getNLPProcessingStarted() == 0L;
            }
            case 31825: {
                final ListIterator listIterator129 = BehavingEntity.getBehavingEntity().lookupWME("AnimationCueWME").listIterator();
                while (listIterator129.hasNext()) {
                    final AnimationCueWME animationCueWME = listIterator129.next();
                    if (animationCueWME.getLayerIndex() == ((__ValueTypes.IntVar)array[0]).i && animationCueWME.getCue() == ((__ValueTypes.IntVar)array[1]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 31829: {
                final ListIterator listIterator130 = BehavingEntity.getBehavingEntity().lookupWME("AnimationCueWME").listIterator();
                while (listIterator130.hasNext()) {
                    final AnimationCueWME animationCueWME2 = listIterator130.next();
                    if (animationCueWME2.getLayerIndex() == 7 && animationCueWME2.getCue() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 31834: {
                final ListIterator listIterator131 = BehavingEntity.getBehavingEntity().lookupWME("AnimationCueWME").listIterator();
                while (listIterator131.hasNext()) {
                    final AnimationCueWME animationCueWME3 = listIterator131.next();
                    if (animationCueWME3.getLayerIndex() == 7 && animationCueWME3.getCue() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 31839: {
                final ListIterator listIterator132 = BehavingEntity.getBehavingEntity().lookupWME("AnimationCueWME").listIterator();
                while (listIterator132.hasNext()) {
                    final AnimationCueWME animationCueWME4 = listIterator132.next();
                    if (animationCueWME4.getLayerIndex() == 7 && animationCueWME4.getCue() == 5) {
                        return true;
                    }
                }
                return false;
            }
            case 31846: {
                final ListIterator<GoalStepWME> listIterator133 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator133.hasNext()) {
                    if (listIterator133.next().getProperty("isDoDialogBody") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 31850: {
                final ListIterator listIterator134 = BehavingEntity.getBehavingEntity().lookupWME("AnimationCueWME").listIterator();
                while (listIterator134.hasNext()) {
                    final AnimationCueWME animationCueWME5 = listIterator134.next();
                    if (animationCueWME5.getLayerIndex() == 7 && animationCueWME5.getCue() == 4) {
                        return true;
                    }
                }
                return false;
            }
            case 31855: {
                final ListIterator<GoalStepWME> listIterator135 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator135.hasNext()) {
                    if (listIterator135.next().getProperty("isDoDialogBody") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 31861: {
                final ListIterator listIterator136 = WorkingMemory.lookupWME("GraceMemory", "AnimationCueWME").listIterator();
                while (listIterator136.hasNext()) {
                    final AnimationCueWME animationCueWME6 = listIterator136.next();
                    if (animationCueWME6.getLayerIndex() == 7 && animationCueWME6.getCue() == ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 31862: {
                final ListIterator listIterator137 = WorkingMemory.lookupWME("TripMemory", "AnimationCueWME").listIterator();
                while (listIterator137.hasNext()) {
                    final AnimationCueWME animationCueWME7 = listIterator137.next();
                    if (animationCueWME7.getLayerIndex() == 7 && animationCueWME7.getCue() == ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 31873: {
                final ListIterator<GoalStepWME> listIterator138 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("GraceMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator138.hasNext()) {
                    if (listIterator138.next().getProperty("isDoDialogBody") != null) {
                        return true;
                    }
                }
                return false;
            }
            case 31875: {
                final ListIterator<GoalStepWME> listIterator139 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("GraceMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator139.hasNext()) {
                    if (listIterator139.next().getProperty("isDoDialogBody") != null) {
                        return true;
                    }
                }
                return false;
            }
            case 31877: {
                final ListIterator<GoalStepWME> listIterator140 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator140.hasNext()) {
                    if (listIterator140.next().getProperty("isDoDialogBody") != null) {
                        return true;
                    }
                }
                return false;
            }
            case 31879: {
                final ListIterator<GoalStepWME> listIterator141 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator141.hasNext()) {
                    if (listIterator141.next().getProperty("isDoDialogBody") != null) {
                        return true;
                    }
                }
                return false;
            }
            case 31881: {
                final ListIterator<GoalStepWME> listIterator142 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("GraceMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator142.hasNext()) {
                    if (listIterator142.next().getProperty("isDoDialogBody") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 31882: {
                final ListIterator<GoalStepWME> listIterator143 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator143.hasNext()) {
                    if (listIterator143.next().getProperty("isDoDialogBody") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 32009: {
                final ListIterator listIterator144 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator144.hasNext()) {
                    final HeldObjectWME heldObjectWME = listIterator144.next();
                    if (heldObjectWME.getCharacterID() == ((Trip)behavingEntity).me && heldObjectWME.getAttachPointID() == ((Trip)behavingEntity).g_objHand) {
                        return false;
                    }
                }
                return true;
            }
            case 32033: {
                final ListIterator listIterator145 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator145.hasNext()) {
                    final HeldObjectWME heldObjectWME2 = listIterator145.next();
                    if (heldObjectWME2.getCharacterID() == ((Trip)behavingEntity).me && heldObjectWME2.getAttachPointID() == ((Trip)behavingEntity).g_objHand) {
                        return true;
                    }
                }
                return false;
            }
            case 32077: {
                final ListIterator listIterator146 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator146.hasNext()) {
                    final ObjectPositionWME objectPositionWME27 = listIterator146.next();
                    final float x9;
                    final float z9;
                    if (objectPositionWME27.getObjectID() == ((Trip)behavingEntity).me && BehavingEntity.constantTrue(x9 = objectPositionWME27.getX()) && BehavingEntity.constantTrue(z9 = objectPositionWME27.getZ())) {
                        final ListIterator listIterator147 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator147.hasNext()) {
                            final ObjectPositionWME objectPositionWME28 = listIterator147.next();
                            final float x10;
                            final float z10;
                            if (objectPositionWME28.getObjectID() == ((Trip)behavingEntity).player && BehavingEntity.constantTrue(x10 = objectPositionWME28.getX()) && BehavingEntity.constantTrue(z10 = objectPositionWME28.getZ())) {
                                final ListIterator listIterator148 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                                while (listIterator148.hasNext()) {
                                    final ObjectRotationWME objectRotationWME6 = listIterator148.next();
                                    final float y2;
                                    if (objectRotationWME6.getObjectID() == ((Trip)behavingEntity).player && BehavingEntity.constantTrue(y2 = objectRotationWME6.getY()) && !Staging.isPointWithinCharCone(x9, z9, x10, z10, y2, 90.0f, 0.0f, 9999.0f) && Staging.getXZDistanceBetweenPoints(x9, z9, x10, z10) < 200.0f) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 32095: {
                final ListIterator listIterator149 = BehavingEntity.getBehavingEntity().lookupWME("StagingInfoWME").listIterator();
                while (listIterator149.hasNext()) {
                    final boolean bObjMovedFromOrig;
                    if (BehavingEntity.constantTrue(bObjMovedFromOrig = listIterator149.next().getBObjMovedFromOrig())) {
                        final ListIterator listIterator150 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator150.hasNext()) {
                            final ObjectPositionWME objectPositionWME29 = listIterator150.next();
                            final float x11;
                            final float z11;
                            if (objectPositionWME29.getObjectID() == ((Trip)behavingEntity).me && BehavingEntity.constantTrue(x11 = objectPositionWME29.getX()) && BehavingEntity.constantTrue(z11 = objectPositionWME29.getZ())) {
                                final ListIterator listIterator151 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator151.hasNext()) {
                                    final ObjectPositionWME objectPositionWME30 = listIterator151.next();
                                    final float x12;
                                    final float z12;
                                    if (objectPositionWME30.getObjectID() == ((Trip)behavingEntity).player && BehavingEntity.constantTrue(x12 = objectPositionWME30.getX()) && BehavingEntity.constantTrue(z12 = objectPositionWME30.getZ())) {
                                        final __ValueTypes.FloatVar floatVar = (__ValueTypes.FloatVar)array[1];
                                        final float xzDistanceBetweenPoints = Staging.getXZDistanceBetweenPoints(x11, z11, x12, z12);
                                        floatVar.f = xzDistanceBetweenPoints;
                                        if (!BehavingEntity.constantTrue(xzDistanceBetweenPoints)) {
                                            continue;
                                        }
                                        final __ValueTypes.FloatVar floatVar2 = (__ValueTypes.FloatVar)array[2];
                                        final float xzDistanceBetweenPoints2 = Staging.getXZDistanceBetweenPoints(x11, z11, ((__ValueTypes.FloatVar)array[5]).f, ((__ValueTypes.FloatVar)array[4]).f);
                                        floatVar2.f = xzDistanceBetweenPoints2;
                                        if (BehavingEntity.constantTrue(xzDistanceBetweenPoints2) && !((__ValueTypes.BooleanVar)array[0]).b && bObjMovedFromOrig && (((__ValueTypes.FloatVar)array[1]).f <= 150.0f || ((__ValueTypes.FloatVar)array[2]).f <= 150.0f)) {
                                            return true;
                                        }
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 32096: {
                final ListIterator listIterator152 = WorkingMemory.lookupWME("PlayerMemory", "IsPlayerTranslatingOrRotatingWME").listIterator();
                while (listIterator152.hasNext()) {
                    if (listIterator152.next().getB()) {
                        return true;
                    }
                }
                return false;
            }
            case 32174: {
                return System.currentTimeMillis() > ((__ValueTypes.LongVar)array[1]).l;
            }
            case 32181: {
                return System.currentTimeMillis() > ((__ValueTypes.LongVar)array[3]).l;
            }
            case 32195: {
                final ListIterator listIterator153 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                while (listIterator153.hasNext()) {
                    final ObjectRotationWME objectRotationWME7 = listIterator153.next();
                    if (objectRotationWME7.getObjectID() == 47 && objectRotationWME7.getY() <= ((__ValueTypes.IntVar)array[1]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 32344: {
                final ListIterator listIterator154 = BehavingEntity.getBehavingEntity().lookupWME("UserTestWME").listIterator();
                while (listIterator154.hasNext()) {
                    if (listIterator154.next().getParam1() != -1) {
                        return true;
                    }
                }
                return false;
            }
            case 32537: {
                final ListIterator listIterator155 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator155.hasNext()) {
                    if (listIterator155.next().getBeatCountOfLastGreetingBeat() > 0) {
                        return true;
                    }
                }
                return false;
            }
            case 32542: {
                final ListIterator listIterator156 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator156.hasNext()) {
                    if (listIterator156.next().getStatus() == 4) {
                        return true;
                    }
                }
                return false;
            }
            case 32545: {
                final ListIterator listIterator157 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator157.hasNext()) {
                    if (listIterator157.next().getStatus() != 4) {
                        return true;
                    }
                }
                return false;
            }
            case 32549: {
                final ListIterator listIterator158 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator158.hasNext()) {
                    if (listIterator158.next().getStatus() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 32558: {
                final ListIterator<GoalStepWME> listIterator159 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator159.hasNext()) {
                    final GoalStepWME goalStepWME11 = listIterator159.next();
                    if (goalStepWME11.getProperty("isBeatGoal") != null && goalStepWME11.getProperty("isAmbSafe") != null && goalStepWME11.getIsExecuting()) {
                        return true;
                    }
                }
                return false;
            }
            case 32563: {
                final ListIterator<GoalStepWME> listIterator160 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", (String)array[0]).listIterator();
                while (listIterator160.hasNext()) {
                    if (listIterator160.next().getSignature().equals(array[0])) {
                        return false;
                    }
                }
                return true;
            }
            case 32564: {
                final ListIterator listIterator161 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator161.hasNext()) {
                    if (listIterator161.next().getStatus() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 32571: {
                final ListIterator listIterator162 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator162.hasNext()) {
                    if (listIterator162.next().getStatus() == 4) {
                        return true;
                    }
                }
                return false;
            }
            case 32574: {
                final ListIterator listIterator163 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator163.hasNext()) {
                    if (listIterator163.next().getStatus() != 4) {
                        return true;
                    }
                }
                return false;
            }
            case 32581: {
                final ListIterator listIterator164 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator164.hasNext()) {
                    if (listIterator164.next().getStatus() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 32593: {
                final ListIterator<GoalStepWME> listIterator165 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator165.hasNext()) {
                    final GoalStepWME goalStepWME12 = listIterator165.next();
                    if (goalStepWME12.getProperty("isBeatGoal") != null && goalStepWME12.getProperty("isAmbSafe") != null && goalStepWME12.getIsExecuting()) {
                        return true;
                    }
                }
                return false;
            }
            case 32607: {
                final ListIterator<GoalStepWME> listIterator166 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", (String)array[1]).listIterator();
                while (listIterator166.hasNext()) {
                    if (listIterator166.next().getSignature().equals(array[1])) {
                        return false;
                    }
                }
                return true;
            }
            case 32608: {
                final ListIterator listIterator167 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator167.hasNext()) {
                    if (listIterator167.next().getStatus() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 32615: {
                final ListIterator listIterator168 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator168.hasNext()) {
                    if (listIterator168.next().getStatus() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 32617: {
                final ListIterator<GoalStepWME> listIterator169 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator169.hasNext()) {
                    final GoalStepWME goalStepWME13 = listIterator169.next();
                    if (goalStepWME13.getProperty("isBeatGoal") != null && goalStepWME13.getProperty("isAmbSafe") != null && goalStepWME13.getIsExecuting()) {
                        return true;
                    }
                }
                return false;
            }
            case 32620: {
                final ListIterator<GoalStepWME> listIterator170 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator170.hasNext()) {
                    final GoalStepWME goalStepWME14 = listIterator170.next();
                    if (goalStepWME14.getProperty("isBeatGoal") != null && goalStepWME14.getProperty("isAmbSafe") != null && goalStepWME14.getIsExecuting()) {
                        return false;
                    }
                }
                return true;
            }
            case 32623: {
                final ListIterator listIterator171 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator171.hasNext()) {
                    if (listIterator171.next().getSVal().equals("ReadyToDecideToDoFixdrinkoptAmb")) {
                        return true;
                    }
                }
                return false;
            }
            case 32628: {
                final ListIterator listIterator172 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator172.hasNext()) {
                    if (listIterator172.next().getStatus() == 4) {
                        return true;
                    }
                }
                return false;
            }
            case 32634: {
                final ListIterator listIterator173 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator173.hasNext()) {
                    if (listIterator173.next().getStatus() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 32641: {
                final ListIterator<GoalStepWME> listIterator174 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator174.hasNext()) {
                    final GoalStepWME goalStepWME15 = listIterator174.next();
                    if (goalStepWME15.getProperty("isBeatGoal") != null && goalStepWME15.getIsExecuting()) {
                        return true;
                    }
                }
                return false;
            }
            case 32642: {
                final ListIterator<GoalStepWME> listIterator175 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator175.hasNext()) {
                    final GoalStepWME goalStepWME16 = listIterator175.next();
                    if (goalStepWME16.getProperty("isBeatGoal") != null && goalStepWME16.getIsExecuting()) {
                        return false;
                    }
                }
                return true;
            }
            case 32643: {
                final ListIterator<GoalStepWME> listIterator176 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator176.hasNext()) {
                    final GoalStepWME goalStepWME17 = listIterator176.next();
                    if (goalStepWME17.getProperty("isBeatGoal") != null && goalStepWME17.getIsExecuting()) {
                        return true;
                    }
                }
                return false;
            }
            case 32652: {
                final ListIterator listIterator177 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator177.hasNext()) {
                    if (listIterator177.next().getStatus() == 4) {
                        return true;
                    }
                }
                return false;
            }
            case 32655: {
                final ListIterator listIterator178 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator178.hasNext()) {
                    if (listIterator178.next().getStatus() != 4) {
                        return true;
                    }
                }
                return false;
            }
            case 32659: {
                final ListIterator listIterator179 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator179.hasNext()) {
                    if (listIterator179.next().getStatus() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 32662: {
                final ListIterator listIterator180 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator180.hasNext()) {
                    if (listIterator180.next().getStatus() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 32672: {
                final ListIterator listIterator181 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator181.hasNext()) {
                    if (listIterator181.next().getStatus() == 2) {
                        return true;
                    }
                }
                return false;
            }
            case 32675: {
                final ListIterator listIterator182 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator182.hasNext()) {
                    if (listIterator182.next().getStatus() != 2) {
                        return true;
                    }
                }
                return false;
            }
            case 33044: {
                final ListIterator<GoalStepWME> listIterator183 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "Global_bgMixin_LTBFixDrink_GraceDrinkReady()").listIterator();
                while (listIterator183.hasNext()) {
                    if (listIterator183.next().getSignature().equals("Global_bgMixin_LTBFixDrink_GraceDrinkReady()")) {
                        return false;
                    }
                }
                return true;
            }
            case 33055: {
                final ListIterator<GoalStepWME> listIterator184 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator184.hasNext()) {
                    final GoalStepWME goalStepWME18 = listIterator184.next();
                    if (goalStepWME18.getProperty("isBeatGoal") != null && goalStepWME18.getIsExecuting()) {
                        return false;
                    }
                }
                return true;
            }
            case 33234: {
                final ListIterator<GoalStepWME> listIterator185 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator185.hasNext()) {
                    final GoalStepWME goalStepWME19 = listIterator185.next();
                    if (goalStepWME19.getProperty("isBeatGoal") != null && goalStepWME19.getIsExecuting()) {
                        return false;
                    }
                }
                return true;
            }
            case 33273: {
                final ListIterator<GoalStepWME> listIterator186 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isBeatGoal").listIterator();
                while (listIterator186.hasNext()) {
                    final GoalStepWME goalStepWME20 = listIterator186.next();
                    if (goalStepWME20.getProperty("isBeatGoal") != null && goalStepWME20.getIsExecuting()) {
                        return false;
                    }
                }
                return true;
            }
            case 33388: {
                final ListIterator listIterator187 = WorkingMemory.lookupWME("PlayerMemory", "PlayerRecentlyTypedTextWME").listIterator();
                while (listIterator187.hasNext()) {
                    if (listIterator187.next().getB()) {
                        return true;
                    }
                }
                return false;
            }
            case 33412: {
                final ListIterator listIterator188 = WorkingMemory.lookupWME("StoryMemory", "TensionStoryValueWME").listIterator();
                while (listIterator188.hasNext()) {
                    if (listIterator188.next().getValue() == 1.0f) {
                        final ListIterator listIterator189 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                        while (listIterator189.hasNext()) {
                            if (listIterator189.next().getAffinity() != 0) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 33413: {
                final ListIterator listIterator190 = WorkingMemory.lookupWME("StoryMemory", "TensionStoryValueWME").listIterator();
                while (listIterator190.hasNext()) {
                    if (listIterator190.next().getValue() == 1.0f) {
                        final ListIterator listIterator191 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                        while (listIterator191.hasNext()) {
                            final StoryStatusWME storyStatusWME = listIterator191.next();
                            if (storyStatusWME.getBeatCountOfLastGreetingBeat() == 4 && storyStatusWME.getBeatCount() == 6) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 33414: {
                final ListIterator listIterator192 = WorkingMemory.lookupWME("StoryMemory", "TensionStoryValueWME").listIterator();
                while (listIterator192.hasNext()) {
                    if (listIterator192.next().getValue() == 1.0f) {
                        final ListIterator listIterator193 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                        while (listIterator193.hasNext()) {
                            final StoryStatusWME storyStatusWME2 = listIterator193.next();
                            if (storyStatusWME2.getBeatCountOfLastGreetingBeat() == 3 && storyStatusWME2.getBeatCount() == 5) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 33415: {
                final ListIterator listIterator194 = WorkingMemory.lookupWME("StoryMemory", "TensionStoryValueWME").listIterator();
                while (listIterator194.hasNext()) {
                    if (listIterator194.next().getValue() == 2.0f) {
                        return true;
                    }
                }
                return false;
            }
            default: {
                throw new AblRuntimeError("Unexpected stepID " + n);
            }
        }
    }
}
