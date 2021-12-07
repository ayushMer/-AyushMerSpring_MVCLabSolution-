<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="/studentManagementSystem/students/save" modelAttribute="student">
<br>
<br>
Name :  <form:input path="firstName"/>
<br>
<br>
Department :  <form:input path="department"/>
<br>
<br>
Country :  <form:input path="country"/>
</form:form>
<br>
<br>
<input type="submit" values="submit"/>
</body>
</html>