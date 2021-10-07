package lv9Myrpg;

import java.util.ArrayList;

public class Dungeon {

	ArrayList<Monster> monsterlist = new ArrayList<Monster>();

	public void dungeonMenu() {
		// 나의 상태, 파티인원 상태 표시하는 메서드
	}

	public void init() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 15; i++) {
			monsterlist.add(makeMonster());
		}
	}

	public Monster makeMonster() {
		String monName[] = { "캥거루", "토끼", "강아지", "고양이", "코알라", "고릴라", "원숭이", "고래", "낙타", "뱀", "물개", "쥐", "소", "말", "돼지",
				"거북이", "악어", "호랑이", "표범", "치타", "늑대", "여우", " 스컹크", "두더지", "돌고래", "도마뱀", " 독소리", "바다표범", " 가재", "랍스타" };
		String name = monName[MainGame.ran.nextInt(monName.length)];
		int exp = MainGame.ran.nextInt(201) + 100;
		int num = MainGame.ran.nextInt(3) + 1;
		int hp = num * 500;
		int A = num * 100;
		int D = num * 30;
		int S = num + 5;
		return new Monster(name, exp, hp, A, D, S);
	}
}
