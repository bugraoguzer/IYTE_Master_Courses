package Model;

public class AdventureBook implements Book {

	private String bookname;
	private String author;
	private Integer ID;
	AdventureBook(Integer ID ,String bookname, String author)
	{
		this.bookname = bookname;
		this.author = author;
		this.ID = ID;
	}
	
	public Integer getID() {
		return ID;
	}
	
	public String getBookname() {
		return bookname;
	}

	public IPackaging getPackType() {
		return new BoxPack();
	}

	public String getAuthor() {
		return author;
	}

}
