package fr.eni.test.exceptions;

public enum Armure {

	LEGERE(1 / 5), MOYENNE(1 / 3), LOURDE(1 / 2);

	private int absorptionDegat;

	private Armure(int absorptionDegat) {
		this.absorptionDegat = absorptionDegat;
	}

	public double getAbsorptionDegat() {
		return absorptionDegat;

	}

}
 