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
			System.out.println("1. 길드원 출력");
			System.out.println("2. 길드원 추가");
			System.out.println("3. 길드원 삭제");
			System.out.println("0. 나가기");
			int sel = MainGame.sc.nextInt();

			if (sel == 1) {
				showAllUnit();
			} else if (sel == 2) {
				addUnit();
			} else if (sel == 3) {
				showAllUnit();
				deleteUnit();
			} else if (sel == 0) {
				break;
			}
		}
	}

	public void init() {
		// default 길드원 생성
		for (int i = 0; i < 10; i++) {
			guildlist.add(makeUnit());
		}

		// default 파티생성
//		int cnt = 0;
//		for (int i = 0; i < 4; i++) {
//			int idx = MainGame.ran.nextInt(guildlist.size());
//			if (!guildlist.get(idx).party) {
//				guildlist.get(idx).party = true;
//				Player.myparty[cnt] = true;
//				Player.myParty[cnt] = guildlist.get(idx);
//				cnt++;
//			} else {
//				i--;
//			}
//		}
		guildlist.get(0).party = true;
		Player.myparty[0] = true;
		Player.myParty[0] = guildlist.get(0);
		guildlist.get(2).party = true;
		Player.myparty[2] = true;
		Player.myParty[2] = guildlist.get(2);
		guildlist.get(3).party = true;
		Player.myparty[3] = true;
		Player.myParty[3] = guildlist.get(3);

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
		Unit tmp = new Unit(name, hp, A, D, S);

		return tmp;
	}

	// 1. 길드원 출력
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
	}

	// 2. 길드원 추가
	public void addUnit() {
		for (int i = 0; i < 5; i++) {
			guildlist.add(makeUnit());
		}
		System.out.println("추가완료");
	}

	// 3. 길드원 삭제
	private void deleteUnit() {
		// TODO Auto-generated method stub
		System.out.print("선택 : ");
		int idx = MainGame.sc.nextInt() - 1;

		if (guildlist.get(idx).party) {
			System.out.println("파티에 가입된 길드원입니다.");
			System.out.println("파티강퇴후 삭제 가능합니다.");
			System.out.println();
		} else {
			boolean check = true;
			for (int i = 0; i < guildlist.get(idx).unititem.length; i++) {
				if (guildlist.get(idx).unititem[i]) {
					check = false;
				}
			}

			if (check) {
				guildlist.remove(idx);
				System.out.println("삭제완료\n");
			} else {
				System.out.println("아이템을 장착한 길드원 입니다.");
				System.out.println("아이템을 모두 해제하고 삭제하시겠습니까?");
				System.out.println("1) 네 2) 아니오");
				int sel = MainGame.sc.nextInt();

				if (sel == 1) {
					guildlist.get(idx).undressedAllUnitItem();
					guildlist.remove(idx);
					System.out.println("삭제완료\n");
				}
			}
		}
	}

	// 파티관리
//	private void manageParty() {
//		// TODO Auto-generated method stub
//		while (true) {
//			showmyParty();
//			System.out.println("1. 장비장착");
//			System.out.println("2. 장비해제");
//			System.out.println("3. 파티퇴출");
//			System.out.println("0. 나가기");
//			int sel = MainGame.sc.nextInt();
//
//			if (sel == 1) {
//				for (int i = 0; i < Player.inven.inven.size(); i++) {
//					Player.inven.inven.get(i).showItemAbillty(i);
//					System.out.println();
//				}
//				System.out.print("선택 : ");
//				sel = MainGame.sc.nextInt() - 1;
//
//				if (sel >= 0 && sel < Player.inven.inven.size()) {
//					Player.myParty.equipUnitItem(Player.inven.inven.get(sel));
//				}
//
//			} else if (sel == 2) {
//				Player.myParty.undressedHub();
//			} else if (sel == 3) {
//				Player.myParty.throwoutGate();
//			} else if (sel == 0) {
//				break;
//			}
//
//		}
//	}

//	// 파티선택
//	private void selectParty() {
//		// TODO Auto-generated method stub
//		System.out.print("선택 : ");
//		int index = MainGame.sc.nextInt() - 1;//길드원 선택했음
//		
//		if (index >= 0 && index < guildlist.size()) {
//			for(int i=0;i<Player.my)
//
//			guildlist.get(index).party = true;
//			if (!Player.myparty) {
//				Player.myparty = true;
//				Player.myParty = guildlist.get(index);
//			} else {
//				Player.myParty.undressedAllUnitItem();
//				Player.myParty.party = false;
//				Player.myParty = guildlist.get(index);
//
//			}
//
//			System.out.println("파티생성완료");
//			System.out.println(MainGame.bar);
//		}
//	}

	//
	private void showmyParty() {
		// TODO Auto-generated method stub
		for (int i = 0; i < Player.myparty.length; i++) {
			if (Player.myparty[i]) {
				guildlist.get(i).showPartyAllInfo();
			} else {
				System.out.println("파티원이 존재하지 않습니다");
				System.out.println();
			}

		}
	}
}
