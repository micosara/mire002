<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<c:if test="${empty loginUser }">
  <script>
	location.href="common/loginForm";
  </script>	
</c:if>
 
<c:if test="${not empty loginUser }">
   <script>
	 location.href="index.do";
   </script>
</c:if>