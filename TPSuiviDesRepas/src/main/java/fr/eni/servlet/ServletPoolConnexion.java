package fr.eni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;




/**
 * Servlet implementation class ServletPoolConnexion
 */
@WebServlet( urlPatterns = { "/ServletPoolConnexion" })
public class ServletPoolConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			Connection cnx = dataSource.getConnection();
			out.print("La connexion est " +(cnx.isClosed()?"fermee":"ouverte")+".");
			cnx.close();
		} catch (NamingException | SQLException e) {
		
			e.printStackTrace();
			System.err.println("ca ne se connecte pas");
		}
		
		
		
		 
		
		
		
		
		
	}

	

}
