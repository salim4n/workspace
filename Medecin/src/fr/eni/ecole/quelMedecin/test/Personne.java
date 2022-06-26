package fr.eni.ecole.quelMedecin.test;

public class Personne {
	
	protected String nom;
	protected String prenom;
	protected String numerDeTelephone;
	protected Adresse adresse;
	
	public Personne (String nom, String prenom, String numeroDeTelephone, Adresse adresse) {
	this.nom = nom;
	this.prenom = prenom;
	this.numerDeTelephone = numeroDeTelephone;
	this.adresse = adresse;
	};
	
	public void afficher() {
		System.out.printf("%s %s%nTelephone : %s%n",
				this.nom,
				this.numerDeTelephone);
	}

}
