package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
	String driver = "com.mysql.jdbc.Driver";
	String username = System.getenv("ACCESSKEY");
	String password = System.getenv("SECRETKEY");
	String dbName = System.getenv("MYSQL_DB");
	String host = System.getenv("MYSQL_HOST");
	String port = System.getenv("MYSQL_PORT");
	//String dbUrl = "jdbc:mysql://"+host+":"+port + "/" +dbName;
	
//	String driver = "com.mysql.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/BookDB";
//	// MySQL用户名
//	String user = "root";
//	// MySQL密码
//	String password = "123";
	
	public Connection getConnection() {
		String dbUrl = String.format("jdbc:mysql://%s:%s/%s", System.getenv("MYSQL_HOST"), System.getenv("MYSQL_PORT"), System.getenv("MYSQL_DB"));
		try {
		// 连续数据库
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dbUrl,username,password);
		if (!conn.isClosed())
			return conn;
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}