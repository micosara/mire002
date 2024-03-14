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
		
		List<MemberVO> memberList = searchMemberDAO.selectSearchMemberList(pageMaker);
		
		if(memberList!=null) for(MemberVO member : memberList) {
			member.setAuthorities(searchMemberDAO.selectAuthoritiesById(member.getId()));
		}
		
		int totalCount = searchMemberDAO.selectSearchMemberListCount(pageMaker);
		pageMaker.setTotalCount(totalCount);
		
		return memberList;
	}

	@Override
	public MemberVO detail(String id) throws SQLException {
		MemberVO member = super.detail(id);
		if(member!=null)
			member.setAuthorities(searchMemberDAO.selectAuthoritiesById(id));
		return member;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		//super.regist(member);
		searchMemberDAO.insertMember(member);
		
		if(member.getAuthorities().size()>0)for(String authority : member.getAuthorities()) {
			searchMemberDAO.insertAuthorities(member.getId(), authority);
		}
	}
	
	
	

}








