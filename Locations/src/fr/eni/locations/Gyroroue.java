package fr.eni.locations;

import java.time.LocalDate;

public class Gyroroue extends CycleElectrique {

	public Gyroroue(LocalDate dateAchat, String marque, String modele, int autonomieKm) {
		super(dateAchat,marque,modele,autonomieKm);
	}

	@Override
	public double getTarifLoc() {
		
		return 18.9;
	}
	
	
}
