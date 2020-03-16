package Model;

import java.util.ArrayList;

public class PackageItem {
	
	ArrayList<PackingMaterials> lists = new ArrayList<PackingMaterials>();
	
	private String content;
	private IPackaging ipackaging;
	private Integer ItemID;
	
	
	public void setPackingType(IPackaging ipackaging)
	{
		this.ipackaging = ipackaging;
	}
	
	public void pack() {
		ipackaging.pack(this);
		System.out.println(lists);
		lists.clear();
	}

	public void add(PackingMaterials material) {
		
		lists.add(material);
	}
	
	 public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	PackageItem(Integer ID)
	 {
		
		 this.ItemID = ID;
	 }
	 
}
