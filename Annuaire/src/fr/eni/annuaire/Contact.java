package fr.eni.annuaire;


public class Contact   {
	
	String nom;
	
	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", noTelephone=" + noTelephone + "]";
	}

	String noTelephone;
	
	public Contact() {
		
	}
	
	public Contact(String nom, String noTelephone) {
		this.nom = nom;
		this.noTelephone = noTelephone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNoTelephone() {
		return noTelephone;
	}

	public void setNoTelephone(String noTelephone) {
		this.noTelephone = noTelephone;
	}
	
	

}
