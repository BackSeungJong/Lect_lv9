package lv9Myrpg;

public class Player {
	public String nicname;
	public int money;

	// 속성
	public int lv; // 1~10
	public int exp;

	public int hp;// 체력
	public int A;// 공격력
	public int D;// 방어력
	public int S;// 속도

	// 길드, 인벤토리
	public Guild guild;
	public Inventory inven = new Inventory();

	public Player(String nicname) {
		this.nicname = nicname;
		this.money = 100000;

		this.lv = 1;
		this.exp = this.lv * 120;

		this.hp = 100;
		this.A = 10;
		this.D = 8;
		this.S = 5;
	}

}
