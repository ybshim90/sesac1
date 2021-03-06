package day_20211215_01;

import java.util.ArrayList;


public class TestBookDao {

public static void main(String[] args) {
		
		test_selectAll();
		test_insert();
		test_findByNo();
		test_count();
		test_delete();
		test_selectAll();
		test_find();
		test_update();
		test_selectAll();
		
	}

	private static void test_update() {
		try {
			BookDao bookDao = new BookDao();
			BookVo vo = bookDao.findByIsbn("1100");
			if(vo==null) {
				return;
			}
			System.out.println(vo);
			vo.setPublisher("수정한출판사1");
			vo.setPrice(35000);
			bookDao.update(vo);
		} catch (Exception e) {
			System.out.println("오류발생 "+e.getMessage());
		}
	}

	private static void test_find() {
		BookDao bookDao = new BookDao();
		try {
			ArrayList<BookVo> bookList = bookDao.findBy("title","%기본%");
			for (BookVo vo : bookList) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			System.out.println("오류발생 "+e.getMessage());
		}
		
		
	}

	private static void test_count() {
		try {
			BookDao bookDao = new BookDao();
			int count = bookDao.count();
			System.out.println("등록도서수 "+count);
		} catch (Exception e) {
			System.out.println("오류발생 "+e.getMessage());
		}
	}

	private static void test_delete() {
		try {
			BookDao bookDao = new BookDao();
			int cnt = bookDao.delete("1300");
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
			BookDao bookDao = new BookDao();
			BookVo vo = bookDao.findByIsbn("1300");
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
		BookDao bookDao = new BookDao();
		try {
			ArrayList<BookVo> bookList = bookDao.selectAll();
			System.out.println("전체출력");
			for (BookVo vo : bookList) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			System.out.println("전체출력오류 "+e.getMessage());
		}
	}

	private static void test_insert() {
		BookDao bookDao = new BookDao();
		BookVo vo = new BookVo("1300","C기본","한빛","최길동",40000);
		try {
			bookDao.insert(vo);
			System.out.println("등록완료");
		} catch (Exception e) {
			System.out.println("등록실패 "+e.getMessage());
		}
	}

}
