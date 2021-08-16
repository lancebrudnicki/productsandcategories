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
<title>Product Page</title>
</head>
<body>
	<h1><c:out value="${product.name}"/></h1>
	<div style="disply:flex; ">
		<p>
			<h1>Categories:</h1>
			<c:forEach items ="${categories}" var="cate">
				<p>
					<c:out value="${cate.name}"/>
				</p>
			</c:forEach>		
		</p>
		<p>
			<form action="/cateproducts/${product.id}" method="post">
				<label for="category" >Add Category </label>
					<select name="category">
						<option value="" disabled selected></option>
						<c:forEach items="${categoriesNotAdd}" var="notcate">
							<option value="${notcate.id}">
								<c:out value="${notcate.name}"/>
							</option>
						</c:forEach>
				</select>
				<input type="submit" value="Add">
			</form>
		</p>
	</div>

</body>
</html>