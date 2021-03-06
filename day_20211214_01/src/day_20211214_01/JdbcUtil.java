package day_20211214_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("로딩성공");
		String url = "jdbc:mysql://127.0.0.1/db1";
		String username = "user1";
		String pass = "1234";
		Connection conn = DriverManager.getConnection(url, username, pass);
		
		return conn;
	}

	public static void close(Statement stmt, Connection conn) {
		try {
			if(stmt != null) stmt.close();
		} catch (SQLException e) {
		}
		try {
			if(conn != null) conn.close();
		} catch (SQLException e) {
		}			
	}
	
}
