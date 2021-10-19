package poly;

public class Archer extends Unit {

	public Archer(String name, int maxhp, int maxmp, int att) {
		super(name, maxhp, maxmp, att);
	}

	@Override
	public void skill(Unit target) {
		// TODO Auto-generated method stub
		System.out.println("[궁수스킬 발동] 적 한명에게 공격력 X2");
		int dmg = att * 2;
		target.curhp -= dmg;
		System.out.printf("[%s] [공격력 : %d] -> [%s] [HP : %d]\n", this.name, dmg, target.name, target.curhp);
	}

}
