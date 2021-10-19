package poly;

import java.util.ArrayList;

public class Warrior extends Unit {

	public Warrior(String name, int maxhp, int maxmp, int att) {
		super(name, maxhp, maxmp, att);
	}

	@Override
	public void skill(ArrayList<Unit> units) {
		// TODO Auto-generated method stub
		System.out.println("[전사스킬 발동] 적 전체에게 공격");
		for (int i = 0; i < units.size(); i++) {
			units.get(i).curhp -= att;
			System.out.printf("[%s] [공격력 : %d] -> [%s] [HP : %d]\n", this.name, this.att, units.get(i).name,
					units.get(i).curhp);
		}
	}

}
