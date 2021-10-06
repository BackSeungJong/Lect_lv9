package lv9Myrpg;

public class Player {
	public static Player instance = new Player("King");
	public String nicname;
	public static int money;

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
	public static Guild guild = new Guild();
	public static Inventory inven = new Inventory();

	// 착용중인 아이템
	public static boolean myitem[] = { false, false, false };
	public static Item myItem[] = new Item[3];
	public static boolean myparty = false;
	public static Unit myParty;

	public Player(String nicname) {
		this.nicname = nicname;
		Player.money = 100000;

		this.lv = 1;
		this.exp = this.lv * 120;

		this.hp = 100;
		this.A = 10;
		this.D = 8;
		this.S = 5;
	}

	public void mystatus() {
		// TODO Auto-generated method stub
		System.out.printf("<<닉네임>> %s [lv] %d\n" + this.nicname, this.lv);
		System.out.printf("[Exp] %d\n", this.exp);
		System.out.println("<<능력치>>");
		System.out.printf("[체력] %d(+%d)\n", this.hp, this.addhp);
		System.out.printf("[공격력] %d(+%d)\n", this.A, this.addA);
		System.out.printf("[방어력] %d(+%d)\n", this.D, this.addD);
		System.out.printf("[속도] %d(+%d)\n", this.S, this.addS);
		System.out.println();
		System.out.println("<<장비>>");
		// 무기
		for (int i = 0; i < myitem.length; i++) {
			if (myitem[i]) {
				if (i == Item.WEAPON) {
					System.out.printf("[%s] %s", Item.Weapon, myItem[i].name);
					printitemstatus(i);
				} else if (i == Item.ARMOR) {
					System.out.printf("[%s] %s", Item.Armor, myItem[i].name);
					printitemstatus(i);
				} else if (i == Item.RING) {
					System.out.printf("[%s] %s", Item.Ring, myItem[i].name);
					printitemstatus(i);
				}
			} else {
				System.out.println("착용X");
			}
		}

	}

	public void printitemstatus(int i) {
		System.out.println();
		if (myItem[i].hp != 0) {
			System.out.printf("[HP : +%d] ", myItem[i].hp);
		}
		if (myItem[i].A != 0) {
			System.out.printf("[공격력 : +%d] ", myItem[i].A);
		}
		if (myItem[i].D != 0) {
			System.out.printf("[방어력 : +%d] ", myItem[i].D);
		}
		if (myItem[i].S != 0) {
			System.out.printf("[속도 : +%d] ", myItem[i].S);
		}
		System.out.println();
	}

	public void equipItem(Item item) {
		if (myitem[item.kind]) {
			this.addhp -= myItem[item.kind].hp;
			this.addA -= myItem[item.kind].A;
			this.addD -= myItem[item.kind].D;
			this.addS -= myItem[item.kind].S;
			myItem[item.kind].enable = true;
		} else {
			myitem[item.kind] = true;
		}
		myItem[item.kind] = item;
		item.enable = false;
		this.addhp += item.hp;
		this.addA += item.A;
		this.addD += item.D;
		this.addS += item.S;
	}

	public void undressedItem(int index) {
		// TODO Auto-generated method stub
		if (myitem[index]) {
			myitem[index] = false;
			myItem[index].enable = true;
			this.addhp -= myItem[index].hp;
			this.addA -= myItem[index].A;
			this.addD -= myItem[index].D;
			this.addS -= myItem[index].S;
			myItem[index] = null;
		}
	}

	public void showMyMoney() {
		System.out.printf("소지금 : %d\n", Player.money);
	}

}
