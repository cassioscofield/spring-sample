<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
</head>
<body>
	
	<section>
		<h2>There was an error with your request, please try again later.</h2>
	</section>
	
	<section style="display: hidden">
		<h4>${exception} - ${message}</h4>
		<h2>caused by: ${cause}</h2>
		<p>${trace}</p>
	</section>
	
</body>
</html>
