package unit;

public class ZombieKing extends Unit {
	private int shield;

	public ZombieKing(String name, int HP, int att, int def, int cri, int shield, int pos) {
		super(name, HP, att, def, cri, pos);
		// TODO Auto-generated constructor stub
		this.shield = shield;
	}

}
