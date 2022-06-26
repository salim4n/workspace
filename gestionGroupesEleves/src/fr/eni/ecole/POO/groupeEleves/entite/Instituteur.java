package fr.eni.ecole.POO.groupeEleves.entite;

import java.time.LocalDate;

public class Instituteur extends Personne implements Classe {

	public Instituteur() {
		super();
		
	}

	public Instituteur(String nom, String prenom, String adresse, LocalDate ddn) {
		super(nom, prenom, adresse, ddn);
		
	}

	@Override
	public void addEleve() {
		// TODO Auto-generated method stub
		
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
