package Model;

public class EnvelopePack implements IPackaging{

	@Override
	public void pack(PackageItem deneme) {
		
        deneme.add(PackingMaterials.Stamps);
        deneme.add(PackingMaterials.Envelope);
		
	}

	
	
}
