<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%@include file="menu.jsp"%>
<div class="panel panel-default"
		style="width: 70%; margin: auto; padding: auto;">
		<div class="panel-body">
	<div align="center"> ${! empty erreur? erreur : ''}</div>
	
	<!-- FORMULAIRE -->
	<form action="mylogin" method="post">
		<fieldset>
			<legend>Se connecter</legend>
				<label>Login: <input type="text" name="login"/></label><br>				
				<br><label>Password: <input type="password" name="password" placeholder="votre mot de passe" /></label><br>
				<input type="radio" name="role" value="true"/>Si administrateur <!-- si checked on passe a la page login admin(a faire) -->
				<input type="radio" name="role" value="false" checked/> Etudiant
				<br><button class="btn btn-success btn-sm" style="margin-top: 10px;"
		type="submit">Valider</button>
				<button class="btn btn-danger btn-sm" style="margin-top: 10px;"
		type="submit">Annuler</button>
				<br><a href="/myNewProject/myformulaire">S'inscrire </a>			
				
		</fieldset>
	</form>
	</div>
	<%@include file="footer.jsp" %>

</body>
</html>