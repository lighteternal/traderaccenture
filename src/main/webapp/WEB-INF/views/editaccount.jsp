<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
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


			<a href="/stocks" class="navbar-brand">Accenture Trader</a>
		</div>

		<div class="row row-list text-right">
			<div class="col-xs-8">
				<p class="text-right navbar-btn">
					Welcome : <b><c:out value="${pageContext.request.remoteUser}" /></b>
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

	<div class="btn-group btn-group-justified">
		<a href="/stocks" class="btn btn-primary">Home</a> <a href="/stocks"
			class="btn btn-primary">New Order</a> <a href="/act"
			class="btn btn-primary">Trades View</a><a href="#"
			class="btn btn-primary">Portfolio</a>
	</div>


	<div class="container">
		<h1>Edit Profile</h1>
		<hr>
		<div class="row">


			<!-- edit form column -->
			<div class="col-md-9 personal-info">

				<h3>Personal info</h3>

				<form class="form-horizontal" role="form" action="/updateCustomer"
					method="put">
					<div class="form-group">
						<label class="col-lg-3 control-label">First name:</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" id="firstName" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Last name:</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" id="lastName" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">ID Card:</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" id="idCard" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Birthday:</label>
						<div class="col-lg-8">
							<input class="form-control" type="text" id="birthday"
								placeholder="YYYY-MM-DD">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Gender:</label>
						<div class="col-md-4 radio">
							<label><input type="radio" name="optradio" id="sex">F</label>
						</div>
						<div class="col-md-4 radio">
							<label><input type="radio" name="optradio" id="sex">M</label>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label">Address:</label>
						<div class="col-md-8">
							<input class="form-control" type="text" id="address" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">City:</label>
						<div class="col-md-8">
							<input class="form-control" type="text" id="city" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Mobile Phone:</label>
						<div class="col-md-8">
							<input class="form-control" type="text" id="mobilePhone" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Phone:</label>
						<div class="col-md-8">
							<input class="form-control" type="text" id="phone" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Email:</label>
						<div class="col-md-8">
							<input class="form-control" type="text" id="email" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">AFM:</label>
						<div class="col-md-8">
							<input class="form-control" type="text" id="AFM" value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Occupation:</label>
						<div class="col-md-8">
							<input class="form-control" type="text" id="occupation" value="">
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-3 control-label">Password:</label>
						<div class="col-md-8">
							<input class="form-control" type="password" id="password"
								value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">Confirm password:</label>
						<div class="col-md-8">
							<input class="form-control" type="password" id="confirmpassword"
								value="">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-8">
							<input type="button" class="btn btn-primary" value="Save Changes">
							<span></span> <input type="reset" class="btn btn-default"
								value="Cancel">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<hr>
</body>
</html>