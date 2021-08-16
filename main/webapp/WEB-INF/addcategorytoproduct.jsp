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
<title>Category Page</title>
</head>
<body>
	<h1><c:out value="${category.name}"/></h1>
	<div style="disply:flex; ">
		<p>
			<h1>Categories:</h1>
			<c:forEach items ="${products}" var="cate">
				<p>
					<c:out value="${cate.name}"/>
				</p>
			</c:forEach>		
		</p>
		<p>
			<form action="/prodcategory/${category.id}" method="post">
				<label for="category" >Add Product</label>
					<select name="product">
						<option value="" disabled selected></option>
						<c:forEach items="${productsNotAdd}" var="notproduct">
							<option value="${notproduct.id}">
								<c:out value="${notproduct.name}"/>
							</option>
						</c:forEach>
				</select>
				<input type="submit" value="Add">
			</form>
		</p>
	</div>
</body>
</html>