public class SpinGraph {
	int[] ecken;
	private float[][] kanten;

	public SpinGraph(float[][] ecken) {
		this.kanten = ecken;
		this.ecken = new int[ecken.length];
		System.out.println(energieBerechnen());
	}

	public float energieBerechnen() {
		float energie = 0;
		for(int i = 0; i < ecken.length; i++) {
			ecken[i] = 1;
		}
		for (int i = 0; i < kanten.length; i++) {
			for (int j = 0; j < kanten.length; j++) {
				System.out.println(ecken[i] + " * " + ecken[j] +  " * " + kanten[i][j] + " = " + (kanten[i][j] * ecken[i] * ecken[j]));
				energie += kanten[i][j] * ecken[i] * ecken[j];
			}
		}
		return energie;
	}
}
