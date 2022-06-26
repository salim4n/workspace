package fr.eni.coucheDAL;

import java.sql.SQLException;

import fr.eni.coucheBO.Aliment;
import fr.eni.coucheBO.Repas;

public interface MethodeDAO {
	
	public void insertRepas(Repas repas) throws SQLException ;
	
	public void insertAliment(Aliment aliment, int id_repas) throws SQLException;
	
	public void voireRepas() throws SQLException;
	
	public void voireAliments() throws SQLException ;

}
