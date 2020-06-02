package facade.characters.player.java;

import abl.runtime.AblRuntimeError;
import java.util.List;
import abl.runtime.CollectionBehaviorWME;
import abl.runtime.CollectionBehavior;
import dramaman.runtime.DramaManager;
import facade.characters.wmedef.PhysicallyFavorWME;
import abl.runtime.BehavingEntity;
import abl.runtime.ParallelBehavior;
import abl.runtime.ObjectWrapper;
import java.lang.reflect.Method;
import abl.runtime.SequentialBehavior;
import abl.runtime.__StepDesc;
import abl.runtime.__ValueTypes;
import abl.runtime.Behavior;
import abl.runtime.GoalStep;
import java.util.Hashtable;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;

public class Player_BehaviorFactories implements BeatConstants, SpriteID, DramaManagerConstants
{
    public static Behavior behaviorFactory0(final int n, final Object[] array, final Hashtable hashtable, final GoalStep goalStep, final String s) {
        switch (n) {
            case 0: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 0, new Object[] { new __ValueTypes.FloatVar(hashtable.get("playerX")), new __ValueTypes.FloatVar(hashtable.get("playerZ")) }, new __StepDesc[] { new __StepDesc(0, Player.__$stepFactory0_rfield) });
            }
            case 1: {
                return new SequentialBehavior(goalStep, null, null, true, s, (short)0, 1, new Object[] { new __ValueTypes.FloatVar(hashtable.get("playerZ2")), new __ValueTypes.FloatVar(hashtable.get("playerZ1")), ((ObjectWrapper)hashtable.get("settledWME")).objectValue(), new __ValueTypes.FloatVar(hashtable.get("playerX2")), ((ObjectWrapper)hashtable.get("prevWME")).objectValue(), new __ValueTypes.FloatVar(hashtable.get("playerX1")), ((ObjectWrapper)hashtable.get("movWME")).objectValue(), ((ObjectWrapper)hashtable.get("transWME")).objectValue() }, new __StepDesc[] { new __StepDesc(1, Player.__$stepFactory0_rfield) });
            }
            case 2: {
                return new SequentialBehavior(goalStep, null, null, true, s, (short)0, 2, new Object[] { new __ValueTypes.FloatVar(hashtable.get("playerZ2")), new __ValueTypes.FloatVar(hashtable.get("playerZ1")), new __ValueTypes.FloatVar(hashtable.get("playerX2")), ((ObjectWrapper)hashtable.get("prevWME")).objectValue(), new __ValueTypes.FloatVar(hashtable.get("playerX1")), ((ObjectWrapper)hashtable.get("movWME")).objectValue(), new __ValueTypes.BooleanVar((Boolean)(Object)hashtable.get("bRotating")), ((ObjectWrapper)hashtable.get("transWME")).objectValue() }, new __StepDesc[] { new __StepDesc(2, Player.__$stepFactory0_rfield) });
            }
            case 3: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 3, new Object[] { new __ValueTypes.FloatVar(hashtable.get("playerYRot")) }, new __StepDesc[] { new __StepDesc(3, Player.__$stepFactory0_rfield) });
            }
            case 4: {
                return new SequentialBehavior(goalStep, null, null, true, s, (short)0, 4, new Object[] { ((ObjectWrapper)hashtable.get("settledWME")).objectValue(), new __ValueTypes.FloatVar(hashtable.get("playerYRot1")), new __ValueTypes.FloatVar(hashtable.get("playerYRot2")), ((ObjectWrapper)hashtable.get("prevWME")).objectValue(), ((ObjectWrapper)hashtable.get("movWME")).objectValue(), ((ObjectWrapper)hashtable.get("rotWME")).objectValue() }, new __StepDesc[] { new __StepDesc(4, Player.__$stepFactory0_rfield) });
            }
            case 5: {
                return new SequentialBehavior(goalStep, null, null, true, s, (short)0, 5, new Object[] { new __ValueTypes.FloatVar(hashtable.get("playerYRot1")), new __ValueTypes.FloatVar(hashtable.get("playerYRot2")), ((ObjectWrapper)hashtable.get("prevWME")).objectValue(), ((ObjectWrapper)hashtable.get("movWME")).objectValue(), new __ValueTypes.BooleanVar((Boolean)(Object)hashtable.get("bTranslating")), ((ObjectWrapper)hashtable.get("rotWME")).objectValue() }, new __StepDesc[] { new __StepDesc(5, Player.__$stepFactory0_rfield) });
            }
            case 6: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 6, null, new __StepDesc[] { new __StepDesc(6, Player.__$stepFactory0_rfield), new __StepDesc(7, Player.__$stepFactory0_rfield) });
            }
            case 7: {
                return new SequentialBehavior(goalStep, Player.__$contextCondition0_rfield, null, false, s, (short)0, 7, new Object[] { ((ObjectWrapper)hashtable.get("settledWME")).objectValue() }, new __StepDesc[] { new __StepDesc(8, Player.__$stepFactory0_rfield), new __StepDesc(9, Player.__$stepFactory0_rfield) });
            }
            case 8: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 8, null, new __StepDesc[] { new __StepDesc(10, Player.__$stepFactory0_rfield) });
            }
            case 9: {
                return new SequentialBehavior(goalStep, null, null, true, s, (short)0, 9, new Object[] { new __ValueTypes.LongVar(), new __ValueTypes.FloatVar(), new __ValueTypes.FloatVar(hashtable.get("playerXPos")), new __ValueTypes.FloatVar(hashtable.get("playerYRot")), ((ObjectWrapper)hashtable.get("cachedPlayerPositionWME")).objectValue(), new __ValueTypes.FloatVar(hashtable.get("playerYPos")), ((ObjectWrapper)hashtable.get("playerFutureRotationWME")).objectValue(), new __ValueTypes.FloatVar(hashtable.get("playerZPos")), ((ObjectWrapper)hashtable.get("cachedPlayerRotationWME")).objectValue(), ((ObjectWrapper)hashtable.get("playerFuturePositionWME")).objectValue() }, new __StepDesc[] { new __StepDesc(11, Player.__$stepFactory0_rfield), new __StepDesc(12, Player.__$stepFactory0_rfield), new __StepDesc(13, Player.__$stepFactory0_rfield), new __StepDesc(14, Player.__$stepFactory0_rfield) });
            }
            case 10: {
                return new ParallelBehavior(goalStep, null, null, false, s, (short)0, 10, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.BooleanVar((Boolean)array[1]), new __ValueTypes.BooleanVar((Boolean)array[2]), new __ValueTypes.FloatVar((Float)array[3]) }, new __StepDesc[] { new __StepDesc(15, Player.__$stepFactory0_rfield), new __StepDesc(16, Player.__$stepFactory0_rfield) }, 2);
            }
            case 11: {
                return new ParallelBehavior(goalStep, null, null, false, s, (short)0, 11, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.BooleanVar((Boolean)array[1]), new __ValueTypes.BooleanVar((Boolean)array[2]), new __ValueTypes.FloatVar((Float)array[3]) }, new __StepDesc[] { new __StepDesc(17, Player.__$stepFactory0_rfield) }, 1);
            }
            case 12: {
                return new ParallelBehavior(goalStep, null, null, false, s, (short)0, 12, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.BooleanVar((Boolean)array[1]), new __ValueTypes.BooleanVar((Boolean)array[2]), new __ValueTypes.FloatVar((Float)array[3]) }, new __StepDesc[] { new __StepDesc(18, Player.__$stepFactory0_rfield) }, 1);
            }
            case 13: {
                return new ParallelBehavior(goalStep, null, null, false, s, (short)0, 13, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.BooleanVar((Boolean)array[1]), new __ValueTypes.BooleanVar((Boolean)array[2]), new __ValueTypes.FloatVar((Float)array[3]) }, new __StepDesc[] { new __StepDesc(-1, Player.__$stepFactory0_rfield) }, 1);
            }
            case 14: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 14, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.IntVar((Integer)array[1]) }, new __StepDesc[] { new __StepDesc(19, Player.__$stepFactory0_rfield), new __StepDesc(20, Player.__$stepFactory0_rfield), new __StepDesc(21, Player.__$stepFactory0_rfield), new __StepDesc(22, Player.__$stepFactory0_rfield) }, new BehavingEntity[] { BehavingEntity.getBehavingEntity("Trip"), BehavingEntity.getBehavingEntity("Player") });
            }
            case 15: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 15, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), ((ObjectWrapper)hashtable.get("gWME")).objectValue(), ((ObjectWrapper)hashtable.get("objID")).objectValue() }, new __StepDesc[] { new __StepDesc(23, Player.__$stepFactory0_rfield) });
            }
            case 16: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 16, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.IntVar((Integer)array[1]) }, new __StepDesc[] { new __StepDesc(24, Player.__$stepFactory0_rfield), new __StepDesc(25, Player.__$stepFactory0_rfield), new __StepDesc(26, Player.__$stepFactory0_rfield) });
            }
            case 17: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 17, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.BooleanVar((Boolean)(Object)hashtable.get("lookActive")), ((ObjectWrapper)hashtable.get("overallControl_Body")).objectValue(), new __ValueTypes.BooleanVar((Boolean)(Object)hashtable.get("objectActivateActive")), new __ValueTypes.FloatVar(hashtable.get("lDistance")) }, new __StepDesc[] { new __StepDesc(27, Player.__$stepFactory0_rfield) });
            }
            case 18: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 18, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.BooleanVar((Boolean)(Object)hashtable.get("lookActive")), ((ObjectWrapper)hashtable.get("overallControl_Body")).objectValue(), new __ValueTypes.BooleanVar((Boolean)(Object)hashtable.get("objectActivateActive")), new __ValueTypes.FloatVar(hashtable.get("lDistance")) }, new __StepDesc[] { new __StepDesc(28, Player.__$stepFactory0_rfield), new __StepDesc(29, Player.__$stepFactory0_rfield), new __StepDesc(30, Player.__$stepFactory0_rfield) }, new BehavingEntity[] { BehavingEntity.getBehavingEntity("Trip"), BehavingEntity.getBehavingEntity("Player") });
            }
            case 19: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 19, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), ((ObjectWrapper)hashtable.get("gWME")).objectValue(), ((ObjectWrapper)hashtable.get("objID")).objectValue() }, new __StepDesc[] { new __StepDesc(31, Player.__$stepFactory0_rfield) });
            }
            case 20: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 20, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), null }, new __StepDesc[] { new __StepDesc(32, Player.__$stepFactory0_rfield), new __StepDesc(33, Player.__$stepFactory0_rfield), new __StepDesc(34, Player.__$stepFactory0_rfield) });
            }
            case 21: {
                return new SequentialBehavior(goalStep, Player.__$contextCondition0_rfield, Player.__$contextConditionSensorFactory0_rfield, false, s, (short)3, 21, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.FloatVar((Float)array[1]), null, new __ValueTypes.FloatVar(hashtable.get("graceX")), new __ValueTypes.FloatVar(hashtable.get("playerRotY")), new __ValueTypes.FloatVar(hashtable.get("playerX")), new __ValueTypes.FloatVar(hashtable.get("graceZ")), new __ValueTypes.FloatVar(hashtable.get("tripZ")), new __ValueTypes.FloatVar(hashtable.get("playerZ")), new __ValueTypes.FloatVar(hashtable.get("objZ")), new __ValueTypes.FloatVar(hashtable.get("tripX")), new __ValueTypes.FloatVar(hashtable.get("objX")) }, new __StepDesc[] { new __StepDesc(35, Player.__$stepFactory0_rfield), new __StepDesc(36, Player.__$stepFactory0_rfield), new __StepDesc(37, Player.__$stepFactory0_rfield) });
            }
            case 22: {
                return new SequentialBehavior(goalStep, Player.__$contextCondition0_rfield, Player.__$contextConditionSensorFactory0_rfield, false, s, (short)2, 22, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.FloatVar((Float)array[1]) }, new __StepDesc[] { new __StepDesc(-3, Player.__$stepFactory0_rfield) });
            }
            case 23: {
                return new SequentialBehavior(goalStep, Player.__$contextCondition0_rfield, Player.__$contextConditionSensorFactory0_rfield, false, s, (short)1, 23, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.FloatVar((Float)array[1]), new __ValueTypes.FloatVar(), new __ValueTypes.BooleanVar(), new __ValueTypes.BooleanVar(), new __ValueTypes.BooleanVar(), new __ValueTypes.LongVar(), new __ValueTypes.FloatVar(), new __ValueTypes.FloatVar(), new __ValueTypes.FloatVar(), new __ValueTypes.FloatVar(), new __ValueTypes.FloatVar(), new __ValueTypes.FloatVar(), new __ValueTypes.FloatVar(), new __ValueTypes.FloatVar(), new __ValueTypes.FloatVar() }, new __StepDesc[] { new __StepDesc(-3, Player.__$stepFactory0_rfield) });
            }
            case 24: {
                return new ParallelBehavior(goalStep, null, null, false, s, (short)0, 24, new Object[] { new __ValueTypes.IntVar((Integer)array[0]) }, new __StepDesc[] { new __StepDesc(38, Player.__$stepFactory0_rfield), new __StepDesc(39, Player.__$stepFactory0_rfield), new __StepDesc(40, Player.__$stepFactory0_rfield) }, 3);
            }
            case 25: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 25, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.FloatVar(hashtable.get("playerX")), new __ValueTypes.FloatVar(hashtable.get("playerZ")), new __ValueTypes.FloatVar(hashtable.get("objZ")), new __ValueTypes.FloatVar(hashtable.get("objX")) }, new __StepDesc[] { new __StepDesc(41, Player.__$stepFactory0_rfield), new __StepDesc(42, Player.__$stepFactory0_rfield) });
            }
            case 26: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 26, new Object[] { (PhysicallyFavorWME)array[0] }, new __StepDesc[] { new __StepDesc(43, Player.__$stepFactory0_rfield), new __StepDesc(44, Player.__$stepFactory0_rfield) });
            }
            case 27: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 27, null, new __StepDesc[] { new __StepDesc(45, Player.__$stepFactory0_rfield), new __StepDesc(46, Player.__$stepFactory0_rfield), new __StepDesc(47, Player.__$stepFactory0_rfield) });
            }
            case 28: {
                return new ParallelBehavior(goalStep, null, null, false, s, (short)0, 28, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.IntVar((Integer)array[1]) }, new __StepDesc[] { new __StepDesc(48, Player.__$stepFactory0_rfield), new __StepDesc(49, Player.__$stepFactory0_rfield), new __StepDesc(50, Player.__$stepFactory0_rfield) }, 3);
            }
            case 29: {
                final Object[] array2 = new Object[6];
                array2[0] = new __ValueTypes.IntVar((Integer)array[0]);
                array2[1] = new __ValueTypes.IntVar((Integer)array[1]);
                final Object[] array3 = array2;
                final int n2 = 2;
                DramaManager.getDramaManager();
                array3[n2] = DramaManager.getStoryMemory();
                array2[3] = new __ValueTypes.LongVar();
                array2[4] = new __ValueTypes.IntVar((Integer)(Object)hashtable.get("currentAffinity"));
                array2[5] = ((ObjectWrapper)hashtable.get("affinityCounter")).objectValue();
                return new SequentialBehavior(goalStep, null, null, false, s, (short)2, 29, array2, new __StepDesc[] { new __StepDesc(51, Player.__$stepFactory0_rfield), new __StepDesc(52, Player.__$stepFactory0_rfield), new __StepDesc(53, Player.__$stepFactory0_rfield), new __StepDesc(54, Player.__$stepFactory0_rfield) });
            }
            case 30: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)1, 30, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.IntVar((Integer)array[1]), new __ValueTypes.IntVar((Integer)(Object)hashtable.get("currentAffinity")), ((ObjectWrapper)hashtable.get("affinityCounter")).objectValue() }, new __StepDesc[] { new __StepDesc(55, Player.__$stepFactory0_rfield), new __StepDesc(56, Player.__$stepFactory0_rfield), new __StepDesc(57, Player.__$stepFactory0_rfield) });
            }
            case 31: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 31, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.IntVar((Integer)array[1]), ((ObjectWrapper)hashtable.get("sameAffinityWME")).objectValue() }, new __StepDesc[] { new __StepDesc(58, Player.__$stepFactory0_rfield) });
            }
            case 32: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 32, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.IntVar((Integer)array[1]) }, new __StepDesc[] { new __StepDesc(59, Player.__$stepFactory0_rfield), new __StepDesc(60, Player.__$stepFactory0_rfield), new __StepDesc(61, Player.__$stepFactory0_rfield) });
            }
            case 33: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)2, 33, new Object[] { new __ValueTypes.FloatVar((Float)array[0]), ((ObjectWrapper)hashtable.get("oneCharacterVisibleInfoWME")).objectValue() }, new __StepDesc[] { new __StepDesc(62, Player.__$stepFactory0_rfield) }, new BehavingEntity[] { BehavingEntity.getBehavingEntity("Player"), BehavingEntity.getBehavingEntity("Trip") });
            }
            case 34: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)1, 34, new Object[] { new __ValueTypes.FloatVar((Float)array[0]) }, new __StepDesc[] { new __StepDesc(63, Player.__$stepFactory0_rfield) }, new BehavingEntity[] { BehavingEntity.getBehavingEntity("Player"), BehavingEntity.getBehavingEntity("Trip") });
            }
            case 35: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 35, new Object[] { new __ValueTypes.BooleanVar(), new __ValueTypes.BooleanVar(), new __ValueTypes.FloatVar(hashtable.get("graceX")), new __ValueTypes.FloatVar(hashtable.get("playerRotY")), new __ValueTypes.FloatVar(hashtable.get("playerX")), new __ValueTypes.FloatVar(hashtable.get("graceZ")), new __ValueTypes.FloatVar(hashtable.get("tripZ")), new __ValueTypes.FloatVar(hashtable.get("playerZ")), new __ValueTypes.FloatVar(hashtable.get("tripX")), new __ValueTypes.FloatVar(hashtable.get("lookDistance")) }, new __StepDesc[] { new __StepDesc(64, Player.__$stepFactory0_rfield), new __StepDesc(65, Player.__$stepFactory0_rfield) });
            }
            case 36: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 36, new Object[] { new __ValueTypes.BooleanVar(), new __ValueTypes.BooleanVar(), ((ObjectWrapper)hashtable.get("visibleWME")).objectValue(), new __ValueTypes.IntVar((Integer)(Object)hashtable.get("charID")) }, new __StepDesc[] { new __StepDesc(66, Player.__$stepFactory0_rfield), new __StepDesc(67, Player.__$stepFactory0_rfield) });
            }
            case 37: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 37, new Object[] { new __ValueTypes.BooleanVar((Boolean)array[0]), new __ValueTypes.BooleanVar((Boolean)array[1]) }, new __StepDesc[] { new __StepDesc(68, Player.__$stepFactory0_rfield), new __StepDesc(69, Player.__$stepFactory0_rfield) });
            }
            case 38: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 38, new Object[] { new __ValueTypes.BooleanVar((Boolean)array[0]), new __ValueTypes.BooleanVar((Boolean)array[1]) }, new __StepDesc[] { new __StepDesc(70, Player.__$stepFactory0_rfield) });
            }
            case 39: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 39, null, new __StepDesc[] { new __StepDesc(71, Player.__$stepFactory0_rfield), new __StepDesc(72, Player.__$stepFactory0_rfield) });
            }
            case 40: {
                return new SequentialBehavior(goalStep, null, null, true, s, (short)0, 40, new Object[] { new __ValueTypes.BooleanVar(), new __ValueTypes.BooleanVar(), new __ValueTypes.BooleanVar(), new __ValueTypes.FloatVar(hashtable.get("playerRotY")), new __ValueTypes.FloatVar(hashtable.get("playerX")), new __ValueTypes.BooleanVar((Boolean)(Object)hashtable.get("bRecentlyTyped")), new __ValueTypes.FloatVar(hashtable.get("playerZ")), ((ObjectWrapper)hashtable.get("w")).objectValue() }, new __StepDesc[] { new __StepDesc(73, Player.__$stepFactory0_rfield) });
            }
            case 41: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 41, new Object[] { new __ValueTypes.FloatVar((Float)array[0]), new __ValueTypes.LongVar() }, new __StepDesc[] { new __StepDesc(74, Player.__$stepFactory0_rfield), new __StepDesc(75, Player.__$stepFactory0_rfield) });
            }
            case 42: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 42, new Object[] { new __ValueTypes.IntVar((Integer)array[0]), new __ValueTypes.FloatVar() }, new __StepDesc[] { new __StepDesc(76, Player.__$stepFactory0_rfield), new __StepDesc(77, Player.__$stepFactory0_rfield) });
            }
            case 43: {
                return new SequentialBehavior(goalStep, null, null, false, s, (short)0, 43, null, new __StepDesc[] { new __StepDesc(78, Player.__$stepFactory0_rfield), new __StepDesc(79, Player.__$stepFactory0_rfield), new __StepDesc(80, Player.__$stepFactory0_rfield), new __StepDesc(81, Player.__$stepFactory0_rfield) });
            }
            case 44: {
                return new CollectionBehavior(goalStep, null, null, false, s, (short)0, 44, null, new __StepDesc[] { new __StepDesc(82, Player.__$stepFactory0_rfield), new __StepDesc(83, Player.__$stepFactory0_rfield), new __StepDesc(84, Player.__$stepFactory0_rfield), new __StepDesc(85, Player.__$stepFactory0_rfield), new __StepDesc(86, Player.__$stepFactory0_rfield), new __StepDesc(87, Player.__$stepFactory0_rfield), new __StepDesc(88, Player.__$stepFactory0_rfield) }, 7);
            }
            case 45: {
                return new SequentialBehavior(goalStep, null, null, true, s, (short)0, 45, new Object[] { null, ((ObjectWrapper)hashtable.get("overallControl_Body")).objectValue() }, new __StepDesc[] { new __StepDesc(89, Player.__$stepFactory0_rfield), new __StepDesc(90, Player.__$stepFactory0_rfield) });
            }
            case 46: {
                return new SequentialBehavior(goalStep, null, null, true, s, (short)2, 46, new Object[] { (CollectionBehaviorWME)array[0], (List)array[1], null, new __ValueTypes.IntVar(), new __ValueTypes.FloatVar(), new __ValueTypes.BooleanVar(), new __ValueTypes.BooleanVar() }, new __StepDesc[] { new __StepDesc(91, Player.__$stepFactory0_rfield), new __StepDesc(92, Player.__$stepFactory0_rfield), new __StepDesc(93, Player.__$stepFactory0_rfield) });
            }
            case 47: {
                return new SequentialBehavior(goalStep, null, null, true, s, (short)1, 47, new Object[] { (CollectionBehaviorWME)array[0], (List)array[1] }, new __StepDesc[] { new __StepDesc(-1, Player.__$stepFactory0_rfield) });
            }
            case 48: {
                return new CollectionBehavior(goalStep, null, null, false, s, (short)0, 48, null, new __StepDesc[] { new __StepDesc(94, Player.__$stepFactory0_rfield) }, 1);
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
}
