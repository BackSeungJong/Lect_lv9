package main;

import java.util.ArrayList;

import unit.Unit;

public class Game {

	// Singleton
	private static Game instance = new Game();

	private Game() {
	}

	public static Game getinstance() {
		return instance;
	}

	//
	//
	private ArrayList<Unit> enemy = new ArrayList<>();

	private void init() {
		Unit player = new Unit("PLAYER", 100, 10, 5, 3, 1);
		enemy.add(new Unit("초라한좀비", 50, 5, 3, 0, 2));
		enemy.add(new Unit("일반좀비", 100, 10, 5, 1, 3));
		enemy.add(new Unit("동네좀비", 180, 5, 3, 0, 5));
		enemy.add(new Unit("고급좀비", 50, 5, 3, 0, 8));
		enemy.add(new Unit("좀비킹오른팔", 50, 5, 3, 0, 10));
		enemy.add(new Unit("좀비킹", 500, 5, 3, 0, 12));
	}

	public void run() {
		// TODO Auto-generated method stub
		init();
	}
}
