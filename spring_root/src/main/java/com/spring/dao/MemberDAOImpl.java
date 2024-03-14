package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession session) {
		this.sqlSession = session;
	}
	
	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member = sqlSession.selectOne("Member-Mapper.selectMemberById",id);
		return member;
	}

	@Override
	public List<String> selectMemberAuthoritiesById(String id) throws SQLException {
		List<String> authorities 
			= sqlSession.selectList("Member-Mapper.selectMemberAuthoritiesById",id);
		return authorities;
	}
	

}
