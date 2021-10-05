package lv9Myrpg;

import java.util.Scanner;

class MainGame {
	public static Scanner sc = new Scanner(System.in);

	String bar = "-------------------------";

	// 메인게임돌리기
	public MainGame() {
		String mynicname = GameStart();
		Player player = new Player(mynicname);
		Inventory inven = new Inventory();
		Shop shop = new Shop();
		Dungeon dg = new Dungeon();

		boolean isRun = true;
		while (isRun) {
			player.mystatus();
			System.out.println(bar);
			System.out.println("1. 던전입장");
			System.out.println("2. 인벤토리");
			System.out.println("3. 상점");
			System.out.println("4. 길드");
			System.out.println("5. 저장");
			System.out.println("6. 로드");
			System.out.println("0. 종료");
			int sel = sc.nextInt();

			if (sel == 1) {
				dg.dungeonMenu();
			} else if (sel == 2) {
				inven.invenMenu();
			} else if (sel == 3) {
				shop.shopMenu();
			} else if (sel == 4) {
				player.guildMenu();
			} else if (sel == 5) {

			} else if (sel == 6) {

			} else if (sel == 0) {
				isRun = false;
			}
		}
	}

	public String GameStart() {
		System.out.println("<<MYRPG>>");
		System.out.println(bar);
		System.out.print("닉네임 : ");
		String nickname = sc.next();
		System.out.println(bar);
		return nickname;
	}

}

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainGame();
	}
}
