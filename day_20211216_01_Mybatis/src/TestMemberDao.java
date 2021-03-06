import java.util.List;

import member.vo.MemberVo;

public class TestMemberDao {

	public static void main(String[] args) {
//		test_insert();
//		test_printAll();
		test_count();
	}

	private static void test_count() {
		try {
			MemberDao dao = new MemberDao();
			int cnt = dao.count();
			System.out.println("회원수:"+cnt);
		} catch (Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}
	}

	private static void test_printAll() {
		try {
			MemberDao dao = new MemberDao();
			List<MemberVo> list = dao.selectAll();
			System.out.println("전체출력");
			for (MemberVo vo : list) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}
	}

	private static void test_insert() {
		MemberVo vo = new MemberVo(30,"홍30","010-300","30번유저","서울");
		try {
			MemberDao dao = new MemberDao();
			dao.insert(vo);
			System.out.println("등록성공");
		} catch (Exception e) {
			System.out.println("등록실패"+e.getMessage());
			e.printStackTrace();
		}
	}

}
