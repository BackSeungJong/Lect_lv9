package poly;

public class Warrior extends Unit {

	public Warrior(String name, int maxhp, int maxmp, int att) {
		super(name, maxhp, maxmp, att);
	}

	@Override
	public void skill(Unit target) {
		// TODO Auto-generated method stub
		System.out.println("적 전체 공격");
	}
}
