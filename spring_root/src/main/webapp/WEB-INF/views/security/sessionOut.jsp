<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<script>
	alert("${message}");
	if(window.opener) {
		window.opener.parent.location.reload();
	}else{
		if(parent){
			window.parent.location.href="<%=(request.getContextPath().isEmpty() ? "/":request.getContextPath())%>";
		}else{
			window.location.href="<%=(request.getContextPath().isEmpty() ? "/":request.getContextPath())%>";			
		}
	}

	window.close();
</script>