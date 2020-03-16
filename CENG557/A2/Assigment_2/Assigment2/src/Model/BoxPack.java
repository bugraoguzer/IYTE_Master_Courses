package Model;

public class BoxPack implements IPackaging{

	@Override
	public void pack(PackageItem deneme) {
		
        deneme.add(PackingMaterials.Box);
        deneme.add(PackingMaterials.Tape);
		
	}

	
	
}
