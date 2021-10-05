package controller;

import java.util.Scanner;

public class Shop {
	public static Scanner sc = new Scanner(System.in);

	UserManager um = new UserManager();
	ItemManager im = new ItemManager();

	private static int Log = -1; // 로그인
	public static String bar = "---------------------\n";

	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			initialmenu();
			System.out.print("menu : ");
			String input = sc.next();

			try {
				int sel = Integer.parseInt(input);

				if (sel == 1) {
					System.out.print("ID : ");
					String id = sc.next();
					um.join(id);
				} else if (sel == 2) {
					System.out.print("ID : ");
					String id = sc.next();
					um.withdraw(id);
					im.deletecart(id);
				} else if (sel == 3) {
					if (login()) {
						loginMenu();
					}
				} else if (sel == 4) {
					ManagerMode();
				} else if (sel == 5) {
					um.printUserData();
					im.printallcategory();
					im.printallitem();
					im.printallcart();
				} else if (sel == 0) {
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("[시스템] 잘 못 입력했습니다.\n");
			}
		}
	}

	private void ManagerMode() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1. 카테고리관리");// im
			System.out.println("2. 아이템관리");// im
			System.out.println("0. 종료");// um
			int sel = sc.nextInt();
			if (sel == 1) {
				im.printallcategory();
				System.out.print(bar);
				System.out.println("1. 추가");
				System.out.println("2. 삭제");
				sel = sc.nextInt();

				if (sel == 1) {
					System.out.print("카테고리이름 : ");
					String name = sc.next();
					im.cateAdd(name);
				} else if (sel == 2) {
					System.out.print("카테고리이름 : ");
					String name = sc.next();
					im.cateDelete(name);
				}

			} else if (sel == 2) {
				im.printallitem();
				System.out.print(bar);
				System.out.println("1. 추가");
				System.out.println("2. 삭제");
				sel = sc.nextInt();
				if (sel == 1) {
					im.itemAdd();
				} else if (sel == 2) {
					im.itemDelete();
				}

			}
//			else if (sel == 3) {
//				System.out.println("1. 추가");
//				System.out.println("2. 삭제");
//				sel = sc.nextInt();
//				if (sel == 1) {
//
//				} else if (sel == 2) {
//
//				}
//
//			}
			else if (sel == 0) {
				break;
			}
		}
	}

	private void loginMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1. 쇼핑");
			System.out.println("2. 장바구니");
			System.out.println("0. 로그아웃");
			String input = sc.next();

			try {
				int sel = Integer.parseInt(input);

				if (sel == 1) {
					shopping();
				} else if (sel == 2) {
					cart();
				} else if (sel == 0) {
					Log = -1;
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("[시스템] 잘 못 입력했습니다.\n");
			}
		}
	}

	private void cart() {
		// TODO Auto-generated method stub
		while (true) {
			im.printcart(um.user.get(Log).getId());
			System.out.println("[1] 구매");
			System.out.println("[2] 삭제");
			System.out.println("[0] 뒤로가기");
			int sel = Shop.sc.nextInt();

			if (sel == 1) {
				System.out.printf("총금액 : %d원\n", um.user.get(Log).getmoney());
				// im.buyitem(um.user.get(Log).getId());
				break;
			} else if (sel == 2) {
				System.out.print("번호 : ");
				int num = Shop.sc.nextInt();
				// int index = im.deleteitem(um.user.get(Log).getId(), num);
				um.user.get(Log).setmoney(um.user.get(Log).getmoney() - im.deleteitem(um.user.get(Log).getId(), num));
			} else if (sel == 0) {
				break;
			}

		}
	}

	private void shopping() {
		// TODO Auto-generated method stub
		while (true) {
			im.printcategory();
			System.out.print("선택 : ");
			int caID = sc.nextInt() - 1;

			if (caID == -1) {
				break;
			}
			im.printitem(caID);
			System.out.print("담기 : ");
			int itID = sc.nextInt();
			int money = im.addCart(um.user.get(Log).getId(), caID, itID);
			um.user.get(Log).setmoney(um.user.get(Log).getmoney() + money);
		}
	}

	private boolean login() {
		// TODO Auto-generated method stub
		System.out.print("ID : ");
		String id = sc.next();

		if (um.findLog(id) != -1) {
			Log = um.findLog(id);
			System.out.printf("\n[시스템] %s님 환영합니다.\n", um.user.get(Log).getId());
			return true;
		}
		System.out.println("[시스템] 아이디가 존재하지 않습니다.\n");
		return false;
	}

	private void initialmenu() {
		// TODO Auto-generated method stub
		System.out.println("<<<백신사>>>");
		//사용자정보보여주자
		um.printUserData();
		System.out.println(bar + "1. 가입");
		System.out.println("2. 탈퇴");
		System.out.println("3. 로그인");
		System.out.println("4. 관리자모드");
		System.out.print("0. 종료\n" + bar);
	}
}
