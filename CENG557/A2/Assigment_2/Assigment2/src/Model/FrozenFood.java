package Model;

public class FrozenFood implements Food {

	
	private String foodname;
	private String LastUsageDate;
	private Integer ID;
	
	FrozenFood(Integer ID,String foodname, String LastUsageDate)
	{
		this.foodname = foodname;
		this.LastUsageDate = LastUsageDate;
		this.ID = ID;
	}
	
	public Integer getID() {
		return ID;
	}
	
	@Override
	public String getFoodname() {
		return null;
	}

	@Override
	public String getLastUsageDate() {
		// TODO Auto-generated method stub
		return LastUsageDate;
	}

	@Override
	public IPackaging getPackType() {
		// TODO Auto-generated method stub
		return new ColdPack();
	}

}
