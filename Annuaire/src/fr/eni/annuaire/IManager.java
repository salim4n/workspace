package fr.eni.annuaire;

import java.util.Collection;

public interface IManager<T, U> {
	
	void ajouter(T elem);
	
	T rechercher(U clef);
	
	int rechercher();
	
	void supprimer(U clef);
	

}
