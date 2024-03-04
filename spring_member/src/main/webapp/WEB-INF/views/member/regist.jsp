<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/views/module/header.jsp" %> 


<!-- Content Wrapper. Contains page content -->
<div class="">

  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>회원등록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">회원관리</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	등록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section>
	<!-- Main content -->
	<section class="content register-page">
		<div class="register-box">
			<div class="login-logo">
    			<a href=""><b>회원 등록</b></a>
  			</div>
			<!-- form start -->
			<div class="card">				
				<div class="register-card-body">
					<form role="form" class="form-horizontal" action="regist" method="post" enctype="multipart/form-data">						
						<div class="input-group mb-3">
								<div class="mailbox-attachment-icon has-img" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
								<div class="mailbox-attachment-info" style="width:100%;">
									<div class="input-group input-group-sm">
										<label for="inputFile" class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
										<input id="inputFileName" class="form-control" type="text" name="tempPicture" disabled/>
										<input type="file" id="inputFile" name="picture" style="display:none;" onchange="picture_go();"/>
									</div>
								</div>
							<br />
						  </div>		
						  <div class="form-group row">
							 <label for="id" class="col-sm-3" style="font-size:0.9em;" >
							 	<span style="color:red;font-weight:bold;">*</span>아이디</label>	
							<div class="col-sm-9 input-group input-group-sm">
								<input name="id" 
									onkeyup="this.value=this.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g, &#39;&#39;);"
								type="text" class="form-control" id="id" placeholder="13글자 영문자,숫자 조합">
								<span class="input-group-append-sm">	
									<button type="button" onclick="idCheck_go();"  class="btn btn-info btn-sm btn-append">중복확인</button>
								</span>								
							</div>								
						</div>
						<div class="form-group row">
							<label for="pwd" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>패스워드</label>
							<div class="col-sm-9 input-group-sm">								
								<input class="form-control" name="pwd" type="password" class="form-control" id="pwd"
										placeholder="20글자 영문자,숫자,특수문자 조합" />
							</div>
							
						</div>
						<div class="form-group row">
							<label for="name" class="col-sm-3" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>이 름</label>
							<div class="col-sm-9 input-group-sm">								
								<input class="form-control" name="name" type="text" class="form-control" id="name"
										placeholder="이름을 입력하세요"
										onkeyup="this.value=this.value.trim();" />
							</div>
							
						</div>		
						<div class="form-group row">
							<label for="authority" class="col-sm-3" style="font-size:0.9em;" >권 한</label>
							<div class="col-sm-9">
								<select name="authority" class="form-control" style="font-size:0.9em;">
									<option value="ROLE_USER">사용자</option>
									<option value="ROLE_MANAGER">운영자</option>
									<option value="ROLE_ADMIN">관리자</option>
								</select>
							</div>
						</div>					
						<div class="form-group row">
							<label for="email" class="col-sm-3" style="font-size:0.9em;">이메일</label>
							<div class="col-sm-9 input-group-sm">
								<input name="email" type="email" class="form-control" id="email"
										placeholder="example@naver.com">
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-sm-3 control-label">전화번호</label>
							<div class="col-sm-9">	
								<div class="input-group-sm">
									<select style="width:75px;" name="phone" id="phone" class="form-control float-left">
										<option value="">-선택-</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="017">017</option>
										<option value="018">018</option>
									</select>							
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-&nbsp;</label>										
									<input style="width:68px;" name="phone" type="text" class="form-control float-left" />
									<label class="float-left" style="padding: 0; text-align: center;">&nbsp;-</label>
									<input style="width:68px;" name="phone" type="text" class="form-control float-right" />						
								</div>
							</div>
						</div>
						
						<div class="card-footer">
							<div class="row">								
								<div class="col-sm-6">
									<button type="button" id="registBtn" onclick="regist_go();" class="btn btn-info">등&nbsp;&nbsp;록</button>
							 	</div>
							 	
							 	<div class="col-sm-6">
									<button type="button" id="cancelBtn" onclick="CloseWindow();"
										class="btn btn-default float-right">&nbsp;&nbsp;&nbsp;취 &nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
								</div>
							
							</div>
						</div>
					</form>					
				</div><!-- register-card-body -->
			</div>
		</div>
	</section>		<!-- /.content -->
</div>
<!-- /.content-wrapper -->
    
<%@ include file="/WEB-INF/views/module/common_js.jsp" %>

<script>
function picture_go(){
	//alert("change");
	let pictureInput = document.querySelector("input[name='picture']");
	let file = pictureInput.files[0];
	
	
	 
   //이미지 확장자 jpg 확인
   var fileFormat = file.name.substr(file.name.lastIndexOf(".")+1).toUpperCase();
   if(!(fileFormat=="JPG" || fileFormat=="JPEG")){
        alert("이미지는 jpg/jpeg 형식만 가능합니다.");
        pictureInput.value="";      
        return;
   } 
   
   //이미지 파일 용량 체크
   if(file.size>1024*1024*1){
        alert("사진 용량은 1MB 이하만 가능합니다.");
        pictureInput.value="";
        return;
    };

	
	let pictureView = document.querySelector("#pictureView");
	document.querySelector('#inputFileName').value=file.name;
	
	if(file){
		var reader = new FileReader();
		
		 reader.onload = function (e) {
	        	//이미지 미리보기	        	
			 	pictureView.style.backgroundImage = "url("+e.target.result+")";
			 	pictureView.style.backgroundPosition="center";
			 	pictureView.style.backgroundSize="cover";
			 	pictureView.style.backgroundRepeat="no-repeat";			 	
	        }
		   reader.readAsDataURL(file);
	}
	
}

var checkedID;

function idCheck_go(){
	let id = $('input[name="id"]').val();
	
	if(!id){
		alert("아이디를 작성하세요.");
		$('input[name="id"]').focus();
		return;
	}
	
	$.ajax({
		url:"idCheck?id="+id,
		method:"get",
		success:function(result){
			//alert(result);
			if(result){
				alert("중복된 아이디 입니다.");
				$('input[name="id"]').focus();
			}else{
				alert("사용가능한 아이디 입니다.");
				checkedID = id;
			}
		}
	});
}
function regist_go(){
	if(!$('input[name="picture"]').val()){
		 alert("사진은 필수입니다.");
		 $('input[name="picture"]').click();
		 return;
	}
	
	if(!$('input[name="id"]').val()){
	    alert("아이디는 필수입니다.");
	    $('input[name="id"]').focus();
	    return;
	}
	if($('input[name="id"]').val()!=checkedID){
	    alert("아이디는 중복 확인이 필요합니다.");
	    return;
	}
	if(!$('input[name="pwd"]').val()){
	   alert("패스워드는 필수입니다.");
	   return;
    }
	if(!$('input[name="name"]').val()){
       alert("이름은 필수입니다.");
       return;
    }
	if(!$('input[name="email"]').val()){
	   alert("이메일은 필수입니다.");
	   return;
	}
    
	var form = $('form[role="form"]');
	form.submit();
}
</script>

<%@ include file="/WEB-INF/views/module/footer.jsp" %>    
    
    