package Model;

public class FreshFood implements Food {

	
	private String foodname;
	private String LastUsageDate;
	private Integer ID;
	
	FreshFood(Integer ID,String foodname, String LastUsageDate)
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
		return foodname;
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
