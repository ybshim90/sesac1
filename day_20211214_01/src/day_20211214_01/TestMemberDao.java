package day_20211214_01;

import java.util.ArrayList;

public class TestMemberDao {

	public static void main(String[] args) {
		
//		test_insert();
//		test_selectAll();
//		test_findByNo();
//		test_delete();
//		test_count();
//		test_find();
		test_selectAll();
		test_update();
		test_selectAll();
		
	}

	private static void test_update() {
		try {
			MemberDao memDao = new MemberDao();
			MemberVo vo = memDao.findByNo(5);
			if(vo==null) {
				return;
			}
			System.out.println(vo);
			vo.setTel("010-332");
			vo.setIntro("수정된정보");
			memDao.update(vo);
		} catch (Exception e) {
			System.out.println("오류발생 "+e.getMessage());
		}
	}

	private static void test_find() {
		MemberDao memDao = new MemberDao();
		try {
			ArrayList<MemberVo> memList = memDao.findBy("tel","%112%");
			for (MemberVo vo : memList) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			System.out.println("오류발생 "+e.getMessage());
		}
		
		
	}

	private static void test_count() {
		try {
			MemberDao memDao = new MemberDao();
			int count = memDao.count();
			System.out.println("회원수 "+count);
		} catch (Exception e) {
			System.out.println("오류발생 "+e.getMessage());
		}
	}

	private static void test_delete() {
		try {
			MemberDao memDao = new MemberDao();
			int cnt = memDao.delete(4);
			if(cnt == 0) {
				System.out.println("결과값없음");
			}else {
				System.out.println("삭제성공");
			}
		} catch (Exception e) {
			System.out.println("삭제오류 "+e.getMessage());
		}
		
	}

	private static void test_findByNo() {
		try {
			MemberDao memDao = new MemberDao();
			MemberVo vo = memDao.findByNo(4);
			if(vo==null) {
				System.out.println("결과값없음");
			}else {
				System.out.println(vo);
			}
		} catch (Exception e) {
			System.out.println("검색오류 "+e.getMessage());
		}
	}

	private static void test_selectAll() {
		MemberDao memDao = new MemberDao();
		try {
			ArrayList<MemberVo> memList = memDao.selectAll();
			for (MemberVo vo : memList) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			System.out.println("전체출력오류 "+e.getMessage());
		}
	}

	private static void test_insert() {
		MemberDao memDao = new MemberDao();
		MemberVo vo = new MemberVo(5,"홍길동2","010-211","새로운 홍길동","서울 강남");
		try {
			memDao.insert(vo);
			System.out.println("등록완료");
		} catch (Exception e) {
			System.out.println("등록실패 "+e.getMessage());
		}
	}
}
