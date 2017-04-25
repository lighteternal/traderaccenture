<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Fail</title>
</head>
<body>
<script>
    window.onload = function() {
       alert("Sorry ${pageContext.request.remoteUser }, we could not process your request. Perhaps check your balance first?");
       window.location.href = "/stocks"
    }
</script>

</body>
</html>