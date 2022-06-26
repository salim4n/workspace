<%@page import="fr.eni.projetEnchere.dal.CategorieArticleDAO"%>
<%@page import="fr.eni.projetEnchere.dal.CategorieArticleDAOJdbcImpl"%>
<%@page import="fr.eni.projetEnchere.bo.CategorieArticle"%>
<%@page import="fr.eni.projetEnchere.bll.CategorieManager"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mise en vente d'un article</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/AjoutArticleAVendre3" method="post">
		<h1>Article à mettre en vente</h1>
		<div>
			<label for="nomArticle">Article : </label>
			<input type="text" name="nomArticle" id="nomArticle" required="required">
		</div>
		<div>
			<label for="description">Description : </label>
			<input type="text" name="description" id="description">
		</div>
		<div>
	         <label for="categorie">Catégorie :</label>
	         <select name="categorie" class="input" id="categorie">
	         <% //CategorieManager categorieManager = new CategorieManager();
	         CategorieArticleDAO categorieArticleDAO = new CategorieArticleDAOJdbcImpl();
	         List<CategorieArticle> listeCategories =  categorieArticleDAO.selectAll()/*categorieManager.selectAllCategories()*/;
	         for(CategorieArticle categorie : listeCategories) { %>
	         <option  value ="<%=categorie.getNoCategorie()%>"><%=categorie.getLibelle()%></option>
	         <% } %>
	         </select>
       	</div>
        <div>
            <label for="dateDebutEncheres">Début de l'enchère :</label>
            <input class="input" type="date" name="dateDebutEncheres" id="dateDebutEncheres" required> 
        </div>
        <div>
            <label for="dateFinEncheres">Fin de l'enchère :</label>
            <input class= "input" type="date" name="dateFinEncheres" id="dateFinEncheres" required> 
        </div>    
        <div>
            <label for="miseAPrix">Mise à prix :</label>
            <input class="input" type="number" name="miseAPrix" id="miseAPrix" step="1" min="0" max= "10000" required>
        </div>
        <div>
        	<h3>Lieu de retrait</h3>
        	<div>
				<label for="rue">Rue : </label>
				<input type="text" name="rue" id="rue">
			</div>
			<div>
				<label for="codePostal">Code postal : </label>
				<input type="text" name="codePostal" id="codePostal">
			</div>
			<div>
				<label for="ville">Ville : </label>
				<input type="text" name="ville" id="ville">
			</div>
        	<br>
        	<button type="submit">Valider la mise en vente</button>
        	<button type="reset">Tout effacer</button>
        </div>
	</form>
</body>
</html>