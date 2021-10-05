package lv9Myrpg;

import java.util.ArrayList;

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

	public int addhp = 0;
	public int addA = 0;
	public int addD = 0;
	public int addS = 0;

	// 길드, 인벤토리
	public Guild guild = new Guild();
	public Inventory inven = new Inventory();

	// 착용중인 아이템
	public boolean myitem[] = { false, false, false };
	public String item[] = { "무기", "방어구", "반지" };
	public Item myItem[] = new Item[3];

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

	public void guildMenu() {
		// TODO Auto-generated method stub

	}

	public void mystatus() {
		// TODO Auto-generated method stub
		System.out.println("[닉네임] " + nicname);
		System.out.println("[능력치]");
		System.out.printf("체력 : %d(+%d)\n", this.hp, this.addhp);
		System.out.printf("공격력 : %d(+%d)\n", this.A, this.addA);
		System.out.printf("방어력 : %d(+%d)\n", this.D, this.addD);
		System.out.printf("속도 : %d(+%d)\n", this.S, this.addS);
		System.out.println("[장비]");
		// 무기
		int cnt = 1;
		for (int i = 0; i < myitem.length; i++) {
			if (myitem[i]) {
				System.out.printf("%s : %d\n", item[i], myItem[i].power);
			} else {
				System.out.println("착용X");
			}
		}
		// 방어구
		// 반지

	}
}
