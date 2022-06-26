package fr.eni.ecole.POO.groupeEleves.entite;

public interface Classe {
	
	public static final String nom = "";
	public static final int nbEleves = 0;
	
	
	void addEleve(Eleve eleve);
	
	Eleve getEleve(int index);
	
	Eleve[] getEleve();
	
	Parent[] getParent();
	
	String getNom();
	
	Instituteur getInstituteur();
	
	String toString();
	
	

}
