package unit;

interface Attack {
	void attack();
}

public class Unit implements Attack {
	private String name;
	private int HP; // 최대 체력
	private int hp; // 현재 체력
	private int att;
	private int def;
	private int cri;
	private int pos;

	public Unit(String name, int HP, int att, int def, int cri, int pos) {
		this.name = name;
		this.HP = HP;
		this.att = att;
		this.def = def;
		this.cri = cri;
		this.pos = pos;

		this.hp = HP;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub

	}

}
