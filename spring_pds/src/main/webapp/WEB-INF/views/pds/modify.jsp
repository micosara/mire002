<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<%@ include file="/WEB-INF/views/module/header.jsp" %>
<div class="wrapper">
 <!-- Content Header (Page header) -->
    <section class="content-header">
    	<div class="container-fluid">
    		<div class="row mb-2">
    			<div class="col-sm-6">
	      			<h1>자료실</h1>
	      		</div>	      		
	    	
	       		
	       		<div class="col-sm-6">
			      <ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item"><a href="list.do"><i class="fa fa-dashboard"></i>자료실</a></li>
			        <li class="breadcrumb-item active">리스트</li>		        
			      </ol>
		      	</div>
	     	</div>	     	
      	</div>
    </section>

   <!-- Main content -->
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-primary">
					<div class="card-header">
						<h3>자료 수정</h3>
					</div><!--end card-header  -->
					<div class="card-body">
						<form enctype="multipart/form-data" role="form" method="post" action="modify.do" name="modifyForm">
							<input type="hidden" name="pno" value="${pds.pno }" />
							
							<div class="form-group">
								<label for="writer">작성자</label> 
								<input type="text" id="writer" readonly
									name="writer" class="form-control" value="${pds.writer }">
							</div>
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title" value="${pds.title }"
									name='title' class="form-control" placeholder="제목을 쓰세요">
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea id="content" class="form-control" rows="5" name="content">${pds.content}</textarea>
							</div>
							
							<div class="form-group">								
								<div class="card card-outline card-success">
									<div class="card-header">
										<h3 style="display:inline;line-height:40px;">첨부파일 : </h3>
										&nbsp;&nbsp;
										<button class="btn btn-primary"	onclick="addFile_go()" type="button" id="addFileBtn">Add File</button>
									</div>									
									<div class="card-footer fileInput">
										<ul class="mailbox-attachments d-flex align-items-stretch clearfix">
											<!-- 첨부파일 썸네일 -->		
											
											<c:forEach items="${pds.attachList }" var="attach" >
											<li class="attach-item thumb${attach.ano}" file-name="${attach.fileName.split('\\$\\$')[1] }" target-ano="${attach.ano }" >																			
												<div class="mailbox-attachment-info ">
													<a class="mailbox-attachment-name" name="attachedFile" href="<%=request.getContextPath()%>/getFile.do?ano=${attach.ano} " >													
														<i class="fas fa-paperclip"></i>
														${attach.fileName.split('\\$\\$')[1] }&nbsp;&nbsp;
														<button type="button" 
															onclick="removeFile_go('thumb${attach.ano}');return false;"
															style="border:0;outline:0;" class="badge bg-red">X</button>																									
													</a>													
												</div>
											</li>	
											</c:forEach>									
										</ul>
										<br/>														
									</div>
								</div>
							</div>
							
						
						</form>
					</div><!--end card-body  -->
					<div class="card-footer">
						<button type="button" class="btn btn-warning" id="modifyBtn" onclick="modify_submit();">수 정</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn" id="cancelBtn" onclick="history.go(-1);">취 소</button>
					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
</div>

<%@ include file="/WEB-INF/views/module/common_js.jsp" %>
<script>
var dataNum=0;
function addFile_go(){
	//alert("add file btn");
	var attachedFile=$('a[name="attachedFile"]').length; //기존파일
	var inputFile=$('input[name="uploadFile"]').length;	 //추가된 파일
	var attachCount=attachedFile+inputFile; //기존파일 + 추가된파일 개수
	
	if(attachCount >=5){
		alert("파일추가는 5개까지만 가능합니다.");
		return;
	}
	
	var div=$('<div>').addClass("inputRow").attr("data-no",dataNum);		
	var input=$('<input>').attr({"type":"file","name":"uploadFile","onchange":"fileChange_go("+dataNum+");"}).css("display","inline");
	div.append(input).append("<button onclick='remove_go("+dataNum+");' style='border:0;outline:0;' class='badge bg-red' type='button'>X</button>");		
	$('.fileInput').append(div);
	dataNum++;		
	
}

function removeFile_go(className){
	//alert(className);
	let li = $('li.'+className);
	
	if(!confirm(li.attr("file-name")+"을 정말 삭제하시겠습니까?")){
		return;
	}    
	
	li.remove();
	
	var input=$('<input>').attr({"type":"hidden",
		 "name":"deleteFile",
		 "value":li.attr("target-ano")
		}); 
	$('form[role="form"]').prepend(input);
}

function modify_submit(){
	//alert("submit btn");
	let form = $('form[name="modifyForm"]');
	
	//유효성 체크
	if($("input[name='title']").val()==""){
		alert(input.name+"은 필수입니다.");
		$("input[name='title']").focus();
		return;
	}
	
	//파일 첨부확인
	let files = $('input[name="uploadFile"]');
	for(var file of files){
		console.log(file.name+" : "+file.value);
		if(file.value==""){
			alert("파일을 선택하세요.");
			file.focus();
			return;
		}
	}	
	
	form.submit();

}


function fileChange_go(dataNum){
    //alert("file change");
    let input = $('div[data-no="'+dataNum+'"] input[type="file"]')[0];
    let file = input.files[0];
	if(file.size > 1024*1024*40){
		alert("첨부파일크기는 40MB 이하만 가능합니다.");
    	input.value="";
	}
}

function remove_go(dataNum){
	let div = $('div[data-no="'+dataNum+'"]');
	div.remove();
}
</script>
<%@ include file="/WEB-INF/views/module/footer.jsp" %>














