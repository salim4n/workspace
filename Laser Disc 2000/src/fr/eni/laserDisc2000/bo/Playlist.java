package fr.eni.laserDisc2000.bo;

import java.util.List;

public class Playlist {

	public String nom;

	public List<Piste> listePistes;

	public Playlist(String nom, List<Piste> listePistes) {
		this.nom = nom;
		this.listePistes = listePistes;
	}

	@Override
	public String toString() {
		return "Playlist [nom=" + nom + ", listePistes=" + listePistes + "]";
	}

}
