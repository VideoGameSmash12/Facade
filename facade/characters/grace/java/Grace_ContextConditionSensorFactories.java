package facade.characters.grace.java;

import abl.runtime.AblRuntimeError;
import abl.runtime.Sensor;
import facade.sensor.GraceObjectPickupPositionSensor;
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

public class Grace_ContextConditionSensorFactories implements GraceScript, TripScript, AnimLayer, FullExpressions, SpriteID, PoseScripts, GestureBodyPart, BodyResource, BeatStatus, BeatConstants, ReactionConstants, DAType, ReactionID, UniversalScript, DramaManagerConstants, BeatArguments, BeatID, EpisodicMemoryConstants, BackstoryCategories, CrisisAccusations, TherapyGameConstants, MusicDefs
{
    public static SensorActivation[] contextConditionSensorFactory0(final int n) {
        switch (n) {
            case 4688: {
                return new SensorActivation[] { new SensorActivation(new GraceObjectPickupPositionSensor(), null) };
            }
            default: {
                throw new AblRuntimeError("Unexpected behaviorID " + n);
            }
        }
    }
}
