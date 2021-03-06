package day_20211215_mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMybatis {

	public static void main(String[] args) throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		
		try (SqlSession session = sqlSessionFactory.openSession(true)) {
			
			MemberVo vo = session.selectOne("member.selectMember", 1);
			System.out.println(vo);
			
			vo = new MemberVo(1, "홍2", "010-222", "홍2", "대전");
			session.selectOne("member.update2",vo);
			System.out.println("수정성공");
			
			vo = session.selectOne("member.selectMember", 1);
			System.out.println(vo);
		}
		
//		try (SqlSession session = sqlSessionFactory.openSession(true)) {
//			HashMap<String, String> m = new HashMap<String, String>();
//			m.put("colno", "no");
//			m.put("valno", "1");
//			m.put("coltel", "tel");
//			m.put("valtel", "010-333");
//			
//			session.selectOne("member.update",m);
//			System.out.println("수정성공");
//		}
		
//		try (SqlSession session = sqlSessionFactory.openSession()) {
//			HashMap<String, String> m = new HashMap<String, String>();
//			m.put("col", "tel");
////			m.put("col", "name");
////			m.put("col", "intro");
////			m.put("col", "addr");
//			m.put("val", "%112%)");
//			
//			List<MemberVo> memList  = session.selectList("member.find",m);
//			for (MemberVo vo : memList) {
//				System.out.println(vo);
//			}
//		}
		
//		try (SqlSession session = sqlSessionFactory.openSession()) {
//			List<MemberVo> memList  = session.selectList("member.findName","%홍%");
//			for (MemberVo vo : memList) {
//				System.out.println(vo);
//			}
//		}
		
//		try (SqlSession session = sqlSessionFactory.openSession()) {
//			List<MemberVo> memList  = session.selectList("member.selectAll");
//			for (MemberVo vo : memList) {
//				System.out.println(vo);
//			}
//		}
		
//		try (SqlSession session = sqlSessionFactory.openSession()) {
//		int cnt = session.selectOne("member.countAll");
//		System.out.println(cnt);
		
//		try (SqlSession session = sqlSessionFactory.openSession(true)) {//true->commit
//			int no = 20;
//			session.insert("member.delete",no);
//			System.out.println("삭제성공");
//		}
		
		
//		try (SqlSession session = sqlSessionFactory.openSession(true)) {//true->commit
//			MemberVo vo = new MemberVo(20,"최길동","010-221","유저","서울");
//			session.insert("member.insertMember",vo);
//			System.out.println("등록성공");
//		}
		
//		try (SqlSession session = sqlSessionFactory.openSession()) {
		
//			MemberVo vo = session.selectOne("member.selectMember", 1);
//			System.out.println(vo);
//		}
	}
}
