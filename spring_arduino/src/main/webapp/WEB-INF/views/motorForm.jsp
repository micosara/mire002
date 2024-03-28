<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title></title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">


  <!-- Content Wrapper. Contains page content -->
  <div class="content">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
      		<div style="width:600px;margin:0 auto;">
	   			<div class="row">
	   				<div class="col-md-4"></div>
	   				<div class="col-md-4 text-center">
	   					<button class="btn btn-primary" onclick="motor_go('forward');">FORWARD</button>
	   				</div>
	   				<div class="col-md-4"></div>
	   			</div>
	   			<div class="row">
	   				<div class="col-md-4 text-center">
	   					<button class="btn btn-primary"  onclick="motor_go('left');">LEFT</button>
	   				</div>
	   				<div class="col-md-4"></div>
	   				<div class="col-md-4 text-center" >
	   					<button class="btn btn-primary"  onclick="motor_go('right');">RIGHT</button>
	   				</div>
	   			</div>
	   			<div class="row">
	   				<div class="col-md-4"></div>
	   				<div class="col-md-4 text-center">
	   					<button class="btn btn-primary"  onclick="motor_go('backward');">BACKWfARD</button>
	   				</div>
	   				<div class="col-md-4"></div>
	   			</div>
   			</div>
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
</div>
<!-- REQUIRED SCRIPTS -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
function motor_go(direct){
	let url = "motor/"+direct;
	$.ajax({
		url : url,
		method:"GET",
		success:function(result){
			alert(result);
		}
	});
	
}
</script>
<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
</body>
</html>
