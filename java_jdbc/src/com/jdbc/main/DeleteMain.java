package com.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteMain {

	public static void main(String[] args) throws Exception{
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String username = "mire001";
		String password = "mire001";
		
		// 1. driver loading
		Class.forName(driverName);
		// 2. connection
		Connection conn = DriverManager.getConnection(url,username,password);

		String sql = "delete from 고객 where 고객아이디='mama'";
		Statement stmt = conn.createStatement();
		
		stmt.executeUpdate(sql);
		
		if(stmt!=null) stmt.close();
		if(conn!=null) conn.close();
		
	}

}
