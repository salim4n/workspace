package fr.eni.ecole.POO.groupeEleves.entite;

import java.time.LocalDate;

public class Eleve extends Personne implements Classe {

	public Eleve() {
		super();
		
	}

	public Eleve(String nom, String prenom, String adresse, LocalDate ddn) {
		super(nom, prenom, adresse, ddn);
		
	}
	
	public void setParent(Parent referent) {
		this.setParent(referent);
	}

	@Override
	public void addEleve(Eleve eleve) {
		
		
	}

	@Override
	public Eleve getEleve(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eleve[] getEleve() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Parent[] getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instituteur getInstituteur() {
		// TODO Auto-generated method stub
		return null;
	}



}
