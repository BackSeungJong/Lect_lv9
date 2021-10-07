package lv9Myrpg;

import java.util.ArrayList;

//Guild 는 Unit이라는 아이템을 담는 인벤토리다!
//Guild
//ㄴ추가->판매하는 Unit들을 보여주고 ㄴ판매 ㄴ버리기

public class Guild {
	ArrayList<Unit> guildlist = new ArrayList<>();

	public void guildMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1. 파티관리");
			System.out.println("2. 파티원영입");
			System.out.println("0. 나가기");
			int sel = MainGame.sc.nextInt();

			if (sel == 1) {
				manageParty();
			} else if (sel == 2) {
				showAllUnit();
			} else if (sel == 0) {
				break;
			}
		}
	}

	public void init() {
		// 파티원 생성
		for (int i = 0; i < 10; i++) {
			guildlist.add(makeUnit());
		}

	}

	public Unit makeUnit() {
		String[] n1 = { "박", "이", "김", "최", "유", "지", "오" };
		String[] n2 = { "명", "기", "종", "민", "재", "석", "광" };
		String[] n3 = { "수", "자", "민", "수", "석", "민", "철" };

		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int A = ran + 1;
		int D = ran / 2 + 1;
		int S = MainGame.ran.nextInt(2) + 1;
		int price = MainGame.ran.nextInt(6001) + 3000;
		Unit tmp = new Unit(name, hp, A, D, S, price);

		return tmp;
	}

	private boolean showmyParty() {
		// TODO Auto-generated method stub
		if (Player.myparty) {
			for (int i = 0; i < guildlist.size(); i++) {
				if (guildlist.get(i).party) {
					guildlist.get(i).showPartyInfo();
				}
			}
			return true;
		} else {
			System.out.println("파티원이 존재하지 않습니다");
			System.out.println();
			return false;
		}
	}

	public void showAllUnit() {
		System.out.println(MainGame.bar);
		for (int i = 0; i < guildlist.size(); i++) {
			System.out.printf("[%d] ", i + 1);
			guildlist.get(i).showUnitInfo();
			if (i != guildlist.size() - 1) {
				System.out.println();
			}
		}
		System.out.println(MainGame.bar);
		// 두번째 메뉴 메서드
		selectParty();

	}

//파티관리
	private void manageParty() {
		// TODO Auto-generated method stub
		while (showmyParty()) {
			System.out.println("1. 장비장착");
			System.out.println("2. 장비해제");
			System.out.println("3. 파티퇴출");
			System.out.println("0. 나가기");
			int sel = MainGame.sc.nextInt();

			if (sel == 1) {
				for (int i = 0; i < Player.inven.inven.size(); i++) {
					Player.inven.inven.get(i).showItemAbillty(i);
					System.out.println();
				}
				System.out.print("선택 : ");
				sel = MainGame.sc.nextInt() - 1;

				if (sel >= 0 && sel < Player.inven.inven.size()) {
					Player.myParty.equipUnitItem(Player.inven.inven.get(sel));
				}

			} else if (sel == 2) {
				Player.myParty.undressedHub();
			} else if (sel == 3) {
				Player.myParty.throwoutGate();
			} else if (sel == 0) {
				break;
			}

		}
	}

	// 파티선택
	private void selectParty() {
		// TODO Auto-generated method stub
		System.out.print("선택 : ");
		int index = MainGame.sc.nextInt() - 1;

		if (index >= 0 && index < guildlist.size()) {
			guildlist.get(index).party = true;
			if (!Player.myparty) {
				Player.myparty = true;
				Player.myParty = guildlist.get(index);
			} else {
				Player.myParty.undressedAllUnitItem();
				Player.myParty.party = false;
				Player.myParty = guildlist.get(index);

			}

			System.out.println("파티생성완료");
			System.out.println(MainGame.bar);
		}
	}

}
