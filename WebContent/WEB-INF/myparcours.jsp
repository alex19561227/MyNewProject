<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.MyParcours"%>
<%@page import="bdd.ParcoursBdd"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Parcours</title>
</head>

<%
	// 	MyParcours monParcours = (MyParcours) request.getSession().getAttribute("parcours");
	request.getSession().getAttribute("ancienparcs");
	// 	List<MyParcours> userparc = ParcoursBdd.viewListParcours((Long) request.getSession().getAttribute("etudiant"));
	//  	pageContext.setAttribute("userparc", userparc);
	//  	System.out.println("Liste parc:" + userparc);
%>
<div class="panel panel-default"
	style="width: 70%; margin: auto; padding: auto;">
	<div class="panel-body">
		<form action="myparcours" method="post">
			<div class="container">
				<table class="table table-hover">
					<h1 align="center">Parcours validé</h1>
					<thead>
						<tr>
							<th>Sujet</th>
							<th>Questionnaire</th>
							<th>Score</th>
							<th>Temps passé</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${etudiant.lName}" /></td>
							<td><c:out value="${etudiant.fName}" /></td>
							<td><c:out value="${etudiant.userId}" /></td>
							<td><c:out value="${subject.subject}" /></td>
							<td><c:out value="${parcours.parcQuiz.questionary}" /></td>
							<td><c:out value="${parcours.score}" /></td>
							<td><c:out value="${parcours.timeSpent}" /></td>
						</tr>
					</tbody>
				</table>
			</div>
	</div>
</div>
</form>
<div align="center"><br><a href="/myNewProject/MySubjectController">Retour à la sélection des sujets </a></div>
<%@include file="footer.jsp"%>
</body>
</html>