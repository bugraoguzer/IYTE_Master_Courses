package Environment;

import java.util.ArrayList;
import java.util.List;

import Devices.Device;

public class Tap implements HouseElements {

	public List<Device> devicelist = new ArrayList<Device>(); 

	
	public void add(Device device) {
		
		devicelist.add(device);
	} 

}
