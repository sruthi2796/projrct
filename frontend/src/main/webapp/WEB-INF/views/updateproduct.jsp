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
<body><c:url value="/admin/details"  var="abc"></c:url>
 
 <form:form method="POST"
          action="${ abc }" modelAttribute="product" enctype="multipart/form-data">
<table>
<tr>
	   
	   <td><form:input path="id"/></td>
	  <td> <form:errors path="id" cssStyle="color:red"/></td>
	   </tr>
		<tr>
			<td>Enter Product Name</td>
			<td>
			<form:input path="productName"/></td>
		<td>		`<form:errors path="productName" cssStyle="color:red"/></td>
		
		</tr>
        <tr>
			<td>Enter Product Description</td>
			<td>
			<form:input path="productDesc"/></td>
			<td>	<form:errors path="productDesc" cssStyle="color:red"/></td>
			
		</tr>
        <tr>
			<td>Enter Product Price</td>
			<td>
			<form:input path="price"/></td>
			<td>	<form:errors path="price" cssStyle="color:red"></form:errors></td>
			
			
		</tr>
		
		<tr>
			<td>Enter Product Quantity</td>
			<td>
			<form:input path="quantity"/></td>
			<td>	<form:errors path="quantity" cssStyle="color:red"/></td>
			
			
		</tr>
		<tr>
		<td>CATEGORY:
           <form:select path="category.categoryid">
           <c:forEach items="${categories}" var="categories">
          <form:option value="${ categories.categoryid}">
          "${ categories.categoryname}"></form:option> </c:forEach>
          </form:select>
          
          
           </td>
           </tr>
           <tr>
		<td>Upload an image</td>
		<td><form:input type="file" path="image"></form:input></td>
		</tr>
           
		<tr><td>
		<input type="submit" value="Edit Product">  </td>
		
		</tr>
		
	</table>

</form:form>
</body>
</html>