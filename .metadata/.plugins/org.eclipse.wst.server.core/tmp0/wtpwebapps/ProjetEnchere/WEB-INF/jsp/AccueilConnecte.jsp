<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.chrono.ChronoZonedDateTime"%>
<%@page import="java.time.ZonedDateTime"%>
<%@page import="java.time.chrono.ChronoLocalDate"%>
<%@page import="java.time.chrono.ChronoLocalDateTime"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Locale"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="fr.eni.projetEnchere.bll.ArticleVenduManager"%>
<%@page import="fr.eni.projetEnchere.bll.CategorieManager"%>
<%@page import="fr.eni.projetEnchere.bo.CategorieArticle"%>
<%@ page import="fr.eni.projetEnchere.bo.ArticleVendu"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css">
	<link rel="stylesheet" href="styles/style.css">
<link rel="stylesheet" href="styles/navbar.css">
<link rel="stylesheet" href="styles/accueil.css">
<script src="bootstrap/js/jquery-1.11.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/js/wow.min.js"></script>
<meta charset="UTF-8">
<title>Accueil quand connecte</title>
</head>

<body>
	<!-- Navbar -->
	<%@ include file="navbar.jsp"%>

	<div class="search-bar">

		<select class="input" id="categorie">
			<%
			CategorieManager ctm = new CategorieManager();
			for (CategorieArticle categorie : ctm.selectAllCategories()) {
			%>
			<option name="categorie" value="<%=categorie.getNoCategorie()%>"><%=categorie.getLibelle()%></option>
			<%
			}
			%>
		</select>

		<div class="search-box">
			<input type="text" class="search"
				placeholder="What are we looking for today?">
		</div>

		<button type="submit" class="search-btn">
			<i class="fas fa-search"></i>
		</button>
	</div>

	<div class="recherche-sup">


		<div>
			<input type="radio" id="huey" name="drone" value="huey" checked>
			<label for="huey">Achats</label>

			<ul>
				<li><input name="Ssdm" id="Ssdm" type="radio"> <label
					class="ssdm" for="Ssdm">Ench??res ouvertes</label></li>

				<li><input name="Ssdm" id="Ssdm" type="radio"> <label
					class="ssdm" for="Ssdm">Mes ench??res en cours</label></li>

				<li><input name="Ssdm" id="Ssdm" type="radio"> <label
					class="ssdm" for="Ssdm">Mes ench??res remport??es</label></li>
			</ul>
		</div>

	</div>
	<div>
		<input type="radio" id="huey" name="drone" value="huey" checked>
		<label for="huey">Mes Ventes</label>


		<ul>
			<li><input name="Ssdm" id="Ssdm" type="radio"> <label
				class="ssdm" for="Ssdm">Mes ventes en cours</label></li>

			<li><input name="Ssdm" id="Ssdm" type="radio"> <label
				class="ssdm" for="Ssdm">Ventes non d??but??s</label></li>

			<li><input name="Ssdm" id="Ssdm" type="radio"> <label
				class="ssdm" for="Ssdm">Ventes termin??es</label></li>
		</ul>

	</div>




	<div class="head">
		<h1>Ench??res En Cours</h1>
	</div>
	<div class="container">
		<div class="card-grid">
			<%
			ArticleVenduManager avm = new ArticleVenduManager();
			List<ArticleVendu> listeArticles = avm.selectAll();
			%>
			<%
			if (listeArticles.size() != 0) {
			%>
			<%
			for (ArticleVendu article : listeArticles) {
			%>
			<div class="card">
				<div class="card-header">
					<%
					if (article.getDateFinEncheres().isAfter(LocalDate.now())) {
					%>
					<h1>
						<a
							href="<%=request.getContextPath()%>/detailVente?idArticle=<%=article.getNoArticle()%>"><%=article.getNomArticle()%></a>
					</h1>
					<%
					} else {
					%>
					<h1>
						<a
							href="<%=request.getContextPath()%>/venteRemporte?idArticle=<%=article.getNoArticle()%>"><%=article.getNomArticle()%></a>
					</h1>
					<%
					}
					%>
				</div>
				<div class="card-img-container">
					<img src="img/tournevis.jpeg" alt="">
				</div>
				<div class="card-body">
					<div class="prix">
						<i class="fas fa-tag"></i><%=article.getMiseAPrix()%></div>
					<%
					if (article.getPrixVente() != 0) {
					%>
					<div class="prix">
						<i class="fas fa-tag"></i><%=article.getPrixVente()%></div>
					<%
					}
					%>
					<div class="card-date-enchere">
						<p>
							<i class="far fa-clock"></i><%=article.getDateDebutEncheres().format(DateTimeFormatter.ofPattern("dd/MM/YYYY", Locale.FRANCE))%></p>
					</div>
					<div class="vendeur">
						<p>
							<i class="fas fa-id-badge"></i><a
								href="<%=request.getContextPath()%>/profil?pseudo=<%=article.getVendeur().getPseudo()%>"><%=article.getVendeur().getPseudo()%></a>
						</p>
					</div>
				</div>
			</div>
			<%
			}
			%>

			<%
			} else {
			%>
			<h1>Aucun article</h1>
			<%
			}
			%>

		</div>
	</div>

</body>
</html>