<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Todo</title>
</head>
<body>
	<form action="save" method="POST">
	
		<p>
			Id:
			<br/>
			<input type="text" name="id" value="${todo.id}" <c:if test="${empty todo.id}">disabled</c:if> />
		</p>
		<p>
			Description:
			<br/>
			<input type="text" name="description" value="${todo.description}"/>
		</p>
		<p>
			Priority:
			<br/>
			<input type="number" name="priority" value="${todo.priority}"/>
		</p>
		<p>
			<br/>
			<input class="btn btn-default" type="submit" value="Save" />
		</p>
		
	</form>
</body>
</html>