package lv9Myrpg;

import java.util.ArrayList;

public class Inventory {
	public ArrayList<Item> inven = new ArrayList<Item>();

	public void invenMenu() {
		// TODO Auto-generated method stub
		System.out.println("1. 착용");
		System.out.println("2. 해제");
		System.out.println("3. 버리기");
		System.out.println("0. 뒤로가기");
		int sel = MainGame.sc.nextInt();

		if (sel == 1) {
			// inven 에 있는 아이탬중 하나를 선택해서 player의
			for (int i = 0; i < inven.size(); i++) {
				if (inven.get(i).kind == Item.WEAPON) {
					System.out.printf("[%d](%s) %s\n", i + 1, Item.Weapon, inven.get(i).name);
				} else if (inven.get(i).kind == Item.WEAPON) {
					System.out.printf("[%d](%s) %s\n", i + 1, Item.Armor, inven.get(i).name);
				} else if (inven.get(i).kind == 2) {
					System.out.printf("[%d](%s) %s\n", i + 1, Item.Ring, inven.get(i).name);
				}
				System.out.println("[공격력 : ] [방어력 : ]");
			}
		} else if (sel == 2) {

		} else if (sel == 3) {

		} else if (sel == 0) {

		}
	}

}
