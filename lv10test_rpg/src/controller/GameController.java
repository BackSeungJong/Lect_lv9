package controller;

import java.util.Scanner;

import models.Player;

public class GameController {
	public static Scanner sc = new Scanner(System.in);
	public static Player player = new Player();

	private void init() {
		// TODO Auto-generated method stub
		System.out.println("------[Green RPG]------");
		System.out.print("[닉네임] ");
		String name = sc.next();
		player.setstatus(name, 100, 100, 10, 5);
		System.out.println();
	}

	public void start() {
		// TODO Auto-generated method stub
		init();
		while (true) {
			System.out.println("1. 던전입장");
			System.out.println("2. 내정보");
			System.out.println("3. 인벤토리");
			System.out.println("4. 파티");
			System.out.println("5. 길드");
			System.out.println("0. 종료");
			int sel = sc.nextInt();

			if (sel == 1) {

			} else if (sel == 2) {
				// player의 속성, 아이템, 파티정보 가져오기
				getinfo();
			} else if (sel == 3) {

			} else if (sel == 4) {

			} else if (sel == 5) {

			} else if (sel == 0) {
				break;
			}
		}
	}

	private void getinfo() {
		// 속성
		player.getstatus();
		// 아이템
		player.getequipment();
		// 파티
	}
}
