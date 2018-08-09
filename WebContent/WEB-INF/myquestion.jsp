<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.MyQuestion"%>
<%@page import="model.MyParcours"%>
<%@page import="bdd.QuestionBdd"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MyAnswer"%>
<%@page import="bdd.AnswerBdd"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Long question = (Long) request.getSession().getAttribute("questionnaire");
		Long l = question;
		List<MyQuestion> questions = QuestionBdd.viewListQuestions(l);
		for (int i = 0; i < questions.size(); i++) {
			List<MyAnswer> answers = AnswerBdd.readListResponse(questions.get(i));
			questions.get(i).setMesReponses((ArrayList<MyAnswer>) answers);
		}
		pageContext.setAttribute("questions", questions);
		session.setAttribute("questions", questions);

		
	%>
	<%@include file="menuadmin.jsp"%>
	<div class="panel panel-default"
		style="width: 70%; margin: auto; padding: auto;">
		<div class="panel-body">
		
			<form action="myquestion" method="post">
			
			<c:forEach items="${questions}" var="question">
				<h2>
					<c:out value="${question.question}" />
				</h2>
				<c:forEach items="${question.mesReponses}" var="reponse">
				
					<br>
					<input type="radio" name="${question.questionId}" value="${reponse.answerId}"/>
					<c:out value="${reponse.answer}" />
					<c:out value="${reponse.correctAnswer}" />
				</c:forEach>
			</c:forEach>
			<br>
			<button class="btn btn-success btn-sm" style="margin-top: 10px;"
				type="submit">Valider</button>
			</form>
		</div>
		<%@include file="footer.jsp"%>
</body>
</html>