package Model;

public class BookFactory extends AbstractFactory {

	@Override
	Book getBook(String book,Integer ID,String bookname,String author) {
		// TODO Auto-generated method stub
	       if (book == null) { 
	            return null; 
	        } 
	        if (book == "drama") { 
	            return new DramaBook(ID,bookname,author); 
	        } else if (book == "science") { 
	            return new ScienceBook(ID,bookname,author); 
	        } else if (book == "adventure")
	        	return new AdventureBook(ID,bookname,author);
	        else
	        	return null; 
	}

	@Override
	Food getFood(String food,Integer ID,String foodname,String LastUsageDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Music getMusic(String music,Integer ID,String albumname,String performer) {
		// TODO Auto-generated method stub
		return null;
	}

}
