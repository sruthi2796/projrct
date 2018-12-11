<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@include file="home.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped table-bordered">
<thead>
<tr>

<th>ID</th>
<th>CATEGORYNAME</th>
<th>ACTION</th>

</tr>
</thead>
<tbody>
<tr>

<c:forEach items="${category}" var="category">
<td><c:out value="${category.categoryid}"></c:out></td>
<td><c:out value="${category.categoryname}" ></c:out></td>
<td><a href="/frontend/admin/viewcategory?id=${category.categoryid }"><span class="glyphicon glyphicon-info-sign"></span></a>
<a href="/frontend/admin/deletecategory?id=${category.categoryid }"><span class="glyphicon glyphicon-trash"></span></a>
<a href="/frontend/admin/updatecategory?id=${category.categoryid }"><span class="glyphicon glyphicon-edit"></span></a></td>
</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>