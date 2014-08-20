
/**
 * @author Monty King, Oliver Butowski und Daniel B�cheler
 *
 */
public class SpinGraphApp {

	public static void main(String[] args) {
		float[][] kanten = new float[9][9];
		long startMillis;
		long endMillis;
		startMillis = System.currentTimeMillis();
		kanten[0][1] = -5;
		kanten[0][2] = 2;
		kanten[0][6] = 4;
		kanten[1][3] = -6;
		kanten[1][6] = 3;
		kanten[2][3] = -2;
		kanten[2][4] = -4;
		kanten[2][6] = -5;
		kanten[2][7] = 16;
		kanten[3][6] = 1;
		kanten[3][5] = 1;
		kanten[3][7] = -2;
		kanten[4][7] = 2;
		kanten[4][8] = 6;
		kanten[5][8] = 4;
		kanten[5][7] = 3;
		kanten[7][8] = -4;
		SpinGraph sg = new SpinGraph(kanten);
		sg.printPerfectConfig();
		endMillis = System.currentTimeMillis();
		System.out.println("Zeit zur Berechnung: " + (endMillis - startMillis) + " ms");
	}
	
	public void eintragen(int ecke1, int ecke2, float wert){
		
	}
	
	

}
