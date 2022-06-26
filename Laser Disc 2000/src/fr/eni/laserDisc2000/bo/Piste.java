package fr.eni.laserDisc2000.bo;

import java.util.List;

public class Piste extends Album {

	public String libelle;

	public Piste(String nom, String pseudo, List<Album> listeAlbums, String titre, String dateDeSortie,
			List<Piste> listePistes, String libelle) {
		super(nom, pseudo, listeAlbums, titre, dateDeSortie, listePistes);
		this.libelle = libelle;

	}

	@Override
	public String toString() {
		return "Piste [libelle=" + libelle + "]";
	}

}
