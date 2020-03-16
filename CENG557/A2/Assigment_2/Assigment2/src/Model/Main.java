package Model;

public class Main {

	public static void main(String[] args) {
		
		AbstractFactory BookFactory = FactoryMaker.getFactory("Book"); 
		Book novel1 = BookFactory.getBook("drama",121324,"to kill a mockingbird","harper lee"); 
		//System.out.println(book.getBookname());
		//System.out.println(book.getAuthor());
		
		AbstractFactory FoodFactory = FactoryMaker.getFactory("Food"); 
		Food pringles1 = FoodFactory.getFood("fresh",312421,"pringles","10.13.2020");
		//System.out.println(food.getFoodname());
		//System.out.println(food.getLastUsageDate());
		
		AbstractFactory MusicFactory = FactoryMaker.getFactory("Music"); 
		Music album1 = MusicFactory.getMusic("string",421321,"Come Fly With Me", "Frank Sinatra"); 
		//System.out.println(music.getAlbumName());
		//System.out.println(music.getMusianname());
		
		
		PackageItem bookpacket = new PackageItem(novel1.getID());
		bookpacket.setPackingType(novel1.getPackType());
		bookpacket.pack();
		
		PackageItem foodpacket = new PackageItem(pringles1.getID());
		foodpacket.setPackingType(pringles1.getPackType());
		foodpacket.pack();
		
		PackageItem albumpacket = new PackageItem(album1.getID());
		foodpacket.setPackingType(album1.getPackType());
		foodpacket.pack();

		
		
		
	}

}
