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
	List<MyUser> users = UserBdd.viewListUsers(request);
	request.getSession().setAttribute("users", users);
		
	%>
	<div>
		<h1 align="center">Liste des étudiants</h1>
		<form action="myaccescomptes" method="post">
			<fieldset>
				<c:forEach items="${users}" var="user">
					<input type="checkbox" id="state" name=${user.userId
							}
						value="true" /> user N°
						<c:out value="${user.userId}" />

					<c:out value="${user.lName}" />
						--------------
						<c:out value="${user.fName}" />
						--------------
						<c:out value="${user.society}" />
						--------------
						<c:out value="${user.email}" />
						--------------
						<c:out value="${user.password}" />
						--------------
						<c:out value="${user.tel}" />
						--------------
						<c:out value="${user.date}" />
						--statut du compte--
						<c:out value="${user.state}" />
					<br>
					<br>
				</c:forEach>
			</fieldset>
	</div>

	<input type="submit" value="Modifier compte(s)" />
	<input type="reset" value="Annulez" />
	</form>
	<%@include file="footer.jsp"%>
</body>
</html>