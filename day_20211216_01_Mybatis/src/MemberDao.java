import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.vo.MemberVo;

public class MemberDao {
	
	static SqlSessionFactory sqlSessionFactory = null;
	
	static { // main() 실행전에 실행됨
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	

	public void insert(MemberVo vo) throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			session.insert("member.insert", vo);
			System.out.println("저장성공");
		}
	}


	public List<MemberVo> selectAll() throws Exception {
		List<MemberVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			list = session.selectList("member.selectAll");
		}
		return list;
	}


	public int count() throws Exception {
		int cnt = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			cnt = session.selectOne("member.selectCnt");
		}
		return cnt;
	}

}
