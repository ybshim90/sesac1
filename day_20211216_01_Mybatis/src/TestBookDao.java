import java.util.List;

import book.vo.BookVo;

public class TestBookDao {

	public static void main(String[] args) {
		test_insert();
		test_selectAll();
		test_count();
	}

	private static void test_count() {
		try {
			BookDao dao = new BookDao();
			int cnt = dao.count();
			System.out.println("도서수:"+cnt);
		} catch (Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}
	}

	private static void test_selectAll() {
		try {
			BookDao dao = new BookDao();
			List<BookVo> list = dao.selectAll();
			System.out.println("전체출력");
			for (BookVo vo : list) {
				System.out.println(vo);
			}
		} catch (Exception e) {
			System.out.println("예외발생"+e.getMessage());
		}
	}

	private static void test_insert() {
		BookVo vo = new BookVo("2000","책제목2000","출판사2000","박길동",2000);
		try {
			BookDao dao = new BookDao();
			dao.insert(vo);
			System.out.println("등록성공");
		} catch (Exception e) {
			System.out.println("등록실패"+e.getMessage());
			e.printStackTrace();
		}
	}

}
