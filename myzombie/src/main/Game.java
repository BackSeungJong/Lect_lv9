package main;

import java.util.ArrayList;
import java.util.Scanner;

import unit.Hero;
import unit.Unit;
import unit.Zombie;
import unit.ZombieKing;

public class Game {
	Scanner sc = new Scanner(System.in);
	// Singleton
	private static Game instance = new Game();

	private Game() {
	}

	public static Game getInstance() {
		return instance;
	}

	// 유닛(히어로, 좀비, 좀비킹)
	private Hero Player;
	private ArrayList<Unit> enemy = new ArrayList<>();

	private void init() {
		Player = new Hero("PLAYER", 100, 5, 1, 1, 5);
		enemy.add(new Zombie("그냥좀비", 25, 5, 1, 3, 5));
		enemy.add(new Zombie("힘쌘좀비", 45, 10, 2, 6, 10));
		enemy.add(new Zombie("정예좀비", 65, 15, 3, 9, 15));
		enemy.add(new ZombieKing("좀비왕", 100, 20, 4, 12, 20, 50));
	}

	private void run() {
		init();
		while (true) {
			System.out.println("[1] 올라간다");
			System.out.println("[2] 체력회복");
			System.out.println("[3] 무기강화");
			int sel = sc.nextInt();

			if (sel == 1) {
				Player.setpos(Player.getpos() + 1);
				int check = check();
				if (check != -1) {
					if (!fight(enemy.get(check))) {
						break;
					}
				}
			} else if (sel == 2) {

			} else if (sel == 3) {

			}

		}
	}

	private int check() {
		for (int i = 0; i < enemy.size(); i++) {
			if (Player.getpos() == enemy.get(i).getpos()) {
				System.out.println("좀비와 마주쳤다");
				return i;
			}
		}
		return -1;
	}

	private boolean fight(Unit unit) {
//		while (true) {
//
//		}
		return false;
	}
}
