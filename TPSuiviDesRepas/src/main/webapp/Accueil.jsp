<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
	<h1>Accueil</h1>
	<br>
	<br>
	<form action="/ServletAjoutRepas" method="get">
		<input type="submit" name="ajout" value="Ajouter un nouveau repas">
	</form>
	<br>
	<br>
	<form action="/ServletVisualRepas" method="get">
		<input type="submit" name="visualiser" value="Visualiser les repas">
	</form>




</body>
</html>