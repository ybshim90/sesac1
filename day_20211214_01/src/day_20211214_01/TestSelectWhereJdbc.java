package day_20211214_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelectWhereJdbc {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="select * from member ";
		sql += "where no = ?";
		int sqlno = 4;
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, sqlno);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String intro = rs.getString(4);
				String addr = rs.getString(5);
				System.out.println(no+","+name+","+tel+","+intro+","+addr);
			}else {
				System.out.println("결과값없음");
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
