package lv9Myrpg;

public class Unit {
	public boolean party; // 파티 유무

	public int turn;
	public String name;
	public int lv; // 1~10
	public int exp;

	public int tmphp;
	public int hp;// 체력
	public int A;// 공격력
	public int D;// 방어력
	public int S;// 속도

	public int addhp = 0;
	public int addA = 0;
	public int addD = 0;
	public int addS = 0;

//	public static boolean unititem[] = { false, false, false };
//	public static Item unitItem[] = new Item[3];
	public boolean unititem[] = { false, false, false };
	public Item unitItem[] = new Item[3];

	public Unit(String name, int hp, int A, int D, int S) {
		this.name = name;
		this.lv = 1;
		this.exp = 100;

		this.hp = hp;
		this.A = A;
		this.D = D;
		this.S = S;

		this.party = false;
	}

	public void showPartyAllInfo() {
		// TODO Auto-generated method stub
		// [1] 이름 [lv] 1
		// [Exp] :
		// [체력 : ] [공격력 : ] [방어력 : ] [속도 : ]
		System.out.printf("<<파티원 닉네임>> %s\n[lv] %d\n", this.name, this.lv);
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
		System.out.println();
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
	}

	// 장비장착
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

	// 장비 모두 해제
	public void undressedAllUnitItem() {
		for (int i = 0; i < unitItem.length; i++) {
			if (unititem[i]) {
				unititem[i] = false;
				unitItem[i].enable = true;
				unitItem[i] = null;
			}
		}
		System.out.println("장비모두해제");
	}

	// 해제 허브
	public void undressedHub() {
		// TODO Auto-generated method stub
		showUnitItem();
		System.out.println(MainGame.bar);
		System.out.print("선택 : ");
		int index = MainGame.sc.nextInt() - 1;

		if (index >= 0 && index <= 3 && unititem[index]) {
			undressedUnitItem(index);
		} else {
			System.out.println("확인하고 다시 입력해주세요");
			System.out.println();
		}
	}

	// 아이템 해제
	public void undressedUnitItem(int index) {
		unititem[index] = false;
		unitItem[index].enable = true;
		this.addhp -= unitItem[index].hp;
		this.addA -= unitItem[index].A;
		this.addD -= unitItem[index].D;
		this.addS -= unitItem[index].S;
		unitItem[index] = null;
		System.out.println("모든장비 장착해제");
		System.out.println();
	}

	// 장착아이템보여주기
	public void showUnitItem() {
		System.out.println("<<착용중인아이템>>");
		if (unititem[0]) {
			System.out.printf("[%d][%s] %s\n", 1, Item.Weapon, unitItem[0].name);
		} else {
			System.out.printf("[%d][%s] 비었음\n", 1, Item.Weapon);
		}
		if (unititem[1]) {
			System.out.printf("[%d][%s] %s\n", 2, Item.Armor, unitItem[1].name);
		} else {
			System.out.printf("[%d][%s] 비었음\n", 2, Item.Armor);
		}
		if (unititem[2]) {
			System.out.printf("[%d][%s] %s\n", 3, Item.Ring, unitItem[2].name);
		} else {
			System.out.printf("[%d][%s] 비었음\n", 3, Item.Ring);
		}
		System.out.println();
	}

//	// 퇴출 게이트
//	public void throwoutGate() {
//		// TODO Auto-generated method stub
//		if (unititem[0] || unititem[1] || unititem[2]) {
//			System.out.println("파티원이 장비를 장착하고있습니다.");
//			System.out.println("모두 해제하고 파티를 해산하시겠습니까?");
//			System.out.println("1)네 2)아니오");
//			int sel = MainGame.sc.nextInt();
//
//			if (sel == 1) {
//				// 모든장비해제
//				undressedAllUnitItem();
//				// 파티강퇴
//				Player.myparty = false;
//				Player.myParty.party = false;
//				Player.myParty = null;
//				System.out.println("강퇴완료");
//			}
//		} else {
//			Player.myparty = false;
//			Player.myParty.party = false;
//			Player.myParty = null;
//			System.out.println("강퇴완료");
//		}
//	}
}
