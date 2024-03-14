package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.PageMaker;
import com.spring.dto.MemberVO;

public interface SearchMemberDAO extends MemberDAO{

	List<MemberVO> selectSearchMemberList(PageMaker pageMaker) throws SQLException;
	
	int selectSearchMemberListCount(PageMaker pageMaker)throws SQLException;
	

	List<String> selectAuthoritiesById(String id)throws SQLException;
	void insertAuthorities(String id, String authority)throws SQLException;
	
}
