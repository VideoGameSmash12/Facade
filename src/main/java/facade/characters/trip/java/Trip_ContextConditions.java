package facade.characters.trip.java;

import java.util.ListIterator;
import abl.runtime.AblRuntimeError;
import facade.characters.wmedef.AmbEightballWME;
import facade.util.Point3D;
import facade.characters.wmedef.ObjectPickupPositionWME;
import facade.characters.wmedef.MoodWME;
import abl.runtime.CollectionBehaviorWME;
import abl.runtime.ParallelBehaviorWME;
import abl.runtime.SequentialBehaviorWME;
import abl.runtime.BehaviorWME;
import facade.characters.wmedef.BodyResourceWME;
import facade.characters.wmedef.PlayerUncoopWME;
import facade.characters.wmedef.BeatFlagWME;
import abl.runtime.GoalStepWME;
import abl.runtime.__ValueTypes;
import dramaman.runtime.StoryStatusWME;
import facade.characters.wmedef.BeatStatusWME;
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

public class Trip_ContextConditions implements GraceScript, TripScript, AnimLayer, FullExpressions, SpriteID, PoseScripts, GestureBodyPart, BodyResource, BeatStatus, BeatConstants, ReactionID, ReactionConstants, DAType, UniversalScript, DramaManagerConstants, PlayerGestureID, BeatArguments, BeatID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, TherapyGameConstants, MusicDefs
{
    public static boolean contextCondition0(final int n, final Object[] array, final BehavingEntity behavingEntity) {
        switch (n) {
            case 5: {
                final ListIterator listIterator = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator.hasNext()) {
                    if (listIterator.next().getStatus() != 6) {
                        return true;
                    }
                }
                return false;
            }
            case 28: {
                final ListIterator listIterator2 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[2]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 29: {
                final ListIterator listIterator3 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator3.hasNext()) {
                    if (listIterator3.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[3]).i) {
                        final ListIterator<GoalStepWME> listIterator4 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", (String)array[2]).listIterator();
                        while (listIterator4.hasNext()) {
                            final GoalStepWME goalStepWME = listIterator4.next();
                            if (goalStepWME.getSignature().equals(array[2]) && goalStepWME.getIsExecuting()) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 103: {
                final ListIterator listIterator5 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator5.hasNext()) {
                    if (!listIterator5.next().getCommitPointReached()) {
                        return true;
                    }
                }
                return false;
            }
            case 169: {
                final ListIterator listIterator6 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator6.hasNext()) {
                    if (listIterator6.next().getCurrentBeat() == 1) {
                        final ListIterator listIterator7 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator7.hasNext()) {
                            if (listIterator7.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 729: {
                final ListIterator listIterator8 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator8.hasNext()) {
                    if (listIterator8.next().getSVal().equals("player hung up phone")) {
                        return false;
                    }
                }
                final ListIterator listIterator9 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator9.hasNext()) {
                    if (listIterator9.next().getSVal().equals("phone call ended")) {
                        return false;
                    }
                }
                return true;
            }
            case 750: {
                final ListIterator listIterator10 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator10.hasNext()) {
                    if (listIterator10.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 840: {
                final ListIterator listIterator11 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator11.hasNext()) {
                    if (listIterator11.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 858: {
                final ListIterator<GoalStepWME> listIterator12 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator12.hasNext()) {
                    if (listIterator12.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 859: {
                final ListIterator<GoalStepWME> listIterator13 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator13.hasNext()) {
                    if (listIterator13.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 860: {
                final ListIterator<GoalStepWME> listIterator14 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator14.hasNext()) {
                    if (listIterator14.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 1532: {
                final ListIterator<GoalStepWME> listIterator15 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator15.hasNext()) {
                    if (listIterator15.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 1535: {
                final ListIterator<GoalStepWME> listIterator16 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator16.hasNext()) {
                    if (listIterator16.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                final ListIterator<GoalStepWME> listIterator17 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isMixinBeatGoal").listIterator();
                while (listIterator17.hasNext()) {
                    if (listIterator17.next().getProperty("isMixinBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 1681: {
                final ListIterator<GoalStepWME> listIterator18 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator18.hasNext()) {
                    if (listIterator18.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 1684: {
                final ListIterator<GoalStepWME> listIterator19 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator19.hasNext()) {
                    if (listIterator19.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                final ListIterator<GoalStepWME> listIterator20 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isMixinBeatGoal").listIterator();
                while (listIterator20.hasNext()) {
                    if (listIterator20.next().getProperty("isMixinBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 1823: {
                final ListIterator<GoalStepWME> listIterator21 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator21.hasNext()) {
                    if (listIterator21.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 1826: {
                final ListIterator<GoalStepWME> listIterator22 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator22.hasNext()) {
                    if (listIterator22.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                final ListIterator<GoalStepWME> listIterator23 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isMixinBeatGoal").listIterator();
                while (listIterator23.hasNext()) {
                    if (listIterator23.next().getProperty("isMixinBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 3009: {
                final ListIterator<GoalStepWME> listIterator24 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator24.hasNext()) {
                    if (listIterator24.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 3012: {
                final ListIterator<GoalStepWME> listIterator25 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator25.hasNext()) {
                    if (listIterator25.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                final ListIterator<GoalStepWME> listIterator26 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isMixinBeatGoal").listIterator();
                while (listIterator26.hasNext()) {
                    if (listIterator26.next().getProperty("isMixinBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 3134: {
                final ListIterator<GoalStepWME> listIterator27 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator27.hasNext()) {
                    if (listIterator27.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 3137: {
                final ListIterator<GoalStepWME> listIterator28 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                while (listIterator28.hasNext()) {
                    if (listIterator28.next().getProperty("isTxnOutBeatGoal") != null) {
                        return false;
                    }
                }
                final ListIterator<GoalStepWME> listIterator29 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isMixinBeatGoal").listIterator();
                while (listIterator29.hasNext()) {
                    if (listIterator29.next().getProperty("isMixinBeatGoal") != null) {
                        return false;
                    }
                }
                return true;
            }
            case 3393: {
                final ListIterator listIterator30 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator30.hasNext()) {
                    if (listIterator30.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[0]).i) {
                        final ListIterator listIterator31 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator31.hasNext()) {
                            if (listIterator31.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 3397: {
                final ListIterator listIterator32 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator32.hasNext()) {
                    if (listIterator32.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[0]).i) {
                        final ListIterator listIterator33 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator33.hasNext()) {
                            if (listIterator33.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 3400: {
                final ListIterator listIterator34 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator34.hasNext()) {
                    if (listIterator34.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[0]).i) {
                        final ListIterator listIterator35 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator35.hasNext()) {
                            if (listIterator35.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        final ListIterator listIterator36 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                        while (listIterator36.hasNext()) {
                            if (!listIterator36.next().getBTxningOut()) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            case 3404: {
                final ListIterator listIterator37 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator37.hasNext()) {
                    if (listIterator37.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[0]).i) {
                        final ListIterator listIterator38 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator38.hasNext()) {
                            if (listIterator38.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        final ListIterator<GoalStepWME> listIterator39 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEByUserProperty("GoalStepWME", "isTxnOutBeatGoal").listIterator();
                        while (listIterator39.hasNext()) {
                            if (listIterator39.next().getProperty("isTxnOutBeatGoal") != null) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 3760: {
                final ListIterator listIterator40 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator40.hasNext()) {
                    if (listIterator40.next().getCurrentBeat() == 27) {
                        return true;
                    }
                }
                return false;
            }
            case 3761: {
                final ListIterator listIterator41 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator41.hasNext()) {
                    if (listIterator41.next().getCurrentBeat() == 27) {
                        return true;
                    }
                }
                return false;
            }
            case 3762: {
                final ListIterator<GoalStepWME> listIterator42 = (ListIterator<GoalStepWME>)WorkingMemory.lookupReflectionWMEBySignature("TripMemory", "GoalStepWME", ((Trip)behavingEntity).sig_bNonAffChrGReturnsT2_bgTxnIn_Veronica).listIterator();
                while (listIterator42.hasNext()) {
                    if (listIterator42.next().getSignature().equals(((Trip)behavingEntity).sig_bNonAffChrGReturnsT2_bgTxnIn_Veronica)) {
                        return true;
                    }
                }
                return false;
            }
            case 4326: {
                final ListIterator listIterator43 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator43.hasNext()) {
                    if (listIterator43.next().getCurrentBeat() == 32) {
                        final ListIterator listIterator44 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator44.hasNext()) {
                            if (listIterator44.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 4327: {
                final ListIterator listIterator45 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator45.hasNext()) {
                    if (listIterator45.next().getCurrentBeat() == 32) {
                        final ListIterator listIterator46 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator46.hasNext()) {
                            if (listIterator46.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 4329: {
                final ListIterator listIterator47 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator47.hasNext()) {
                    if (listIterator47.next().getCurrentBeat() == 32) {
                        final ListIterator listIterator48 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator48.hasNext()) {
                            if (listIterator48.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 5304: {
                final ListIterator listIterator49 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator49.hasNext()) {
                    if (listIterator49.next().getCurrentBeat() == 36) {
                        final ListIterator listIterator50 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator50.hasNext()) {
                            if (listIterator50.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 5305: {
                final ListIterator listIterator51 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator51.hasNext()) {
                    if (listIterator51.next().getCurrentBeat() == 36) {
                        final ListIterator listIterator52 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator52.hasNext()) {
                            if (listIterator52.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 5397: {
                final ListIterator listIterator53 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator53.hasNext()) {
                    if (listIterator53.next().getCurrentBeat() == 37) {
                        final ListIterator listIterator54 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator54.hasNext()) {
                            if (listIterator54.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 5398: {
                final ListIterator listIterator55 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator55.hasNext()) {
                    if (listIterator55.next().getCurrentBeat() == 37) {
                        final ListIterator listIterator56 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator56.hasNext()) {
                            if (listIterator56.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 5544: {
                final ListIterator listIterator57 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator57.hasNext()) {
                    if (listIterator57.next().getCurrentBeat() == 38) {
                        final ListIterator listIterator58 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator58.hasNext()) {
                            if (listIterator58.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 5545: {
                final ListIterator listIterator59 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator59.hasNext()) {
                    if (listIterator59.next().getCurrentBeat() == 38) {
                        final ListIterator listIterator60 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator60.hasNext()) {
                            if (listIterator60.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 5590: {
                final ListIterator listIterator61 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator61.hasNext()) {
                    if (listIterator61.next().getCurrentBeat() == 39) {
                        final ListIterator listIterator62 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator62.hasNext()) {
                            if (listIterator62.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 5591: {
                final ListIterator listIterator63 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator63.hasNext()) {
                    if (listIterator63.next().getCurrentBeat() == 39) {
                        final ListIterator listIterator64 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator64.hasNext()) {
                            if (listIterator64.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 5636: {
                final ListIterator listIterator65 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator65.hasNext()) {
                    if (listIterator65.next().getCurrentBeat() == 40) {
                        final ListIterator listIterator66 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator66.hasNext()) {
                            if (listIterator66.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 5637: {
                final ListIterator listIterator67 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator67.hasNext()) {
                    if (listIterator67.next().getCurrentBeat() == 40) {
                        final ListIterator listIterator68 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator68.hasNext()) {
                            if (listIterator68.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 6478: {
                final ListIterator listIterator69 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator69.hasNext()) {
                    if (listIterator69.next().getBLeavingApartment()) {
                        return true;
                    }
                }
                return false;
            }
            case 6492: {
                final ListIterator listIterator70 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator70.hasNext()) {
                    if (listIterator70.next().getBLeavingForKitchen()) {
                        return true;
                    }
                }
                return false;
            }
            case 6495: {
                final ListIterator listIterator71 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator71.hasNext()) {
                    if (listIterator71.next().getBLeavingForKitchen()) {
                        return true;
                    }
                }
                return false;
            }
            case 6498: {
                final ListIterator listIterator72 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator72.hasNext()) {
                    if (listIterator72.next().getBLeavingForKitchen()) {
                        return true;
                    }
                }
                return false;
            }
            case 6509: {
                final ListIterator listIterator73 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator73.hasNext()) {
                    if (listIterator73.next().getBNotSpeaking()) {
                        return true;
                    }
                }
                return false;
            }
            case 6521: {
                final ListIterator listIterator74 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator74.hasNext()) {
                    if (listIterator74.next().getBNotMoving()) {
                        return true;
                    }
                }
                return false;
            }
            case 6535: {
                final ListIterator listIterator75 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator75.hasNext()) {
                    if (listIterator75.next().getBFidgety()) {
                        return true;
                    }
                }
                return false;
            }
            case 6838: {
                final ListIterator listIterator76 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator76.hasNext()) {
                    if (listIterator76.next().getBLeavingApartment()) {
                        return true;
                    }
                }
                return false;
            }
            case 6851: {
                final ListIterator listIterator77 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator77.hasNext()) {
                    if (listIterator77.next().getBLeavingForKitchen()) {
                        return true;
                    }
                }
                return false;
            }
            case 6854: {
                final ListIterator listIterator78 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator78.hasNext()) {
                    if (listIterator78.next().getBLeavingForKitchen()) {
                        return true;
                    }
                }
                return false;
            }
            case 6865: {
                final ListIterator listIterator79 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator79.hasNext()) {
                    if (listIterator79.next().getBNotSpeaking()) {
                        return true;
                    }
                }
                return false;
            }
            case 6877: {
                final ListIterator listIterator80 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator80.hasNext()) {
                    if (listIterator80.next().getBNotMoving()) {
                        return true;
                    }
                }
                return false;
            }
            case 6891: {
                final ListIterator listIterator81 = WorkingMemory.lookupWME("PlayerMemory", "PlayerUncoopWME").listIterator();
                while (listIterator81.hasNext()) {
                    if (listIterator81.next().getBFidgety()) {
                        return true;
                    }
                }
                return false;
            }
            case 8244: {
                final ListIterator listIterator82 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator82.hasNext()) {
                    final BodyResourceWME bodyResourceWME = listIterator82.next();
                    if (bodyResourceWME.getResourceID() == ((__ValueTypes.IntVar)array[0]).i && bodyResourceWME.getOwner() == array[1]) {
                        return true;
                    }
                }
                return false;
            }
            case 8246: {
                final ListIterator<SequentialBehaviorWME> listIterator83 = (ListIterator<SequentialBehaviorWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("SequentialBehaviorWME", (String)array[0]).listIterator();
                while (listIterator83.hasNext()) {
                    final SequentialBehaviorWME sequentialBehaviorWME = listIterator83.next();
                    array[2] = sequentialBehaviorWME;
                    if (sequentialBehaviorWME.getSignature().equals(array[0]) && array[2] == array[1]) {
                        return true;
                    }
                }
                return false;
            }
            case 8247: {
                final ListIterator<ParallelBehaviorWME> listIterator84 = (ListIterator<ParallelBehaviorWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("ParallelBehaviorWME", (String)array[0]).listIterator();
                while (listIterator84.hasNext()) {
                    final ParallelBehaviorWME parallelBehaviorWME = listIterator84.next();
                    array[2] = parallelBehaviorWME;
                    if (parallelBehaviorWME.getSignature().equals(array[0]) && array[2] == array[1]) {
                        return true;
                    }
                }
                return false;
            }
            case 8248: {
                final ListIterator<CollectionBehaviorWME> listIterator85 = (ListIterator<CollectionBehaviorWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("CollectionBehaviorWME", (String)array[0]).listIterator();
                while (listIterator85.hasNext()) {
                    final CollectionBehaviorWME collectionBehaviorWME = listIterator85.next();
                    array[2] = collectionBehaviorWME;
                    if (collectionBehaviorWME.getSignature().equals(array[0]) && array[2] == array[1]) {
                        return true;
                    }
                }
                return false;
            }
            case 8249: {
                final ListIterator listIterator86 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator86.hasNext()) {
                    final BodyResourceWME bodyResourceWME2 = listIterator86.next();
                    if (bodyResourceWME2.getResourceID() == ((__ValueTypes.IntVar)array[0]).i && bodyResourceWME2.getOwner() == array[2]) {
                        return true;
                    }
                }
                return false;
            }
            case 8397: {
                final ListIterator listIterator87 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator87.hasNext()) {
                    final MoodWME moodWME = listIterator87.next();
                    if (moodWME.getType() == ((__ValueTypes.IntVar)array[2]).i && moodWME.getStrength() == ((__ValueTypes.IntVar)array[3]).i && !moodWME.getBTerminate()) {
                        return true;
                    }
                }
                return false;
            }
            case 8514: {
                final ListIterator listIterator88 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator88.hasNext()) {
                    if (listIterator88.next().getStatus() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 8583: {
                final ListIterator listIterator89 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupPositionWME").listIterator();
                while (listIterator89.hasNext()) {
                    final ObjectPickupPositionWME objectPickupPositionWME = listIterator89.next();
                    if (objectPickupPositionWME.getObjectID() == ((__ValueTypes.IntVar)array[1]).i && objectPickupPositionWME.getX() == ((Point3D)array[2]).x && objectPickupPositionWME.getZ() == ((Point3D)array[2]).z) {
                        return true;
                    }
                }
                return false;
            }
            case 8849: {
                final ListIterator listIterator90 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator90.hasNext()) {
                    if (listIterator90.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 8858: {
                final ListIterator listIterator91 = WorkingMemory.lookupWME("StoryMemory", "AmbEightballWME").listIterator();
                while (listIterator91.hasNext()) {
                    if (listIterator91.next().getReadingCtr() <= 3) {
                        return true;
                    }
                }
                return false;
            }
            case 8866: {
                final ListIterator listIterator92 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator92.hasNext()) {
                    if (listIterator92.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 8881: {
                final ListIterator listIterator93 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator93.hasNext()) {
                    if (listIterator93.next().getStatus() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 8888: {
                final ListIterator listIterator94 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator94.hasNext()) {
                    if (listIterator94.next().getCurrentBeat() == ((__ValueTypes.IntVar)array[0]).i) {
                        return true;
                    }
                }
                return false;
            }
            case 8895: {
                final ListIterator listIterator95 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator95.hasNext()) {
                    if (listIterator95.next().getSVal().equals("Amb_bgMixin_LightenUp done")) {
                        return false;
                    }
                }
                return true;
            }
            case 8899: {
                final ListIterator listIterator96 = WorkingMemory.lookupWME("StoryMemory", "StoryStatusWME").listIterator();
                while (listIterator96.hasNext()) {
                    final StoryStatusWME storyStatusWME = listIterator96.next();
                    if (storyStatusWME.getCurrentBeat() == ((__ValueTypes.IntVar)array[0]).i && storyStatusWME.getCurrentBeat() != 7 && storyStatusWME.getCurrentBeat() != 8) {
                        return true;
                    }
                }
                return false;
            }
            case 9000: {
                final ListIterator listIterator97 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator97.hasNext()) {
                    final BeatStatusWME beatStatusWME = listIterator97.next();
                    final __ValueTypes.IntVar intVar = (__ValueTypes.IntVar)array[0];
                    final int abortReason = beatStatusWME.getAbortReason();
                    intVar.i = abortReason;
                    if (BehavingEntity.constantTrue(abortReason) && (((__ValueTypes.IntVar)array[0]).i == -1 || ((__ValueTypes.IntVar)array[0]).i == 1 || ((__ValueTypes.IntVar)array[0]).i == 2 || ((__ValueTypes.IntVar)array[0]).i == 5)) {
                        final ListIterator listIterator98 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                        while (listIterator98.hasNext()) {
                            if (listIterator98.next().getSVal().equals("EndingExperience")) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                return false;
            }
            case 9018: {
                final ListIterator<GoalStepWME> listIterator99 = (ListIterator<GoalStepWME>)BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("GoalStepWME", "Amb_Fixdrinkopt_DoItThisBeat_PerformAtThisBeatGoal()").listIterator();
                while (listIterator99.hasNext()) {
                    if (listIterator99.next().getSignature().equals("Amb_Fixdrinkopt_DoItThisBeat_PerformAtThisBeatGoal()")) {
                        return false;
                    }
                }
                return true;
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
}
