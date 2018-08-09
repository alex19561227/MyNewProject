<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<!--  
	<ul>
		<li>Login</li>
		<li>Accueil</li>
		<li>Contact</li>
	</ul>
	Au lieu de coder le code html sr chaque page, il est possible de la placer dans un fichier JSP et l'importer
	-->
	<%@include file="menu.jsp"%>


	<h1>Bienvenue <c:out value="${user.fName}"/>,</h1>
	
	<fieldset>
		<legend>INFORMATIONS:</legend>	
		<c:out value="${user.lName}"/><br>
		<c:out value="${user.fName}"/><br>
		<c:out value="${user.society}"/><br>
		<c:out value="${user.email}"/><br>
		<c:out value="${user.tel}"/><br>
		<c:out value="${user.date}"/><br>
		
	</fieldset>
	
	<!-- Condition Ternaire   -->
<%-- 	Bonjour, ${! empty tab ? tab[1] : 'Aucun résultat' } --%>
	
	
	<br>
	<!-- Si tab1 n'est pas vide, afficher le tableau, sinon afficher le message  -->


	<%@include file="footer.jsp"%>
</body>
</html>