/**
 * 
 */
package fr.eni.papeterie.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import fr.eni.papeterie.bo.Article;
import fr.eni.papeterie.bo.Ramette;
import fr.eni.papeterie.bo.Stylo;
import fr.eni.papeterie.dal.ArticleDAO;
import fr.eni.papeterie.dal.DALException;
import fr.eni.papeterie.dal.JdbcTools;

/**
 * @author Eni Ecole
 * 
 */
public class ArticleDAOJdbcImpl implements ArticleDAO {

	private static final String TYPE_STYLO = "STYLO";
	private static final String TYPE_RAMETTE = "RAMETTE";

	private static final String sqlSelectById = "select *  from articles where idArticle = ?";
	private static final String sqlSelectAll = "select *  from articles";
	private static final String sqlUpdate = "update articles set reference=?,marque=?,designation=?,"
			+ "prixUnitaire=?,qteStock=?,grammage=?,couleur=? where idArticle=?";
	private static final String sqlInsert = "insert into articles(reference,marque,designation,"
			+ "prixUnitaire,qteStock,type,grammage,couleur) values(?,?,?,?,?,?,?,?)";
	private static final String sqlDelete = "delete from articles where idArticle=?";

	private static final String sqlSelectByMarque = "select idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type "
			+ " from articles where marque = ?";
	private static final String sqlSelectByMotCle = "select idArticle, reference, marque, designation, prixUnitaire, qteStock, grammage, couleur, type "
			+ " from articles where marque like ? or designation like ?";

