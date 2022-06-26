package fr.eni.locations;

import java.time.LocalDate;

public class Gyropode extends CycleElectrique {
	
	private int tailleMinCm;

	public Gyropode(LocalDate dateAchat, String marque, String modele, int autonomieKm, int tailleMinCm) {
		super(dateAchat, marque, modele, autonomieKm);
		this.tailleMinCm = tailleMinCm;
	}

	public int getTailleMinCm() {
		return tailleMinCm;
	}

	public void setTailleMinCm(int tailleMinCm) {
		this.tailleMinCm = tailleMinCm;
	}

	@Override
	public double getTarifLoc() {
	
		return 29.9;
	}
	
	public String toString() {
		return String.format("%s [%dm%d min]",
				super.toString(),
				this.tailleMinCm/100,
				this.tailleMinCm%100);
	}

}
