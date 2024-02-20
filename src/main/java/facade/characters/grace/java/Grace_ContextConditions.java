package facade.characters.grace.java;

import java.util.ListIterator;
import abl.runtime.AblRuntimeError;
import facade.util.Point3D;
import facade.characters.wmedef.ObjectPickupPositionWME;
import facade.characters.wmedef.BeatStatusWME;
import facade.characters.wmedef.MoodWME;
import abl.runtime.CollectionBehaviorWME;
import abl.runtime.ParallelBehaviorWME;
import abl.runtime.SequentialBehaviorWME;
import abl.runtime.BehaviorWME;
import abl.runtime.__ValueTypes;
import facade.characters.wmedef.BodyResourceWME;
import facade.characters.wmedef.BeatFlagWME;
import wm.WorkingMemory;
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

public class Grace_ContextConditions implements GraceScript, TripScript, AnimLayer, FullExpressions, SpriteID, PoseScripts, GestureBodyPart, BodyResource, BeatStatus, BeatConstants, ReactionConstants, DAType, ReactionID, UniversalScript, DramaManagerConstants, BeatArguments, BeatID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, TherapyGameConstants, MusicDefs
{
    public static boolean contextCondition0(final int n, final Object[] array, final BehavingEntity behavingEntity) {
        switch (n) {
            case 340: {
                final ListIterator listIterator = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator.hasNext()) {
                    if (listIterator.next().getSVal().equals("player hung up phone")) {
                        return false;
                    }
                }
                final ListIterator listIterator2 = WorkingMemory.lookupWME("StoryMemory", "BeatFlagWME").listIterator();
                while (listIterator2.hasNext()) {
                    if (listIterator2.next().getSVal().equals("phone call ended")) {
                        return false;
                    }
                }
                return true;
            }
            case 4349: {
                final ListIterator listIterator3 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator3.hasNext()) {
                    final BodyResourceWME bodyResourceWME = listIterator3.next();
                    if (bodyResourceWME.getResourceID() == ((__ValueTypes.IntVar)array[0]).i && bodyResourceWME.getOwner() == array[1]) {
                        return true;
                    }
                }
                return false;
            }
            case 4351: {
                final ListIterator<SequentialBehaviorWME> listIterator4 = BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("SequentialBehaviorWME", (String)array[0]).listIterator();
                while (listIterator4.hasNext()) {
                    final SequentialBehaviorWME sequentialBehaviorWME = listIterator4.next();
                    array[2] = sequentialBehaviorWME;
                    if (sequentialBehaviorWME.getSignature().equals(array[0]) && array[2] == array[1]) {
                        return true;
                    }
                }
                return false;
            }
            case 4352: {
                final ListIterator<ParallelBehaviorWME> listIterator5 = BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("ParallelBehaviorWME", (String)array[0]).listIterator();
                while (listIterator5.hasNext()) {
                    final ParallelBehaviorWME parallelBehaviorWME = listIterator5.next();
                    array[2] = parallelBehaviorWME;
                    if (parallelBehaviorWME.getSignature().equals(array[0]) && array[2] == array[1]) {
                        return true;
                    }
                }
                return false;
            }
            case 4353: {
                final ListIterator<CollectionBehaviorWME> listIterator6 = BehavingEntity.getBehavingEntity().lookupReflectionWMEBySignature("CollectionBehaviorWME", (String)array[0]).listIterator();
                while (listIterator6.hasNext()) {
                    final CollectionBehaviorWME collectionBehaviorWME = listIterator6.next();
                    array[2] = collectionBehaviorWME;
                    if (collectionBehaviorWME.getSignature().equals(array[0]) && array[2] == array[1]) {
                        return true;
                    }
                }
                return false;
            }
            case 4354: {
                final ListIterator listIterator7 = BehavingEntity.getBehavingEntity().lookupWME("BodyResourceWME").listIterator();
                while (listIterator7.hasNext()) {
                    final BodyResourceWME bodyResourceWME2 = listIterator7.next();
                    if (bodyResourceWME2.getResourceID() == ((__ValueTypes.IntVar)array[0]).i && bodyResourceWME2.getOwner() == array[2]) {
                        return true;
                    }
                }
                return false;
            }
            case 4502: {
                final ListIterator listIterator8 = BehavingEntity.getBehavingEntity().lookupWME("MoodWME").listIterator();
                while (listIterator8.hasNext()) {
                    final MoodWME moodWME = listIterator8.next();
                    if (moodWME.getType() == ((__ValueTypes.IntVar)array[2]).i && moodWME.getStrength() == ((__ValueTypes.IntVar)array[3]).i && !moodWME.getBTerminate()) {
                        return true;
                    }
                }
                return false;
            }
            case 4619: {
                final ListIterator listIterator9 = WorkingMemory.lookupWME("BeatMemory", "BeatStatusWME").listIterator();
                while (listIterator9.hasNext()) {
                    if (listIterator9.next().getStatus() == 1) {
                        return true;
                    }
                }
                return false;
            }
            case 4688: {
                final ListIterator listIterator10 = BehavingEntity.getBehavingEntity().lookupWME("ObjectPickupPositionWME").listIterator();
                while (listIterator10.hasNext()) {
                    final ObjectPickupPositionWME objectPickupPositionWME = listIterator10.next();
                    if (objectPickupPositionWME.getObjectID() == ((__ValueTypes.IntVar)array[1]).i && objectPickupPositionWME.getX() == ((Point3D)array[2]).x && objectPickupPositionWME.getZ() == ((Point3D)array[2]).z) {
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
}
