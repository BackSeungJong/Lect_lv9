package lv9Myrpg;

public class Item {
	static final int WEAPON = 0;
	static final int ARMOR = 1;
	static final int RING = 2;

	static String Weapon = "무기";
	static String Armor = "방어구";
	static String Ring = "반지";

	boolean enable;

	int kind;
	String name;
	// 아이탬 능력치
	int hp;// 체력
	int A;// 공격력
	int D;// 방어력
	int S;// 속도

	int price;

	public Item(int k, String n, int hp, int a, int d, int s, int pr) {
		this.kind = k;
		this.name = n;
		this.hp = hp;
		this.A = a;
		this.D = d;
		this.S = s;
		this.price = pr;
		this.enable = true;
	}
	
	public void showItemAbillty(int i) {
		
		if (kind == Item.WEAPON) {
			System.out.printf("[%d](%s) %s", i + 1, Item.Weapon, name);
		} else if (kind == Item.ARMOR) {
			System.out.printf("[%d](%s) %s", i + 1, Item.Armor, name);
		} else if (kind == Item.RING) {
			System.out.printf("[%d](%s) %s", i + 1, Item.Ring, name);
		}

		if (!enable) {
			System.out.println("(착용중)");
		} else {
			System.out.println();
		}

		//
		if (hp != 0) {
			System.out.printf("[체력 : %d] ", hp);
		}
		if (A != 0) {
			System.out.printf("[공격력 : %d] ", A);
		}
		if (D != 0) {
			System.out.printf("[방어력 : %d] ",D);
		}
		if (S != 0) {
			System.out.printf("[속도 : %d] ", S);
		}
		System.out.println();
	}
}
