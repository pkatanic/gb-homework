<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
<h3>Product List</h3>
	<c:set var="total" value="0"></c:set>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			
			
		</tr>
		<c:forEach var="product" items="${products }">
			
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				
				<td>${product.price }</td>	
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>
