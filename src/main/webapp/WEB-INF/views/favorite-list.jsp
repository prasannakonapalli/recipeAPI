<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Favorite List Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>

	<div class="container">
		<c:choose>
			<c:when test="${recipes!=null}">
				<div>

					<h4>Favorite List Page</h4>
				</div>
				<br>
				<table class="table">

					<tr class="jumbotron">
						<th>Image</th>
						<th>Food</th>
						<th>Calories</th>
						<th>Diet</th>
						<th>Original Source</th>
						<th>Internal Source</th>
						<th>Bookmarked</th>
					</tr>
					<c:forEach items="${recipes}" var="recipe">

						<tr>


							<td><img alt="No image"
								src=<c:out value="${recipe.image}" />></td>
							<td><c:out value="${recipe.label}" /></td>
							<td>
							<fmt:formatNumber type="number" value="${recipe.calories}"   minFractionDigits ="3"/>
							</td>
							<td> 
							
							<c:forEach items="${recipe.dietLabels}" var="dietLabel">
							<c:set var="diet" value="${dietLabel}" />
							 ${diet}<br>
							</c:forEach> 
							</td>
							<td><c:url var="url" value="${recipe.url}" /> <a
								href="${url}">Link</a></td>

							<td><c:url value="/recipeById" var="url">
									<c:param name="recipeId" value="${recipe.uri}" />
								</c:url> <a href="<c:url value="${url}" ></c:url>"> Internal Link </a>
								</td>

							 
							<td><c:url value="/removeFavorite" var="url">
									<c:param name="recipeId" value="${recipe.uri}" />
								</c:url>
								 <a class="btn btn-danger"  href="<c:url value="${url}" ></c:url>">Remove Favorites</a>

							</td>
						<tr>
					</c:forEach>
				</table>
				<br>

				<div>
					<a href="/">Change Search</a> | <a href="/showExistingResults">Back to Results </a>
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
