public class SpinGraph {
	final float SCHWELLE = 0.2f;
	byte[] finalConfig;
	byte[][] eckenKombinationen;
	private float[][] kanten;
	boolean minIsSet = false;
	float min = 0;

	public SpinGraph(float[][] kanten, int anzahlEcken) {
		this.kanten = kanten;
		this.finalConfig = null;
		this.eckenKombinationen = new byte[(int) Math.pow(2, anzahlEcken)][anzahlEcken];
		simualtedAmnealing(anzahlEcken);	
	}
	
	
	public void bruteForce() {
		for(int i = 0; i < eckenKombinationen.length; i++) {
			String iBinary = Integer.toBinaryString(i);
			for(int j = 0; j < eckenKombinationen[i].length; j++) {
				if(j < iBinary.length()) {
					eckenKombinationen[i][eckenKombinationen[i].length - j - 1] = (byte) Integer.parseInt(String.valueOf(iBinary.charAt(iBinary.length() - j - 1)));
				} else
					eckenKombinationen[i][eckenKombinationen[i].length - j - 1] = 0;
			}
		}
		for(byte[] config : eckenKombinationen) {
			float energieConfig = energieBerechnen(config);
			if(minIsSet){
				min = energieConfig;
				minIsSet = true;
			} else if(energieConfig < min) {
					min = energieConfig;
					this.finalConfig = config;
			}
		}
	}
	
	
	public float energieBerechnen(byte[] config) {
		float energie = 0;
		byte[] tempConfig = config.clone();
		for(int i = 0; i < tempConfig.length; i++)
			tempConfig[i] = (byte) (tempConfig[i] * 2 -1);
		
		for (int i = 0; i < kanten.length; i++) {
			for (int j = 0; j < kanten.length; j++) {
				energie += kanten[i][j] * tempConfig[i] * tempConfig[j];
			}
		}
		return energie;
	}
	
	public void simualtedAmnealing(int anzahlEcken) {
		finalConfig = new byte[anzahlEcken]; //
	System.out.println(finalConfig.length);
		boolean letztesEins = false;
		for(int i = 0; i < finalConfig.length; i++) {
			if(!letztesEins) {
				finalConfig[i] = (byte) 1;
				letztesEins = true;
				System.out.println(finalConfig[i]);
			} else {
				finalConfig[i] = (byte) -1;
				letztesEins = false;
				System.out.println(finalConfig[i]);
			}
		}
		for(int t= 1 ; t <= 50; t++){	
			for(int j = 0; j < finalConfig.length; j++) {
				float e1 = energieBerechnen(finalConfig);
				finalConfig[j] *= -1;
				float e2 = energieBerechnen(finalConfig);
				finalConfig[j] *= -1;
				if(e2 > e1) {
					finalConfig[j] *= -1;
				} else if(Math.pow(Math.E, (-e1 - e2/t)) > SCHWELLE) {
					finalConfig[j] *= -1;
				}
			}
		}
		
	}
	
	public void printPerfectConfig() {
		System.out.println("Minimale Energie: " + min);
		for(byte ecke : finalConfig) {
			System.out.println(ecke);
		}
	}
}
