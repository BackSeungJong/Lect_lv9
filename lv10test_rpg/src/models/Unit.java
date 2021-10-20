package models;

interface human {
	public void getequipment();
}

public class Unit {
	public String name;
	public int maxhp;
	public int curhp;
	public int maxmp;
	public int curmp;
	public int att;
	public int def;

	public Unit() {

	}

	public Unit(String name, int hp, int mp, int att, int def) {
		this.name = name;
		this.maxhp = hp;
		this.curhp = hp;
		this.maxmp = mp;
		this.curmp = mp;
		this.att = att;
		this.def = def;
	}

	// 일반공격
	public void attack(Unit target) {
		int dmg = this.att - target.def;
		if (dmg < 0) {
			System.out.println("MISS");
		} else {
			target.curhp -= dmg;
			System.out.printf("[%s] >> [%s][HP] %d(-%d)", name, target.name, target.curhp, dmg);
		}
	}

	// 속성가져오기
	public void getstatus() {
		System.out.println("[속성]");
		System.out.printf("[이름] %s [HP] %d [MP] %d\n", name, curhp, curmp);
		System.out.printf("[ATT] %d [DEF] %d\n", att, def);
		System.out.println();
	}

}
