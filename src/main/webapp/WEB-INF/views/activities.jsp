<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<title>Trades view</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
<script
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script src="/js/datatable.js"></script>
</head>

<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">

			<div class="navbar-header">


				<a href="#" class="navbar-brand">Accenture Trader</a>
			</div>

			<div class="row row-list text-right">
				<div class="col-xs-8">
					<p class="text-right navbar-btn">
						Welcome : <b><c:out
								value="${pageContext.request.remoteUser}" /></b>
					</p>
					

				</div>
				<div class="col-xs-1 container-paragraph">
					<form action="/logout" method="post">
						<button type="submit" class="btn btn-danger navbar-btn login-btn ">Log
							out</button>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</div>
			</div>


		</div>
	</nav>
	<div class="btn-group btn-group-justified">
		<a href="/stocks" class="btn btn-primary">Home</a> <a href="/stocks"
			class="btn btn-primary">New Order</a> <a href="/act"
			class="btn btn-primary">Trades View</a><a href="#"
			class="btn btn-primary">Portfolio</a>
	</div>
	<h1>Trades view</h1>

	<table id="activitiesTable" class="display">

		<!-- Header Table -->
		<thead>
			<tr>
				<th>Id</th>
				<th>CreationDate</th>
				<th>Amount</th>
				<th>Stock</th>
				<th>Price (&#8364;)</th>
				<th>ActivityType</th>
			</tr>
		</thead>
		<!-- Footer Table -->
		<tfoot>
			<tr>
				<th>Id</th>
				<th>CreationDate</th>
				<th>Amount</th>
				<th>Stock</th>
				<th>Price (&#8364;)</th>
				<th>ActivityType</th>
			</tr>
		</tfoot>
	</table>

</body>
</html>