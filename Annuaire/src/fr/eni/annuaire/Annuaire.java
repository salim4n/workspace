package fr.eni.annuaire;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public  class Annuaire<T,U > implements IManager<T, U> {
	
	Map<String,Contact>contacts;	
	
	
	public Annuaire() {
		contacts = new TreeMap<>();
		
	}

	@Override
	public void ajouter(T elem) {
		contacts.put((String) elem, null);
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public T rechercher(U clef) {

		return (T) contacts.values();
	}


	@Override
	public int rechercher() {
		
		return contacts.size();

		
	}

	@Override
	public void supprimer(U clef) {
		contacts.remove(clef);
		
	}
	
	
	
	



	
	

}
