package com.sist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProvider {
	public static Connection getConnection() {
		Connection conn =null;
		try {
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			String user="c##bfour";
			String password="bfour";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return conn;
	}
	public static void close(Connection conn,Statement stmt) {
		try {
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void close(Connection conn,Statement stmt, ResultSet rs) {
		try {
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
