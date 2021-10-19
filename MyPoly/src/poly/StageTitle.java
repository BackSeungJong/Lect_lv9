package poly;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("=====[Green RPG]=====");
		System.out.println("1. 게임 시작");
		System.out.println("0. 종료");
		int sel = GameManager.sc.nextInt();

		if (sel == 1) {
			GameManager.nextStage = "LOBBY";
		}
		return false;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
