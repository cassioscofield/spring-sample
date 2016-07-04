<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Todo - List</title>
	<%@ include file="../head.jsp" %> 
</head>
<body>

	<div class="container">
		
		<div class="row">
		
			<div class="col-md-6">
				<h2>TODO</h2>
				<%@ include file="todo.jsp" %> 
			</div>
			<div class="col-md-6">
				<h2>TODO - List</h2>
				<ul>
					<c:forEach items="${todos}" var="item">
					    <li >
					    	${item.description} - ${item.priority} <a href="list?id=${item.id}">edit</a>&nbsp;<a href="remove?id=${item.id}">remove</a>
					    </li>
					</c:forEach>
				</ul>
			</div>
			
		</div>
		
	</div>
	
</body>
</html>