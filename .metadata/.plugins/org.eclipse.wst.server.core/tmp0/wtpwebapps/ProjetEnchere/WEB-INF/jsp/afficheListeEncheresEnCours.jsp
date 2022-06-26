<%@page import="java.time.LocalDate"%>
<%@page import="fr.eni.projetEnchere.bo.ArticleVendu"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Liste d'enchères en cours</title>
</head>
<body>
<!DOCTYPE html>

<body align ="center">
	
		<h1>Liste d'enchères en cours</h1>
		<table align="center">
			<thead>
				<tr>
					<td>Article</td>
					<td>Description</td>
					<td>Meilleure offre</td>
					<td>Mise à prix</td>
					<td>Début de l'enchère</td>
					<td>Fin de l'enchère</td>

					
				</tr>
			</thead>
				<%
					List<ArticleVendu> listeArticle = (List<ArticleVendu>) request.getAttribute("listeArticle");
					if(listeArticle!=null && listeArticle.size()>0)
					{
				%>
						<tbody>
							<%
							for(ArticleVendu article : listeArticle)
							{
								if(article.getDateFinEncheres().isAfter(LocalDate.now().minusDays(1)) && article.getDateDebutEncheres().isBefore(LocalDate.now().plusDays(1))){
							%>	
								<tr>
									<td><%=article.getNomArticle()%></td>
									<td><%=article.getDescription()%></td>
									<td><%=article.getPrixVente()%></td>
									<td><%=article.getMiseAPrix()%></td>
									<td><%=article.getDateDebutEncheres()%></td>
									<td><%=article.getDateFinEncheres()%></td>
									
								</tr>
							
							<%}
							}%>
						</tbody>
				<%
					}
					else
					{
				%>
					<p>Il n'y a aucun article à afficher<P>
				<%
					}
				%>
	
			
			
		</table>
	
</body>
</html>
