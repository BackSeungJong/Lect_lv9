package main;

import java.util.ArrayList;

import unit.Hero;
import unit.Unit;

public class Game {
	// Singleton
	private static Game instance = new Game();

	private Game() {
	}

	public static Game getInstance() {
		return instance;
	}

	// 유닛(히어로, 좀비, 좀비킹)
	private Hero Player;
	private ArrayList<Unit> enemy = new ArrayList<>();
}
