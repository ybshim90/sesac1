package day_20211213_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class testInsertJdbc {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		String username = "최길동";
		String tel = "010-114";
		String intro = "네'번째";
		String addr = "부산";
		String insertSql = "insert into member(no,name,tel,intro,addr)";
		insertSql += "values(?,?,?,?,?)";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(insertSql);
			stmt.setInt(1, 6);
			stmt.setString(2, username);
			stmt.setString(3, tel);
			stmt.setString(4, intro);
			stmt.setString(5, addr);
			
//			stmt.executeQuery();
//			stmt.executeUpdate();
			stmt.executeUpdate();
			System.out.println("등록성공");
			
		} catch (Exception e) {
			System.out.println("sql오류");
			e.printStackTrace();	
		
		} finally {
			JdbcUtil.close(stmt,conn);
		}
	}

}
