package poly;

import java.util.ArrayList;
import java.util.Random;

public class StageBattle extends Stage {

	UnitManager unitManager = new UnitManager();
	ArrayList<Unit> playerList = null;
	ArrayList<Unit> monsterList = null;
	Random ran = new Random();

	@Override
	public boolean update() {
		// 배틀 메소드
		System.out.println("------전투시작------");
		while (true) {
			for (int i = 0; i < playerList.size(); i++) {
				PlayerTurn(playerList.get(i));
				System.out.println();
			}
			for (int i = 0; i < monsterList.size(); i++) {
				MonsterTurn(monsterList.get(i));
			}
			System.out.println();
			if (!check()) {
				break;
			}
		}
		System.out.println("--------------------\n");
		return false;
	}

	private boolean check() {
		// TODO Auto-generated method stub
		if (monsterList.isEmpty()) {
			return false;
		} else if (playerList.isEmpty()) {
			return false;
		}
		return true;
	}

	private void MonsterTurn(Unit unit) {
		// TODO Auto-generated method stub
		int index = ran.nextInt(playerList.size());

		unit.attack(playerList.get(index));
	}

	private void PlayerTurn(Unit unit) {

		int index = ran.nextInt(monsterList.size());
		Unit tmp = null;
		System.out.printf("[%s] [HP : %d]  [MP : %d]\n", unit.name, unit.curhp, unit.curmp);
		System.out.println("[1.일반공격] [2.스킬사용] [3.휴식]");
		int sel = GameManager.sc.nextInt();

		if (sel == 1) {
			unit.attack(monsterList.get(index));
			tmp = monsterList.get(index);
		} else if (sel == 2) {
			if (unit.curmp >= 100) {
				if (unit instanceof Warrior) {
					unit.skill(monsterList);
					unit.curmp -= 100;
				} else if (unit instanceof Magician) {
					index = ran.nextInt(playerList.size());
					unit.skill(playerList.get(index));
					unit.curmp -= 100;
				} else {
					unit.skill(monsterList.get(index));
					unit.curmp -= 100;
				}
			} else {
				System.out.println("마나가 부족합니다");
			}
		} else if (sel == 3) {
			System.out.println("휴식을 취합니다.");
			System.out.println("[+100HP] [+100MP]");
			if (unit.curhp + 100 >= unit.Maxhp) {
				unit.curhp = unit.Maxhp;
			} else {
				unit.curhp += 100;
			}

			if (unit.curmp + 100 >= unit.Maxmp) {
				unit.curmp = unit.Maxmp;
			} else {
				unit.curmp += 100;
			}
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		playerList = unitManager.playerList;
		monsterList = unitManager.monsterList;
	}
}
