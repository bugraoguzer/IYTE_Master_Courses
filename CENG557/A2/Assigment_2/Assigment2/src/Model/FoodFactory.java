package Model;

public class FoodFactory extends AbstractFactory {

	@Override
	Book getBook(String book,Integer ID,String bookname,String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Food getFood(String food,Integer ID,String foodname,String LastUsageDate) {
		// TODO Auto-generated method stub
	       if (food == null) { 
	            return null; 
	        } 
	 
	        if (food == "frozen") { 
	            return new FrozenFood(ID,foodname, LastUsageDate); 
	        } else if (food == "fresh") { 
	            return new FreshFood(ID,foodname,LastUsageDate); 
	        }
	        else
	        	return null; 
	}



	@Override
	Music getMusic(String music,Integer ID,String albumname, String performer) {
		// TODO Auto-generated method stub
		return null;
	}

}
