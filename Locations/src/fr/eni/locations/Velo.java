package fr.eni.locations;

import java.time.LocalDate;

public class Velo extends Cycle {

	private int nbVitesse;

	public Velo(LocalDate dateAchat, String marque, String modele, int nbVitesse) {
		super(dateAchat, marque, modele);
		this.nbVitesse = nbVitesse;

	}

	public int getNbVitesse() {
		return nbVitesse;
	}

	public void setNbVitesse(int nbVitesse) {
		this.nbVitesse = nbVitesse;
	}

	@Override
	public double getTarifLoc() {

		return 4.9;
	}

	public String toString() {
		return String.format("%s %d vitesse%s", super.toString(), this.nbVitesse, this.nbVitesse > 1 ? "s" : "");
	}

}
