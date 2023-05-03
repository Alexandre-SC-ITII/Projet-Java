package matrice;

import java.util.ArrayList;
import java.util.List;

public class Heros {
	private String nom;
	private List<Ressource> stockBle;
	private List<Ressource> stockBois;
	private Pierre pierre;
	private ObjetManufacture feu;
	private ObjetManufacture farine;
	private int poidsEmporte;
	private int nbPartie;
	private int x;
	private int y;
	private Ressource casecourante;
	private boolean pain = false;

	// Constructeur
	public Heros(String nom) {
		this.nom = nom;
		this.stockBle = new ArrayList<>();
		this.stockBois = new ArrayList<>();
		this.pierre = new Pierre(null);
		this.feu = null;
		this.feu = new ObjetManufacture(null);
		this.farine = new ObjetManufacture(null);
		this.poidsEmporte = 0;
		this.nbPartie = 0;
		this.x = 0;
		this.y = 0;
	}

	public int jouer(Ressource[][] map) {
		int deplacements = 0;
		int ramassage = 0;

		System.out.println("Position : " + x + " " + y);
		// Choisir la direction à prendre
		Direction direction;
		while (pain == false) {
			casecourante = map[x][y];
			direction = choisirDirection();
			switch (ramassage) {
			case 0:
				if (casecourante instanceof Ble || casecourante instanceof Pierre) {
					prendre();
					if (pierre.getNom() != null) {
						if (stockBle.size() == 10) {
							Ressource[] tabBle = new Ressource[stockBle.size()];
							for (int i = 0; i < 10; i++) {
								tabBle[i] = stockBle.get(i);
							}
							farine = pierre.utiliser(tabBle);
							poidsEmporte = 0;

							while (x != 0) {
								x--;
								deplacements++;
							}

							while (y != 0) {
								y--;
								deplacements++;
							}
							ramassage = 1;
						}
					}
				}
				break;

			case 1:
				if (farine.getType() != null && casecourante instanceof Bois) {
					prendre();
					if (stockBois.size() == 5) {
						Ressource[] tabBois = new Ressource[stockBle.size()];
						Bois b = new Bois("b");
						for (int i = 0; i < 5; i++) {
							tabBois[i] = stockBois.get(i);
						}
						feu = b.utiliser(tabBois);

						while (x != 9) {
							x++;
							deplacements++;
						}

						while (y != 9) {
							y++;
							deplacements++;
						}

					}
				}
				break;
			}
			pain = fairePain(farine, feu);

			// Se déplacer dans cette direction
			try {
				seDeplacer(direction);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();

				direction = choisirDirection();
			}
			System.out.println("Position : " + x + " " + y);
			deplacements++;
		}

		if (pain == true) {
			System.out.println("Le pain est fabriqué !");
		}

		return deplacements;
	}

	public boolean fairePain(ObjetManufacture fa, ObjetManufacture fe) {
		if (fa.getType() != null && fe.getType() != null)
			return true;
		else
			return false;
	}

	private Direction choisirDirection() {
		if (y % 2 == 0 && x != 9) {
			System.out.println("DROITE");
			return Direction.DROITE;
		}

		else if (y % 2 == 1 && x != 0) {
			System.out.println("GAUCHE");
			return Direction.GAUCHE;
		}

		else
			System.out.println("BAS");
		return Direction.BAS;

	}

	private void seDeplacer(Direction d) throws Exception {
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

	public void prendre() {
		Ressource ressource = casecourante;
		if (ressource == null) {
			System.out.println("Il n'y a rien à prendre ici.");
		} else if (this.poidsEmporte + ressource.getPoids() > 13) {
			System.out.println("Vous ne pouvez pas porter autant de poids.");
		} else {
			if (ressource instanceof Ble) {
				this.stockBle.add(ressource);
			} else if (ressource instanceof Bois) {
				this.stockBois.add(ressource);
			} else if (ressource instanceof Pierre) {
				this.pierre = new Pierre(ressource.getNom());
			}
			this.poidsEmporte += ressource.getPoids();
			casecourante = null;
			System.out.println("Vous avez pris : " + ressource.getNom());
		}
	}

}
