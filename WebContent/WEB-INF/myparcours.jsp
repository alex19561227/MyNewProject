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
<form action="myparcours" method="post">
	<h2>
		<c:out value="${etudiant.lName}" />
	</h2>
	<h2>
		<c:out value="${etudiant.fName}" />
	</h2>
	<h2>
		<c:out value="${etudiant.userId}" />
		<c:out value="${subject.subject}" />
	<br>
	<c:out value="${parcours.parcQuiz.questionary}" />
	<br>
	<c:out value="${parcours.score}" />
	<br>
	<c:out value="${parcours.timeSpent}" />

	</h2>
	<c:forEach items="${ancienparcs}" var="ancienparc">
	<c:out value="${subject.subject}" />
	<br>
	<c:out value="${ancienparc.parcQuiz.questionary}" />
	<br>
	<c:out value="${ancienparc.score}" />
	<br>
	<c:out value="${ancienparc.timeSpent}" />
	<br>
	</c:forEach>
</form>
<%@include file="footer.jsp"%>
</body>
</html>