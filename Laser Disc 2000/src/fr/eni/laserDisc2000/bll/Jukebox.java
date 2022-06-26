package fr.eni.laserDisc2000.bll;

import fr.eni.laserDisc2000.bo.Album;
import fr.eni.laserDisc2000.bo.Piste;
import fr.eni.laserDisc2000.bo.Playlist;

public class Jukebox {

	static void lire(Piste piste) {
		System.out.println(piste.titre);
	}

	static void lire(Album album) {
		System.out.println(album.nom);
	}

	static void lire(Playlist playlist) {
		System.out.println(playlist.nom);
	}

	public static void main(String[] args) {
		
		Piste aloalo = new Piste(null, null, null, null, null, null, null);
		Album DoomDaDum = new Album(null, null, null, null, null, null);
		Playlist myPlaylist = new Playlist(null, null);
		
		lire(aloalo);
		lire(DoomDaDum);
		lire(myPlaylist);
		

	}

}
