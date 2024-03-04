<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:if test="${empty loginUser }">
<script>
	alert("세션이 만료되었습니다.\n로그인 페이지로 이동합니다.");
	location.href="<%=request.getContextPath()%>/commons/login";
</script>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${loginUser}님 환영합니다.</h1>
	<h1>main.jsp</h1>
	<button type="button">로그아웃</button>
</body>
</html>