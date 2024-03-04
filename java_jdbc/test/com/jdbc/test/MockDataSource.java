package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;

import com.jdbc.datasource.DataSource;

public class MockDataSource extends DataSource{
	private static MockDataSource instance = new MockDataSource();
	public static MockDataSource getInstance() {
		return instance;
	}


	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private String username = "mire001";
	private String password = "mire001";
	
	public Connection getConncetion() throws Exception{
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	
}
