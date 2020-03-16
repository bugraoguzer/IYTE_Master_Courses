package Model;

public class FactoryMaker {

	
    public static AbstractFactory getFactory(String factory) { 
    	 
        if (factory == null) { 
            return null; 
        } 
 
        if (factory == "Book") { 
            return new BookFactory(); 
        } else if (factory == "Food") { 
            return new FoodFactory(); 
        }else if (factory == "Music")
        	return new MusicFactory();
 
        return null; 
    } 
}
