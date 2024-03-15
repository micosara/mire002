package com.spring.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.PageMaker;
import com.spring.dto.MemberVO;

public class SearchMemberDAOImpl extends MemberDAOImpl
								 implements SearchMemberDAO{

	private SqlSession sqlSession;
	public void setSearchDAOSqlSession(SqlSession session) {
		this.sqlSession = session;
	}
	
	@Override
	public List<MemberVO> selectSearchMemberList(PageMaker pageMaker) throws SQLException {
		int offset = pageMaker.getStartRow();
		int limit = pageMaker.getPerPageNum();
		RowBounds rows = new RowBounds(offset,limit);
		
		List<MemberVO> memberList 
		= sqlSession.selectList("Member-Mapper.selectSearchMemberList",pageMaker,rows);
		return memberList;
	}

	@Override
	public int selectSearchMemberListCount(PageMaker pageMaker) throws SQLException {
		return sqlSession.selectOne("Member-Mapper.selectSearchMemberListCount",pageMaker);
	}

	@Override
	public List<String> selectAuthoritiesById(String id) throws SQLException {
		List<String> authorities 
			= sqlSession.selectList("Member-Mapper.selectAuthoritiesById",id);
		return authorities;
	}
	
	
	
	@Override
	public void insertAuthorities(String id, String authority) throws SQLException {
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("id",id);
		paramMap.put("authority",authority);
		sqlSession.insert("Member-Mapper.insertAuthorities",paramMap);
		
	}

	@Override
	public void deleteAllAuthorityById(String id) throws SQLException {
		sqlSession.delete("Member-Mapper.deleteAllAuthorityById",id);
		
	}


}
