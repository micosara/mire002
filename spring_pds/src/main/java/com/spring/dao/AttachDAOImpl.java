package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.AttachVO;
import com.spring.dto.PdsVO;

public class AttachDAOImpl implements AttachDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession session) {
		this.sqlSession = session;
	}
	
	@Override
	public List<AttachVO> selectAttachByPno(int pno) throws SQLException {
		return sqlSession.selectList("Attach-Mapper.selectAttachByPno",pno);
	}

	@Override
	public AttachVO selectAttachByAno(int ano) throws SQLException {
		return sqlSession.selectOne("Attach-Mapper.selectAttachByAno",ano);
	}

	@Override
	public void insertAttach(AttachVO attach) throws SQLException {
		sqlSession.insert("Attach-Mapper.insertAttach",attach);
		
	}

	@Override
	public void deletAttach(int ano) throws SQLException {
		sqlSession.delete("Attach-Mapper.deleteAttach",ano);
		
	}

	@Override
	public void deletAllAttach(int pno) throws SQLException {
		sqlSession.delete("Attach-Mapper.deletAllAttach",pno);
		
	}

}
