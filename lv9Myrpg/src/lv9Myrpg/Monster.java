package lv9Myrpg;

public class Monster {
	public boolean participation;

	public String name;
	public int exp;
	public int turn;

	public int hp;// 체력
	public int tmphp;
	public int A;// 공격력
	public int D;// 방어력
	public int S;// 속도

	public Monster(String name, int exp, int hp, int A, int D, int S) {
		this.name = name;
		this.exp = exp;

		this.hp = hp;
		this.A = A;
		this.D = D;
		this.S = S;

		this.participation = false;
	}

}
