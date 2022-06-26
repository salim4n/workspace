package fr.eni.ecole.quelMedecin.test;

public class MedecinGeneraliste extends Personne {

	public static final int MAX_CRENAUX = 15;
	private static int tarif = 25;
	private Creneau[] creneaux = new Creneau[MAX_CRENAUX];

	public MedecinGeneraliste(String nom, String prenom, String numeroDeTelephone, Adresse adresse ) {
		super(nom, prenom, numeroDeTelephone, adresse );
	}

	public void affichage() {
		System.out.printf("%s %s %n Telephone : %s%n tarif %d euro%n", this.getNom(), this.getPrenom(),
				this.getNumeroDeTelephone(), MedecinGeneraliste.tarif);
	}

	public void afficher() {
		System.out.printf("%s %s %n Telephone : %s%n tarif %d euro%n", this.getNom(), this.getPrenom(),
				this.getNumeroDeTelephone(), MedecinGeneraliste.tarif);
		getAdresse().afficher();
		System.out.println("Creneaux : ");

		for (int i = 0; i < this.creneaux.length; i++) {
			if (this.creneaux[i] != null)
				this.creneaux[i].afficher();
		}

	}

	void ajouterCreneau(Creneau creneauAAjouter) {
		if (this != creneauAAjouter.getMedecin()) {
			System.err.println("Ce creneau ne peut etre associe a ce medecin " + " car il est deja associe a un autre");
		} else {
			int pos = 0;
			while (pos < this.creneaux.length && this.creneaux[pos] != null)
				pos++;
			if (pos == this.creneaux.length) {
				System.err.println("Trop de creneaux sont affectes a ce medecin");
			} else {
				this.creneaux[pos] = creneauAAjouter;
			}
		}
	}

	public String getNumeroDeTelephone() {
		return getNumeroDeTelephone();
	}
	


	public int getTarif() {
		return MedecinGeneraliste.tarif;
	}

	public static void setTarif(int tarif) {
		MedecinGeneraliste.tarif = tarif;
	}

	public Adresse getAdresse() {
		return getAdresse();
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

}
