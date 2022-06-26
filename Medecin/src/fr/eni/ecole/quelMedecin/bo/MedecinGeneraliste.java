package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste {

	private String nom;
	private String numeroDeTelephone;
	private String prenom;
	private static int tarif = 25;
	

	public MedecinGeneraliste(String nom, String prenom,  String numeroDeTelephone) {
		this.nom = nom;
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		
		
	}
	
	public void affichge() {
	System.out.println(" " + this.nom + " " + this.prenom);
	System.out.println("Telephone : " + this.numeroDeTelephone);
	System.out.println("Tarif : " + MedecinGeneraliste.tarif);
	}


	public String getNom() {
		return nom;
	}

	

	public String getPrenom() {
		return prenom;
	}




	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}


	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}


	public  int getTarif() {
		return MedecinGeneraliste.tarif;
	}


	public static  void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}






	
	

}
