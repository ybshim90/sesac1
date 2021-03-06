package day_20211214_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MemberDao {

	public void insert(MemberVo vo) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String insertSql = "insert into member(no,name,tel,intro,addr)";
		insertSql += "values(?,?,?,?,?)";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(insertSql);
			stmt.setInt(1, vo.getNo());
			stmt.setString(2, vo.getName());
			stmt.setString(3, vo.getTel());
			stmt.setString(4, vo.getIntro());
			stmt.setString(5, vo.getAddr());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();	
			throw new Exception(e);
		
		} finally {
			JdbcUtil.close(stmt,conn);
		}
	}

	public ArrayList<MemberVo> selectAll() throws Exception {
		ArrayList<MemberVo> memberArr = new ArrayList<MemberVo>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="select * from member order by no ";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String intro = rs.getString(4);
				String addr = rs.getString(5);
				vo.setNo(no);
				vo.setName(name);
				vo.setTel(tel);
				vo.setIntro(intro);
				vo.setAddr(addr);
				memberArr.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}
		return memberArr;
	}

	public MemberVo findByNo(int findno) throws Exception {
		MemberVo vo = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="select * from member ";
		sql += "where no = ?";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, findno);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVo();
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String intro = rs.getString(4);
				String addr = rs.getString(5);
				vo.setNo(no);
				vo.setName(name);
				vo.setTel(tel);
				vo.setIntro(intro);
				vo.setAddr(addr);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}
		return vo;
	}

	public int delete(int findno) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="delete from member ";
		sql += "where no = ?";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, findno);
			int cnt = stmt.executeUpdate();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}
	}

	public int count() throws Exception {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="select count(*) from member ";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}
		return cnt;				
	}

	public ArrayList<MemberVo> findBy(String colName, String value) throws Exception {
		ArrayList<MemberVo> memberArr = new ArrayList<MemberVo>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="select * from member where ";
		sql += colName+" like ?";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, value);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				MemberVo vo = new MemberVo();
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String intro = rs.getString(4);
				String addr = rs.getString(5);
				vo.setNo(no);
				vo.setName(name);
				vo.setTel(tel);
				vo.setIntro(intro);
				vo.setAddr(addr);
				memberArr.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}
		return memberArr;
	}

	public void update(MemberVo vo) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String insertSql = "update member set ";
		insertSql += "name = ?,		";
		insertSql += "intro = ?,	";
		insertSql += "tel = ?,		";
		insertSql += "addr = ?		";
		insertSql += "where no = ?	";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(insertSql);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getIntro());
			stmt.setString(3, vo.getTel());
			stmt.setString(4, vo.getAddr());
			stmt.setInt(5, vo.getNo());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
			throw new Exception(e);
		} finally {
			JdbcUtil.close(stmt,conn);
		}
	}
	
}
