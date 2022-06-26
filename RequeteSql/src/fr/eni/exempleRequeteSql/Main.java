package fr.eni.exempleRequeteSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;
/*importer via librairie l'api necessaire, autrement l'import est impossible comme ici .*/

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		 Statement stmt = null;
		
		
		//charger le driver jdbc en memoire
		
				try {
					DriverManager.registerDriver(new SQLServerDriver());
					String url = "jdbc:sqlserver://localhost:1433;databasename=PAPETERIE_DB;encrypt=true;trustServerCertificate=true";
					connection = DriverManager.getConnection(url, "sa", "1234");
					System.out.println("connection");
					
					// Creer un statement
					
					stmt = connection.createStatement();
					ResultSet rs =stmt.executeQuery("select idArticle, reference, marque  from articles");
					while(rs.next()) {
						System.out.println(rs.getString("idArticle") + "" + rs.getString("reference") + "" + rs.getString("marque"));
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if (stmt != null) {
						try {
							stmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if (connection != null) {

						try {
							connection.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}

	}

}
