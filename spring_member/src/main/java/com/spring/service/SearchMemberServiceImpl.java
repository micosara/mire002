package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.PageMaker;
import com.spring.dao.SearchMemberDAO;
import com.spring.dto.MemberVO;

public class SearchMemberServiceImpl extends MemberServiceImpl
									implements SearchMemberService{
	
	private SearchMemberDAO searchMemberDAO;
	public void setSearchMemberDAO(SearchMemberDAO searchMemberDAO) {
		this.searchMemberDAO = searchMemberDAO;
	}
	
	@Override
	public List<MemberVO> searchList(PageMaker pageMaker) throws SQLException {
		
		int totalCount = searchMemberDAO.selectSearchMemberListCount(pageMaker);
		pageMaker.setTotalCount(totalCount);
		return searchMemberDAO.selectSearchMemberList(pageMaker);
	}
	

}








