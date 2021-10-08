package lv9Myrpg;

import java.util.ArrayList;

public class Dungeon {
	ArrayList<Monster> monsterlist = new ArrayList<Monster>();
	ArrayList<Monster> enemy = new ArrayList<Monster>();

	public void dungeonMenu() {
		//
		enemySet();
		// 나의 상태, 파티인원 상태 표시하는 메서드
		Player.instance.showMyAllState();

		System.out.println(MainGame.bar);
		System.out.println(Player.instance.S);
		System.out.println("-----");
		for (int i = 0; i < Player.myParty.length; i++) {
			System.out.println(Player.myParty[i].S);
		}
		System.out.println("-----");
		for (int i = 0; i < enemy.size(); i++) {
			System.out.println(enemy.get(i).S);
		}
		System.out.println(MainGame.bar);

		// 파티원이 부족할 경우 입장불가
		if (checkParty()) {
			System.out.println("입장하시겠습니까?");
			System.out.println("1. 예 2. 아니오");
			int sel = MainGame.sc.nextInt();

			if (sel == 1) {
				battle();
			}
		} else {
			System.out.println("파티원이 부족합니다.");
			System.out.println("파티원을 영입하고 입장해주세요.\n");
		}
	}

	public void init() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 15; i++) {
			monsterlist.add(makeMonster());
		}
	}

	// 몬스터 만들기
	public Monster makeMonster() {
		String monName[] = { "캥거루", "토끼", "강아지", "고양이", "코알라", "고릴라", "원숭이", "고래", "낙타", "뱀", "물개", "쥐", "소", "말", "돼지",
				"거북이", "악어", "호랑이", "표범", "치타", "늑대", "여우", " 스컹크", "두더지", "돌고래", "도마뱀", " 독소리", "바다표범", " 가재", "랍스타" };
		String name = monName[MainGame.ran.nextInt(monName.length)];
		int exp = MainGame.ran.nextInt(201) + 100;
		int num = MainGame.ran.nextInt(3) + 1;
		int hp = num * 500;
		int A = num;
		int D = num;
		int S = num + 5;
		return new Monster(name, exp, hp, A, D, S);
	}

	// 적 리스트 만들기
	private void enemySet() {
		for (int i = 0; i < 3; i++) {
			int index = MainGame.ran.nextInt(monsterlist.size());
			if (!monsterlist.get(index).participation) {
				monsterlist.get(index).participation = true;
				enemy.add(monsterlist.get(index));
			} else {
				i--;
			}
		}
		System.out.println("set 종료");
		for (int i = 0; i < enemy.size(); i++) {
			System.out.println(enemy.get(i).name);
			System.out.println(enemy.get(i).S);
			System.out.println();
		}
	}

	private void battle() {
		// 순서 정하기
		int max = Player.instance.S;
		Player.instance.tmphp = Player.instance.hp;// 체력세팅
		for (int i = 0; i < Player.myParty.length; i++) {
			Player.myParty[i].tmphp = Player.myParty[i].hp;// 체력세팅
			if (Player.myParty[i].S > max) {
				max = Player.myParty[i].S;
			}
		}
		for (int i = 0; i < enemy.size(); i++) {
			enemy.get(i).tmphp = enemy.get(i).hp;// 체력세팅
			if (max < enemy.get(i).S) {
				max = enemy.get(i).S;
			}
		}
		int maxData = max;
		System.out.println("제일큰값 : " + max);
		System.out.println("제일큰값 : " + maxData);

		// ---------------------------------------------------------------------------------
		boolean win = false;
		boolean isRun = true;
		int cnt = 1;
		while (isRun) {
//			System.out.printf("------%d-------\n", max);
			if (max == Player.instance.S) {
				playerAttack(); // 플레이어공격
				if (enemy.isEmpty()) {
					win = true;
					isRun = false;
					break;
				}
			}
			if (!enemy.isEmpty()) {
				for (int i = 0; i < Player.myParty.length; i++) {
					if (Player.myparty[i] && max == Player.myParty[i].S) {
						partyAttack(Player.myParty[i]); // 파티원 공격
						if (enemy.isEmpty()) {
							win = true;
							isRun = false;
							break;
						}
					}
				}
			}
			if (!enemy.isEmpty()) {
				for (int i = 0; i < enemy.size(); i++) {
					if (max == enemy.get(i).S) {
						defend(enemy.get(i)); // 몬스터공격

						// 플레이어 사망시
						if (!Player.heart) {
							isRun = false;
							break;
						}
					}
				}
			}
			max--;
			if (enemy.isEmpty()) {
				win = true;
				isRun = false;
			}
//			else if (!Player.heart) {
//				Player.heart = true;
//				isRun = false;
//			}
			if (max == 0) {
				max = maxData;
			}
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			cnt++;
		}
		// ------------------------------------------------------------------------------

		if (win) {
			System.out.println("던전클리어!");
		} else {
			System.out.println("던전클리어 실패. . .");
		}
	}

	// 플레이어 공격
	public void playerAttack() {
		int attack = MainGame.ran.nextInt(enemy.size());

		System.out.printf("PLAYER -> %s\n", enemy.get(attack).name);

		if (Player.instance.A > enemy.get(attack).D) {
			System.out.printf("공격성공.\n");
			enemy.get(attack).tmphp -= Player.instance.A - enemy.get(attack).D;
			if (enemy.get(attack).tmphp <= 0) {
				System.out.printf("%s가 사망했다.\n", enemy.get(attack).name);
				enemy.remove(attack);
			}
		} else {
			System.out.println("MISS");
		}
		System.out.println();
	}

	// 파티원 공격
	public void partyAttack(Unit party) {
		int attack = MainGame.ran.nextInt(enemy.size());

		System.out.printf("%s -> %s\n", party.name, enemy.get(attack).name);

		if (party.A > enemy.get(attack).D) {
			System.out.printf("공격성공.\n");
			enemy.get(attack).tmphp -= party.A - enemy.get(attack).D;
			if (enemy.get(attack).tmphp <= 0) {
				System.out.printf("%s가 사망했다.\n", enemy.get(attack).name);
				enemy.remove(attack);
			}
		} else {
			System.out.println("MISS");
		}
		System.out.println();
	}

	// 몬스터 공격 프로세스
	public void defend(Monster enemy) {
		while (true) {
			int attack = MainGame.ran.nextInt(Player.myparty.length + 1);

			if (attack == Player.myparty.length) {// 플레이어 맞기
				playerDefend(enemy);
				break;
			} else if (Player.myparty[attack]) {// 파티원이 맞기
				partyDefend(enemy, Player.myParty[attack]);
				break;
			}
		}
		System.out.println();
	}

	// 플레이가 맞기
	public void playerDefend(Monster enemy) {
		System.out.printf("%s -> %s\n", enemy.name, "PLAYER");

		if (enemy.A > Player.instance.D) {
			System.out.printf("공격성공.\n");
			Player.instance.tmphp -= enemy.A - Player.instance.D;
			if (Player.instance.tmphp <= 0) {
				System.out.printf("%s가 사망했다.\n", "PLAYER");
				Player.heart = false;
			}
		} else {
			System.out.println("MISS");
		}
		System.out.println();
	}

	// 파티원이 맞기
	public void partyDefend(Monster enemy, Unit party) {
		System.out.printf("%s -> %s\n", enemy.name, party.name);

		if (enemy.A > party.D) {
			System.out.printf("공격성공.\n");
			party.tmphp -= enemy.A - party.D;
			if (party.tmphp <= 0) {
				System.out.printf("%s가 사망했다.\n", party.name);
				party.undressedAllUnitItem();
				for (int i = 0; i < Player.myparty.length; i++) {
					if (Player.myparty[i] && Player.myParty[i].equals(party)) {
						Player.myparty[i] = false;
						Player.myParty[i] = null;
						for (int j = 0; j < Player.guild.guildlist.size(); j++) {
							if (party.equals(Player.guild.guildlist.get(j))) {
								Player.guild.guildlist.remove(j);
							}
						}
					}
				}
			}
		} else {
			System.out.println("MISS");
		}
		System.out.println();
	}

	// 파티가 풀인지 확인
	private boolean checkParty() {
		// TODO Auto-generated method stub

		for (int i = 0; i < Player.myparty.length; i++) {
			if (!Player.myparty[i]) {
				return false;
			}
		}
		return true;
	}
}
