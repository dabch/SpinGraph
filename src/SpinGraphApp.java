
/**
 * @author Monty King, Oliver Butowski und Daniel B�cheler
 *
 */
public class SpinGraphApp {

	public static void main(String[] args) {
		float[][] kanten = new float[9][9];
		long startMillis = System.currentTimeMillis();
		long endMillis;
		kanten = kantenEintragen();
		SpinGraph sg = new SpinGraph(kanten);
		sg.printPerfectConfig();
		endMillis = System.currentTimeMillis();
		System.out.println("Zeit zur Berechnung: " + (endMillis - startMillis) + " ms");
	}
	
	public static float[][] kantenEintragen() {
		int knotenzahl = 9;
		float[][] einzutragen = {
				{0, 1, -5},
				{0, 2, 2},
				{0, 6, 4},
				{1, 3, -6},
				{1, 6, 3},
				{2, 3, -2},
				{2, 4, -4},
				{2, 6, -5},
				{2, 7, 16},
				{3, 6, 1},
				{3, 5, 1},
				{3, 7, -2},
				{4, 7, 2},
				{4, 8, 6},
				{5, 8, 4},
				{5, 7, 3},
				{7, 8, -4}};
		float[][] kanten = new float[knotenzahl][knotenzahl];
		for(float[] kante : einzutragen)
			kanten[(int) kante[0]][(int) kante[1]] = kante[2];
		return kanten;
	}	
}
