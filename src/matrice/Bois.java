package matrice;

public class Bois extends Ressource implements Utilisable {
	private String id;

	public Bois(String id) {
		this.id = id;

	}

	public ObjetManufacture utiliser(Ressource[] r) {
		ObjetManufacture Feu = new ObjetManufacture("Feu");
		return Feu;
	}

}
