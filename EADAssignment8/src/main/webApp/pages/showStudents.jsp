<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/header.jsp"%>

<div class="container">
<table class="table">
<thread>
<tr>
<th scope="col">Id</th>
<th scope="col">First Name</th>
<th scope="col">Last Name</th>
<th scope="col">Father Name</th>
<th scope="col">Email Id</th>
<th scope="col">Class</th>
<th scope="col">Age</th>
</tr>
</thread>
<tbody>
<c:forEach var="student" items="${students}">
<th scope="row">${student.id}</th>
<th>${student.firstName}</th>
<th>${student.lastName}</th>
<th>${student.fatherName}</th>
<th>${student.email}</th>
<th>${student.className}</th>
<th>${student.age}</th>
</c:forEach>
</tbody>
</table>
</div>

