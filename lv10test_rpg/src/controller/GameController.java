package controller;

import java.util.Random;
import java.util.Scanner;

import etc.Guild;
import etc.Item;
import models.Player;
import models.Unit;

public class GameController {
	public static Scanner sc = new Scanner(System.in);
	public static Random ran = new Random();
	public static Player player = new Player();
	public static Guild guild = new Guild();

	public GameController() {
		System.out.println("========[Green RPG]=========");
//		System.out.print("[닉네임] ");
//		String name = sc.next();
		player.setstatus("PLAYER", 100, 100, 10, 5);
		player.myinven.add(new Item(0, "나무칼", 0, 0, 3, 1));
		player.myinven.add(new Item(0, "쇠칼", 0, 0, 5, 2));
		player.myinven.add(new Item(1, "나무갑옷", 30, 0, 0, 3));
		player.myinven.add(new Item(1, "쇠갑옷", 50, 0, 0, 5));
		player.myinven.add(new Item(2, "반지", 20, 0, 2, 2));
		player.myinven.add(new Item(2, "목걸이", 0, 20, 2, 2));
		player.myparty.add(new Unit("파티원1", 100, 100, 5, 3));
		player.myparty.add(new Unit("파티원2", 100, 100, 5, 3));
		player.myparty.add(new Unit("파티원3", 100, 100, 5, 3));
		System.out.println("============================");
	}

	public void start() {
		// TODO Auto-generated method stub
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
				// 인벤토리 > 착용, 버리기
				player.getinven();
			} else if (sel == 4) {
				player.manageparty();
			} else if (sel == 5) {
				player.manageguild();
			} else if (sel == 0) {
				break;
			}
		}
	}

	private void getinfo() {
		// 속성
		System.out.println("[속성]");
		player.getstatus();
		// 아이템
		System.out.println("[아이템]");
		player.getequipment();
		// 파티
		System.out.println("[파티]");
		player.getparty();
	}
}
