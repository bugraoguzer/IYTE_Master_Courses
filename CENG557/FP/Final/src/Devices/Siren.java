package Devices;

import RedisPubSubMulti.Publisher;

public class Siren extends Device{

	
	public static long sleepBetweenMsg = 20000; //sleep between each message. in milisec.
	public static long elapsedTime = 1; //the duration time for the publish loop (that runs on the subscribers) in milisec. 0 means infinite loop.
	public static String hostName = "127.0.0.1";
	public static int port = 6379;
	
	public String getName() {
		String className = this.getClass().getName();
		return className;
	}
	
	
	public void sendData(){
		String Info = "Detected Something Siren Starting";
		Publisher pub2 = new Publisher(Info, "genel", sleepBetweenMsg, elapsedTime, hostName, port);
		pub2.start();
	}
	
	
	public void trigger(){
			
			String Info = "Detected Something Siren Starting for";
			System.out.println(Info);
			sendData();
		}
	
	
	public void deactive(){
		String Info = "Siren will be deactive";
		System.out.println(Info);
		Publisher pub2 = new Publisher(Info, "genel", sleepBetweenMsg, elapsedTime, hostName, port);
		pub2.start();
	}
}
