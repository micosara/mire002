<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>LED 깜박이기</h1>
	
	<c:forEach begin="1" end="9" step="1" var="num">
		<button onclick="led_start(${num});">${num }</button>&nbsp;&nbsp;
	</c:forEach>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
		function led_start(num){
			//alert(num);
			let url = "built_in/"+num;
			//alert(url);
			$.ajax({
				"url":url,
				"method":"GET",
				"success":function(result){
					alert(result);
				}
				
			});
		}
	
	</script>
</body>
</html>





