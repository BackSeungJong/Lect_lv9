package lv9Myrpg;

import java.util.ArrayList;

public class Inventory {
	public ArrayList<Item> inven = new ArrayList<Item>();

	public void init() {
		inven.add(new Item(0, "나무칼", 0, 2, 0, 1, 100));
		inven.add(new Item(0, "쇠칼", 0, 5, 1, 1, 100));
		inven.add(new Item(1, "나무갑옷", 10, 0, 1, 0, 100));
		inven.add(new Item(1, "쇠갑옷", 30, 0, 3, 0, 100));
		inven.add(new Item(2, "용의반지", 10, 2, 2, 3, 100));

	}

	public void invenMenu() {
		while (true) {
			// TODO Auto-generated method stub
			// 인벤토리에서 내 캐릭터 + 길드원 아이템모두 착용해제가능하게
			//
			//
			//
			//

			System.out.println("1. 착용");
			System.out.println("2. 해제");
			System.out.println("3. 버리기");
			System.out.println("0. 뒤로가기");
			int sel = MainGame.sc.nextInt();

			if (sel == 1) {
				// inven 에 있는 아이탬중 하나를 선택해서 player의
				if (!inven.isEmpty()) {
					for (int i = 0; i < inven.size(); i++) {
						Player.inven.inven.get(i).showItemAbillty(i);
						System.out.println();
					}
					System.out.print("선택 : ");
					sel = MainGame.sc.nextInt() - 1;

					if (sel >= 0 && sel < inven.size()) {
						// 인덱스 : sel
						// kind : inven.get(sel).kind
						Player.instance.equipItem(inven.get(sel));
					}
				} else {
					System.out.println("인벤토리 비었음");
				}

			} else if (sel == 2) {
				if (Player.myitem[0] || Player.myitem[1] || Player.myitem[2]) {
					for (int i = 0; i < Player.myitem.length; i++) {
						if (Player.myitem[i]) {
							if (Player.myItem[i].kind == Item.WEAPON) {
								System.out.printf("[%d](%s) %s\n", 1, Item.Weapon, Player.myItem[i].name);
							} else if (Player.myItem[i].kind == Item.ARMOR) {
								System.out.printf("[%d](%s) %s\n", 2, Item.Armor, Player.myItem[i].name);
							} else if (Player.myItem[i].kind == Item.RING) {
								System.out.printf("[%d](%s) %s\n", 3, Item.Ring, Player.myItem[i].name);
							}
						}
					}
					System.out.print("선택 : ");
					sel = MainGame.sc.nextInt() - 1;

					if (sel >= 0 && sel <= Player.myitem.length) {
						// index = sel
						Player.instance.undressedItem(sel);
						System.out.println("해제완료");
					}
				} else {
					System.out.println("착용중인 아이템이 없습니다");
				}
			} else if (sel == 3) {
				for (int i = 0; i < inven.size(); i++) {
					Player.inven.inven.get(i).showItemAbillty(i);
					System.out.println();
				}
				System.out.print("선택 : ");
				sel = MainGame.sc.nextInt() - 1;

				if (sel >= 0 && sel <= inven.size()) {
					// 인덱스 : sel
					// kind : inven.get(sel).kind
					if (inven.get(sel).enable) {

						inven.remove(sel);
						System.out.println("버리기완료");
					} else {
						System.out.println("착용중인 아이탬입니다");
					}
				}
			} else if (sel == 0) {
				break;
			}
		}

	}

	public void sort() {
		// TODO Auto-generated method stub
		for (int i = 0; i < inven.size() - 1; i++) {
			int minidx = i;
			for (int j = i + 1; j < inven.size(); j++) {
				if (inven.get(j).kind < inven.get(minidx).kind) {
					minidx = j;
				}
			}
			Item tmp = inven.get(i);
			inven.set(i, inven.get(minidx));
			inven.set(minidx, tmp);
		}
	}

}
