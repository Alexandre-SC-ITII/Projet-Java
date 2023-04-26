package matrice;

public class Pierre extends Ressource implements Utilisable{
	private String id;
	private static int poids = 3;

	public Pierre(String id) {
		super(poids, id);
		this.id = id;

	}
	
	public ObjetManufacture utiliser(Ressource[] r) {
		int ble = 0;
		Boolean status = true;
		ObjetManufacture maFarine = new ObjetManufacture("Farine");
		ObjetManufacture nMaFarine = new ObjetManufacture("Pas de farine");
		
		for (int i = 0; i < 10; i++) {
			r[i] = new Ressource(poids, id);
			if (r[i] instanceof Ble) {
				ble++;
			}
		}
		if (ble == 10) {
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
				return maFarine;
			} else {
				return nMaFarine;
			}
		} else {
			return nMaFarine;
		}
	}

}
