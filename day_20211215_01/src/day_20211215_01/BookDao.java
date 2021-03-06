package day_20211215_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDao {
	public void insert(BookVo vo) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String insertSql = "insert into book(isbn,title,publisher,author,price)";
		insertSql += "values(?,?,?,?,?)";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(insertSql);
			stmt.setString(1, vo.getIsbn());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getPublisher());
			stmt.setString(4, vo.getAuthor());
			stmt.setInt(5, vo.getPrice());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();	
			throw new Exception(e);
		
		} finally {
			JdbcUtil.close(stmt,conn);
		}
	}

	public ArrayList<BookVo> selectAll() throws Exception {
		ArrayList<BookVo> bookArr = new ArrayList<BookVo>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="select * from book order by isbn ";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BookVo vo = new BookVo();
				String isbn = rs.getString(1);
				String title = rs.getString(2);
				String publisher = rs.getString(3);
				String author = rs.getString(4);
				int price = rs.getInt(5);
				vo.setIsbn(isbn);
				vo.setTitle(title);
				vo.setPublisher(publisher);
				vo.setAuthor(author);
				vo.setPrice(price);
				bookArr.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}
		return bookArr;
	}

	public BookVo findByIsbn(String findisbn) throws Exception {
		BookVo vo = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="select * from book ";
		sql += "where isbn = ?";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, findisbn);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				vo = new BookVo();
				String isbn = rs.getString(1);
				String title = rs.getString(2);
				String publisher = rs.getString(3);
				String author = rs.getString(4);
				int price = rs.getInt(5);
				vo.setIsbn(isbn);
				vo.setTitle(title);
				vo.setPublisher(publisher);
				vo.setAuthor(author);
				vo.setPrice(price);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}
		return vo;
	}

	public int delete(String findisbn) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="delete from book ";
		sql += "where isbn = ?";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, findisbn);
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
		String sql="select count(*) from book ";
		
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

	public ArrayList<BookVo> findBy(String colName, String value) throws Exception {
		ArrayList<BookVo> bookArr = new ArrayList<BookVo>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql="select * from book where ";
		sql += colName+" like ?";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, value);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BookVo vo = new BookVo();
				String isbn = rs.getString(1);
				String title = rs.getString(2);
				String publisher = rs.getString(3);
				String author = rs.getString(4);
				int price = rs.getInt(5);
				vo.setIsbn(isbn);
				vo.setTitle(title);
				vo.setPublisher(publisher);
				vo.setAuthor(author);
				vo.setPrice(price);
				bookArr.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			JdbcUtil.close(stmt, conn);
		}
		return bookArr;
	}

	public void update(BookVo vo) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		String insertSql = "update book set ";
		insertSql += "title = ?,		";
		insertSql += "publisher = ?,	";
		insertSql += "author = ?,		";
		insertSql += "price = ?			";
		insertSql += "where isbn = ?	";
		
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(insertSql);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getPublisher());
			stmt.setString(3, vo.getAuthor());
			stmt.setInt(4, vo.getPrice());
			stmt.setString(5, vo.getIsbn());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();	
			throw new Exception(e);
		} finally {
			JdbcUtil.close(stmt,conn);
		}
	}
}
