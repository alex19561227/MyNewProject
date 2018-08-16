<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Creation questionnaire</title>
</head>
<body>
	<div class="panel panel-default"
		style="width: 70%; margin: auto; padding: auto;">
		<div class="panel-body">
			<h1 align="center">Formulaire de création de questionnaire</h1>

			<form action="creationquizz" method="post">
				<div class="form-group"
					style="width: 70%; margin: auto; padding: 5px;">
					<label for="suj">Intitulé du Sujet:</label> <input type="text"
						name="sujet" value="${suj}" class="form-control" id="subject">
					<c:if test="${suj==''}"> le champ "sujet" n'a pas été renseigné </c:if>
				</div>
				<div class="form-group"
					style="width: 70%; margin: auto; padding: 5px;">
					<label for="questionnaire">Intitulé du Questionnaire:</label> <input
						type="text" name="quizz" value="${quizzy}" class="form-control"
						id="quizzo">
					<c:if test="${quizzy==''}"> le champ "questionnaire" n'a pas été renseigné </c:if>
				</div>
				<div class="form-group"
					style="width: 70%; margin: auto; padding: 5px;">
					<label for="sel1">Selection du nombre de questions (3
						maximum)</label> <select class="form-control" name="nbreQuestion"
						id="sel1">
						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select>
					<button class="btn btn-success btn-sm" style="margin-top: 10px;"
						type="submit">Passer aux questions</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>