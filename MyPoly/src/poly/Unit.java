package poly;

interface PossessSkill {
	void skill(Unit target);
}

public class Unit implements PossessSkill{
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
		System.out.printf("[%d] -> [%d] 일반공격\n", this.name, target.name);
	}

	@Override
	public void skill(Unit target) {
		// TODO Auto-generated method stub
		
	}
}
