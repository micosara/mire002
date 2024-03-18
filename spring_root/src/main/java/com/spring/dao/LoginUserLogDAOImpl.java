package com.spring.dao;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class LoginUserLogDAOImpl implements LoginUserLogDAO {
	private SqlSession session;
	public void setSqlsession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public void insertLoginUserLog(Map<String, Object> logVO) throws SQLException {
		session.update("LoginUserLog-Mapper.insertLoginUserLog",logVO);
		
	}

	@Override
	public void deleteLoginUserLog() throws SQLException {
		session.update("LoginUserLog-Mapper.deleteLoginUserLog");
		
	}
}
