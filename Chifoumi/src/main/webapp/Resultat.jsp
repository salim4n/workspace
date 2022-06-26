<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int botTentative = 0;
int requete = 0;
int victoire = 0;
String choixJ;
String choixB;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resultat</title>
</head>
<body>
	<h1><%="Resultat"%></h1>
	</br>
	<%
	botTentative = (int) request.getAttribute("choixBot");
	requete = (int) request.getAttribute("choixJoueur");
	victoire = (int) request.getAttribute("result");
	switch (requete) {
	case 1:
		choixJ = "pierre";
		break;
	case 2:
		choixJ = "feuille";
		break;
	case 3:
		choixJ = "ciseau";
		break;
	default:
		choixJ = "erreur";
	}
	switch (botTentative) {
	case 0:
		choixB = "pierre";
		break;
	case 1:
		choixB = "feuille";
		break;
	case 2:
		choixB = "ciseau";
		break;
	default:
		choixB = "erreur";
	}
	%>

	</br>
	<h3>choix du bot :</h3>
	<h3><%=choixB%></h3>
	</br>
	<h3>Choix du joueur</h3>
	<h3><%=choixJ%></h3>
	</br>

	<%
	if (victoire == 1) {
	%><h2><%="egalite"%></h2>
	<%
	} else if (victoire == 2) {
	%><h2><%="perdu"%></h2>
	<%
	} else if (victoire == 3) {
	%><h2><%="victoire"%></h2>
	<%
	}
	%>


	<a href="Tentative.jsp">Rejouer</a>

</body>
</html>