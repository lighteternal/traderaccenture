<%@ page import="java.sql.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="utf-8">

<title>AccentureTrader</title>
<link href="/css/main.css" rel="stylesheet" type="text/css" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<style>
body {
	padding: 0;
	margin: 0;
	font-size: 13px;
}
</style>

</head>
<body>
	<div id="wrapper">


		<nav class="navbar navbar-default" style="margin-bottom: 5px;">
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
				<div class="row" style="margin-left: 1px;">
					<p>Please select a stock from the dropdown menu.</p>
					<select id="selectBox" onchange="window.location.href=this.value">
						<option value="" selected>Select a Stock...</option>
						<c:forEach var="stock1" items="${stocks}">

							<option value="/stocks/${stock1.getStockID()}">${stock1.getSName()}</option>
						</c:forEach>
					</select>

				</div>


			</div>
		</nav>

		<div class="btn-group btn-group-justified">
			<a href="/stocks" class="btn btn-primary">Home</a> <a href="/stocks"
				class="btn btn-primary">New Order</a> <a href="/act"
				class="btn btn-primary">Trades View</a><a href="#"
				class="btn btn-primary">Portfolio</a>
		</div>
		<img
			src="http://img.welkermedia.com/uploads/2016/08/be-greaterthan-you-imagined-male.jpg"
			style="width: 100%;">
	</div>
	<footer class="footer">
		<div>
			<p class="text-center" style="margin: 0 0 0 0px;">Copyright 2017
				Trader</p>
		</div>
	</footer>

</body>
</html>