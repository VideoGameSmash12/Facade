package facade.characters.grace.java;

import abl.runtime.AblRuntimeError;
import facade.sensor.ObjectStateSensor;
import facade.sensor.GraceArmBaseSensor;
import facade.sensor.GraceObjectPickupRotationSensor;
import facade.sensor.GraceObjectPickupPositionSensor;
import facade.sensor.ObjectRotationSensor;
import facade.sensor.HeldObjectsSensor;
import abl.runtime.Sensor;
import facade.sensor.ObjectPositionSensor;
import abl.runtime.SensorActivation;
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

public class Grace_PreconditionSensorFactories implements GraceScript, TripScript, AnimLayer, FullExpressions, SpriteID, PoseScripts, GestureBodyPart, BodyResource, BeatStatus, BeatConstants, ReactionConstants, DAType, ReactionID, UniversalScript, DramaManagerConstants, BeatArguments, BeatID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, TherapyGameConstants, MusicDefs
{
    public static SensorActivation[] preconditionSensorFactory0(final int n) {
        switch (n) {
            case 170: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 273: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 279: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 297: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 352: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 355: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 356: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 357: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 358: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 359: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 456: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 665: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 1820: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 1821: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 1822: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 1823: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 1824: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 1825: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2097: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2098: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 2222: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2520: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 2522: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 2523: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 2524: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 2525: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 2902: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2903: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2953: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2954: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2955: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2956: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2983: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2984: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2985: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 2986: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 3597: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3598: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3605: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3606: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 3717: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 3764: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 3765: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 3766: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 3767: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4499: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4666: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4672: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4676: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4677: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4679: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4681: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4682: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4683: {
                return new SensorActivation[] { new SensorActivation(new GraceObjectPickupPositionSensor(), null), new SensorActivation(new GraceObjectPickupRotationSensor(), null) };
            }
            case 4686: {
                return new SensorActivation[] { new SensorActivation(new GraceObjectPickupPositionSensor(), null) };
            }
            case 4687: {
                return new SensorActivation[] { new SensorActivation(new GraceObjectPickupRotationSensor(), null) };
            }
            case 4690: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4691: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4692: {
                return new SensorActivation[] { new SensorActivation(new GraceObjectPickupPositionSensor(), null), new SensorActivation(new GraceObjectPickupRotationSensor(), null) };
            }
            case 4693: {
                return new SensorActivation[] { new SensorActivation(new GraceObjectPickupPositionSensor(), null) };
            }
            case 4694: {
                return new SensorActivation[] { new SensorActivation(new GraceObjectPickupRotationSensor(), null) };
            }
            case 4696: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4697: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4699: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4703: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4706: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4707: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4712: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4722: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4731: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4732: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4733: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4737: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4749: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4775: {
                return new SensorActivation[] { new SensorActivation(new GraceArmBaseSensor(), null) };
            }
            case 4776: {
                return new SensorActivation[] { new SensorActivation(new GraceArmBaseSensor(), null) };
            }
            case 4821: {
                return new SensorActivation[] { new SensorActivation(new GraceArmBaseSensor(), null) };
            }
            case 4822: {
                return new SensorActivation[] { new SensorActivation(new GraceArmBaseSensor(), null) };
            }
            case 4871: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4872: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4884: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4885: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4893: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4916: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4942: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4943: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4944: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4947: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 4951: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4955: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 4956: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null), new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null), new SensorActivation(new ObjectStateSensor(), null) };
            }
            case 4960: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null), new SensorActivation(new ObjectStateSensor(), null) };
            }
            case 4968: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null), new SensorActivation(new ObjectStateSensor(), null) };
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
}
