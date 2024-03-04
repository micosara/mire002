<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Echo message</title>
</head>
<body>
	<h1>JSP forwarding</h1>
	<h1>method : ${requestScope.method }</h1>
	<h1>To : ${param.who}</h1>
	<h1>Message : ${param.message }</h1>
</body>
</html>







