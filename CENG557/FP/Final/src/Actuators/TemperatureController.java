package Actuators;

import RedisPubSubMulti.Publisher;

public class TemperatureController extends Actuators {

	private String Location;
	private static long sleepBetweenMsg = 20000; //sleep between each message. in milisec.
	private static long elapsedTime = 0; //the duration time for the publish loop (that runs on the subscribers) in milisec. 0 means infinite loop.
	private static String hostName = "127.0.0.1";
	private static int port = 6379;
	private static String info;
	private static String tempdegree = "35";
	private static String activatestatus = "turn-off";
	
	public String getName() {
		String className = this.getClass().getName();
		return className;
	}
	
	public void trigger() {

		String PublisherInfo ="Temp Degreee Setted = "+tempdegree;
		Publisher pub1 = new Publisher(PublisherInfo, "genel", sleepBetweenMsg, elapsedTime, hostName, port);
		pub1.start();
		
	}

	public void setdegree(String degree) {
		tempdegree = degree;

	}
	
	
}
