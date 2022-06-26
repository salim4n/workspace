<%@page import="org.eclipse.jdt.internal.compiler.ast.ForeachStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="fr.eni.coucheBO.Repas"%>
<%@ page import="java.util.ArrayList"%>

<%
List<Repas> listRepas = new ArrayList<>();
int nbRepas = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historique</title>
</head>
<body>
	<h1>Historique</h1>
	<br>
	<br>

	<table>
		<thead>
			<tr>
				<th colspan="3"></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>date</td>
				<td>heure</td>
				<td>Action</td>
			</tr>
			<%
			for (Repas repas : listRepas) {
				repas = (Repas) request.getAttribute("repas");

				nbRepas = listRepas.size();
			

			for (int row = 0; row <= nbRepas - 1; row++) {
			%>
			<tr>
				<td><%=repas.getDate().toString()%></td>
				<td><%=repas.getHeureRepas().toString()%></td>
				<td><a
					href="<%=request.getContextPath()%>/ServletAjoutRepas?detail=<%=repas.getId_repas()%>">
						détails</a></td>
			</tr>
			<%
			if (String.valueOf(repas.getId_repas()).equals(request.getParameter("aliment"))) {
			%>
			<tr>
				<%
				for (int row2 = 0; row2 < repas.getListAliment().size(); row2++) {
				%>
				<td><%=repas.getListAliment().toString()%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
			<%
			}
			}
			%>

		</tbody>
	</table>





</body>
</html>