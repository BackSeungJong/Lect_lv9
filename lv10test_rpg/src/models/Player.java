package models;

//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
import java.util.ArrayList;
import java.util.HashMap;

import controller.GameController;
import etc.Guild;
import etc.Item;

public class Player extends Unit {

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

	// 파티정보 가져오기
	public void getparty() {

		if (myparty.isEmpty()) {
			System.out.println("파티가 존재하지 않습니다.");
		} else {
			for (int i = 0; i < myparty.size(); i++) {
				System.out.printf("[%d]", i + 1);
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

	// 인벤 >> 아이템 버리기
	private void itemjunk(int index) {
		if (!myinven.get(index).use) {
			myinven.remove(index);
		} else {
			System.out.println("착용중인 아이템입니다.");
		}
	}

	public void manageparty() {

		// TODO Auto-generated method stub
		while (true) {
			getparty();
			System.out.println("------------------");
			System.out.println("1. 파티원 영입");
			System.out.println("2. 파티원 퇴출");
			System.out.println("3. 파티원 장비 착용");
			System.out.println("4. 파티원 장비 해제");
			int sel = GameController.sc.nextInt();

			if (sel == 1) {
				recruit();
			} else if (sel == 2) {
				withdraw();
			} else if (sel == 3) {
				equipmyparty();
			} else if (sel == 4) {
				unequipmyparty();
			}
		}
	}

	private void unequipmyparty() {
		// TODO Auto-generated method stub
		System.out.print("선택 : ");
		int index = GameController.sc.nextInt() - 1;

		if (index >= 0 && index < myparty.size()) {
			for (int i = 0; i < myparty.get(index).myequipment.length; i++) {
				System.out.printf("[%d]", i + 1);
				myinven.get(i).getiteminfo();
				System.out.println();
			}
			System.out.println("---------");
			System.out.print("선택 : ");

			int itemindex = GameController.sc.nextInt() - 1;

			myparty.get(index).equip(myinven.get(itemindex));
		}
	}

	private void equipmyparty() {
		// TODO Auto-generated method stub
		System.out.print("선택 : ");
		int index = GameController.sc.nextInt() - 1;

		if (index >= 0 && index < myparty.size()) {
			for (int i = 0; i < myinven.size(); i++) {
				System.out.printf("[%d]", i + 1);
				myinven.get(i).getiteminfo();
				System.out.println();
			}
			System.out.println("---------");
			System.out.print("선택 : ");

			int itemindex = GameController.sc.nextInt() - 1;

			myparty.get(index).equip(myinven.get(itemindex));
		}
	}

	// 파티원 퇴출
	private void withdraw() {
		if (!myparty.isEmpty()) {
			for (int i = 0; i < myparty.size(); i++) {
				System.out.printf("[%d]", i + 1);
				myparty.get(i).getstatus();
			}
			System.out.print("선택 : ");
			int sel = GameController.sc.nextInt() - 1;

			if (sel >= 0 && sel < myparty.size()) {
				myparty.get(sel).allunequip(myparty.get(sel).myequipment);
				myparty.remove(sel);
			}

		}
	}

	// 파티원 영입
	private void recruit() {
		Guild guild = GameController.guild;
		if (myparty.size() < 3) {
			for (int i = 0; i < guild.list.size(); i++) {
				System.out.printf("[%d]", i + 1);
				guild.list.get(i).getstatus();
			}
			System.out.print("선택 : ");
			int sel = GameController.sc.nextInt() - 1;

			if (sel >= 0 && sel < guild.list.size()) {
				myparty.add(guild.list.get(sel));
				guild.list.remove(sel);
			}
		} else {
			System.out.println("더이상 영입할 수 없습니다.");
		}
	}

	public void manageguild() {
		Guild guild = GameController.guild;
		while (true) {
			for (int i = 0; i < guild.list.size(); i++) {
				System.out.printf("[%d]", i + 1);
				guild.list.get(i).getstatus();
			}
			System.out.println("------------------");
			System.out.println("1. 파티초대");
			System.out.println("0. 나가기");
			int sel = GameController.sc.nextInt();

			if (sel == 1) {
				recruit();
			} else if (sel == 0) {
				break;
			}
		}
	}
}
