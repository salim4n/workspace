package fr.eni.coucheDAL;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import fr.eni.coucheBO.Aliment;
import fr.eni.coucheBO.Repas;

public class RepasDAOjdbcImpl implements MethodeDAO {

	public static final String insertRepas = "insert into Repas(dateRepas,heureRepas)values(?,?)";
	public static final String insertAliment = "insert into Aliments(id_repas,aliment)values(?,?)";
	public static final String voirRepas = "select * from Repas";
	public static final String voirAliment = "select * from Aliments";
	
	PrintWriter out;

	public void insertRepas(Repas repas) throws SQLException {

		try (Connection cnx = ConnectionProvider.getConnection();) {

			PreparedStatement pstmt = cnx.prepareStatement(insertRepas);
			pstmt.setDate(1, repas.conversionDate(repas.getDate()));
			pstmt.setTime(2, repas.conversionTime(repas.getHeureRepas()));
			int res = pstmt.executeUpdate();
			if (res == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					repas.setId_repas(rs.getInt(1));
				}
			}
			for (Aliment aliment : repas.getListAliment()) {
				insertAliment(aliment, repas.getId_repas());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertAliment(Aliment aliment, int id_repas) throws SQLException {

		try (Connection cnx = ConnectionProvider.getConnection();) {

			PreparedStatement pstmt = cnx.prepareStatement(insertRepas);
			pstmt.setString(2, aliment.getNom());
			pstmt.setInt(1, id_repas);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				aliment.setNom(((Aliment) rs).getNom());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void voireRepas() throws SQLException {
		Statement stmt = null;
		try (Connection cnx = ConnectionProvider.getConnection();) {
			stmt.getConnection();
			ResultSet rs = stmt.executeQuery(voirRepas);
			while (rs.next()) {
				out.print(rs.toString());
			}
		} catch (Exception e) {
			if (stmt == null) {
				System.err.println("pas de statement");
			}
			e.printStackTrace();
		}

	}
	
	public void voireAliments() throws SQLException {
		Statement stmt = null;
		try (Connection cnx = ConnectionProvider.getConnection();) {
		stmt.getConnection();
		ResultSet rs = stmt.executeQuery(voirAliment);
		while(rs.next()) {
			out.print(rs.toString());
		}
		} catch (Exception e) {
			if(stmt == null) {
				System.err.println("pas de statement");
			}
			e.printStackTrace();
		}
	}
}
