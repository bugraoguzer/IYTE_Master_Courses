package Sensors;

import java.util.List;
import java.util.concurrent.TimeUnit;

import Application.Feature;
import Devices.Device;
import RedisPubSubMulti.Publisher;
import RedisPubSubMulti.Subscriber;

public class WaterDetector extends Sensor {

	private String Location;
	public static long sleepBetweenMsg = 20000; //sleep between each message. in milisec.
	public static long elapsedTime = 1; //the duration time for the publish loop (that runs on the subscribers) in milisec. 0 means infinite loop.
	public static String hostName = "127.0.0.1";
	public static int port = 6379;
	public static String alarmmode ="";
	public static List<Feature> devicelist;
	public static int gaslevel = 0;
	private static String info;
	private static String status = "Turn-off";
	


	public String getLocation() {
		return Location;
	}




	public void setLocation(String location) {
		Location = location;
	}
	
	public void setDevice(List<Feature> liste) {
		devicelist=liste;
	}

	
	
	public void trigger() {
		if(status.equals("Turn-off")) {
			info = "Smoke detected of the "+Location;
			sendData();}
		}
	
	public String getName() {
		String className = this.getClass().getName();
		return className;
	}
	

	public void sendData() {
		try {			
				Publisher pub1 = new Publisher("Smoke detected of the "+Location, "genel", sleepBetweenMsg, elapsedTime, hostName, port);
				pub1.start();
				
				for (Feature device : devicelist) {
				    device.trigger();
				}
			
		} catch (NumberFormatException | NullPointerException ex) {
			System.out.println("Alarm not active");  
		} catch (Exception ex) {
		    //Handle generic exception here
		}
	}	
}
