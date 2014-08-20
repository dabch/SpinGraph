
public class SpinGraphApp {

	public static void main(String[] args) {
		float[][] argument = new float[4][4];
		argument[0][1] = -2;
		argument[0][2] = 1.5f;
		argument[1][2] = 3;
		argument[2][3] = 5;
		SpinGraph sg = new SpinGraph(argument);
	}

}
