<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@include file="home.jsp" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/resources/css/login.css'></c:url>">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<div class="login-block">
${loginError}
${message}

<b> login</b>
<c:url value="/j_spring_security_check" var="url"></c:url>
<form:form method="POST" action="${url }">
EMAIL:<input type="text" name="j_username"><br>
PASSWORD:<input type="text" name="j_password"><br>
<input class="btn-login" type="submit" value="login">
</form:form>
</div>
</div>

</body>
</html>