package fr.eni.ecole.quelMedecin.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Patient extends Personne  {
	

	private char sexe;
	private long numeroSecu;
	private LocalDate date;
	private String commentaires;
	
		

	
public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numeroSecu, LocalDate date, String commentaires, Adresse adresse) {
	super(nom,prenom,numeroDeTelephone, adresse);
	this.sexe = sexe;
	this.numeroSecu = numeroSecu;
	this.date = date;
	this.commentaires = commentaires;
	}




public void afficher() {
	super.afficher();
	System.out.printf("Sexe : %s%nNumero de securite sociale : %d%n" +
	"Date de naissance : %s%nCommentaires : %s%nAdresse : %n",
	this.sexe == 'F' ? "Feminin" : "Masculin",
			this.numeroSecu,
			this.date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)),
			this.commentaires != null ? this.commentaires : "[aucun commentaire]");
	this.adresse.afficher();
		
}






public String getNumeroDeTelephone() {
	return getNumeroDeTelephone();
}


public char getSexe() {
	return sexe;
}


public long getNumeroSecu() {
	return numeroSecu;
}


public LocalDate getDate() {
	return date;
}


public String getCommentaires() {
	return commentaires;
}


public void setCommentaires(String commentaires) {
	this.commentaires = commentaires;
}

public Adresse getAdresse() {
	return adresse;
}

public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
}


}
