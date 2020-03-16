package Model;

public class ColdPack implements IPackaging{

	@Override
	public void pack(PackageItem deneme) {
		
        deneme.add(PackingMaterials.Box);
        deneme.add(PackingMaterials.Tape);
        deneme.add(PackingMaterials.Foam);
        deneme.add(PackingMaterials.DryIce);
        
		
	}

	
	
}
