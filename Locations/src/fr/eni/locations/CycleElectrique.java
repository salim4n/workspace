package fr.eni.locations;

import java.time.LocalDate;

public abstract class CycleElectrique extends Cycle {

	private int autonomieKm;

	public CycleElectrique(LocalDate dateAchat, String marque, String modele, int autonomieKm) {
		super(dateAchat, marque, modele);
		this.autonomieKm = autonomieKm;

	}

	public int getAutonomieKm() {
		return autonomieKm;
	}

	public void setAutonomieKm(int autonomieKm) {
		this.autonomieKm = autonomieKm;
	}

	public String toString() {
		return String.format("%s %d km d'autonomie ", super.toString(), this.autonomieKm);
	}

	public abstract double getTarifLoc();

}
