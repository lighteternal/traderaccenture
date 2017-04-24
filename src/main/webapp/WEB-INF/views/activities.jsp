<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<title>Trades view</title>
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
	<h1>Trades view</h1>
	<table id="activitiesTable" class="display">

		<!-- Header Table -->
		<thead>
			<tr>
				<th>Id</th>
				<th>CreationDate</th>
				<th>Amount</th>
				<th>StockID</th>
				<th>StockPrice</th>
				<th>ActivityType</th>
			</tr>
		</thead>
		<!-- Footer Table -->
		<tfoot>
			<tr>
				<th>Id</th>
				<th>CreationDate</th>
				<th>Amount</th>
				<th>StockID</th>
				<th>StockPrice</th>
				<th>ActivityType</th>
			</tr>
		</tfoot>
	</table>

</body>
</html>