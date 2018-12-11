<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@include file="home.jsp" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url value="/admin/updatecate"  var="abc"></c:url>
<form:form method="POST"
          action="${ abc }" modelAttribute="category">
<table>
<tr>
	   
	   <td><form:input path="categoryid"/></td>
	  <td> <form:errors path="categoryid" cssStyle="color:red"/></td>
	   </tr>
		<tr>
			<td>Enter  Name</td>
			<td>
			<form:input path="categoryname"/></td>
		<td>		`<form:errors path="categoryname" cssStyle="color:red"/></td>
		<tr>
		<td> <input type="submit" value="edit"/></td>
		
		</tr>
		</table>
		</form:form>
</body>
</html>