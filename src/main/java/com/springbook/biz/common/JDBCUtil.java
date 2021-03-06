package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.PreparedStatement;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/study","root","1234");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;   
	}
	
	public static void close(PreparedStatement stmt, Connection conn) {
		if(stmt!=null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt=null;
			}
		}
		
		if(conn!=null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
	}
	
	public static void close(ResultSet rs,PreparedStatement stmt, Connection conn) {
		if(stmt!=null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt=null;
			}
		}
		
		if(conn!=null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
		
		if(rs!=null) {
			try {
				if(!rs.isClosed()) rs.close();
			} catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs=null;
			}
		}
	}
}
