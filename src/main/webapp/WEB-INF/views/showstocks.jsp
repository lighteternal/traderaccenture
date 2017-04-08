<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Stocks</h2>

	
		<table>
			<tr>
				<c:forEach var="stock" items="${stocks}">
					<td>${stock}</td>

				</c:forEach>
			</tr>
		</table>


	
</body>
</html>