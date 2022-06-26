<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<script src="bootstrap/js/jquery-1.11.0.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="bootstrap/js/wow.min.js"></script>
	<meta charset="UTF-8">
	<style>
		th, td {
		  padding: 15px;
		}
	</style>
</head>

<body>
<div class="container">
	<h2>Eni-Enchères</h2>
	<div  class="row">
	<div align="center">
		<h4>Mon profil</h4>
	</div>
	
	<form action="<%=request.getContextPath()%>/register" method="post">
		<div class="form-group col-md-6">
			<div>
		<h1></h1>
				<table border="0" align="center">
<tbody>

<tr>
<td><label for="Pseudo">Pseudo: </label></td>
<td><input id="Pseudo" maxlength="30" name="identifiant" type="text" placeholder="pseudo" required/></td>
</tr>
<%if ( request.getAttribute("erreur20102")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Pseudo déjà utilisé </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20101")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Pseudo trop long  </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20103")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Veuillez rentrer un pseudo  </a></td></tr><%}%>

<tr>
<td><label for="Prénom">Prénom: </label></td>
<td><input id="Prénom" maxlength="30"name="prenom" type="text" placeholder="prenom" required/></td>

</tr>
<%if ( request.getAttribute("erreur20110")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> prenom trop long  </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20111")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Veuillez rentrer un prenom  </a></td></tr><%}%>

<tr>
<td><label for="nom">nom: </label></td>
<td><input id="nom" maxlength="30"name="nom" type="text" placeholder="nom" required/></td>
</tr>

<%if ( request.getAttribute("erreur20115")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> nom trop long  </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20116")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Veuillez rentrer un nom  </a></td></tr><%}%>

<tr>
<td><label for="email">email: </label></td>
<td><input id="email" maxlength="20" name="email" type="email" placeholder="email" required/></td>
</tr>

<%if ( request.getAttribute("erreur20120")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> email trop long  </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20121")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Veuillez rentrer un email  </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20122")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Email déjà utilisé  </a></td></tr><%}%>

<tr>
<td><label for="Teléphone">Teléphone: </label></td>
<td><input id="Teléphone" maxlength="15" name="telephone" type="tel" placeholder="01-02-03-04-05" pattern="[0]{1}[0-9]{1}-[0-9]{2}-[0-9]{2}-[0-9]{2}-[0-9]{2}" required /></td>
</tr>

<%if ( request.getAttribute("erreur20125")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Numéro de téléphone  trop long  </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20126")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Numéro de téléphone trop court   </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20127")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Veuillez rentrer un Teléphone  </a></td></tr><%}%>

<tr>
<td><label for="rue">rue: </label></td>
<td><input id="rue" maxlength="30" name="rue" type="text" placeholder="rue" required /></td>
</tr>

<%if ( request.getAttribute("erreur20130")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> rue trop long  </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20131")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Veuillez rentrer un rue  </a></td></tr><%}%>

<tr>
<td><label for=" Codepostal"> Code postal: </label></td>
<td><input id=" Codepostal" maxlength="5" name="codePostal" type="text" placeholder="Code postal" pattern="[0-9]{5}" required/></td>
</tr>

<%if ( request.getAttribute("erreur20135")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> codePostal trop long  </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20136")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> codePostal trop court   </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20137")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Veuillez rentrer un codePostal  </a></td></tr><%}%>

<tr>
<td><label for=" vile"> ville: </label></td>
<td><input id=" vile" maxlength="30" name="vile" type="text" placeholder="vile" required/></td>
</tr>

<%if ( request.getAttribute("erreur20140")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> vile trop long  </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20141")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Veuillez rentrer un vile  </a></td></tr><%}%>

<tr>
<td><label for="Mot de passe">Mot de passe: </label></td>
<td><input id="Mot de passe" maxlength="30" name="motdepasse" type="password" placeholder="Mot de passe" required/></td>
</tr>

<%if ( request.getAttribute("erreur20106")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> motdepasse trop long  </a></td></tr><%}%>
<%if ( request.getAttribute("erreur20107")!=null){%><tr><td><a style="color: rgb(214, 122, 127)"> Veuillez rentrer un motdepasse  </a></td></tr><%}%>

</tbody>
</table>
<div align="center">
	<input name="Submit" type="Submit" class="btn btn-success" value="Créer" />
	<input name="Submit" type="reset" class="btn btn-success" value="Annuler" />
</div>
			</div>
			
		</div>
		<div class="form-group col-md-6">
			<h1></h1>
			<div>
				<table border="0" align="center">
</table>
			</div>
			
		</div>
	</form>
		<div class="row">
		<a href="<%=request.getContextPath()%>/login" ><button type="submit" class="btn btn-success col-md-6">Aller se connecter </button></a>
		
	</div>
	
	</div>
 	
</body>
</html>