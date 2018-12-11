<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js" ></script>
  <link href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" rel="stylesheet">
<title>HOME</title>
</head>
<body>
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
  <a href="" class="navbar-brand"> <img src="<c:url value=''></c:url>" alt="watch" height="50px" width="30px"></a>
  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
   <div class="collapse navbar-collapse" id="myNavbar">
    <ul class="nav navbar-nav">
      <li><a href="#"><span class="glyphicon glyphicon-home">Home</span></a></li>
      <li><a href="#">Aboutus</a></li>
      <security:authorize access="hasRole('ROLE_ADMIN')">
      <li><a href="/frontend/admin/addproduct"><span class="glyphicon glyphicon-plus">Addproducts</span></a></li>
      </security:authorize>
      <li><a href="/frontend/allcategory"><span class="glyphicon glyphicon-list">Allcategory</span></a></li>
      <li><a href="/frontend/list"><span class="glyphicon glyphicon-th-list">Allproducts</span></a></li>
      <security:authorize access="hasRole('ROLE_ADMIN')">
      <li><a href="/frontend/admin/addcategory"><span class="glyphicon glyphicon-th-list">Addcategory</span></a></li>
      </security:authorize>
      <li class="dropdown">
    <a class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" href="#">CATEGORY
    <span class="caret"></span></a>
    <ul class="dropdown-menu">
       <c:forEach items="${cat}" var="cat">
  <li> <a href='/frontend/catdisplay?id=${cat.categoryid}'>${cat.categoryname}</a></li>
      </c:forEach>
        </ul>
       </ul>
   <ul class="nav navbar-nav navbar-right">
     <li> <a href="/frontend/login"><span class="glyphicon glyphicon-user">Signup</span></a></li>
    <li>  <a href="/frontend/logout">Signout</a></li>
    <li>  <a href="/frontend/registerform"><span class="glyphicon glyphicon-log-in">Signin</span></a></li>
    </ul>
      </div>
       </div>
        </nav>

</body>
</html>