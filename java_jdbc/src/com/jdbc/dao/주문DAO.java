package com.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.datasource.DataSource;
import com.jdbc.dto.주문VO;

public class 주문DAO implements DAO<주문VO>{

	private DataSource dataSource = DataSource.getInstance();
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<주문VO> selectList()throws Exception {
		Connection conn = dataSource.getConncetion();
		Statement stmt = conn.createStatement();
		
		String sql = "select * from 주문";
		ResultSet rs = stmt.executeQuery(sql);
		
		List<주문VO> 주문리스트 =new ArrayList<주문VO>();
		while(rs.next()) {
			주문VO 주문 = new 주문VO();
			
			주문.set배송지(rs.getString("배송지"));
			주문.set수량(rs.getInt("수량"));
			주문.set주문고객(rs.getString("주문고객"));
			주문.set주문번호(rs.getString("주문번호"));
			주문.set주문일자(rs.getDate("주문일자"));
			주문.set주문제품(rs.getString("주문제품"));
			
			주문리스트.add(주문);
		}
		
		if(stmt!=null)stmt.close();
		if(conn!=null)conn.close();
		
		return 주문리스트;
	}

	@Override
	public 주문VO selectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(주문VO e)throws Exception {
		Connection conn = dataSource.getConncetion();
		
		String sql = "insert into 주문(주문번호,주문고객,주문제품,수량,배송지,주문일자) "
				     +"values(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, e.get주문번호());
		pstmt.setString(2, e.get주문고객());
		pstmt.setString(3,e.get주문제품());
		pstmt.setInt(4, e.get수량());
		pstmt.setString(5,e.get배송지());
		pstmt.setDate(6, new Date(e.get주문일자().getTime()));
		
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
		
	}

	@Override
	public void update(주문VO e) throws Exception{
		Connection conn = dataSource.getConncetion();
		
		String sql = "update 주문 set "
					+ "주문고객=?,주문제품=?,수량=?,배송지=?,주문일자=? "
				     +"where 주문번호=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, e.get주문고객());
		pstmt.setString(2,e.get주문제품());
		pstmt.setInt(3, e.get수량());
		pstmt.setString(4,e.get배송지());
		pstmt.setDate(5, new Date(e.get주문일자().getTime()));
		pstmt.setString(6, e.get주문번호());
		
		pstmt.executeUpdate();
		
		if(pstmt!=null)pstmt.close();
		if(conn!=null)conn.close();
	}

	@Override
	public void delete(String id)throws Exception {
		Connection conn = dataSource.getConncetion();
		String sql = "delete from 주문 where 주문번호='"+id+"'";
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate(sql);
		
		if(stmt!=null) stmt.close();
		if(conn!=null)conn.close();
		
	}

}
