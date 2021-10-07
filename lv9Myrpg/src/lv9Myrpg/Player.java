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
	public static boolean myparty[] = { false, false, false, false };
	public static Unit myParty[] = new Unit[4];

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

	// 내 능력치 상태표시
	public void mystatus() {
		// TODO Auto-generated method stub
		System.out.printf("<<닉네임>> %s\n[lv] %d\n", this.nicname, this.lv);
		System.out.printf("[Exp] %d\n", this.exp);
		System.out.println("<<능력치>>");
		System.out.printf("[체력] %d(+%d)\n", this.hp, this.addhp);
		System.out.printf("[공격력] %d(+%d)\n", this.A, this.addA);
		System.out.printf("[방어력] %d(+%d)\n", this.D, this.addD);
		System.out.printf("[속도] %d(+%d)\n", this.S, this.addS);
		System.out.println();
//		System.out.println("<<장비>>");
		// 무기
//		for (int i = 0; i < myitem.length; i++) {
//			if (myitem[i]) {
//				if (i == Item.WEAPON) {
//					System.out.printf("[%s] %s", Item.Weapon, myItem[i].name);
//					printitemstatus(i);
//				} else if (i == Item.ARMOR) {
//					System.out.printf("[%s] %s", Item.Armor, myItem[i].name);
//					printitemstatus(i);
//				} else if (i == Item.RING) {
//					System.out.printf("[%s] %s", Item.Ring, myItem[i].name);
//					printitemstatus(i);
//				}
//			} else {
//				System.out.println("착용X");
//			}
//		}

	}

	// 아이템 능력치
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

	// 장비 장착
	public void equipItem(Item item) {
		if (item.enable) {
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
			System.out.println("착용완료");
		} else {
			System.out.println("착용중인 아이템입니다");
			System.out.println();
		}
	}

	// 장비해제
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

	// 소지금 출력
	public void showMyMoney() {
		System.out.printf("소지금 : %d\n", Player.money);
	}

	// 파티관리
	public static void partyMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1. 파티원 추가");
			System.out.println("2. 파티원 삭제");
			System.out.println("3. 파티원 교체");
			System.out.println("0. 나가기");
			int sel = MainGame.sc.nextInt();

			if (sel == 1) {
				int cnt = 0;
				for (int i = 0; i < myparty.length; i++) {
					if (!myparty[i]) {
						cnt++;
					}
				}
				if (cnt != 0) {
					addparty();
				} else {
					System.out.println("파티가 가득 찼습니다.\n");
				}
			} else if (sel == 2) {
				int cnt = 0;
				for (int i = 0; i < myparty.length; i++) {
					if (myparty[i]) {
						cnt++;
					}
				}
				if (cnt == 0) {
					System.out.println("파티가 비었습니다.\n");
				} else {
					deleteparty();
				}
			} else if (sel == 3) {
				int cnt = 0;
				for (int i = 0; i < myparty.length; i++) {
					if (myparty[i]) {
						cnt++;
					}
				}
				if (cnt == 0) {
					System.out.println("파티가 비었습니다.\n");
				} else {
					replaceparty();
				}
			} else if (sel == 0) {
				break;
			}
		}
	}

	// 파티관리 >> 파티원 추가
	private static void addparty() {
		// TODO Auto-generated method stub
		guild.showAllUnit();
		System.out.print("선택 : ");
		int UnitIdx = MainGame.sc.nextInt() - 1;

		if (UnitIdx >= 0 && UnitIdx < guild.guildlist.size() && !guild.guildlist.get(UnitIdx).party) {
			for (int i = 0; i < myParty.length; i++) {
				if (myparty[i]) {
					System.out.printf("[%d] %s (lv.%d)\n", i + 1, myParty[i].name, myParty[i].lv);
				} else {
					System.out.printf("[%d] 비었음\n", i + 1);
				}
			}
			System.out.print("자리 선택 : ");
			int idx = MainGame.sc.nextInt() - 1;

			if (idx >= 0 && idx < 4 && !myparty[idx]) {
				myparty[idx] = true;
				guild.guildlist.get(UnitIdx).party = true;
				myParty[idx] = guild.guildlist.get(UnitIdx);
				System.out.println("파티원 추가 완료\n");
			}
		}
	}

	// 파티관리 >> 파티원 삭제
	private static void deleteparty() {
		// TODO Auto-generated method stub
		for (int i = 0; i < myParty.length; i++) {
			if (myparty[i]) {
				System.out.printf("[%d] %s (lv.%d)\n", i + 1, myParty[i].name, myParty[i].lv);
			} else {
				System.out.printf("[%d] 비었음\n", i + 1);
			}
		}
		System.out.print("자리 선택 : ");
		int idx = MainGame.sc.nextInt() - 1;

		if (idx >= 0 && idx < myparty.length && myparty[idx]) {
			myParty[idx].party = false;
			myparty[idx] = false;
			myParty[idx] = null;
			System.out.println("파티강퇴 완료\n");
		}
	}

	// 파티관리 >> 파티원 교체
	private static void replaceparty() {
		// TODO Auto-generated method stub
		for (int i = 0; i < myParty.length; i++) {
			if (myparty[i]) {
				System.out.printf("[%d] %s (lv.%d)\n", i + 1, myParty[i].name, myParty[i].lv);
			} else {
				System.out.printf("[%d] 비었음\n", i + 1);
			}
		}
		System.out.print("자리 선택 : ");
		int idx = MainGame.sc.nextInt() - 1;

		if (idx >= 0 && idx < myparty.length && myparty[idx]) {
			guild.showAllUnit();
			System.out.print("선택 : ");
			int UnitIdx = MainGame.sc.nextInt() - 1;

			if (UnitIdx >= 0 && UnitIdx < guild.guildlist.size() && !guild.guildlist.get(UnitIdx).party) {
				myParty[idx].party = false;
				myParty[idx] = guild.guildlist.get(UnitIdx);
				myParty[idx].party = true;
				System.out.println("파티교체 완료\n");
			}
		}
	}
}
