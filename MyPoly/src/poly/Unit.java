package poly;

import java.util.ArrayList;

interface PossessSkill {
	void skill(Unit target);

	void skill(ArrayList<Unit> units);
}

public class Unit implements PossessSkill {
	public String name;
	public int Maxhp;
	public int curhp;
	public int Maxmp;
	public int curmp;
	public int att;

	public Unit(String name, int maxhp, int maxmp, int att) {
		this.name = name;
		this.Maxhp = maxhp;
		this.curhp = maxhp;
		this.Maxmp = maxmp;
		this.curmp = maxmp;
		this.att = att;
	}

	public void attack(Unit target) {
		target.curhp -= att;
		System.out.printf("[%s] [공격력 : %d] -> [%s] [HP : %d]\n", this.name, this.att, target.name, target.curhp);
	}

	@Override
	public void skill(Unit target) {
		// TODO Auto-generated method stub

	}

	@Override
	public void skill(ArrayList<Unit> units) {
		// TODO Auto-generated method stub
		
	}
}
