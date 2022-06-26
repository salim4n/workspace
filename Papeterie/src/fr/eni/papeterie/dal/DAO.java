package fr.eni.papeterie.dal;

import java.util.List;

/**
 * CRUD = Create Read Update Delete
 * Et la Généricité <T>
 */
public interface DAO<T> {

	/**
	 * @author Eni Ecole
	 *
	 */	
		//Insérer un nouveau business object -- CREATE
		public void insert(T data) throws DALException;
	
		//Sélectionner un business object par son id -- READ
		public T selectById(int id) throws DALException;
		
		//Sélectionner tous les business objects  -- READ ALL
		public List<T> selectAll() throws DALException;
		
		//Modifier les attributs d'un business object
		public void update(T data) throws DALException;
		
		//Supprimer un business object
		public void delete(int id) throws DALException;
		
	
}
