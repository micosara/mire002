package com.spring.command;

public class PageMaker {

	private int page = 1; // 페이지번호
	private int perPageNum = 10; // 페이지당 리스트개수
	private String searchType = ""; // 검색구분
	private String keyword = ""; // 검색어

	private int totalCount; // 전체 행의 개수
	private int startPage = 1; // 시작 페이지 번호
	private int endPage = 1; // 마지막 페이지 번호
	private int realEndPage; // 끝 페이지 번호
	private boolean prev; // 이전페이지 버튼 유무
	private boolean next; // 다음페이지 버튼 유무

	private int displayPageNum = 10; // 한 페이지에 보여줄 페이지번호 개수

	// starPage,endPage, prev, next 설정. by totalCount
	private void calcData() {
		endPage = (int) (Math.ceil(page / (double) displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;

		realEndPage = (int) (Math.ceil(totalCount / (double) perPageNum));

		if (startPage < 0) {
			startPage = 1;
		}
		if (endPage > realEndPage) {
			endPage = realEndPage;
		}

		prev = startPage == 1 ? false : true;
		next = endPage < realEndPage ? true : false;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public int getPage() {
		return page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public String getSearchType() {
		return searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

}
