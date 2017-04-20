<!DOCTYPE HTML>
<%@ page import="java.sql.*"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	ResultSet resultset = null;
	
%>
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
					<p class="text-right navbar-btn"> Your balance is: <c:out value="${customer.getAccount().getAcBalance()}"></c:out>
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
	
	  <%
		try {
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost/traderdb1?user=root&password=root");

			Statement statement = connection.createStatement();

			resultset = statement.executeQuery("select stockID,sName from Stocks");
			
	%>

	
		
		<select id="selectBox" onchange="window.location.href=this.value">
			<option value="" selected>Select a Stock...</option>
			<%
				while (resultset.next()) {
			%>
			
			<option value="/stocks/<%=resultset.getString(1)%>"><%=resultset.getString(2)%></option>
			<%
				}
			%>
		</select>
		
	

	<%
		//**Should I input the codes here?**
		} catch (Exception e) {
			out.println("wrong entry" + e);
		}
	%> </div>
	<div class="btn-group btn-group-justified">
		<a href="#" class="btn btn-primary">Home</a> <a href="#"
			class="btn btn-primary">New Order</a> <a href="#"
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
						Quantity:<br> <input type="text" name="quantity"
							placeholder="quantity" id="quantity" onblur="addQuantity()"><br>

					</form>
				</div>
				<div class="col-md-6">
					Order Price
					<div id="test"></div>
					<hr>
					<div class="boxed">
						Fees & Taxes <br>
						<div id="fees"></div>
					</div>
				</div>
			</div>


		</div>
		<div class="col-md-6">
			<table class="table table-bordered">

				<tbody>
					<tr>
						<td>Day Low <br> ${stock.getSDayLow() }
						</td>
						<td>Day High <br> ${stock.getSDayHigh() }
						</td>
						<td>Volume <br> ${stock.getSVolume() }
						</td>
					</tr>
					<tr>
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
				data-stockid="${stock.getStockID()}" onclick="submitForms()" />
		</div>

	</div>






	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/js/stockid.js"></script>
</body>
</html>