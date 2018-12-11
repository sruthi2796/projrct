<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@include file="home.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}

</style>
</head>
<body>

<table class="table table-striped table-bordered">
<tr>
<th>IMAGE</th>
<th>PRODUCTNAME:</th>

<th>PRODUCTDESCRIPTION</th>

<th>QUANTITY</th>

<th>PRICE</th>
<th>category</th>

</tr>
<tr>
<td>
<img src="<c:url value='/resources/images/${product.id }.png'></c:url>" height="40px" width="50px">
</td>

<td>${product.productName }</td>
<td>${product.productDesc }</td>
<td>${product.quantity }</td>
<td>${product.price }</td>
<td>${product.category.categoryname }</td>
</tr>
</table>

<c:if test="${product.quantity > 0 }">
<security:authorize access="hasRole('ROLE_USER')">
<form action="<c:url value='/cart/addtocart/${product.id }'></c:url>">
Enter Quantity <input type="number" name="requestedquantity" min="1" max="${product.quantity }">
<button class="btn btn-lg btn-info">Add To Cart</button><br>
</form>
</security:authorize>
</c:if>
<c:if test="${product.quantity==0 }">
<button class="btn btn-lg btn-info" disabled>OUT OF STOCK</button>
</c:if>
<br>
<a href="<c:url value='/list'></c:url>" > Back to Previous page</a>


</body>
</html>
