<%@ page import="java.sql.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
						Welcome Back <b><c:out
								value="${pageContext.request.remoteUser}" /></b>
					</p>
					<p class="text-right navbar-btn">
						Your balance is:
						<c:out value="${customer.getAccount().getAcBalance()}"></c:out>
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
	<div>
		<p>Please select a stock from the dropdown menu.</p>
		<br> <select id="selectBox"
			onchange="window.location.href=this.value">
			<option value="" selected>Select a Stock...</option>
			<c:forEach var="stock1" items="${stocks}">

				<option value="/stocks/${stock1.getStockID()}">${stock1.getSName()}</option>
			</c:forEach>
		</select>

	</div>
	<div class="btn-group btn-group-justified">
		<a href="#" class="btn btn-primary">Home</a> <a href="#"
			class="btn btn-primary">New Order</a> <a href="#"
			class="btn btn-primary">Trades View</a><a href="#"
			class="btn btn-primary">Portfolio</a>
	</div>
</body>
</html>