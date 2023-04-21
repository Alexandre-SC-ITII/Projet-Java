package matrice;

public class Pierre extends Ressource implements Utilisable{
	private String id;

	public Pierre(String id) {
		this.id = id;

	}
	
	public ObjetManufacture utiliser(Ressource[] r) {
		ObjetManufacture Farine = new ObjetManufacture("Farine");
		return Farine;
	}

}
