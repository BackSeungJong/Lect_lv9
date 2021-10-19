package poly;

public class Magician extends Unit {

	public Magician(String name, int maxhp, int maxmp, int att) {
		super(name, maxhp, maxmp, att);
	}

	@Override
	public void skill(Unit target) {
		// TODO Auto-generated method stub
		System.out.println("[마법사스킬 발동] 아군 한명 체력50 회복");
		System.out.printf("[%s] [HP : %d(+%d)]\n", target.name, target.curhp, 50);
		if (target.curhp + 50 >= target.Maxhp) {
			target.curhp = target.Maxhp;
		} else {
			target.curhp += 50;
		}
	}

}
