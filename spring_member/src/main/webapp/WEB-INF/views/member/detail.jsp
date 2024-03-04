<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/module/header.jsp" %>

 <div >
      <section class="content-header">
        <div class="container-fluid">
           <div class="row md-2">
              <div class="col-sm-6">
                 <h1>상세페이지</h1>              
              </div>
              <div class="col-sm-6">
                 <ol class="breadcrumb float-sm-right">
                 <li class="breadcrumb-item">
                    <a href="#">
                       <i class="fa fa-dashboard">회원관리</i>
                    </a>
                 </li>
                 <li class="breadcrumb-item active">
                    상세보기
                 </li>              
            </ol>
              </div>
           </div>
        </div>
     </section>
    <!-- Main content -->
    <section class="content register-page">       
      <div class="register-box">         
          <form role="form" class="form-horizontal"  method="post">
             <div class="register-card-header" >
                <h1 class="text-center">회원 상세보기</h1>
             </div>
              <div class="register-card-body" >
                  <div class="row"  style="height:200px;">
                  <div class="mailbox-attachments clearfix col-md-12" style="text-align: center;">                     
                     <div class="manPicture" data-id="${member.id}" id="pictureView" style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>                                          
                  </div>
               </div>
               <br />
                   <div class="form-group row" >
                     <label for="inputEmail3" class="col-sm-3 control-label text-right">아이디</label>
   
                     <div class="col-sm-9">
                       <input name="id" type="text" class="form-control" id="inputEmail3"  value="${member.id }" readonly>
                     </div>
                   </div>                  
                   <div class="form-group row">
                     <label for="inputPassword3" class="col-sm-3 control-label text-right">이  름</label>
   
                     <div class="col-sm-9">
                       <input name="pwd" type="text" class="form-control" id="inputPassword3" value="${member.name }" readonly>
                     </div>
                   </div>
                    <div class="form-group row">
                     <label for="inputPassword3" class="col-sm-3 control-label text-right">이메일</label>
   
                     <div class="col-sm-9">
                       <input name="email" type="email" class="form-control" id="inputPassword3" value="${member.email }" readonly>
                     </div>
                   </div>
                    <div class="form-group row">
                     <label for="inputPassword3" class="col-sm-3 control-label text-right">전화번호</label>
                     <div class="col-sm-9">   
                        <input name="phone" type="text" class="form-control" id="inputPassword3" value="${member.phone }" readonly>                   
                     </div>                  
                   </div>               
                 </div>  
                <div class="card-footer" style="padding:5px 0;" >
                      <div class="row">
                         <div class="col-sm-4 text-center">
                            <button type="button" onclick="location.href='modifyForm?id=${member.id}';" id="modifyBtn" class="btn btn-warning ">수 정</button>
                         </div>
                      
                         <div class="col-sm-4 text-center">
                            <button type="button" onclick="location.href='remove?id=${member.id}';" id="deleteBtn" class="btn btn-danger" >삭 제</button>
                         </div>
                         
                         <div class="col-sm-4 text-center">
                           <button type="button" id="listBtn" onclick="CloseWindow();" class="btn btn-primary pull-right">닫 기</button>
                        </div>
                       </div>     
                </div>
              </form>
           </div>
    </section>
    
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->



<%@ include file="/WEB-INF/views/module/common_js.jsp" %>
<script>
MemberPictureThumb('');
</script>


<%@ include file="/WEB-INF/views/module/footer.jsp" %>