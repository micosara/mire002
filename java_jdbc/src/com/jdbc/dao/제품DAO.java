package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.datasource.DataSource;
import com.jdbc.dto.제품VO;

public class 제품DAO implements DAO<제품VO>{

	private DataSource dataSource = DataSource.getInstance();
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<제품VO> selectList()throws Exception {
		Connection conn = dataSource.getConncetion();
		Statement stmt = conn.createStatement();
		
		// 제품
		String sql = "select * from 제품";
		ResultSet rs = stmt.executeQuery(sql);
		
		List<제품VO> 제품리스트 = new ArrayList<제품VO>();
		while(rs.next()) {
			제품VO 제품 = new 제품VO();
			
			제품.set단가(rs.getInt("단가"));
			제품.set재고량(rs.getInt("재고량"));
			제품.set제조업체(rs.getString("제조업체"));
			제품.set제품명(rs.getString("제조업체"));
			제품.set제품번호(rs.getString("제품번호"));
			
			제품리스트.add(제품);
		}
		
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
		
		return 제품리스트;
	}

	@Override
	public 제품VO selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(제품VO e)throws Exception {
		Connection conn = dataSource.getConncetion();
		
		String sql = "insert into 제품(제품번호,제품명,재고량,단가,제조업체) "
				     +"values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, e.get제품번호());
		pstmt.setString(2, e.get제품명());
		pstmt.setInt(3, e.get재고량());
		pstmt.setInt(4, e.get단가());
		pstmt.setString(5, e.get제조업체());

		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		
	}

	@Override
	public void update(제품VO e)throws Exception {
		Connection conn = dataSource.getConncetion();
		
		String sql = "update 제품 set "
					+ "제품명=?,재고량=?,단가=?,제조업체=? "
					+ "where 제품번호=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, e.get제품명());
		pstmt.setInt(2, e.get재고량());
		pstmt.setInt(3, e.get단가());
		pstmt.setString(4, e.get제조업체());
		pstmt.setString(5, e.get제품번호());

		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}

	@Override
	public void delete(String id)throws Exception {
		Connection conn = dataSource.getConncetion();
		String sql = "delete from 제품 where 제품번호='"+id+"'";
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate(sql);
		
		if(stmt!=null) stmt.close();
		if(conn!=null)conn.close();
		
	}

}
