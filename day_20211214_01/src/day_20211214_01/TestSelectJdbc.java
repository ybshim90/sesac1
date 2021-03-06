package day_20211214_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelectJdbc {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="select count(*) from member";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int cnt = rs.getInt(1);
				System.out.println(cnt);
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 파일 없음");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql 처리 문제");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt, conn);
		}
		
	}

}
