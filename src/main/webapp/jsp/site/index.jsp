<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Site page</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css">
	</head>
	<body>
		<h1 style="text-align: center;">This is site page</h1>
		<form action="<%=request.getContextPath()%>/site/loginhandle" method="POST">
			<input type="text" name="row">
			<input type="submit">
		</form>
	</body>
</html>