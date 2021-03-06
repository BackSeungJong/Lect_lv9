package lv9Myrpg;

import java.util.Random;
import java.util.Scanner;

class MainGame {
	public static Scanner sc = new Scanner(System.in);
	public static Random ran = new Random();
	static String bar = "-------------------------";

	// 메인게임돌리기
	public MainGame() {

		// String mynicname = GameStart();
		// Player player = new Player(mynicname);

		Shop shop = new Shop();
		Dungeon dg = new Dungeon();

		Player.inven.init();// 인벤토리에 아이템세팅
		shop.init();// 상점아이템세팅
		Player.guild.init();// 길드세팅
		dg.init();// 몬스터세팅

		boolean isRun = true;
		while (isRun) {
			Player.instance.mystatus();
			System.out.println(bar);
			System.out.println("1. 던전입장");
			System.out.println("2. 인벤토리");
			System.out.println("3. 상점");
			System.out.println("4. 길드");
			System.out.println("5. 파티");
			System.out.println("6. 내 상태");
			System.out.println("7. 저장");
			System.out.println("8. 로드");
			System.out.println("0. 종료");
			int sel = sc.nextInt();
			System.out.println(bar);

			if (sel == 1) {
				dg.dungeonMenu();
			} else if (sel == 2) {
				Player.inven.invenMenu();
			} else if (sel == 3) {
				shop.shopMenu();
			} else if (sel == 4) {
				Player.guild.guildMenu();
			} else if (sel == 5) {
				Player.partyMenu();
			} else if (sel == 6) {
				Player.instance.showMyAllState();
			} else if (sel == 7) {

			} else if (sel == 8) {

			} else if (sel == 0) {
				isRun = false;
			}
			System.out.println();
			// 정렬메소드
			Player.inven.sort();
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
