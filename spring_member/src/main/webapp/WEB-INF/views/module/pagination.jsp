<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
  
<form id="jobForm">	
	<input type='hidden' name="page" value="" />
	<input type='hidden' name="perPageNum" value=""/>
	<input type='hidden' name="searchType" value="" />
	<input type='hidden' name="keyword" value="" />
</form>


<nav aria-label="Navigation">
	<ul class="pagination justify-content-center m-0">
		<li class="page-item">
			<a class="page-link" href="javascript:search_list(1);">
				<i class="fas fa-angle-double-left"></i>
			</a>
		</li>
		
		<li class="page-item">
			<a class="page-link" href="javascript:list_go(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.page});">
				<i class="fas fa-angle-left"></i>
			</a>						
		</li>
		<c:forEach var="pageNum" begin="${pageMaker.startPage }" 
								 end="${pageMaker.endPage }" >
		<li class="page-item ${pageMaker.page == pageNum?'active':''}">
			<a class="page-link" href="javascript:search_list(${pageNum });">
				${pageNum }
			</a>
		</li>
		</c:forEach>
			
		<li class="page-item">
			<a class="page-link" href="javascript:list_go(${pageMaker.next ? pageMaker.endPage+1 :pageMaker.page});">
				<i class="fas fa-angle-right"></i>
			</a>						
		</li>	
		<li class="page-item">
			<a class="page-link" href="javascript:list_go(${pageMaker.realEndPage});">
				<i class="fas fa-angle-double-right"></i>
			</a>
		</li>		
	</ul>
</nav>    


<script>
function search_list(page){
	//alert(page);
	let perPageNum = document.querySelector('select[name="perPageNum"]').value;
	let searchType = document.querySelector('select[name="searchType"]').value;
	let keyword = document.querySelector('input[name="keyword"]').value;
	
	//alert(perPageNum+":"+searchType+":"+keyword);
	
	let form = document.querySelector("#jobForm");
	form.page.value=page;
	form.perPageNum.value=perPageNum;
	form.searchType.value = searchType;
	form.keyword.value = keyword;
	
	console.log(page,perPageNum,searchType,keyword);
	console.log($(form).serialize());
	
	//form.action="";
	//form.method="";
	form.submit();
}	
</script>


