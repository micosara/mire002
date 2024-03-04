<%@page import="com.jdbc.dto.고객VO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jsp.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Starter</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

	<div class="row">
		<div class="col-12">
			<table class="table table-bordered table-hover dataTable dtr-inline">
				<tr class="text-center">
					<th class="sorting sorting_asc">고객아이디</th>
					<th class="sorting sorting_asc">고객이름</th>
					<th class="sorting sorting_asc">나이</th>
					<th class="sorting sorting_asc">등급</th>
					<th class="sorting sorting_asc">직업</th>
					<th class="sorting sorting_asc">적립금</th>
				</tr>
				<c:if test="${not empty memberList }">
					<c:forEach var="member" items="${memberList }">
					<%  고객VO member = (고객VO)pageContext.getAttribute("member"); %>
				<tr class="text-center">
					<td class="dtr-control sorting_1"><%=member.get고객이름() %></td>
					<td class="dtr-control sorting_1"><%=member.get고객이름() %></td>
					<td class="dtr-control sorting_1"><%=member.get나이() %></td>
					<td class="dtr-control sorting_1"><%=member.get등급() %></td>
					<td class="dtr-control sorting_1"><%=member.get직업() %></td>
					<td class="dtr-control sorting_1">
						￦<fmt:formatNumber pattern="#,###" value="<%=member.get적립금() %>" />
					</td>
				</tr>
					</c:forEach>
				</c:if>
			</table>
		
		</div>
	</div>


</div>	

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
</body>
</html>



