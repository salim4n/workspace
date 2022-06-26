package fr.eni.coucheBLL;

import java.time.LocalDate;
import java.time.LocalTime;

import fr.eni.coucheBO.Aliment;
import fr.eni.coucheBO.Repas;
import fr.eni.coucheDAL.MethodeDAO;
import fr.eni.coucheDAL.SuiviRepasDAOFactory;

public class SuiviRepasManager {

	private MethodeDAO methodeDAO;

	public SuiviRepasManager() {
		this.methodeDAO = SuiviRepasDAOFactory.getSuiviRepas();
	}

	public Repas ajouterRepas(LocalDate date, LocalTime heureRepas) {

		Repas repas = new Repas(date, heureRepas);
		return repas;
	}

	public Aliment ajouterAliment(String nom) {

		Aliment aliment = new Aliment(nom);
		return aliment;
	}

}
