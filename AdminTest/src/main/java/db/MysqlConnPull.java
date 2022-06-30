package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MysqlConnPull {
	public Connection conn;
	public PreparedStatement psmt;
	public Statement stmt;
	public ResultSet rs;
	
	public MysqlConnPull () {
		try {
			Context context = new InitialContext();
			Context envContext = (Context)context.lookup("java:comp/env");
			DataSource dataSource = (DataSource)envContext.lookup("jdbc/Myproject");
			conn = dataSource.getConnection();
			
			System.out.println("DB연결성공!");
		}
		catch (Exception e) {
			System.out.println("DB연결실패");
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(rs != null) rs.close();
			if(conn != null) conn.close();
			
			System.out.println("DB자원 반납");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
