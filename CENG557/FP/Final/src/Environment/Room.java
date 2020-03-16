package Environment;

import java.util.ArrayList;
import java.util.List;

import Application.Feature;
import Devices.Device;

public class Room implements HouseElements {

	public List<HouseElements> RoomElements = new ArrayList<HouseElements>(); 

	public List<Feature> devicelist = new ArrayList<Feature>(); 

	
	public void add(Feature feature) {
		
		devicelist.add(feature);
	} 
	
	public void addHomeElements(HouseElements ele) 
	  { 
		 	RoomElements.add(ele); 
	  }
	
	public void execute(Feature feature2131)
	{
		feature2131.trigger();
	}

	


}
