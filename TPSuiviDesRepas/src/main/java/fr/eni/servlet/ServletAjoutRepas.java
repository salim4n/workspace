package fr.eni.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.coucheBLL.SuiviRepasManager;
import fr.eni.coucheBO.Aliment;
import fr.eni.coucheBO.Repas;

/**
 * Servlet implementation class ServletAjoutRepas
 */
@WebServlet("/ServletAjoutRepas")
public class ServletAjoutRepas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjoutRepas() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/Ajout.jsp");
		rd.forward(request, response);

	}
@Override
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		DateTimeFormatter dtf1 = null;
		dtf1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter dtf2 = null;
		dtf2 = DateTimeFormatter.ofPattern("hh-mm");

		SuiviRepasManager repasManager = new SuiviRepasManager();
		Repas repas = new Repas();
		LocalDate date = LocalDate.parse(request.getParameter("date"), dtf1);
		LocalTime time = LocalTime.parse(request.getParameter("heure"), dtf2);

		repas = repasManager.ajouterRepas(date, time);
		List<Aliment> listAliment = new ArrayList<>();

		for (Aliment aliment : listAliment) {
			aliment.setNom(request.getParameter("aliments"));

		}
		
		request.setAttribute("repas", repas);
		RequestDispatcher rd = request.getRequestDispatcher("/historique.jsp");
		request.setAttribute("aliment", listAliment);
		rd = request.getRequestDispatcher("/historique.jsp");
		
		
		

	}

}
