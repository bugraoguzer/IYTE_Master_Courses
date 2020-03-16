package Sensors;

import java.util.List;
import java.util.concurrent.TimeUnit;

import Application.Feature;
import Devices.Device;
import RedisPubSubMulti.Publisher;
import RedisPubSubMulti.Subscriber;

public class DoorOpenDetector extends Sensor{

	private String Location;
	public static long sleepBetweenMsg = 20000; //sleep between each message. in milisec.
	public static long elapsedTime = 1; //the duration time for the publish loop (that runs on the subscribers) in milisec. 0 means infinite loop.
	public static String hostName = "127.0.0.1";
	public static int port = 6379;
	public static String alarmmode ="";
	public static List<Feature> devicelist;
	private static String status = "Turn-off";
	private static String info;

	public String getLocation() {
		return Location;
	}


	public void setLocation(String location) {
		Location = location;
	}
	
	public void setDevice(List<Feature> devices) {
		devicelist = devices;
		
	}
	
	public String getName() {
		String className = this.getClass().getName();
		return className;
	}
	
public void trigger() {

	if(status.equals("Turn-off")) {
		info = "Door Opened !! at" + Location;
		sendData();
	}
		
	}


	public void sendData() {
		
		Subscriber sub24 = new Subscriber("Listener45", "alarm", hostName, port); //one connection per one subscriber
		sub24.start();
		
		try {
			sub24.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("wait");
			e.printStackTrace();
		}
		
		alarmmode = sub24.getlastaction();
		

		

		try {
			if(alarmmode.equals("Activated") && !(alarmmode ==null)) {
				
				Publisher pub1 = new Publisher(info, "genel", sleepBetweenMsg, elapsedTime, hostName, port);
				pub1.start();
				
				for (Feature device : devicelist) {
				    device.trigger();
				}
			}
		} catch (NumberFormatException | NullPointerException ex) {
			System.out.println("Alarm not active");  
		} catch (Exception ex) {
		    //Handle generic exception here
		}
	



	}
	
	
}
