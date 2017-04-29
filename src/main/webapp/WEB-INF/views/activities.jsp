<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.sql.*"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/css/easy-autocomplete.min.css">
<style>
body {
	padding: 0;
	margin: 0;
	font-size: 13px;
}

td {
	font-size: 18px;
}
</style>

</head>
<body>

	<div id="wrapper">


		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="row row-list">
					<div class="col-md-3 navbar-header">


						<a href="/stocks" class="navbar-brand">Accenture Trader</a>
					</div>


					<div class="col-md-8 text-right ">
						<p style="margin-top: 10px;">
							Welcome : <b><c:out value="${pageContext.request.remoteUser}" /></b>
						</p>
						<p>
							Your balance is:

							<fmt:formatNumber type="number" maxFractionDigits="2"
								value="${customer.getAccount().getAcBalance()}" var="newBalance" />

							<c:out value="${fn:replace(newBalance, ',', '.')}"></c:out>
							&#8364;
					</div>
					<div class="col-md-1 container-paragraph">
						<form action="/logout" method="post">
							<button type="submit"
								class="btn btn-danger navbar-btn login-btn btn-responsive ">Log
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
	<footer class="footer">
		<div>
			<p class="text-center" style="margin: 0 0 0 0px;">Copyright 2017
				Trader</p>
		</div>
	</footer>
</body>
</html>