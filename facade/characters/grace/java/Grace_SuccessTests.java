package facade.characters.grace.java;

import java.util.ListIterator;
import abl.runtime.AblRuntimeError;
import facade.characters.wmedef.UserTestWME;
import facade.characters.wmedef.IsPlayerTranslatingOrRotatingWME;
import facade.characters.wmedef.StagingInfoWME;
import facade.characters.wmedef.HeldObjectWME;
import facade.characters.wmedef.AnimationCueWME;
import dramaman.runtime.StoryStatusWME;
import facade.characters.wmedef.MoodWME;
import facade.characters.wmedef.PlayerRecentlyTypedTextWME;
import abl.runtime.BehaviorWME;
import abl.runtime.__ValueTypes;
import facade.characters.wmedef.BodyResourceWME;
import facade.characters.wmedef.SignalWME;
import facade.characters.wmedef.PlayerUncoopWME;
import abl.runtime.GoalStepWME;
import facade.characters.wmedef.BeatFlagWME;
import wm.WorkingMemory;
import facade.util.Staging;
import facade.characters.wmedef.ObjectRotationWME;
import facade.characters.wmedef.ObjectPositionWME;
import abl.runtime.BehavingEntity;
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

public class Grace_SuccessTests implements GraceScript, TripScript, AnimLayer, FullExpressions, SpriteID, PoseScripts, GestureBodyPart, BodyResource, BeatStatus, BeatConstants, ReactionConstants, DAType, ReactionID, UniversalScript, DramaManagerConstants, BeatArguments, BeatID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, TherapyGameConstants, MusicDefs
{
    public static boolean successTest0(final int n, final Object[] array, final BehavingEntity behavingEntity) {
        switch (n) {
            case 52: {
                final ListIterator listIterator = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator.hasNext()) {
                    final ObjectPositionWME objectPositionWME = listIterator.next();
                    final float x;
                    final float z;
                    if (objectPositionWME.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x = objectPositionWME.getX()) && BehavingEntity.constantTrue(z = objectPositionWME.getZ())) {
                        final ListIterator listIterator2 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                        while (listIterator2.hasNext()) {
                            final ObjectRotationWME objectRotationWME = listIterator2.next();
                            final float y;
                            if (objectRotationWME.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(y = objectRotationWME.getY())) {
                                final ListIterator listIterator3 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator3.hasNext()) {
                                    final ObjectPositionWME objectPositionWME2 = listIterator3.next();
                                    final float x2;
                                    final float z2;
                                    if (objectPositionWME2.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x2 = objectPositionWME2.getX()) && BehavingEntity.constantTrue(z2 = objectPositionWME2.getZ()) && Staging.isPointWithinCharCone(x2, z2, x, z, y, 60.0f, 0.0f, 9999.0f)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 910: {
                final ListIterator listIterator4 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator4.hasNext()) {
                    if (listIterator4.next().getSVal().equals("answering machine outgoing message")) {
                        return true;
                    }
                }
                return false;
            }
            case 1126: {
                final ListIterator listIterator5 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator5.hasNext()) {
                    if (listIterator5.next().getSVal().equals("answering machine outgoing message")) {
                        return true;
                    }
                }
                return false;
            }
            case 8586: {
                final ListIterator<GoalStepWME> listIterator6 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isStagingGoal").listIterator();
                while (listIterator6.hasNext()) {
                    if (listIterator6.next().getProperty("isStagingGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 9104: {
                final ListIterator listIterator7 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                while (listIterator7.hasNext()) {
                    final ObjectRotationWME objectRotationWME2 = listIterator7.next();
                    if (objectRotationWME2.getObjectID() == 47 && objectRotationWME2.getY() <= 0.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 9106: {
                final ListIterator listIterator8 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                while (listIterator8.hasNext()) {
                    final ObjectRotationWME objectRotationWME3 = listIterator8.next();
                    if (objectRotationWME3.getObjectID() == 47 && objectRotationWME3.getY() > 25.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 9420: {
                final ListIterator listIterator9 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                while (listIterator9.hasNext()) {
                    final ObjectRotationWME objectRotationWME4 = listIterator9.next();
                    if (objectRotationWME4.getObjectID() == 47 && objectRotationWME4.getY() <= 0.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 9422: {
                final ListIterator listIterator10 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                while (listIterator10.hasNext()) {
                    final ObjectRotationWME objectRotationWME5 = listIterator10.next();
                    if (objectRotationWME5.getObjectID() == 47 && objectRotationWME5.getY() <= -60.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 9426: {
                final ListIterator listIterator11 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator11.hasNext()) {
                    if (listIterator11.next().getBLeavingApartment()) {
                        return true;
                    }
                }
                return false;
            }
            case 11499: {
                final ListIterator listIterator12 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator12.hasNext()) {
                    if (!listIterator12.next().getBLeavingApartment()) {
                        return true;
                    }
                }
                return false;
            }
            case 11509: {
                final ListIterator listIterator13 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator13.hasNext()) {
                    if (!listIterator13.next().getBLeavingForKitchen()) {
                        return true;
                    }
                }
                return false;
            }
            case 11534: {
                final ListIterator listIterator14 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator14.hasNext()) {
                    if (!listIterator14.next().getBNotSpeaking()) {
                        return true;
                    }
                }
                return false;
            }
            case 11544: {
                final ListIterator listIterator15 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator15.hasNext()) {
                    if (!listIterator15.next().getBNotMoving()) {
                        return true;
                    }
                }
                return false;
            }
            case 11557: {
                final ListIterator listIterator16 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator16.hasNext()) {
                    if (!listIterator16.next().getBFidgety()) {
                        return true;
                    }
                }
                return false;
            }
            case 12525: {
                final ListIterator listIterator17 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator17.hasNext()) {
                    if (!listIterator17.next().getBLeavingApartment()) {
                        return true;
                    }
                }
                return false;
            }
            case 12535: {
                final ListIterator listIterator18 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator18.hasNext()) {
                    if (!listIterator18.next().getBLeavingForKitchen()) {
                        return true;
                    }
                }
                return false;
            }
            case 15517: {
                final ListIterator listIterator19 = WorkingMemory.lookupWME("TripMemory", "SignalWME").listIterator();
                while (listIterator19.hasNext()) {
                    if (listIterator19.next().getName().equals(array[0])) {
                        return true;
                    }
                }
                return false;
            }
            case 15535: {
                final ListIterator listIterator20 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator20.hasNext()) {
                    final BodyResourceWME bodyResourceWME = listIterator20.next();
                    if (bodyResourceWME.getResourceID() == ((__ValueTypes.IntVar)array[0]).i && bodyResourceWME.getOwner() != null) {
                        return true;
                    }
                }
                return false;
            }
            case 15539: {
                final ListIterator<GoalStepWME> listIterator21 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "resourceOwner").listIterator();
                while (listIterator21.hasNext()) {
                    if (listIterator21.next().getProperty("resourceOwner") == array[1]) {
                        return false;
                    }
                }
                return true;
            }
            case 15567: {
                final ListIterator listIterator22 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator22.hasNext()) {
                    final BodyResourceWME bodyResourceWME2 = listIterator22.next();
                    final int resourcePriority;
                    final BehaviorWME owner;
                    if (bodyResourceWME2.getResourceID() == ((__ValueTypes.IntVar)array[0]).i && BehavingEntity.constantTrue(resourcePriority = bodyResourceWME2.getResourcePriority()) && BehavingEntity.constantTrue(owner = bodyResourceWME2.getOwner()) && (owner == null || resourcePriority <= ((__ValueTypes.IntVar)array[1]).i)) {
                        return true;
                    }
                }
                return false;
            }
            case 15582: {
                final ListIterator listIterator23 = WorkingMemory.lookupWME("PlayerMemory", "PlayerRecentlyTypedTextWME").listIterator();
                while (listIterator23.hasNext()) {
                    final PlayerRecentlyTypedTextWME playerRecentlyTypedTextWME = listIterator23.next();
                    final long timestamp;
                    if (playerRecentlyTypedTextWME.getB() && BehavingEntity.constantTrue(timestamp = playerRecentlyTypedTextWME.getTimestamp()) && System.currentTimeMillis() < timestamp + 1000L) {
                        return true;
                    }
                }
                return false;
            }
            case 15917: {
                return System.currentTimeMillis() > ((MoodWME)array[1]).getDecayAtMillis();
            }
            case 15919: {
                return System.currentTimeMillis() > ((MoodWME)array[1]).getBurstDecayAtMillis();
            }
            case 16009: {
                final ListIterator listIterator24 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator24.hasNext()) {
                    if (listIterator24.next().getBurstDecay() == 0.0f) {
                        return true;
                    }
                }
                return false;
            }
            case 16069: {
                final ListIterator listIterator25 = WorkingMemory.lookupWME("PlayerMemory", "PlayerRecentlyTypedTextWME").listIterator();
                while (listIterator25.hasNext()) {
                    if (!listIterator25.next().getB()) {
                        return true;
                    }
                }
                return false;
            }
            case 16071: {
                return ((StoryStatusWME)array[0]).getNLPProcessingStarted() == 0L;
            }
            case 16117: {
                final ListIterator listIterator26 = BehavingEntity.getBehavingEntity().lookupWME("AnimationCueWME").listIterator();
                while (listIterator26.hasNext()) {
                    final AnimationCueWME animationCueWME = listIterator26.next();
                    if (animationCueWME.getLayerIndex() == ((__ValueTypes.IntVar)array[0]).i && animationCueWME.getCue() == ((__ValueTypes.IntVar)array[1]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 16121: {
                final ListIterator listIterator27 = BehavingEntity.getBehavingEntity().lookupWME("AnimationCueWME").listIterator();
                while (listIterator27.hasNext()) {
                    final AnimationCueWME animationCueWME2 = listIterator27.next();
                    if (animationCueWME2.getLayerIndex() == 7 && animationCueWME2.getCue() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 16126: {
                final ListIterator listIterator28 = BehavingEntity.getBehavingEntity().lookupWME("AnimationCueWME").listIterator();
                while (listIterator28.hasNext()) {
                    final AnimationCueWME animationCueWME3 = listIterator28.next();
                    if (animationCueWME3.getLayerIndex() == 7 && animationCueWME3.getCue() == 3) {
                        return true;
                    }
                }
                return false;
            }
            case 16131: {
                final ListIterator listIterator29 = BehavingEntity.getBehavingEntity().lookupWME("AnimationCueWME").listIterator();
                while (listIterator29.hasNext()) {
                    final AnimationCueWME animationCueWME4 = listIterator29.next();
                    if (animationCueWME4.getLayerIndex() == 7 && animationCueWME4.getCue() == 5) {
                        return true;
                    }
                }
                return false;
            }
            case 16138: {
                final ListIterator<GoalStepWME> listIterator30 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator30.hasNext()) {
                    if (listIterator30.next().getProperty("isDoDialogBody") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 16142: {
                final ListIterator listIterator31 = BehavingEntity.getBehavingEntity().lookupWME("AnimationCueWME").listIterator();
                while (listIterator31.hasNext()) {
                    final AnimationCueWME animationCueWME5 = listIterator31.next();
                    if (animationCueWME5.getLayerIndex() == 7 && animationCueWME5.getCue() == 4) {
                        return true;
                    }
                }
                return false;
            }
            case 16147: {
                final ListIterator<GoalStepWME> listIterator32 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator32.hasNext()) {
                    if (listIterator32.next().getProperty("isDoDialogBody") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 16153: {
                final ListIterator listIterator33 = WorkingMemory.lookupWME("GraceMemory", "AnimationCueWME").listIterator();
                while (listIterator33.hasNext()) {
                    final AnimationCueWME animationCueWME6 = listIterator33.next();
                    if (animationCueWME6.getLayerIndex() == 7 && animationCueWME6.getCue() == ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 16154: {
                final ListIterator listIterator34 = WorkingMemory.lookupWME("TripMemory", "AnimationCueWME").listIterator();
                while (listIterator34.hasNext()) {
                    final AnimationCueWME animationCueWME7 = listIterator34.next();
                    if (animationCueWME7.getLayerIndex() == 7 && animationCueWME7.getCue() == ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 16165: {
                final ListIterator<GoalStepWME> listIterator35 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("GraceMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator35.hasNext()) {
                    if (listIterator35.next().getProperty("isDoDialogBody") != null) {
                        return true;
                    }
                }
                return false;
            }
            case 16167: {
                final ListIterator<GoalStepWME> listIterator36 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("GraceMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator36.hasNext()) {
                    if (listIterator36.next().getProperty("isDoDialogBody") != null) {
                        return true;
                    }
                }
                return false;
            }
            case 16169: {
                final ListIterator<GoalStepWME> listIterator37 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator37.hasNext()) {
                    if (listIterator37.next().getProperty("isDoDialogBody") != null) {
                        return true;
                    }
                }
                return false;
            }
            case 16171: {
                final ListIterator<GoalStepWME> listIterator38 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator38.hasNext()) {
                    if (listIterator38.next().getProperty("isDoDialogBody") != null) {
                        return true;
                    }
                }
                return false;
            }
            case 16173: {
                final ListIterator<GoalStepWME> listIterator39 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("GraceMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator39.hasNext()) {
                    if (listIterator39.next().getProperty("isDoDialogBody") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 16174: {
                final ListIterator<GoalStepWME> listIterator40 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEByUserProperty("TripMemory", "GoalStepWME", "isDoDialogBody").listIterator();
                while (listIterator40.hasNext()) {
                    if (listIterator40.next().getProperty("isDoDialogBody") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 16301: {
                final ListIterator listIterator41 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator41.hasNext()) {
                    final HeldObjectWME heldObjectWME = listIterator41.next();
                    if (heldObjectWME.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME.getAttachPointID() == ((Grace)behavingEntity).g_objHand) {
                        return false;
                    }
                }
                return true;
            }
            case 16325: {
                final ListIterator listIterator42 = BehavingEntity.getBehavingEntity().lookupWME("HeldObjectWME").listIterator();
                while (listIterator42.hasNext()) {
                    final HeldObjectWME heldObjectWME2 = listIterator42.next();
                    if (heldObjectWME2.getCharacterID() == ((Grace)behavingEntity).me && heldObjectWME2.getAttachPointID() == ((Grace)behavingEntity).g_objHand) {
                        return true;
                    }
                }
                return false;
            }
            case 16369: {
                final ListIterator listIterator43 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                while (listIterator43.hasNext()) {
                    final ObjectPositionWME objectPositionWME3 = listIterator43.next();
                    final float x3;
                    final float z3;
                    if (objectPositionWME3.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x3 = objectPositionWME3.getX()) && BehavingEntity.constantTrue(z3 = objectPositionWME3.getZ())) {
                        final ListIterator listIterator44 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator44.hasNext()) {
                            final ObjectPositionWME objectPositionWME4 = listIterator44.next();
                            final float x4;
                            final float z4;
                            if (objectPositionWME4.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x4 = objectPositionWME4.getX()) && BehavingEntity.constantTrue(z4 = objectPositionWME4.getZ())) {
                                final ListIterator listIterator45 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                                while (listIterator45.hasNext()) {
                                    final ObjectRotationWME objectRotationWME6 = listIterator45.next();
                                    final float y2;
                                    if (objectRotationWME6.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(y2 = objectRotationWME6.getY()) && !Staging.isPointWithinCharCone(x3, z3, x4, z4, y2, 90.0f, 0.0f, 9999.0f) && Staging.getXZDistanceBetweenPoints(x3, z3, x4, z4) < 200.0f) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }
            case 16387: {
                final ListIterator listIterator46 = BehavingEntity.getBehavingEntity().lookupWME("StagingInfoWME").listIterator();
                while (listIterator46.hasNext()) {
                    final boolean bObjMovedFromOrig;
                    if (BehavingEntity.constantTrue(bObjMovedFromOrig = listIterator46.next().getBObjMovedFromOrig())) {
                        final ListIterator listIterator47 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                        while (listIterator47.hasNext()) {
                            final ObjectPositionWME objectPositionWME5 = listIterator47.next();
                            final float x5;
                            final float z5;
                            if (objectPositionWME5.getObjectID() == ((Grace)behavingEntity).me && BehavingEntity.constantTrue(x5 = objectPositionWME5.getX()) && BehavingEntity.constantTrue(z5 = objectPositionWME5.getZ())) {
                                final ListIterator listIterator48 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPositionWME").listIterator();
                                while (listIterator48.hasNext()) {
                                    final ObjectPositionWME objectPositionWME6 = listIterator48.next();
                                    final float x6;
                                    final float z6;
                                    if (objectPositionWME6.getObjectID() == ((Grace)behavingEntity).player && BehavingEntity.constantTrue(x6 = objectPositionWME6.getX()) && BehavingEntity.constantTrue(z6 = objectPositionWME6.getZ())) {
                                        final __ValueTypes.FloatVar floatVar = (__ValueTypes.FloatVar)array[1];
                                        final float xzDistanceBetweenPoints = Staging.getXZDistanceBetweenPoints(x5, z5, x6, z6);
                                        floatVar.f = xzDistanceBetweenPoints;
                                        if (!BehavingEntity.constantTrue(xzDistanceBetweenPoints)) {
                                            continue;
                                        }
                                        final __ValueTypes.FloatVar floatVar2 = (__ValueTypes.FloatVar)array[2];
                                        final float xzDistanceBetweenPoints2 = Staging.getXZDistanceBetweenPoints(x5, z5, ((__ValueTypes.FloatVar)array[5]).f, ((__ValueTypes.FloatVar)array[4]).f);
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
            case 16388: {
                final ListIterator listIterator49 = WorkingMemory.lookupWME("PlayerMemory", "IsPlayerTranslatingOrRotatingWME").listIterator();
                while (listIterator49.hasNext()) {
                    if (listIterator49.next().getB()) {
                        return true;
                    }
                }
                return false;
            }
            case 16466: {
                return System.currentTimeMillis() > ((__ValueTypes.LongVar)array[1]).l;
            }
            case 16473: {
                return System.currentTimeMillis() > ((__ValueTypes.LongVar)array[3]).l;
            }
            case 16487: {
                final ListIterator listIterator50 = BehavingEntity.getBehavingEntity().lookupWME("ObjectRotationWME").listIterator();
                while (listIterator50.hasNext()) {
                    final ObjectRotationWME objectRotationWME7 = listIterator50.next();
                    if (objectRotationWME7.getObjectID() == 47 && objectRotationWME7.getY() <= ((__ValueTypes.IntVar)array[1]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 16636: {
                final ListIterator listIterator51 = BehavingEntity.getBehavingEntity().lookupWME("UserTestWME").listIterator();
                while (listIterator51.hasNext()) {
                    if (listIterator51.next().getParam1() != -1) {
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
