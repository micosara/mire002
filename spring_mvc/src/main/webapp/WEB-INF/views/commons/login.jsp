<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인</h1>
	<form method="post">
		아이디:<input type="text" name="id"><br/>
		패스워드:<input type="password" name="pwd"><br/>
		<input type="submit" value="로그인">
	</form>
<script>	
<c:if test="${param.error eq 1 }">
	alert("아이디가 일치하지 않습니다.");
</c:if>	
<c:if test="${param.error eq 2 }">
	alert("패스워드가 일치하지 않습니다.");
</c:if>
</script>
</body>
</html>







