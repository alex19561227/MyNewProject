<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<%@include file="menuadmin.jsp"%>
	<%
		request.getSession().getAttribute("admin");
		request.getSession().getAttribute("user");

		
	%>
	<div class="panel panel-success"
		style="width: 70%; margin: auto; padding: auto;">
		<div class="panel-heading">
			<h1>
				Bienvenue :
				<c:out value="${admin.fName}" />
				<c:out value="${user.fName}" />
			</h1>
		</div>
		<div class="panel-body">
			<fieldset>
				<legend>INFORMATIONS:</legend>
				Nom :
				<c:out value="${admin.lName}" />
				<c:out value="${user.lName}" />
				<br>
				Prénom :
				<c:out value="${admin.fName}" />
				<c:out value="${user.fName}" />
				<br>
				Société :
				<c:out value="${admin.society}" />
				<c:out value="${user.society}" />
				<br>
				E-mail :
				<c:out value="${admin.email}" />
				<c:out value="${user.email}" />
				<br>
				Téléphone :
				<c:out value="${admin.tel}" />
				<c:out value="${user.tel}" />
				<br>
				Date d'inscription :
				<c:out value="${admin.date}" />
				<c:out value="${user.date}" />
				<br>
			</fieldset>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>