package matrice;

public class Bois extends Ressource implements Utilisable {
	private String id;
	private static int poids = 2;

	public Bois(String id) {
		super(poids, id);
		this.id = id;

	}

	public ObjetManufacture utiliser(Ressource[] r) {
		ObjetManufacture monFeu = new ObjetManufacture("Feu");

		System.out.println(monFeu.getType() + " crée !");
		return monFeu;
	}

}
