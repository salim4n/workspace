<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout</title>
</head>
<body>
<h1>Ajout</h1><br><br>

<form  action="/ServletAjoutRepas" method="post" >
<label>date :</label><input type="datetime-local" name="date">
<br>
<label>heure :</label><input type="time" name="heure" >
<br>
<label>repas :</label><br><textarea rows="5" cols=""></textarea><br>
<input type="submit" name="aliments" value="valider">
</form>
  <form action="./Accueil.jsp">
      <button type="submit">Annuler</button>
    </form>
<br>




</body>
</html>