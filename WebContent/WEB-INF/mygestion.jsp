<%@page import="model.MyUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion</title>
<body>

	<%@include file="menuadmin.jsp"%>
	<%
		session.setAttribute("users", request.getAttribute("users"));
	%>
	<div class="panel panel-default"
		style="width: 70%; margin: auto; padding: 25px;">
		<h1 align="center">Liste des étudiants</h1>
		<form action="mygestion" method="post">
			<fieldset>
				<table class="table table-hover">
					<thead>
						<tr>
							<th></th>
							<th>Id</th>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Société</th>
							<th>Mail</th>
							<th>Téléphone</th>
							<th>Statut</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<tr>
								<td><input type="checkbox" id="state" name="${user.userId}" value="true" /></td>
								<td><c:out value="${user.userId}" /></td>

								<td><c:out value="${user.lName}" /></td>
								<td><c:out value="${user.fName}" /></td>
								<td><c:out value="${user.society}" /></td>
								<td><c:out value="${user.email}" /></td>
								<td><c:out value="${user.tel}" /></td>
								<td><c:out value="${user.state}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>


			</fieldset>
			<button type="submit" class="btn btn-success btn-sm">Activer compte(s)</button>
			<button type="reset" class="btn btn-danger btn-sm">Annuler</button>
		</form>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>