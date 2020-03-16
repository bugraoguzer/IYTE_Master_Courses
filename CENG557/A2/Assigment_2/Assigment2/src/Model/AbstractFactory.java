package Model;

public abstract class AbstractFactory {

	abstract Book getBook(String book,Integer ID,String bookname,String author);
	abstract Food getFood(String food,Integer ID,String foodname,String LastUsageDate);
	abstract Music getMusic(String music,Integer ID,String albumname,String performer);
}
