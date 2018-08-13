<%@page import="model.MySubject"%>
<%@page import="bdd.SubjectBdd"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des sujets</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<% 
		List<MySubject> subjects = SubjectBdd.viewListSubjects();
		pageContext.setAttribute("subjects", subjects);
		request.getSession().setAttribute("subjects", subjects);
	%>

	<div class="panel panel-default"
		style="width: 70%; margin: auto; padding: auto;">
		<div class="panel-body">

			<h1 align="center">Liste des sujets</h1>
			<h3 align="center">Selectionnez votre questionnaire a repondre</h3>

			<div align="center">${! empty erreur? erreur : ''}</div>
			<form action="mysubject" method="post">
				<fieldset>
					<div class="col-xs-3">
						<select class="form-control" name="choixsujet">
							<c:forEach items="${subjects}" var="subject">
								<option value="${subject.subjectId}">${subject.subject}</option>
							</c:forEach>
					</div>
					</select>
					<button class="btn btn-success btn-sm" style="margin-top: 10px;"
						type="submit">Valider</button>
				</fieldset>
				<br> <br>
			</form>
		</div>
	<div align="center"><br><a href="/myNewProject/recapparcours">Parcours déjà réalisés </a></div>
	<br>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>