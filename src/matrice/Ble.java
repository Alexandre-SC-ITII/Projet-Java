package matrice;

public class Ble extends Ressource{
	private String id;
	private static int poids = 1;
	
	public Ble(String id) {
		super(poids, id);
		this.id = id;
	}

}
