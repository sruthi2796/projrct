<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="home.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped table-bordered">
<tr>

<th>ID</th>

<th>CATEGORYNAME</th>
</tr>
<tr>
<td>${category.categoryid }</td>
<td>${category.categoryname }</td>

</tr>
</table>
</body>
</html>