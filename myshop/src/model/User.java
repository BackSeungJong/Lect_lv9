package model;

public class User {
	private String id;
	private int money;// 내야할 돈

	public User(String id) {
		this.id = id;
		this.money = 0;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public int getmoney() {
		return this.money;
	}

	public void setmoney(int money) {
		this.money = money;
	}
}
