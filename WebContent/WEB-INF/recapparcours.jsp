<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.MyParcours"%>
<%@page import="bdd.QuestionaryBdd"%>
<%@page import="bdd.SubjectBdd"%>
<%@page import="bdd.ParcoursBdd"%>
<%@page import="java.util.List"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<MyParcours> ancienparcs = ParcoursBdd
				.viewListParcours((long) (request.getSession().getAttribute("etudiantId")));
		for (int i = 0; i < ancienparcs.size(); i++) {
			ancienparcs.get(i)
					.setParcQuiz(QuestionaryBdd.viewQuizzId(ancienparcs.get(i).getParcQuiz().getQuestionaryId()));
			ancienparcs.get(i).getParcQuiz().setSubjectId(
					SubjectBdd.viewSujetId(ancienparcs.get(i).getParcQuiz().getSubjectId().getSubjectId()));
		}
		request.getSession().setAttribute("ancienparcs", ancienparcs);
	%>

	<div class="panel panel-default"
		style="width: 70%; margin: auto; padding: auto;">
		<div class="panel-body">
			<h1 align="center">Liste des parcours effectués</h1>
			<form action="recapparcours" method="post">
				<div class="container">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Sujet</th>
								<th>Questionnaire</th>
								<th>Score</th>
								<th>Temps passé</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ancienparcs}" var="ancienparc">
								<tr>
									<td><c:out
											value="${ancienparc.parcQuiz.subjectId.subject}" /></td>
									<br>
									<td><c:out value="${ancienparc.parcQuiz.questionary}" /></td>
									<br>
									<td><c:out value="${ancienparc.score}" /></td>
									<br>
									<td><c:out value="${ancienparc.timeSpent}" /></td>
									<br>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div align="center">
						<br> <a href="/myNewProject/MySubjectController">Choisir
							un sujet </a>
					</div>
					<br>
				</div>
			</form>
		</div>
	</div>
</body>
</html>