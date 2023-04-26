package matrice;

public class Bois extends Ressource implements Utilisable {
	private String id;
	private static int poids = 2;

	public Bois(String id) {
		super(poids, id);
		this.id = id;

	}

	public ObjetManufacture utiliser(Ressource[] r) {
		int bois = 0;
		Boolean status = true;
		ObjetManufacture monFeu = new ObjetManufacture("Feu");
		ObjetManufacture nMonFeu = new ObjetManufacture("Pas de feu");
		
		for (int i = 0; i < 5; i++) {
			r[i] = new Ressource(poids, id);
			if (r[i] instanceof Bois) {
				bois++;
			}
		}
		if (bois == 5) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (i != j) {
						if (r[i].getNom() == r[j].getNom()) {
							status = false;
						}
					}
				}
			}
			if (status == true) {
				return monFeu;
			} else
				return nMonFeu;

		} else
			return nMonFeu;
	}

}
