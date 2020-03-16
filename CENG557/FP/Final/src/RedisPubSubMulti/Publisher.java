package RedisPubSubMulti;

import java.util.concurrent.TimeUnit;

import redis.clients.jedis.Jedis;

public class Publisher extends Thread{

	private Thread t;
	private String h;
	private int p;
	private String channelsToPublish = null;
	private String msg = null;
	private long pausa = 10000;
	private long duration = 10000; 
	private Jedis jedis;
	
	public Publisher(String message, String totalChannels, long sleepBetweenMsg, long elapsedTime, String hostName, int port) {
		
		channelsToPublish = totalChannels;
		msg = message;
		pausa = sleepBetweenMsg;
		duration = elapsedTime;
		h = hostName;
		p = port;
	}
	
	public void run(){
		
		System.out.println("Running Publisher");
		System.out.println("Publish to all channels the message: " +  msg);
		jedis = new Jedis(h, p);
		publish();
		jedis.close(); 
		System.out.println("exiting Publisher");

	}
	
	public void start() {
		System.out.println("Publisher started");
	      if (t == null) {
	         t = new Thread (this, "Publisher");
	         t.start ();
	      }
	}
	
	public void publish() {
		

			jedis.publish(channelsToPublish, msg);
			try {
				Thread.sleep(pausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}

	
}