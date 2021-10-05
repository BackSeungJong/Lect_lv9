package lv9Myrpg;

public class Item {
	static final int WEAPON = 0;
	static final int ARMOR = 1;
	static final int RING = 2;

	static String Weapon = "무기";
	static String Armor = "방어구";
	static String Ring = "반지";

	int kind;
	String name;
	int hp;// 체력
	int A;// 공격력
	int D;// 방어력
	int S;// 속도
	int price;

	public void setItem(int k, String n, int p, int pr) {
		kind = k;
		name = n;
		price = pr;
	}
}
