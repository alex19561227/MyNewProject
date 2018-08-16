<%@page import="model.MyUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="bdd.UserBdd"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modification des comptes</title>
</head>
<body>
	<%@include file="menuadmin.jsp"%>
	<%
		List<MyUser> users = UserBdd.viewValidatedUsers(request);
		request.getSession().setAttribute("users", users);
	%>
	<div class="panel panel-default"
		style="width: 70%; margin: auto; padding: auto;">
		<div class="panel-body">
			<h1 align="center">Liste des étudiants</h1>
			<form action="myaccescomptes" method="post">
				<div class="container">
					<table class="table table-hover">

						<thead>
							<tr>
								<th>Identifiant</th>
								<th>Prénom</th>
								<th>Nom</th>
								<th>Société</th>
								<th>Email</th>
								<th>Mot de passe</th>
								<th>Téléphone</th>
								<th>Date d'inscription</th>
								<th>Statut</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${users}" var="user">
								<tr>
									<td><input type="checkbox" id="state"
										name=${user.userId
							} value="true" /> user N° <c:out
											value="${user.userId}" /></td>

									<td><c:out value="${user.lName}" /></td>
									<td><c:out value="${user.fName}" /></td>
									<td><c:out value="${user.society}" /></td>
									<td><c:out value="${user.email}" /></td>
									<td><c:out value="${user.password}" /></td>
									<td><c:out value="${user.tel}" /></td>
									<td><c:out value="${user.date}" /></td>
									<td><c:out value="${user.state}" /></td>
							</c:forEach>
						</tbody>
					</table>
				</div>

				<button type="submit"  class="btn btn-success btn-sm">Modifier compte(s)</button>
				<button type="reset"  class="btn btn-danger btn-sm">Reset</button>
			</form>
		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>