<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	alert("세션이 만료되었습니다. \n다시 로그인하시기 바랍니다.");
	window.close();
	if(window.opener){
		window.opener.parent.location.href="/common/loginForm.do";
	}else{
		window.parent.location.href="/common/loginForm.do";
	}
</script>