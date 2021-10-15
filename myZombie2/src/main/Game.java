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
		
	}

	public void run() {
		// TODO Auto-generated method stub
		init();
	}
}
