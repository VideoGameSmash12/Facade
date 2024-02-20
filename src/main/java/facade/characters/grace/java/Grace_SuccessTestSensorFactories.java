package facade.characters.grace.java;

import abl.runtime.AblRuntimeError;
import facade.sensor.HeldObjectsSensor;
import facade.sensor.GraceAnimationCueSensor;
import facade.sensor.ObjectPositionSensor;
import abl.runtime.Sensor;
import facade.sensor.ObjectRotationSensor;
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

public class Grace_SuccessTestSensorFactories implements GraceScript, TripScript, AnimLayer, FullExpressions, SpriteID, PoseScripts, GestureBodyPart, BodyResource, BeatStatus, BeatConstants, ReactionConstants, DAType, ReactionID, UniversalScript, DramaManagerConstants, BeatArguments, BeatID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, TherapyGameConstants, MusicDefs
{
    public static SensorActivation[] successTestSensorFactory0(final int n) {
        switch (n) {
            case 52: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 9104: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            case 9106: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            case 9420: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            case 9422: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            case 16117: {
                return new SensorActivation[] { new SensorActivation(new GraceAnimationCueSensor(), null) };
            }
            case 16121: {
                return new SensorActivation[] { new SensorActivation(new GraceAnimationCueSensor(), null) };
            }
            case 16126: {
                return new SensorActivation[] { new SensorActivation(new GraceAnimationCueSensor(), null) };
            }
            case 16131: {
                return new SensorActivation[] { new SensorActivation(new GraceAnimationCueSensor(), null) };
            }
            case 16142: {
                return new SensorActivation[] { new SensorActivation(new GraceAnimationCueSensor(), null) };
            }
            case 16153: {
                return new SensorActivation[] { new SensorActivation(new GraceAnimationCueSensor(), null) };
            }
            case 16154: {
                return new SensorActivation[] { new SensorActivation(new GraceAnimationCueSensor(), null) };
            }
            case 16301: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 16325: {
                return new SensorActivation[] { new SensorActivation(new HeldObjectsSensor(), null) };
            }
            case 16369: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 16387: {
                return new SensorActivation[] { new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 16487: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null) };
            }
            default: {
                throw new AblRuntimeError("Unexpected stepID " + n);
            }
        }
    }
}
