package Application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import Actuators.Alarm;
import Actuators.LightController;
import Actuators.ShutterController;
import Devices.Device;
import Devices.Light;
import Devices.MobilePhone;
import Devices.Siren;
import Environment.Door;
import Environment.Room;
import Environment.Tap;
import Environment.Window;
import Factories.ActuatorsFactory;
import Factories.ComponentFactory;
import Factories.DeviceFactory;
import Factories.SensorFactory;
import RedisPubSubMulti.Publisher;
import RedisPubSubMulti.Subscriber;
import Sensors.DoorOpenDetector;
import Sensors.GlassBreakDetector;
import Sensors.Sensor;
import Sensors.SmokeDetector;
import Sensors.WaterDetector;
import XMLReader.XMLReader;


public class Main {
	
	public static int subscribersNum = 1; //numbers of subscribers to create
	public static int channelsPerSubscriber = 5; //how many channels to create for each subscriber (each subscriber not sharing his channels with others).
	public static long sleepBetweenMsg = 20000; //sleep between each message. in milisec.
	public static long elapsedTime = 0; //the duration time for the publish loop (that runs on the subscribers) in milisec. 0 means infinite loop.
	public static String hostName = "127.0.0.1";
	public static int port = 6379;
	public static List<String> featurelist;
	public static List<Feature> devices = new ArrayList<Feature>(); 
	public static List<Feature> sensors = new ArrayList<Feature>();
	public static List<Feature> actuators = new ArrayList<Feature>(); 
	
	
		public static void main(String[] args) {
			
		SensorFactory sensorfactory = new SensorFactory();
		DeviceFactory devicefactory = new DeviceFactory();
		ActuatorsFactory actuatorsfactory = new ActuatorsFactory();
		
		XMLReader instance1 = XMLReader.getInstance();
			try {
				featurelist=instance1.reader12("Cheap.xml");
			} catch (XPathExpressionException | ParserConfigurationException | NullPointerException |SAXException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		for(String featurename : featurelist)
		{
			String parse = featurename.substring(featurename.lastIndexOf("_") + 1);
			if(featurename.contains("Devices"))
			{
				devices.add(ComponentFactory.get(devicefactory,parse));
			}else if(featurename.contains("Sensors")){
				sensors.add(ComponentFactory.get(sensorfactory,parse));
			}else if(featurename.contains("Actuators")){
				actuators.add(ComponentFactory.get(actuatorsfactory,parse));
				
			}
		}

		
		Subscriber sub22 = new Subscriber("Listener5", "alarm", hostName, port); //one connection per one subscriber
		sub22.start();
		
	
		
		
		Subscriber sub23 = new Subscriber("Listener3", "genel", hostName, port); //one connection per one subscriber
		sub23.start();
		
		try {
			sub23.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("wait");
			e.printStackTrace();
		}
		
		

		//Example
		Alarm genel1 = new Alarm();
		genel1.trigger();
		
		Room garageroom = new Room();
		Door garagedoor = new Door();
		Window garagewindow = new Window("Garage");
		
		DoorOpenDetector door1 = new DoorOpenDetector();
		door1.setLocation("Garage");
		door1.setDevice(devices);
		door1.trigger();
		garagedoor.add(door1);
		garagedoor.execute(door1);
		
		GlassBreakDetector glassdetector = new GlassBreakDetector();
		glassdetector.setLocation("Garage");
		glassdetector.setDevice(devices);
		glassdetector.trigger();
		garagewindow.add(glassdetector);
		garagewindow.Open();
		
	

		/*

		//Hall
		Door halldoor = new Door();
		
		//Garage
		Room garageroom = new Room();
		Door garagedoor = new Door();
		Window garagewindow = new Window("Garage");
		garageroom.addHomeElements(garagedoor);
		garageroom.addHomeElements(garagewindow);
		
		
		//Sample Actions
		parentroom.execute(light1);
		parentroom.execute(light1);
		parentroom.execute(windowshutter);
		 
		
	*/	

	}

		

}
