<%@page import="model.MyUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulaire inscription</title>
</head>
<body>
	<%
	request.getSession().getAttribute("role");
	%>

	<h1 align="center">Formulaire d'insciption Stagiaire</h1>


	<div align="center">${! empty erreur? erreur : ''}</div>

	<form action="myformulaire" method="post">
		<div class="form-group" style="width: 70%; margin: auto; padding: 5px;">
      	<label for="name">Nom:</label>
		<input type="text" name="nom" value="${nom}" class="form-control" id="name">
		<c:if test="${nom==''}"> le champ "nom" n'a pas été renseigné </c:if>
		</div>
		<div class="form-group" style="width: 70%; margin: auto; padding: 5px;">
      	<label for="lname">Prenom:</label>
		<input type="text" name="prenom" value="${prenom}" class="form-control" id="lname">
		<c:if test="${prenom==''}"> le champ "prénom" n'a pas été renseigné </c:if>
		</div>
		<div class="form-group" style="width: 70%; margin: auto; padding: 5px;">
      	<label for="societe">Société:</label>
		<input type="text" name="society" value="${society}" class="form-control" id="societe"> 
		<c:if test="${society==''}"> le champ "société" n'a pas été renseigné </c:if>
		</div>
		<div class="form-group" style="width: 70%; margin: auto; padding: 5px;">
      	<label for="mail">E-mail:</label>
		<input type="email" name="email" value="${email}" class="form-control" id="mail">
		<c:if test="${email==''}"> le champ "e-mail" n'a pas été renseigné </c:if>
		</div>
		<div class="form-group" style="width: 70%; margin: auto; padding: 5px;">
      	<label for="phone">Téléphone:</label>
		<input type="text" name="tel" value="${tel}" class="form-control" id="phone">
		<c:if test="${tel==''}"> le champ "téléphone" n'a pas été renseigné </c:if>
		</div>
		<br><br>
		<div class="form-group" style="width: 70%; margin: auto; padding: 5px;">
		<button type="submit" class="btn btn-success btn-sm">Envoyer</button> 
		<button type="reset" class="btn btn-warning btn-sm">Annuler</button>
			<c:if test="${role != false}" var="condition" scope="session">
		<button type="submit" class="btn btn-info btn-sm">Modifier</button>
		<button type="submit" class="btn btn-danger btn-sm">Supprimer</button>
		</div>
	</c:if>
			
			
			<h2 align="center">Merci d'avoir complété le formulaire !</h2>
	</form>

	<%@include file="footer.jsp"%>

</body>
</html>