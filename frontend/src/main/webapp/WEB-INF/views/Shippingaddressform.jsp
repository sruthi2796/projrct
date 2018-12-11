<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="home.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<c:url value="/cart/createorder" var="url"></c:url>
<form:form modelAttribute="shippingaddress" action="${url}"  method="POST">
<table>
<tr>
<td>
<form:label path="apartmentnumber"> APARTMENTNUMBER</form:label>
	<form:input path="apartmentnumber"/></td>
	
	<td>
	<form:label path="streetname">STREETNAME</form:label>
	<form:input path="streetname"/></td>
	<td>
	<form:label path="city">CITY</form:label>
	<form:input path="city"/></td>
	<td>
	<form:label path="state">STATE</form:label>
	<form:input path="state"/>
	</td>
	<td>
	<form:label path="country">COUNTRY</form:label>
	<form:input path="country" />
	</td>
	<td>
	<form:label path="zipcode">ZIPCODE</form:label>
	<form:input path="zipcode"/>
	</td>
	</tr>
	<br>
	
	</table>
	<input type="submit" value="APPLY" style="background-color:maroon;">
	</form:form>
</div>

</body>
</html>