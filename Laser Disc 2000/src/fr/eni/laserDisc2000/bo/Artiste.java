package fr.eni.laserDisc2000.bo;

import java.util.List;

public class Artiste {

	public String nom;
	public String pseudo;
	public List<Album> listeAlbums;

	public Artiste() {

	}

	
	public Artiste(String nom, String pseudo, List<Album> listeAlbums) {
		this.nom = nom;
		this.pseudo = pseudo;
		this.listeAlbums = listeAlbums;

	}

	@Override
	public String toString() {
		return "Artiste [nom=" + nom + ", pseudo=" + pseudo + ", listeAlbums=" + listeAlbums + "]";
	}

}
