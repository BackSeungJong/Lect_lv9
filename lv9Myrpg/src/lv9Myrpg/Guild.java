package lv9Myrpg;

import java.util.ArrayList;

//Guild 는 Unit이라는 아이템을 담는 인벤토리다!
//Guild
//ㄴ추가->판매하는 Unit들을 보여주고 ㄴ판매 ㄴ버리기

public class Guild {
	ArrayList<Unit> guildlist = new ArrayList<>();

	public void init() {
		// 파티원 생성
		for (int i = 0; i < 5; i++) {
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

	public void guildMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1. 파티관리");
			System.out.println("2. 길드원목록");
			System.out.println("0. 나가기");
			int sel = MainGame.sc.nextInt();

			if (sel == 1) {
				showmyParty();
			} else if (sel == 2) {
				showAllUnit();
			} else if (sel == 0) {
				break;
			}
		}
	}

	private void showmyParty() {
		// TODO Auto-generated method stub
		if (Player.myparty) {
			for (int i = 0; i < guildlist.size(); i++) {
				if (guildlist.get(i).party) {
					guildlist.get(i).showPartyInfo();
				}
			}
		} else {
			System.out.println("파티원이 존재하지 않습니다");
		}
	}

	public void showAllUnit() {
		System.out.println(MainGame.bar);
		for (int i = 0; i < guildlist.size(); i++) {
			guildlist.get(i).showUnitInfo();
			System.out.println();
		}
		System.out.println(MainGame.bar);
		// 두번째 메뉴 메서드
		makePartyMenu();

	}

	public void makePartyMenu() {
		while (true) {
			System.out.println("1. 파티영입");
			System.out.println("2. 새로고침");
			System.out.println("0. 나가기");
			int sel = MainGame.sc.nextInt();

			if (sel == 1) {
				
			} else if (sel == 2) {

			} else if (sel == 0) {
				break;
			}
		}
	}

}
