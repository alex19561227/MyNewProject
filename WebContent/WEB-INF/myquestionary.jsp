<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.MyQuestionary"%>
<%@page import="bdd.QuestionaryBdd"%>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des questionnaires</title>
</head>
<body>
	<%@include file="menu.jsp"%>
	<%
		long sujetId = (long) session.getAttribute("choixsujet");
		System.out.println("myquestionary jsp - sujetId: " + sujetId);
		List<MyQuestionary> questionaries = QuestionaryBdd.viewListQuizz(sujetId);
		pageContext.setAttribute("questionaries", questionaries);
	%>
	<div class="panel panel-default"
		style="width: 70%; margin: auto; padding: auto;">
		<div class="panel-body">
			<h1 align="center">Liste des questionnaires</h1>
			<h3 align="center">Selectionnez votre questionnaire a repondre</h3>
			
			<div align="center">${! empty erreur? erreur : ''}</div>
			<form action="myquestionary" method="post">
				<input type="hidden" name="sujet"
					value="<%=request.getParameter("choixsujet") %>" />
				<fieldset>
					<div class="col-xs-3">
						<select class="form-control" name="choixquestionnaire">
							<c:forEach items="${questionaries}" var="questionary">
								<option value="${questionary.questionaryId }">${questionary.questionary}</option>
							</c:forEach>
					</div>
					</select>
					<button class="btn btn-success btn-sm" style="margin-top: 10px;"
						type="submit">Valider</button>
				</fieldset>
				<br> <br>
			</form>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>