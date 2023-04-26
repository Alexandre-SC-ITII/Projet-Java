package matrice;

public class Ressource {
	private int poids = 0;
	private String nom;

	public Ressource(int poids, String nom) {
		this.poids = poids;
		this.nom = nom;
	}
	public int getPoids() {
		return poids;
	}
	
	public String getNom() {
		return nom;
	}
}
