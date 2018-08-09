<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Réponse</title>
</head>
<body>
<input type="radio" id="state" name="${answer.answer}" value="true" />
<input type="text" name="answer" value="${answer}"/>
<%@include file="footer.jsp"%>
</body>
</html>