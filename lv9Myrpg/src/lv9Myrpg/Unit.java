package lv9Myrpg;

public class Unit {
	public String name;
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

	public static boolean unititem[] = { false, false, false };
	public static Item unitItem[] = new Item[3];

	public Unit(String name, int hp, int A, int D, int S) {
		this.name = name;
		this.lv = 1;
		this.exp = 100;

		this.hp = hp;
		this.A = A;
		this.D = D;
		this.S = S;
	}

	public void showUnitInfo(int num) {
		// TODO Auto-generated method stub
		// [1] 이름
		// [체력 : ] [공격력 : ] [방어력 : ] [속도 : ]
		System.out.println("<<닉네임>> " + this.name);
		System.out.println("<<능력치>>");
		System.out.printf("[체력] %d(+%d)\n", this.hp, this.addhp);
		System.out.printf("[공격력] %d(+%d)\n", this.A, this.addA);
		System.out.printf("[방어력] %d(+%d)\n", this.D, this.addD);
		System.out.printf("[속도] %d(+%d)\n", this.S, this.addS);
		System.out.println();
		System.out.println("<<장비>>");
		// 무기
		for (int i = 0; i < unititem.length; i++) {
			if (unititem[i]) {
				if (i == Item.WEAPON) {
					System.out.printf("[%s] %s", Item.Weapon, unitItem[i].name);
					printiUnitItemstatus(i);
				} else if (i == Item.ARMOR) {
					System.out.printf("[%s] %s", Item.Armor, unitItem[i].name);
					printiUnitItemstatus(i);
				} else if (i == Item.RING) {
					System.out.printf("[%s] %s", Item.Ring, unitItem[i].name);
					printiUnitItemstatus(i);
				}
			} else {
				System.out.println("착용X");
			}
		}
	}

	private void printiUnitItemstatus(int i) {
		// TODO Auto-generated method stub

	}
}
