package Actuators;

import RedisPubSubMulti.Publisher;

public class LightController extends Actuators {

	private String Location;
	private String info;
	private static long sleepBetweenMsg = 20000; //sleep between each message. in milisec.
	private static long elapsedTime = 0; //the duration time for the publish loop (that runs on the subscribers) in milisec. 0 means infinite loop.
	private static String hostName = "127.0.0.1";
	private static int port = 6379;
	private static String status = "Turn-off";

	public String getName() {
		String className = this.getClass().getName();
		return className;
	}
	
	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public void trigger() {
		if(status.equals("Turn-off")) {
			info = "Light will be turning on at " + Location;
		}else {
			info = "Light will be turning off at " + Location;
		}
		String PublisherInfo = info;
		Publisher pub3 = new Publisher(PublisherInfo, "genel", sleepBetweenMsg, elapsedTime, hostName, port);
		pub3.start();
		
	}
	
	public void settimer(String time,String activate)
	{
		info = Location+"Light will be " +activate+" at "+time;  
		Publisher pub2 = new Publisher(info, "genel", sleepBetweenMsg, elapsedTime, hostName, port);
		pub2.start();
	}

	
}
