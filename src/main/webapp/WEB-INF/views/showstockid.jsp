<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	
	.footer {
    	color: #fff;
	    line-height: 59px;
	    background-color: #000;
	    border-top: 1px solid #fff;
	}
	

.content {
    position: relative;
    margin-bottom: 30em;
}

body {
    padding: 0;
    margin: 0;
    font-family: 'Open Sans', 'Trebuchet MS', arial, sans-serif;
    font-size: 13px;
}



td{

font-size:18px;

}
		
	</style>


</head>
<body>
	
	<div id="wrapper">
	
	<div class="content">
	
    
	<nav class="navbar navbar-default">
		<div class="container-fluid">
		
		
			   <div class="navbar-header">
				 <a href="#" class="navbar-brand">Accenture Trader</a>			
			  </div>
			
			<div class="row row-list text-right">
			    <div class="col-xs-8"> 
				    <p class="text-right navbar-btn">
						Welcome : <b><c:out value="${pageContext.request.remoteUser}"/></b>
					</p></div>
			    <div class="col-xs-1 container-paragraph">
			    	<form action="/logout" method="post">						
						<button type="submit" class="btn btn-danger navbar-btn login-btn ">Log out</button>
						<input type="hidden" name="${_csrf.parameterName}"
									                       value="${_csrf.token}"/>
					</form>
				</div>
			</div>  
					        		
			        		
			
		</div>
	</nav>
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
						<a href="#" class="btn btn-primary" id="buyButton" onclick="setBuy()" data-price="${stock.getSBuyPrice()}">Buy	${stock.getSBuyPrice()}</a> 
						<a href="#" class="btn btn-primary" id="sellButton" onclick="setSell()" data-price="${stock.getSSellPrice()}">Sell ${stock.getSSellPrice()}</a>
					</div>
					<hr>
					<form id="quantityForm">
						<h3>Quantity:</h3>
						<div class="form-group">
						  
						  <input type="text" name="quantity" class="form-control" placeholder="put quantity" id="quantity" onblur="addQuantity()">
						</div>
					</form>
				</div>
				<div class="col-md-6">
					<h3 style="text-align:center">Order Price</h2>
					
					
					<div class="boxed">
						<h3 style="text-align:center">Fees & Taxes <br><div id="fees"></div></h3>
					</div>
				</div>
			</div>


		</div>
		<div class="col-md-6">
		 
		 <div class="table-responsive">
			<table class="table table-bordered " >

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
			<input type="button" value="BUY/SELL" id="submitButton" class="btn btn-primary" data-stockid="${stock.getStockID()}" onclick="submitForms()" />
		</div>
	 </div>
	</div>


  </div> <!-- /.container -->
  
  	<footer class="footer">
		  <div class="container-fluid">
		    <p class="pull-left">Copyright © 2017 Trader</p>
		  </div>
		</footer>

 
</div>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="/js/stockid.js"></script>
</body>
</html>