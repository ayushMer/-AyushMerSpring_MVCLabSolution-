<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
 integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
 crossorigin="anonymous"> 

<title>Student Management</title>
</head>
<body>
<div class="container">
<h2> Student Registration and Search</h2>
<form action="/studentManagementSystem/students/search" class="form-inline">
	<a href="/studentManagementSystem/students/showFormForAdd" class="btn btn-primary btn-sm mb-3"> Add Student </a>
	<br>
	<input type="search" name="department" placeholder="Search using department" class="form-control-sm ml-5 mr-2 mb-3"/>
	<br>
	<button type="submit" class="btn btn-success btn-sm mb-3"> Search </button>
	<br>
</form>

<table class="table table-bordered table-strpped">
<thead class="thead-dark">
<tr>
	<th>Student Id</th>
	<th>Name</th>
	<th>Department</th>
	<th>Country</th>
</tr>
</thead>
<tbody>
<c:forEach items=${Student} var="tempStudent">
<tr>
	<td><c:out value="${tempStudent.studentId}"></c:out></td>
	<td><c:out value="${tempStudent.firstName}"></c:out></td>
	<td><c:out value="${tempStudent.department}"></c:out></td>
	<td><c:out value="${tempStudent.country}"></c:out></td>
	<td>
	<a href="/studentManagementSystem/students/save"> Update student Details</a>
	<a href="/studentManagementSystem/students/delete"> Delete Student</a>
	</td>
</tr>
</c:forEach>
</tbody>


</table>
</div>
</body>
</html>