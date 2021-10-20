package etc;

import java.util.ArrayList;

import controller.GameController;
import models.Player;
import models.Unit;

public class Guild {
	public ArrayList<Unit> list = new ArrayList<>();

	public Guild() {
		for (int i = 0; i < 10; i++) {
			init();
		}
	}

	public void init() {
		String f[] = { "김", "박", "이", "서", "우", "백", "정" };
		String s[] = { "승", "종", "예", "정", "웅", "우", "은", "무", "장", "순" };
		String l[] = { "은", "재", "설", "소", "연", "영", "정", "람" };

		String name = f[GameController.ran.nextInt(f.length)] + s[GameController.ran.nextInt(s.length)]
				+ l[GameController.ran.nextInt(l.length)];
		int hp = GameController.ran.nextInt(50) + 100;
		int att = GameController.ran.nextInt(5) + 5;
		int def = GameController.ran.nextInt(5);

		list.add(new Unit(name, hp, 0, att, def));
	}

	
	
}
