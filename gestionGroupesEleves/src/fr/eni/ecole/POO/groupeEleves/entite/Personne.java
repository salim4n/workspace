package fr.eni.ecole.POO.groupeEleves.entite;

import java.time.LocalDate;

public abstract class Personne {
	
	private String nom;
	private String prenom;
	private String adresse;
	private LocalDate ddn;
	
	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", ddn=" + ddn + "]";
	}

	public Personne() {
		
	}

	public Personne(String nom,String prenom, String adresse, LocalDate ddn) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAdresse(adresse);
		this.setDdn(ddn);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public LocalDate getDdn() {
		return ddn;
	}

	public void setDdn(LocalDate ddn) {
		this.ddn = ddn;
	}
		
	

}
