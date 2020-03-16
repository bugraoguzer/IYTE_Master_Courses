package RedisPubSubMulti;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Subscriber extends Thread {
	 
	private Thread t;
	private String subscriberName;
	private String h;
	private int p;
	private String channelsToListen = null;
	public static String output;
	
	
	public Subscriber(String name, String channels, String hostName, int port) {
		
		subscriberName = name;
		channelsToListen = channels;
		h = hostName;
		p = port;
		System.out.println("Creating " +  subscriberName );
	}
	


	public void run(){
		
		System.out.println("Running " +  subscriberName );
		Jedis jedis = new Jedis(h, p);
		jedis.subscribe((new JedisPubSub(){
			
			 @Override
             public void onMessage(String channel, String message) {
                 
				 if(channel.equals("alarm")) {
                 output = message;}
				 System.out.println(subscriberName + " Receiving On: " + channel + " message: " + message);
			 }


		}), channelsToListen);
		
		
		jedis.close(); 
		System.out.println("exiting " +  subscriberName);
	}
	

	public void start() {
	//Starts the thread in a separate path of execution, then invokes the run() method on this Thread object.
		System.out.println("Starting " +  subscriberName );
	         t = new Thread (this, subscriberName);
	         t.start ();
	}
	
	public String getlastaction()
	{	
		return output;
	}
}