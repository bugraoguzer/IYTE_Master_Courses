package Factories;

import java.util.List;

import Actuators.Actuators;
import Application.Feature;
import Devices.Device;
import Devices.Light;
import Devices.MobilePhone;
import Devices.Siren;
import Devices.WallPanel;
import Sensors.DoorOpenDetector;
import Sensors.GlassBreakDetector;
import Sensors.Sensor;
import Sensors.SmokeDetector;
import Sensors.SunsetDetector;
import Sensors.WaterDetector;

public class DeviceFactory implements AbstractFactory {
 

	public Feature CreateComponent(String device) {
		// TODO Auto-generated method stub
	      if(device == null){
	            return null;
	        }

	        if(device.equalsIgnoreCase("WallPanel")){
	            return new WallPanel();
	        }else if(device.equalsIgnoreCase("Siren")){
	            return new Siren();
	        }else if(device.equalsIgnoreCase("MobilePhone")){
	            return new MobilePhone();
	        }else if(device.equalsIgnoreCase("Light")){
	            return new Light();     
	        }
	        return null;
	}



}