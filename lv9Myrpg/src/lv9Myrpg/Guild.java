package lv9Myrpg;

import java.util.ArrayList;

public class Guild {
	ArrayList<Unit> guildlist = new ArrayList<>();

	public void init() {
		// 파티원 생성
	}

	public void guildMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1. 파티생성");
			System.out.println("2. 파티원관리");
			System.out.println("0. 나가기");
			int sel = MainGame.sc.nextInt();

			if (sel == 1) {
				showAllUnit();
			} else if (sel == 2) {

			} else if (sel == 0) {
				break;
			}
		}
	}

	public void showAllUnit() {
		for (int i = 0; i < guildlist.size(); i++) {
			guildlist.get(i).showUnitInfo(i);
		}
	}

}
