package lv9Myrpg;

public class Unit {
	public boolean party;

	public String name;
	public int price;
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

	public Unit(String name, int hp, int A, int D, int S, int price) {
		this.name = name;
		this.lv = 1;
		this.exp = 100;

		this.hp = hp;
		this.A = A;
		this.D = D;
		this.S = S;

		this.price = price;
		this.party = false;
	}

	public void showPartyInfo() {
		// TODO Auto-generated method stub
		// [1] 이름 [lv] 1
		// [Exp] :
		// [체력 : ] [공격력 : ] [방어력 : ] [속도 : ]
		System.out.printf("<<파티원 닉네임>> %s [lv] %d\n", this.name, this.lv);
		System.out.printf("[Exp] %d\n", this.exp);
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
		System.out.println();
		if (unitItem[i].hp != 0) {
			System.out.printf("[HP : +%d] ", unitItem[i].hp);
		}
		if (unitItem[i].A != 0) {
			System.out.printf("[공격력 : +%d] ", unitItem[i].A);
		}
		if (unitItem[i].D != 0) {
			System.out.printf("[방어력 : +%d] ", unitItem[i].D);
		}
		if (unitItem[i].S != 0) {
			System.out.printf("[속도 : +%d] ", unitItem[i].S);
		}
		System.out.println();
	}

	public void showUnitInfo() {
		// TODO Auto-generated method stub
		System.out.print("<<파티원 닉네임>> " + this.name);
		if (this.party) {
			System.out.println(" (파티중)");
		} else {
			System.out.println();
		}
		System.out.println("<<능력치>>");
		System.out.printf("[체력] %d(+%d)\n", this.hp, this.addhp);
		System.out.printf("[공격력] %d(+%d)\n", this.A, this.addA);
		System.out.printf("[방어력] %d(+%d)\n", this.D, this.addD);
		System.out.printf("[속도] %d(+%d)\n", this.S, this.addS);
		System.out.printf("가격 : %d\n", this.price);
	}

	public void equipUnitItem(Item item) {
		if (item.enable) {
			if (unititem[item.kind]) {
				this.addhp -= unitItem[item.kind].hp;
				this.addA -= unitItem[item.kind].A;
				this.addD -= unitItem[item.kind].D;
				this.addS -= unitItem[item.kind].S;
				unitItem[item.kind].enable = true;
			} else {
				unititem[item.kind] = true;
			}
			unitItem[item.kind] = item;
			item.enable = false;
			this.addhp += item.hp;
			this.addA += item.A;
			this.addD += item.D;
			this.addS += item.S;
			System.out.println("착용완료");
		} else {
			System.out.println("이미 착용중인 아이템입니다");
		}
	}
//
//	public void undressedUnitItem() {
//		if (unititem[index]) {
//			unititem[index] = false;
//			unititem[index].enable = true;
//			this.addhp -= myItem[index].hp;
//			this.addA -= myItem[index].A;
//			this.addD -= myItem[index].D;
//			this.addS -= myItem[index].S;
//			myItem[index] = null;
//		}
//	}

	public void undressedAllUnitItem() {
		for (int i = 0; i < unitItem.length; i++) {
			if (unititem[i]) {
				unititem[i] = false;
				unitItem[i] = null;
			}
		}
		System.out.println("장비모두해제");
	}
}
