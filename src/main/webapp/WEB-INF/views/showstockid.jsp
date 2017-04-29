<!DOCTYPE HTML>
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

		<div class="content">


			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<div class="row row-list">
						<div class="col-md-3 navbar-header">


							<a href="/stocks" class="navbar-brand">Accenture Trader</a>
						</div>


						<div class="col-md-8 text-right ">
							<p style="margin-top: 10px;">
								Welcome : <b><c:out
										value="${pageContext.request.remoteUser}" /></b>
							</p>
							<p>
								Your balance is:
<<<<<<< HEAD
								<fmt:formatNumber type="number" maxFractionDigits="2"
									value="${customer.getAccount().getAcBalance()}"
									var="newBalance" />

								<c:out value="${fn:replace(newBalance, ',', '.')}"></c:out>&#8364;
=======
								<c:out value="${customer.getAccount().getAcBalance()}"></c:out>&#8364;
>>>>>>> 979b912b8e002ad6a9d29d5735d8ed25111b2285
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
						<select id="selectBox" onchange="window.location.href=this.value">
							<option value="" selected>Select a Stock...</option>
							<c:forEach var="stock1" items="${stocks}">

								<option value="/stocks/${stock1.getStockID()}">${stock1.getSName()}</option>
							</c:forEach>
						</select>

					</div>
					<!-- <input id="example-heroes" placeholder="Heroes" /> -->
				</div>
			</nav>

			<div class="btn-group btn-group-justified">
				<a href="/stocks" class="btn btn-primary">Home</a> <a href="/stocks"
					class="btn btn-primary">New Order</a> <a href="/act"
					class="btn btn-primary">Trades View</a><a href="#"
					class="btn btn-primary">Portfolio</a>
			</div>




			<div class="container">
				<div class="row">
					<h1 style="margin-bottom: 50px;">${stock.getSName()}</h1>
				</div>

				<div class="col-md-6">
					<div>

						<div class="col-md-6">
							<div class="btn-group btn-group-justified">
								<a href="#" class="btn btn-primary" id="buyButton"
									onclick="setBuy()" data-price="${stock.getSBuyPrice()}">Buy
									${stock.getSBuyPrice()}</a> <a href="#" class="btn btn-primary"
									id="sellButton" onclick="setSell()"
									data-price="${stock.getSSellPrice()}">Sell
									${stock.getSSellPrice()}</a>
							</div>
							<hr>
							<form id="quantityForm">
								<h3>Quantity:</h3>
								<!-- <br> -->
								<div class="form-group">
									<input type="text" name="quantity" class="form-control"
										placeholder="put quantity" id="quantity"
										onkeyup="addQuantity()">
									<!-- <br> -->
									<!-- <button type="button_quantity" class="btn btn-default">Ok</button> -->
								</div>

							</form>
						</div>
						<div class="col-md-6">
							<h3 style="text-align: center">
								Order Price
								<div id="orderprice"></div>
							</h3>
							<hr>
							<div class="boxed">
								<h3 style="text-align: center">
									Fees & Taxes <br>
									<div id="fees"></div>
								</h3>
							</div>
						</div>
					</div>


				</div>
				<div class="col-md-6">
					<div class="table-responsive">
						<table class="table table-bordered">

							<tbody>
								<tr class="warning">
									<td>Day Low <br> ${stock.getSDayLow() }
									</td>
									<td>Day High <br> ${stock.getSDayHigh() }
									</td>
									<td>Volume <br> ${stock.getSVolume() }
									</td>
								</tr>
								<tr class="info">
									<td>Limit Up <br> ${stock.getSLimitUp() }
									</td>
									<td>Limit Down <br> ${stock.getSLimitDown() }
									</td>
									<td>Close <br> ${stock.getSClosePrice() }
									</td>
								</tr>

							</tbody>
						</table>
						<!-- <a href="ordered.jsp" class="btn btn-primary" role="TotalButton">BUY/SELL</a> -->
						<input type="button" value="BUY/SELL" id="submitButton"
							class="btn btn-primary" data-stockid="${stock.getStockID()}"
							onclick="submitForms()" />
					</div>
				</div>
			</div>

		</div>
		<!-- /.container -->

		<footer class="footer">
			<div>
				<p class="text-center" style="margin:0 0 0 0px;">Copyright 2017 Trader</p>
			</div>
		</footer>

	</div>


	<!-- Latest compiled and minified JavaScript -->
	<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/js/stockid.js"></script>
	<script src="/js/jquery.easy-autocomplete.min.js"></script>
	<script src="/js/autocomplete.js"></script>
</body>
</html>