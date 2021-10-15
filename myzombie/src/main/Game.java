package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import unit.Hero;
import unit.Unit;
import unit.Zombie;
import unit.ZombieKing;

public class Game {
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
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

	public void run() {
		init();
		int act = 1;
		while (true) {
			map(act);
			int sel = sc.nextInt();

			// 오르기
			if (sel == 1) {
				System.out.println("뚜벅 뚜벅...");
				Player.setpos(Player.getpos() + 1);
				int check = check();
				if (check != -1) {
					if (fight(enemy.get(check)) == false) {
						break;
					}
				} else {
					System.out.println("아무일도 일어나지 않았다.\n");
				}
				act = 1;
			}
			// 체력회복
			else if (sel == 2 && act == 1) {
				int rnum = ran.nextInt(40) + 20;
				Player.sethp(Player.gethp() + rnum);
				System.out.println("체력을 " + rnum + "만큼 회복했다!");
				act = 2;
			}
			// 무기강화
			else if (sel == 3 && act == 1) {
				int rnum = ran.nextInt(2) + 1;
				if (rnum == 1) {
					rnum = ran.nextInt(3) + 1;
					Player.setatt(Player.getatt() + rnum);
					System.out.println("공격력이 " + rnum + "만큼 증가했다!");
				} else if (rnum == 2) {
					rnum = ran.nextInt(3) + 1;
					Player.setdef(Player.getdef() + rnum);
					System.out.println("방어력이 " + rnum + "만큼 증가했다!");
				}
				act = 2;
			}

		}
	}

	private void map(int act) {
		System.out.printf("[ 현재 층 : %d]\n", Player.getpos());
		System.out.println("[1] 올라간다");
		if (act == 1) {
			System.out.println("[2] 체력회복");
			System.out.println("[3] 무기강화");
		}
	}

	private int check() {
		for (int i = 0; i < enemy.size(); i++) {
			if (Player.getpos() == enemy.get(i).getpos()) {
				System.out.println("좀비와 마주쳤다\n");
				return i;
			}
		}
		return -1;
	}

	private boolean fight(Unit enemy) {
		while (true) {
			Player.print();
			System.out.println("===== VS =====");
			enemy.print();
			System.out.println("--------------");
			System.out.println("[무엇을 할까?]");
			System.out.printf("1.공격   2.물약(%d개 남음)\n", Player.getmedicine());
			int sel = sc.nextInt();

			// 플레이어 행동
			if (sel == 1) {
				Player.attack(enemy);
			} else if (sel == 2) {
				Player.drink();
			}
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();

			// 좀비 행동
			enemy.attack(Player);
			if (die(enemy) != 0) {
				break;
			}
			System.out.println();
		}
		if (die(enemy) == 1) {
			System.out.println("사망했다...\n");
			return false;
		} else {
			System.out.println("승리했다!\n");
			return true;
		}
	}

	private int die(Unit a) {
		if (Player.gethp() <= 0) {
			return 1;
		} else if (a.gethp() <= 0) {
			return 2;
		} else {
			return 0;
		}
	}
}
