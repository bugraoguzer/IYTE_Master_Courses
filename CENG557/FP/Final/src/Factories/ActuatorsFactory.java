package Factories;

import java.util.List;

import Actuators.Actuators;
import Actuators.Alarm;
import Actuators.LightController;
import Actuators.ShutterController;
import Actuators.TemperatureController;
import Application.Feature;


public class ActuatorsFactory implements AbstractFactory {
 
	public Feature CreateComponent(String actuatrs) {

        if(actuatrs == null){
            return null;
        }
        if(actuatrs.equalsIgnoreCase("Alarm")){
            return new Alarm();
        }else if(actuatrs.equalsIgnoreCase("LightController")){
            return new LightController();
        }else if(actuatrs.equalsIgnoreCase("ShutterController")){
            return new ShutterController();
        }else if(actuatrs.equalsIgnoreCase("TemperatureController")){
            return new TemperatureController();     
        }
        return null;
	}
}