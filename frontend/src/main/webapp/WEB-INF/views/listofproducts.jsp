<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@include file="home.jsp" %>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>

<script type="text/javascript">
$(document).ready(function(){
	var searchcondition='${searchcondition}'
    $('.table').DataTable({
    	"lengthMenu":[[5,7,-1],[5,7,"All"]],
    	"oSearch":{
    	"sSearch":searchcondition
    	}
    })
  })
</script>
</head>
<body>
<table class="table table-striped table-bordered">
<thead>
<tr>
<th>IMAGE</th>
<th>ID</th>
<th>PRODUCTNAME</th>
<th>PRODUCTDESC</th>
<th>QUANTITY</th>
<th>PRICE</th>
<th>CATEGORY</th>
<th>ACTION</th>

</tr>
</thead>
<tbody>
<tr>
<c:forEach items="${ products}" var="product">
<td><img src="<c:url value='/resources/images/${product.id }.png'></c:url>" height="40px" width="50px"/>
</td>
<td><c:out value="${product.id }"></c:out></td>
<td><c:out value="${product.productName }"></c:out></td>
<td><c:out value="${product.productDesc}"></c:out></td>
<td><c:out value="${product.quantity }"></c:out></td> 
<td><c:out value="${product.price }"></c:out></td>
<td><c:out value="${product.category.categoryname }"></c:out></td>

<td><a href='/frontend/info?id=${product.id }'><span class="glyphicon glyphicon-info-sign"></span></a>
<security:authorize access="hasRole('ROLE_ADMIN')">
<a href='/frontend/admin/delete?id=${product.id }'><span class="glyphicon glyphicon-trash"></span></a>
</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">
<a href='/frontend/admin/update?id=${product.id}'><span class="glyphicon glyphicon-edit"></span></a></td>
</security:authorize>


</tr>
</c:forEach>
</tbody>
</table>

</body>
</html>