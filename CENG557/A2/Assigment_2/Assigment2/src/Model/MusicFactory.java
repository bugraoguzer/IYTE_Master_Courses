package Model;

public class MusicFactory extends AbstractFactory {

	@Override
	Book getBook(String book,Integer ID,String bookname,String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Food getFood(String food,Integer ID,String foodname,String LastUsageDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Music getMusic(String music,Integer ID,String albumname,String performer) {
	       if (music == null) { 
	            return null; 
	        } 
	 
	        if (music == "string") { 
	            return new StringMusic(ID,albumname,performer); 
	        } else if (music == "science") { 
	            return new InstrumentsMusic(ID,albumname,performer); 
	        }
	        else
	        	return null; 
	}

}
