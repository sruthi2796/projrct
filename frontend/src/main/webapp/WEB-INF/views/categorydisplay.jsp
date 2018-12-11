<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@include file="home.jsp" %>
    <%@ page isELIgnored = "false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${product}" var="product">
<c:if test="${category.categoryid==product.category.categoryid}">
<table class="table table-bordered table-striped">
<tr>
<th>PRODUCTID</th>
<th>PRODUCTNAME</th>
<th>PRODUCTDESCRIPTION</th>
<th>QUANTITY</th>
<th>PRICE</th>
</tr>
<tr>
<b><c:out value="${category.categoryname }:"></c:out></b>
<td><c:out value="${product.id}"></c:out></td>
<td><c:out value="${product.productName}"></c:out></td>
<td><c:out value="${product.productDesc}"></c:out></td>
<td><c:out value="${product.quantity}"></c:out></td>
<td><c:out value="${product.price}"></c:out></td>
</tr>
</table>
</c:if>
 </c:forEach>
 
</body>
</html>