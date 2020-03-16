package Model;

public class InstrumentsMusic implements Music {


	private String albumname;
	private String performer;
	private Integer ID;
	
	InstrumentsMusic(Integer ID,String albumname,String performer)
	{
		this.albumname = albumname;
		this.performer = performer;
		this.ID = ID;
	}
	
	public Integer getID() {
		return ID;
	}
	
	@Override
	public String getMusianname() {
		// TODO Auto-generated method stub
		return performer;
	}

	@Override
	public String getAlbumName() {
		// TODO Auto-generated method stub
		return albumname;
	}

	@Override
	public IPackaging getPackType() {
		// TODO Auto-generated method stub
		return new EnvelopePack();
	}

}
