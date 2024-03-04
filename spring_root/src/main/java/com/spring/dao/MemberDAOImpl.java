package com.spring.dao;

import java.sql.SQLException;

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
	

}
