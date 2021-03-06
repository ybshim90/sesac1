import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import book.vo.BookVo;

public class BookDao {
	
	static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public void insert(BookVo vo) throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			session.insert("book.insert", vo);
		}
	}

	public List<BookVo> selectAll() throws Exception {
		List<BookVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			list = session.selectList("book.selectAll");
		}
		return list;
	}

	public int count() {
		int cnt = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			cnt = session.selectOne("book.selectCnt");
		}
		return cnt;
	}

}
