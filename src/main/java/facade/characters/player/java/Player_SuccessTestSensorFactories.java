package facade.characters.player.java;

import abl.runtime.AblRuntimeError;
import facade.sensor.ObjectPositionSensor;
import facade.sensor.ObjectRotationSensor;
import abl.runtime.Sensor;
import facade.sensor.PlayerObjectActivationSensor;
import abl.runtime.SensorActivation;
import dramaman.runtime.DramaManagerConstants;
import facade.util.SpriteID;
import facade.util.BeatConstants;

public class Player_SuccessTestSensorFactories implements BeatConstants, SpriteID, DramaManagerConstants
{
    public static SensorActivation[] successTestSensorFactory0(final int n) {
        switch (n) {
            case 32: {
                return new SensorActivation[] { new SensorActivation(new PlayerObjectActivationSensor(), null) };
            }
            case 66: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            case 68: {
                return new SensorActivation[] { new SensorActivation(new ObjectRotationSensor(), null), new SensorActivation(new ObjectPositionSensor(), null) };
            }
            default: {
                throw new AblRuntimeError("Unexpected stepID " + n);
            }
        }
    }
}
