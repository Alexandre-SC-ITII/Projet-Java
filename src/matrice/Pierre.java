package matrice;

public class Pierre extends Ressource implements Utilisable {
	private String id;
	private static int poids = 3;

	public Pierre(String id) {
		super(poids, id);
		this.id = id;

	}

	public ObjetManufacture utiliser(Ressource[] r) {
		ObjetManufacture maFarine = new ObjetManufacture("Farine");

		System.out.println(maFarine.getType() + " crée !");
		return maFarine;
	}

}
