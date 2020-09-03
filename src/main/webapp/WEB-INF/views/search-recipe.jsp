<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Recipe</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />
</head>
<body>
	<div class="container">

		<div class="jumbotron">
			<h2 class="display-3 light">Search Recipe</h2>
		</div>



		<form action="/show-results" method="post">
			<div class="form-group mx-sm-3 mb-2">
				<label>RecordCount:</label> <select name="recordCount">
					<option value="3">3</option>
					<option value="5">5</option>
					<option value="10">10</option>

				</select>
			</div>

			<div class="form-group">
				<div class="form-group mx-sm-3 mb-2">
					<label>Search Text:</label> <input type="text" name="searchText"
						class="form-control" required />
				</div>
				<br>
				<div class="form-group mx-sm-3 mb-2">
					<label>Calories: </label> <input type="number" name="cals"
						class="form-control" />
				</div>
				<br>
				<div class="form-group mx-sm-3 mb-2">
					<label>Diet-Restrictions:</label> <select class="form-control"
						name="diet">
						<option value="">--Select--</option>
						<option value="balanced">balanced</option>
						<option value="high-protein">high-protein</option>
						<option value="low-carb">low-carb</option>
					</select>
				</div>
				<br>
				<div class="form-group mx-sm-3 mb-2">
					<button type="submit" class="btn btn-primary mb-2">Search</button>
				</div>
			</div>

		</form>

	</div>

</body>
</html>
