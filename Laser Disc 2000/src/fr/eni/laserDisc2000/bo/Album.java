package fr.eni.laserDisc2000.bo;

import java.util.List;

public class Album extends Artiste {

	public String titre;
	public String dateDeSortie;
	
	public List<Piste> listePistes;

	
	public Album(String nom, String pseudo, List<Album> listeAlbums, String titre, String dateDeSortie,
			List<Piste> listePistes) {
		super(nom, pseudo, listeAlbums);
		this.titre = titre;
		this.dateDeSortie = dateDeSortie;
		this.listePistes = listePistes;

	}

	@Override
	public String toString() {
		return "Album [titre=" + titre + ", dateDeSortie=" + dateDeSortie + ", listePistes=" + listePistes + "]";
	}

}
