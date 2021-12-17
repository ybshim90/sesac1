import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import member.vo.MemberVo;

public class TestMybatis {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			MemberVo vo = new MemberVo(30,"홍30","010-300","30번유저","서울");
			session.insert("member.insert", vo);
			System.out.println("저장성공");
		}
	}

}
