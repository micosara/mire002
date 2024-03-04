<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/WEB-INF/views/module/header.jsp"%>
<!-- Content Wrapper. Contains page content -->
<div>
	<section class="content-header">
		<div class="container-fluid">
			<div class="row md-2">
				<div class="col-sm-6">
					<h1>수정페이지</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#"> <i
								class="fa fa-dashboard">회원관리</i>
						</a></li>
						<li class="breadcrumb-item active">수정</li>
					</ol>
				</div>
			</div>
		</div>
	</section>
	<!-- Main content -->
	<section class="content register-page">
		<form role="form" class="form-horizontal" action="modify.do"
			method="post" enctype="multipart/form-data">
			<div class="card" style="min-width: 450px;">
				<div class="card-body">
					<div class="row">
						<input type="file" id="inputFile" name="picture"
							style="display: none" onchange="picture_go();" /> <input
							type="hidden" name="oldPicture" value="${member.picture }" />
						<div class="input-group col-md-12">
							<div class="col-md-12" style="text-align: center;">
								<div class="manPicture" data-id="${member.id }" id="pictureView"
									style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto; margin-bottom: 5px;"></div>
								<div class="input-group input-group-sm">
									<label for="inputFile"
										class=" btn btn-warning btn-sm btn-flat input-group-addon">사진변경</label>
									<input id="inputFileName" class="form-control" type="text"
										name="tempPicture" disabled
										value="${member.picture.split('\\$\\$')[1]}" />
								</div>
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="id" class="col-sm-3 control-label text-center">아이디</label>
						<div class="col-sm-9">
							<input readonly name="id" type="text" class="form-control"
								id="id" value="${member.id }" />
						</div>
					</div>

					<div class="form-group row">
						<label for="pwd" class="col-sm-3 control-label text-center">패스워드</label>

						<div class="col-sm-9">
							<input name="pwd" type="password" class="form-control" id="pwd"
								value="${member.pwd }" />
						</div>
					</div>
					<div class="form-group row">
						<label for="name" class="col-sm-3 control-label text-center">이
							름</label>

						<div class="col-sm-9">
							<input name="name" type="text" class="form-control" id="name"
								value="${member.name }" />
						</div>
					</div>


					<div class="form-group row">
						<label for="authority" class="col-sm-3 control-label text-center">권
							한</label>
						<div class="col-sm-9">
							<select name="authority" class="form-control">
								<option ${member.authority eq 'ROLE_USER' ? 'selected' : '' }
									value="ROLE_USER">사용자</option>
								<option ${member.authority eq 'ROLE_MANAGER' ? 'selected' : '' }
									value="ROLE_MANAGER">운영자</option>
								<option ${member.authority eq 'ROLE_ADMIN' ? 'selected' : '' }
									value="ROLE_ADMIN">관리자</option>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label for="email" class="col-sm-3 control-label text-center">이메일</label>

						<div class="col-sm-9">
							<input name="email" type="email" class="form-control" id="email"
								placeholder="example@naver.com" value="${member.email }">
						</div>
					</div>
					<div class="form-group row">
						<label for="phone" class="col-sm-3 control-label text-center">전화번호</label>
						<div class="col-sm-9">
							<input name="phone" type="text" class="form-control"
								id="inputPassword3" value="${member.phone }">
						</div>
					</div>

					<div class="card-footer row"
						style="margin-top: 0; border-top: none;">
						<button type="button" id="modifyBtn" onclick="modify_go();"
							class="btn btn-warning col-sm-4 text-center">수정하기</button>
						<div class="col-sm-4"></div>
						<button type="button" id="cancelBtn" onclick="history.go(-1);"
							class="btn btn-default pull-right col-sm-4 text-center">취
							소</button>
					</div>
				</div>
			</div>
		</form>
	</section>
	<!-- /.content -->
</div>

<%@ include file="/WEB-INF/views/module/common_js.jsp"%>
<script>
MemberPictureThumb('');
</script>

<script>
	function picture_go() {
		let inputFile = $('input#inputFile')[0].files[0];
		let fileFormat = inputFile.name.substr(
				inputFile.name.lastIndexOf(".") + 1).toUpperCase();

		//이미지 확장자 jpg 확인
		if (!(fileFormat == "JPG" || fileFormat == "JPEG")) {
			alert("이미지는 jpg 형식만 가능합니다.");
			return;
		}

		//이미지 파일 용량 체크
		if (inputFile.size > 1024 * 1024 * 1) {
			alert("사진 용량은 1MB 이하만 가능합니다.");
			return;
		}
		;

		$('#inputFileName').val(inputFile.name);

		//미리보기
		if (inputFile) {
			var reader = new FileReader();
			let pictureView = $('div#pictureView')[0];

			reader.onload = function(e) {
				//이미지 미리보기
				pictureView.style.backgroundImage = "url(" + e.target.result
						+ ")";
				pictureView.style.backgroundPosition = "center";
				pictureView.style.backgroundSize = "cover";
				pictureView.style.backgroundRepeat = "no-repeat";
			}
			reader.readAsDataURL(inputFile);
		}
	}
	function modify_go() {
		//alert("modify btn");
		var form = $('form[role="form"]');
		form.submit();
	}
</script>

<%@ include file="/WEB-INF/views/module/footer.jsp"%>


