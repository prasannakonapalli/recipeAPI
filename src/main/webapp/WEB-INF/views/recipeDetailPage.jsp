<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recipe Detail Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>

	<div class="container">
		<c:choose>
			<c:when test="${recipe!=null}">
				<div>

					<h3>Recipe Detail Page</h3>
				</div>
				<br>
				<table class="table"> 

					<tr>
						<td><img alt="No image" src=<c:out value="${recipe.image}" />>
							<strong><c:out value="${recipe.label}" /></strong></td>

					</tr>

					<tr>
						<td><strong>ShareAs:</strong> 
						
						<a href="<c:url value="${recipe.shareAs}" ></c:url>">
						<c:out value="${recipe.shareAs}" /></a>
						</td>

					</tr>

					<tr>
						<td><strong>Ingredients:</strong> <c:out value="${recipe.ingredientLines}" />
						</td>

					</tr>

				</table>
				<br>

				<div>
					<a href="/showExistingResults">Back to Results</a>
				</div>
				<br>
			</c:when>
			<c:otherwise>
				<h2>No Data Found</h2>
				<br />
			</c:otherwise>
		</c:choose>
	</div>


</body>
</html>
