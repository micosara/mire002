<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index.jsp</h1>
		
	<ul>
		<sec:authorize access="isAuthenticated()">
		<li><a href="<%=request.getContextPath() %>/home" >/home</a></li>
		</sec:authorize>
		
		<sec:authorize access="hasAuthority('ROLE_USER')">
		<li><a href="<%=request.getContextPath() %>/member">/member</a></li>
		</sec:authorize>
		
		<sec:authorize access="hasAuthority('ROLE_MANAGER')">
		<li><a href="<%=request.getContextPath() %>/manager">/manager</a></li>
		</sec:authorize>
		<sec:authorize access="hasAuthority('ROLE_ADMIN')">
		<li><a href="<%=request.getContextPath() %>/admin">/admin</a></li>
		</sec:authorize>
	</ul>
	
	<sec:authorize access="!isAuthenticated()">
		<a href="/security/spring_security_login">로그인</a>&nbsp;&nbsp;&nbsp;
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated()">
		<a href="/security/j_spring_security_logout">로그아웃</a>
	</sec:authorize> 
</body>
</html>





