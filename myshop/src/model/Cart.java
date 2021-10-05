package model;

public class Cart {
	private String userId; // 구입한 유저 id
	private Item item; // 구입한 아이템

	public Cart(String userId, Item item) {
		this.userId = userId;
		this.item = item;
	}

	public String getuserId() {
		return this.userId;
	}

	public String itemname() {
		return this.item.getname();
	}

	public int itemprice() {
		return this.item.getprice();
	}
//	public void print() {
//		System.out.println("[" + userId + "]" + "아이템 : " + itemName);
//	}
}
