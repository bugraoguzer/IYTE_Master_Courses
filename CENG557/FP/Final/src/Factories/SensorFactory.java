package Factories;

import java.util.List;

import Actuators.Actuators;
import Application.Feature;
import Devices.Device;
import Sensors.DoorOpenDetector;
import Sensors.GlassBreakDetector;
import Sensors.Sensor;
import Sensors.SmokeDetector;
import Sensors.SunsetDetector;
import Sensors.WaterDetector;

public class SensorFactory implements AbstractFactory {
 
	public Feature CreateComponent(String sensor) {

        if(sensor == null){
            return null;
        }

        if(sensor.equalsIgnoreCase("DoorOpenDetector")){
            return new DoorOpenDetector();
        }else if(sensor.equalsIgnoreCase("GlassBreakDetector")){
            return new GlassBreakDetector();
        }else if(sensor.equalsIgnoreCase("SmokeDetector")){
            return new SmokeDetector();
        }else if(sensor.equalsIgnoreCase("SunsetDetector")){
            return new SunsetDetector();     
        }else if(sensor.equalsIgnoreCase("WaterDetector")){
            return new WaterDetector();
        }
        return null;
	}

}