public class SpinGraph {
	byte[] finalConfig;
	byte[][] eckenKombinationen;
	float[][] kanten;
	boolean minIsSet = false;
	float min = 0;

	public SpinGraph(float[][] kanten) {
		this.kanten = kanten;
		this.finalConfig = null;
		this.eckenKombinationen = new byte[(int) Math.pow(2, kanten.length)][kanten.length];
		erstelleMoeglichkeitenArray();
		boolean minIsSet = false;
		for(byte[] config : eckenKombinationen) {
			float energieConfig = berechneEnergie(config);
			if(minIsSet){
				min = energieConfig;
				minIsSet = true;
			} else if(energieConfig < min) {
					min = energieConfig;
					this.finalConfig = config;
			}
		}
	}
	
	
	public void erstelleMoeglichkeitenArray() {
		for(int i = 0; i < eckenKombinationen.length; i++) {
			String iBinary = Integer.toBinaryString(i);
			for(int j = 0; j < eckenKombinationen[i].length; j++) {
				if(j < iBinary.length()) {
					eckenKombinationen[i][eckenKombinationen[i].length - j - 1] = (byte) Integer.parseInt(String.valueOf(iBinary.charAt(iBinary.length() - j - 1)));
				} else
					eckenKombinationen[i][eckenKombinationen[i].length - j - 1] = 0;
			}
		}
	}
	
	
	public float berechneEnergie(byte[] config) {
		float energie = 0;
		for(int i = 0; i < config.length; i++)
			config[i] = (byte) (config[i] * 2 -1);
		
		for (int i = 0; i < kanten.length; i++) {
			for (int j = 0; j < kanten.length; j++) {
				energie += kanten[i][j] * config[i] * config[j];
			}
		}
		return energie;
	}
	
	public void printPerfectConfig() {
		System.out.println("Minimale Energie: " + min);
		for(byte ecke : finalConfig) {
			System.out.println(ecke);
		}
	}
}
