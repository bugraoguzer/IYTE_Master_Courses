package Application;

import java.util.List;

import Devices.Device;

public interface Feature {

	public void sendData();
	public void trigger();
	public void setDevice(List<Feature> devices);
	public void setLocation(String Location);
	public String getName();
	
	
}
