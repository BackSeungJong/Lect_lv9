package poly;

public class Archer extends Unit {

	public Archer(String name, int maxhp, int maxmp, int att) {
		super(name, maxhp, maxmp, att);
	}

	@Override
	public void skill(Unit target) {
		// TODO Auto-generated method stub
		System.out.println("적 한명 공격력 0");
	}

}