	public Article selectById(int id) throws DALException {
		Article art = null;
		// Utilisation de java.lang.AutoCloseable et try-with-resources
		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(sqlSelectById);) {
			rqt.setInt(1, id);

			try (ResultSet rs = rqt.executeQuery();) {
				if (rs.next()) {

					if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {

						art = new Stylo(rs.getInt("idArticle"), rs.getString("marque"),
								rs.getString("reference").trim(), rs.getString("designation"),
								rs.getFloat("prixUnitaire"), rs.getInt("qteStock"), rs.getString("couleur"));
					}
					if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
						art = new Ramette(rs.getInt("idArticle"), rs.getString("marque"),
								rs.getString("reference").trim(), rs.getString("designation"),
								rs.getFloat("prixUnitaire"), rs.getInt("qteStock"), rs.getInt("grammage"));
					}
				}
			}

		} catch (SQLException e) {
			throw new DALException("selectById failed - id = " + id, e);
		}
		return art;
	}

	public List<Article> selectAll() throws DALException {
		List<Article> liste = new ArrayList<Article>();
		try (Connection cnx = JdbcTools.getConnection(); Statement rqt = cnx.createStatement();) {
			try (ResultSet rs = rqt.executeQuery(sqlSelectAll);) {
				Article art = null;

				while (rs.next()) {
					if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {

						art = new Stylo(rs.getInt("idArticle"), rs.getString("marque"),
								rs.getString("reference").trim(), rs.getString("designation"),
								rs.getFloat("prixUnitaire"), rs.getInt("qteStock"), rs.getString("couleur"));
					}
					if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
						art = new Ramette(rs.getInt("idArticle"), rs.getString("marque"),
								rs.getString("reference").trim(), rs.getString("designation"),
								rs.getFloat("prixUnitaire"), rs.getInt("qteStock"), rs.getInt("grammage"));
					}
					liste.add(art);
				}
			}
		} catch (SQLException e) {
			throw new DALException("selectAll failed - ", e);
		}
		return liste;

	}

	public void update(Article data) throws DALException {
		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(sqlUpdate);) {
			rqt.setString(1, data.getReference());
			rqt.setString(2, data.getMarque());
			rqt.setString(3, data.getDesignation());
			rqt.setFloat(4, data.getPrixUnitaire());
			rqt.setInt(5, data.getQteStock());
			rqt.setInt(8, data.getIdArticle());
			if (data instanceof Ramette) {
				Ramette r = (Ramette) data;
				rqt.setInt(6, r.getGrammage());
				rqt.setNull(7, Types.VARCHAR);
			}
			if (data instanceof Stylo) {
				Stylo s = (Stylo) data;
				rqt.setNull(6, Types.INTEGER);
				rqt.setString(7, s.getCouleur());
			}

			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update article failed - " + data, e);
		}
	}

	public void insert(Article data) throws DALException {
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);) {
			rqt.setString(1, data.getReference());
			rqt.setString(2, data.getMarque());
			rqt.setString(3, data.getDesignation());
			rqt.setFloat(4, data.getPrixUnitaire());
			rqt.setInt(5, data.getQteStock());
			if (data instanceof Ramette) {
				Ramette r = (Ramette) data;
				rqt.setString(6, TYPE_RAMETTE);
				rqt.setInt(7, r.getGrammage());
				rqt.setNull(8, Types.VARCHAR);
			}
			if (data instanceof Stylo) {
				Stylo s = (Stylo) data;
				rqt.setString(6, TYPE_STYLO);
				rqt.setNull(7, Types.INTEGER);
				rqt.setString(8, s.getCouleur());
			}

			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				try (ResultSet rs = rqt.getGeneratedKeys();) {
					if (rs.next()) {
						data.setIdArticle(rs.getInt(1));
					}
				}

			}

		} catch (SQLException e) {
			throw new DALException("Insert article failed - " + data, e);
		}
	}

	// l'intégrité référentielle s'occupe d'invalider la suppression
	// si l'article est référencé dans une ligne de commande

	public void delete(int id) throws DALException {
		try (Connection cnx = JdbcTools.getConnection(); PreparedStatement rqt = cnx.prepareStatement(sqlDelete);) {
			rqt.setInt(1, id);
			rqt.executeUpdate();
		} catch (SQLException e) {
			throw new DALException("Delete article failed - id=" + id, e);
		}
	}

	@Override
	public List<Article> selectByMarque(String marque) throws DALException {
		List<Article> liste = new ArrayList<Article>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectByMarque);) {

			rqt.setString(1, marque);
			try (ResultSet rs = rqt.executeQuery();) {
				Article art = null;

				while (rs.next()) {
					if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {

						art = new Stylo(rs.getInt("idArticle"), rs.getString("marque"),
								rs.getString("reference").trim(), rs.getString("designation"),
								rs.getFloat("prixUnitaire"), rs.getInt("qteStock"), rs.getString("couleur"));
					}
					if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
						art = new Ramette(rs.getInt("idArticle"), rs.getString("marque"),
								rs.getString("reference").trim(), rs.getString("designation"),
								rs.getFloat("prixUnitaire"), rs.getInt("qteStock"), rs.getInt("grammage"));
					}
					liste.add(art);
				}
			}
		} catch (SQLException e) {
			throw new DALException("selectByMarque failed - ", e);
		}
		return liste;
	}

	@Override
	public List<Article> selectByMotCle(String motCle) throws DALException {
		List<Article> liste = new ArrayList<Article>();
		try (Connection cnx = JdbcTools.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(sqlSelectByMotCle);) {

			rqt.setString(1, "%" + motCle + "%");
			rqt.setString(2, "%" + motCle + "%");
			try (ResultSet rs = rqt.executeQuery();) {
				Article art = null;

				while (rs.next()) {
					if (TYPE_STYLO.equalsIgnoreCase(rs.getString("type").trim())) {

						art = new Stylo(rs.getInt("idArticle"), rs.getString("marque"),
								rs.getString("reference").trim(), rs.getString("designation"),
								rs.getFloat("prixUnitaire"), rs.getInt("qteStock"), rs.getString("couleur"));
					}
					if (TYPE_RAMETTE.equalsIgnoreCase(rs.getString("type").trim())) {
						art = new Ramette(rs.getInt("idArticle"), rs.getString("marque"),
								rs.getString("reference").trim(), rs.getString("designation"),
								rs.getFloat("prixUnitaire"), rs.getInt("qteStock"), rs.getInt("grammage"));
					}
					liste.add(art);
				}
			}
		} catch (SQLException e) {
			throw new DALException("selectByMotCle failed - ", e);
		}
		return liste;
	}
}
