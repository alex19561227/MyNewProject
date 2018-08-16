<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		request.getSession().getAttribute("nbres");
	%>
	<div class="panel panel-default"
		style="width: 70%; margin: auto; padding: auto;">
		<div class="panel-body">
			<form action="CreationQuizz2Controller" method="post">

				<c:forEach var="nbre" begin="0" end="${nbres-1}">
					<div class="form-group"
						style="width: 70%; margin: auto; padding: 5px;">
						<h2>
							<label for="question">Question ${nbre}:</label> <input
								type="text" name="quest"
								class="form-control" id="questio">
						</h2>
<%-- 						<c:if test="${quest==''}"> le champ "question" n'a pas été renseigné </c:if> --%>
					</div>
					<c:forEach var="q" begin="0" end="2">
						<div class="form-group"
							style="width: 70%; margin: auto; padding: 5px;">
							<div class="radio" style="padding: 25px; margin: auto">
								<label><input type="radio" name="bonnereponse" value="${q}"></label>
								<label for="reponse">Réponse :</label> <input type="text"
									name="rep${nbre}" class="form-control" id="repon">
							</div>
						</div>
					</c:forEach>
				</c:forEach>
				<button class="btn btn-success btn-sm"
					style="margin-top: 10px; margin-left: 200px;" type="submit">Valider
					Questionnaire</button>
			</form>
		</div>
	</div>
</body>
</html>