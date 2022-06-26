package fr.eni.ecole.quelMedecin.bo;

import java.time.LocalDate;



public class Patient {
	
	
	private String nom;
	private String prenom;
	private String numeroDeTelephone;
	private char sexe;
	private long numeroSecu;
	private LocalDate date;
	private String commentaires;
		
	
	
	
public Patient(String nom, String prenom, String numeroDeTelephone, char sexe, long numeroSecu, LocalDate date, String commentaires) {
		this.nom = nom.toUpperCase();
		this.prenom = prenom;
		this.numeroDeTelephone = numeroDeTelephone;
		this.sexe = sexe;
		this.numeroSecu = numeroSecu;
		this.date = date;
		this.commentaires = commentaires;
	}

public void afficher() {
	System.out.println(this.nom + " " + this.prenom);
	System.out.println("Telephone : " + this.numeroDeTelephone);
	System.out.println("Sexe :" + this.sexe);
	System.out.println("Numero de securite sociale : " + this.numeroSecu);
	System.out.println("Date de naissance : " + this.date);
	System.out.println("Commentaires : " + this.commentaires);
		
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






}


