package Environment;

import java.util.ArrayList;
import java.util.List;

import Application.Feature;

public class Window implements HouseElements {


	public List<Feature> featurelist = new ArrayList<Feature>(); 
	private String Location = "";
	private String Info = "";
	
	public Window(String location) {
		super();
		Location = location;
	}

	public void add(Feature feature) {
		
		featurelist.add(feature);
	} 

	public void Open() {
		
	    for (Feature feature: featurelist) {

	    	   feature.trigger();
	       
	    	
	    }
		
	}
	
	public void GlassBreak() {
		
	    for (Feature feature: featurelist) {
	
		    	   feature.trigger();
		       
		    	
		    }
		
	}
}
