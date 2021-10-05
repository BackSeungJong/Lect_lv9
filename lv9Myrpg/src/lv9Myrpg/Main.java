package lv9Myrpg;

import java.util.Scanner;

class MainGame {
	public static Scanner sc = new Scanner(System.in);

	String bar = "---------------";

	// 메인게임돌리기
	public MainGame() {
		String mynicname = GameStart();
		Player player = new Player(mynicname);
	}

	public String GameStart() {
		System.out.println("<<MYRPG>>");
		System.out.println(bar);
		System.out.print("[1] 캐릭터 생성");
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
