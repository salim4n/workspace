package fr.eni.ecole.quelMedecin.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Creneau {

	private LocalTime date;
	private int duree;
	MedecinGeneraliste medecin;

	public Creneau(LocalTime date, int duree, MedecinGeneraliste medecin) {
		this.date = date;
		this.duree = duree;
		this.medecin = medecin;
		medecin.ajouterCreneau(this);
	}

	public void afficher() {
		System.out.printf("%s - %s (%d minutes)%n",
				this.date.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
				this.date.plusMinutes(this.duree).format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)),
				this.duree);
	}

	public int getDuree() {
		return duree;
	}

	public LocalTime getDate() {
		return date;
	}

	public MedecinGeneraliste getMedecin() {
		return medecin;
	}

}
