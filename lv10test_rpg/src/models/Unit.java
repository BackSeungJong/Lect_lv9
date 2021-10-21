package models;

import etc.Item;

interface human {
	public void getequipment();

	public void equip(Item item);

	public void unequip(Item item);

	public void allunequip(Item[] list);
}

public class Unit implements human {
	public String name;
	public int maxhp;
	public int curhp;
	public int maxmp;
	public int curmp;
	public int att;
	public int def;

	public Item myequipment[]; // 착용 아이템

	// 장비속성
	public int addhp;
	public int addmp;
	public int addatt;
	public int adddef;

	public Unit() {

	}

	public Unit(String name, int hp, int mp, int att, int def) {
		myequipment= new Item[3];
		this.name = name;
		this.maxhp = hp;
		this.curhp = hp;
		this.maxmp = mp;
		this.curmp = mp;
		this.att = att;
		this.def = def;
	}

	// 일반공격
	public void attack(Unit target) {
		int dmg = this.att - target.def;
		if (dmg < 0) {
			System.out.println("MISS");
		} else {
			target.curhp -= dmg;
			System.out.printf("[%s] >> [%s][HP] %d(-%d)", name, target.name, target.curhp, dmg);
		}
	}

	// 속성가져오기
	public void getstatus() {

		System.out.printf("[이름] %s [HP] %d(+%d) [MP] %d(+%d)\n", name, curhp, addhp, curmp, addmp);
		System.out.printf("[ATT] %d(+%d) [DEF] %d(+%d)\n", att, addatt, def, adddef);
		System.out.println();
	}

	// 장비정보 가져오기
	@Override
	public void getequipment() {

		if (myequipment == null) {
			System.out.println("착용중인 아이템이 없습니다.");
		} else {
			for (int i = 0; i < myequipment.length; i++) {
				if (myequipment[i] != null) {
					myequipment[i].getiteminfo();
				}
			}
		}
		System.out.println();
	}

	// 인벤 >> 장비장착
	@Override
	public void equip(Item item) {
		// 착용중인거 벗기
		if (myequipment[item.kind] != null) {
			myequipment[item.kind].use = false;
		}
		// 착용
		item.use = true;
		myequipment[item.kind] = item;
		System.out.println("착용완료");

		addhp += item.hp;
		addmp += item.mp;
		addatt += item.att;
		adddef += item.def;
	}

	// >> 장비해제
	@Override
	public void unequip(Item item) {
		// TODO Auto-generated method stub
		if (myequipment[item.kind] != null) {
			myequipment[item.kind].use = false;
		}
		myequipment[item.kind] = null;

		addhp -= item.hp;
		addmp -= item.mp;
		addatt -= item.att;
		adddef -= item.def;
	}

	@Override
	public void allunequip(Item[] list) {
		// TODO Auto-generated method stub
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i] != null) {
					list[i].use = false;
					addhp -= list[i].hp;
					addmp -= list[i].mp;
					addatt -= list[i].att;
					adddef -= list[i].def;
				}
			}
		}
		System.out.println("장비모두해제완료");
	}
}
