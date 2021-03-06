package day_20211215_01;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMemberMenu {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while(true) {
			printMainMenu();
			int menuNo = sc.nextInt();
			sc.nextLine();
			if(menuNo==-999)
				break;
			if(menuNo==1)
				memberMenu();
//			if(menuNo==2)
//				bookMenu();
		}//end while
		System.out.println("*** 프로그램 종료 ***");
		
	}

	private static void memberMenu() {
		while (true) {
			printMemberMenu();
			int menuNo = sc.nextInt();
			sc.nextLine();
			if(menuNo==-999)
				break;
			if(menuNo==1)
				memberAdd();
			else if(menuNo==2)
				memberFind();
			else if(menuNo==3)
				memberPrintAll();
		}
	}

	private static void memberPrintAll() {
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

	private static void memberFind() {
		while (true) {
			printMemberFindMenu();
			int menuNo = sc.nextInt();
			sc.nextLine();
			if(menuNo==-999)
				break;
			if(menuNo==1) {
				System.out.println("검색할 회원번호입력>> ");	
				String str = sc.nextLine();
				memberFindBy("no",str);
			}
			else if(menuNo==2) {
				System.out.println("검색할 회원이름입력>> ");	
				String str = sc.nextLine();
				memberFindBy("name",str);
			}
			else if(menuNo==3) {
				System.out.println("검색할 회원전화입력>> ");	
				String str = sc.nextLine();
				memberFindBy("tel",str);
			}
			else if(menuNo==4) {
				System.out.println("검색할 회원주소입력>> ");	
				String str = sc.nextLine();
				memberFindBy("addr",str);				
			}
			
		}
		
	}

	

	private static void memberFindBy(String colName, String str) {
		MemberDao memDao = new MemberDao();
		String value = "%"+str+"%";
		try {
			ArrayList<MemberVo> memList = memDao.findBy(colName,value);
			System.out.println("검색결과:"+memList.size());
			for (MemberVo vo : memList) {
				System.out.println(vo);
			}
			if(memList.size()==1) {
				memberUpdateMenu(memList.get(0));				
			}
		} catch (Exception e) {
			System.out.println("오류발생 "+e.getMessage());
		}
		
	}

	private static void memberUpdateMenu(MemberVo vo) {
		while (true) {
			printMemberUpdateMenu();
			int menuNo = sc.nextInt();
			sc.nextLine();
			if(menuNo==-999)
				break;
			if(menuNo==1) {
				memberUpdate(vo);
				break;
			}
			else if(menuNo==2) {
				memberDelete(vo);
				break;
			}
		}
	}


	private static void memberDelete(MemberVo vo) {
		while(true) {
			System.out.println("삭제하시겠습니까?(Y/N)>> ");	
			String delYN = sc.nextLine();
			if(delYN.equals("Y")) {
				try {
					MemberDao memDao = new MemberDao();
					int cnt = memDao.delete(vo.getNo());
					if(cnt == 0) {
						System.out.println("결과값없음");
					}else {
						System.out.println("삭제성공");
					}
				} catch (Exception e) {
					System.out.println("삭제오류 "+e.getMessage());
				}
				break;
			}else if(delYN.equals("N")) {
				break;
			}			
		}
	}

	private static void memberUpdate(MemberVo vo) {
		System.out.println("수정할 이름입력>> ");	
		String name = sc.nextLine();
		System.out.println("수정할 전화입력>> ");	
		String tel = sc.nextLine();
		System.out.println("수정할 소개입력>> ");	
		String intro = sc.nextLine();
		System.out.println("수정할 주소입력>> ");	
		String addr = sc.nextLine();
		try {
			MemberDao memDao = new MemberDao();
			if(vo==null) {
				return;
			}
			System.out.println("기존회원정보:"+vo);
			if(name.length()!=0)
				vo.setName(name);
			if(tel.length()!=0)
				vo.setTel(tel);
			if(intro.length()!=0)
				vo.setIntro(intro);
			if(addr.length()!=0)
				vo.setAddr(addr);
			memDao.update(vo);
			System.out.println("회원수정성공:"+vo);
		} catch (Exception e) {
			System.out.println("오류발생 "+e.getMessage());
		}
	}


	private static void printMemberUpdateMenu() {
		System.out.println("(1)회원수정 (2)회원삭제 (-999)이전메뉴");
		System.out.println("메뉴번호>> ");	
	}

	private static void printMemberFindMenu() {
		System.out.println("* 회원검색 *");
		System.out.println("(1)번호검색 (2)이름검색 (3)전화검색 (4)주소검색  (-999)이전메뉴");
		System.out.println("메뉴번호>> ");	
	}

	private static void memberAdd() {
		System.out.println("회원번호입력>>");
		int no = sc.nextInt();
		sc.nextLine();
		System.out.println("회원이름입력>>");
		String name = sc.nextLine();
		System.out.println("회원전화입력>>");
		String tel = sc.nextLine();
		System.out.println("회원소개입력>>");
		String intro = sc.nextLine();
		System.out.println("회원주소입력>>");
		String addr = sc.nextLine();
		MemberVo vo = new MemberVo(no,name,tel,intro,addr);
		memberInsert(vo);
	}
	
	

	private static void memberInsert(MemberVo vo) {
		MemberDao memDao = new MemberDao();
		try {
			memDao.insert(vo);
			System.out.println("등록완료");
		} catch (Exception e) {
			System.out.println("등록실패 "+e.getMessage());
		}
	}

	private static void printMemberMenu() {
		System.out.println("** 회원관리 **");
		printMemberCount();
		System.out.println("(1)회원등록 (2)회원검색 (3)회원전체출력 (-999)이전메뉴");
		System.out.println("메뉴번호>> ");
	}

	private static void printMemberCount() {
		try {
			MemberDao memDao = new MemberDao();
			int count = memDao.count();
			System.out.println("회원수 "+count);
		} catch (Exception e) {
			System.out.println("오류발생 "+e.getMessage());
		}
	}

	private static void printMainMenu() {
		System.out.println("*** 도서관 관리 프로그램 v0.3 ***");
		System.out.println("(1) 회원관리 (2) 도서관리 (-999)종료");
		System.out.println("메뉴번호>> ");	
	}
	
	

}
