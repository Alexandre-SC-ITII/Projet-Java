package matrice;

public class Heros {
	private String nom;
	private Ressource[] ble;
	private Ressource[] bois;
	private Ressource pierre;
	private ObjetManufacture feu;
	private ObjetManufacture farine;
	private int poidsEmporte;
	private int nbPartie;
	private int[][] caseCourante;

	public Heros(String nom) {
		ble = null;
		bois = null;
		pierre = null;
		feu = null;
		farine = null;
		poidsEmporte = 0;
		nbPartie = 0;
		caseCourante = new int[0][0];
	}

	public int jouer(Ressource[][] map) throws Exception{
		int deplacements = 0;
		int x = 0,y = 0;
		while (x != 9 || y != 9) {
            // Choisir la direction à prendre
            Direction direction = choisirDirection();
            
            // Se déplacer dans cette direction
            seDeplacer(direction, x, y);
            deplacements++;
        }
        
        return deplacements;
    }
    
    private Direction choisirDirection() {
        // Implémentation de la logique de choix de direction ici
    	Direction d;
    	
    	return d;
    }

	private void seDeplacer(Direction d, int x, int y) throws Exception {
		switch (d) {
		case HAUT:
			if (y == 0) {
				throw new Exception("Impossible, sortie de tableau");
			}
			y--;
			break;

		case BAS:
			if (y == 9) {
				throw new Exception("Impossible, sortie de tableau");
			}
			y++;
			break;

		case GAUCHE:
			if (x == 0) {
				throw new Exception("Impossible, sortie de tableau");
			}
			x--;
			break;

		case DROITE:
			if (x == 9) {
				throw new Exception("Impossible, sortie de tableau");
			}
			x++;
			break;
		}
	}
}
