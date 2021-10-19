package poly;

import java.util.ArrayList;

public class UnitManager {
	ArrayList<Unit> playerList = new ArrayList<Unit>();
	ArrayList<Unit> monsterList = new ArrayList<Unit>();

	public UnitManager() {
		// 플레이어 생성
		playerList.add(new Warrior("전사", 500, 100, 30));
		playerList.add(new Magician("마법사", 300, 300, 10));
		playerList.add(new Archer("궁수", 400, 200, 40));

		monsterList.add(new Lion("사자", 700, 0, 50));
		monsterList.add(new Wolf("늑대", 700, 0, 50));
		monsterList.add(new Eagle("독수리", 700, 0, 50));
	}
}
