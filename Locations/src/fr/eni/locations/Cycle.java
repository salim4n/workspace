package fr.eni.locations;

import java.time.LocalDate;

public abstract class Cycle {

	private LocalDate dateAchat;
	private String marque;
	private String modele;

	public Cycle(LocalDate dateAchat, String marque, String modele) {
		this.setDateAchat(dateAchat);
		this.setMarque(marque);
		this.setModele(modele);
	}

	public int age() {
		return dateAchat.until(LocalDate.now()).getYears();

	}

	public abstract double getTarifLoc();

	public String toString() {
		int age = this.age();
		return String.format("%s %s %s (%dan%s) ", this.getClass().getSimpleName(), this.marque, this.modele, age,
				age > 1 ? "s" : "");
	}

	public LocalDate getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

}
