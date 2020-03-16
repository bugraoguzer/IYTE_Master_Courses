package Actuators;

import RedisPubSubMulti.Publisher;

public class ShutterController extends Actuators {

	private String Location;
	private static long sleepBetweenMsg = 20000; //sleep between each message. in milisec.
	private static long elapsedTime = 0; //the duration time for the publish loop (that runs on the subscribers) in milisec. 0 means infinite loop.
	private static String hostName = "127.0.0.1";
	private static int port = 6379;
	private static String info = "turn-off";

	
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
		if(info=="turn-off") {
			info = "Shutter will be turning on at" + Location;
		}else {
			info = "Shutter will be turning off at" + Location;
		}
		String PublisherInfo = info;
		Publisher pub3 = new Publisher(PublisherInfo, "genel", sleepBetweenMsg, elapsedTime, hostName, port);
		pub3.start();
		
	}

	
}
