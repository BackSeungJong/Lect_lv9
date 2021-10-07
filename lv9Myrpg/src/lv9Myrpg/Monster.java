package lv9Myrpg;

public class Monster {

	public String name;
	public int exp;

	public int hp;// 체력
	public int A;// 공격력
	public int D;// 방어력
	public int S;// 속도

	public Monster(String name, int exp, int hp, int A, int D, int S) {
		this.name = name;
		this.exp = exp;

		this.hp = hp;
		this.A = A;
		this.D = D;
		this.S = S;
	}

	public void makeMonster() {
		String monName[] = { "캥거루", "토끼", "강아지", "고양이", "코알라", "고릴라", "원숭이", "고래", "낙타", "뱀", "물개", "쥐", "소", "말", "돼지",
				"거북이", "악어", "호랑이", "표범", "치타", "늑대", "여우", " 스컹크", "두더지", "돌고래", "도마뱀", " 독소리", "바다표범", " 가재", "랍스타" };
		String name = monName[MainGame.ran.nextInt(monName.length)];
		int exp = MainGame.ran.nextInt(201)+100;
		int num=MainGame.ran.nextInt(3)+1;
		int hp = num*500;
		int A = num*100;
		int D = num*30;
		int S = num+5;
	}
}
