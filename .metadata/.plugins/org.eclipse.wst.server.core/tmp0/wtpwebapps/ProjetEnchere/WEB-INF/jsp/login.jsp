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
	<title>Insert title here</title>
</head>
<body>
<%
String nomUser = "";
String motDePasse = "";
Cookie[] cookies = request.getCookies();
if (cookies != null) {
	for(Cookie unCookie:cookies){
		if (unCookie.getName().equals("nomUser")) {
			nomUser = unCookie.getValue();
		}else if(unCookie.getName().equals("motDePasse")) {
			motDePasse = unCookie.getValue();
		}}} %>




<div class="container">

	<div>
		<h3>Eni-Enchères</h3>
	</div>
	<form action="<%=request.getContextPath()%>/login" method="post">
		<div class="form-group row">
			  <div class="col-md-6">
			  <label for="exampleInputEmail1">user name </label>
			<input type="nom" name = "nameUser" class="form-control" id="exampleInputEmail1" placeholder="Enter user name" value="<%= nomUser %>" required >	
			<%if ( request.getAttribute("errorIdentifaint")!=null){%><br><a style="color: rgb(214, 122, 127)">erreur nom utilisateur inconue </a><%}%><br>
	
    </div>
    </div>
		<div class="form-group row">
		  <div class="col-md-6">
			<label for="exampleInputPassword1">Password</label>
			<input type="password" name = "password"class="form-control" id="exampleInputPassword1" placeholder="Password" value="<%= motDePasse %>" required   >
			<%if ( request.getAttribute("errorMotdepasse")!=null){%><br><a style="color: rgb(214, 122, 127)"> erreur mot de passe incorecte</a><%}%><br>
			
			<label>
			
			<input type="checkbox" name = "saveUser"> Se souvenir de moi
				<br>
  		  </div>
		</div>
		
		<div class ="row">
			<button type="submit" class="btn btn-success col-md-2">Connection</button>
		</div>
	</form>
	<div class="row">
		<a href="<%=request.getContextPath()%>/register" ><button type="submit" class="btn btn-success col-md-6">Créer un compte </button></a>
	</div>
</div>
</body>
</html>