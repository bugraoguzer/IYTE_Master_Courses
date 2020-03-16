package Actuators;

import RedisPubSubMulti.Publisher;
import RedisPubSubMulti.Subscriber;

public class Alarm extends Actuators {

	private static long sleepBetweenMsg = 20000; //sleep between each message. in milisec.
	private static long elapsedTime = 0; //the duration time for the publish loop (that runs on the subscribers) in milisec. 0 means infinite loop.
	private static String hostName = "127.0.0.1";
	private static int port = 6379;
	private static String info;
	private static String status = "Turn-off";
	
	
	
		public void trigger() {
		if(status.equals("Turn-off")) {
				info = "Activated"; 
				Publisher pub1 = new Publisher(info, "alarm", sleepBetweenMsg, elapsedTime, hostName, port);
				pub1.start();
			}else {
				info = "InActivated"; 
			}

		}
	
}
