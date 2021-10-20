package models;

import java.util.ArrayList;
import java.util.HashMap;

import controller.GameController;
import etc.Item;

public class Player extends Unit implements human {

	public Item myequipment[]; // 착용 아이템
	public ArrayList<Unit> myparty; // 파티원
	public ArrayList<Item> myinven; // 인벤토리

	public Player() {

	}

	// 최초생성 > 속성세팅
	public void setstatus(String name, int hp, int mp, int att, int def) {
		super.name = name;
		maxhp = hp;
		curhp = hp;
		maxmp = mp;
		curmp = mp;
		super.att = att;
		super.def = def;
		myequipment = new Item[3];
		myparty = new ArrayList<>();
		myinven = new ArrayList<Item>();
	}

	// 장비정보 가져오기
	@Override
	public void getequipment() {
		System.out.println("[아이템]");
		if (myequipment.length == 0) {
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

	// 파티정보 가져오기
	public void getparty() {
		System.out.println("[파티]");
		if (myparty.isEmpty()) {
			System.out.println("파티가 존재하지 않습니다.");
		} else {
			for (int i = 0; i < myparty.size(); i++) {
				myparty.get(i).getstatus();
			}
		}
		System.out.println();
	}

	// 인밴토리열기
	public void getinven() {
		while (true) {
			for (int i = 0; i < myinven.size(); i++) {
				System.out.printf("[%d]", i + 1);
				myinven.get(i).getiteminfo();
				System.out.println();
			}
			System.out.println("------------------");
			System.out.println("1. 착용");
			System.out.println("2. 버리기");
			System.out.println("0. 나가기");
			int sel = GameController.sc.nextInt();
			if (sel == 1) {
				System.out.print("선택 : ");
				sel = GameController.sc.nextInt() - 1;

				if (sel >= 0 && sel < myinven.size()) {
					equip(myinven.get(sel));
				}
			} else if (sel == 2) {
				System.out.print("선택 : ");
				sel = GameController.sc.nextInt() - 1;

				if (sel >= 0 && sel < myinven.size()) {
					itemjunk(sel);
				}
			} else if (sel == 0) {
				break;
			}
		}
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
		if (myequipment[item.kind] != null) {
			myequipment[item.kind].use = false;
		}
		myequipment[item.kind] = null;

		addhp -= item.hp;
		addmp -= item.mp;
		addatt -= item.att;
		adddef -= item.def;
	}

	// 인벤 >> 아이템 버리기
	private void itemjunk(int index) {
		if (!myinven.get(index).use) {
			myinven.remove(index);
		} else {
			System.out.println("착용중인 아이템입니다.");
		}
	}
}
