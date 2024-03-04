package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.PageMaker;
import com.spring.dto.PdsVO;

public class PdsDAOImpl implements PdsDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession session) {
		this.sqlSession = session;
	}
	
	@Override
	public List<PdsVO> selectSearchPdsList(PageMaker pageMaker) throws SQLException {
		
		int offset = (pageMaker.getPage()-1)*pageMaker.getPerPageNum();
		int limmit = pageMaker.getPerPageNum();
		
		RowBounds rows = new RowBounds(offset,limmit);
		
		return sqlSession.selectList("Pds-Mapper.selectSearchPdsList",pageMaker,rows);
	}

	@Override
	public int selectSearchPdsListCount(PageMaker pageMaker) throws SQLException {
		return sqlSession.selectOne("Pds-Mapper.selectSearchPdsListCount",pageMaker);
	}

	@Override
	public PdsVO selectPdsByPno(int pno) throws SQLException {
		PdsVO pds = sqlSession.selectOne("Pds-Mapper.selectPdsByPno",pno);
		return pds;
	}

	@Override
	public int selectPdsSeqNext() throws SQLException {
		int seq = sqlSession.selectOne("Pds-Mapper.selectPdsSeqNext");
		return seq;
	}

	@Override
	public void insertPds(PdsVO pds) throws SQLException {
		sqlSession.insert("Pds-Mapper.insertPds",pds);
		
	}

	@Override
	public void updatePds(PdsVO pds) throws SQLException {
		sqlSession.update("Pds-Mapper.updatePds",pds);
		
	}

	@Override
	public void increaseViewCnt(int pno) throws SQLException {
		sqlSession.update("Pds-Mapper.increaseViewCnt",pno);
		
	}

	@Override
	public void deletePds(int pno) throws SQLException {
		sqlSession.delete("Pds-Mapper.deletePds",pno);
	}

}
