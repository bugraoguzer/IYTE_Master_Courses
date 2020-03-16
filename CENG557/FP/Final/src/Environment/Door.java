package Environment;

import java.util.ArrayList;
import java.util.List;

import Application.Feature;
import Devices.Device;

public class Door implements HouseElements {

	public List<Feature> devicelist = new ArrayList<Feature>(); 

	
	public void add(Feature feature) {
		
		devicelist.add(feature);
	} 
	
	public void execute(Feature feature2131)
	{
		feature2131.trigger();
	}

}
