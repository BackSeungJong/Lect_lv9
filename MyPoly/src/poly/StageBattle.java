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
		for (int i = 0; i < playerList.size(); i++) {
			PlayerTurn(playerList.get(i));
		}
		for (int i = 0; i < monsterList.size(); i++) {
			MonsterTurn(monsterList.get(i));
		}
		return false;
	}

	private void MonsterTurn(Unit unit) {
		// TODO Auto-generated method stub
		int index = ran.nextInt(playerList.size());
	}

	private void PlayerTurn(Unit unit) {

		int index = ran.nextInt(monsterList.size());

		System.out.printf("[%d] [HP : %d]  [MP : %d]", unit.name, unit.curhp, unit.curmp);
		System.out.println("[1.일반공격] [2.스킬사용] [3.휴식]");
		int sel = GameManager.sc.nextInt();

		if (sel == 1) {
			unit.attack(monsterList.get(index));
		} else if (sel == 2) {
			if (unit.curmp >= 100) {
				unit.skill(monsterList.get(index));
				unit.curmp -= 100;
			} else {
				System.out.println("마나가 부족합니다");
			}
		} else if (sel == 3) {
			System.out.println("휴식을 취합니다.");
			System.out.println("[+100HP] [+100MP]");
			unit.curhp += 100;
			unit.curmp += 100;
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		playerList = unitManager.playerList;
		monsterList = unitManager.monsterList;
	}

}
