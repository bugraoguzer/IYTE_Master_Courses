package Model;

public class DramaBook implements Book {

	private String bookname;
	private String author;
	private Integer ID;
	
	DramaBook(Integer ID ,String bookname, String author)
	{
		this.bookname = bookname;
		this.author = author;
		this.ID = ID;
	}
	
	public Integer getID() {
		return ID;
	}

	@Override
	public String getBookname() {
		return bookname;
	}

	@Override
	public IPackaging getPackType() {
		// TODO Auto-generated method stub
		return new BoxPack();
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return author;
	}

}
