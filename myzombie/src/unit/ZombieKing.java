package unit;

public class ZombieKing extends Unit {
	int shield;

	public ZombieKing(String name, int hp, int att, int def, int pos, int cri, int shield) {
		super(name, hp, att, def, pos, cri);
		this.shield = shield;
		// TODO Auto-generated constructor stub
	}

	public int getshield() {
		return this.shield;
	}

	public void setshield(int shield) {
		this.shield = shield;
	}

	@Override
	public void print() {
		System.out.printf("[이름] %s [체력] %d(+%d)\n", getname(), gethp(), getshield());
		System.out.printf("[공격력] %d [방어력] %d\n", getatt(), getdef());
	}

}
