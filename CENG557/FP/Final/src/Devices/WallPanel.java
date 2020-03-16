package Devices;

public class WallPanel extends Device{
	
	public void trigger(){
		System.out.println("Wallpanel bleeping");
	}
	
	public String getName() {
		String className = this.getClass().getName();
		return className;
	}
}
