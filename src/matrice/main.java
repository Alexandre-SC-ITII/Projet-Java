package matrice;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heros h = new Heros("Poulpe");
		Ressource[][] matrix1 = new Ressource[10][10];
		for (int i = 0; i < 10; i++) {
			matrix1[i][i] = new Ble("ble" + i);
		}
		matrix1[0][1] = new Pierre("Paul");
		matrix1[2][5] = new Bois("bois25");
		matrix1[3][1] = new Bois("bois31");
		matrix1[4][8] = new Bois("bois48");
		matrix1[5][2] = new Bois("bois52");
		matrix1[5][3] = new Bois("bois53");
		matrix1[9][1] = new Bois("bois91");

		Ressource[][] matrix2 = new Ressource[10][10];
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				matrix2[i][3] = new Ble("ble" + i);
			} else {
				matrix2[i][4] = new Ble("ble" + i);
			}
		}
		matrix2[8][5] = new Pierre("Jacques");
		matrix2[0][5] = new Bois("bois05");
		matrix2[5][1] = new Bois("bois51");
		matrix2[6][8] = new Bois("bois68");
		matrix2[8][2] = new Bois("bois82");
		matrix2[8][4] = new Bois("bois84");
		matrix2[9][9] = new Bois("bois99");

		Ressource[][] matrix4 = new Ressource[10][10];
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				matrix4[i][0] = new Ble("ble" + i);
			} else {
				matrix4[i][1] = new Ble("ble" + i);
			}
		}
		matrix4[9][9] = new Pierre("Jacques");
		matrix4[4][1] = new Bois("bois41");
		matrix4[4][8] = new Bois("bois48");
		matrix4[8][2] = new Bois("bois82");
		matrix4[8][3] = new Bois("bois83");
		matrix4[8][9] = new Bois("bois89");
		
		//System.out.println(matrix2[8][3]);

		System.out.println("Déplacements : " + h.jouer(matrix4));
	}

}
