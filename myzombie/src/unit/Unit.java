package unit;

import java.util.Random;

//interface
interface canAttack {
	void attack(Unit target);
}

//상속 > 부모클래스 
public class Unit implements canAttack {
	private String name;
	private int HP;
	private int hp;
	private int att;
	private int def;
	private int pos;
	private int cri;

	Random ran = new Random();

	public Unit(String name, int hp, int att, int def, int pos, int cri) {
		this.name = name;
		this.HP = hp;
		this.att = att;
		this.def = def;
		this.pos = pos;
		this.cri = cri;// 크리티컬 확률

		this.hp = HP;
	}

	// getter
	public int getHP() {
		return this.HP;
	}

	public String getname() {
		return name;
	}

	public int gethp() {
		return hp;
	}

	public int getatt() {
		return att;
	}

	public int getdef() {
		return def;
	}

	public int getpos() {
		return pos;
	}

	// setter
	public void sethp(int hp) {
		this.HP = hp;
	}

	public void setCri(int cri) {
		this.cri = cri;
	}

	// 메서드
	@Override
	public void attack(Unit target) {
		int num = ran.nextInt(100) + 1;
		int dmg = (this.att - target.def);
		if (dmg <= 0) {
			dmg = 1;
		}
		if (num <= this.cri) {
			dmg *= 2;
			System.out.println(name + "의 크리티컬 공격!!");
			System.out.println(dmg + "의 대미지!!");
			target.sethp(target.gethp() - dmg);
			System.out.println(target.name + "의 남은 체력 : " + target.hp);
		} else {
			System.out.println(name + "의 공격!");
			System.out.println(dmg + "의 대미지!");
			target.sethp(target.gethp() - dmg);
			System.out.println(target.name + "의 남은 체력 : " + target.hp);
		}
	}

}
