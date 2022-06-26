package fr.eni.coucheDAL;

public abstract class SuiviRepasDAOFactory {
	
	public static MethodeDAO getSuiviRepas() {
		
		return new RepasDAOjdbcImpl();
	}

}
