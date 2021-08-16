<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<form:form action="/products/new" method="post" modelAttribute="product">
		<form:errors path="*" />
		<p>
			Name:
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			Description:
			<form:errors path="description" />
			<form:input path="description" />
		</p>
		<p>
			Price:
			<form:errors path="price" />
			<form:input type="number" path="price" />
		</p>
		<input type="submit" value="Create">
	</form:form>


</body>
</html>