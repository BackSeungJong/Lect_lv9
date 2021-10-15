package unit;

import java.util.Random;

public class Hero extends Unit {

	private int medicine = 3;

	public Hero(String name, int hp, int att, int def, int pos, int cri) {
		super(name, hp, att, def, pos, cri);
		// TODO Auto-generated constructor stub
	}

	public int getmedicine() {
		return this.medicine;
	}

	public void drink() {
		if (medicine > 0) {
			System.out.println("회복약을 마신다.");
			System.out.println("체력 100회복.");
			if (this.gethp() + 100 > this.getHP())
				this.sethp(this.getHP());
			else {
				this.sethp(this.gethp() + 100);
			}
			medicine--;
		} else {
			System.out.println("회복약이 없습니다.");
		}
	}

	@Override
	public void attack(Unit target) {
		if (target instanceof ZombieKing) {
			if (((ZombieKing) target).shield > 0) {
				int dam = (this.getatt() - target.getdef()) * (ran.nextInt(150) + 50) / 100;
				if (dam <= 0) {
					dam = 1;
				}
				System.out.println(getname() + "의 공격!");
				System.out.println(dam + "의 대미지!");
				((ZombieKing) target).setshield(((ZombieKing) target).getshield() - dam);
				if (((ZombieKing) target).getshield() <= 0) {
					System.out.println(target.getname() + "의 쉴드가 박살났다!");
					((ZombieKing) target).setshield(0);
				}
				System.out.println(target.getname() + "의 남은 체력 : " + target.gethp() + " (쉴드 : "
						+ ((ZombieKing) target).getshield() + ")");
			} else {
				super.attack(target);
			}
		} else {
			super.attack(target);
		}
	}

	// 아이템 떨구기
	public void dropReward(Zombie unit) {
		// upcasting
		// Unit unit = (Unit) dr;
		Random ran = new Random();
		int rnum = ran.nextInt(4);

		if (rnum == 0) {
			if (medicine < 3) {
				medicine++;
				System.out.println("포션을 획득했습니다.\n");
			} else {
				System.out.println("포션수량이 가득차 더이상 획득할 수 없습니다.\n");
			}
		} else if (rnum == 1) {
			setHP(getHP() + unit.getHP());
			sethp(getHP());
			System.out.println("체력 30 증가!\n");
		} else if (rnum == 2) {
			setatt(getatt() + unit.getatt());
			System.out.printf("공격력 %d 증가!\n", unit.getatt());
		} else if (rnum == 3) {
			setdef(getdef() + unit.getdef());
			System.out.printf("방어력 %d 증가!\n", unit.getdef());
		}

	}

}
