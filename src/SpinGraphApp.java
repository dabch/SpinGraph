
/**
 * QuickAndDirtyStyle(TM) by Michael Brenner
 * @author Monty King, Oliver Butowski und Daniel Bücheler
 *
 */
public class SpinGraphApp {

	public static void main(String[] args) {
		float[][] argument = new float[9][9];
		long startMillis;
		long endMillis;
		startMillis = System.currentTimeMillis();
		argument[0][1] = -5;
		argument[0][2] = 2;
		argument[0][6] = 4;
		argument[1][3] = -6;
		argument[1][6] = 3;
		argument[2][3] = -2;
		argument[2][4] = -4;
		argument[2][6] = -5;
		argument[2][7] = 16;
		argument[3][6] = 1;
		argument[3][5] = 1;
		argument[3][7] = -2;
		argument[4][7] = 2;
		argument[4][8] = 6;
		argument[5][8] = 4;
		argument[5][7] = 3;
		argument[7][8] = -4;
		SpinGraph sg = new SpinGraph(argument);
		sg.printPerfectConfig();
		endMillis = System.currentTimeMillis();
		System.out.println("Zeit zur Berechnung: " + (endMillis - startMillis) + " ms");
	}

}
