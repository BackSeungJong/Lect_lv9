package lv9Myrpg;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> itemlist = new ArrayList<Item>();

	public void init() {
		itemlist.add(new Item(0, "단검", 0, 3, 0, 3, 1000));
		itemlist.add(new Item(0, "장검", 0, 5, 1, 1, 1000));
		itemlist.add(new Item(0, "대검", 20, 7, 0, 0, 1500));
		itemlist.add(new Item(1, "금갑옷", 300, 7, 0, 0, 9000));
		itemlist.add(new Item(1, "은갑옷", 200, 7, 0, 0, 5000));
		itemlist.add(new Item(1, "동갑옷", 100, 7, 0, 0, 3000));
		itemlist.add(new Item(1, "천갑옷", 50, 7, 0, 0, 1000));
		itemlist.add(new Item(2, "귀걸이", 50, 7, 5, 5, 3000));
		itemlist.add(new Item(2, "팔찌", 50, 5, 7, 7, 3000));
		itemlist.add(new Item(2, "목걸이", 50, 5, 5, 7, 3000));
		itemlist.add(new Item(2, "코걸이", 100, 7, 7, 7, 7000));
	}

	public void shopMenu() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1. 구매");
			System.out.println("2. 판매");
			System.out.println("0. 나가기");
			int sel = MainGame.sc.nextInt();

			if (sel == 1) {
				buyItem();
			} else if (sel == 2) {
				sellItem();
			} else if (sel == 0) {
				break;
			}
		}
	}

	public void sellItem() {
		for (int i = 0; i < Player.inven.inven.size(); i++) {
			Player.inven.inven.get(i).showItemAbillty(i);
		}
		System.out.print("선택 : ");
		int sel = MainGame.sc.nextInt() - 1;

		if (Player.inven.inven.get(sel).enable) {
			Player.money += Player.inven.inven.get(sel).price;
			Player.inven.inven.remove(sel);
			System.out.println("판매완료");
			Player.instance.showMyMoney();
		} else {
			System.out.println("착용중인 장비는 판매할 수 없습니다");
		}

	}

	public void buyItem() {
		showShopItem();
		System.out.println(MainGame.bar);
		Player.instance.showMyMoney();
		System.out.print("선택 : ");
		int sel = MainGame.sc.nextInt() - 1;

		if (sel >= 0 && sel < itemlist.size()) {
			if (Player.money >= itemlist.get(sel).price) {
				Player.inven.inven.add(itemlist.get(sel));
				Player.money -= itemlist.get(sel).price;
				itemlist.remove(sel);
				System.out.println("구매완료");
			} else {
				System.out.println("잔액부족");
			}
		}
	}

	public void showShopItem() {
		for (int i = 0; i < itemlist.size(); i++) {
			itemlist.get(i).showItemAbillty(i);
			System.out.printf("[가격 : %d]\n\n", itemlist.get(i).price);
		}
	}
}
