package Factories;

import java.util.List;

import Actuators.Actuators;
import Application.Feature;
import Devices.Device;
import Sensors.Sensor;

public interface AbstractFactory {

	public Feature CreateComponent(String device);
	

    
}
