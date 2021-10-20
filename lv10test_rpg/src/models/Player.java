package models;

import java.util.ArrayList;
import java.util.HashMap;

import etc.Item;

public class Player extends Unit implements human {

	public Item myequipment[];
	public ArrayList<Unit> party;

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
		party = new ArrayList<>();
	}

	// 장비가져오기
	@Override
	public void getequipment() {
		System.out.println("[아이템]");
		if (myequipment.length == 0) {
			System.out.println("착용중인 아이템이 없습니다.");
		} else {
			for (int i = 0; i < myequipment.length; i++) {
				if (myequipment[i] == null) {
					System.out.println("X");
				} else {

				}
			}
		}

	}
}
