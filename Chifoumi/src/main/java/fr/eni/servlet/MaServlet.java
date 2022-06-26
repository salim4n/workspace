package fr.eni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.RequestContext;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/MaServlet")
public class MaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int botChoix = (int) (Math.random() * 3);
		System.out.println("choix du bot : " + botChoix);

		int requete = 0;
		String choix1 = request.getParameter("pierre");
		String choix3 = request.getParameter("ciseau");
		String choix2 = request.getParameter("feuille");
		
		if (choix2 == null && choix3 == null) {
			requete = 1;
		} else if (choix1 == null && choix3 == null) {
			requete = 2;
		} else if (choix1 == null && choix2 == null) {
			requete = 3;
		}

		System.out.println("choix du joueur : " + requete);
		System.out.println("------------------------------------------");
		// pierre = 1 / bot 0
		// feuille = 2 / bot 1
		// ciseau = 3 / bot 2
		int victoire = 0;
		// victoire 1 = egalite
		// victoire 2 = perdu
		// victoire 3 = gagne

		if (requete == 1 && botChoix == 0) {
			victoire = 1;
		} else if (requete == 2 && botChoix == 1) {
			victoire = 1;
		} else if (requete == 3 && botChoix == 2) {
			victoire = 1;
		} else if (requete == 1 && botChoix == 1) {
			victoire = 2;
		} else if (requete == 2 && botChoix == 0) {
			victoire = 3;
		} else if (requete == 2 && botChoix == 2) {
			victoire = 2;
		} else if (requete == 3 && botChoix == 1) {
			victoire = 3;
		} else if (requete == 1 && botChoix == 2) {
			victoire = 3;
		} else if (requete == 3 && botChoix == 0) {
			victoire = 2;
		}

		System.out.println("le resultat : " + victoire);
		System.out.println("------------------------------------------");

		request.setAttribute("choixBot", botChoix);
		RequestDispatcher rd = request.getRequestDispatcher("/Resultat.jsp");
		request.setAttribute("choixJoueur", requete);
		rd = request.getRequestDispatcher("/Resultat.jsp");
		request.setAttribute("result", victoire);
		rd = request.getRequestDispatcher("/Resultat.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
